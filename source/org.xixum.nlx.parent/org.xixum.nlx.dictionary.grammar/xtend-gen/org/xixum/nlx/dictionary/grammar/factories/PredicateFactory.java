package org.xixum.nlx.dictionary.grammar.factories;

import org.neo4j.driver.internal.value.RelationshipValue;
import org.xixum.nlx.ai.IDbAccess;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.grammar.predicates.Predicate;

@SuppressWarnings("all")
public class PredicateFactory /* implements IPredicateFactory  */{
  private IDbAccess dbAccessor;

  public PredicateFactory(final IDbAccess access) {
    this.dbAccessor = access;
  }

  @Override
  public Predicate create(final RelationshipValue value, final INode nodeStart, final INode nodeEnd) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PredicateConstants.LINK_INSTANCE_TO_ refers to the missing type Object"
      + "\nThe field PredicateConstants.LINK_TO_ refers to the missing type Object"
      + "\nThe field PredicateConstants.IS_ refers to the missing type Object"
      + "\nThe field PredicateConstants.INSTANCE_OF_ refers to the missing type Object"
      + "\nThe field PredicateConstants.TARGET_ refers to the missing type Object"
      + "\nThe field PredicateConstants.EQUALS_ refers to the missing type Object"
      + "\nThe field PredicateConstants.NEXT_ refers to the missing type Object"
      + "\nThe field PredicateConstants.PREVIOUS_ refers to the missing type Object"
      + "\nThe field PredicateConstants.DO_ refers to the missing type Object"
      + "\nThe field PredicateConstants.ENTER_RULE_ refers to the missing type Object"
      + "\nThe field PredicateConstants.EXTENDS_ refers to the missing type Object"
      + "\nThe field PredicateConstants.GET_TARGET_ refers to the missing type Object"
      + "\nThe field PredicateConstants.GET_SOURCE_ refers to the missing type Object"
      + "\nThe field PredicateConstants.ENDS_WITH_ refers to the missing type Object"
      + "\nThe field PredicateConstants.OF_ refers to the missing type Object"
      + "\nThe field PredicateConstants.GET_NAME_ refers to the missing type Object"
      + "\nThe field PredicateConstants.FIND_ refers to the missing type Object"
      + "\nThe field PredicateConstants.OF_CLASS_ refers to the missing type Object");
  }
}
