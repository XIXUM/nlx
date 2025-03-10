package org.xixum.nlx.view.fxviews.semantics;

import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class Intermediate {
  protected EObject element = null;

  protected ILinkContainer container = null;

  protected ILinkType type;

  public Intermediate(final ILinkType type, final EObject element) {
    this.element = element;
    this.type = type;
  }

  public Intermediate(final ILinkContainer container) {
    this.container = container;
  }

  public String generate(final String attr) {
    throw new Error("Unresolved compilation problems:"
      + "\nWordImpl cannot be resolved to a type."
      + "\nExtBracketSentence cannot be resolved to a type."
      + "\nBracketSentence cannot be resolved to a type."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition.");
  }

  public ILinkType getType() {
    return this.type;
  }

  public ILinkContainer getContainer() {
    return this.container;
  }
}
