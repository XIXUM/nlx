package de.validas.nlx.dictionary.grammar.token;

import de.validas.nlx.dictionary.grammar.types.IGrammarType;
import de.validas.utils.data.lists.IAppendable;
import de.validas.utils.data.lists.IContainable;
import de.validas.utils.data.lists.IIndexable;
import javax.annotation.Generated;
import org.eclipse.emf.ecore.EObject;
import org.neo4j.driver.v1.types.Node;

/**
 * @author schaller
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IGrammarItem extends IAppendable, IContainable, IIndexable {
  public abstract String getName();
  
  public abstract String getLabel();
  
  public abstract EObject getElement();
  
  public abstract Node getBaseNode();
  
  public abstract long generateID();
  
  public abstract IGrammarType getInternalType();
}
