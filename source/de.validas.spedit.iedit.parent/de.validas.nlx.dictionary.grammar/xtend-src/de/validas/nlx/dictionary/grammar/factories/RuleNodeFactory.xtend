package de.validas.nlx.dictionary.grammar.factories

import de.validas.nlx.ai.INodeFactory
import de.validas.nlx.ai.IParserDriver
import de.validas.nlx.dictionary.grammar.nodes.ActionNode
import de.validas.nlx.dictionary.grammar.nodes.ActionObject
import de.validas.nlx.dictionary.grammar.nodes.RuleToken
import de.validas.nlx.dictionary.grammar.nodes.TenseNode
import de.validas.nlx.dictionary.grammar.nodes.WordClassToken
import de.validas.nlx.dictionary.grammar.nodes.WordFragment
import de.validas.nlx.dictionary.grammar.nodes.WordToken
import org.neo4j.driver.v1.types.Node

import static de.validas.nlx.dictionary.constants.NodeConstants._ACTION
import static de.validas.nlx.dictionary.constants.NodeConstants._ACTION_OBJECT
import static de.validas.nlx.dictionary.constants.NodeConstants._CONDITION
import static de.validas.nlx.dictionary.constants.NodeConstants._INTERPUNCTION
import static de.validas.nlx.dictionary.constants.NodeConstants._IMPL_RULE_TOKEN
import static de.validas.nlx.dictionary.constants.NodeConstants._TENSE
import static de.validas.nlx.dictionary.constants.NodeConstants._WORD
import static de.validas.nlx.dictionary.constants.NodeConstants._WORD_CLASS
import static de.validas.nlx.dictionary.constants.NodeConstants._WORD_FRAGMENT
import static de.validas.nlx.constants.Neo4jConstants._CLASS
import de.validas.nlx.dictionary.grammar.nodes.ClassNode

class RuleNodeFactory implements INodeFactory {
	
	protected val ConditionFactory conditionFactory = new ConditionFactory()
	protected val interpunctionFactory = new InterpunctionFactory()
	
	
	override create(Node node, IParserDriver driver) {
		
		var Iterable<String> labels = node.labels()
		switch (labels.get(0)) { 
			//TODO: igonore multible Lables for now 
			case _WORD: {
				new WordToken(node, driver)
			}
			case _WORD_CLASS: {
				new WordClassToken(node, driver)
			}
			case _WORD_FRAGMENT: {
				new WordFragment(node, driver)
			}
			case _IMPL_RULE_TOKEN: {
				new RuleToken(node, driver)
			}
			case _ACTION: {
				new ActionNode(node, driver)
			}
			case _ACTION_OBJECT: {
				new ActionObject(node, driver)
			}
			case _TENSE: {
				new TenseNode(node,driver)
			}
			case _CLASS:{
				new ClassNode(node, driver)
			}
			case _CONDITION: {
				conditionFactory.create(node, driver)  
			}
			
			case _INTERPUNCTION: {
				interpunctionFactory.create(node, driver)
			}
			
			//TODO: ... other future NoteTypes
		}
		
	}
	
}
