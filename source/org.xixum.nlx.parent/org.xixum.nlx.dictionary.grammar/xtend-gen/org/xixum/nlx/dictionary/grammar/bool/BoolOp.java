package org.xixum.nlx.dictionary.grammar.bool;

import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public abstract class BoolOp {
  public abstract boolean isTrue(final INode node);

  public abstract INode returnFinal(final INode node);

  public abstract INode returnIntermediate(final INode node);
}
