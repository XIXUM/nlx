/**
 * @author: Felix Schaller
 */
package org.xixum.nlx.dictionary.type;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("all")
public interface ITypeInfo {
  /* List<XPair<String, ITypeAttributes>> */Object getTypes();

  void updateTypes(final HashMap<String, ITypeAttributes> linkTypes);

  void addTypes(final HashMap<String, ITypeAttributes> linkTypes);

  /* Node */Object getBase();
}
