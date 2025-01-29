package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.dictionary.grammar.nodes.AbstractDictRuleObj;
import javax.annotation.Generated;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class ErrorNode extends AbstractDictRuleObj {
  private String message;
  
  public ErrorNode(final Node node, final IParserDriver driver) {
    this(node, driver, "");
  }
  
  public ErrorNode(final Node node, final IParserDriver driver, final String message) {
    super(node, driver);
    this.message = message;
  }
  
  @Override
  public INode solve() {
    return null;
  }
  
  public String getMessage() {
    return this.message;
  }
}
