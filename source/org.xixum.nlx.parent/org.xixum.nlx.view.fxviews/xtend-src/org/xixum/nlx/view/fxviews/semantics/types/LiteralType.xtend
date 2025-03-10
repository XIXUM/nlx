package org.xixum.nlx.view.fxviews.semantics.types

import org.xixum.nlx.view.fxviews.semantics.ILinkable
import javafx.scene.Node
import org.xixum.nlx.dictionary.grammar.token.IGrammarLiteral

class LiteralType extends AbstractLinkType implements IGrammarLiteral  {
	
	new(String name, ILinkable parent) {
		this.name = name
		this.parent = parent
	}
	
	def Node getRoot() {
		return null;
	}
	
	def void removeType(TypeElement element) {
		// method stub
	}
	
	def void update(){
		
	}
	
}
