package org.xixum.nlx.view.fxviews.cache

import org.xixum.nlx.view.fxviews.cache.ICacheObj

interface ICacheLink extends ICacheObj {
	//TODO: make ICacheLink unrelative to ICacheObj
	def ICacheObj  getOutLink()
	
	def ICacheObj  getInLink()
	
	def String getAttrs()
}