package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.dictionary.grammar.bool.BoolOr;
import de.validas.nlx.dictionary.grammar.nodes.ConditionNode;
import de.validas.nlx.dictionary.grammar.nodes.IDictNode;
import java.util.List;
import javax.annotation.Generated;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class BoolOrConditionNode extends ConditionNode {
  private static final BoolOr boolOr = new BoolOr();
  
  public BoolOrConditionNode(final Node node, final IParserDriver driver) {
    super(node, driver);
  }
  
  @Override
  public INode solve() {
    if ((this.predicates == null)) {
      List<Record> outs = this.listAllOutputs();
      this.createPredicates(outs);
    }
    INode result = this.doExecuteTypes(this.connections, BoolOrConditionNode.boolOr);
    if ((result instanceof IDictNode)) {
      return result;
    } else {
      return null;
    }
  }
}
