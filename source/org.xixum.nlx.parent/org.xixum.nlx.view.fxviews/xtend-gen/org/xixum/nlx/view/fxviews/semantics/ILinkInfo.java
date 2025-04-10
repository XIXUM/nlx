/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */
package org.xixum.nlx.view.fxviews.semantics;

import java.util.List;
import org.neo4j.driver.v1.Record;

@SuppressWarnings("all")
public interface ILinkInfo {
  Object getRecord(final String key);

  Record getRecord();

  List<Record> getRecordMap();
}
