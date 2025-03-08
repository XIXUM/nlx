package de.validas.nlx.dictionary.grammar.nodes.interfaces

import de.validas.nlx.ai.semantics.INode

interface IPredicateTARGET {
	def INode target(INode caller)
}