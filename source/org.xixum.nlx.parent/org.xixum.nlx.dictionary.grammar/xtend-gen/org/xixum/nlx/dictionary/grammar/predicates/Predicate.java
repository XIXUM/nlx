/**
 * AbstractDictRuleObj - Base Obj for Abstract dictionary rules
 * (c) 2020 licensed under Apache Public License 2.0
 * www.felixschaller.com
 * @author Felix Schaller
 */
package org.xixum.nlx.dictionary.grammar.predicates;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.internal.value.NullValue;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IDbAccess;
import org.xixum.nlx.ai.neo4j.Neo4jAccess;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;

@SuppressWarnings("all")
public abstract class Predicate /* implements IPredicate  */{
  private static final boolean DEBUG = false;

  protected static final List<String> requiredTense /* Skipped initializer because of errors */;

  protected static final List<String> requiredSubClass /* Skipped initializer because of errors */;

  protected static final List<String> requiredConjugation /* Skipped initializer because of errors */;

  protected static final List<String> requiredBaseForm = Predicate.requiredConjugation;

  protected Relationship relation;

  protected NodeValue target;

  protected IDbAccess dbAccessor;

  protected INode nodeStart;

  protected INode nodeEnd;

  protected INode errorNode;

  protected String name;

  protected static final /* Set<Object> */Object validationType /* Skipped initializer because of errors */;

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
    throw new Error("Unresolved compilation problems:"
      + "\nArrow cannot be resolved."
      + "\ngenerate cannot be resolved");
  }

  public INode doLinkTo(final String asType) {
    throw new Error("Unresolved compilation problems:"
      + "\nArrow cannot be resolved."
      + "\nType mismatch: cannot convert from String to int"
      + "\nType mismatch: cannot convert from boolean to List<String>"
      + "\nThe field Predicate.validationType refers to the missing type Object"
      + "\nThe field PredicateConstants.GET_SOURCE_ refers to the missing type Object"
      + "\nThe field PredicateConstants.GET_TARGET_ refers to the missing type Object"
      + "\nThe field PredicateConstants.WITH_ refers to the missing type Object"
      + "\nThe field PredicateConstants.BASE_FORM_ refers to the missing type Object"
      + "\nThe field PredicateConstants.CONJUGATION_ refers to the missing type Object"
      + "\nThe field PredicateConstants.TENSE_ refers to the missing type Object"
      + "\nThe field PredicateConstants.SUB_CLASS_OF_ refers to the missing type Object"
      + "\nThe field PredicateConstants.PRECEED_BY_ refers to the missing type Object"
      + "\nThe field PredicateConstants.RESULT_ refers to the missing type Object"
      + "\ngenerate cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PredicateConstants.NAME_ refers to the missing type Object"
      + "\nThe field PredicateConstants.WITH_ refers to the missing type Object"
      + "\nThe field PredicateConstants.GET_SOURCE_ refers to the missing type Object"
      + "\nThe field PredicateConstants.GET_TARGET_ refers to the missing type Object"
      + "\nThe field PredicateConstants.NAME_ refers to the missing type Object"
      + "\nThe field PredicateConstants.WITH_ refers to the missing type Object"
      + "\nThe field PredicateConstants.GET_SOURCE_ refers to the missing type Object"
      + "\nThe field PredicateConstants.GET_TARGET_ refers to the missing type Object");
  }
}
