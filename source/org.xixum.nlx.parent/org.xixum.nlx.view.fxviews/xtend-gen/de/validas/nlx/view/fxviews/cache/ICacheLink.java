package de.validas.nlx.view.fxviews.cache;

import de.validas.nlx.view.fxviews.cache.ICacheObj;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface ICacheLink extends ICacheObj {
  public abstract ICacheObj getOutLink();
  
  public abstract ICacheObj getInLink();
  
  public abstract String getAttrs();
}
