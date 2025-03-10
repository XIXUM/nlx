<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/cache/CachedLink.xtend
package de.validas.nlx.view.fxviews.cache

import org.neo4j.driver.v1.Record

class CachedLink extends CachedDeadLink {
	
	//String label
	Record rec
	String varSelect
	String attrs
	
	new (ICacheObj start, ICacheObj end, String attrs, Record rec, String varSelect) {
		//this.label = label
		super(start, end)
		this.rec = rec
		this.varSelect = varSelect
		this.attrs = attrs
	}
	
//	def getLabel() {
//		return label
//	}
	
	override getNode() {
		if (record.containsKey(varSelect))
			record.get(varSelect).asNode
		else 
			null
	}
	
	override getRecord() {
		rec
	}
	
	override getAttrs() {
		attrs
	}
	
	override hasAttrs(String string) {
		if (string === null) return true
		if (string.empty) 
			true
		else 
			attrs.equals(string)
	}
	
=======
package org.xixum.nlx.view.fxviews.cache

import org.neo4j.driver.v1.Record

class CachedLink extends CachedDeadLink {
	
	//String label
	Record rec
	String varSelect
	String attrs
	
	new (ICacheObj start, ICacheObj end, String attrs, Record rec, String varSelect) {
		//this.label = label
		super(start, end)
		this.rec = rec
		this.varSelect = varSelect
		this.attrs = attrs
	}
	
//	def getLabel() {
//		return label
//	}
	
	override getNode() {
		if (record.containsKey(varSelect))
			record.get(varSelect).asNode
		else 
			null
	}
	
	override getRecord() {
		rec
	}
	
	override getAttrs() {
		attrs
	}
	
	override hasAttrs(String string) {
		if (string === null) return true
		if (string.empty) 
			true
		else 
			attrs.equals(string)
	}
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/cache/CachedLink.xtend
}