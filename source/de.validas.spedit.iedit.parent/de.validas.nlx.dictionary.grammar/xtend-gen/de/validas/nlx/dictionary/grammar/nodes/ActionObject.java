package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.constants.NodeConstants;
import de.validas.nlx.dictionary.constants.PredicateConstants;
import de.validas.nlx.dictionary.grammar.bool.BoolOr;
import de.validas.nlx.dictionary.grammar.nodes.AbstractActionPredicatedNodeObj;
import de.validas.nlx.dictionary.grammar.nodes.IActionNode;
import de.validas.nlx.dictionary.grammar.nodes.IObjectNode;
import de.validas.nlx.dictionary.grammar.nodes.WordToken;
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateFIND;
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateOF;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class ActionObject extends AbstractActionPredicatedNodeObj implements IObjectNode, IPredicateOF, IPredicateFIND {
  private static final BoolOr boolOr = new BoolOr();
  
  protected final List<String> objectTypes = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(PredicateConstants.OF_, PredicateConstants.GET_NAME_));
  
  public ActionObject(final Node node, final IParserDriver driver) {
    super(node, driver);
  }
  
  @Override
  public INode solve() {
    Object _xblockexpression = null;
    {
      if ((this.predicates == null)) {
        List<Record> outs = this.listAllOutputs();
        this.createPredicates(outs);
      }
      this.doExecuteTypes(this.objectTypes, ActionObject.boolOr);
      Object _xifexpression = null;
      boolean _equals = this.getAttribute(NodeConstants._TYPE).equals(NodeConstants._SHORT_OF);
      if (_equals) {
        Object _xblockexpression_1 = null;
        {
          for (final String attributes : this.objectTypes) {
            Object _attribute = this.getAttribute(attributes);
            boolean _tripleEquals = (_attribute == null);
            if (_tripleEquals) {
              return null;
            }
          }
          Object _attribute_1 = this.getAttribute(PredicateConstants.OF_);
          INode ofType = ((INode) _attribute_1);
          Object _attribute_2 = this.getAttribute(PredicateConstants.GET_NAME_);
          int suffixLength = ((String) _attribute_2).length();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("MATCH (");
          _builder.append(Neo4jConstants._TARGET);
          _builder.append(":Word)-[]->(");
          String _label = ofType.getLabel();
          _builder.append(_label);
          _builder.append("{");
          _builder.append(Neo4jConstants._NAME);
          _builder.append(" : \"");
          Object _attribute_3 = ofType.getAttribute(NodeConstants._ATTR_NAME);
          _builder.append(((String) _attribute_3));
          _builder.append("\"}) ");
          _builder.newLineIfNotEmpty();
          _builder.append("WHERE ");
          _builder.append(Neo4jConstants._TARGET);
          _builder.append(".");
          _builder.append(Neo4jConstants._NAME);
          _builder.append(" = substring(");
          _builder.append(Neo4jConstants._NODE);
          _builder.append(".");
          _builder.append(Neo4jConstants._NAME);
          _builder.append(", 0,size(");
          _builder.append(Neo4jConstants._NODE);
          _builder.append(".");
          _builder.append(Neo4jConstants._NAME);
          _builder.append(")-");
          _builder.append(suffixLength);
          _builder.append(")");
          String result = _builder.toString();
          this.setAttribute(NodeConstants._QUERY, result);
          _xblockexpression_1 = null;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return ((INode)_xblockexpression);
  }
  
  @Override
  public INode of(final INode caller, final Relationship relation) {
    Object _xblockexpression = null;
    {
      caller.setAttribute(relation.type().toLowerCase(), this);
      _xblockexpression = null;
    }
    return ((INode)_xblockexpression);
  }
  
  @Override
  public INode find(final INode caller, final Relationship relation) {
    INode _switchResult = null;
    boolean _matched = false;
    if (caller instanceof IActionNode) {
      _matched=true;
      INode _xblockexpression = null;
      {
        Object _attribute = ((IActionNode)caller).getAttribute(PredicateConstants.WITH_);
        INode wordNode = ((INode) _attribute);
        if ((wordNode == null)) {
          return null;
        }
        this.solve();
        Object _attribute_1 = this.getAttribute(NodeConstants._QUERY);
        String generated = ((String) _attribute_1);
        INode _xifexpression = null;
        if (((generated != null) && (!generated.isEmpty()))) {
          INode _xblockexpression_1 = null;
          {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("MATCH (");
            _builder.append(Neo4jConstants._NODE);
            _builder.append(":");
            _builder.append(NodeConstants._WORD);
            _builder.append(" {");
            _builder.append(Neo4jConstants._NAME);
            _builder.append(":\"");
            String _word = ((WordToken) wordNode).getWord();
            _builder.append(_word);
            _builder.append("\"})");
            _builder.newLineIfNotEmpty();
            Object _attribute_2 = this.getAttribute(NodeConstants._QUERY);
            _builder.append(_attribute_2);
            _builder.newLineIfNotEmpty();
            _builder.append("return ");
            _builder.append(Neo4jConstants._TARGET);
            String query = _builder.toString();
            Object _setAttribute = this.setAttribute(PredicateConstants.WITH_, this.executeQuery(query, this.driver));
            _xblockexpression_1 = ((INode) _setAttribute);
          }
          _xifexpression = _xblockexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      _switchResult = _xblockexpression;
    }
    return _switchResult;
  }
}
