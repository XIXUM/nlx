package de.validas.nlx.dictionary.grammar.runnables

import de.validas.nlx.ai.semantics.INode
import de.validas.nlx.dictionary.grammar.nodes.ImplRuleNode
import de.validas.utils.data.types.XPair
import java.util.Map
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject

interface IRuleRunnable {
	def void run()
	
	def void start()
	
	def Map<Integer, INode> getResult()
	
	//def void nextRule(ImplRuleNode implRuleNode, EList<XPair<EObject, String>> chain) 
	
}
