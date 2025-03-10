package org.xixum.nlx.view.fxviews.semantics.types

import org.xixum.nlx.dictionary.type.ITypeAttributes
import org.xixum.nlx.view.fxviews.semantics.ILinkable
import org.xixum.nlx.view.fxviews.semantics.util.LinkUtils
import org.xixum.utils.data.types.XPair
import java.util.Map

import static org.xixum.nlx.constants.Neo4jConstants.END_
import static org.xixum.nlx.constants.Neo4jConstants.START_
import org.xixum.nlx.view.fxviews.semantics.ILink
import org.xixum.nlx.dictionary.type.TypeAttributes
import org.xixum.nlx.dictionary.type.LinkTypeAttribute
import org.xixum.nlx.constants.Direction
import org.xixum.nlx.dictionary.constants.AttributeSet
import org.neo4j.driver.v1.types.Node

class CardinalType extends AbstractGrammarType implements ICardinalLinkable {
	
	XPair<String, ILinkable> start
	XPair<String, ILinkable> end
	ITypeAttributes attribs
	Integer lower
	Integer higher
	String name
	ITypeAttributes typesIntersect
	int cardinality

	
	new(ILinkable parent, XPair<String, ILinkable> start, XPair<String, ILinkable> end, ITypeAttributes linkAttribs){
		this.parent = parent
		this.start = start
		this.end = end
		this.attribs = linkAttribs
		var pair = LinkUtils.calculateBounds(start, end);
		this.lower = pair.getKey();
		this.higher = pair.getValue();
		this.name = start.key     //'''«start.key»+'''   //plus indicates cardinality >= 1
		cardinality = Math.max(start.value.cardinality, end.value.cardinality) + 1  //TODO: 14.03.2022 count cardinality

		var baseN = (attribs as LinkTypeAttribute).getParent(AttributeSet.START).baseNode

		this.typesIntersect = (attribs as LinkTypeAttribute).intersection(baseN, true, false)
		
	}
	
	override getCanvas() {
		start.value.canvas
	}
	
	override getHigherBound() {
		higher
	}
	
	override getLowerBound() {
		lower
	}
	
	override getName() {
		name
	}
	
	override getType() {
		new XPair(start.key,typesIntersect)
	}
	
	override getTypes() {
		#[type]
	}
	
	override setLink(String type, ILink link) {
		// Cardnal Type is only a referrer thus owns no own Links
	}
	
	override getCardinality() {
		cardinality
	}
	
	override getIntermediate() {
		parent.intermediate
	}
	
	override getBaseType(){
		var higher = (parent as ILink).startLink.value
		if (higher instanceof ILink && (higher as ILink).hasCardinalType)
			((higher as ILink).cardinalType as ICardinalLinkable).baseType
		else
			start.value
	}
	
	override getStart(){
		start
	}
	
	override getEnd(){
		end
	}
	
}