/**
 * AbstractDictRuleObj - Base Obj for Abstract dictionary rules
 * (c) 2020 licensed under Apache Public License 2.0
 * www.felixschaller.com
 * @author Felix Schaller
 */

package de.validas.nlx.ai.semantics

import de.validas.nlx.ai.IFunction1
import de.validas.nlx.ai.IParserDriver
import de.validas.nlx.constants.Direction
import java.util.List
import org.neo4j.driver.internal.value.NodeValue
import org.neo4j.driver.v1.Record
import org.neo4j.driver.v1.types.Node
import java.util.Map

interface INode {
	
	def INode solve()
	
	def Node getNodeRef()
	
	def IParserDriver getDriver()
	
	def void setNodeRef (Node node)
	
	def List<Record> listAllConnections()
	
	def List<Record> listConnections(String type)
	
	def List<Record> listAllOutputs()
	
	def List<Record> listAllInputs()
	
	def Object getAttribute(String key)
	
	def Object setAttribute(String key, Object value)
	
	def long getID()
	
	def String getLabel()
	
	def String getName()
	
	def boolean hasLabel(Node node, String name)
	
	def void setFilter(String filter)
	
	def INode findNodeAndCreateTarget(String string, IFunction1<Object, ?> delegate)
	
	def List<Node> findNodeTypeByName(String type, String name)
	
	def List<Node> findLinkedNodeByName(String string, String linkType, Direction dir)
	
	def Map<Long, Map<String, INode>> getChildren()
	
}
