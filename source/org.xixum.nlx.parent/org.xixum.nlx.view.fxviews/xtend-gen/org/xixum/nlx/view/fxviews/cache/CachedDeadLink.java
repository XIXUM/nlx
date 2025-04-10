/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */
package org.xixum.nlx.view.fxviews.cache;

import java.util.Collection;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
public class CachedDeadLink implements ICacheLink {
  protected ICacheObj start;

  protected ICacheObj end;

  public CachedDeadLink(final ICacheObj start, final ICacheObj end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public void setOutLink(final ICacheObj obj) {
    this.start = obj;
  }

  @Override
  public void setInLink(final ICacheObj obj) {
    this.end = obj;
  }

  @Override
  public ICacheObj getOutLink() {
    return this.start;
  }

  @Override
  public ICacheObj getInLink() {
    return this.end;
  }

  @Override
  public Node getNode() {
    return null;
  }

  @Override
  public Record getRecord() {
    return null;
  }

  @Override
  public Collection<ICacheObj> getOutLinks() {
    throw new UnsupportedOperationException("TODO: make unrelative");
  }

  @Override
  public Collection<ICacheObj> getInLinks() {
    throw new UnsupportedOperationException("TODO: make unrelative");
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public String getAttrs() {
    return null;
  }

  @Override
  public boolean hasAttrs(final String string) {
    boolean _xblockexpression = false;
    {
      if ((string == null)) {
        return true;
      }
      _xblockexpression = string.isEmpty();
    }
    return _xblockexpression;
  }
}
