package de.validas.nlx.dictionary.grammar.factories

import org.neo4j.driver.v1.types.Node
import de.validas.nlx.ai.IParserDriver
import de.validas.nlx.dictionary.grammar.nodes.ContextNode
import de.validas.nlx.ai.IContextFactory

class ContextFactory implements IContextFactory {
	
	override create(IParserDriver driver) {
		new ContextNode(driver)
	}
	
}