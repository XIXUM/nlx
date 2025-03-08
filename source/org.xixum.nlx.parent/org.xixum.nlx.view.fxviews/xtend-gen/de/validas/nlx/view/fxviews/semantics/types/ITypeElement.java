package de.validas.nlx.view.fxviews.semantics.types;

import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.utils.data.lists.IAppendable;
import de.validas.utils.data.lists.IContainable;
import de.validas.utils.data.lists.IIndexable;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface ITypeElement extends IAppendable, IContainable, IIndexable {
  public abstract ITypeAttributes getTypeAttributes();
  
  public abstract void setTypeAttributes(final ITypeAttributes attrs);
}
