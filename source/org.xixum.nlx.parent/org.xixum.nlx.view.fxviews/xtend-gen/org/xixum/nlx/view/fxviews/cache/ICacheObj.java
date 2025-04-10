/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */
package org.xixum.nlx.view.fxviews.cache;

import java.util.Collection;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
public interface ICacheObj {
  void setOutLink(final ICacheObj obj);

  void setInLink(final ICacheObj obj);

  Collection<ICacheObj> getOutLinks();

  Collection<ICacheObj> getInLinks();

  Node getNode();

  Record getRecord();

  String getName();

  boolean hasAttrs(final String string);
}
