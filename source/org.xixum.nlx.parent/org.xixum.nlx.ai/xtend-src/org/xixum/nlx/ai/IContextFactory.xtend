package de.validas.nlx.ai

import de.validas.nlx.ai.semantics.IContextNode

interface IContextFactory {
	
	def IContextNode create(IParserDriver driver)
	
}