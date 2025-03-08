package de.validas.nlx.view.fxviews.cache;

import de.validas.nlx.view.fxviews.cache.CachedDeadLink;
import de.validas.nlx.view.fxviews.cache.ICacheObj;
import javax.annotation.Generated;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class CachedLink extends CachedDeadLink {
  private Record rec;
  
  private String varSelect;
  
  private String attrs;
  
  public CachedLink(final ICacheObj start, final ICacheObj end, final String attrs, final Record rec, final String varSelect) {
    super(start, end);
    this.rec = rec;
    this.varSelect = varSelect;
    this.attrs = attrs;
  }
  
  @Override
  public Node getNode() {
    Node _xifexpression = null;
    boolean _containsKey = this.getRecord().containsKey(this.varSelect);
    if (_containsKey) {
      _xifexpression = this.getRecord().get(this.varSelect).asNode();
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  @Override
  public Record getRecord() {
    return this.rec;
  }
  
  @Override
  public String getAttrs() {
    return this.attrs;
  }
  
  @Override
  public boolean hasAttrs(final String string) {
    boolean _xblockexpression = false;
    {
      if ((string == null)) {
        return true;
      }
      boolean _xifexpression = false;
      boolean _isEmpty = string.isEmpty();
      if (_isEmpty) {
        _xifexpression = true;
      } else {
        _xifexpression = this.attrs.equals(string);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
