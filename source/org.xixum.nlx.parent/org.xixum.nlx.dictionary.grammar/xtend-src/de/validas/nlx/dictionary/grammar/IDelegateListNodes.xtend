<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.spedit.iedit/src/de/validas/spedit/validation/semantics/IDelegateListNodes.xtend
package de.validas.spedit.validation.semantics

import java.util.List
import org.neo4j.driver.internal.value.NodeValue

/**
 *  deprecated. use IFunction from: de.validas.nlx.ai
 */
@Deprecated
interface IDelegateListNodes {
	def List<NodeValue> execute(String string)
=======
package org.xixum.nlx.dictionary.grammar

import java.util.List
import org.neo4j.driver.internal.value.NodeValue

/**
 *  deprecated. use IFunction from: org.xixum.nlx.ai
 */
@Deprecated
interface IDelegateListNodes {
	def List<NodeValue> execute(String string)
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary.grammar/xtend-src/de/validas/nlx/dictionary/grammar/IDelegateListNodes.xtend
}