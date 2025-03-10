package org.xixum.nlx.dictionary.grammar.nodes;

import java.util.List;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.dictionary.grammar.bool.BoolAnd;

@SuppressWarnings("all")
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
