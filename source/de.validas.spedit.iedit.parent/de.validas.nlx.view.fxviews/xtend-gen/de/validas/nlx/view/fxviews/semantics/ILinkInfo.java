package de.validas.nlx.view.fxviews.semantics;

import java.util.List;
import javax.annotation.Generated;
import org.neo4j.driver.v1.Record;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface ILinkInfo {
  public abstract Object getRecord(final String key);
  
  public abstract Record getRecord();
  
  public abstract List<Record> getRecordMap();
}
