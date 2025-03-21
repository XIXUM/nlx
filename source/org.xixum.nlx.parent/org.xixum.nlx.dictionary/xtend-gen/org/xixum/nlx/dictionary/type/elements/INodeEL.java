package org.xixum.nlx.dictionary.type.elements;

import java.util.List;

@SuppressWarnings("all")
public interface INodeEL extends INetworkEL {
  /* Node */Object getNode();

  boolean addRel(final IRelationshipEL rel);

  boolean addAllRels(final List<IRelationshipEL> relationships);

  List<IRelationshipEL> getRelationship(final /* Direction */Object set);
}
