<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/xtend-src/de/validas/nlx/dictionary/type/AbstractTypeInfo.xtend
package de.validas.nlx.dictionary.type

import de.validas.nlx.dictionary.type.ITypeAttributes
import de.validas.utils.data.types.XPair
import java.util.HashMap
import java.util.List
import org.neo4j.driver.v1.types.Node

abstract class AbstractTypeInfo implements ITypeInfo{
	
	protected List<XPair<String, ITypeAttributes>> types
	protected Node baseNode

	
	new(Node node, HashMap<String, de.validas.nlx.dictionary.type.ITypeAttributes> linkTypes) {
		types = newArrayList
		addTypes(linkTypes)
		baseNode = node
	}
	
	override getTypes(){
		types
	}
	
	override updateTypes(HashMap<String, ITypeAttributes> linkTypes) {
		types.clear
		addTypes(linkTypes)
	}
	
	override void addTypes(HashMap<String, ITypeAttributes> linkTypes){
		if (linkTypes !== null)
			for (type : linkTypes.keySet){
				types.add(new XPair<String, ITypeAttributes>(type,linkTypes.get(type)))
			}
	}
	
	override getBase(){
		baseNode
	}
	
}
=======
package org.xixum.nlx.dictionary.type

import org.xixum.nlx.dictionary.type.ITypeAttributes
import org.xixum.utils.data.types.XPair
import java.util.HashMap
import java.util.List
import org.neo4j.driver.v1.types.Node

abstract class AbstractTypeInfo implements ITypeInfo{
	
	protected List<XPair<String, ITypeAttributes>> types
	protected Node baseNode

	
	new(Node node, HashMap<String, org.xixum.nlx.dictionary.type.ITypeAttributes> linkTypes) {
		types = newArrayList
		addTypes(linkTypes)
		baseNode = node
	}
	
	override getTypes(){
		types
	}
	
	override updateTypes(HashMap<String, ITypeAttributes> linkTypes) {
		types.clear
		addTypes(linkTypes)
	}
	
	override void addTypes(HashMap<String, ITypeAttributes> linkTypes){
		if (linkTypes !== null)
			for (type : linkTypes.keySet){
				types.add(new XPair<String, ITypeAttributes>(type,linkTypes.get(type)))
			}
	}
	
	override getBase(){
		baseNode
	}
	
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/xtend-src/org/xixum/nlx/dictionary/type/AbstractTypeInfo.xtend
