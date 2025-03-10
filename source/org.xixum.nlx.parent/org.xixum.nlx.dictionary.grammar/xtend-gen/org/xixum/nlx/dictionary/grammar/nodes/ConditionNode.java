package org.xixum.nlx.dictionary.grammar.nodes;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateEQUALS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateTARGET;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;

@SuppressWarnings("all")
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
