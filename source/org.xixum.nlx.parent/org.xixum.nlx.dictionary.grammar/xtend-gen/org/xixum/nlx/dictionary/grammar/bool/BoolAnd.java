package org.xixum.nlx.dictionary.grammar.bool;

import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public class BoolAnd extends BoolOp {
  @Override
  public boolean isTrue(final INode node) {
    return (node == null);
  }

  @Override
  public INode returnFinal(final INode node) {
    return node;
  }

  @Override
  public INode returnIntermediate(final INode node) {
    return null;
  }
}
