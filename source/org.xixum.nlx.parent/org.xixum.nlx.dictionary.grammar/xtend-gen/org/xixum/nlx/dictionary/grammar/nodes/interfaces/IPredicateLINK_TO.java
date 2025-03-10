package org.xixum.nlx.dictionary.grammar.nodes.interfaces;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public interface IPredicateLINK_TO {
  INode linkTo(final INode caller, final Relationship relation, final Function1<? super String, ? extends INode> delegate);
}
