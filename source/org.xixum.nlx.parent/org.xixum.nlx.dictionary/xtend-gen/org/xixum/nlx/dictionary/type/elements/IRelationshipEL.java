package org.xixum.nlx.dictionary.type.elements;

@SuppressWarnings("all")
public interface IRelationshipEL extends INetworkEL {
  INodeEL getStart();

  INodeEL getEnd();

  /* Relationship */Object getRelationship();

  Boolean relink(final NodeEL el);
}
