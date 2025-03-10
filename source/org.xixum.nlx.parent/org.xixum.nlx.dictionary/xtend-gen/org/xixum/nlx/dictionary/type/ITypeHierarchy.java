package org.xixum.nlx.dictionary.type;

import java.util.List;

@SuppressWarnings("all")
public interface ITypeHierarchy {
  String getType();

  List<ITypeHierarchy> getChildren();
}
