package org.xixum.nlx.dictionary.grammar.nodes;

import java.util.List;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateEQUALS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateTARGET;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;

@SuppressWarnings("all")
public abstract class ConditionNode extends AbstractPredicatedNodeObj implements IRuleNode, ITokenNode, IPredicateEQUALS, IPredicateTARGET {
  protected List<INode> isObj;

  protected String match;

  protected final List<String> connections /* Skipped initializer because of errors */;

  public ConditionNode(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public abstract INode solve();

  @Override
  public INode target(final INode caller) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PredicateConstants.TARGET_ refers to the missing type Object");
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
