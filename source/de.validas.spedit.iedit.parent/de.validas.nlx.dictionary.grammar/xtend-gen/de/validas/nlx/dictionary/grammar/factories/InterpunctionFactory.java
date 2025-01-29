package de.validas.nlx.dictionary.grammar.factories;

import de.validas.nlx.ai.INodeFactory;
import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.ai.util.NodeUtil;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.constants.DictionaryConstants;
import de.validas.nlx.dictionary.grammar.nodes.TerminalNode;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class InterpunctionFactory implements INodeFactory {
  @Override
  public INode create(final Node node, final IParserDriver driver) {
    List<Record> records = NodeUtil.listConnections(driver.getDbAccessor(), node, DictionaryConstants._AT);
    Node position = NodeUtil.recordsToNode(records, Neo4jConstants._TARGET).get(0);
    Map<String, Object> attributes = node.asMap();
    return new TerminalNode(node, position, driver);
  }
}
