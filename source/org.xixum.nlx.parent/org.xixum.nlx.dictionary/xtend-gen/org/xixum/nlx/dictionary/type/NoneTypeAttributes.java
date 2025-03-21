package org.xixum.nlx.dictionary.type;

import java.util.Collection;
import java.util.List;
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
  public /* List<Node> */Object getSource() {
    return null;
  }

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
