<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/xtend-src/de/validas/nlx/dictionary/type/elements/INodeEL.xtend
package de.validas.nlx.dictionary.type.elements

import de.validas.nlx.constants.Direction
import java.util.List
import org.neo4j.driver.v1.types.Node

interface INodeEL extends INetworkEL {
	
	def Node getNode()	
	
	def boolean addRel(IRelationshipEL rel)
	
	def boolean addAllRels(List<IRelationshipEL> relationships)
	
	def List<IRelationshipEL> getRelationship(Direction set)
}

=======
package org.xixum.nlx.dictionary.type.elements

import org.xixum.nlx.constants.Direction
import java.util.List
import org.neo4j.driver.v1.types.Node

interface INodeEL extends INetworkEL {
	
	def Node getNode()	
	
	def boolean addRel(IRelationshipEL rel)
	
	def boolean addAllRels(List<IRelationshipEL> relationships)
	
	def List<IRelationshipEL> getRelationship(Direction set)
}

>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/xtend-src/org/xixum/nlx/dictionary/type/elements/INodeEL.xtend
