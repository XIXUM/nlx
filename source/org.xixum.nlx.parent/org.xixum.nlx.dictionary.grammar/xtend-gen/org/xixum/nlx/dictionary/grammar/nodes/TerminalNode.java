package org.xixum.nlx.dictionary.grammar.nodes;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.constants.DictionaryConstants;
import org.xixum.nlx.dictionary.constants.NodeConstants;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateEQUALS;

@SuppressWarnings("all")
public class TerminalNode extends AbstractDictRuleObj implements IDictNode, IPredicateEQUALS {
  private Node position;

  public TerminalNode(final Node node, final Node position, final IParserDriver driver) {
    super(node, driver);
    this.position = position;
    this.setAttribute(DictionaryConstants._POSITION, position);
  }

  @Override
  public INode solve() {
    return null;
  }

  public Node getPosition() {
    return this.position;
  }

  public String getType() {
    return this.node.get(NodeConstants._TYPE).asString();
  }

  @Override
  public INode equals(final INode caller) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getBaseType() from the type IGrammarType refers to the missing type XPair"
      + "\nkey cannot be resolved"
      + "\nequals cannot be resolved"
      + "\n! cannot be resolved");
  }
}
