package de.validas.nlx.ai;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.IContextNode;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IContextFactory {
  public abstract IContextNode create(final IParserDriver driver);
}
