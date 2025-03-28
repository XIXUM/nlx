package org.xixum.nlx.dictionary.grammar.factories;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.INodeFactory;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public class ConditionFactory implements INodeFactory {
  @Override
  public INode create(final Node node, final IParserDriver driver) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field _BOOL_AND is undefined"
      + "\nThe method or field _BOOL_OR is undefined"
      + "\nThe field PredicateConstants.TYPE_ refers to the missing type Object");
  }
}
