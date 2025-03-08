package de.validas.nlx.dictionary.grammar.factories;

import com.google.common.base.Objects;
import de.validas.nlx.ai.INodeFactory;
import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.constants.NodeConstants;
import de.validas.nlx.dictionary.grammar.factories.ConditionFactory;
import de.validas.nlx.dictionary.grammar.factories.InterpunctionFactory;
import de.validas.nlx.dictionary.grammar.nodes.ActionNode;
import de.validas.nlx.dictionary.grammar.nodes.ActionObject;
import de.validas.nlx.dictionary.grammar.nodes.ClassNode;
import de.validas.nlx.dictionary.grammar.nodes.RuleToken;
import de.validas.nlx.dictionary.grammar.nodes.TenseNode;
import de.validas.nlx.dictionary.grammar.nodes.WordClassToken;
import de.validas.nlx.dictionary.grammar.nodes.WordFragment;
import de.validas.nlx.dictionary.grammar.nodes.WordToken;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class RuleNodeFactory implements INodeFactory {
  protected final ConditionFactory conditionFactory = new ConditionFactory();
  
  protected final InterpunctionFactory interpunctionFactory = new InterpunctionFactory();
  
  @Override
  public INode create(final Node node, final IParserDriver driver) {
    INode _xblockexpression = null;
    {
      Iterable<String> labels = node.labels();
      INode _switchResult = null;
      final Iterable<String> _converted_labels = (Iterable<String>)labels;
      String _get = ((String[])Conversions.unwrapArray(_converted_labels, String.class))[0];
      boolean _matched = false;
      if (Objects.equal(_get, NodeConstants._WORD)) {
        _matched=true;
        _switchResult = new WordToken(node, driver);
      }
      if (!_matched) {
        if (Objects.equal(_get, NodeConstants._WORD_CLASS)) {
          _matched=true;
          _switchResult = new WordClassToken(node, driver);
        }
      }
      if (!_matched) {
        if (Objects.equal(_get, NodeConstants._WORD_FRAGMENT)) {
          _matched=true;
          _switchResult = new WordFragment(node, driver);
        }
      }
      if (!_matched) {
        if (Objects.equal(_get, NodeConstants._IMPL_RULE_TOKEN)) {
          _matched=true;
          _switchResult = new RuleToken(node, driver);
        }
      }
      if (!_matched) {
        if (Objects.equal(_get, NodeConstants._ACTION)) {
          _matched=true;
          _switchResult = new ActionNode(node, driver);
        }
      }
      if (!_matched) {
        if (Objects.equal(_get, NodeConstants._ACTION_OBJECT)) {
          _matched=true;
          _switchResult = new ActionObject(node, driver);
        }
      }
      if (!_matched) {
        if (Objects.equal(_get, NodeConstants._TENSE)) {
          _matched=true;
          _switchResult = new TenseNode(node, driver);
        }
      }
      if (!_matched) {
        if (Objects.equal(_get, Neo4jConstants._CLASS)) {
          _matched=true;
          _switchResult = new ClassNode(node, driver);
        }
      }
      if (!_matched) {
        if (Objects.equal(_get, NodeConstants._CONDITION)) {
          _matched=true;
          _switchResult = this.conditionFactory.create(node, driver);
        }
      }
      if (!_matched) {
        if (Objects.equal(_get, NodeConstants._INTERPUNCTION)) {
          _matched=true;
          _switchResult = this.interpunctionFactory.create(node, driver);
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
