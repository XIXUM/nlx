package org.xixum.nlx.dictionary.grammar.nodes;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateLINK_TO;

@SuppressWarnings("all")
public class TenseNode extends AbstractPredicatedNodeObj implements IDictNode, IPredicateLINK_TO {
  public TenseNode(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  public String getTense() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PredicateConstants.NAME_ refers to the missing type Object");
  }

  @Override
  public INode solve() {
    return null;
  }

  @Override
  public INode linkTo(final INode caller, final Relationship relation, final Function1<? super String, ? extends INode> delegate) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PredicateConstants.AS_ refers to the missing type Object");
  }
}
