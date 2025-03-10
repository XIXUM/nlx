package org.xixum.nlx.dictionary.type;

import java.util.Collection;
import java.util.List;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.dictionary.type.elements.INodeEL;
import org.xixum.nlx.dictionary.type.elements.IRelationshipEL;

@SuppressWarnings("all")
public class NoneTypeAttributes implements ITypeAttributes {
  @Override
  public Node getBaseNode() {
    return null;
  }

  @Override
  public Object getAttrs() {
    return null;
  }

  @Override
  public List<Node> getSource() {
    return null;
  }

  @Override
  public List<Node> getTarget() {
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
