package org.xixum.nlx.dictionary.type;

import java.util.Collection;
import java.util.List;
import org.xixum.nlx.dictionary.type.elements.INodeEL;
import org.xixum.nlx.dictionary.type.elements.IRelationshipEL;

@SuppressWarnings("all")
public class InterpunctionTypeAttribute implements ITypeAttributes {
  private /* Node */Object source;

  private String interpunction;

  private String type;

  public InterpunctionTypeAttribute(final /* Node */Object source, final String interpunction, final String type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field InterpunctionTypeAttribute.source refers to the missing type Node");
  }

  public InterpunctionTypeAttribute(final String interpunction, final String type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor InterpunctionTypeAttribute(Node, String, String) refers to the missing type Node");
  }

  public String getType() {
    return this.type;
  }

  @Override
  public Node getBaseNode() {
    return null;
  }

  @Deprecated
  @Override
  public Object getAttrs() {
    return this.interpunction;
  }

  @Deprecated
  @Override
  public /* List<Node> */Object getSource() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field InterpunctionTypeAttribute.source refers to the missing type Node");
  }

  @Deprecated
  @Override
  public /* List<Node> */Object getTarget() {
    return null;
  }

  @Override
  public void merge(final ITypeAttributes attributes) {
  }

  @Override
  public Collection<? extends INodeEL> getSourceEL() {
    return null;
  }

  @Override
  public Collection<? extends INodeEL> getTargetEL() {
    return null;
  }

  @Override
  public Collection<? extends IRelationshipEL> getAttrsEL() {
    return null;
  }
}
