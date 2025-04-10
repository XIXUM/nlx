package org.xixum.nlx.dictionary.grammar.nodes;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
import org.xixum.nlx.dictionary.grammar.bool.BoolOr;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateENTER_RULE;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateEXTENDS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateGET;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateLINK_TO;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateNEXT;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicatePREVIOUS;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;
import org.xixum.utils.data.lists.IAppendable;

@SuppressWarnings("all")
public class RuleToken extends AbstractPredicatedNodeObj implements IRuleNode, ITokenNode, IPredicateNEXT, IPredicatePREVIOUS, IPredicateENTER_RULE, IPredicateEXTENDS, IPredicateGET, IPredicateLINK_TO {
  private static final BoolOr boolOr = new BoolOr();

  protected final List<String> functionalTypes = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(PredicateConstants.EXTENDS_, PredicateConstants.EQUALS_, PredicateConstants.TARGET_));

  protected final List<String> directionalTypes = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(PredicateConstants.NEXT_, PredicateConstants.PREVIOUS_));

  public RuleToken(final Node node, final IParserDriver driver) {
    super(node, driver);
  }

  @Override
  public INode solve() {
    if ((this.predicates == null)) {
      List<Record> outs = this.listAllOutputs();
      this.createPredicates(outs);
    }
    Object _setAttribute = this.setAttribute(PredicateConstants.RESULT_, this.doExecuteTypes(this.functionalTypes, RuleToken.boolOr));
    INode result = ((INode) _setAttribute);
    if ((result != null)) {
      if (((this.negativeFilter != null) && this.negativeFilter.stream().anyMatch(((Predicate<String>) (String el) -> {
        return this.directionalTypes.contains(el);
      })))) {
        return result;
      }
      boolean _containsAny = this.containsAny(this.directionalTypes, this.predicates.keySet());
      if (_containsAny) {
        return this.doExecuteTypes(this.directionalTypes, RuleToken.boolOr);
      } else {
        return result;
      }
    }
    return null;
  }

  public boolean containsAny(final Collection<?> coll, final Collection<?> coll2) {
    final Predicate<Object> _function = (Object el) -> {
      return coll2.contains(el);
    };
    return coll.stream().anyMatch(_function);
  }

  @Override
  public INode next(final INode caller) {
    INode _xblockexpression = null;
    {
      final Function1<INode, Object> _function = (INode e) -> {
        IGrammarItem _xblockexpression_1 = null;
        {
          Object _attribute = ((INode) e).getAttribute(Neo4jConstants._TOKEN);
          IAppendable _successor = ((IGrammarItem) _attribute).getSuccessor();
          IGrammarItem next = ((IGrammarItem) _successor);
          ((INode) e).getDriver().getContext().setAttribute(PredicateConstants.NEXT_, next);
          _xblockexpression_1 = next;
        }
        return _xblockexpression_1;
      };
      Function1<INode, Object> preSolve = _function;
      _xblockexpression = this.wrappedWalker(caller, preSolve, null, null);
    }
    return _xblockexpression;
  }

  @Override
  public INode previous(final INode caller) {
    INode _xblockexpression = null;
    {
      final Function1<INode, Object> _function = (INode e) -> {
        Object _xblockexpression_1 = null;
        {
          Object _attribute = ((INode) e).getAttribute(Neo4jConstants._TOKEN);
          IAppendable _precessor = ((IGrammarItem) _attribute).getPrecessor();
          IGrammarItem pre = ((IGrammarItem) _precessor);
          _xblockexpression_1 = ((INode) e).getDriver().getContext().setAttribute(PredicateConstants.PREVIOUS_, pre);
        }
        return _xblockexpression_1;
      };
      final Function1<INode, Object> preSolve = _function;
      _xblockexpression = this.wrappedWalker(caller, preSolve, null, null);
    }
    return _xblockexpression;
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
    INode _xblockexpression = null;
    {
      final Function1<INode, Object> _function = (INode e) -> {
        return null;
      };
      Function1<INode, Object> preSolve = _function;
      String filter = null;
      boolean _matched = false;
      if (caller instanceof RuleToken) {
        _matched=true;
        final Function1<INode, Object> _function_1 = (INode e) -> {
          Object _attribute = ((INode) e).getAttribute(Neo4jConstants._TOKEN);
          return ((IGrammarItem) _attribute);
        };
        preSolve = _function_1;
        StringConcatenation _builder = new StringConcatenation();
        {
          boolean _hasElements = false;
          for(final String type : this.directionalTypes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            _builder.append("!");
            _builder.append(type);
          }
        }
        filter = _builder.toString();
      }
      _xblockexpression = this.wrappedWalker(caller, preSolve, null, filter);
    }
    return _xblockexpression;
  }

  @Override
  public INode get(final INode caller, final Relationship relation) {
    Object _xblockexpression = null;
    {
      Object _attribute = this.getAttribute(PredicateConstants.TARGET_);
      INode target = ((INode) _attribute);
      Object _attribute_1 = this.getAttribute(PredicateConstants.RESULT_);
      INode value = ((INode) _attribute_1);
      if ((target != null)) {
        caller.setAttribute(relation.type().toLowerCase(), value);
      }
      if ((value != null)) {
        caller.setAttribute(relation.type().toLowerCase(), value);
      }
      _xblockexpression = null;
    }
    return ((INode)_xblockexpression);
  }

  @Override
  public INode linkTo(final INode caller, final Relationship relation, final Function1<? super String, ? extends INode> delegate) {
    String type = relation.get(PredicateConstants.AS_).asString().toLowerCase();
    return delegate.apply(type);
  }
}
