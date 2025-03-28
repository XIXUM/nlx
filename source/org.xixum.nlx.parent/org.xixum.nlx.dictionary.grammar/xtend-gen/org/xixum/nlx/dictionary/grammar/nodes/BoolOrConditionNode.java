package org.xixum.nlx.dictionary.grammar.nodes;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.grammar.bool.BoolOr;

@SuppressWarnings("all")
public class BoolOrConditionNode extends ConditionNode {
  private static final BoolOr boolOr = new BoolOr();

  public BoolOrConditionNode(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode solve() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractDictRuleObj.predicates refers to the missing type IPredicate");
  }
}
