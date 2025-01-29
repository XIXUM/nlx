/**
 * @author: Felix Schaller
 */
package de.validas.nlx.dictionary.type;

import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.utils.data.types.XPair;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface ITypeInfo {
  public abstract List<XPair<String, ITypeAttributes>> getTypes();
  
  public abstract void updateTypes(final HashMap<String, ITypeAttributes> linkTypes);
  
  public abstract void addTypes(final HashMap<String, ITypeAttributes> linkTypes);
  
  public abstract Node getBase();
}
