package org.xixum.nlx.dictionary.grammar.nodes.interfaces

import org.xixum.nlx.ai.semantics.INode

interface IPredicateTARGET {
	def INode target(INode caller)
}