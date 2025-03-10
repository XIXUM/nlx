package org.xixum.nlx.dictionary.type;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.v1.types.Node;
import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public abstract class AbstractTypeInfo implements ITypeInfo {
  protected List<XPair<String, ITypeAttributes>> types;

  protected Node baseNode;

  public AbstractTypeInfo(final Node node, final HashMap<String, ITypeAttributes> linkTypes) {
    this.types = CollectionLiterals.<XPair<String, ITypeAttributes>>newArrayList();
    this.addTypes(linkTypes);
    this.baseNode = node;
  }

  @Override
  public List<XPair<String, ITypeAttributes>> getTypes() {
    return this.types;
  }

  @Override
  public void updateTypes(final HashMap<String, ITypeAttributes> linkTypes) {
    this.types.clear();
    this.addTypes(linkTypes);
  }

  @Override
  public void addTypes(final HashMap<String, ITypeAttributes> linkTypes) {
    if ((linkTypes != null)) {
      Set<String> _keySet = linkTypes.keySet();
      for (final String type : _keySet) {
        ITypeAttributes _get = linkTypes.get(type);
        XPair<String, ITypeAttributes> _xPair = new XPair<String, ITypeAttributes>(type, _get);
        this.types.add(_xPair);
      }
    }
  }

  @Override
  public Node getBase() {
    return this.baseNode;
  }
}
