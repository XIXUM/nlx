package org.xixum.nlx.dictionary.grammar.nodes;

import java.util.List;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.grammar.bool.BoolOr;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateFIND;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateOF;

@SuppressWarnings("all")
public class ActionObject extends AbstractActionPredicatedNodeObj implements IObjectNode, IPredicateOF, IPredicateFIND {
  private static final BoolOr boolOr = new BoolOr();

  protected final List<String> objectTypes /* Skipped initializer because of errors */;

  public ActionObject(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode solve() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field _TYPE is undefined"
      + "\nThe method or field _SHORT_OF is undefined"
      + "\nThe method or field _ATTR_NAME is undefined"
      + "\nThe method or field _QUERY is undefined"
      + "\nThe field AbstractDictRuleObj.predicates refers to the missing type IPredicate"
      + "\nThe field PredicateConstants.OF_ refers to the missing type Object"
      + "\nThe field PredicateConstants.GET_NAME_ refers to the missing type Object");
  }

  @Override
  public INode of(final INode caller, final Relationship relation) {
    Object _xblockexpression = null;
    {
      caller.setAttribute(relation.type().toLowerCase(), this);
      _xblockexpression = null;
    }
    return ((INode)_xblockexpression);
  }

  @Override
  public INode find(final INode caller, final Relationship relation) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field _QUERY is undefined"
      + "\nThe method or field _WORD is undefined"
      + "\nThe method or field _QUERY is undefined"
      + "\nThe field PredicateConstants.WITH_ refers to the missing type Object"
      + "\nThe field PredicateConstants.WITH_ refers to the missing type Object");
  }
}
