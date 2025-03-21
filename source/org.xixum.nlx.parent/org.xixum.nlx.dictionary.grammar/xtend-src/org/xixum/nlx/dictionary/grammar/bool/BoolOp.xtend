<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.spedit.iedit/src/de/validas/spedit/validation/semantics/bool/BoolOp.xtend
package de.validas.spedit.validation.semantics.bool

import de.validas.nlx.ai.semantics.INode

abstract class BoolOp {
	def boolean isTrue(INode node)
	
	def INode returnFinal(INode node)
	
	def INode returnIntermediate(INode node)
}
=======
package org.xixum.nlx.dictionary.grammar.bool

import org.xixum.nlx.ai.semantics.INode

abstract class BoolOp {
	def boolean isTrue(INode node)
	
	def INode returnFinal(INode node)
	
	def INode returnIntermediate(INode node)
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary.grammar/xtend-src/de/validas/nlx/dictionary/grammar/bool/BoolOp.xtend
