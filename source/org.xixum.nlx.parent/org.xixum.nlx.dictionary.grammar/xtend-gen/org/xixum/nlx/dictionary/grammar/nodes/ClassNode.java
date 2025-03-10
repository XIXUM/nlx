package org.xixum.nlx.dictionary.grammar.nodes;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateIS;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;

@SuppressWarnings("all")
public class ClassNode extends AbstractPredicatedNodeObj implements IPredicateIS {
  private IGrammarItem item;

  public ClassNode(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode solve() {
    return null;
  }

  @Override
  public INode is(final INode caller) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getBaseType() from the type IGrammarType refers to the missing type XPair"
      + "\nkey cannot be resolved"
      + "\n!== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nequals cannot be resolved");
  }
}
