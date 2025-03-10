<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.spedit.iedit/src/de/validas/spedit/validation/semantics/bool/BoolAnd.xtend
package de.validas.spedit.validation.semantics.bool

import de.validas.spedit.validation.semantics.bool.BoolOp
import de.validas.nlx.ai.semantics.INode

class BoolAnd extends BoolOp {
	
	override isTrue(INode node) {
		return node === null
	}
	
	override returnFinal(INode node) {
		node
	}
	
	override returnIntermediate(INode node) {
		null
	}
	
}
=======
package org.xixum.nlx.dictionary.grammar.bool

import org.xixum.nlx.dictionary.grammar.bool.BoolOp
import org.xixum.nlx.ai.semantics.INode

class BoolAnd extends BoolOp {
	
	override isTrue(INode node) {
		return node === null
	}
	
	override returnFinal(INode node) {
		node
	}
	
	override returnIntermediate(INode node) {
		null
	}
	
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary.grammar/xtend-src/de/validas/nlx/dictionary/grammar/bool/BoolAnd.xtend
