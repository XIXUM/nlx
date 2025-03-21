package org.xixum.nlx.dictionary.grammar.rules;

import java.util.List;
import org.neo4j.driver.internal.value.NodeValue;

/**
 * deprecated. use IFunction from: org.xixum.nlx.ai
 */
@Deprecated
@SuppressWarnings("all")
public interface IDelegateListNodes {
  List<NodeValue> execute(final String string);
}
