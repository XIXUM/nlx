package org.xixum.nlx.dictionary.grammar.nodes;

import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateGET_NAME;

@SuppressWarnings("all")
public abstract class AbstractPredicatedNodeObj extends AbstractDictRuleObj implements IPredicateGET_NAME {
  public AbstractPredicatedNodeObj(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode getName(final INode caller, final Relationship relation) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PredicateConstants.GET_NAME_ refers to the missing type Object");
  }
}
