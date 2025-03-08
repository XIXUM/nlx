/**
 * (c) felixschaller.com 2022
 */
package de.validas.nlx.dictionary.grammar.nodes.interfaces;

import de.validas.nlx.ai.semantics.INode;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Relationship;

/**
 * @author Felix Schaller
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IPredicateOF_CLASS {
  public abstract INode ofClass(final INode caller, final Relationship relation);
}
