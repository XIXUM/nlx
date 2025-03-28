package org.xixum.nlx.dictionary.type.elements;

import java.util.List;

@SuppressWarnings("all")
public class NodeEL extends NetworkEL implements INodeEL {
  protected /* Node */Object node;

  protected List<IRelationshipEL> relsIN;

  protected List<IRelationshipEL> relsOUT;

  public NodeEL(final /* Node */Object node, final List<IRelationshipEL> rels) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field NodeEL.node refers to the missing type Node");
  }

  public NodeEL(final /* Node */Object node) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field NodeEL.node refers to the missing type Node");
  }

  @Override
  public /* Node */Object getNode() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field NodeEL.node refers to the missing type Node");
  }

  @Override
  public boolean addAllRels(final List<IRelationshipEL> relationships) {
    boolean _xblockexpression = false;
    {
      boolean success = true;
      for (final IRelationshipEL rel : relationships) {
        {
          boolean respond = this.addRel(rel);
          if (success) {
            success = respond;
          }
        }
      }
      _xblockexpression = success;
    }
    return _xblockexpression;
  }

  @Override
  public List<IRelationshipEL> getRelationship(final /* Direction */Object set) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field IN is undefined"
      + "\nThe method or field OUT is undefined"
      + "\nThe method or field ALL is undefined");
  }

  @Override
  public boolean addRel(final IRelationshipEL rel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getRelationship() from the type IRelationshipEL refers to the missing type Relationship"
      + "\nThe method getRelationship() from the type IRelationshipEL refers to the missing type Relationship"
      + "\nThe field NodeEL.node refers to the missing type Node"
      + "\nendNodeId cannot be resolved"
      + "\nstartNodeId cannot be resolved"
      + "\nid cannot be resolved"
      + "\nequals cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nequals cannot be resolved"
      + "\n&& cannot be resolved");
  }

  @Override
  public long getID() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field NodeEL.node refers to the missing type Node"
      + "\nid cannot be resolved");
  }

  @Override
  public void mergeRel(final INetworkEL el) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Direction is undefined"
      + "\nThe method getRelationship(Direction) from the type NodeEL refers to the missing type Direction"
      + "\nALL cannot be resolved");
  }

  @Override
  public String toString() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field NodeEL.node refers to the missing type Node"
      + "\nThe field NodeEL.node refers to the missing type Node"
      + "\nlabels cannot be resolved"
      + "\nasMap cannot be resolved");
  }
}
