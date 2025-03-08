package de.validas.nlx.ai;

import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.ai.semantics.IPredicate;
import javax.annotation.Generated;
import org.neo4j.driver.internal.value.RelationshipValue;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IPredicateFactory {
  public abstract IPredicate create(final RelationshipValue value, final INode nodeStart, final INode nodeEnd);
}
