<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/xtend-src/de/validas/nlx/dictionary/type/InterpunctionTypeAttribute.xtend
package de.validas.nlx.dictionary.type

import de.validas.nlx.dictionary.type.ITypeAttributes
import org.neo4j.driver.v1.types.Node

class InterpunctionTypeAttribute implements ITypeAttributes {
	
	
	Node source
	String interpunction
	String type
	
	new(Node source, String interpunction, String type){
		this.source = source
		this.interpunction = interpunction
		this.type = type
	}
	
	new(String interpunction, String type) {
		this(null, interpunction, type)
	}
	
	def getType() {
		type
	}
	
	override getBaseNode() {
		null
	}
	
	@Deprecated
	override getAttrs() {
		interpunction
	}
	
	@Deprecated
	override getSource() {
		newArrayList(source)
	}
	
	@Deprecated
	override getTarget() {
		null
	}
	
	override merge(ITypeAttributes attributes) {
		
	}
	
	override getSourceEL() {
		null
	}
	
	override getTargetEL() {
		null
	}
	
	override getAttrsEL() {
		null
	}
	
=======
package org.xixum.nlx.dictionary.type

import org.xixum.nlx.dictionary.type.ITypeAttributes
import org.neo4j.driver.v1.types.Node

class InterpunctionTypeAttribute implements ITypeAttributes {
	
	
	Node source
	String interpunction
	String type
	
	new(Node source, String interpunction, String type){
		this.source = source
		this.interpunction = interpunction
		this.type = type
	}
	
	new(String interpunction, String type) {
		this(null, interpunction, type)
	}
	
	def getType() {
		type
	}
	
	override getBaseNode() {
		null
	}
	
	@Deprecated
	override getAttrs() {
		interpunction
	}
	
	@Deprecated
	override getSource() {
		newArrayList(source)
	}
	
	@Deprecated
	override getTarget() {
		null
	}
	
	override merge(ITypeAttributes attributes) {
		
	}
	
	override getSourceEL() {
		null
	}
	
	override getTargetEL() {
		null
	}
	
	override getAttrsEL() {
		null
	}
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/xtend-src/org/xixum/nlx/dictionary/type/InterpunctionTypeAttribute.xtend
}