package org.xixum.nlx.dictionary.grammar.nodes;

import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateGET;

@SuppressWarnings("all")
public abstract class AbstractActionPredicatedNodeObj extends AbstractPredicatedNodeObj implements IPredicateGET {
  public AbstractActionPredicatedNodeObj(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode get(final INode caller, final Relationship relation) {
    Object _xblockexpression = null;
    {
      Object _attribute = this.getAttribute(PredicateConstants.WITH_);
      INode value = ((INode) _attribute);
      if ((value != null)) {
        caller.setAttribute(relation.type().toLowerCase(), value);
      }
      _xblockexpression = null;
    }
    return ((INode)_xblockexpression);
  }
}
