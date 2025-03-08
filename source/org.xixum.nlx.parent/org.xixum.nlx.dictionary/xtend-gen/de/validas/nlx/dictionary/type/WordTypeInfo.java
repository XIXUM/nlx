package de.validas.nlx.dictionary.type;

import de.validas.nlx.dictionary.type.AbstractTypeInfo;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import java.util.HashMap;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class WordTypeInfo extends AbstractTypeInfo {
  public WordTypeInfo(final HashMap<String, ITypeAttributes> linkTypes) {
    super(null, linkTypes);
  }
  
  public WordTypeInfo(final Node node, final HashMap<String, ITypeAttributes> linkTypes) {
    super(node, linkTypes);
  }
}
