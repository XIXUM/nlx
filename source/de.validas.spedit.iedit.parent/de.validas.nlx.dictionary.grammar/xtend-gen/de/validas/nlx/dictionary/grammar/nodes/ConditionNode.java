package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.constants.PredicateConstants;
import de.validas.nlx.dictionary.grammar.nodes.AbstractPredicatedNodeObj;
import de.validas.nlx.dictionary.grammar.nodes.IRuleNode;
import de.validas.nlx.dictionary.grammar.nodes.ITokenNode;
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateEQUALS;
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateTARGET;
import de.validas.nlx.dictionary.grammar.token.IGrammarItem;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public abstract class ConditionNode extends AbstractPredicatedNodeObj implements IRuleNode, ITokenNode, IPredicateEQUALS, IPredicateTARGET {
  protected List<INode> isObj;
  
  protected String match;
  
  protected final List<String> connections = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(PredicateConstants.IS_, PredicateConstants.INSTANCE_OF_, PredicateConstants.ENDS_WITH_));
  
  public ConditionNode(final Node node, final IParserDriver driver) {
    super(node, driver);
  }
  
  @Override
  public abstract INode solve();
  
  @Override
  public INode target(final INode caller) {
    INode _xblockexpression = null;
    {
      INode result = this.equals(caller);
      if ((result != null)) {
        this.driver.getContext().setAttribute(PredicateConstants.TARGET_, caller.getAttribute(Neo4jConstants._NODE));
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  @Override
  public INode equals(final INode caller) {
    INode _xblockexpression = null;
    {
      Object _attribute = caller.getAttribute(Neo4jConstants._TOKEN);
      IGrammarItem contextS = ((IGrammarItem) _attribute);
      if ((contextS == null)) {
        return null;
      }
      this.setAttribute(Neo4jConstants._TOKEN, contextS);
      _xblockexpression = this.solve();
    }
    return _xblockexpression;
  }
}
