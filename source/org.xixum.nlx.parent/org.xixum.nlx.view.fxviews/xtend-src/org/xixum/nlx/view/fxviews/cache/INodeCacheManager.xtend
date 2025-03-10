<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/cache/INodeCacheManager.xtend
package de.validas.nlx.view.fxviews.cache

import org.neo4j.driver.v1.Record

interface INodeCacheManager {
	
	@Deprecated
	def ICacheObj getNode(String name, String label, Record rec, String varSelect) 
	
	def ICacheObj addNode(String name, String label, Record rec, String varSelect) 
		
	def void addLink (ICacheObj start, ICacheObj end, CachedLink link)
	
	def ICacheObj getNodeByName(String string)
	
=======
package org.xixum.nlx.view.fxviews.cache

import org.neo4j.driver.v1.Record

interface INodeCacheManager {
	
	@Deprecated
	def ICacheObj getNode(String name, String label, Record rec, String varSelect) 
	
	def ICacheObj addNode(String name, String label, Record rec, String varSelect) 
		
	def void addLink (ICacheObj start, ICacheObj end, CachedLink link)
	
	def ICacheObj getNodeByName(String string)
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/cache/INodeCacheManager.xtend
}