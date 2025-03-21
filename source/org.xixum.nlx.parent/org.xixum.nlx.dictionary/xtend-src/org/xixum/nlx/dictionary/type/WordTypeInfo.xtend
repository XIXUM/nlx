<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/xtend-src/de/validas/nlx/dictionary/type/WordTypeInfo.xtend
package de.validas.nlx.dictionary.type

import de.validas.nlx.dictionary.type.ITypeAttributes
import java.util.HashMap
import org.neo4j.driver.v1.types.Node

class WordTypeInfo extends AbstractTypeInfo { 
	
	new (HashMap<String, ITypeAttributes> linkTypes) {
		super(null, linkTypes)
	}
	
	new(Node node, HashMap<String, ITypeAttributes> linkTypes) {
		super(node, linkTypes)
	}
		
}
=======
package org.xixum.nlx.dictionary.type

import org.xixum.nlx.dictionary.type.ITypeAttributes
import java.util.HashMap
import org.neo4j.driver.v1.types.Node

class WordTypeInfo extends AbstractTypeInfo { 
	
	new (HashMap<String, ITypeAttributes> linkTypes) {
		super(null, linkTypes)
	}
	
	new(Node node, HashMap<String, ITypeAttributes> linkTypes) {
		super(node, linkTypes)
	}
		
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/xtend-src/org/xixum/nlx/dictionary/type/WordTypeInfo.xtend
