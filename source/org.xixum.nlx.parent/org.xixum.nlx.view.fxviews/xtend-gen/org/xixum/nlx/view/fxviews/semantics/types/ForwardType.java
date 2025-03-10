package org.xixum.nlx.view.fxviews.semantics.types;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.constants.Direction;
import org.xixum.nlx.dictionary.type.ITypeAttributes;

@SuppressWarnings("all")
public class ForwardType extends AbstractGrammarType implements IForwardLinkable {
  private Direction direction;

  private Node forwardType;

  private ITypeAttributes attribs;

  private ITypeAttributes typesIntersect;

  public ForwardType(final /* ILinkable */Object parent, final Direction direction, final Node forwardType) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractGrammarType.parent refers to the missing type Object"
      + "\ntype cannot be resolved"
      + "\nvalue cannot be resolved");
  }

  @Override
  public Direction getDirection() {
    return this.direction;
  }

  @Override
  public Node getForwarType() {
    return this.forwardType;
  }
}
