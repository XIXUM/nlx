/**
 * (c) felixschaller.com
 * @author felix schaller
 */
package org.xixum.nlx.dictionary.grammar.nodes.interfaces;

import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public interface IPredicatePREVIOUS {
  /**
   * interface for predicate capability PREVIOUS
   */
  INode previous(final INode caller);
}
