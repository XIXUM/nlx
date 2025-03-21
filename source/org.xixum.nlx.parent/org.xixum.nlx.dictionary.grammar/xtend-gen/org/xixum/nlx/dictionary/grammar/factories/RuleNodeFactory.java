package org.xixum.nlx.dictionary.grammar.factories;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.INodeFactory;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public class RuleNodeFactory implements INodeFactory {
  protected final ConditionFactory conditionFactory = new ConditionFactory();

  protected final InterpunctionFactory interpunctionFactory = new InterpunctionFactory();

  @Override
  public INode create(final Node node, final IParserDriver driver) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field _WORD is undefined"
      + "\nThe method or field _WORD_CLASS is undefined"
      + "\nThe method or field _WORD_FRAGMENT is undefined"
      + "\nThe method or field _IMPL_RULE_TOKEN is undefined"
      + "\nThe method or field _ACTION is undefined"
      + "\nThe method or field _ACTION_OBJECT is undefined"
      + "\nThe method or field _TENSE is undefined"
      + "\nThe method or field _CONDITION is undefined"
      + "\nThe method or field _INTERPUNCTION is undefined");
  }
}
