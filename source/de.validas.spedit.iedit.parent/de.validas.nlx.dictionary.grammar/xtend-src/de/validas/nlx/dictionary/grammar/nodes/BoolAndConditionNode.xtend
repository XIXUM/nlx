package de.validas.nlx.dictionary.grammar.nodes

import de.validas.nlx.ai.IParserDriver
import de.validas.nlx.ai.semantics.INode
import de.validas.nlx.dictionary.grammar.bool.BoolAnd
import java.util.List
import org.neo4j.driver.v1.Record
import org.neo4j.driver.v1.types.Node

class BoolAndConditionNode extends ConditionNode {
	
	val static BoolAnd boolAnd = new BoolAnd()

	new(Node node, IParserDriver driver) {
		super(node, driver)
	}
	
	override INode solve() {
		// TODO consider a wrapper function with pre and post solves
		
		if (predicates === null) {
			var List<Record> outs = listAllOutputs()
			createPredicates(outs)
		}
		//Temporary
		var result = doExecuteTypes(connections, boolAnd)
		
		if (result instanceof IDictNode) // type safety
			return result
		else
			return null
		
	}
	
}
