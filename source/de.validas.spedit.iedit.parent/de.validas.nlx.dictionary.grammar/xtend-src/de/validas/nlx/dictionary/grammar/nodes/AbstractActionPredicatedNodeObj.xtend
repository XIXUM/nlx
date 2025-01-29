package de.validas.nlx.dictionary.grammar.nodes

import static de.validas.nlx.dictionary.constants.PredicateConstants.WITH_

import org.neo4j.driver.v1.types.Node
import de.validas.nlx.ai.IParserDriver
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateGET
import org.neo4j.driver.v1.types.Relationship
import de.validas.nlx.ai.semantics.INode

abstract class AbstractActionPredicatedNodeObj extends AbstractPredicatedNodeObj implements IPredicateGET {
	
	new(Node node, IParserDriver driver) {
		super(node, driver)
	}
	
	override get(INode caller, Relationship relation) {
		var value = getAttribute(WITH_) as INode
		if (value !== null)
			caller.setAttribute(relation.type.toLowerCase, value)
		null //do not solve anything
	}
	
}