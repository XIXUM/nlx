/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 * 
 * Node Cache Manager is a interface between Client and Database to cache Inquiries to database to speed up and to avoid calling for redundant calls on the database
 * it acts as a invisible layer between and filters out redundant calls, attempting to query data only once unless modified on the DB.
 */
package org.xixum.nlx.view.fxviews.cache;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.LinkedHashMap;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.v1.Record;

@Singleton
@SuppressWarnings("all")
public class NodeCacheManager implements INodeCacheManager {
  protected LinkedHashMap<String, ICacheObj> nodeMap = CollectionLiterals.<String, ICacheObj>newLinkedHashMap();

  @Inject
  public NodeCacheManager() {
  }

  @Override
  public ICacheObj getNode(final String name, final String label, final Record rec, final String varName) {
    ICacheObj _xifexpression = null;
    boolean _containsKey = this.nodeMap.containsKey(name);
    if (_containsKey) {
      return this.nodeMap.get(name);
    } else {
      _xifexpression = this.addNode(name, label, rec, varName);
    }
    return _xifexpression;
  }

  @Override
  public ICacheObj addNode(final String name, final String label, final Record rec, final String varSelect) {
    ICacheObj _xblockexpression = null;
    {
      ICacheObj cacheNode = new CachedNode(name, label, rec, varSelect);
      ICacheObj old = this.nodeMap.put(name, cacheNode);
      if ((old != null)) {
        Collection<ICacheObj> _inLinks = old.getInLinks();
        for (final ICacheObj link : _inLinks) {
          {
            link.setInLink(cacheNode);
            cacheNode.setInLink(link);
          }
        }
        Collection<ICacheObj> _outLinks = old.getOutLinks();
        for (final ICacheObj link_1 : _outLinks) {
          {
            link_1.setOutLink(cacheNode);
            cacheNode.setOutLink(link_1);
          }
        }
      }
      _xblockexpression = cacheNode;
    }
    return _xblockexpression;
  }

  @Override
  public void addLink(final ICacheObj start, final ICacheObj end, final CachedLink link) {
    link.setInLink(end);
    link.setOutLink(start);
    end.setInLink(link);
    start.setOutLink(link);
  }

  @Override
  public ICacheObj getNodeByName(final String name) {
    Object _xifexpression = null;
    boolean _containsKey = this.nodeMap.containsKey(name);
    if (_containsKey) {
      return this.nodeMap.get(name);
    } else {
      _xifexpression = null;
    }
    return ((ICacheObj)_xifexpression);
  }
}
