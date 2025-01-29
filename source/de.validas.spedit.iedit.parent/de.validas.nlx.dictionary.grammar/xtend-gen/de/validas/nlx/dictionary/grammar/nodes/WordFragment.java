package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.grammar.nodes.AbstractDictRuleObj;
import de.validas.nlx.dictionary.grammar.nodes.ConditionNode;
import de.validas.nlx.dictionary.grammar.nodes.IDictNode;
import de.validas.nlx.dictionary.grammar.nodes.interfaces.IPredicateENDS_WITH;
import de.validas.nlx.dictionary.grammar.token.IGrammarItem;
import de.validas.nlx.dictionary.grammar.utils.GrammarUtil;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class WordFragment extends AbstractDictRuleObj implements IDictNode, IPredicateENDS_WITH {
  public WordFragment(final Node node, final IParserDriver driver) {
    super(node, driver);
  }
  
  @Override
  public INode solve() {
    return null;
  }
  
  @Override
  public INode endsWith(final INode caller) {
    boolean _matched = false;
    if (caller instanceof ConditionNode) {
      _matched=true;
      Object _attribute = ((ConditionNode)caller).getAttribute(Neo4jConstants._TOKEN);
      String word = ((IGrammarItem) _attribute).getName().toLowerCase();
      Object _attribute_1 = this.getAttribute(Neo4jConstants._ATTR_NAME);
      boolean _endsWith = word.endsWith(((String) _attribute_1));
      if (_endsWith) {
        return GrammarUtil.findWord(this, word);
      }
    }
    return null;
  }
}
