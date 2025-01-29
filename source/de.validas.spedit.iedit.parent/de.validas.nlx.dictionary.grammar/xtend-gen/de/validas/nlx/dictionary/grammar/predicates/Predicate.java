/**
 * AbstractDictRuleObj - Base Obj for Abstract dictionary rules
 * (c) 2020 licensed under Apache Public License 2.0
 * www.felixschaller.com
 * @author Felix Schaller
 */
package de.validas.nlx.dictionary.grammar.predicates;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.validas.nlx.ai.IDbAccess;
import de.validas.nlx.ai.neo4j.Neo4jAccess;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.ai.semantics.IPredicate;
import de.validas.nlx.ai.util.Arrow;
import de.validas.nlx.constants.Direction;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.constants.PredicateConstants;
import de.validas.nlx.dictionary.grammar.nodes.IDictNode;
import de.validas.nlx.dictionary.grammar.nodes.ValidateNode;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.internal.value.NullValue;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public abstract class Predicate implements IPredicate {
  private static final boolean DEBUG = false;
  
  protected static final List<String> requiredTense = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(PredicateConstants.WITH_));
  
  protected static final List<String> requiredSubClass = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(PredicateConstants.WITH_, PredicateConstants.GET_TARGET_));
  
  protected static final List<String> requiredConjugation = IterableExtensions.<String>toList(Iterables.<String>concat(Predicate.requiredTense, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(PredicateConstants.GET_SOURCE_, PredicateConstants.GET_TARGET_))));
  
  protected static final List<String> requiredBaseForm = Predicate.requiredConjugation;
  
  protected Relationship relation;
  
  protected NodeValue target;
  
  protected IDbAccess dbAccessor;
  
  protected INode nodeStart;
  
  protected INode nodeEnd;
  
  protected INode errorNode;
  
  protected String name;
  
  protected static final Map<String, List<String>> validationType = Collections.<String, List<String>>unmodifiableMap(CollectionLiterals.<String, List<String>>newHashMap(Pair.<String, List<String>>of(PredicateConstants.CONJUGATION_, Predicate.requiredConjugation), Pair.<String, List<String>>of(PredicateConstants.TENSE_, Predicate.requiredTense), Pair.<String, List<String>>of(PredicateConstants.SUB_CLASS_OF_, Predicate.requiredSubClass), Pair.<String, List<String>>of(PredicateConstants.BASE_FORM_, Predicate.requiredBaseForm), Pair.<String, List<String>>of(PredicateConstants.PRECEED_BY_, Predicate.requiredTense)));
  
  public Predicate(final Relationship relation, final INode nodeStart, final INode nodeEnd, final IDbAccess dbAccessor, final String name) {
    this.relation = relation;
    this.dbAccessor = dbAccessor;
    this.nodeStart = nodeStart;
    this.nodeEnd = nodeEnd;
    this.name = name;
  }
  
  @Override
  public abstract INode execute();
  
  public boolean isRelated(final long s, final long e, final String type) {
    boolean _xblockexpression = false;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(")");
      CharSequence _generate = new Arrow(null, type, Direction.RIGHT).generate();
      _builder.append(_generate);
      _builder.append("(");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(") WHERE ID(");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(") = ");
      _builder.append(s);
      _builder.append(" AND ID(");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(") = ");
      _builder.append(e);
      _builder.newLineIfNotEmpty();
      _builder.append("Return ");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(",");
      _builder.append(Neo4jConstants._TARGET);
      final String query = _builder.toString();
      List<Record> records = this.readDB(query);
      if (((records != null) && (!records.isEmpty()))) {
        return true;
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public INode doLinkTo(final String asType) {
    INode _xblockexpression = null;
    {
      this.errorNode = null;
      List<String> _get = Predicate.validationType.get(asType);
      ValidateNode nodeValidator = new ValidateNode(this.nodeStart, this.nodeEnd, _get);
      HashMap<String, INode> connections = nodeValidator.validate();
      boolean _hasAnnotation = nodeValidator.hasAnnotation();
      if (_hasAnnotation) {
        return nodeValidator.getAnnotation();
      }
      INode source = connections.get(PredicateConstants.GET_SOURCE_);
      INode target = connections.get(PredicateConstants.GET_TARGET_);
      INode with = connections.get(PredicateConstants.WITH_);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(") WHERE ID(");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(") = {0}");
      _builder.newLineIfNotEmpty();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(") WHERE ID(");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(") = {1}");
      _builder.newLineIfNotEmpty();
      _builder.append("MERGE (");
      _builder.append(Neo4jConstants._NODE);
      _builder.append(")");
      CharSequence _generate = new Arrow(Neo4jConstants._LINK, asType, Direction.RIGHT).generate();
      _builder.append(_generate);
      _builder.append("(");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("Return ");
      _builder.append(Neo4jConstants._LINK);
      final String rawQuery = _builder.toString();
      INode _switchResult = null;
      boolean _matched = false;
      if (Objects.equal(asType, PredicateConstants.BASE_FORM_)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(asType, PredicateConstants.CONJUGATION_)) {
          _matched=true;
        }
      }
      if (_matched) {
        INode _xblockexpression_1 = null;
        {
          if (((source != null) && (target != null))) {
            boolean _equals = source.equals(with);
            if (_equals) {
              boolean _isRelated = this.isRelated(source.getID(), target.getID(), asType);
              boolean _not = (!_isRelated);
              if (_not) {
                final String query = MessageFormat.format(rawQuery, Long.valueOf(with.getID()).toString(), Long.valueOf(target.getID()).toString());
                List<Record> records = this.writeDB(query);
                this.logResult(records);
              }
            }
          }
          _xblockexpression_1 = this.nodeEnd;
        }
        _switchResult = _xblockexpression_1;
      }
      if (!_matched) {
        if (Objects.equal(asType, PredicateConstants.TENSE_)) {
          _matched=true;
          INode _xblockexpression_2 = null;
          {
            long end = this.nodeEnd.getID();
            boolean _isRelated = this.isRelated(with.getID(), end, asType);
            boolean _not = (!_isRelated);
            if (_not) {
              final String query = MessageFormat.format(rawQuery, Long.valueOf(with.getID()).toString(), Long.valueOf(end).toString());
              List<Record> records = this.writeDB(query);
              this.logResult(records);
            }
            _xblockexpression_2 = this.nodeEnd;
          }
          _switchResult = _xblockexpression_2;
        }
      }
      if (!_matched) {
        if (Objects.equal(asType, PredicateConstants.SUB_CLASS_OF_)) {
          _matched=true;
          INode _xblockexpression_3 = null;
          {
            if ((target != null)) {
              final long end = this.nodeEnd.getID();
              boolean _isRelated = this.isRelated(target.getID(), end, asType);
              boolean _not = (!_isRelated);
              if (_not) {
                final String query = MessageFormat.format(rawQuery, Long.valueOf(target.getID()).toString(), Long.valueOf(end).toString());
                List<Record> records = this.writeDB(query);
                this.logResult(records);
              }
            }
            _xblockexpression_3 = this.nodeEnd;
          }
          _switchResult = _xblockexpression_3;
        }
      }
      if (!_matched) {
        if (Objects.equal(asType, PredicateConstants.PRECEED_BY_)) {
          _matched=true;
          INode _xblockexpression_4 = null;
          {
            if ((with != null)) {
              final Object end = this.nodeEnd.getAttribute(PredicateConstants.RESULT_);
              if ((end instanceof IDictNode)) {
                boolean _isRelated = this.isRelated(with.getID(), ((IDictNode)end).getID(), asType);
                boolean _not = (!_isRelated);
                if (_not) {
                  final String query = MessageFormat.format(rawQuery, Long.valueOf(with.getID()).toString(), Long.valueOf(((IDictNode)end).getID()).toString());
                  List<Record> records = this.writeDB(query);
                  this.logResult(records);
                }
              }
            }
            _xblockexpression_4 = this.nodeEnd;
          }
          _switchResult = _xblockexpression_4;
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public void logResult(final List<Record> records) {
    List<Record> _elvis = null;
    if (records != null) {
      _elvis = records;
    } else {
      List<Record> _emptyList = Collections.<Record>emptyList();
      _elvis = _emptyList;
    }
    for (final Record record : _elvis) {
      {
        final Value param = record.get(Neo4jConstants._LINK);
        if ((param instanceof RelationshipValue)) {
          this.logIt(((RelationshipValue) param).asRelationship());
        }
        if ((param instanceof NullValue)) {
          this.logIt(null);
        }
      }
    }
  }
  
  public List<Record> writeDB(final String query) {
    List<Record> _xifexpression = null;
    if ((!Predicate.DEBUG)) {
      _xifexpression = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.WRITE);
    } else {
      Object _xblockexpression = null;
      {
        this.nodeStart.getDriver().getLogger().log(query);
        _xblockexpression = null;
      }
      _xifexpression = ((List<Record>)_xblockexpression);
    }
    return _xifexpression;
  }
  
  public List<Record> readDB(final String query) {
    return this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.READ);
  }
  
  protected void logIt(final Relationship rel) {
    if ((rel != null)) {
      IBuildLogger _logger = this.nodeStart.getDriver().getLogger();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Connection created:");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("START:  ");
      Object _attribute = this.nodeStart.getAttribute(PredicateConstants.NAME_);
      _builder.append(_attribute, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("with: ");
      Object _attribute_1 = this.nodeStart.getAttribute(PredicateConstants.WITH_);
      _builder.append(_attribute_1, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("getSource: ");
      Object _attribute_2 = this.nodeStart.getAttribute(PredicateConstants.GET_SOURCE_);
      _builder.append(_attribute_2, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("getTarget: ");
      Object _attribute_3 = this.nodeStart.getAttribute(PredicateConstants.GET_TARGET_);
      _builder.append(_attribute_3, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("Node: ");
      Object _attribute_4 = this.nodeEnd.getAttribute(Neo4jConstants._NODE);
      _builder.append(_attribute_4, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("-");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("[Connection ID: ");
      long _id = rel.id();
      _builder.append(_id, "\t\t");
      _builder.append(" , Type: ");
      String _type = rel.type();
      _builder.append(_type, "\t\t");
      _builder.append("]");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("->");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("END: ");
      Object _attribute_5 = this.nodeEnd.getAttribute(PredicateConstants.NAME_);
      _builder.append(_attribute_5, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("with: ");
      Object _attribute_6 = this.nodeStart.getAttribute(PredicateConstants.WITH_);
      _builder.append(_attribute_6, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("getSource: ");
      Object _attribute_7 = this.nodeStart.getAttribute(PredicateConstants.GET_SOURCE_);
      _builder.append(_attribute_7, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("getTarget: ");
      Object _attribute_8 = this.nodeStart.getAttribute(PredicateConstants.GET_TARGET_);
      _builder.append(_attribute_8, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("Node: ");
      Object _attribute_9 = this.nodeEnd.getAttribute(Neo4jConstants._NODE);
      _builder.append(_attribute_9, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("Debug:");
      _builder.append(Predicate.DEBUG, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("---------------------------------------------------------------");
      _logger.log(_builder);
    } else {
      IBuildLogger _logger_1 = this.nodeStart.getDriver().getLogger();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Connection \'null\' cannot be created!");
      _logger_1.log(_builder_1);
    }
  }
}
