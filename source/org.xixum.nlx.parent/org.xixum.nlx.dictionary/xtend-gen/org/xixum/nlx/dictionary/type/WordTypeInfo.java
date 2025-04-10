package org.xixum.nlx.dictionary.type;

import java.util.HashMap;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
public class WordTypeInfo extends AbstractTypeInfo {
  public WordTypeInfo(final HashMap<String, ITypeAttributes> linkTypes) {
    super(null, linkTypes);
  }

  public WordTypeInfo(final Node node, final HashMap<String, ITypeAttributes> linkTypes) {
    super(node, linkTypes);
  }
}
