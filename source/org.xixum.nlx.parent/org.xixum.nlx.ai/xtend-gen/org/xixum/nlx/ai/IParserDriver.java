package de.validas.nlx.ai;

import de.validas.nlx.ai.IContextFactory;
import de.validas.nlx.ai.IDbAccess;
import de.validas.nlx.ai.INodeFactory;
import de.validas.nlx.ai.IPredicateFactory;
import de.validas.nlx.ai.semantics.IContextNode;
import de.validas.nlx.ai.semantics.INode;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IParserDriver {
  public abstract IDbAccess getDbAccessor();
  
  public abstract IPredicateFactory getPredicateFactory();
  
  public abstract void setDbAccessor(final IDbAccess access);
  
  public abstract void setPredicateFactory(final IPredicateFactory factory);
  
  public abstract void setNodeFactory(final INodeFactory factory);
  
  public abstract INodeFactory getNodeFactory();
  
  public abstract void setContextFactory(final INodeFactory factory);
  
  public abstract IContextFactory getContextFactory();
  
  public abstract IContextNode newContext();
  
  public abstract void setContext(final IContextNode node);
  
  public abstract IContextNode getContext();
  
  public abstract IBuildLogger getLogger();
  
  public abstract INode getNodeById(final Node node);
  
  public abstract List<Record> listConnections(final Node source, final String type);
  
  public abstract IParserDriver newCache();
}
