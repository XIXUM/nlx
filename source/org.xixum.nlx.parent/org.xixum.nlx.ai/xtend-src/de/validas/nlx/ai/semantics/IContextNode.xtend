package de.validas.nlx.ai.semantics

interface IContextNode {
	
	def Object getAttribute(String key)
	
	def Object setAttribute(String key, Object value)
	
}
