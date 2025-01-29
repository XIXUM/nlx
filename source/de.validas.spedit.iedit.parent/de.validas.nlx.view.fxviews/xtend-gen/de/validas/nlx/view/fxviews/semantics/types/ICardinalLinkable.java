/**
 * @author: Felix Schaller
 */
package de.validas.nlx.view.fxviews.semantics.types;

import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.utils.data.types.XPair;
import javax.annotation.Generated;

/**
 * extends ILinkable for cardinal type forwarding
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface ICardinalLinkable extends ILinkable {
  public abstract ILinkable getBaseType();
  
  public abstract XPair<String, ILinkable> getStart();
  
  public abstract XPair<String, ILinkable> getEnd();
}
