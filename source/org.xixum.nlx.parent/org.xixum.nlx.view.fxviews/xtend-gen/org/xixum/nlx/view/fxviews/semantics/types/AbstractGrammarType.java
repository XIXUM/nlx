package org.xixum.nlx.view.fxviews.semantics.types;

import java.util.List;
import java.util.Map;
import org.xixum.nlx.dictionary.grammar.types.IGrammarType;
import org.xixum.nlx.view.fxviews.semantics.ILink;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.views.IPanelContainer;

@SuppressWarnings("all")
public class AbstractGrammarType implements ILinkable {
  protected ILinkable parent;

  @Override
  public IPanelContainer getCanvas() {
    return this.parent.getCanvas();
  }

  @Override
  public int getHigherBound() {
    return 0;
  }

  @Override
  public List<ILink> getLink() {
    return null;
  }

  @Override
  public IGrammarType getLinkType() {
    return null;
  }

  @Override
  public int getLowerBound() {
    return 0;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public Object getType() {
    return null;
  }

  @Override
  public Object getTypes() {
    return null;
  }

  @Override
  public int getCardinality() {
    return 0;
  }

  @Override
  public Map<? extends String, ?> getIntermediate() {
    return this.parent.getIntermediate();
  }

  @Override
  public void setLink(final String type, final ILink link) {
  }
}
