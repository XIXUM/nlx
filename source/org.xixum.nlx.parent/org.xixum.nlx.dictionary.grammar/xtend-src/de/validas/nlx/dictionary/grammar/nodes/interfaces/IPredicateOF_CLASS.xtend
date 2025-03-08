/**
 * (c) felixschaller.com 2022
 */

package de.validas.nlx.dictionary.grammar.nodes.interfaces

import org.neo4j.driver.v1.types.Relationship
import de.validas.nlx.ai.semantics.INode

/**
 * @author Felix Schaller
 */
interface IPredicateOF_CLASS {

	def INode ofClass(INode caller, Relationship relation)

}