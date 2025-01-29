package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.constants.PredicateConstants;
import de.validas.nlx.dictionary.grammar.nodes.AbstractDictRuleObj;
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateGET_NAME;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
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
