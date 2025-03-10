package org.xixum.nlx.view.fxviews.semantics.types;

import java.util.Collections;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.view.fxviews.semantics.ILink;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.views.IPanelContainer;

@SuppressWarnings("all")
public class CardinalType extends AbstractGrammarType implements ICardinalLinkable {
  private /* XPair<String, ILinkable> */Object start;

  private /* XPair<String, ILinkable> */Object end;

  private ITypeAttributes attribs;

  private Integer lower;

  private Integer higher;

  private String name;

  private ITypeAttributes typesIntersect;

  private int cardinality;

  public CardinalType(final ILinkable parent, final /* XPair<String, ILinkable> */Object start, final /* XPair<String, ILinkable> */Object end, final ITypeAttributes linkAttribs) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field CardinalType.start refers to the missing type XPair"
      + "\nThe field CardinalType.end refers to the missing type XPair"
      + "\nkey cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\ncardinality cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\ncardinality cannot be resolved");
  }

  @Override
  public IPanelContainer getCanvas() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field CardinalType.start refers to the missing type XPair"
      + "\nvalue cannot be resolved"
      + "\ncanvas cannot be resolved");
  }

  @Override
  public int getHigherBound() {
    return (this.higher).intValue();
  }

  @Override
  public int getLowerBound() {
    return (this.lower).intValue();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Object getType() {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved."
      + "\nThe field CardinalType.start refers to the missing type XPair"
      + "\nkey cannot be resolved");
  }

  @Override
  public Object getTypes() {
    Object _type = this.getType();
    return Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(_type));
  }

  @Override
  public void setLink(final String type, final ILink link) {
  }

  @Override
  public int getCardinality() {
    return this.cardinality;
  }

  @Override
  public Map<? extends String, ?> getIntermediate() {
    return this.parent.getIntermediate();
  }

  @Override
  public Object getBaseType() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field startLink is undefined for the type ILink"
      + "\nThe field CardinalType.start refers to the missing type XPair"
      + "\nvalue cannot be resolved"
      + "\nvalue cannot be resolved");
  }

  @Override
  public Object getStart() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field CardinalType.start refers to the missing type XPair");
  }

  @Override
  public Object getEnd() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field CardinalType.end refers to the missing type XPair");
  }
}
