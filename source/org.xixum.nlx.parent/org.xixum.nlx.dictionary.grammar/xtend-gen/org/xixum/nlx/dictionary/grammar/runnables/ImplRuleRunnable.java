package org.xixum.nlx.dictionary.grammar.runnables;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.grammar.nodes.ImplRuleNode;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;

@SuppressWarnings("all")
public class ImplRuleRunnable extends Thread implements IRuleRunnable {
  protected static int nextRunnerNumber = 0;

  protected int runnerNr;

  protected ImplRuleNode implRuleNode;

  protected IGrammarItem token;

  protected HashMap<Integer, INode> result = new HashMap<Integer, INode>();

  protected String lock;

  public ImplRuleRunnable(final ImplRuleNode implRuleNode, final IGrammarItem token) {
    super(new Function0<String>() {
      @Override
      public String apply() {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("ImplRuleRunner-");
        String _name = implRuleNode.getName();
        _builder.append(_name);
        _builder.append("-");
        int _plusPlus = ImplRuleRunnable.nextRunnerNumber++;
        _builder.append(_plusPlus);
        return _builder.toString();
      }
    }.apply());
    this.lock = this.getName();
    this.runnerNr = ImplRuleRunnable.nextRunnerNumber;
    this.implRuleNode = implRuleNode;
    this.token = token;
  }

  public void solve() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getIndex() is undefined for the type IGrammarItem");
  }

  @Override
  public void run() {
    this.solve();
  }

  @Override
  public Map<Integer, INode> getResult() {
    return this.result;
  }
}
