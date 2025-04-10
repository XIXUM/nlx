/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */
package org.xixum.nlx.view.fxviews.semantics.types;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.dictionary.constants.AttributeSet;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.LinkTypeAttribute;
import org.xixum.nlx.view.fxviews.semantics.ILink;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.semantics.util.LinkUtils;
import org.xixum.nlx.view.fxviews.views.IPanelContainer;
import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public class CardinalType extends AbstractGrammarType implements ICardinalLinkable {
  private XPair<String, ILinkable> start;

  private XPair<String, ILinkable> end;

  private ITypeAttributes attribs;

  private Integer lower;

  private Integer higher;

  private String name;

  private ITypeAttributes typesIntersect;

  private int cardinality;

  public CardinalType(final ILinkable parent, final XPair<String, ILinkable> start, final XPair<String, ILinkable> end, final ITypeAttributes linkAttribs) {
    this.parent = parent;
    this.start = start;
    this.end = end;
    this.attribs = linkAttribs;
    Pair<Integer, Integer> pair = LinkUtils.calculateBounds(start, end);
    this.lower = pair.getKey();
    this.higher = pair.getValue();
    this.name = start.getKey();
    int _max = Math.max(start.getValue().getCardinality(), end.getValue().getCardinality());
    int _plus = (_max + 1);
    this.cardinality = _plus;
    Node baseN = ((LinkTypeAttribute) this.attribs).getParent(AttributeSet.START).getBaseNode();
    this.typesIntersect = ((LinkTypeAttribute) this.attribs).intersection(baseN, true, false);
  }

  @Override
  public IPanelContainer getCanvas() {
    return this.start.getValue().getCanvas();
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
  public XPair<String, ITypeAttributes> getType() {
    String _key = this.start.getKey();
    return new XPair<String, ITypeAttributes>(_key, this.typesIntersect);
  }

  @Override
  public List<XPair<String, ITypeAttributes>> getTypes() {
    XPair<String, ITypeAttributes> _type = this.getType();
    return Collections.<XPair<String, ITypeAttributes>>unmodifiableList(CollectionLiterals.<XPair<String, ITypeAttributes>>newArrayList(_type));
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
  public ILinkable getBaseType() {
    ILinkable _xblockexpression = null;
    {
      ILinkable higher = ((ILink) this.parent).getStartLink().getValue();
      ILinkable _xifexpression = null;
      if (((higher instanceof ILink) && ((ILink) higher).hasCardinalType())) {
        ILinkable _cardinalType = ((ILink) higher).getCardinalType();
        _xifexpression = ((ICardinalLinkable) _cardinalType).getBaseType();
      } else {
        _xifexpression = this.start.getValue();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  @Override
  public XPair<String, ILinkable> getStart() {
    return this.start;
  }

  @Override
  public XPair<String, ILinkable> getEnd() {
    return this.end;
  }
}
