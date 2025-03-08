package de.validas.nlx.dictionary.grammar.nodes

import static de.validas.nlx.dictionary.constants.PredicateConstants.NAME_
import static de.validas.nlx.dictionary.constants.PredicateConstants.AS_

import de.validas.nlx.ai.IParserDriver
import org.neo4j.driver.v1.types.Node
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateLINK_TO
import de.validas.nlx.ai.semantics.INode
import org.neo4j.driver.v1.types.Relationship
//import org.eclipse.xtext.xbase.lib.Functions.Function1

class TenseNode extends AbstractPredicatedNodeObj implements IDictNode, IPredicateLINK_TO {
	
	new(Node node, IParserDriver driver) {
		super(node, driver)
	}

	def String getTense() {
		var Object obj = getAttribute(NAME_)
		if(obj instanceof String) return obj
		null
	}
	
	override solve() {
		// TODO consider a wrapper function with pre and post solves
		null //has no behavior yet
	}
	
	override INode linkTo(INode caller, Relationship relation, (String)=>INode delegate)  {
		//TODO: 19.10.22 nodeEnd is unhandled, could describe the context link instanceto -> pronoun (action w.o. source and target neccesary)
		var String type = relation.get(AS_).asString().toLowerCase // TODO: null safe check
		return delegate.apply(type)
	}
	
}
