package org.xixum.nlx.dictionary.grammar.factories;

import org.xixum.nlx.ai.IContextFactory;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.IContextNode;
import org.xixum.nlx.dictionary.grammar.nodes.ContextNode;

@SuppressWarnings("all")
public class ContextFactory implements IContextFactory {
  @Override
  public IContextNode create(final IParserDriver driver) {
    return new ContextNode(driver);
  }
}
