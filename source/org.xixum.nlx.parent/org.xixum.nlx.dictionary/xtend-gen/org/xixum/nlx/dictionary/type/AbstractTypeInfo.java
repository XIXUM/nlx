package org.xixum.nlx.dictionary.type;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("all")
public abstract class AbstractTypeInfo implements ITypeInfo {
  protected /* List<XPair<String, ITypeAttributes>> */Object types;

  protected /* Node */Object baseNode;

  public AbstractTypeInfo(final /* Node */Object node, final HashMap<String, ITypeAttributes> linkTypes) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractTypeInfo.types refers to the missing type XPair"
      + "\nThe field AbstractTypeInfo.baseNode refers to the missing type Node");
  }

  @Override
  public /* List<XPair> */Object getTypes() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractTypeInfo.types refers to the missing type XPair");
  }

  @Override
  public void updateTypes(final HashMap<String, ITypeAttributes> linkTypes) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractTypeInfo.types refers to the missing type XPair");
  }

  @Override
  public void addTypes(final HashMap<String, ITypeAttributes> linkTypes) {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved."
      + "\nThe field AbstractTypeInfo.types refers to the missing type XPair");
  }

  @Override
  public Node getBase() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractTypeInfo.baseNode refers to the missing type Node");
  }
}
