package de.validas.nlx.view.fxviews.semantics.types

import de.validas.nlx.view.fxviews.semantics.ILinkable
import de.validas.nlx.view.fxviews.semantics.ILink

class AbstractGrammarType implements ILinkable {
	
	protected ILinkable parent
	
	override getCanvas() {
		parent.canvas
	}
	
	override getHigherBound() {
		0
	}
	
	override getLink() {
		
	}
	
	override getLinkType() {
		
	}
	
	override getLowerBound() {
		0
	}
	
	override getName() {
		
	}
	
	override getType() {
		
	}
	
	override getTypes() {
		
	}
	
	override getCardinality() {
		0
	}
	
	override getIntermediate() {
		parent.intermediate
	}
	
	override setLink(String type, ILink link) {
		// Type is only a referrer thus owns no own Links
	}
	
}