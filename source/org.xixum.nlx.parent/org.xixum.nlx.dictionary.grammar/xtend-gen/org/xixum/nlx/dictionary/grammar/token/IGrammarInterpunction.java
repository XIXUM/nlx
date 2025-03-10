package org.xixum.nlx.dictionary.grammar.token;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.dictionary.grammar.types.ItemType;

@SuppressWarnings("all")
public interface IGrammarInterpunction {
  ItemType getCathegory();

  Node getNode();
}
