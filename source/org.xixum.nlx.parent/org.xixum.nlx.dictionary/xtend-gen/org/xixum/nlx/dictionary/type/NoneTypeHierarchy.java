package org.xixum.nlx.dictionary.type;

import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.xixum.nlx.dictionary.constants.NodeConstants;

@SuppressWarnings("all")
public class NoneTypeHierarchy implements ITypeHierarchy {
  @Override
  public String getType() {
    return NodeConstants._NONE;
  }

  @Override
  public List<ITypeHierarchy> getChildren() {
    List<ITypeHierarchy> empty = CollectionLiterals.<ITypeHierarchy>newArrayList();
    return empty;
  }
}
