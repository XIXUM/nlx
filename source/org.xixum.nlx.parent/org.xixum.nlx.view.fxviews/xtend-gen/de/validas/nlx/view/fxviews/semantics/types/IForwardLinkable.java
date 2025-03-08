package de.validas.nlx.view.fxviews.semantics.types;

import de.validas.nlx.constants.Direction;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IForwardLinkable extends ILinkable {
  public abstract Direction getDirection();
  
  public abstract Node getForwarType();
}
