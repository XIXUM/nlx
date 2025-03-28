package org.xixum.nlx.view.fxviews.semantics.types;

import org.xixum.nlx.dictionary.grammar.token.IGrammarLiteral;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;

@SuppressWarnings("all")
public class LiteralType extends AbstractLinkType implements IGrammarLiteral {
  public LiteralType(final String name, final ILinkable parent) {
    this.name = name;
    this.setParent(parent);
  }

  public /* Node */Object getRoot() {
    return null;
  }

  public void removeType(final TypeElement element) {
  }

  public void update() {
  }
}
