package org.xixum.nlx.dictionary.grammar.rules;

import de.validas.spedit.naturalLang.Sentence;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.xixum.nlx.ai.IDbAccess;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.ParserDriver;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.grammar.factories.ContextFactory;
import org.xixum.nlx.dictionary.grammar.factories.PredicateFactory;
import org.xixum.nlx.dictionary.grammar.factories.RuleNodeFactory;
import org.xixum.nlx.dictionary.grammar.nodes.ImplRuleNode;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;

@SuppressWarnings("all")
public class ImplicitRulesOnDict {
  protected IDictionaryAccess dictAcc;

  protected IParserDriver driver;

  protected List<ImplRuleNode> rules;

  /**
   * MOVE THIS Class into Dictionary Plugin --> cyclic dependency
   */
  public ImplicitRulesOnDict(final IDictionaryAccess dictAcc, final IBuildLogger logger) {
    this.dictAcc = dictAcc;
    IDbAccess _dbAccessor = dictAcc.getDbAccessor();
    RuleNodeFactory _ruleNodeFactory = new RuleNodeFactory();
    IDbAccess _dbAccessor_1 = dictAcc.getDbAccessor();
    PredicateFactory _predicateFactory = new PredicateFactory(_dbAccessor_1);
    ContextFactory _contextFactory = new ContextFactory();
    ParserDriver _parserDriver = new ParserDriver(_dbAccessor, _ruleNodeFactory, _predicateFactory, _contextFactory, logger);
    this.driver = _parserDriver;
  }

  /**
   * Start Rule checking:
   */
  public void solve(final IGrammarItem item) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createImplRules(IAppendable) from the type ImplicitRulesOnDict refers to the missing type IAppendable");
  }

  public void updateRules(final IGrammarItem item) {
    for (final ImplRuleNode rule : this.rules) {
      rule.setAttribute(Neo4jConstants._TOKEN, item);
    }
  }

  public void createImplRules(final /* IAppendable */Object item) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor ImplRuleNode(Node, IAppendable, IParserDriver) refers to the missing type IAppendable");
  }

  /**
   * creates chain on element Base
   */
  @Deprecated
  public /* EList<XPair<EObject, String>> */Object generateChain(final Sentence sentence) {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved."
      + "\nXPair cannot be resolved.");
  }

  public boolean checkAllWordsTrained(final /* EList<XPair<EObject, String>> */Object chain) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getTypes() from the type ITypeInfo refers to the missing type Object"
      + "\nkey cannot be resolved"
      + "\nkey cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nkey cannot be resolved");
  }
}
