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