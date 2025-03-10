package org.xixum.nlx.dictionary.grammar.nodes;

import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.IContextNode;

@SuppressWarnings("all")
public class ContextNode extends AbstractNode implements IContextNode {
  private IParserDriver driver;

  public ContextNode(final IParserDriver driver) {
    this.driver = driver;
  }
}
