package org.xixum.nlx.dictionary.type.elements;

import java.util.Map;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
public class RelationshipEL extends NetworkEL implements IRelationshipEL {
  private Relationship relation;

  private INodeEL startN;

  private INodeEL endN;

  private RelationshipEL(final INodeEL start, final INodeEL end, final Relationship rel) {
    this.startN = start;
    this.endN = end;
    this.relation = rel;
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
  public Relationship getRelationship() {
    return this.relation;
  }

  public static IRelationshipEL create(final INodeEL start, final INodeEL end, final Relationship rel) {
    RelationshipEL _xblockexpression = null;
    {
      RelationshipEL instance = new RelationshipEL(start, end, rel);
      INodeEL _start = instance.getStart();
      if (_start!=null) {
        _start.addRel(instance);
      }
      INodeEL _end = instance.getEnd();
      if (_end!=null) {
        _end.addRel(instance);
      }
      _xblockexpression = instance;
    }
    return _xblockexpression;
  }

  @Override
  public long getID() {
    return this.relation.id();
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
    StringConcatenation _builder = new StringConcatenation();
    String _type = this.relation.type();
    _builder.append(_type);
    _builder.append(" | ");
    Map<String, Object> _asMap = this.relation.asMap();
    _builder.append(_asMap);
    return _builder.toString();
  }
}
