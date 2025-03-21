<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/cache/ICacheLink.xtend
package de.validas.nlx.view.fxviews.cache

import de.validas.nlx.view.fxviews.cache.ICacheObj

interface ICacheLink extends ICacheObj {
	//TODO: make ICacheLink unrelative to ICacheObj
	def ICacheObj  getOutLink()
	
	def ICacheObj  getInLink()
	
	def String getAttrs()
=======
package org.xixum.nlx.view.fxviews.cache

import org.xixum.nlx.view.fxviews.cache.ICacheObj

interface ICacheLink extends ICacheObj {
	//TODO: make ICacheLink unrelative to ICacheObj
	def ICacheObj  getOutLink()
	
	def ICacheObj  getInLink()
	
	def String getAttrs()
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/cache/ICacheLink.xtend
}