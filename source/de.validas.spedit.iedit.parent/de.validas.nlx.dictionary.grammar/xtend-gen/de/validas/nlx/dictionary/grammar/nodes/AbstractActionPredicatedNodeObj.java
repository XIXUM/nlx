package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.dictionary.constants.PredicateConstants;
import de.validas.nlx.dictionary.grammar.nodes.AbstractPredicatedNodeObj;
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateGET;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
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
