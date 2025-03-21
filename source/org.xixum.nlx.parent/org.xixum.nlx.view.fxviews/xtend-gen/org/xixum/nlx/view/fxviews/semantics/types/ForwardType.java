package org.xixum.nlx.view.fxviews.semantics.types;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.constants.Direction;
import org.xixum.nlx.dictionary.constants.AttributeSet;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.LinkTypeAttribute;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;

@SuppressWarnings("all")
public class ForwardType extends AbstractGrammarType implements IForwardLinkable {
  private Direction direction;

  private Node forwardType;

  private ITypeAttributes attribs;

  private ITypeAttributes typesIntersect;

  public ForwardType(final ILinkable parent, final Direction direction, final Node forwardType) {
    this.parent = parent;
    this.direction = direction;
    this.forwardType = forwardType;
    this.attribs = parent.getType().getValue();
    Node baseN = ((LinkTypeAttribute) this.attribs).getParent(AttributeSet.START).getBaseNode();
    this.typesIntersect = ((LinkTypeAttribute) this.attribs).intersection(baseN, true, false);
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
