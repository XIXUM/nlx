package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.dictionary.constants.PredicateConstants;
import de.validas.nlx.dictionary.grammar.nodes.AbstractPredicatedNodeObj;
import de.validas.nlx.dictionary.grammar.nodes.IDictNode;
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateLINK_TO;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
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
