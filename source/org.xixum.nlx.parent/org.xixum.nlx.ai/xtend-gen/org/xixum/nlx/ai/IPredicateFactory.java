package org.xixum.nlx.ai;

import org.neo4j.driver.internal.value.RelationshipValue;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.ai.semantics.IPredicate;

@SuppressWarnings("all")
public interface IPredicateFactory {
  IPredicate create(final RelationshipValue value, final INode nodeStart, final INode nodeEnd);
}
