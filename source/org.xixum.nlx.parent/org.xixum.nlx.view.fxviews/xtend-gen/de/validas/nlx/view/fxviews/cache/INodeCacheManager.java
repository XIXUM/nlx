package de.validas.nlx.view.fxviews.cache;

import de.validas.nlx.view.fxviews.cache.CachedLink;
import de.validas.nlx.view.fxviews.cache.ICacheObj;
import javax.annotation.Generated;
import org.neo4j.driver.v1.Record;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface INodeCacheManager {
  @Deprecated
  public abstract ICacheObj getNode(final String name, final String label, final Record rec, final String varSelect);
  
  public abstract ICacheObj addNode(final String name, final String label, final Record rec, final String varSelect);
  
  public abstract void addLink(final ICacheObj start, final ICacheObj end, final CachedLink link);
  
  public abstract ICacheObj getNodeByName(final String string);
}
