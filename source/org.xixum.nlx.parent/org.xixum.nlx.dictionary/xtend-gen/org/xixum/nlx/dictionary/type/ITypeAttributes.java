package org.xixum.nlx.dictionary.type;

import java.util.Collection;
import java.util.List;
import org.xixum.nlx.dictionary.type.elements.INodeEL;
import org.xixum.nlx.dictionary.type.elements.IRelationshipEL;

@SuppressWarnings("all")
public interface ITypeAttributes {
  /* Node */Object getBaseNode();

  @Deprecated
  Object getAttrs();

  @Deprecated
  /* List<Node> */Object getSource();

  @Deprecated
  /* List<Node> */Object getTarget();

  void merge(final ITypeAttributes attributes);

  Collection<? extends INodeEL> getSourceEL();

  Collection<? extends INodeEL> getTargetEL();

  Collection<? extends IRelationshipEL> getAttrsEL();
}
