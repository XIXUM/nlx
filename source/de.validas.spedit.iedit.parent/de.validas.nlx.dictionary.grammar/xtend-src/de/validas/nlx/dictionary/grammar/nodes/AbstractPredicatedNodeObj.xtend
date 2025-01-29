package de.validas.nlx.dictionary.grammar.nodes

import static de.validas.nlx.dictionary.constants.PredicateConstants.GET_NAME_
import static de.validas.nlx.constants.Neo4jConstants._ATTR_NAME

import de.validas.nlx.dictionary.grammar.nodes.AbstractDictRuleObj
import org.neo4j.driver.v1.types.Node
import de.validas.nlx.ai.IParserDriver
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateGET_NAME
import de.validas.nlx.ai.semantics.INode
import org.neo4j.driver.v1.types.Relationship

abstract class AbstractPredicatedNodeObj extends AbstractDictRuleObj implements IPredicateGET_NAME{
	
	new(Node node, IParserDriver driver) {
		super(node, driver)
	}
	
	override getName(INode caller, Relationship relation){
		caller.setAttribute(GET_NAME_, getAttribute(_ATTR_NAME))
		null
	}
	
}