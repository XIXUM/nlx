package de.validas.nlx.dictionary.grammar.nodes

import de.validas.nlx.ai.IParserDriver
import de.validas.nlx.ai.semantics.IContextNode

class ContextNode extends AbstractNode implements IContextNode {
	
	IParserDriver driver
	
	new (IParserDriver driver){
		this.driver = driver
	}
	
}