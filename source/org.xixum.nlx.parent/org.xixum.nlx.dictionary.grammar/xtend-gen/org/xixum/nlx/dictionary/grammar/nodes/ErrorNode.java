package org.xixum.nlx.dictionary.grammar.nodes;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public class ErrorNode extends AbstractDictRuleObj {
  private String message;

  public ErrorNode(final Node node, final IParserDriver driver) {
    this(node, driver, "");
  }

  public ErrorNode(final Node node, final IParserDriver driver, final String message) {
    super(node, driver);
    this.message = message;
  }

  @Override
  public INode solve() {
    return null;
  }

  public String getMessage() {
    return this.message;
  }
}
