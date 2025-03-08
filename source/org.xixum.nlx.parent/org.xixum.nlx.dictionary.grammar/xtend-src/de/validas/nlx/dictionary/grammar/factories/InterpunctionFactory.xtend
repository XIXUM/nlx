package de.validas.nlx.dictionary.grammar.factories

import de.validas.nlx.ai.INodeFactory
import de.validas.nlx.ai.IParserDriver
import org.neo4j.driver.v1.types.Node

//import static de.validas.nlx.constants.Neo4jConstants._NAME
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._START
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._END
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._FULLSTOP		
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._BRACKETOPEN  
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._BRACKETCLOSE 
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._QUESTION_M   
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._SEPARATOR    
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._NEWLINE      
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._KOMMA        
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._SEMICOLON    
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._EXCLAMATION_M
//import static de.validas.nlx.dictionary.constants.DictionaryConstants._SPECIAL 

import de.validas.nlx.dictionary.grammar.nodes.TerminalNode

import static de.validas.nlx.dictionary.constants.DictionaryConstants._AT
import static de.validas.nlx.constants.Neo4jConstants._TARGET
import de.validas.nlx.ai.util.NodeUtil

class InterpunctionFactory implements INodeFactory{
	
	override create(Node node, IParserDriver driver) {
		
		var records = NodeUtil.listConnections(driver.dbAccessor, node, _AT)
		var position = NodeUtil.recordsToNode(records, _TARGET).get(0)
		
		var attributes = node.asMap()
		
		return new TerminalNode(node, position, driver)

	}
	
}