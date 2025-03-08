/**
 * (c) felixschaller.com
 * @author felix schaller
 */
package de.validas.nlx.dictionary.grammar.nodes.interfaces

import de.validas.nlx.ai.semantics.INode

/**
 * interface for predicate capability NEXT
 */
interface IPredicateNEXT {
	
	def INode next(INode caller)

}