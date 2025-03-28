package org.xixum.nlx.dictionary.grammar.nodes;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.grammar.bool.BoolOr;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateENTER_RULE;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateEXTENDS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateGET;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateLINK_TO;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateNEXT;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicatePREVIOUS;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;

@SuppressWarnings("all")
public class RuleToken extends AbstractPredicatedNodeObj implements IRuleNode, ITokenNode, IPredicateNEXT, IPredicatePREVIOUS, IPredicateENTER_RULE, IPredicateEXTENDS, IPredicateGET, IPredicateLINK_TO {
  private static final BoolOr boolOr = new BoolOr();

  protected final /* List<Object> */Object functionalTypes /* Skipped initializer because of errors */;

  protected final /* List<Object> */Object directionalTypes /* Skipped initializer because of errors */;

  public RuleToken(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode solve() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractDictRuleObj.predicates refers to the missing type IPredicate"
      + "\nThe field PredicateConstants.RESULT_ refers to the missing type Object"
      + "\nThe field RuleToken.functionalTypes refers to the missing type Object"
      + "\nThe field RuleToken.directionalTypes refers to the missing type Object"
      + "\nThe field RuleToken.directionalTypes refers to the missing type Object"
      + "\nThe field AbstractDictRuleObj.predicates refers to the missing type IPredicate"
      + "\nThe field RuleToken.directionalTypes refers to the missing type Object");
  }

  public boolean containsAny(final Collection<?> coll, final Collection<?> coll2) {
    final Predicate<Object> _function = (Object el) -> {
      return coll2.contains(el);
    };
    return coll.stream().anyMatch(_function);
  }

  @Override
  public INode next(final INode caller) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PredicateConstants.NEXT_ refers to the missing type Object");
  }

  @Override
  public INode previous(final INode caller) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PredicateConstants.PREVIOUS_ refers to the missing type Object");
  }

  @Override
  public INode enterRule(final INode caller) {
    INode _xblockexpression = null;
    {
      final Function1<INode, Object> _function = (INode e) -> {
        return null;
      };
      Function1<INode, Object> preSolve = _function;
      boolean _matched = false;
      if (caller instanceof ImplRuleNode) {
        _matched=true;
        final Function1<INode, Object> _function_1 = (INode e) -> {
          Object _attribute = ((INode) e).getAttribute(Neo4jConstants._TOKEN);
          return ((IGrammarItem) _attribute);
        };
        preSolve = _function_1;
      }
      _xblockexpression = this.wrappedWalker(caller, preSolve, null, null);
    }
    return _xblockexpression;
  }

  @Override
  public INode Extends(final INode caller) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field RuleToken.directionalTypes refers to the missing type Object");
  }

  @Override
  public INode get(final INode caller, final Relationship relation) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PredicateConstants.TARGET_ refers to the missing type Object"
      + "\nThe field PredicateConstants.RESULT_ refers to the missing type Object");
  }

  @Override
  public INode linkTo(final INode caller, final Relationship relation, final Function1<? super String, ? extends INode> delegate) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field PredicateConstants.AS_ refers to the missing type Object");
  }
}
