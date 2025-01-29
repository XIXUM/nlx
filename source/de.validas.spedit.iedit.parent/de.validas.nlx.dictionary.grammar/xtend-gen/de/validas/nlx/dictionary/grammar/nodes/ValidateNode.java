package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.grammar.nodes.ErrorNode;
import de.validas.nlx.dictionary.grammar.nodes.ITokenNode;
import de.validas.nlx.dictionary.grammar.token.IGrammarItem;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class ValidateNode {
  private INode errorNode;
  
  private INode nodeStart;
  
  private List<String> strings;
  
  public ValidateNode(final INode node, final INode node2, final List<String> strings) {
    this.nodeStart = node;
    List<String> _elvis = null;
    if (strings != null) {
      _elvis = strings;
    } else {
      _elvis = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
    }
    this.strings = _elvis;
    this.errorNode = null;
  }
  
  public HashMap<String, INode> validate() {
    HashMap<String, INode> _xblockexpression = null;
    {
      HashMap<String, INode> connections = new HashMap<String, INode>();
      for (final String connectionType : this.strings) {
        {
          Object connection = this.nodeStart.getAttribute(connectionType);
          if ((connection instanceof INode)) {
            Object _attribute = this.nodeStart.getAttribute(connectionType);
            connections.put(connectionType, ((INode) _attribute));
          } else {
            if ((this.errorNode == null)) {
              Node _nodeRef = this.nodeStart.getNodeRef();
              IParserDriver _driver = this.nodeStart.getDriver();
              ErrorNode _errorNode = new ErrorNode(_nodeRef, _driver);
              this.errorNode = _errorNode;
            }
            this.errorNode.setAttribute(connectionType, connection);
            IBuildLogger _logger = this.nodeStart.getDriver().getLogger();
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("[ERROR]: ");
            _builder.append(connectionType);
            _builder.append(" For:");
            _builder.newLineIfNotEmpty();
            _builder.append(connection);
            _builder.append(" -> at [");
            {
              if ((this.nodeStart instanceof ITokenNode)) {
                Object _attribute_1 = this.nodeStart.getAttribute(Neo4jConstants._TOKEN);
                int _index = ((IGrammarItem) _attribute_1).getIndex();
                _builder.append(_index);
              } else {
                _builder.append("null");
              }
            }
            _builder.append("]");
            _logger.log(_builder);
          }
        }
      }
      _xblockexpression = connections;
    }
    return _xblockexpression;
  }
  
  public boolean hasAnnotation() {
    boolean _xifexpression = false;
    if ((this.errorNode == null)) {
      _xifexpression = false;
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
  }
  
  public INode getAnnotation() {
    return this.errorNode;
  }
}
