package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.IContextNode;
import de.validas.nlx.dictionary.grammar.nodes.AbstractNode;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class ContextNode extends AbstractNode implements IContextNode {
  private IParserDriver driver;
  
  public ContextNode(final IParserDriver driver) {
    this.driver = driver;
  }
}
