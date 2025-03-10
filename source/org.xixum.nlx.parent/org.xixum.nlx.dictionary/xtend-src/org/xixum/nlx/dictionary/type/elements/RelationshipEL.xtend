<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/xtend-src/de/validas/nlx/dictionary/type/elements/RelationshipEL.xtend
package de.validas.nlx.dictionary.type.elements

import org.neo4j.driver.v1.types.Relationship

class RelationshipEL extends NetworkEL implements IRelationshipEL{
	
	Relationship relation
	INodeEL startN
	INodeEL endN
	
	private new(INodeEL start, INodeEL end, Relationship rel){
		this.startN = start
		this.endN = end
		this.relation = rel
	}
	
	override INodeEL getStart(){
		startN
	}
	
	override INodeEL getEnd(){
		endN
	}
	
	override Relationship getRelationship(){
		relation
	}
	
	def static IRelationshipEL create(INodeEL start, INodeEL end, Relationship rel){
		var instance = new RelationshipEL(start, end, rel)
		instance.getStart().addRel(instance)
		instance.getEnd().addRel(instance)
		instance
	}
	
	override getID() {
		relation.id
	}
	
	override relink(NodeEL el) {
		if (startN.ID.equals(el.ID))
			startN = el
		else if (endN.ID.equals(el.ID))
			endN = el
		else
			return false
		true
	}
	
	override mergeRel(INetworkEL el) {
		if (el instanceof IRelationshipEL){
			//if (!el.ID.equals(relation.id))
			return //do nothing, just allow delete
		} else 
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		
	}
	
	override toString(){
		'''«relation.type» | «relation.asMap»'''
	}
	
=======
package org.xixum.nlx.dictionary.type.elements

import org.neo4j.driver.v1.types.Relationship

class RelationshipEL extends NetworkEL implements IRelationshipEL{
	
	Relationship relation
	INodeEL startN
	INodeEL endN
	
	private new(INodeEL start, INodeEL end, Relationship rel){
		this.startN = start
		this.endN = end
		this.relation = rel
	}
	
	override INodeEL getStart(){
		startN
	}
	
	override INodeEL getEnd(){
		endN
	}
	
	override Relationship getRelationship(){
		relation
	}
	
	def static IRelationshipEL create(INodeEL start, INodeEL end, Relationship rel){
		var instance = new RelationshipEL(start, end, rel)
		instance.getStart()?.addRel(instance)
		instance.getEnd()?.addRel(instance)
		instance
	}
	
	override getID() {
		relation.id
	}
	
	override relink(NodeEL el) {
		if (startN.ID.equals(el.ID))
			startN = el
		else if (endN.ID.equals(el.ID))
			endN = el
		else
			return false
		true
	}
	
	override mergeRel(INetworkEL el) {
		if (el instanceof IRelationshipEL){
			//if (!el.ID.equals(relation.id))
			return //do nothing, just allow delete
		} else 
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		
	}
	
	override toString(){
		'''«relation.type» | «relation.asMap»'''
	}
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/xtend-src/org/xixum/nlx/dictionary/type/elements/RelationshipEL.xtend
}