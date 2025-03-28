package org.xixum.nlx.dictionary.grammar.nodes;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.grammar.bool.BoolOr;
import org.xixum.utils.data.lists.IAppendable;

@SuppressWarnings("all")
public class ImplRuleNode extends AbstractDictRuleObj implements IRuleNode {
  private static final BoolOr boolOr = new BoolOr();

  protected int index = 0;

  protected INode result;

  public ImplRuleNode(final Node node, final IAppendable token, final IParserDriver driver) {
    super(node, driver);
    driver.getContext().setAttribute(Neo4jConstants._TOKEN, token);
    this.setAttribute(Neo4jConstants._TOKEN, token);
  }

  @Override
  public INode solve() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractDictRuleObj.predicates refers to the missing type IPredicate"
      + "\nThe method doExecuteType(String, BoolOp, List<IPredicate>) from the type AbstractDictRuleObj refers to the missing type IPredicate"
      + "\nThe field PredicateConstants.ENTER_RULE_ refers to the missing type Object"
      + "\nThe field AbstractDictRuleObj.predicates refers to the missing type IPredicate"
      + "\nThe field PredicateConstants.ENTER_RULE_ refers to the missing type Object"
      + "\nThe method doExecuteType(String, BoolOp, List<IPredicate>) from the type AbstractDictRuleObj refers to the missing type IPredicate"
      + "\nThe field PredicateConstants.DO_ refers to the missing type Object"
      + "\nThe field AbstractDictRuleObj.predicates refers to the missing type IPredicate"
      + "\nThe field PredicateConstants.DO_ refers to the missing type Object");
  }

  public INode setResult(final INode node) {
    return this.result = node;
  }

  public INode getResult() {
    return this.result;
  }
}
