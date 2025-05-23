/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

package org.xixum.nlx.view.fxviews.semantics.types

import org.xixum.nlx.constants.Direction
import org.xixum.nlx.dictionary.DictItem
import org.xixum.nlx.dictionary.IDictionaryAccess
import org.xixum.nlx.dictionary.type.ITypeAttributes
import org.xixum.nlx.view.fxviews.access.IJavaFxObj
import org.xixum.nlx.dictionary.grammar.types.ItemType
import org.xixum.nlx.view.fxviews.access.elements.TerminalItem
import org.xixum.nlx.view.fxviews.control.SmallPanelObjController
import org.xixum.nlx.view.fxviews.semantics.ILinkObj
import org.xixum.nlx.view.fxviews.semantics.ILinkable
import org.xixum.nlx.view.fxviews.semantics.constants.SubClassType
import org.xixum.nlx.view.fxviews.semantics.util.AttribUtils
import org.xixum.nlx.naturalLang.BracketSentence
import org.xixum.nlx.naturalLang.ExtBracketSentence
import org.xixum.utils.data.types.XPair
import org.xixum.utils.data.util.StringUtils
import java.util.ArrayList
import java.util.List
import javafx.application.Platform
import javafx.scene.control.TitledPane
import javafx.scene.layout.VBox
import org.eclipse.emf.ecore.EObject
import org.neo4j.driver.internal.value.ListValue
import org.neo4j.driver.v1.types.Node
import org.neo4j.driver.v1.types.Relationship

import static org.xixum.nlx.dictionary.constants.NodeConstants._INTERPUNCTION
import static org.xixum.nlx.dictionary.constants.NodeConstants._TYPE
import static org.xixum.nlx.view.fxviews.semantics.constants.SubClassType.BRACKET_SENTENCE
import static org.xixum.nlx.view.fxviews.semantics.constants.SubClassType.EXT_BRACKET_SENTENCE
import static org.xixum.nlx.view.fxviews.semantics.constants.SubClassType.INTERPUNCTION
import static org.xixum.nlx.constants.Neo4jConstants._N
import static org.xixum.nlx.constants.Neo4jConstants._L
import static org.xixum.nlx.constants.Neo4jConstants._L2
import static org.xixum.nlx.constants.Neo4jConstants._LL
import static org.xixum.nlx.constants.Neo4jConstants._NAME
import static org.xixum.nlx.constants.Neo4jConstants._A
import static org.xixum.nlx.constants.Neo4jConstants._B
import static org.xixum.nlx.constants.Neo4jConstants._C
import static org.xixum.nlx.constants.Neo4jConstants._CLASS
import static org.xixum.nlx.constants.Neo4jConstants._OF_CLASS
import static org.xixum.nlx.dictionary.constants.DictionaryConstants._AT
import static org.xixum.nlx.dictionary.constants.DictionaryConstants._POSITION
import static org.xixum.nlx.dictionary.constants.DictionaryConstants._OF_TYPE
import static org.xixum.nlx.dictionary.constants.DictionaryConstants._CHAR

import org.xixum.nlx.ai.util.NodeUtil
import org.xixum.nlx.ai.neo4j.Neo4jAccess.Action
import org.xixum.nlx.ai.util.Arrow
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict
import org.xixum.nlx.dictionary.grammar.token.IGrammarInterpunction
import org.xixum.nlx.constants.TokenPosition

class InterpunctionType extends AbstractLinkType implements IGrammarInterpunction {
	
	//TODO: variate between classic interpuction and separator
	
	protected SubClassType subClass
	protected String type
	ItemType cathegory
	IDictionaryAccess dictAccess
	Node node
	ITypeAttributes attrs
	
	new(EObject el, ItemType type, IDictionaryAccess dictAccess) {
		this(el,type, null, dictAccess)
	}
	
	new(EObject el, ItemType cathegory, String separator, IDictionaryAccess dictAccess){
		this.cathegory = cathegory;
		this.name = _INTERPUNCTION
		if (separator !== null){
			val clean = separator.replaceAll("\\s", "")
			if (!clean.empty)
				this.type = clean
			else
				this.type = StringUtils.special_escape(separator)
		}
		if (el instanceof ExtBracketSentence){  //TODO: should be improved with class behavior
			subClass = EXT_BRACKET_SENTENCE;
		} else if (el instanceof BracketSentence)
			subClass = BRACKET_SENTENCE
		else
			subClass = INTERPUNCTION;
		
		this.dictAccess = dictAccess
	}
	
	override setParent(ILinkable nodePanel) {
		this._parent = nodePanel
		if (dictAccess.dbAccessor !== null){
			//node = NodeUtil.nodeExistOrCreate(dictAccess.dbAccessor, '''«_N»:«_INTERPUNCTION» {«_NAME»:"«this.cathegory»"«IF this.type!== null», «_TYPE»:"«this.type»"«ENDIF»}''', _N, #[], false)
			var query = '''MATCH(«_N»:«_INTERPUNCTION» {«_NAME»:"«this.cathegory»"«IF this.type!== null», «_TYPE»:"«this.type»"«ENDIF»})«new Arrow(_L,_AT,null).generate»(«_A»:«_POSITION» {«_NAME»:"«((_parent as ILinkObj).token as TerminalItem).position.name»"})
«			IF this.type!== null»
MATCH(«_N»)«new Arrow(_L2,_OF_TYPE,null).generate»(«_B»:«_CHAR» {«_NAME»:"«this.type»"})
«			ENDIF»
RETURN *'''
			var result = dictAccess.dbAccessor.runCodeRecords(query, Action.READ)
			node = NodeUtil.getFirstRecord(result, _N)
			if (result === null || result.empty){
				query ='''MERGE («_N»:«_INTERPUNCTION» {«_NAME»:"«this.cathegory»"«IF this.type!== null», «_TYPE»:"«this.type»"«ENDIF»})
MERGE («_A»:«_POSITION» {«_NAME»:"«((_parent as ILinkObj).token as TerminalItem).position.name»"})
MERGE («_C»:«_CLASS» {«_NAME»:"«_INTERPUNCTION»"})
MERGE («_N»)«new Arrow(_LL,_OF_CLASS,Direction.RIGHT).generate»(«_C»)
MERGE («_N»)«new Arrow(_L,_AT,Direction.RIGHT).generate»(«_A»)
«				IF this.type!== null»
MERGE («_B»:«_CHAR» {«_NAME»:"«this.type»"})
MERGE («_N»)«new Arrow(_L2,_OF_TYPE,Direction.RIGHT).generate»(«_B»)
«				ENDIF»
RETURN *'''
				println(query+"\n")
				node = NodeUtil.getFirstRecord(dictAccess.dbAccessor.runCodeRecords(query, Action.WRITE), _N)
			}		
		}
	}
		
	def getSubClass() {
		subClass
	}
	
	override getBaseType(){
		new XPair<String, ITypeAttributes>(type, null);
	}
	
	override getCathegory(){
		cathegory
	}
	
	def String generate(String attr){
		'''«attr»:"«cathegory»"«IF (type !==null)», «attr»Type:"«type»"«ENDIF»'''
	}
	
	def update() {
		if (dictAccess.connected){
			var info = dictAccess.getLinkTypes(cathegory.toString, _INTERPUNCTION, true)
			if (info !== null)
			for (typ: info.types){
				if (typ.key.equals(cathegory.toString))
					createAttributes(typ.value) //TODO: 04.04.22: alternatively get from entrySet with index
				if (attrs === null)
					attrs = typ.value
				else
					attrs.merge(typ.value)
			}
		}
	}
	
	override getNode(){
		node
	}
	
	override postProcess(ILinkObj precessor, List<ITypeAttributes> attribs, ImplicitRulesOnDict grammar) {
		var token = (parent as ILinkObj).token
		
		if (type!== null){			// check links per type - not globally
			if (precessor!== null){
				var intAttribs = new ArrayList<ITypeAttributes>(attribs)
				intAttribs.add(attrs)
				var pT = precessor.token
				if (pT.internalType?.typeInfo === null)
					return
				var pos = (token as TerminalItem).getPosition()
				switch (pos){
					case TokenPosition.INTERMEDIATE:	{
						dictAccess.addSuccessor(pT.generateTokenInfo, new DictItem(cathegory.name, name, if (node !== null) node.id else -1), #{cathegory.name}, intAttribs)  //TODO: 10.05.22 null-safe should be obsolete here...
					}
					case TokenPosition.START,
					case TokenPosition.END:{
						dictAccess.addSuccessor(pT.generateTokenInfo, new DictItem(pos.toString(), name, node.id), #{cathegory.name}, intAttribs)			
					}
					
				}
				//updateTypes(dictAccess.getLinkTypes(token.name, _WORD, true))
			}
		
		}



	}
	
	
}

