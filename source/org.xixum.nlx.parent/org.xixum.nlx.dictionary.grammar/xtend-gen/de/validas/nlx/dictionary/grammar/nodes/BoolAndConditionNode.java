package de.validas.nlx.dictionary.grammar.nodes;

import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.ai.semantics.INode;
import de.validas.nlx.dictionary.grammar.bool.BoolAnd;
import de.validas.nlx.dictionary.grammar.nodes.ConditionNode;
import de.validas.nlx.dictionary.grammar.nodes.IDictNode;
import java.util.List;
import javax.annotation.Generated;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class BoolAndConditionNode extends ConditionNode {
  private static final BoolAnd boolAnd = new BoolAnd();
  
  public BoolAndConditionNode(final Node node, final IParserDriver driver) {
    super(node, driver);
  }
  
  @Override
  public INode solve() {
    if ((this.predicates == null)) {
      List<Record> outs = this.listAllOutputs();
      this.createPredicates(outs);
    }
    INode result = this.doExecuteTypes(this.connections, BoolAndConditionNode.boolAnd);
    if ((result instanceof IDictNode)) {
      return result;
    } else {
      return null;
    }
  }
}
