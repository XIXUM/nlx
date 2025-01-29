package de.validas.nlx.dictionary.grammar.nodes

import static de.validas.nlx.constants.Neo4jConstants._NAME
import static de.validas.nlx.constants.Neo4jConstants._TOKEN
import static de.validas.nlx.dictionary.constants.PredicateConstants.AS_

import de.validas.nlx.ai.IParserDriver
import org.neo4j.driver.v1.types.Node
import de.validas.nlx.dictionary.grammar.token.IGrammarItem
import de.validas.nlx.dictionary.grammar.token.IGrammarLiteral
import de.validas.nlx.dictionary.grammar.token.IGrammarInterpunction
import de.validas.nlx.dictionary.grammar.utils.GrammarUtil
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateIS
import de.validas.nlx.ai.semantics.INode
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateOF_CLASS
import org.neo4j.driver.v1.types.Relationship
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateLINK_TO

class WordClassToken extends AbstractPredicatedNodeObj implements IDictNode, IPredicateIS, IPredicateOF_CLASS, IPredicateLINK_TO  {

	
	IGrammarItem item
	
	new(Node node, IParserDriver driver) {
		super(node, driver)
	}

	override solve() {
		// TODO consider a wrapper function with pre and post solves
		null
	}
	
	override is(INode caller) {

		this.item = (caller.getAttribute(_TOKEN) as IGrammarItem)
		
		val type = item.internalType
		switch (type){ 
			IGrammarLiteral:{
				//only check for type if selected in context
				val selectedT = type.baseType?.key
				if (selectedT !== null && selectedT.equals(getAttribute(_NAME)))
					return GrammarUtil.findTarget(this, item.name)
				else
					return solve()	
			}
			IGrammarInterpunction:{									
				return GrammarUtil.findInterpunction(this, item)
			}
			default:{
				return solve()
			}
		} 	
	}
	
	override ofClass(INode caller, Relationship relation) {
		return this
	}
	
	override INode linkTo(INode caller, Relationship relation, (String)=>INode delegate)  {
		var String type = relation.get(AS_).asString().toLowerCase // TODO: null safe check
		return delegate.apply(type)
	}
	
	
}
