package de.validas.nlx.dictionary.grammar.factories;

import de.validas.nlx.ai.IContextFactory;
import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.IContextNode;
import de.validas.nlx.dictionary.grammar.nodes.ContextNode;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class ContextFactory implements IContextFactory {
  @Override
  public IContextNode create(final IParserDriver driver) {
    return new ContextNode(driver);
  }
}
