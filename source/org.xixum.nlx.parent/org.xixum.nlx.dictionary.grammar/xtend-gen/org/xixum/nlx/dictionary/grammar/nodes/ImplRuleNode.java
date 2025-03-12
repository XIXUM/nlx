package org.xixum.nlx.dictionary.grammar.nodes;

import java.util.List;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
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
    if ((this.predicates == null)) {
      List<Record> outs = this.listAllOutputs();
      this.createPredicates(outs);
    }
    this.setResult(this.doExecuteType(PredicateConstants.ENTER_RULE_, ImplRuleNode.boolOr, this.predicates.get(PredicateConstants.ENTER_RULE_)));
    INode _result = this.getResult();
    boolean _tripleNotEquals = (_result != null);
    if (_tripleNotEquals) {
      return this.doExecuteType(PredicateConstants.DO_, ImplRuleNode.boolOr, this.predicates.get(PredicateConstants.DO_));
    }
    return null;
  }

  public INode setResult(final INode node) {
    return this.result = node;
  }

  public INode getResult() {
    return this.result;
  }
}
