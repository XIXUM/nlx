/**
 * AbstractDictRuleObj - Base Obj for Abstract dictionary rules
 * (c) 2020 licensed under Apache Public License 2.0
 * www.felixschaller.com
 * @author Felix Schaller
 */
package de.validas.nlx.ai.semantics;

import de.validas.nlx.ai.IFunction1;
import de.validas.nlx.ai.IParserDriver;
import de.validas.nlx.constants.Direction;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface INode {
  public abstract INode solve();
  
  public abstract Node getNodeRef();
  
  public abstract IParserDriver getDriver();
  
  public abstract void setNodeRef(final Node node);
  
  public abstract List<Record> listAllConnections();
  
  public abstract List<Record> listConnections(final String type);
  
  public abstract List<Record> listAllOutputs();
  
  public abstract List<Record> listAllInputs();
  
  public abstract Object getAttribute(final String key);
  
  public abstract Object setAttribute(final String key, final Object value);
  
  public abstract long getID();
  
  public abstract String getLabel();
  
  public abstract String getName();
  
  public abstract boolean hasLabel(final Node node, final String name);
  
  public abstract void setFilter(final String filter);
  
  public abstract INode findNodeAndCreateTarget(final String string, final IFunction1<Object, ?> delegate);
  
  public abstract List<Node> findNodeTypeByName(final String type, final String name);
  
  public abstract List<Node> findLinkedNodeByName(final String string, final String linkType, final Direction dir);
  
  public abstract Map<Long, Map<String, INode>> getChildren();
}
