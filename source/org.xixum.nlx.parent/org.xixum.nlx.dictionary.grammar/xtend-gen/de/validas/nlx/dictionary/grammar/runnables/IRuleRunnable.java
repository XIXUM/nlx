package de.validas.nlx.dictionary.grammar.runnables;

import de.validas.nlx.ai.semantics.INode;
import java.util.Map;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IRuleRunnable {
  public abstract void run();
  
  public abstract void start();
  
  public abstract Map<Integer, INode> getResult();
}
