package org.xixum.nlx.dictionary.grammar.nodes.interfaces;

import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public interface IPredicateTARGET {
  INode target(final INode caller);
}
