package de.validas.nlx.dictionary.grammar.bool;

import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.dictionary.grammar.bool.BoolOp;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class BoolOr extends BoolOp {
  @Override
  public boolean isTrue(final INode node) {
    return (node != null);
  }
  
  @Override
  public INode returnFinal(final INode node) {
    return null;
  }
  
  @Override
  public INode returnIntermediate(final INode node) {
    return node;
  }
}
