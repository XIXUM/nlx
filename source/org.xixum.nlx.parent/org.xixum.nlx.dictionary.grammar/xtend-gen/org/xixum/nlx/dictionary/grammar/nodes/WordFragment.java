package org.xixum.nlx.dictionary.grammar.nodes;

import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateENDS_WITH;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;
import org.xixum.nlx.dictionary.grammar.utils.GrammarUtil;

@SuppressWarnings("all")
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
