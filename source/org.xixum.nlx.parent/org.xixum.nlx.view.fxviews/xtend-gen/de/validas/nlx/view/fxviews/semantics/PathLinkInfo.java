/**
 * (c)2022 felixschaller.com
 */
package de.validas.nlx.view.fxviews.semantics;

import de.validas.nlx.view.fxviews.semantics.ILinkInfo;
import de.validas.nlx.view.fxviews.semantics.LinkInfo;
import java.util.List;
import javax.annotation.Generated;
import org.neo4j.driver.v1.Record;

/**
 * class that extends LinkInfo to store exclusion patterns
 * @author schaller
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
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
