package de.validas.nlx.dictionary.grammar.nodes

import de.validas.nlx.ai.IParserDriver
import org.neo4j.driver.v1.types.Node

class ErrorNode extends AbstractDictRuleObj {
	
	String message
	
	new(Node node, IParserDriver driver) {
		this(node, driver, "")
	}
	
	new(Node node, IParserDriver driver, String message) {
		super(node, driver)
		this.message = message
	}
	
	override solve() {
		null
	}
	
	def getMessage() {
		message
	}
	
}
