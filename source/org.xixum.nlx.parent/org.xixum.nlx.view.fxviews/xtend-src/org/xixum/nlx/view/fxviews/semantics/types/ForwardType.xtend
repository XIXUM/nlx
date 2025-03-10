package org.xixum.nlx.view.fxviews.semantics.types

import org.xixum.nlx.dictionary.constants.AttributeSet
import org.xixum.nlx.dictionary.type.ITypeAttributes
import org.xixum.nlx.dictionary.type.LinkTypeAttribute
import org.xixum.nlx.view.fxviews.semantics.ILinkable
import org.neo4j.driver.v1.types.Node
import org.xixum.nlx.constants.Direction

class ForwardType extends AbstractGrammarType implements IForwardLinkable {
	
	Direction direction
	Node forwardType
	
	ITypeAttributes attribs
	ITypeAttributes typesIntersect
	
	
	new(ILinkable parent, Direction direction, Node forwardType){
		this.parent = parent
		this.direction = direction
		this.forwardType = forwardType
		
		this.attribs = parent.type.value
		var baseN = (attribs as LinkTypeAttribute).getParent(AttributeSet.START).baseNode
		this.typesIntersect = (attribs as LinkTypeAttribute).intersection(baseN, true, false)
		
	}
	
	override getDirection(){
		direction
	}
	
	override getForwarType(){
		forwardType
	}
	
}