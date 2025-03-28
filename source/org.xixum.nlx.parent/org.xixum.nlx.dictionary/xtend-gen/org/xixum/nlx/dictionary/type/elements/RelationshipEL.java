package org.xixum.nlx.dictionary.type.elements;

@SuppressWarnings("all")
public class RelationshipEL extends NetworkEL implements IRelationshipEL {
  private /* Relationship */Object relation;

  private INodeEL startN;

  private INodeEL endN;

  private RelationshipEL(final INodeEL start, final INodeEL end, final /* Relationship */Object rel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field RelationshipEL.relation refers to the missing type Relationship");
  }

  @Override
  public INodeEL getStart() {
    return this.startN;
  }

  @Override
  public INodeEL getEnd() {
    return this.endN;
  }

  @Override
  public /* Relationship */Object getRelationship() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field RelationshipEL.relation refers to the missing type Relationship");
  }

  public static IRelationshipEL create(final INodeEL start, final INodeEL end, final /* Relationship */Object rel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor RelationshipEL(INodeEL, INodeEL, Relationship) refers to the missing type Relationship");
  }

  @Override
  public long getID() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field RelationshipEL.relation refers to the missing type Relationship"
      + "\nid cannot be resolved");
  }

  @Override
  public Boolean relink(final NodeEL el) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Long.valueOf(this.startN.getID()).equals(Long.valueOf(el.getID()));
      if (_equals) {
        this.startN = el;
      } else {
        boolean _equals_1 = Long.valueOf(this.endN.getID()).equals(Long.valueOf(el.getID()));
        if (_equals_1) {
          this.endN = el;
        } else {
          return Boolean.valueOf(false);
        }
      }
      _xblockexpression = true;
    }
    return Boolean.valueOf(_xblockexpression);
  }

  @Override
  public void mergeRel(final INetworkEL el) {
    if ((el instanceof IRelationshipEL)) {
      return;
    } else {
      throw new UnsupportedOperationException("TODO: auto-generated method stub");
    }
  }

  @Override
  public String toString() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field RelationshipEL.relation refers to the missing type Relationship"
      + "\nThe field RelationshipEL.relation refers to the missing type Relationship"
      + "\ntype cannot be resolved"
      + "\nasMap cannot be resolved");
  }
}
