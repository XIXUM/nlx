<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/xtend-src/de/validas/nlx/dictionary/type/TypeHierarchy.xtend
package de.validas.nlx.dictionary.type

import java.util.List
import org.neo4j.driver.v1.types.Node
import static de.validas.nlx.constants.Neo4jConstants._NAME

class TypeHierarchy implements ITypeHierarchy{
	
	Node node
	List<ITypeHierarchy> hierarchy
	
	new(Node node, List<ITypeHierarchy> hierarchy) {
		this.node = node
		this.hierarchy = hierarchy
	}
	
	override getType(){
		node.get(_NAME).asString
	}
	
	override getChildren() {
		hierarchy
	}
	
=======
package org.xixum.nlx.dictionary.type

import java.util.List
import org.neo4j.driver.v1.types.Node
import static org.xixum.nlx.constants.Neo4jConstants._NAME

class TypeHierarchy implements ITypeHierarchy{
	
	Node node
	List<ITypeHierarchy> hierarchy
	
	new(Node node, List<ITypeHierarchy> hierarchy) {
		this.node = node
		this.hierarchy = hierarchy
	}
	
	override getType(){
		node.get(_NAME).asString
	}
	
	override getChildren() {
		hierarchy
	}
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/xtend-src/org/xixum/nlx/dictionary/type/TypeHierarchy.xtend
}