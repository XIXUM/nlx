package org.xixum.nlx.dictionary.grammar.nodes;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.constants.DictionaryConstants;
import org.xixum.nlx.dictionary.constants.NodeConstants;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateEQUALS;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;
import org.xixum.nlx.dictionary.grammar.types.IGrammarType;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public class TerminalNode extends AbstractDictRuleObj implements IDictNode, IPredicateEQUALS {
  private Node position;

  public TerminalNode(final Node node, final Node position, final IParserDriver driver) {
    super(node, driver);
    this.position = position;
    this.setAttribute(DictionaryConstants._POSITION, position);
  }

  @Override
  public INode solve() {
    return null;
  }

  public Node getPosition() {
    return this.position;
  }

  public String getType() {
    return this.node.get(NodeConstants._TYPE).asString();
  }

  @Override
  public INode equals(final INode caller) {
    TerminalNode _xblockexpression = null;
    {
      Object _attribute = caller.getAttribute(Neo4jConstants._TOKEN);
      final IGrammarItem contextS = ((IGrammarItem) _attribute);
      if ((contextS == null)) {
        return null;
      }
      final INode result = this.solve();
      boolean _equalsIgnoreCase = contextS.getName().equalsIgnoreCase(this.name);
      boolean _not = (!_equalsIgnoreCase);
      if (_not) {
        return result;
      }
      IGrammarType _internalType = null;
      if (contextS!=null) {
        _internalType=contextS.getInternalType();
      }
      XPair<String, ITypeAttributes> _baseType = null;
      if (_internalType!=null) {
        _baseType=_internalType.getBaseType();
      }
      final String type = _baseType.getKey();
      boolean _equals = type.equals(this.getType());
      boolean _not_1 = (!_equals);
      if (_not_1) {
        return result;
      }
      _xblockexpression = this;
    }
    return _xblockexpression;
  }
}
