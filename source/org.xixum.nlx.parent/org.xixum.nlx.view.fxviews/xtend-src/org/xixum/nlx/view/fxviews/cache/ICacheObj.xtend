<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/cache/ICacheObj.xtend
package de.validas.nlx.view.fxviews.cache

import java.util.Collection
import org.neo4j.driver.v1.Record
import org.neo4j.driver.v1.types.Node

interface ICacheObj {
	
	def void setOutLink(ICacheObj obj)
	
	def void setInLink(ICacheObj obj)
	
	def Collection<ICacheObj>  getOutLinks()
	
	def Collection<ICacheObj>  getInLinks()
	
	def Node getNode()
	
	def Record getRecord()
	
	def String getName()
	
	def boolean hasAttrs(String string)
	
=======
package org.xixum.nlx.view.fxviews.cache

import java.util.Collection
import org.neo4j.driver.v1.Record
import org.neo4j.driver.v1.types.Node

interface ICacheObj {
	
	def void setOutLink(ICacheObj obj)
	
	def void setInLink(ICacheObj obj)
	
	def Collection<ICacheObj>  getOutLinks()
	
	def Collection<ICacheObj>  getInLinks()
	
	def Node getNode()
	
	def Record getRecord()
	
	def String getName()
	
	def boolean hasAttrs(String string)
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/cache/ICacheObj.xtend
}