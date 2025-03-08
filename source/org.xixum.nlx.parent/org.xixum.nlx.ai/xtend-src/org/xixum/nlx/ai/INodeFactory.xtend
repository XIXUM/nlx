package de.validas.nlx.ai

import de.validas.nlx.ai.semantics.INode
import org.neo4j.driver.v1.types.Node

interface INodeFactory {
	
	def INode create(Node node, IParserDriver driver)

}
