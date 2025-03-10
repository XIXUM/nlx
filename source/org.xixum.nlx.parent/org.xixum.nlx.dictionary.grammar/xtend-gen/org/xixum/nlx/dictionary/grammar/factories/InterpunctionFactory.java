package org.xixum.nlx.dictionary.grammar.factories;

import java.util.List;
import java.util.Map;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.INodeFactory;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.ai.util.NodeUtil;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.constants.DictionaryConstants;
import org.xixum.nlx.dictionary.grammar.nodes.TerminalNode;

@SuppressWarnings("all")
public class InterpunctionFactory implements INodeFactory {
  @Override
  public INode create(final Node node, final IParserDriver driver) {
    List<Record> records = NodeUtil.listConnections(driver.getDbAccessor(), node, DictionaryConstants._AT);
    Node position = NodeUtil.recordsToNode(records, Neo4jConstants._TARGET).get(0);
    Map<String, Object> attributes = node.asMap();
    return new TerminalNode(node, position, driver);
  }
}
