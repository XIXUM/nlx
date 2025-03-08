package de.validas.nlx.dictionary.type.elements;

import de.validas.nlx.constants.Direction;
import de.validas.nlx.dictionary.type.elements.INetworkEL;
import de.validas.nlx.dictionary.type.elements.IRelationshipEL;
import java.util.List;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface INodeEL extends INetworkEL {
  public abstract Node getNode();
  
  public abstract boolean addRel(final IRelationshipEL rel);
  
  public abstract boolean addAllRels(final List<IRelationshipEL> relationships);
  
  public abstract List<IRelationshipEL> getRelationship(final Direction set);
}
