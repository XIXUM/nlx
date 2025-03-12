package org.xixum.nlx.dictionary.grammar.rules;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IDbAccess;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.ParserDriver;
import org.xixum.nlx.ai.neo4j.Neo4jAccess;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.constants.NodeConstants;
import org.xixum.nlx.dictionary.grammar.factories.ContextFactory;
import org.xixum.nlx.dictionary.grammar.factories.PredicateFactory;
import org.xixum.nlx.dictionary.grammar.factories.RuleNodeFactory;
import org.xixum.nlx.dictionary.grammar.nodes.ImplRuleNode;
import org.xixum.nlx.dictionary.grammar.runnables.ImplRuleRunnable;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;
import org.xixum.nlx.dictionary.type.ITypeInfo;
import org.xixum.nlx.naturalLang.New_Line;
import org.xixum.nlx.naturalLang.Sentence;
import org.xixum.nlx.naturalLang.SubSentence;
import org.xixum.nlx.naturalLang.Word;
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
    IDbAccess _dbAccessor = this.driver.getDbAccessor();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._NODE);
    _builder.append(":");
    _builder.append(NodeConstants._IMPL_DICT_RULE);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("RETURN ");
    _builder.append(Neo4jConstants._NODE);
    List<Record> result = _dbAccessor.runCodeRecords(_builder.toString(), Neo4jAccess.Action.READ);
    List<ImplRuleNode> ruleNodes = new ArrayList<ImplRuleNode>();
    for (final Record record : result) {
      {
        Value _get = record.get(Neo4jConstants._NODE.toString());
        Node node = ((NodeValue) _get).asNode();
        IParserDriver _newCache = this.driver.newCache();
        ImplRuleNode _implRuleNode = new ImplRuleNode(node, item, _newCache);
        ruleNodes.add(_implRuleNode);
      }
    }
    this.rules = ruleNodes;
  }

  /**
   * creates chain on element Base
   */
  @Deprecated
  public EList<XPair<EObject, String>> generateChain(final Sentence sentence) {
    BasicEList<XPair<EObject, String>> chain = new BasicEList<XPair<EObject, String>>();
    int index = 0;
    EList<EObject> _subsentence = sentence.getSubsentence();
    for (final EObject ssentence : _subsentence) {
      {
        if ((index > 0)) {
          XPair<EObject, String> _xPair = new XPair<EObject, String>(null, NodeConstants._KOMMA);
          chain.add(_xPair);
        }
        EList<EObject> _elements = ((SubSentence) ssentence).getElements();
        for (final EObject element : _elements) {
          if ((!(element instanceof New_Line))) {
            XPair<EObject, String> _xPair_1 = new XPair<EObject, String>(element, null);
            chain.add(_xPair_1);
          }
        }
        index++;
      }
    }
    return chain;
  }

  public boolean checkAllWordsTrained(final EList<XPair<EObject, String>> chain) {
    boolean _xblockexpression = false;
    {
      for (final XPair<EObject, String> touple : chain) {
        EObject _key = touple.getKey();
        if ((_key instanceof Word)) {
          EObject _key_1 = touple.getKey();
          String[] chunks = ((String[])Conversions.unwrapArray(((Word) _key_1).getWord(), String.class));
          for (final String chunk : chunks) {
            {
              ITypeInfo result = this.dictAcc.findInDictionary(chunk);
              if ((result != null)) {
                return false;
              }
              touple.setValue(result.getTypes().get(0).getKey());
            }
          }
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
}
