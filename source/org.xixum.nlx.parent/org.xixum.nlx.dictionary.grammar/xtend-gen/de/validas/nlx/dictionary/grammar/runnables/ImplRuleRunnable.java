package de.validas.nlx.dictionary.grammar.runnables;

import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.dictionary.grammar.nodes.ImplRuleNode;
import de.validas.nlx.dictionary.grammar.runnables.IRuleRunnable;
import de.validas.nlx.dictionary.grammar.token.IGrammarItem;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class ImplRuleRunnable extends Thread implements IRuleRunnable {
  protected static int nextRunnerNumber = 0;
  
  protected int runnerNr;
  
  protected ImplRuleNode implRuleNode;
  
  protected IGrammarItem token;
  
  protected HashMap<Integer, INode> result = new HashMap<Integer, INode>();
  
  protected String lock;
  
  public ImplRuleRunnable(final ImplRuleNode implRuleNode, final IGrammarItem token) {
    super(new Function0<String>() {
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
    INode value = this.implRuleNode.solve();
    if ((value != null)) {
      int i = this.token.getIndex();
      this.result.put(Integer.valueOf(i), value);
      IBuildLogger _logger = this.implRuleNode.getDriver().getLogger();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[ImplRuleRunner-");
      _builder.append(this.runnerNr);
      _builder.append("] [Error]: Required Input on Token:[");
      _builder.append(i);
      _builder.append("][name: ");
      String _string = this.token.toString();
      _builder.append(_string);
      _builder.append("] Result:");
      INode _get = this.result.get(Integer.valueOf(i));
      _builder.append(_get);
      _logger.log(_builder);
    }
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
