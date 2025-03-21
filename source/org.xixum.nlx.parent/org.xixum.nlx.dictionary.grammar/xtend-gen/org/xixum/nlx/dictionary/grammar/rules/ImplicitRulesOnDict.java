package org.xixum.nlx.dictionary.grammar.rules;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.grammar.nodes.ImplRuleNode;
import org.xixum.nlx.dictionary.grammar.runnables.ImplRuleRunnable;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;
import org.xixum.nlx.naturalLang.Sentence;
import org.xixum.utils.data.lists.IAppendable;
import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public class ImplicitRulesOnDict {
  protected IDictionaryAccess dictAcc;

  protected IParserDriver driver;

  protected List<ImplRuleNode> rules;

  /**
   * MOVE THIS Class into Dictionary Plugin --> cyclic dependency
   */
  public ImplicitRulesOnDict(final IDictionaryAccess dictAcc, final IBuildLogger logger) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor ParserDriver(IDbAccess, INodeFactory, Object, IContextFactory, IBuildLogger) refers to the missing type Object");
  }

  /**
   * Start Rule checking:
   */
  public void solve(final IGrammarItem item) {
    try {
      boolean _isConnected = this.dictAcc.isConnected();
      boolean _not = (!_isConnected);
      if (_not) {
        return;
      }
      if (((this.rules == null) || this.rules.isEmpty())) {
        this.createImplRules(item);
      } else {
        this.updateRules(item);
      }
      List<Thread> runners = new ArrayList<Thread>();
      for (final ImplRuleNode rule : this.rules) {
        ImplRuleRunnable _implRuleRunnable = new ImplRuleRunnable(rule, item);
        runners.add(_implRuleRunnable);
      }
      for (final Thread runner : runners) {
        runner.start();
      }
      for (final Thread runner_1 : runners) {
        {
          runner_1.join();
          if ((runner_1 instanceof ImplRuleRunnable)) {
            ((ImplRuleRunnable)runner_1).getResult();
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void updateRules(final IGrammarItem item) {
    for (final ImplRuleNode rule : this.rules) {
      rule.setAttribute(Neo4jConstants._TOKEN, item);
    }
  }

  public void createImplRules(final IAppendable item) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field _IMPL_DICT_RULE is undefined");
  }

  /**
   * creates chain on element Base
   */
  @Deprecated
  public EList<XPair<EObject, String>> generateChain(final Sentence sentence) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field _KOMMA is undefined");
  }

  public boolean checkAllWordsTrained(final EList<XPair<EObject, String>> chain) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method findInDictionary(String) is undefined for the type IDictionaryAccess"
      + "\n!== cannot be resolved"
      + "\ntypes cannot be resolved"
      + "\nget cannot be resolved"
      + "\nkey cannot be resolved");
  }
}
