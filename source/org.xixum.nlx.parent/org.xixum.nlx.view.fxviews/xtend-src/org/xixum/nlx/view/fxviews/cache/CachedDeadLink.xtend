<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/cache/CachedDeadLink.xtend
package de.validas.nlx.view.fxviews.cache

class CachedDeadLink implements ICacheLink { 
	
	protected ICacheObj start
	protected ICacheObj end
	
	new(ICacheObj start, ICacheObj end) {
		this.start = start
		this.end = end 
	}
	
	override setOutLink(ICacheObj obj) {
		this.start = obj
	}
	
	override setInLink(ICacheObj obj) {
		this.end = obj
	}
	
	override getOutLink()
	{
		this.start
	}
	
	override getInLink()
	{
		this.end
	}
	
	override getNode() {
		null
	}
	
	override getRecord() {
		null
	}
	
	override getOutLinks() {
		throw new UnsupportedOperationException("TODO: make unrelative")
	}
	
	override getInLinks() {
		throw new UnsupportedOperationException("TODO: make unrelative")
	}
	
	override getName() {
		null
	}
	
	override getAttrs() {
		null
	}
	
	override hasAttrs(String string) {
		if (string === null) return true
		string.empty
	}
	
	
=======
package org.xixum.nlx.view.fxviews.cache

class CachedDeadLink implements ICacheLink { 
	
	protected ICacheObj start
	protected ICacheObj end
	
	new(ICacheObj start, ICacheObj end) {
		this.start = start
		this.end = end 
	}
	
	override setOutLink(ICacheObj obj) {
		this.start = obj
	}
	
	override setInLink(ICacheObj obj) {
		this.end = obj
	}
	
	override getOutLink()
	{
		this.start
	}
	
	override getInLink()
	{
		this.end
	}
	
	override getNode() {
		null
	}
	
	override getRecord() {
		null
	}
	
	override getOutLinks() {
		throw new UnsupportedOperationException("TODO: make unrelative")
	}
	
	override getInLinks() {
		throw new UnsupportedOperationException("TODO: make unrelative")
	}
	
	override getName() {
		null
	}
	
	override getAttrs() {
		null
	}
	
	override hasAttrs(String string) {
		if (string === null) return true
		string.empty
	}
	
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/cache/CachedDeadLink.xtend
}