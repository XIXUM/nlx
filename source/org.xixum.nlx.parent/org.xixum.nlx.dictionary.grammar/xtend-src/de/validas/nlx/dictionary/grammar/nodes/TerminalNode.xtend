package de.validas.nlx.dictionary.grammar.nodes

import static de.validas.nlx.constants.Neo4jConstants._TOKEN
import static de.validas.nlx.dictionary.constants.NodeConstants._TYPE

import de.validas.nlx.dictionary.grammar.nodes.AbstractDictRuleObj
import org.neo4j.driver.v1.types.Node
import de.validas.nlx.ai.IParserDriver


import static de.validas.nlx.dictionary.constants.DictionaryConstants._POSITION
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateEQUALS
import de.validas.nlx.ai.semantics.INode
import de.validas.nlx.dictionary.grammar.token.IGrammarItem

class TerminalNode extends AbstractDictRuleObj implements IDictNode, IPredicateEQUALS {
	
	Node position
	
	new(Node node, Node position,  IParserDriver driver) {
		super(node, driver)
		this.position = position
		this.setAttribute(_POSITION, position)
	}
	
	override solve() {
		return null
	}
	
	def getPosition(){
		position
	}
	
	def getType(){
		node.get(_TYPE).asString
	}
	
	override equals(INode caller) {
		val contextS = caller.getAttribute(_TOKEN) as IGrammarItem
		if (contextS === null)
			return null 
		
		val result = solve

		if (!contextS.name.equalsIgnoreCase(this.name))
			return result

		val type = contextS?.internalType?.baseType.key
		if (!type.equals(this.type))
			return result
		this	
	}
	
}