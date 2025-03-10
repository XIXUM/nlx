/**
 * Link Processor Class. Queries Database for Link rules or creates new rules
 * (c) 2020 felixschaller.com and sub brands
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * www.felixschaller.com
 * @author Felix Schaller
 */
package org.xixum.nlx.view.fxviews.semantics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IDbAccess;
import org.xixum.nlx.ai.util.Arrow;
import org.xixum.nlx.ai.util.NodeUtil;
import org.xixum.nlx.constants.Direction;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.constants.NodeConstants;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.view.fxviews.cache.CachedDeadLink;
import org.xixum.nlx.view.fxviews.cache.CachedLink;
import org.xixum.nlx.view.fxviews.cache.CachedNode;
import org.xixum.nlx.view.fxviews.cache.ICacheObj;
import org.xixum.nlx.view.fxviews.cache.INodeCacheManager;
import org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants;

/**
 * LinkProcessor solves the the semantics in the panelChain. it communicates with the database
 * to resolve sentence structure or trains new patterns.
 * 
 * TODO: currently an functional approach. Consider to implement these functionalities & behavior inside the panel nodes itself.
 */
@SuppressWarnings("all")
public class LinkProcessor {
  protected final String[] wordDefault = { "None" };

  protected final String[] allGrammarAttrs = { Neo4jConstants._MID, Neo4jConstants._IN_BOX, Neo4jConstants._OUT_BOX };

  protected final String[] wordTArray /* Skipped initializer because of errors */;

  protected final List<String> wordTypes = (List<String>)Conversions.doWrapArray(this.wordTArray);

  protected IDictionaryAccess dictAccess;

  protected SemanticLinker semanticLinker;

  protected INodeCacheManager cacheManager;

  private boolean useCache = false;

  public LinkProcessor(final IDictionaryAccess dictAccess, final SemanticLinker linker, final INodeCacheManager manager) {
    this.dictAccess = dictAccess;
    this.semanticLinker = linker;
    this.cacheManager = manager;
  }

  /**
   * resolves the Grammar tree for the sentence
   */
  public /* List<XPair<ILinkable, Boolean>> */Object evaluateNext(final ILinkable source) {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved to a type."
      + "\nXPair cannot be resolved to a type."
      + "\nThe method or field successor is undefined for the type ILinkObj"
      + "\nThe method or field successor is undefined for the type ILinkObj"
      + "\nXPair cannot be resolved."
      + "\nThe method or field successor is undefined for the type Object"
      + "\nXPair cannot be resolved."
      + "\nXPair cannot be resolved."
      + "\nThe method or field successor is undefined for the type ILinkObj"
      + "\nThe method or field successor is undefined for the type ILinkObj"
      + "\nXPair cannot be resolved."
      + "\nThe method or field value is undefined for the type Object"
      + "\nThe method or field value is undefined for the type Object"
      + "\nThe method or field index is undefined for the type Object"
      + "\nXPair cannot be resolved."
      + "\nXPair cannot be resolved."
      + "\nXPair cannot be resolved."
      + "\nXPair cannot be resolved."
      + "\nType mismatch: cannot convert from Object to Iterable<?>"
      + "\nThe method addAllExcl(Set<XPair>, List<XPair>) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method evaluateNext(ILinkable) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method addExcl(Set<XPair>, XPair) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method addAllExcl(Set<XPair>, List<XPair>) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method evaluateNext(ILinkable) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method addExcl(Set<XPair>, XPair) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method findLink(ILinkable, ILinkable, HashMap<String, Intermediate>) from the type LinkProcessor refers to the missing type XPair"
      + "\n!== cannot be resolved"
      + "\n!== cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nlink cannot be resolved"
      + "\n>= cannot be resolved"
      + "\n== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\nempty cannot be resolved"
      + "\nkey cannot be resolved"
      + "\nequals cannot be resolved"
      + "\nkey cannot be resolved");
  }

  /**
   * Extension Method, avoid double subentries in Set
   */
  public void addExcl(final /* Set<XPair<ILinkable, Boolean>> */Object set, final /* XPair<ILinkable, Boolean> */Object pair) {
    throw new Error("Unresolved compilation problems:"
      + "\nkey cannot be resolved"
      + "\n== cannot be resolved"
      + "\nkey cannot be resolved");
  }

  /**
   * Extension Method, avoid double subentries in Set from List
   */
  public void addAllExcl(final /* Set<XPair<ILinkable, Boolean>> */Object set, final /* List<XPair<ILinkable, Boolean>> */Object pairs) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method addExcl(Set<XPair>, XPair) from the type LinkProcessor refers to the missing type XPair");
  }

  /**
   * make postprocess
   */
  public void postProcess(final ILinkObj linkable, final ImplicitRulesOnDict grammar) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field successor is undefined for the type ILinkObj"
      + "\nThe method or field getTypes is undefined for the type ILinkObj"
      + "\nThe method or field getTypes is undefined for the type ILinkObj"
      + "\n!== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nempty cannot be resolved"
      + "\n! cannot be resolved");
  }

  public /* List<XPair<ILinkable, Boolean>> */Object findLink(final ILinkable first, final ILinkable second, final HashMap<String, Intermediate> attributes) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method recordToLink(List<Record>, ILinkable, ILinkable, Map<? extends String, ?>, String) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method recordToLink(List<Record>, ILinkable, ILinkable, Map<? extends String, ?>, String) from the type LinkProcessor refers to the missing type XPair");
  }

  protected ArrayList<ICacheObj> extractFromRec(final List<Record> records, final String varName, final boolean not_empty, final ILinkable token) {
    String typelabel = "";
    Node node = null;
    ArrayList<ICacheObj> nodes = CollectionLiterals.<ICacheObj>newArrayList();
    if (not_empty) {
      for (final Record rec : records) {
        {
          node = rec.get(varName).asNode();
          typelabel = node.get(Neo4jConstants._NAME).asString();
          nodes.add(this.cacheManager.addNode(typelabel, ((String[])Conversions.unwrapArray(node.labels(), String.class))[0], rec, varName));
        }
      }
      return nodes;
    } else {
      return this.nodeToTypes(token, false);
    }
  }

  protected ArrayList<ICacheObj> nodeToTypes(final ILinkable node, final boolean useCache) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field types is undefined for the type ILinkable"
      + "\n=== cannot be resolved"
      + "\nkey cannot be resolved"
      + "\nkey cannot be resolved");
  }

  protected void addToCache(final List<Record> records, final ILinkable first, final ILinkable second, final String attrs) {
    boolean not_empty = ((records != null) && (!records.isEmpty()));
    ArrayList<ICacheObj> firstNodes = this.extractFromRec(records, Neo4jConstants._SOURCE, not_empty, first);
    ArrayList<ICacheObj> secondNodes = this.extractFromRec(records, Neo4jConstants._TARGET, not_empty, second);
    for (final ICacheObj firstNode : firstNodes) {
      for (final ICacheObj secondNode : secondNodes) {
        {
          ICacheObj link = null;
          if (not_empty) {
            for (final Record rec : records) {
              {
                CachedLink _cachedLink = new CachedLink(firstNode, secondNode, attrs, rec, Neo4jConstants._LINK);
                link = _cachedLink;
                firstNode.setOutLink(link);
                secondNode.setInLink(link);
              }
            }
          } else {
            CachedDeadLink _cachedDeadLink = new CachedDeadLink(firstNode, secondNode);
            link = _cachedDeadLink;
            firstNode.setOutLink(link);
            secondNode.setInLink(link);
          }
        }
      }
    }
  }

  protected ArrayList<ICacheObj> findInCache(final ILinkable first, final ILinkable second, final HashMap<String, Intermediate> attributes) {
    ArrayList<ICacheObj> firstNodes = this.nodeToTypes(first, true);
    ArrayList<ICacheObj> secondNodes = this.nodeToTypes(second, true);
    this.addGrammarAttrib(first, Neo4jConstants._OUT_BOX, attributes);
    this.addGrammarAttrib(second, Neo4jConstants._IN_BOX, attributes);
    String attrs = this.generateLinkType(attributes);
    ArrayList<ICacheObj> result = CollectionLiterals.<ICacheObj>newArrayList();
    boolean _not = (!(firstNodes.isEmpty() || secondNodes.isEmpty()));
    if (_not) {
      for (final ICacheObj firstNode : firstNodes) {
        for (final ICacheObj secondNode : secondNodes) {
          {
            ICacheObj link = ((CachedNode) firstNode).hasLinkTo(secondNode, attrs);
            if ((link != null)) {
              result.add(link);
            }
          }
        }
      }
    }
    return result;
  }

  public Intermediate addGrammarAttrib(final ILinkable linkable, final String channel, final HashMap<String, Intermediate> map) {
    Intermediate _xifexpression = null;
    if ((linkable instanceof ILinkContainer)) {
      Intermediate _intermediate = new Intermediate(linkable);
      _xifexpression = map.put(channel, _intermediate);
    }
    return _xifexpression;
  }

  protected void removeFromCache(final ILinkable first, final ILinkable second) {
    ArrayList<ICacheObj> firstNodes = this.nodeToTypes(first, true);
    ArrayList<ICacheObj> secondNodes = this.nodeToTypes(second, true);
    boolean _not = (!(firstNodes.isEmpty() || secondNodes.isEmpty()));
    if (_not) {
      for (final ICacheObj firstNode : firstNodes) {
        for (final ICacheObj secondNode : secondNodes) {
          ((CachedNode) firstNode).removeLinkTo(secondNode);
        }
      }
    }
  }

  public /* List<XPair<ILinkable, Boolean>> */Object createLink(final ILinkable first, final ILinkable second, final Intermediate intermediate) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field key is undefined for the type Object"
      + "\nThe method or field key is undefined for the type Object"
      + "\nThe method or field type is undefined for the type ILinkable"
      + "\nThe method or field type is undefined for the type ILinkable"
      + "\nThe method recordToLink(List<Record>, ILinkable, ILinkable, Map<? extends String, ?>, String) from the type LinkProcessor refers to the missing type XPair"
      + "\nvalue cannot be resolved"
      + "\nbaseNode cannot be resolved"
      + "\nid cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nbaseNode cannot be resolved"
      + "\nid cannot be resolved");
  }

  protected String generateLinkType(final HashMap<String, Intermediate> map) {
    StringConcatenation _builder = new StringConcatenation();
    String sequence = _builder.toString();
    boolean _isEmpty = map.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      boolean first = true;
      Set<String> _keySet = map.keySet();
      for (final String attr : _keySet) {
        {
          String result = map.get(attr).generate(attr);
          if ((result != null)) {
            if ((!first)) {
              String _sequence = sequence;
              sequence = (_sequence + ", ");
            }
            String _sequence_1 = sequence;
            sequence = (_sequence_1 + result);
            first = false;
          }
        }
      }
    }
    return sequence;
  }

  protected /* List<XPair> */Object recordToLink(final List<Record> records, final ILinkable first, final ILinkable second, final Map<? extends String, ?> intermediate, final String varName) {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved to a type."
      + "\nXPair cannot be resolved."
      + "\nThe method evaluateNext(ILinkable) from the type LinkProcessor refers to the missing type XPair"
      + "\nkey cannot be resolved"
      + "\nkey cannot be resolved");
  }

  protected Pair<CharSequence, Intermediate> generateQuery(final ILinkable linkable, final String varName, final String type, final boolean allowCardinal) {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from Object to ILinkable");
  }

  public Pair<CharSequence, Intermediate> createSentenceQuery(final ILinkContainer linkable, final String varName) {
    Pair<CharSequence, Intermediate> _xblockexpression = null;
    {
      IDbAccess _dbAccessor = this.dictAccess.getDbAccessor();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(varName);
      _builder.append(":");
      _builder.append(GrammarConstants.PARAGRAPH_);
      _builder.append("{");
      _builder.append(Neo4jConstants._NAME);
      _builder.append(":\"");
      _builder.append(GrammarConstants.PLAIN_);
      _builder.append("\"}");
      Node family = NodeUtil.nodeExistOrCreate(_dbAccessor, _builder.toString(), varName, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), false);
      IDbAccess _dbAccessor_1 = this.dictAccess.getDbAccessor();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(varName);
      _builder_1.append(":");
      _builder_1.append(GrammarConstants.SENTENCE_CLASS_);
      _builder_1.append("{");
      _builder_1.append(Neo4jConstants._NAME);
      _builder_1.append(":\"");
      String _name = linkable.getLinkType().getName();
      _builder_1.append(_name);
      _builder_1.append("\"}");
      Node node = NodeUtil.nodeExistOrCreate(_dbAccessor_1, _builder_1.toString(), varName, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), false);
      IDbAccess _dbAccessor_2 = this.dictAccess.getDbAccessor();
      Arrow _arrow = new Arrow(Neo4jConstants._LINK, NodeConstants._OF_CLASS, Direction.LEFT);
      NodeUtil.connectionExistOrCreate(_dbAccessor_2, family, _arrow, node);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("MATCH (");
      _builder_2.append(varName);
      _builder_2.append(":");
      _builder_2.append(GrammarConstants.SENTENCE_CLASS_);
      _builder_2.append(") WHERE ID(");
      _builder_2.append(varName);
      _builder_2.append(") = ");
      long _id = node.id();
      _builder_2.append(_id);
      Intermediate _intermediate = new Intermediate(linkable);
      _xblockexpression = new Pair<CharSequence, Intermediate>(_builder_2, _intermediate);
    }
    return _xblockexpression;
  }

  protected Node grammarExistOrCreate(final String nodeName, final String attrs, final String varName, final List<String> exclude, final String optionalQuery, final boolean fail) {
    Node _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(varName);
      _builder.append(":");
      _builder.append(NodeConstants.GRAMMAR_CLUSTER_);
      _builder.append(" {");
      _builder.append(Neo4jConstants._NAME);
      _builder.append(":\"");
      _builder.append(nodeName);
      _builder.append("\" ");
      {
        if (((attrs != null) && (attrs.length() > 0))) {
          _builder.append(", ");
          _builder.append(attrs);
        }
      }
      _builder.append("}");
      String subQuery = _builder.toString();
      _xblockexpression = NodeUtil.nodeExistOrCreate(this.dictAccess.getDbAccessor(), subQuery, varName, exclude, optionalQuery, fail);
    }
    return _xblockexpression;
  }
}
