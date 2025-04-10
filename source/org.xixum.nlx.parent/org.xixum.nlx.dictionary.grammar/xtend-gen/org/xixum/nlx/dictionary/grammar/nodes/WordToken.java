package org.xixum.nlx.dictionary.grammar.nodes;

import java.util.List;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
import org.xixum.nlx.dictionary.grammar.bool.BoolOr;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateEQUALS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateTARGET;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;

@SuppressWarnings("all")
public class WordToken extends AbstractDictRuleObj implements IDictNode, IPredicateEQUALS, IPredicateTARGET {
  private static final BoolOr boolOr = new BoolOr();

  protected INode wordClass = null;

  public WordToken(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  public String getWord() {
    Object _xblockexpression = null;
    {
      Object obj = this.getAttribute(Neo4jConstants._NAME);
      if ((obj instanceof String)) {
        return ((String)obj);
      }
      _xblockexpression = null;
    }
    return ((String)_xblockexpression);
  }

  @Override
  public INode solve() {
    Object _xblockexpression = null;
    {
      if ((this.predicates == null)) {
        List<Record> outs = this.listAllOutputs();
        this.createPredicates(outs);
      }
      if ((this.wordClass == null)) {
        this.wordClass = this.doExecuteType(PredicateConstants.OF_CLASS_, WordToken.boolOr, this.predicates.get(PredicateConstants.OF_CLASS_));
      }
      _xblockexpression = null;
    }
    return ((INode)_xblockexpression);
  }

  @Override
  public INode equals(final INode caller) {
    WordToken _xblockexpression = null;
    {
      Object _attribute = caller.getAttribute(Neo4jConstants._TOKEN);
      IGrammarItem contextS = ((IGrammarItem) _attribute);
      if ((contextS == null)) {
        return null;
      }
      String name = contextS.getName();
      boolean _equalsIgnoreCase = name.equalsIgnoreCase(this.getWord());
      boolean _not = (!_equalsIgnoreCase);
      if (_not) {
        return this.solve();
      }
      _xblockexpression = this;
    }
    return _xblockexpression;
  }

  @Override
  public INode target(final INode caller) {
    INode _xblockexpression = null;
    {
      INode result = this.equals(caller);
      if ((result != null)) {
        this.driver.getContext().setAttribute(PredicateConstants.TARGET_, result);
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
