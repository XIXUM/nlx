/**
 * AbstractDictRuleObj - Base Obj for Abstract dictionary rules
 * (c) 2020 licensed under Apache Public License 2.0
 * www.felixschaller.com
 * @author Felix Schaller
 */
package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IFunction1;
import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.neo4j.Neo4jAccess;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.ai.semantics.IPredicate;
import de.validas.nlx.ai.util.Arrow;
import de.validas.nlx.ai.util.NodeUtil;
import de.validas.nlx.constants.Direction;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.constants.NodeConstants;
import de.validas.nlx.dictionary.grammar.bool.BoolOp;
import de.validas.nlx.dictionary.grammar.nodes.AbstractNode;
import de.validas.nlx.dictionary.grammar.token.IGrammarItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public abstract class AbstractDictRuleObj extends AbstractNode implements INode {
  protected Node node;
  
  protected String label;
  
  protected String name;
  
  protected long ID;
  
  protected IParserDriver driver;
  
  protected Map<String, List<IPredicate>> predicates;
  
  protected List<String> negativeFilter;
  
  protected List<String> positiveFilter;
  
  protected Map<Long, Map<String, INode>> children = CollectionLiterals.<Long, Map<String, INode>>newHashMap();
  
  protected Map<String, String> mapResultTo = CollectionLiterals.<String, String>newHashMap();
  
  public AbstractDictRuleObj(final Node node, final IParserDriver driver) {
    this.node = node;
    this.name = node.get(Neo4jConstants._NAME).asString();
    this.driver = driver;
    this.label = this.internalGetLabelFromNode();
    this.attributes = this.internalGetAttrFromNode();
    this.ID = this.internalGetIdFromNode(node);
  }
  
  protected Map<String, Object> internalGetAttrFromNode() {
    Map<String, Object> _asMap = this.node.asMap();
    return new HashMap<String, Object>(_asMap);
  }
  
  protected String internalGetLabelFromNode() {
    String _xblockexpression = null;
    {
      Iterable<String> result = this.node.labels();
      final Iterable<String> _converted_result = (Iterable<String>)result;
      _xblockexpression = ((String[])Conversions.unwrapArray(_converted_result, String.class))[0];
    }
    return _xblockexpression;
  }
  
  protected long internalGetIdFromNode(final Node node) {
    return node.id();
  }
  
  @Override
  public Node getNodeRef() {
    return this.node;
  }
  
  @Override
  public void setNodeRef(final Node node) {
    this.node = node;
  }
  
  @Override
  public boolean hasLabel(final Node node, final String name) {
    Iterable<String> _labels = node.labels();
    for (final String label : _labels) {
      boolean _equals = label.equals(name);
      if (_equals) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Node of Class:(");
    Class<? extends AbstractDictRuleObj> _class = this.getClass();
    _builder.append(_class);
    _builder.append("), ");
    _builder.newLineIfNotEmpty();
    _builder.append("Labels:(");
    _builder.append(this.label);
    _builder.append("), Attributes:(");
    String _string = this.attributes.toString();
    _builder.append(_string);
    _builder.append(")");
    return _builder.toString();
  }
  
  @Override
  public List<Record> listAllConnections() {
    List<Record> _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(":");
      _builder.append(this.label);
      _builder.append(")-[");
      _builder.append(Neo4jConstants._LINK);
      _builder.append("]-(");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("WHERE ID(");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(") = ");
      _builder.append(this.ID);
      _builder.newLineIfNotEmpty();
      _builder.append("RETURN ");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(", ");
      _builder.append(Neo4jConstants._TARGET);
      final String query = _builder.toString();
      _xblockexpression = this.driver.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.READ);
    }
    return _xblockexpression;
  }
  
  @Override
  public List<Record> listConnections(final String type) {
    List<Record> _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(":");
      _builder.append(this.label);
      _builder.append(")-[");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(":");
      _builder.append(type);
      _builder.append("]-(");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("WHERE ID(");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(") = ");
      _builder.append(this.ID);
      _builder.newLineIfNotEmpty();
      _builder.append("RETURN ");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(", ");
      _builder.append(Neo4jConstants._TARGET);
      final String query = _builder.toString();
      _xblockexpression = this.driver.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.READ);
    }
    return _xblockexpression;
  }
  
  @Override
  public List<Record> listAllOutputs() {
    List<Record> _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(":");
      _builder.append(this.label);
      _builder.append(")-[");
      _builder.append(Neo4jConstants._LINK);
      _builder.append("]->(");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("WHERE ID(");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(") = ");
      _builder.append(this.ID);
      _builder.newLineIfNotEmpty();
      _builder.append("RETURN ");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(", ");
      _builder.append(Neo4jConstants._TARGET);
      final String query = _builder.toString();
      _xblockexpression = this.driver.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.READ);
    }
    return _xblockexpression;
  }
  
  @Override
  public List<Record> listAllInputs() {
    List<Record> _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(":");
      _builder.append(this.label);
      _builder.append(")<-[");
      _builder.append(Neo4jConstants._LINK);
      _builder.append("]-(");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("WHERE ID(");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(") = ");
      _builder.append(this.ID);
      _builder.newLineIfNotEmpty();
      _builder.append("RETURN ");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(", ");
      _builder.append(Neo4jConstants._TARGET);
      final String query = _builder.toString();
      _xblockexpression = this.driver.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.READ);
    }
    return _xblockexpression;
  }
  
  @Override
  public long getID() {
    return this.ID;
  }
  
  @Override
  public String getLabel() {
    return this.label;
  }
  
  @Override
  public String getName() {
    return this.name;
  }
  
  @Override
  public INode findNodeAndCreateTarget(final String string, final IFunction1<Object, ?> delegate) {
    INode _xblockexpression = null;
    {
      Object result = delegate.apply(string);
      INode _xifexpression = null;
      if ((result instanceof List)) {
        INode _xblockexpression_1 = null;
        {
          List<Node> nodes = ((List<Node>)result);
          INode _xifexpression_1 = null;
          if (((nodes != null) && (!nodes.isEmpty()))) {
            _xifexpression_1 = this.driver.getNodeById(nodes.get(0));
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public List<Node> findNodeTypeByName(final String type, final String name) {
    List<Node> _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(":");
      _builder.append(type);
      _builder.append(" {");
      _builder.append(Neo4jConstants._ATTR_NAME);
      _builder.append(":\"");
      _builder.append(name);
      _builder.append("\"})");
      _builder.newLineIfNotEmpty();
      _builder.append("RETURN ");
      _builder.append(Neo4jConstants._NODE);
      final String query = _builder.toString();
      final List<Record> records = this.driver.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.READ);
      _xblockexpression = NodeUtil.recordsToNode(records, Neo4jConstants._NODE);
    }
    return _xblockexpression;
  }
  
  @Override
  public List<Node> findLinkedNodeByName(final String string, final String linkType, final Direction dir) {
    List<Node> _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(":");
      _builder.append(this.label);
      _builder.append(" {");
      _builder.append(Neo4jConstants._ATTR_NAME);
      _builder.append(":\"");
      Object _get = this.attributes.get(Neo4jConstants._ATTR_NAME.toString());
      _builder.append(_get);
      _builder.append("\"})");
      CharSequence _generate = new Arrow(null, linkType, dir).generate();
      _builder.append(_generate);
      _builder.append("(");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(" {");
      _builder.append(Neo4jConstants._ATTR_NAME);
      _builder.append(": \"");
      _builder.append(string);
      _builder.append("\"})");
      _builder.newLineIfNotEmpty();
      _builder.append("WHERE ID(");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(") = ");
      _builder.append(this.ID);
      _builder.newLineIfNotEmpty();
      _builder.append("RETURN ");
      _builder.append(Neo4jConstants._TARGET);
      final String query = _builder.toString();
      final List<Record> records = this.driver.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.READ);
      _xblockexpression = NodeUtil.recordsToNode(records, Neo4jConstants._TARGET);
    }
    return _xblockexpression;
  }
  
  protected void createPredicates(final List<Record> outs) {
    this.predicates = CollectionLiterals.<String, List<IPredicate>>newHashMap();
    for (final Record record : outs) {
      {
        Value _get = record.get(Neo4jConstants._LINK.toString());
        RelationshipValue rel = ((RelationshipValue) _get);
        Value _get_1 = record.get(Neo4jConstants._TARGET);
        IPredicate predicate = this.driver.getPredicateFactory().create(rel, this, 
          this.driver.getNodeById(((NodeValue) _get_1).asNode()));
        String type = rel.asRelationship().type().toLowerCase();
        if ((predicate != null)) {
          List<IPredicate> result = this.predicates.get(type);
          if ((result == null)) {
            ArrayList<IPredicate> _arrayList = new ArrayList<IPredicate>();
            result = _arrayList;
          }
          result.add(predicate);
          this.predicates.put(type, result);
        }
      }
    }
  }
  
  protected INode doExecuteTypes(final List<String> types, final BoolOp boolOp) {
    INode _xblockexpression = null;
    {
      INode result = null;
      for (final String connection : types) {
        {
          List<IPredicate> type = this.predicates.get(connection);
          if (((type != null) && (!type.isEmpty()))) {
            result = this.doExecuteType(connection, boolOp, type);
            if ((result != null)) {
              this.setAttribute(connection, result);
            }
            boolean _isTrue = boolOp.isTrue(result);
            if (_isTrue) {
              return boolOp.returnIntermediate(result);
            }
          }
        }
      }
      _xblockexpression = boolOp.returnFinal(result);
    }
    return _xblockexpression;
  }
  
  protected INode doExecuteType(final String type, final BoolOp boolOp, final List<IPredicate> connections) {
    INode _xblockexpression = null;
    {
      INode result = null;
      if (((this.negativeFilter != null) && this.negativeFilter.contains(type))) {
        return null;
      }
      List<IPredicate> _elvis = null;
      if (connections != null) {
        _elvis = connections;
      } else {
        List<IPredicate> _emptyList = Collections.<IPredicate>emptyList();
        _elvis = _emptyList;
      }
      for (final IPredicate predicate : _elvis) {
        {
          result = predicate.execute();
          boolean _isTrue = boolOp.isTrue(result);
          if (_isTrue) {
            return boolOp.returnIntermediate(result);
          }
        }
      }
      _xblockexpression = boolOp.returnFinal(result);
    }
    return _xblockexpression;
  }
  
  @Override
  public void setFilter(final String filter) {
    ArrayList<String> _arrayList = new ArrayList<String>();
    this.negativeFilter = _arrayList;
    ArrayList<String> _arrayList_1 = new ArrayList<String>();
    this.positiveFilter = _arrayList_1;
    String[] _split = filter.split(NodeConstants._KOMMA_SEP_FILTER);
    for (final String element : _split) {
      boolean _startsWith = element.startsWith(NodeConstants._NEGATIVE_FILTER);
      if (_startsWith) {
        this.negativeFilter.add(element.substring(1));
      } else {
        this.positiveFilter.add(element);
      }
    }
  }
  
  public INode executeQuery(final String query, final IParserDriver driver) {
    INode _xblockexpression = null;
    {
      List<Node> nodes = NodeUtil.recordsToNode(driver.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.WRITE), Neo4jConstants._TARGET);
      INode _xifexpression = null;
      if (((nodes != null) && (!nodes.isEmpty()))) {
        _xifexpression = driver.getNodeById(nodes.get(0));
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * Wrapper function that unifies common tasks for next and previous by calling designated delegate from predicate method
   */
  public INode wrappedWalker(final INode node, final Function1<INode, Object> preSolveDelegate, final Function1<INode, Object> postSolveDelegate, final String filter) {
    this.init();
    final Object contextS = node.getAttribute(Neo4jConstants._TOKEN);
    if ((contextS == null)) {
      return null;
    }
    Object _apply = null;
    if (preSolveDelegate!=null) {
      _apply=preSolveDelegate.apply(node);
    }
    final Object target = _apply;
    if ((target == null)) {
      return null;
    }
    if ((target instanceof IGrammarItem)) {
      this.setAttribute(Neo4jConstants._TOKEN, target);
      this.setAttribute(Neo4jConstants._NODE, this.driver.getNodeById(((IGrammarItem)target).getBaseNode()));
    }
    if ((filter != null)) {
      this.setFilter(filter);
    }
    final INode res = this.solve();
    if (postSolveDelegate!=null) {
      postSolveDelegate.apply(node);
    }
    return res;
  }
  
  @Override
  public IParserDriver getDriver() {
    return this.driver;
  }
  
  @Override
  public abstract INode solve();
  
  @Override
  public Map<Long, Map<String, INode>> getChildren() {
    return this.children;
  }
}
