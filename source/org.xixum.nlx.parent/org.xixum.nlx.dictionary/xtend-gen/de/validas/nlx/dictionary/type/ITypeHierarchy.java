package de.validas.nlx.dictionary.type;

import java.util.List;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface ITypeHierarchy {
  public abstract String getType();
  
  public abstract List<ITypeHierarchy> getChildren();
}
