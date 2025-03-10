package org.xixum.nlx.ai;

import org.xixum.nlx.ai.semantics.IContextNode;

@SuppressWarnings("all")
public interface IContextFactory {
  IContextNode create(final IParserDriver driver);
}
