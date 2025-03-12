package org.xixum.nlx.dictionary.grammar.nodes;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateIS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateLINK_TO;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateOF_CLASS;
import org.xixum.nlx.dictionary.grammar.token.IGrammarInterpunction;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;
import org.xixum.nlx.dictionary.grammar.token.IGrammarLiteral;
import org.xixum.nlx.dictionary.grammar.types.IGrammarType;
import org.xixum.nlx.dictionary.grammar.utils.GrammarUtil;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public class WordClassToken extends AbstractPredicatedNodeObj implements IDictNode, IPredicateIS, IPredicateOF_CLASS, IPredicateLINK_TO {
  private IGrammarItem item;

  public WordClassToken(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode solve() {
    return null;
  }

  @Override
  public INode is(final INode caller) {
    Object _attribute = caller.getAttribute(Neo4jConstants._TOKEN);
    this.item = ((IGrammarItem) _attribute);
    final IGrammarType type = this.item.getInternalType();
    boolean _matched = false;
    if (type instanceof IGrammarLiteral) {
      _matched=true;
      XPair<String, ITypeAttributes> _baseType = type.getBaseType();
      String _key = null;
      if (_baseType!=null) {
        _key=_baseType.getKey();
      }
      final String selectedT = _key;
      if (((selectedT != null) && selectedT.equals(this.getAttribute(Neo4jConstants._NAME)))) {
        return GrammarUtil.findTarget(this, this.item.getName());
      } else {
        return this.solve();
      }
    }
    if (!_matched) {
      if (type instanceof IGrammarInterpunction) {
        _matched=true;
        return GrammarUtil.findInterpunction(this, this.item);
      }
    }
    return this.solve();
  }

  @Override
  public INode ofClass(final INode caller, final Relationship relation) {
    return this;
  }

  @Override
  public INode linkTo(final INode caller, final Relationship relation, final Function1<? super String, ? extends INode> delegate) {
    String type = relation.get(PredicateConstants.AS_).asString().toLowerCase();
    return delegate.apply(type);
  }
}
