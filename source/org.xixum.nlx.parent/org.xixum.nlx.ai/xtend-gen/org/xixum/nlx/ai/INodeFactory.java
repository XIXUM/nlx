package org.xixum.nlx.ai;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public interface INodeFactory {
  INode create(final Node node, final IParserDriver driver);
}
