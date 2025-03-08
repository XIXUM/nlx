package de.validas.nlx.dictionary.grammar.bool;

import de.validas.nlx.ai.semantics.INode;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public abstract class BoolOp {
  public abstract boolean isTrue(final INode node);
  
  public abstract INode returnFinal(final INode node);
  
  public abstract INode returnIntermediate(final INode node);
}
