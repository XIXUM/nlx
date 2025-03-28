/**
 * Link Processor Class. Queries Database for Link rules or creates new rules
 * (c) 2025 XIXUM.ORG and sub brands
 * 
 * Licensed under the Eclipse License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * www.xixum.org
 * @author Felix Schaller
 */

package org.xixum.nlx.view.fxviews.semantics

import org.xixum.nlx.ai.neo4j.Neo4jAccess.Action
import org.xixum.nlx.ai.util.Arrow
import org.xixum.nlx.ai.util.NodeUtil
import org.xixum.nlx.constants.Direction
import org.xixum.nlx.dictionary.IDictionaryAccess
import org.xixum.nlx.dictionary.type.ITypeAttributes
import org.xixum.nlx.view.fxviews.access.elements.ContainerItem
import org.xixum.nlx.view.fxviews.access.elements.KommaItem
import org.xixum.nlx.view.fxviews.access.elements.SeparatorItem
import org.xixum.nlx.view.fxviews.access.elements.SmallItem
import org.xixum.nlx.view.fxviews.cache.CachedDeadLink
import org.xixum.nlx.view.fxviews.cache.CachedLink
import org.xixum.nlx.view.fxviews.cache.CachedNode
import org.xixum.nlx.view.fxviews.cache.ICacheObj
import org.xixum.nlx.view.fxviews.cache.INodeCacheManager
import org.xixum.nlx.view.fxviews.semantics.types.ICardinalLinkable
import org.xixum.nlx.view.fxviews.semantics.util.LinkUtils
import org.xixum.nlx.view.fxviews.visual.IPanel
import org.xixum.nlxpresets.NlxDictConstants
import org.xixum.utils.data.types.XPair
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.Set
import java.util.stream.Collectors
import org.neo4j.driver.v1.Record
import org.neo4j.driver.v1.types.Node
import static org.xixum.nlx.constants.Neo4jConstants.*
import static org.xixum.nlx.dictionary.constants.DictionaryConstants._EXCLUDES
import static org.xixum.nlx.dictionary.constants.DictionaryConstants._REDUNDANCE
import static org.xixum.nlx.dictionary.constants.DictionaryConstants._REDUNDANT
import static org.xixum.nlx.dictionary.constants.NodeConstants.GRAMMAR_CLUSTER_
import static org.xixum.nlx.dictionary.constants.NodeConstants.GRAMMAR_LINK_
import static org.xixum.nlx.dictionary.constants.NodeConstants._OF_CLASS
import static org.xixum.nlx.dictionary.constants.NodeConstants._TYPE
import static org.xixum.nlx.dictionary.constants.NodeConstants._WORD
import static org.xixum.nlx.dictionary.constants.NodeConstants._WORD_CLASS
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants.*
import static org.xixum.nlx.dictionary.constants.DictionaryConstants._FORWARD
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict

/**
 * LinkProcessor solves the the semantics in the panelChain. it communicates with the database 
 * to resolve sentence structure or trains new patterns.
 * 
 * TODO: currently an functional approach. Consider to implement these functionalities & behavior inside the panel nodes itself.
 *   
 */
class LinkProcessor {
	protected val String[] wordDefault = #["None"]
	protected val String[] allGrammarAttrs = #[_MID, _IN_BOX, _OUT_BOX]
	protected val String[] wordTArray = wordDefault + NlxDictConstants.getAllTypes() // TODO: replace by getAllTypesWNone
	protected val List<String> wordTypes = wordTArray
	protected IDictionaryAccess dictAccess
	protected SemanticLinker semanticLinker
	protected INodeCacheManager cacheManager
	boolean useCache = false

	// cache turned off
	new(IDictionaryAccess dictAccess, SemanticLinker linker, INodeCacheManager manager) {
		this.dictAccess = dictAccess
		semanticLinker = linker
		cacheManager = manager
	}

	/**
	 * resolves the Grammar tree for the sentence 
	 */
	def List<XPair<ILinkable, Boolean>> evaluateNext(ILinkable source) {
		// TODO: 03.06.2022 Test why evaluateNext returns semantic Links with same ID twice
		var attributes = newHashMap
		var boolean resolved = false;
		var Set<XPair<ILinkable, Boolean>> destinations = null;
		var internalSource = source
		if (dictAccess.dbAccessor === null) // no database
			return null
		if (internalSource instanceof ILinkObj) {
			while (internalSource.token instanceof SmallItem) {
				if (internalSource.successor !== null)
					internalSource = internalSource.successor as ILinkObj
				else // TODO: should not be neccesary:
					return #[new XPair(null, resolved)] // EOL
			}
		}
		var successor = LinkUtils.findNextAdjacentPanel(internalSource, true).successor
		if (successor !== null) { // find out if successor is part of higher order??
		// TDOD: solve Hierarchy of grammar links like bracket sentence shall go for higher order links first 
			var ILinkObj internalSuccessor = successor as ILinkObj
			while (internalSuccessor.token instanceof SmallItem) {
				var token = (internalSuccessor as ILinkObj).token
				switch token {
					KommaItem | SeparatorItem: {
						if (!attributes.containsKey(_MID)) {
							attributes.put(_MID, new Intermediate(token.internalType, token.element))
						}
					}
					default: { // full stop or end bracket
						if (internalSource instanceof ILink)
							return #[new XPair(internalSource, true)] // precessors have links
						else
							return #[new XPair(internalSource, false)] // no links
					}
				}
				if (internalSuccessor.successor !== null)
					internalSuccessor = internalSuccessor.successor as ILinkObj
				else // TODO: should be not necessary 
					return #[new XPair(null, resolved)] // EOL
			}
			if (destinations === null)
				destinations = newHashSet
			var types = internalSuccessor.links
			var List<ILink> links = null
			if (types !== null) {
				links = types.values.stream().flatMap(x|x.stream()).collect(Collectors.toList());
			}
			if (links !== null && !links.empty) { // successor has already links
			// links.forEach[k,v | v.forall[l| LinkUtils.traceRoot(l as ILinkable)]]
				for (root : LinkUtils.traceAllRoots(internalSuccessor as ILinkable, 0, false)) {
					var overlap = LinkUtils.findNextAdjacentPanel(root.value, false)
					var rLinkable = root.value
					var rlinks = rLinkable.link
					if (overlap.index >= internalSuccessor.index) // TODO: 14.03.22 recurse up as long links overlap
						if (rlinks == null || rlinks.empty){
							destinations.addAllExcl(evaluateNext(rLinkable))
						} else {
							destinations.addExcl(new XPair<ILinkable, Boolean>(rLinkable, false))
						}
				}
			} else
				destinations.addAllExcl(evaluateNext(internalSuccessor as ILinkable))
			var found = false
			for (dest : destinations)
				if (dest.key.equals(internalSuccessor))
					found = true
			if (!found)
				destinations.addExcl(new XPair(internalSuccessor, false)) // use node or link to other as solution
		} else
			return #[new XPair(internalSource, true)]
		if (destinations !== null && !destinations.empty) {
			var List<XPair<ILinkable, Boolean>> results = newArrayList()
			for (dest : destinations) {
				var result = findLink(internalSource, dest.key, attributes)
				if (result !== null)
					results.addAll(result)
			}
			if (results !== null && !results.empty) return results // found higher priority rule	
		}
		#[new XPair(internalSource, false)]
	}

	/**
	 * Extension Method, avoid double subentries in Set 
	 */
	def void addExcl(Set<XPair<ILinkable, Boolean>> set, XPair<ILinkable, Boolean> pair) {
		var found = false;
		for (el : set) {
			if (el.key == pair.key)
				found = true
		}
		if (!found)
			set.add(pair);
	}

	/**
	 * Extension Method, avoid double subentries in Set from List
	 */
	def void addAllExcl(Set<XPair<ILinkable, Boolean>> set, List<XPair<ILinkable, Boolean>> pairs) {
		for (pair : pairs) {
			set.addExcl(pair)
		}
	}

	/**
	 * make postprocess
	 */
	def postProcess(ILinkObj linkable,  ImplicitRulesOnDict grammar) {
		var successor = linkable.successor as ILinkObj
		// TODO: 09.08.21 only postprocess if word has no attributes (followed by)
		if (linkable.getTypes !== null && !linkable.getTypes.empty) {
			var token = linkable.token 
			if (token !== null) {
				
				try {
						token.postProcess(grammar)
				} catch (Exception e) {
					e.printStackTrace
				}
			}
		}
	}

	def List<XPair<ILinkable, Boolean>> findLink(ILinkable first, ILinkable second, HashMap<String, Intermediate> attributes) {
		var c_Result = if (useCache) findInCache(first, second, attributes) else #[]
		if (!c_Result.isEmpty) {
			var records = newArrayList()
			for (entry : c_Result)
				records.add(entry.record)
			return recordToLink(records, first, second, attributes, _LINK)
		} else {
			var firstQ = generateQuery(first, _SOURCE, null, true)
			var secondQ = generateQuery(second, _TARGET, null, false)
			if (firstQ === null || secondQ === null)
				return null
			if (firstQ.value !== null) attributes.put(_OUT_BOX, firstQ.value)
			if (secondQ.value !== null) attributes.put(_IN_BOX, secondQ.value)
			var nonAttr = newArrayList(allGrammarAttrs)
			nonAttr.removeAll(attributes.keySet)
			var attrs = generateLinkType(attributes)
			var query = '''«firstQ.key»
«secondQ.key»
MATCH («_SOURCE»)-[:«GRAMMAR_LINK_» {«_TYPE»:"«_FIRST»"}]-(«_LINK»:«GRAMMAR_CLUSTER_»«IF (attrs !== null && attrs.length > 0)
			» {«attrs»}«ENDIF»)-[:«GRAMMAR_LINK_» {«_TYPE»:"«_SECOND»"}]-(«_TARGET») WHERE NOT («FOR attr : nonAttr SEPARATOR ' OR '»exists(«_LINK».«attr»)«ENDFOR»)
CALL apoc.when(«_SOURCE»<>«_TARGET», 
 "MATCH («_LINK») WHERE NOT ((«_LINK»)<-[:«GRAMMAR_LINK_»  {«_TYPE»:'«_FIRST»'}]-(«_TARGET»)) RETURN «_LINK»", "MATCH («_LINK») RETURN «_LINK»", {«_LINK»:«_LINK», «_TARGET»:«_TARGET», «_SOURCE»:«_SOURCE»}) YIELD «_VALUE»
WITH «_VALUE».«_LINK» AS «_LINK», «_SOURCE» AS «_SOURCE», «_TARGET» AS «_TARGET»
OPTIONAL MATCH («_SOURCE»)-[«_START»:«_FORWARD»]->(«_LINK»)
OPTIONAL MATCH («_TARGET»)-[«_END»:«_FORWARD»]->(«_LINK»)
OPTIONAL MATCH «_P» = («_LINK»)«new Arrow(_E,_EXCLUDES,null,null,null,true,true, Direction.RIGHT).generate»(«_A»)
OPTIONAL MATCH («_A»)«new Arrow(null,null,Direction.RIGHT).generate»(«_R»:«_REDUNDANCE»)
OPTIONAL MATCH («_A»)«new Arrow(_L, null, Direction.RIGHT).generate»(«_B») WHERE NOT (type(«_L») = "«_EXCLUDES»" OR type(«_L») = "«_REDUNDANT»")
RETURN «_SOURCE», «_LINK», «_TARGET», «_A», «_P», «_R», COLLECT ({«_LK»:{«_LI»: ID(«_L»), «_LL»:type(«_L»), «_LA»:«_L»}, «_ND»:{«_NI»: ID(«_B»), «_NL»:labels(«_B»), «_NA»: «_B»}}) as «_ATTR», «_START», «_END»'''
			var List<Record> result = dictAccess.dbAccessor.runCodeRecords(query, Action.READ)
			if (useCache) addToCache(result, first, second, attrs)
			return recordToLink(result, first, second, attributes, _LINK)
		}
	}

	protected def extractFromRec(List<Record> records, String varName, boolean not_empty, ILinkable token) {
		var typelabel = ""
		var Node node = null
		var nodes = newArrayList()
		if (not_empty) {
			for (rec : records) {
				node = rec.get(varName).asNode()
				typelabel = node.get(_NAME).asString
				nodes.add(cacheManager.addNode(typelabel, node.labels.get(0), rec, varName))
			}
			return nodes
		} else {
			return nodeToTypes(token, false)
		}
	}

	protected def nodeToTypes(ILinkable node, boolean useCache) {
		var result = newArrayList()
		var types = node.types
		if (types === null)
			return result
		if (useCache)
			for (type : types) { // TODO: add container detection
				var cachedT = cacheManager.getNodeByName(type.key)
				if (cachedT !== null)
					result.add(cachedT)
			}
		else
			for (typelabel : types) { // TODO: add container detection
				result.add(cacheManager.addNode(typelabel.key, "", null, ""))
			}
		result
	}

	protected def addToCache(List<Record> records, ILinkable first, ILinkable second, String attrs) {
		var not_empty = records !== null && !records.isEmpty
		var firstNodes = extractFromRec(records, _SOURCE, not_empty, first)
		var secondNodes = extractFromRec(records, _TARGET, not_empty, second)
		for (firstNode : firstNodes) {
			for (secondNode : secondNodes) {
				var ICacheObj link = null
				if (not_empty) {
					for (rec : records) {
						link = new CachedLink(firstNode, secondNode, attrs, rec, _LINK)
						firstNode.outLink = link
						secondNode.inLink = link
					}
				} else {
					link = new CachedDeadLink(firstNode, secondNode)
					firstNode.outLink = link
					secondNode.inLink = link
				}
			}
		}
	}

	protected def findInCache(ILinkable first, ILinkable second, HashMap<String, Intermediate> attributes) {
		var firstNodes = nodeToTypes(first, true)
		var secondNodes = nodeToTypes(second, true)
		addGrammarAttrib(first, _OUT_BOX, attributes)
		addGrammarAttrib(second, _IN_BOX, attributes)
		var attrs = generateLinkType(attributes)
		var result = newArrayList()
		if (!(firstNodes.isEmpty || secondNodes.isEmpty)) {
			for (firstNode : firstNodes)
				for (secondNode : secondNodes) {
					var link = (firstNode as CachedNode).hasLinkTo(secondNode, attrs)
					if (link !== null)
						result.add(link)
				}
		}
		return result
	}

	def addGrammarAttrib(ILinkable linkable, String channel, HashMap<String, Intermediate> map) {
		if (linkable instanceof ILinkContainer)
			map.put(channel, new Intermediate(linkable))
	}

	protected def removeFromCache(ILinkable first, ILinkable second) {
		var firstNodes = nodeToTypes(first, true)
		var secondNodes = nodeToTypes(second, true)
		if (!(firstNodes.isEmpty || secondNodes.isEmpty)) {
			for (firstNode : firstNodes)
				for (secondNode : secondNodes) {
					(firstNode as CachedNode).removeLinkTo(secondNode)
				}
		}
	}

	def List<XPair<ILinkable, Boolean>> createLink(ILinkable first, ILinkable second, Intermediate intermediate) {
		if (useCache) removeFromCache(first, second)
		
		val types = #{_FIRST -> LinkUtils.getLinkHigherType(first).key, _SECOND -> LinkUtils.getLinkHigherType(second).key} //type names
		val typeIDs = #{_FIRST -> first.type.value.baseNode.id, _SECOND -> second.type.value.baseNode.id} // type id's
		val Pair<CharSequence, Intermediate> firstQ = generateQuery(first, _SOURCE, types.get(_FIRST), true)
		val Pair<CharSequence, Intermediate> secondQ = generateQuery(second, _TARGET, types.get(_SECOND), false)
		if (firstQ === null || secondQ === null)
			return null
		// TODO: assign Grammar Node to Subclass
		val attributes = newHashMap
		if (intermediate !== null) attributes.put(_MID, intermediate)
		if (firstQ.value !== null) attributes.put(_OUT_BOX, firstQ.value)
		if (secondQ.value !== null) attributes.put(_IN_BOX, secondQ.value)
		val attrs = generateLinkType(attributes)
		val nonAttr = newArrayList(allGrammarAttrs)
		nonAttr.removeAll(attributes.keySet)
		val additionalQuery = '''MATCH («_S»)-[«_L1»:«GRAMMAR_LINK_» {«_TYPE»:"«_FIRST»"}]->(«_NODE»)<-[«_L2»:«GRAMMAR_LINK_» {«_TYPE»:"«_SECOND»"}]-(«_T») WHERE (ID(«_S») =«typeIDs.get(_FIRST)» AND ID(«_T»)=«typeIDs.get(_SECOND)»)'''
		val node = grammarExistOrCreate('''«IF first instanceof ILink
				»(«types.get(_FIRST)»)«ELSE»«types.get(_FIRST)»«ENDIF»«ARROW_»«IF second instanceof ILink
				»(«types.get(_SECOND)»)«ELSE»«types.get(_SECOND)»«ENDIF»''', attrs, _NODE, nonAttr, additionalQuery, true)
		if (node === null)
			return null
		// TODO: replace with code generator
		var query = '''«firstQ.key»
«secondQ.key»
MATCH («_LINK»:«GRAMMAR_CLUSTER_») WHERE ID(«_LINK») = «node.id»
MERGE («_SOURCE»)-[:«GRAMMAR_LINK_» {«_TYPE»:"«FIRST_»"}]->(«_LINK»)<-[:«GRAMMAR_LINK_» {«_TYPE»:"«SECOND_»"}]-(«_TARGET»)
RETURN «_SOURCE», «_TARGET», «_LINK»'''
		var result = dictAccess.dbAccessor.runCodeRecords(query, Action.WRITE)
		if (useCache) addToCache(result, first, second, attrs)
		return recordToLink(result, first, second, attributes, _LINK)
	}

	protected def generateLinkType(HashMap<String, Intermediate> map) {
		// var attrs = #[_MID, _IN_BOX, _OUT_BOX]
		var sequence = ''''''
		if (!map.empty) {
			var first = true
			for (attr : map.keySet) {
				var result = map.get(attr).generate(attr)
				if (result !== null) {
					if (!first) {
						sequence += ", "
					}
					sequence += result
					first = false
				}
			}
		}
		return sequence
	}

	protected def recordToLink(List<Record> records, ILinkable first, ILinkable second, Map<? extends String, ? extends Object> intermediate, String varName) {
		var List<XPair<ILinkable, Boolean>> result
		if (records !== null && !records.isEmpty) {
			if (records.get(0) === null)
				return null
			var recMap = new HashMap<Long, List<Record>>();
			for (rec : records) {
				var link = rec.get(_LINK).asNode()
				if (link !== null) {
					var map = recMap.get(link.id)
					if (map === null) {
						map = newArrayList()
						recMap.put(link.id, map)
					}
					map.add(rec)
				}
			}
			for (id : recMap.keySet) {
				semanticLinker.makeLink(first, second, intermediate, recMap.get(id));
				val List<ILink> allLinks = newArrayList 
				switch(first){
					ILinkObj:{
						first.links.values.forEach[e | allLinks.addAll(e)]  //TODO: 05.12.22 this may be the reason of redundancy. only ONE type is required here
					}
					ILink:{
						allLinks.addAll(first.links)
					}
				}
				for (link : allLinks) {
					if (result === null)
						result = newArrayList
					var value = evaluateNext(link) // and resolve higher below
					if (value !== null && !value.empty) {
						result.addAll(value)
					}
					var selfLink = new XPair(link as ILinkable, false)
					if (!result.map[e|e.key].contains(selfLink.key)) // double check. should not be necessary on sets
						result.add(selfLink) // add current
				}
			}
		}
		return result
	}

	protected def Pair<CharSequence, Intermediate> generateQuery(ILinkable linkable, String varName, String type, boolean allowCardinal) {
		switch (linkable) {
			ILinkContainer: {
				var inner = linkable.allInnerLinks ?: #[]
				if (inner !== null && !inner.empty) {
					var innerFirst = inner.get(0)
					createSentenceQuery(linkable, varName)
				} else if (linkable.length(false) == 1) {
					createSentenceQuery(linkable, varName)
				} else
					null
			}
			IPanel: {
				new Pair<CharSequence, Intermediate>('''MATCH (:«_WORD» {«_NAME»:"«linkable.token.name.toLowerCase»"})-[:«_OF_CLASS»]->(«varName»«IF (type !== null && type.length > 0)»: «_WORD_CLASS» {«_NAME»:"«type»"}«ENDIF»)''',
					null)
			}
			ILink: {
				if (linkable.hasCardinalType && allowCardinal) {
					return generateQuery(linkable.cardinalType, varName, null, allowCardinal)
				}
				new Pair<CharSequence, Intermediate>('''MATCH («varName»:«GRAMMAR_CLUSTER_») WHERE ID(«varName») = «((linkable as ILink).linkInfo.getRecord(_LINK) as Node).id»''', null)
			}
			ICardinalLinkable: {
				// new Pair<CharSequence, Intermediate>('''MATCH («varName»: «_WORD_CLASS» {«_NAME»:"«linkable.baseType.name»"})''', null)
				generateQuery(linkable.baseType, varName, null, allowCardinal) // TODO: 17.03.22 Should look for WordClass instead of Word. But works anyway provisionally 
			}
			default: {
				null
			}
		}
	}

	def createSentenceQuery(ILinkContainer linkable, String varName) {
		var Node family = NodeUtil.nodeExistOrCreate(dictAccess.dbAccessor, '''«varName»:«PARAGRAPH_»{«_NAME»:"«PLAIN_»"}''', varName, #[], false)
		var Node node = NodeUtil.nodeExistOrCreate(dictAccess.dbAccessor, '''«varName»:«SENTENCE_CLASS_»{«_NAME»:"«linkable.linkType.name»"}''', varName, #[], false)
		NodeUtil.connectionExistOrCreate(dictAccess.dbAccessor, family, new Arrow(_LINK, _OF_CLASS, Direction.LEFT), node)
		new Pair<CharSequence, Intermediate>('''MATCH («varName»:«SENTENCE_CLASS_») WHERE ID(«varName») = «node.id»''', new Intermediate(linkable))
	}

	protected def Node grammarExistOrCreate(String nodeName, String attrs, String varName, List<String> exclude, String optionalQuery, boolean fail) {
		var subQuery = '''«varName»:«GRAMMAR_CLUSTER_» {«_NAME»:"«nodeName»" «IF (attrs!== null && attrs.length > 0)», «attrs»«ENDIF»}''' 
		NodeUtil.nodeExistOrCreate(dictAccess.dbAccessor, subQuery, varName, exclude, optionalQuery, fail);
	}
}
