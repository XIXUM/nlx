package org.xixum.nlx.dictionary.type;

import java.util.Collection;
import java.util.List;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.dictionary.type.elements.INodeEL;
import org.xixum.nlx.dictionary.type.elements.IRelationshipEL;

@SuppressWarnings("all")
public interface ITypeAttributes {
  Node getBaseNode();

  @Deprecated
  Object getAttrs();

  @Deprecated
  List<Node> getSource();

  @Deprecated
  List<Node> getTarget();

  void merge(final ITypeAttributes attributes);

  Collection<? extends INodeEL> getSourceEL();

  Collection<? extends INodeEL> getTargetEL();

  Collection<? extends IRelationshipEL> getAttrsEL();
}
