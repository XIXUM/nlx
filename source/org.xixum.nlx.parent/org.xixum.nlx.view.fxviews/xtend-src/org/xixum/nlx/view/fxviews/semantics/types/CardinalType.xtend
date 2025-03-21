<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/semantics/types/CardinalType.xtend
package de.validas.nlx.view.fxviews.semantics.types

import de.validas.nlx.dictionary.type.ITypeAttributes
import de.validas.nlx.view.fxviews.semantics.ILinkable
import de.validas.nlx.view.fxviews.semantics.util.LinkUtils
import de.validas.utils.data.types.XPair
import java.util.Map

import static de.validas.nlx.constants.Neo4jConstants.END_
import static de.validas.nlx.constants.Neo4jConstants.START_
import de.validas.nlx.view.fxviews.semantics.ILink
import de.validas.nlx.dictionary.type.TypeAttributes
import de.validas.nlx.dictionary.type.LinkTypeAttribute
import de.validas.nlx.constants.Direction
import de.validas.nlx.dictionary.constants.AttributeSet
import org.neo4j.driver.v1.types.Node

class CardinalType implements ICardinalLinkable {
	
	XPair<String, ILinkable> start
	XPair<String, ILinkable> end
	ILinkable parent
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
		cardinality = start.value.cardinality + 1  //TODO: 14.03.2022 count cardinality

		var baseN = (attribs as LinkTypeAttribute).getParent(AttributeSet.START).baseNode

		this.typesIntersect = (attribs as LinkTypeAttribute).intersection(baseN, true, false)
		
	}
	
	override getCanvas() {
		start.value.canvas
	}
	
	override getHigherBound() {
		higher
	}
	
	override getLink() {
		null
	}
	
	override getLinkType() {
		//throw new UnsupportedOperationException("TODO: auto-generated method stub")
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
		if((parent as ILink).hasCardinalType)
			((parent as ILink).cardinalType as ICardinalLinkable).baseType
		start.value
	}
	
	override getStart(){
		start
	}
	
	override getEnd(){
		end
	}
	
=======
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
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/semantics/types/CardinalType.xtend
}