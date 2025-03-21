package org.xixum.nlx.ai;

import java.util.List;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.semantics.IContextNode;
import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public interface IParserDriver {
  IDbAccess getDbAccessor();

  /* IPredicateFactory */Object getPredicateFactory();

  void setDbAccessor(final IDbAccess access);

  void setPredicateFactory(final /* IPredicateFactory */Object factory);

  void setNodeFactory(final INodeFactory factory);

  INodeFactory getNodeFactory();

  void setContextFactory(final INodeFactory factory);

  IContextFactory getContextFactory();

  IContextNode newContext();

  void setContext(final IContextNode node);

  IContextNode getContext();

  IBuildLogger getLogger();

  INode getNodeById(final Node node);

  List<Record> listConnections(final Node source, final String type);

  IParserDriver newCache();
}
