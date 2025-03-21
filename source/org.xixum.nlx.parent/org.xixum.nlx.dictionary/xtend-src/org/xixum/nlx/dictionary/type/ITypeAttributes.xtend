<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/xtend-src/de/validas/nlx/dictionary/type/ITypeAttributes.xtend
package de.validas.nlx.dictionary.type

import de.validas.nlx.dictionary.type.elements.INodeEL
import de.validas.nlx.dictionary.type.elements.IRelationshipEL
import java.util.Collection
import java.util.List
import org.neo4j.driver.v1.types.Node

interface ITypeAttributes {

	def Node getBaseNode()
	
	@Deprecated     //deprecate Interface
	def Object getAttrs()
	
	@Deprecated     //deprecate Interface
	def List<Node> getSource()	
	
	@Deprecated     //deprecate Interface
	def List<Node> getTarget()
	
	def void merge(ITypeAttributes attributes)
	
	def Collection<? extends INodeEL> getSourceEL()
	
	def Collection<? extends INodeEL> getTargetEL()
	
	def Collection<? extends IRelationshipEL> getAttrsEL()
	
=======
package org.xixum.nlx.dictionary.type

import org.xixum.nlx.dictionary.type.elements.INodeEL
import org.xixum.nlx.dictionary.type.elements.IRelationshipEL
import java.util.Collection
import java.util.List
import org.neo4j.driver.v1.types.Node

interface ITypeAttributes {

	def Node getBaseNode()
	
	@Deprecated     //deprecate Interface
	def Object getAttrs()
	
	@Deprecated     //deprecate Interface
	def List<Node> getSource()	
	
	@Deprecated     //deprecate Interface
	def List<Node> getTarget()
	
	def void merge(ITypeAttributes attributes)
	
	def Collection<? extends INodeEL> getSourceEL()
	
	def Collection<? extends INodeEL> getTargetEL()
	
	def Collection<? extends IRelationshipEL> getAttrsEL()
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/xtend-src/org/xixum/nlx/dictionary/type/ITypeAttributes.xtend
}