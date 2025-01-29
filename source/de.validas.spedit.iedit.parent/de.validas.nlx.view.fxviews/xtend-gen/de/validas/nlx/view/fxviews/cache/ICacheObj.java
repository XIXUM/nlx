package de.validas.nlx.view.fxviews.cache;

import java.util.Collection;
import javax.annotation.Generated;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface ICacheObj {
  public abstract void setOutLink(final ICacheObj obj);
  
  public abstract void setInLink(final ICacheObj obj);
  
  public abstract Collection<ICacheObj> getOutLinks();
  
  public abstract Collection<ICacheObj> getInLinks();
  
  public abstract Node getNode();
  
  public abstract Record getRecord();
  
  public abstract String getName();
  
  public abstract boolean hasAttrs(final String string);
}
