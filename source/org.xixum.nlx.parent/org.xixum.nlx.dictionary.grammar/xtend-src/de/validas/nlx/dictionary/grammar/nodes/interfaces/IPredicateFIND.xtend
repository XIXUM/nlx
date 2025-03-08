package de.validas.nlx.dictionary.grammar.nodes.interfaces

import de.validas.nlx.ai.semantics.INode
import org.neo4j.driver.v1.types.Relationship

interface IPredicateFIND {
	
	def INode find(INode caller, Relationship relation)
}