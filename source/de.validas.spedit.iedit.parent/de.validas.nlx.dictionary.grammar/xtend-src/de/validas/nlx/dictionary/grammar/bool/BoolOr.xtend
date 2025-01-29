package de.validas.nlx.dictionary.grammar.bool

import de.validas.nlx.dictionary.grammar.bool.BoolOp
import de.validas.nlx.ai.semantics.INode

class BoolOr extends BoolOp {
	
	override isTrue(INode node) {
		return node !== null
	}
	
	override returnFinal(INode node) {
		null
	}
	
	override returnIntermediate(INode node) {
		node
	}
}

