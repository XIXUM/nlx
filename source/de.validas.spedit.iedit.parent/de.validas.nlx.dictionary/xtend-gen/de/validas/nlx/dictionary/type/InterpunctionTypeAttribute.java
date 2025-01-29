package de.validas.nlx.dictionary.type;

import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.dictionary.type.elements.INodeEL;
import de.validas.nlx.dictionary.type.elements.IRelationshipEL;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class InterpunctionTypeAttribute implements ITypeAttributes {
  private Node source;
  
  private String interpunction;
  
  private String type;
  
  public InterpunctionTypeAttribute(final Node source, final String interpunction, final String type) {
    this.source = source;
    this.interpunction = interpunction;
    this.type = type;
  }
  
  public InterpunctionTypeAttribute(final String interpunction, final String type) {
    this(null, interpunction, type);
  }
  
  public String getType() {
    return this.type;
  }
  
  @Override
  public Node getBaseNode() {
    return null;
  }
  
  @Deprecated
  @Override
  public Object getAttrs() {
    return this.interpunction;
  }
  
  @Deprecated
  @Override
  public List<Node> getSource() {
    return CollectionLiterals.<Node>newArrayList(this.source);
  }
  
  @Deprecated
  @Override
  public List<Node> getTarget() {
    return null;
  }
  
  @Override
  public void merge(final ITypeAttributes attributes) {
  }
  
  @Override
  public Collection<? extends INodeEL> getSourceEL() {
    return null;
  }
  
  @Override
  public Collection<? extends INodeEL> getTargetEL() {
    return null;
  }
  
  @Override
  public Collection<? extends IRelationshipEL> getAttrsEL() {
    return null;
  }
}
