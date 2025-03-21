<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.spedit.iedit/src/de/validas/spedit/validation/semantics/nodes/BoolAndConditionNode.xtend
package de.validas.spedit.validation.semantics.nodes

import de.validas.spedit.validation.semantics.bool.BoolAnd
import java.util.List
import org.neo4j.driver.internal.value.NodeValue
import org.neo4j.driver.v1.Record
import de.validas.nlx.ai.semantics.INode
import de.validas.nlx.ai.IParserDriver

class BoolAndConditionNode extends ConditionNode {
	
	val static BoolAnd boolAnd = new BoolAnd()

	new(NodeValue node, IParserDriver driver) {
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
		
		if (result instanceof de.validas.spedit.validation.semantics.IDictNode) // type safety
			return result
		else
			return null
		
	}
}
=======
package org.xixum.nlx.dictionary.grammar.nodes

import org.xixum.nlx.ai.IParserDriver
import org.xixum.nlx.ai.semantics.INode
import org.xixum.nlx.dictionary.grammar.bool.BoolAnd
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
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary.grammar/xtend-src/de/validas/nlx/dictionary/grammar/nodes/BoolAndConditionNode.xtend
