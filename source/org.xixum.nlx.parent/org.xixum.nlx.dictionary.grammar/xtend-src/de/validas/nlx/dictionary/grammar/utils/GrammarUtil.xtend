package de.validas.nlx.dictionary.grammar.utils

import static de.validas.nlx.dictionary.constants.NodeConstants._WORD
import static de.validas.nlx.dictionary.constants.DictionaryConstants._POSITION
import static de.validas.nlx.constants.Neo4jConstants._NAME
import static de.validas.nlx.constants.Neo4jConstants._OF_CLASS
import static de.validas.nlx.constants.Neo4jConstants._CLASS
import static de.validas.nlx.dictionary.constants.DictionaryConstants._WORD_TYPE
import static de.validas.nlx.constants.Neo4jConstants._TOKEN
import static de.validas.nlx.constants.Neo4jConstants._P
import static de.validas.nlx.constants.Neo4jConstants._N
import static de.validas.nlx.constants.Neo4jConstants._T
import static de.validas.nlx.constants.Neo4jConstants._L


import org.eclipse.xtext.xbase.lib.Functions.Function1
import de.validas.nlx.ai.semantics.INode
import java.util.List
import org.neo4j.driver.v1.types.Node
import de.validas.nlx.constants.Direction
import de.validas.nlx.dictionary.grammar.token.IGrammarItem
import de.validas.nlx.dictionary.grammar.nodes.TerminalNode
import de.validas.nlx.dictionary.grammar.nodes.ClassNode
import de.validas.nlx.ai.util.Arrow
import org.neo4j.driver.v1.Record
import de.validas.nlx.ai.util.NodeUtil
import de.validas.nlx.ai.neo4j.Neo4jAccess.Action
import de.validas.nlx.ai.IParserDriver
import org.neo4j.driver.v1.types.Path

class GrammarUtil {
	
	
	def static INode findWord(INode nodeClass, String name) {
		val id = nodeClass.ID
		var children = nodeClass.children
		if (!children.containsKey(id))
			children.put(id, newHashMap)
		val descendants = children.get(id)
		if (!descendants.containsKey(name)) {
			var Function1<Object, List<Node>> delegate = [ e |
				if (e instanceof String)
					nodeClass.findNodeTypeByName(_WORD, e)
			]
			var INode result = nodeClass.findNodeAndCreateTarget(name, delegate)
			if (result instanceof INode) {
				descendants.put(name, result)
				return result
			}
		} else
			return descendants.get(name)
		null
	}

	def static INode findTarget(INode nodeClass, String name) {
		// TODO:  generalize this method with WordFragment find Fragment and delegate search
		val id = nodeClass.ID
		var children = nodeClass.children
		if (!children.containsKey(id))
			children.put(id, newHashMap)
		val descendants = children.get(id)
		if (!descendants.containsKey(name)) {
			var Function1<Object, List<Node>> delegate = [ e |
				if (e instanceof String)
					nodeClass.findLinkedNodeByName(e, _OF_CLASS, Direction.LEFT)
			]
			var INode result = nodeClass.findNodeAndCreateTarget(name, delegate)
			if (result instanceof INode) {
				descendants.put(name, result)
				return result
			}
		} else
			return descendants.get(name)
		null
	}

	def static INode findInterpunction(INode node, IGrammarItem item) {
		var current =  node.driver.getNodeById(item.baseNode)  //TODO: should behave similar to findTarget
		//var children = node.children
		switch(current){
			TerminalNode:{
				var nC = current.getAttribute(_POSITION) as Node
				var nN = node.getAttribute(_POSITION) as Node
				if (current.getAttribute(_NAME).equals(node.getAttribute(_NAME)) && nC.id === nN.id){
					return current
				} else
					null
			}
			default:{
				null
			}
		}
	}
	
	def static List<Path> findPathTo(IParserDriver driver, Node from, Node to, String type) {

		if (from == null || to == null)
			return null
		// MATCH P = (N:Class {name:"WordType"})<-[l:ofClass*]-(t:Word {name:"get"}) return *
		val query = '''MATCH «_P» = («_N»)«new Arrow(_L, type, null, null, null, true, Direction.RIGHT).generate»(«_T») WHERE ID(«_N») = «from.id» AND ID(«_T») = «to.id» 
«					  »RETURN *'''
		val List<Record> records = driver.dbAccessor.runCodeRecords(query, Action.READ)
		if (!records?.empty){
			var result = newArrayList
			for (rec : records)
				result.add(rec.get(_P).asPath)
			return result
		}
		return null

	}
	
}