package org.xixum.nlx.dictionary.type.elements;

import java.util.List;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.constants.Direction;

@SuppressWarnings("all")
public interface INodeEL extends INetworkEL {
  Node getNode();

  boolean addRel(final IRelationshipEL rel);

  boolean addAllRels(final List<IRelationshipEL> relationships);

  List<IRelationshipEL> getRelationship(final Direction set);
}
