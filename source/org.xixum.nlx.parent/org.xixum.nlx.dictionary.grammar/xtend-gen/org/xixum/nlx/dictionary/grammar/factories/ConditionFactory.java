package org.xixum.nlx.dictionary.grammar.factories;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.INodeFactory;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.constants.NodeConstants;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
import org.xixum.nlx.dictionary.grammar.nodes.AbstractDictRuleObj;
import org.xixum.nlx.dictionary.grammar.nodes.BoolAndConditionNode;
import org.xixum.nlx.dictionary.grammar.nodes.BoolOrConditionNode;
import org.xixum.nlx.dictionary.grammar.nodes.ErrorNode;

@SuppressWarnings("all")
public class ConditionFactory implements INodeFactory {
  @Override
  public INode create(final Node node, final IParserDriver driver) {
    AbstractDictRuleObj _xblockexpression = null;
    {
      Map<String, Object> _asMap = node.asMap();
      HashMap<String, Object> attributes = new HashMap<String, Object>(_asMap);
      final Object type = attributes.get(PredicateConstants.TYPE_);
      AbstractDictRuleObj _switchResult = null;
      boolean _matched = false;
      if (Objects.equals(type, NodeConstants._BOOL_AND)) {
        _matched=true;
        _switchResult = new BoolAndConditionNode(node, driver);
      }
      if (!_matched) {
        if (Objects.equals(type, NodeConstants._BOOL_OR)) {
          _matched=true;
          _switchResult = new BoolOrConditionNode(node, driver);
        }
      }
      if (!_matched) {
        ErrorNode _xblockexpression_1 = null;
        {
          IBuildLogger _logger = driver.getLogger();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("[ERROR]: ConditionFactory For:");
          _builder.newLine();
          _builder.append("Node -> [");
          long _id = node.id();
          _builder.append(_id);
          _builder.append(", ");
          Map<String, Object> _asMap_1 = node.asMap();
          _builder.append(_asMap_1);
          _builder.append("]");
          _logger.log(_builder);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("unknown boolean operator: \"");
          _builder_1.append(type);
          _builder_1.append("\"");
          _xblockexpression_1 = new ErrorNode(node, driver, _builder_1.toString());
        }
        _switchResult = _xblockexpression_1;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
