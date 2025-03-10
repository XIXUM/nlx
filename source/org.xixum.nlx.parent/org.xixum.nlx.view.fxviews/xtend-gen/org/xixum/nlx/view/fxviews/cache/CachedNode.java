package org.xixum.nlx.view.fxviews.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
public class CachedNode implements ICacheObj {
  private String name;

  private Record record;

  private String varSelect;

  private HashMap<String, ICacheObj> outLinks = new HashMap<String, ICacheObj>();

  private HashMap<String, ICacheObj> inLinks = new HashMap<String, ICacheObj>();

  public CachedNode(final String name, final String label, final Record rec, final String varSelect) {
    this.record = rec;
    this.name = name;
    this.varSelect = varSelect;
  }

  @Override
  public void setOutLink(final ICacheObj obj) {
    this.outLinks.put(((ICacheLink) obj).getInLink().getName(), obj);
  }

  @Override
  public void setInLink(final ICacheObj obj) {
    this.inLinks.put(((ICacheLink) obj).getOutLink().getName(), obj);
  }

  @Override
  public Collection<ICacheObj> getOutLinks() {
    return this.outLinks.values();
  }

  @Override
  public Collection<ICacheObj> getInLinks() {
    return this.inLinks.values();
  }

  public ICacheObj hasLinkTo(final ICacheObj target, final String attrs) {
    Set<String> _keySet = this.outLinks.keySet();
    for (final String key : _keySet) {
      {
        ICacheObj link = this.outLinks.get(key);
        ICacheObj end = ((ICacheLink) link).getInLink();
        if ((end.equals(target) && link.hasAttrs(attrs))) {
          return link;
        }
      }
    }
    return null;
  }

  @Override
  public Node getNode() {
    Node _xifexpression = null;
    boolean _containsKey = this.record.containsKey(this.varSelect);
    if (_containsKey) {
      _xifexpression = this.record.get(this.varSelect).asNode();
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }

  @Override
  public Record getRecord() {
    return this.record;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public void removeLinkTo(final ICacheObj target) {
    ArrayList<String> keys = CollectionLiterals.<String>newArrayList();
    Set<String> _keySet = this.outLinks.keySet();
    for (final String key : _keySet) {
      {
        ICacheObj link = this.outLinks.get(key);
        ICacheObj end = ((ICacheLink) link).getInLink();
        if (((end != null) && end.equals(target))) {
          keys.add(key);
        }
      }
    }
    for (final String key_1 : keys) {
      {
        ICacheObj link = this.outLinks.get(key_1);
        ICacheObj end = ((ICacheLink) link).getInLink();
        this.removeOut(key_1);
        ((CachedNode) end).removeIn(this.name);
        link.setInLink(null);
        link.setOutLink(null);
      }
    }
  }

  public ICacheObj removeIn(final String key) {
    return this.inLinks.remove(key);
  }

  public ICacheObj removeOut(final String key) {
    return this.outLinks.remove(key);
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

  @Override
  public String toString() {
    return this.name;
  }
}
