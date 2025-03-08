package de.validas.nlx.ai;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface INodeFactory {
  public abstract INode create(final Node node, final IParserDriver driver);
}
