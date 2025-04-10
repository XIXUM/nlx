package org.xixum.nlx.dictionary.type;

import java.util.List;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.constants.Neo4jConstants;

@SuppressWarnings("all")
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
