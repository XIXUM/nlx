package org.xixum.nlx.view.fxviews.semantics.types;

import org.xixum.nlx.view.fxviews.semantics.ILinkable;

@SuppressWarnings("all")
public class CompoundType extends LiteralType {
  public CompoundType(final String name, final ILinkable parent) {
    super(name, parent);
  }

  @Override
  public XPair getBaseType() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field types is undefined for the type ILinkable"
      + "\nThe method or field panelChain is undefined for the type ContainerPanel"
      + "\nThe method or field type is undefined for the type ILinkObj"
      + "\nThe method or field panelChain is undefined for the type ContainerPanel"
      + "\n!== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n> cannot be resolved"
      + "\nget cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n<= cannot be resolved"
      + "\nget cannot be resolved"
      + "\nget cannot be resolved"
      + "\ntype cannot be resolved");
  }
}
