package org.xixum.nlx.dictionary.grammar.token;

import org.eclipse.emf.ecore.EObject;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.dictionary.grammar.types.IGrammarType;
import org.xixum.utils.data.lists.IAppendable;

/**
 * @author schaller
 */
@SuppressWarnings("all")
public interface IGrammarItem extends IAppendable/* , IContainable, IIndexable */ {
  String getName();

  String getLabel();

  EObject getElement();

  Node getBaseNode();

  long generateID();

  IGrammarType getInternalType();
}
