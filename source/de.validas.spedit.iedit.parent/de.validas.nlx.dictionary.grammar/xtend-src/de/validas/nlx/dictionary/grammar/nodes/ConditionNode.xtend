package de.validas.nlx.dictionary.grammar.nodes

import static de.validas.nlx.dictionary.constants.PredicateConstants.ENDS_WITH_
import static de.validas.nlx.dictionary.constants.PredicateConstants.INSTANCE_OF_
import static de.validas.nlx.dictionary.constants.PredicateConstants.IS_
import static de.validas.nlx.dictionary.constants.PredicateConstants.TARGET_
import static de.validas.nlx.constants.Neo4jConstants._TOKEN
import static de.validas.nlx.constants.Neo4jConstants._NODE

import de.validas.nlx.ai.IParserDriver
import de.validas.nlx.ai.semantics.INode
import java.util.List
import org.neo4j.driver.v1.types.Node
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateEQUALS
import de.validas.nlx.dictionary.grammar.token.IGrammarItem
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateTARGET

abstract class ConditionNode extends AbstractPredicatedNodeObj implements IRuleNode, ITokenNode, IPredicateEQUALS, IPredicateTARGET{
	
	protected List<INode> isObj
	protected String match
	protected val List<String> connections = #[IS_, INSTANCE_OF_, ENDS_WITH_]
	
	new(Node node, IParserDriver driver) {
		super(node, driver)
	}
	
	override INode solve()
	
	override INode target(INode caller){
		var result = equals(caller)
		if (result !== null)
			driver.context.setAttribute(TARGET_, caller.getAttribute(_NODE))
		result
	}
	
	override INode equals(INode caller){
		var contextS = caller.getAttribute(_TOKEN) as IGrammarItem
		if (contextS === null)
			return null 
							
		setAttribute(_TOKEN, contextS)	
		solve()	
	}
	
}
