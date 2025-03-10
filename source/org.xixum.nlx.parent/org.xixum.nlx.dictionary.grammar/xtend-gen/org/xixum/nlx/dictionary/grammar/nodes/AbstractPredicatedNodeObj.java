package org.xixum.nlx.dictionary.grammar.nodes;

import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateGET_NAME;

@SuppressWarnings("all")
public abstract class AbstractPredicatedNodeObj extends AbstractDictRuleObj implements IPredicateGET_NAME {
  public AbstractPredicatedNodeObj(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode getName(final INode caller, final Relationship relation) {
    Object _xblockexpression = null;
    {
      caller.setAttribute(PredicateConstants.GET_NAME_, this.getAttribute(Neo4jConstants._ATTR_NAME));
      _xblockexpression = null;
    }
    return ((INode)_xblockexpression);
  }
}
