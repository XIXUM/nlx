/**
 * @author: Felix Schaller
 */
package org.xixum.nlx.dictionary.type;

import java.util.HashMap;
import java.util.List;
import org.neo4j.driver.v1.types.Node;
import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public interface ITypeInfo {
  List<XPair<String, ITypeAttributes>> getTypes();

  void updateTypes(final HashMap<String, ITypeAttributes> linkTypes);

  void addTypes(final HashMap<String, ITypeAttributes> linkTypes);

  Node getBase();
}
