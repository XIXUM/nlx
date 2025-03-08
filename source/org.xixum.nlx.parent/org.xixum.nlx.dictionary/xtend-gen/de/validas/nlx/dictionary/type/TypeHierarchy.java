package de.validas.nlx.dictionary.type;

import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.type.ITypeHierarchy;
import java.util.List;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class TypeHierarchy implements ITypeHierarchy {
  private Node node;
  
  private List<ITypeHierarchy> hierarchy;
  
  public TypeHierarchy(final Node node, final List<ITypeHierarchy> hierarchy) {
    this.node = node;
    this.hierarchy = hierarchy;
  }
  
  @Override
  public String getType() {
    return this.node.get(Neo4jConstants._NAME).asString();
  }
  
  @Override
  public List<ITypeHierarchy> getChildren() {
    return this.hierarchy;
  }
}
