/**
 * (c) felixschaller.com
 * @author felix schaller
 */
package org.xixum.nlx.dictionary.grammar.nodes.interfaces;

import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public interface IPredicateEQUALS {
  INode equals(final INode caller);
}
