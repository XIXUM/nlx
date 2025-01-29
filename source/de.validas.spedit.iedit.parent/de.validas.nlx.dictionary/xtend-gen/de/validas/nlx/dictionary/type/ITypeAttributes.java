package de.validas.nlx.dictionary.type;

import de.validas.nlx.dictionary.type.elements.INodeEL;
import de.validas.nlx.dictionary.type.elements.IRelationshipEL;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface ITypeAttributes {
  public abstract Node getBaseNode();
  
  @Deprecated
  public abstract Object getAttrs();
  
  @Deprecated
  public abstract List<Node> getSource();
  
  @Deprecated
  public abstract List<Node> getTarget();
  
  public abstract void merge(final ITypeAttributes attributes);
  
  public abstract Collection<? extends INodeEL> getSourceEL();
  
  public abstract Collection<? extends INodeEL> getTargetEL();
  
  public abstract Collection<? extends IRelationshipEL> getAttrsEL();
}
