package org.xixum.nlx.dictionary.grammar.nodes;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateIS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateLINK_TO;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateOF_CLASS;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;

@SuppressWarnings("all")
public class WordClassToken extends AbstractPredicatedNodeObj implements IDictNode, IPredicateIS, IPredicateOF_CLASS, IPredicateLINK_TO {
  private IGrammarItem item;

  public WordClassToken(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode solve() {
    return null;
  }

  @Override
  public INode is(final INode caller) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getBaseType() from the type IGrammarType refers to the missing type XPair"
      + "\nkey cannot be resolved"
      + "\n!== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nequals cannot be resolved");
  }

  @Override
  public INode ofClass(final INode caller, final Relationship relation) {
    return this;
  }

  @Override
  public INode linkTo(final INode caller, final Relationship relation, final Function1<? super String, ? extends INode> delegate) {
    String type = relation.get(PredicateConstants.AS_).asString().toLowerCase();
    return delegate.apply(type);
  }
}
