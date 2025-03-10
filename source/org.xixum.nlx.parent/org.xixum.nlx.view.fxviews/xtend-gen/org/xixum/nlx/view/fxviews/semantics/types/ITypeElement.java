package org.xixum.nlx.view.fxviews.semantics.types;

import org.xixum.nlx.dictionary.type.ITypeAttributes;

@SuppressWarnings("all")
public interface ITypeElement /* extends IAppendable, IContainable, IIndexable  */{
  ITypeAttributes getTypeAttributes();

  void setTypeAttributes(final ITypeAttributes attrs);
}
