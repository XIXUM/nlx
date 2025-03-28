package org.xixum.nlx.view.fxviews.semantics.types;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.constants.Direction;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;

@SuppressWarnings("all")
public interface IForwardLinkable extends ILinkable {
  Direction getDirection();

  Node getForwarType();
}
