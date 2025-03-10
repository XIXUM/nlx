package org.xixum.nlx.view.fxviews.cache;

import org.neo4j.driver.v1.Record;

@SuppressWarnings("all")
public interface INodeCacheManager {
  @Deprecated
  ICacheObj getNode(final String name, final String label, final Record rec, final String varSelect);

  ICacheObj addNode(final String name, final String label, final Record rec, final String varSelect);

  void addLink(final ICacheObj start, final ICacheObj end, final CachedLink link);

  ICacheObj getNodeByName(final String string);
}
