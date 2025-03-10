package org.xixum.nlx.dictionary.grammar.nodes;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
import org.xixum.nlx.dictionary.grammar.bool.BoolOr;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateDO;

@SuppressWarnings("all")
public class ActionNode extends AbstractActionPredicatedNodeObj implements IActionNode, IActionSubject, IPredicateDO {
  private static final BoolOr boolOr = new BoolOr();

  protected final List<String> functionalTypes = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(PredicateConstants.GET_SOURCE_, PredicateConstants.GET_TARGET_, PredicateConstants.LINK_TO_, PredicateConstants.LINK_INSTANCE_TO_, PredicateConstants.FIND_));

  public ActionNode(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode solve() {
    if ((this.predicates == null)) {
      List<Record> outs = this.listAllOutputs();
      this.createPredicates(outs);
    }
    INode result = this.doExecuteTypes(this.functionalTypes, ActionNode.boolOr);
    if ((result != null)) {
      return this.doExecuteType(PredicateConstants.DO_, ActionNode.boolOr, this.predicates.get(PredicateConstants.DO_));
    }
    return null;
  }

  @Override
  public INode Do(final INode caller) {
    Object _xblockexpression = null;
    {
      boolean _matched = false;
      if (caller instanceof ImplRuleNode) {
        _matched=true;
        Object target = this.driver.getContext().getAttribute(PredicateConstants.TARGET_);
        if ((target != null)) {
          this.setAttribute(PredicateConstants.WITH_, ((INode) target));
        } else {
          INode _result = ((ImplRuleNode)caller).getResult();
          this.setAttribute(PredicateConstants.WITH_, ((INode) _result));
        }
        return this.solve();
      }
      if (!_matched) {
        if (caller instanceof IActionNode) {
          _matched=true;
          this.setAttribute(PredicateConstants.WITH_, ((IActionNode)caller).getAttribute(PredicateConstants.WITH_));
          return this.solve();
        }
      }
      _xblockexpression = null;
    }
    return ((INode)_xblockexpression);
  }
}
