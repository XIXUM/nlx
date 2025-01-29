package de.validas.nlx.view.fxviews.semantics;

import de.validas.nlx.view.fxviews.semantics.ILinkInfo;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.internal.value.ListValue;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.internal.value.NullValue;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Value;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class LinkInfo implements ILinkInfo {
  protected Record record;
  
  public LinkInfo(final Record rec) {
    this.record = rec;
  }
  
  @Override
  public Object getRecord(final String key) {
    Object _xblockexpression = null;
    {
      Value value = this.record.get(key);
      Object _switchResult = null;
      boolean _matched = false;
      if (value instanceof NodeValue) {
        _matched=true;
        _switchResult = ((NodeValue)value).asNode();
      }
      if (!_matched) {
        if (value instanceof NullValue) {
          _matched=true;
          _switchResult = null;
        }
      }
      if (!_matched) {
        if (value instanceof ListValue) {
          _matched=true;
          _switchResult = ((ListValue)value).asList();
        }
      }
      if (!_matched) {
        _switchResult = null;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  @Override
  public Record getRecord() {
    return this.record;
  }
  
  @Override
  public List<Record> getRecordMap() {
    return Collections.<Record>unmodifiableList(CollectionLiterals.<Record>newArrayList(this.record));
  }
}
