<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/xtend-src/de/validas/nlx/dictionary/type/ITypeInfo.xtend
/**
 * @author: Felix Schaller
 */
package de.validas.nlx.dictionary.type

import de.validas.nlx.dictionary.type.ITypeAttributes
import de.validas.utils.data.types.XPair
import java.util.List
import java.util.HashMap
import org.neo4j.driver.v1.types.Node

interface ITypeInfo {
	
	//TODO: replace XPair with grammar Type with hashed attributes 
	def List<XPair<String, ITypeAttributes>> getTypes()
	
	def void updateTypes(HashMap<String, ITypeAttributes> linkTypes)
	def void addTypes(HashMap<String, ITypeAttributes> linkTypes)
	
	def Node getBase()
	
}
=======
/**
 * @author: Felix Schaller
 */
package org.xixum.nlx.dictionary.type

import org.xixum.nlx.dictionary.type.ITypeAttributes
import org.xixum.utils.data.types.XPair
import java.util.List
import java.util.HashMap
import org.neo4j.driver.v1.types.Node

interface ITypeInfo {
	
	//TODO: replace XPair with grammar Type with hashed attributes 
	def List<XPair<String, ITypeAttributes>> getTypes()
	
	def void updateTypes(HashMap<String, ITypeAttributes> linkTypes)
	def void addTypes(HashMap<String, ITypeAttributes> linkTypes)
	
	def Node getBase()
	
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/xtend-src/org/xixum/nlx/dictionary/type/ITypeInfo.xtend
