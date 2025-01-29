package de.validas.nlx.dictionary.grammar.utils;

import com.google.common.base.Objects;
import de.validas.nlx.ai.IFunction1;
import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.neo4j.Neo4jAccess;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.ai.util.Arrow;
import de.validas.nlx.constants.Direction;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.constants.DictionaryConstants;
import de.validas.nlx.dictionary.constants.NodeConstants;
import de.validas.nlx.dictionary.grammar.nodes.TerminalNode;
import de.validas.nlx.dictionary.grammar.token.IGrammarItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Path;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class GrammarUtil {
  public static INode findWord(final INode nodeClass, final String name) {
    Object _xblockexpression = null;
    {
      final long id = nodeClass.getID();
      Map<Long, Map<String, INode>> children = nodeClass.getChildren();
      boolean _containsKey = children.containsKey(Long.valueOf(id));
      boolean _not = (!_containsKey);
      if (_not) {
        children.put(Long.valueOf(id), CollectionLiterals.<String, INode>newHashMap());
      }
      final Map<String, INode> descendants = children.get(Long.valueOf(id));
      boolean _containsKey_1 = descendants.containsKey(name);
      boolean _not_1 = (!_containsKey_1);
      if (_not_1) {
        final Function1<Object, List<Node>> _function = (Object e) -> {
          List<Node> _xifexpression = null;
          if ((e instanceof String)) {
            _xifexpression = nodeClass.findNodeTypeByName(NodeConstants._WORD, ((String)e));
          }
          return _xifexpression;
        };
        Function1<Object, List<Node>> delegate = _function;
        final Function1<Object, List<Node>> _converted_delegate = (Function1<Object, List<Node>>)delegate;
        INode result = nodeClass.findNodeAndCreateTarget(name, new IFunction1<Object, Object>() {
            public Object apply(Object e) {
              return _converted_delegate.apply(e);
            }
        });
        if ((result instanceof INode)) {
          descendants.put(name, result);
          return result;
        }
      } else {
        return descendants.get(name);
      }
      _xblockexpression = null;
    }
    return ((INode)_xblockexpression);
  }
  
  public static INode findTarget(final INode nodeClass, final String name) {
    Object _xblockexpression = null;
    {
      final long id = nodeClass.getID();
      Map<Long, Map<String, INode>> children = nodeClass.getChildren();
      boolean _containsKey = children.containsKey(Long.valueOf(id));
      boolean _not = (!_containsKey);
      if (_not) {
        children.put(Long.valueOf(id), CollectionLiterals.<String, INode>newHashMap());
      }
      final Map<String, INode> descendants = children.get(Long.valueOf(id));
      boolean _containsKey_1 = descendants.containsKey(name);
      boolean _not_1 = (!_containsKey_1);
      if (_not_1) {
        final Function1<Object, List<Node>> _function = (Object e) -> {
          List<Node> _xifexpression = null;
          if ((e instanceof String)) {
            _xifexpression = nodeClass.findLinkedNodeByName(((String)e), Neo4jConstants._OF_CLASS, Direction.LEFT);
          }
          return _xifexpression;
        };
        Function1<Object, List<Node>> delegate = _function;
        final Function1<Object, List<Node>> _converted_delegate = (Function1<Object, List<Node>>)delegate;
        INode result = nodeClass.findNodeAndCreateTarget(name, new IFunction1<Object, Object>() {
            public Object apply(Object e) {
              return _converted_delegate.apply(e);
            }
        });
        if ((result instanceof INode)) {
          descendants.put(name, result);
          return result;
        }
      } else {
        return descendants.get(name);
      }
      _xblockexpression = null;
    }
    return ((INode)_xblockexpression);
  }
  
  public static INode findInterpunction(final INode node, final IGrammarItem item) {
    Object _xblockexpression = null;
    {
      INode current = node.getDriver().getNodeById(item.getBaseNode());
      Object _switchResult = null;
      boolean _matched = false;
      if (current instanceof TerminalNode) {
        _matched=true;
        Object _xblockexpression_1 = null;
        {
          Object _attribute = ((TerminalNode)current).getAttribute(DictionaryConstants._POSITION);
          Node nC = ((Node) _attribute);
          Object _attribute_1 = node.getAttribute(DictionaryConstants._POSITION);
          Node nN = ((Node) _attribute_1);
          Object _xifexpression = null;
          if ((((TerminalNode)current).getAttribute(Neo4jConstants._NAME).equals(node.getAttribute(Neo4jConstants._NAME)) && (nC.id() == nN.id()))) {
            return current;
          } else {
            _xifexpression = null;
          }
          _xblockexpression_1 = _xifexpression;
        }
        _switchResult = _xblockexpression_1;
      }
      if (!_matched) {
        _switchResult = null;
      }
      _xblockexpression = _switchResult;
    }
    return ((INode)_xblockexpression);
  }
  
  public static List<Path> findPathTo(final IParserDriver driver, final Node from, final Node to, final String type) {
    if ((Objects.equal(from, null) || Objects.equal(to, null))) {
      return null;
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MATCH ");
    _builder.append(Neo4jConstants._P);
    _builder.append(" = (");
    _builder.append(Neo4jConstants._N);
    _builder.append(")");
    CharSequence _generate = new Arrow(Neo4jConstants._L, type, null, null, null, true, Direction.RIGHT).generate();
    _builder.append(_generate);
    _builder.append("(");
    _builder.append(Neo4jConstants._T);
    _builder.append(") WHERE ID(");
    _builder.append(Neo4jConstants._N);
    _builder.append(") = ");
    long _id = from.id();
    _builder.append(_id);
    _builder.append(" AND ID(");
    _builder.append(Neo4jConstants._T);
    _builder.append(") = ");
    long _id_1 = to.id();
    _builder.append(_id_1);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("RETURN *");
    final String query = _builder.toString();
    final List<Record> records = driver.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.READ);
    boolean _isEmpty = false;
    if (records!=null) {
      _isEmpty=records.isEmpty();
    }
    boolean _not = (!_isEmpty);
    if (_not) {
      ArrayList<Path> result = CollectionLiterals.<Path>newArrayList();
      for (final Record rec : records) {
        result.add(rec.get(Neo4jConstants._P).asPath());
      }
      return result;
    }
    return null;
  }
}
