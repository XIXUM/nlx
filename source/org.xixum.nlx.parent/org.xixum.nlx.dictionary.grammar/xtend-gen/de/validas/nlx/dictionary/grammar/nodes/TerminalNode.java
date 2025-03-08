package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.constants.DictionaryConstants;
import de.validas.nlx.dictionary.constants.NodeConstants;
import de.validas.nlx.dictionary.grammar.nodes.AbstractDictRuleObj;
import de.validas.nlx.dictionary.grammar.nodes.IDictNode;
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateEQUALS;
import de.validas.nlx.dictionary.grammar.token.IGrammarItem;
import de.validas.nlx.dictionary.grammar.types.IGrammarType;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.utils.data.types.XPair;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
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
