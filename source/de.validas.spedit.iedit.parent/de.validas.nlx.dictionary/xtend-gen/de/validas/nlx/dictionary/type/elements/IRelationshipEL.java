package de.validas.nlx.dictionary.type.elements;

import de.validas.nlx.dictionary.type.elements.INetworkEL;
import de.validas.nlx.dictionary.type.elements.INodeEL;
import de.validas.nlx.dictionary.type.elements.NodeEL;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IRelationshipEL extends INetworkEL {
  public abstract INodeEL getStart();
  
  public abstract INodeEL getEnd();
  
  public abstract Relationship getRelationship();
  
  public abstract Boolean relink(final NodeEL el);
}
