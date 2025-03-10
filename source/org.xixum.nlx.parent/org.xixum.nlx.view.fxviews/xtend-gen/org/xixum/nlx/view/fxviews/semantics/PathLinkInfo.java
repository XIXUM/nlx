/**
 * (c)2022 felixschaller.com
 */
package org.xixum.nlx.view.fxviews.semantics;

import java.util.List;
import org.neo4j.driver.v1.Record;

/**
 * class that extends LinkInfo to store exclusion patterns
 * @author schaller
 */
@SuppressWarnings("all")
public class PathLinkInfo extends LinkInfo implements ILinkInfo {
  private List<Record> recMap;

  public PathLinkInfo(final List<Record> recMap) {
    super(recMap.get(0));
    this.recMap = recMap;
  }

  @Override
  public List<Record> getRecordMap() {
    return this.recMap;
  }
}
