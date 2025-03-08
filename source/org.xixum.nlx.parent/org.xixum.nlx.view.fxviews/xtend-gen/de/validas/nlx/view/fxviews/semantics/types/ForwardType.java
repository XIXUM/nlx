package de.validas.nlx.view.fxviews.semantics.types;

import de.validas.nlx.constants.Direction;
import de.validas.nlx.dictionary.constants.AttributeSet;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.dictionary.type.LinkTypeAttribute;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.semantics.types.AbstractGrammarType;
import de.validas.nlx.view.fxviews.semantics.types.IForwardLinkable;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
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
