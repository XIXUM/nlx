package org.xixum.nlx.dictionary.type.elements;

import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
public interface IRelationshipEL extends INetworkEL {
  INodeEL getStart();

  INodeEL getEnd();

  Relationship getRelationship();

  Boolean relink(final NodeEL el);
}
