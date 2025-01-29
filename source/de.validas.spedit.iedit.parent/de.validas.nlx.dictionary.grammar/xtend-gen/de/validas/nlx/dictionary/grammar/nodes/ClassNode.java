package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.ai.util.NodeUtil;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.grammar.nodes.AbstractPredicatedNodeObj;
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateIS;
import de.validas.nlx.dictionary.grammar.token.IGrammarInterpunction;
import de.validas.nlx.dictionary.grammar.token.IGrammarItem;
import de.validas.nlx.dictionary.grammar.token.IGrammarLiteral;
import de.validas.nlx.dictionary.grammar.types.IGrammarType;
import de.validas.nlx.dictionary.grammar.utils.GrammarUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class ClassNode extends AbstractPredicatedNodeObj implements IPredicateIS {
  private IGrammarItem item;
  
  public ClassNode(final Node node, final IParserDriver driver) {
    super(node, driver);
  }
  
  @Override
  public INode solve() {
    return null;
  }
  
  @Override
  public INode is(final INode caller) {
    Object _xblockexpression = null;
    {
      Object _attribute = caller.getAttribute(Neo4jConstants._TOKEN);
      this.item = ((IGrammarItem) _attribute);
      final IGrammarType type = this.item.getInternalType();
      boolean _matched = false;
      if (type instanceof IGrammarLiteral) {
        _matched=true;
        final ArrayList<ArrayList<Node>> segments = NodeUtil.pathToNodes(GrammarUtil.findPathTo(this.driver, this.item.getBaseNode(), this.node, Neo4jConstants._OF_CLASS));
        List<ArrayList<Node>> _elvis = null;
        if (segments != null) {
          _elvis = segments;
        } else {
          _elvis = Collections.<ArrayList<Node>>unmodifiableList(CollectionLiterals.<ArrayList<Node>>newArrayList());
        }
        for (final ArrayList<Node> chain : _elvis) {
          int _size = 0;
          if (chain!=null) {
            _size=chain.size();
          }
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            int _size_1 = chain.size();
            int _minus = (_size_1 - 2);
            final INode classN = this.driver.getNodeById(chain.get(Math.max(1, _minus)));
            final String selectedT = type.getBaseType().getKey();
            if (((selectedT != null) && selectedT.equals(classN.getAttribute(Neo4jConstants._NAME)))) {
              return classN;
            }
          }
        }
        this.solve();
      }
      if (!_matched) {
        if (type instanceof IGrammarInterpunction) {
          _matched=true;
          final Node tNode = ((IGrammarInterpunction)type).getNode();
          final ArrayList<ArrayList<Node>> segments = NodeUtil.pathToNodes(GrammarUtil.findPathTo(this.driver, tNode, this.node, Neo4jConstants._OF_CLASS));
          ArrayList<Node> _get = null;
          if (segments!=null) {
            _get=segments.get(0);
          }
          ArrayList<Node> chain = _get;
          int _size = 0;
          if (chain!=null) {
            _size=chain.size();
          }
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            int _size_1 = chain.size();
            int _minus = (_size_1 - 2);
            return this.driver.getNodeById(chain.get(Math.max(0, _minus)));
          }
        }
      }
      if (!_matched) {
        return this.solve();
      }
      _xblockexpression = null;
    }
    return ((INode)_xblockexpression);
  }
}
