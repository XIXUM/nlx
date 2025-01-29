package de.validas.nlx.dictionary.grammar.nodes.interfaces;

import de.validas.nlx.ai.semantics.INode;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IPredicateLINK_TO {
  public abstract INode linkTo(final INode caller, final Relationship relation, final Function1<? super String, ? extends INode> delegate);
}
