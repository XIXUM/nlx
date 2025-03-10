<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/xtend-src/de/validas/nlx/dictionary/type/elements/IRelationshipEL.xtend
package de.validas.nlx.dictionary.type.elements

import org.neo4j.driver.v1.types.Relationship

interface IRelationshipEL extends INetworkEL {
	
	def INodeEL getStart()
	
	def INodeEL getEnd()
	
	def Relationship getRelationship()
	
	def Boolean relink(NodeEL el)
	
=======
package org.xixum.nlx.dictionary.type.elements

import org.neo4j.driver.v1.types.Relationship

interface IRelationshipEL extends INetworkEL {
	
	def INodeEL getStart()
	
	def INodeEL getEnd()
	
	def Relationship getRelationship()
	
	def Boolean relink(NodeEL el)
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/xtend-src/org/xixum/nlx/dictionary/type/elements/IRelationshipEL.xtend
}