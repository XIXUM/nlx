package org.xixum.nlx.dictionary.grammar.nodes;

import java.util.List;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.grammar.bool.BoolOr;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateDO;

@SuppressWarnings("all")
public class ActionNode extends AbstractActionPredicatedNodeObj implements IActionNode, IActionSubject, IPredicateDO {
  private static final BoolOr boolOr = new BoolOr();

  protected final List<String> functionalTypes /* Skipped initializer because of errors */;

  public ActionNode(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode solve() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractDictRuleObj.predicates refers to the missing type IPredicate"
      + "\nThe method doExecuteType(String, BoolOp, List<IPredicate>) from the type AbstractDictRuleObj refers to the missing type IPredicate"
      + "\nThe field PredicateConstants.DO_ refers to the missing type Object"
      + "\nThe field AbstractDictRuleObj.predicates refers to the missing type IPredicate"
      + "\nThe field PredicateConstants.DO_ refers to the missing type Object");
  }

  @Override
  public INode Do(final INode caller) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PredicateConstants.TARGET_ refers to the missing type Object"
      + "\nThe field PredicateConstants.WITH_ refers to the missing type Object"
      + "\nThe field PredicateConstants.WITH_ refers to the missing type Object"
      + "\nThe field PredicateConstants.WITH_ refers to the missing type Object"
      + "\nThe field PredicateConstants.WITH_ refers to the missing type Object");
  }
}
