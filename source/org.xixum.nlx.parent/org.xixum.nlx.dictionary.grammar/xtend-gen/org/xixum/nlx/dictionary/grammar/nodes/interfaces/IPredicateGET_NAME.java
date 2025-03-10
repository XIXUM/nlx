package org.xixum.nlx.dictionary.grammar.nodes.interfaces;

import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public interface IPredicateGET_NAME {
  INode getName(final INode caller, final Relationship relation);
}
