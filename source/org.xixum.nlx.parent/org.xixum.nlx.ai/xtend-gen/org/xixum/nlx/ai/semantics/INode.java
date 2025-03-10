/**
 * AbstractDictRuleObj - Base Obj for Abstract dictionary rules
 * (c) 2020 licensed under Apache Public License 2.0
 * www.felixschaller.com
 * @author Felix Schaller
 */
package org.xixum.nlx.ai.semantics;

import java.util.List;
import java.util.Map;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IFunction1;
import org.xixum.nlx.ai.IParserDriver;
import org.xixum.nlx.constants.Direction;

@SuppressWarnings("all")
public interface INode {
  INode solve();

  Node getNodeRef();

  IParserDriver getDriver();

  void setNodeRef(final Node node);

  List<Record> listAllConnections();

  List<Record> listConnections(final String type);

  List<Record> listAllOutputs();

  List<Record> listAllInputs();

  Object getAttribute(final String key);

  Object setAttribute(final String key, final Object value);

  long getID();

  String getLabel();

  String getName();

  boolean hasLabel(final Node node, final String name);

  void setFilter(final String filter);

  INode findNodeAndCreateTarget(final String string, final IFunction1<Object, ?> delegate);

  List<Node> findNodeTypeByName(final String type, final String name);

  List<Node> findLinkedNodeByName(final String string, final String linkType, final Direction dir);

  Map<Long, Map<String, INode>> getChildren();
}
