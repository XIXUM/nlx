package de.validas.nlx.dictionary.grammar.factories

import de.validas.nlx.ai.INodeFactory
import de.validas.nlx.ai.IParserDriver
import de.validas.nlx.dictionary.grammar.nodes.BoolAndConditionNode
import de.validas.nlx.dictionary.grammar.nodes.BoolOrConditionNode
import java.util.HashMap
import org.neo4j.driver.v1.types.Node

import static de.validas.nlx.dictionary.constants.PredicateConstants.TYPE_
import static de.validas.nlx.dictionary.constants.NodeConstants._BOOL_AND
import static de.validas.nlx.dictionary.constants.NodeConstants._BOOL_OR
import de.validas.nlx.dictionary.grammar.nodes.ErrorNode

class ConditionFactory implements INodeFactory {

	override create(Node node, IParserDriver driver) {
		var HashMap<String, Object> attributes = new HashMap<String, Object>(node.asMap())
		val type = attributes.get(TYPE_) 
		switch (type) {
			case _BOOL_AND: {
				new BoolAndConditionNode(node, driver)
			}
			case _BOOL_OR: {
				new BoolOrConditionNode(node, driver)
			}
			default: {
				//TODO: 11.11.22 raise Exception and catch exception in runner
				driver.logger.log('''[ERROR]: ConditionFactory For:
Node -> [«node.id», «node.asMap»]''')
				new ErrorNode(node, driver, '''unknown boolean operator: "«type»"''')
			}
		}

	}

}
