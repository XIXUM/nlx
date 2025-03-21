package org.xixum.nlx.dictionary.type;

import java.util.List;

@SuppressWarnings("all")
public class TypeHierarchy implements ITypeHierarchy {
  private /* Node */Object node;

  private List<ITypeHierarchy> hierarchy;

  public TypeHierarchy(final /* Node */Object node, final List<ITypeHierarchy> hierarchy) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeHierarchy.node refers to the missing type Node");
  }

  @Override
  public String getType() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field _NAME is undefined"
      + "\nThe field TypeHierarchy.node refers to the missing type Node"
      + "\nget cannot be resolved"
      + "\nasString cannot be resolved");
  }

  @Override
  public List<ITypeHierarchy> getChildren() {
    return this.hierarchy;
  }
}
