package org.xixum.nlx.view.fxviews.semantics.types;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.constants.Direction;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;

@SuppressWarnings("all")
public class ForwardType extends AbstractGrammarType implements IForwardLinkable {
  private Direction direction;

  private Node forwardType;

  private ITypeAttributes attribs;

  private ITypeAttributes typesIntersect;

  public ForwardType(final ILinkable parent, final Direction direction, final Node forwardType) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field type is undefined for the type ILinkable"
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
