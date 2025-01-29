package de.validas.nlx.dictionary.grammar.nodes.interfaces;

import de.validas.nlx.ai.semantics.INode;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IPredicateOF {
  public abstract INode of(final INode caller, final Relationship relation);
}
