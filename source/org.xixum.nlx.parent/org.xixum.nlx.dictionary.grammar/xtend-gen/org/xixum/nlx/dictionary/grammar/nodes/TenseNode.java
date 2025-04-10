package org.xixum.nlx.dictionary.grammar.nodes;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateLINK_TO;

@SuppressWarnings("all")
public class TenseNode extends AbstractPredicatedNodeObj implements IDictNode, IPredicateLINK_TO {
  public TenseNode(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  public String getTense() {
    Object _xblockexpression = null;
    {
      Object obj = this.getAttribute(PredicateConstants.NAME_);
      if ((obj instanceof String)) {
        return ((String)obj);
      }
      _xblockexpression = null;
    }
    return ((String)_xblockexpression);
  }

  @Override
  public INode solve() {
    return null;
  }

  @Override
  public INode linkTo(final INode caller, final Relationship relation, final Function1<? super String, ? extends INode> delegate) {
    String type = relation.get(PredicateConstants.AS_).asString().toLowerCase();
    return delegate.apply(type);
  }
}
