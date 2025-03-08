package de.validas.nlx.dictionary.grammar.nodes.interfaces

import de.validas.nlx.ai.semantics.INode
import de.validas.nlx.dictionary.grammar.token.IGrammarItem

interface IPredicateIS {
	def INode is(INode caller) 
}