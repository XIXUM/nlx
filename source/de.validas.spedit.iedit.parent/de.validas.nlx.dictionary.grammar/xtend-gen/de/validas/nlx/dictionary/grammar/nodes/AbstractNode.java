package de.validas.nlx.dictionary.grammar.nodes;

import java.util.Map;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class AbstractNode {
  protected Map<String, Object> attributes = CollectionLiterals.<String, Object>newHashMap();
  
  protected Map<String, Object> extraAttributes = CollectionLiterals.<String, Object>newHashMap();
  
  public Object getAttribute(final String key) {
    Object _xifexpression = null;
    boolean _containsKey = this.attributes.containsKey(key);
    if (_containsKey) {
      _xifexpression = this.attributes.get(key);
    } else {
      _xifexpression = this.extraAttributes.get(key);
    }
    return _xifexpression;
  }
  
  public Object setAttribute(final String key, final Object value) {
    Object _xblockexpression = null;
    {
      this.extraAttributes.put(key, value);
      _xblockexpression = value;
    }
    return _xblockexpression;
  }
  
  public Map<String, Object> clearExtraAttributes() {
    return this.extraAttributes = CollectionLiterals.<String, Object>newHashMap();
  }
  
  public Map<String, Object> init() {
    return this.clearExtraAttributes();
  }
}
