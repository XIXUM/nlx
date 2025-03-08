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
package de.validas.nlx.view.fxviews.semantics;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.validas.nlx.ai.IDbAccess;
import de.validas.nlx.ai.neo4j.Neo4jAccess;
import de.validas.nlx.ai.util.Arrow;
import de.validas.nlx.ai.util.NodeUtil;
import de.validas.nlx.constants.Direction;
import de.validas.nlx.constants.Neo4jConstants;
import de.validas.nlx.dictionary.IDictionaryAccess;
import de.validas.nlx.dictionary.constants.DictionaryConstants;
import de.validas.nlx.dictionary.constants.NodeConstants;
import de.validas.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.view.fxviews.access.IItem;
import de.validas.nlx.view.fxviews.access.elements.KommaItem;
import de.validas.nlx.view.fxviews.access.elements.SeparatorItem;
import de.validas.nlx.view.fxviews.access.elements.SmallItem;
import de.validas.nlx.view.fxviews.access.elements.TerminalItem;
import de.validas.nlx.view.fxviews.cache.CachedDeadLink;
import de.validas.nlx.view.fxviews.cache.CachedLink;
import de.validas.nlx.view.fxviews.cache.CachedNode;
import de.validas.nlx.view.fxviews.cache.ICacheObj;
import de.validas.nlx.view.fxviews.cache.INodeCacheManager;
import de.validas.nlx.view.fxviews.semantics.ILink;
import de.validas.nlx.view.fxviews.semantics.ILinkContainer;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.ILinkType;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.semantics.Intermediate;
import de.validas.nlx.view.fxviews.semantics.SemanticLinker;
import de.validas.nlx.view.fxviews.semantics.constants.GrammarConstants;
import de.validas.nlx.view.fxviews.semantics.types.ICardinalLinkable;
import de.validas.nlx.view.fxviews.semantics.util.LinkUtils;
import de.validas.nlx.view.fxviews.visual.IPanel;
import de.validas.spedit.presets.NlxDictConstants;
import de.validas.utils.data.lists.IAppendable;
import de.validas.utils.data.types.XPair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Generated;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;

/**
 * LinkProcessor solves the the semantics in the panelChain. it communicates with the database
 * to resolve sentence structure or trains new patterns.
 * 
 * TODO: currently an functional approach. Consider to implement these functionalities & behavior inside the panel nodes itself.
 */
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class LinkProcessor {
  protected final String[] wordDefault = { "None" };
  
  protected final String[] allGrammarAttrs = { Neo4jConstants._MID, Neo4jConstants._IN_BOX, Neo4jConstants._OUT_BOX };
  
  protected final String[] wordTArray = ((String[])Conversions.unwrapArray(Iterables.<String>concat(((Iterable<? extends String>)Conversions.doWrapArray(this.wordDefault)), NlxDictConstants.getAllTypes()), String.class));
  
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
  public List<XPair<ILinkable, Boolean>> evaluateNext(final ILinkable source) {
    List<XPair<ILinkable, Boolean>> _xblockexpression = null;
    {
      HashMap<String, Intermediate> attributes = CollectionLiterals.<String, Intermediate>newHashMap();
      boolean resolved = false;
      Set<XPair<ILinkable, Boolean>> destinations = null;
      ILinkable internalSource = source;
      IDbAccess _dbAccessor = this.dictAccess.getDbAccessor();
      boolean _tripleEquals = (_dbAccessor == null);
      if (_tripleEquals) {
        return null;
      }
      if ((internalSource instanceof ILinkObj)) {
        while ((((ILinkObj)internalSource).getToken() instanceof SmallItem)) {
          IAppendable _successor = ((ILinkObj)internalSource).getSuccessor();
          boolean _tripleNotEquals = (_successor != null);
          if (_tripleNotEquals) {
            IAppendable _successor_1 = ((ILinkObj)internalSource).getSuccessor();
            internalSource = ((ILinkObj) _successor_1);
          } else {
            XPair<ILinkable, Boolean> _xPair = new XPair<ILinkable, Boolean>(null, Boolean.valueOf(resolved));
            return Collections.<XPair<ILinkable, Boolean>>unmodifiableList(CollectionLiterals.<XPair<ILinkable, Boolean>>newArrayList(_xPair));
          }
        }
      }
      IAppendable successor = LinkUtils.findNextAdjacentPanel(internalSource, true).getSuccessor();
      if ((successor != null)) {
        ILinkObj internalSuccessor = ((ILinkObj) successor);
        while ((internalSuccessor.getToken() instanceof SmallItem)) {
          {
            IItem token = ((ILinkObj) internalSuccessor).getToken();
            boolean _matched = false;
            if (token instanceof KommaItem || token instanceof SeparatorItem) {
              _matched=true;
              boolean _containsKey = attributes.containsKey(Neo4jConstants._MID);
              boolean _not = (!_containsKey);
              if (_not) {
                ILinkType _internalType = ((TerminalItem)token).getInternalType();
                EObject _element = ((TerminalItem)token).getElement();
                Intermediate _intermediate = new Intermediate(_internalType, _element);
                attributes.put(Neo4jConstants._MID, _intermediate);
              }
            }
            if (!_matched) {
              if ((internalSource instanceof ILink)) {
                XPair<ILinkable, Boolean> _xPair = new XPair<ILinkable, Boolean>(internalSource, Boolean.valueOf(true));
                return Collections.<XPair<ILinkable, Boolean>>unmodifiableList(CollectionLiterals.<XPair<ILinkable, Boolean>>newArrayList(_xPair));
              } else {
                XPair<ILinkable, Boolean> _xPair_1 = new XPair<ILinkable, Boolean>(internalSource, Boolean.valueOf(false));
                return Collections.<XPair<ILinkable, Boolean>>unmodifiableList(CollectionLiterals.<XPair<ILinkable, Boolean>>newArrayList(_xPair_1));
              }
            }
            IAppendable _successor = internalSuccessor.getSuccessor();
            boolean _tripleNotEquals = (_successor != null);
            if (_tripleNotEquals) {
              IAppendable _successor_1 = internalSuccessor.getSuccessor();
              internalSuccessor = ((ILinkObj) _successor_1);
            } else {
              XPair<ILinkable, Boolean> _xPair_2 = new XPair<ILinkable, Boolean>(null, Boolean.valueOf(resolved));
              return Collections.<XPair<ILinkable, Boolean>>unmodifiableList(CollectionLiterals.<XPair<ILinkable, Boolean>>newArrayList(_xPair_2));
            }
          }
        }
        if ((destinations == null)) {
          destinations = CollectionLiterals.<XPair<ILinkable, Boolean>>newHashSet();
        }
        Map<String, List<ILink>> types = internalSuccessor.getLinks();
        List<ILink> links = null;
        if ((types != null)) {
          final Function<List<ILink>, Stream<ILink>> _function = (List<ILink> x) -> {
            return x.stream();
          };
          links = types.values().stream().<ILink>flatMap(_function).collect(Collectors.<ILink>toList());
        }
        if (((links != null) && (!links.isEmpty()))) {
          List<XPair<Integer, ILinkable>> _traceAllRoots = LinkUtils.traceAllRoots(((ILinkable) internalSuccessor), 0, false);
          for (final XPair<Integer, ILinkable> root : _traceAllRoots) {
            {
              ILinkObj overlap = LinkUtils.findNextAdjacentPanel(root.getValue(), false);
              ILinkable rLinkable = root.getValue();
              List<ILink> rlinks = rLinkable.getLink();
              int _index = overlap.getIndex();
              int _index_1 = internalSuccessor.getIndex();
              boolean _greaterEqualsThan = (_index >= _index_1);
              if (_greaterEqualsThan) {
                if ((Objects.equal(rlinks, null) || rlinks.isEmpty())) {
                  this.addAllExcl(destinations, this.evaluateNext(rLinkable));
                } else {
                  XPair<ILinkable, Boolean> _xPair = new XPair<ILinkable, Boolean>(rLinkable, Boolean.valueOf(false));
                  this.addExcl(destinations, _xPair);
                }
              }
            }
          }
        } else {
          this.addAllExcl(destinations, this.evaluateNext(((ILinkable) internalSuccessor)));
        }
        boolean found = false;
        for (final XPair<ILinkable, Boolean> dest : destinations) {
          boolean _equals = dest.getKey().equals(internalSuccessor);
          if (_equals) {
            found = true;
          }
        }
        if ((!found)) {
          XPair<ILinkable, Boolean> _xPair = new XPair<ILinkable, Boolean>(internalSuccessor, Boolean.valueOf(false));
          this.addExcl(destinations, _xPair);
        }
      } else {
        XPair<ILinkable, Boolean> _xPair_1 = new XPair<ILinkable, Boolean>(internalSource, Boolean.valueOf(true));
        return Collections.<XPair<ILinkable, Boolean>>unmodifiableList(CollectionLiterals.<XPair<ILinkable, Boolean>>newArrayList(_xPair_1));
      }
      if (((destinations != null) && (!destinations.isEmpty()))) {
        List<XPair<ILinkable, Boolean>> results = CollectionLiterals.<XPair<ILinkable, Boolean>>newArrayList();
        for (final XPair<ILinkable, Boolean> dest_1 : destinations) {
          {
            List<XPair<ILinkable, Boolean>> result = this.findLink(internalSource, dest_1.getKey(), attributes);
            if ((result != null)) {
              results.addAll(result);
            }
          }
        }
        if (((results != null) && (!results.isEmpty()))) {
          return results;
        }
      }
      XPair<ILinkable, Boolean> _xPair_2 = new XPair<ILinkable, Boolean>(internalSource, Boolean.valueOf(false));
      _xblockexpression = Collections.<XPair<ILinkable, Boolean>>unmodifiableList(CollectionLiterals.<XPair<ILinkable, Boolean>>newArrayList(_xPair_2));
    }
    return _xblockexpression;
  }
  
  /**
   * Extension Method, avoid double subentries in Set
   */
  public void addExcl(final Set<XPair<ILinkable, Boolean>> set, final XPair<ILinkable, Boolean> pair) {
    boolean found = false;
    for (final XPair<ILinkable, Boolean> el : set) {
      ILinkable _key = el.getKey();
      ILinkable _key_1 = pair.getKey();
      boolean _equals = Objects.equal(_key, _key_1);
      if (_equals) {
        found = true;
      }
    }
    if ((!found)) {
      set.add(pair);
    }
  }
  
  /**
   * Extension Method, avoid double subentries in Set from List
   */
  public void addAllExcl(final Set<XPair<ILinkable, Boolean>> set, final List<XPair<ILinkable, Boolean>> pairs) {
    for (final XPair<ILinkable, Boolean> pair : pairs) {
      this.addExcl(set, pair);
    }
  }
  
  /**
   * make postprocess
   */
  public void postProcess(final ILinkObj linkable, final ImplicitRulesOnDict grammar) {
    IAppendable _successor = linkable.getSuccessor();
    ILinkObj successor = ((ILinkObj) _successor);
    if (((linkable.getTypes() != null) && (!linkable.getTypes().isEmpty()))) {
      IItem token = linkable.getToken();
      if ((token != null)) {
        try {
          token.postProcess(grammar);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            e.printStackTrace();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
  }
  
  public List<XPair<ILinkable, Boolean>> findLink(final ILinkable first, final ILinkable second, final HashMap<String, Intermediate> attributes) {
    List<ICacheObj> _xifexpression = null;
    if (this.useCache) {
      _xifexpression = this.findInCache(first, second, attributes);
    } else {
      _xifexpression = Collections.<ICacheObj>unmodifiableList(CollectionLiterals.<ICacheObj>newArrayList());
    }
    List<ICacheObj> c_Result = _xifexpression;
    boolean _isEmpty = c_Result.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ArrayList<Record> records = CollectionLiterals.<Record>newArrayList();
      for (final ICacheObj entry : c_Result) {
        records.add(entry.getRecord());
      }
      return this.recordToLink(records, first, second, attributes, Neo4jConstants._LINK);
    } else {
      Pair<CharSequence, Intermediate> firstQ = this.generateQuery(first, Neo4jConstants._SOURCE, null, true);
      Pair<CharSequence, Intermediate> secondQ = this.generateQuery(second, Neo4jConstants._TARGET, null, false);
      if (((firstQ == null) || (secondQ == null))) {
        return null;
      }
      Intermediate _value = firstQ.getValue();
      boolean _tripleNotEquals = (_value != null);
      if (_tripleNotEquals) {
        attributes.put(Neo4jConstants._OUT_BOX, firstQ.getValue());
      }
      Intermediate _value_1 = secondQ.getValue();
      boolean _tripleNotEquals_1 = (_value_1 != null);
      if (_tripleNotEquals_1) {
        attributes.put(Neo4jConstants._IN_BOX, secondQ.getValue());
      }
      ArrayList<String> nonAttr = CollectionLiterals.<String>newArrayList(this.allGrammarAttrs);
      nonAttr.removeAll(attributes.keySet());
      String attrs = this.generateLinkType(attributes);
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _key = firstQ.getKey();
      _builder.append(_key);
      _builder.newLineIfNotEmpty();
      CharSequence _key_1 = secondQ.getKey();
      _builder.append(_key_1);
      _builder.newLineIfNotEmpty();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._SOURCE);
      _builder.append(")-[:");
      _builder.append(NodeConstants.GRAMMAR_LINK_);
      _builder.append(" {");
      _builder.append(NodeConstants._TYPE);
      _builder.append(":\"");
      _builder.append(GrammarConstants._FIRST);
      _builder.append("\"}]-(");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(":");
      _builder.append(NodeConstants.GRAMMAR_CLUSTER_);
      {
        if (((attrs != null) && (attrs.length() > 0))) {
          _builder.append(" {");
          _builder.append(attrs);
          _builder.append("}");
        }
      }
      _builder.append(")-[:");
      _builder.append(NodeConstants.GRAMMAR_LINK_);
      _builder.append(" {");
      _builder.append(NodeConstants._TYPE);
      _builder.append(":\"");
      _builder.append(GrammarConstants._SECOND);
      _builder.append("\"}]-(");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(") WHERE NOT (");
      {
        boolean _hasElements = false;
        for(final String attr : nonAttr) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(" OR ", "");
          }
          _builder.append("exists(");
          _builder.append(Neo4jConstants._LINK);
          _builder.append(".");
          _builder.append(attr);
          _builder.append(")");
        }
      }
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("CALL apoc.when(");
      _builder.append(Neo4jConstants._SOURCE);
      _builder.append("<>");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(", ");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"MATCH (");
      _builder.append(Neo4jConstants._LINK, " ");
      _builder.append(") WHERE NOT ((");
      _builder.append(Neo4jConstants._LINK, " ");
      _builder.append(")<-[:");
      _builder.append(NodeConstants.GRAMMAR_LINK_, " ");
      _builder.append("  {");
      _builder.append(NodeConstants._TYPE, " ");
      _builder.append(":\'");
      _builder.append(GrammarConstants._FIRST, " ");
      _builder.append("\'}]-(");
      _builder.append(Neo4jConstants._TARGET, " ");
      _builder.append(")) RETURN ");
      _builder.append(Neo4jConstants._LINK, " ");
      _builder.append("\", \"MATCH (");
      _builder.append(Neo4jConstants._LINK, " ");
      _builder.append(") RETURN ");
      _builder.append(Neo4jConstants._LINK, " ");
      _builder.append("\", {");
      _builder.append(Neo4jConstants._LINK, " ");
      _builder.append(":");
      _builder.append(Neo4jConstants._LINK, " ");
      _builder.append(", ");
      _builder.append(Neo4jConstants._TARGET, " ");
      _builder.append(":");
      _builder.append(Neo4jConstants._TARGET, " ");
      _builder.append(", ");
      _builder.append(Neo4jConstants._SOURCE, " ");
      _builder.append(":");
      _builder.append(Neo4jConstants._SOURCE, " ");
      _builder.append("}) YIELD ");
      _builder.append(Neo4jConstants._VALUE, " ");
      _builder.newLineIfNotEmpty();
      _builder.append("WITH ");
      _builder.append(Neo4jConstants._VALUE);
      _builder.append(".");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(" AS ");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(", ");
      _builder.append(Neo4jConstants._SOURCE);
      _builder.append(" AS ");
      _builder.append(Neo4jConstants._SOURCE);
      _builder.append(", ");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(" AS ");
      _builder.append(Neo4jConstants._TARGET);
      _builder.newLineIfNotEmpty();
      _builder.append("OPTIONAL MATCH (");
      _builder.append(Neo4jConstants._SOURCE);
      _builder.append(")-[");
      _builder.append(GrammarConstants._START);
      _builder.append(":");
      _builder.append(DictionaryConstants._FORWARD);
      _builder.append("]->(");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("OPTIONAL MATCH (");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(")-[");
      _builder.append(GrammarConstants._END);
      _builder.append(":");
      _builder.append(DictionaryConstants._FORWARD);
      _builder.append("]->(");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("OPTIONAL MATCH ");
      _builder.append(Neo4jConstants._P);
      _builder.append(" = (");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(")");
      CharSequence _generate = new Arrow(Neo4jConstants._E, DictionaryConstants._EXCLUDES, null, null, null, true, true, Direction.RIGHT).generate();
      _builder.append(_generate);
      _builder.append("(");
      _builder.append(Neo4jConstants._A);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("OPTIONAL MATCH (");
      _builder.append(Neo4jConstants._A);
      _builder.append(")");
      CharSequence _generate_1 = new Arrow(null, null, Direction.RIGHT).generate();
      _builder.append(_generate_1);
      _builder.append("(");
      _builder.append(Neo4jConstants._R);
      _builder.append(":");
      _builder.append(DictionaryConstants._REDUNDANCE);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("OPTIONAL MATCH (");
      _builder.append(Neo4jConstants._A);
      _builder.append(")");
      CharSequence _generate_2 = new Arrow(Neo4jConstants._L, null, Direction.RIGHT).generate();
      _builder.append(_generate_2);
      _builder.append("(");
      _builder.append(Neo4jConstants._B);
      _builder.append(") WHERE NOT (type(");
      _builder.append(Neo4jConstants._L);
      _builder.append(") = \"");
      _builder.append(DictionaryConstants._EXCLUDES);
      _builder.append("\" OR type(");
      _builder.append(Neo4jConstants._L);
      _builder.append(") = \"");
      _builder.append(DictionaryConstants._REDUNDANT);
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("RETURN ");
      _builder.append(Neo4jConstants._SOURCE);
      _builder.append(", ");
      _builder.append(Neo4jConstants._LINK);
      _builder.append(", ");
      _builder.append(Neo4jConstants._TARGET);
      _builder.append(", ");
      _builder.append(Neo4jConstants._A);
      _builder.append(", ");
      _builder.append(Neo4jConstants._P);
      _builder.append(", ");
      _builder.append(Neo4jConstants._R);
      _builder.append(", COLLECT ({");
      _builder.append(Neo4jConstants._LK);
      _builder.append(":{");
      _builder.append(Neo4jConstants._LI);
      _builder.append(": ID(");
      _builder.append(Neo4jConstants._L);
      _builder.append("), ");
      _builder.append(Neo4jConstants._LL);
      _builder.append(":type(");
      _builder.append(Neo4jConstants._L);
      _builder.append("), ");
      _builder.append(Neo4jConstants._LA);
      _builder.append(":");
      _builder.append(Neo4jConstants._L);
      _builder.append("}, ");
      _builder.append(Neo4jConstants._ND);
      _builder.append(":{");
      _builder.append(Neo4jConstants._NI);
      _builder.append(": ID(");
      _builder.append(Neo4jConstants._B);
      _builder.append("), ");
      _builder.append(Neo4jConstants._NL);
      _builder.append(":labels(");
      _builder.append(Neo4jConstants._B);
      _builder.append("), ");
      _builder.append(Neo4jConstants._NA);
      _builder.append(": ");
      _builder.append(Neo4jConstants._B);
      _builder.append("}}) as ");
      _builder.append(Neo4jConstants._ATTR);
      _builder.append(", ");
      _builder.append(GrammarConstants._START);
      _builder.append(", ");
      _builder.append(GrammarConstants._END);
      String query = _builder.toString();
      List<Record> result = this.dictAccess.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.READ);
      if (this.useCache) {
        this.addToCache(result, first, second, attrs);
      }
      return this.recordToLink(result, first, second, attributes, Neo4jConstants._LINK);
    }
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
    ArrayList<ICacheObj> _xblockexpression = null;
    {
      ArrayList<ICacheObj> result = CollectionLiterals.<ICacheObj>newArrayList();
      List<XPair<String, ITypeAttributes>> types = node.getTypes();
      if ((types == null)) {
        return result;
      }
      if (useCache) {
        for (final XPair<String, ITypeAttributes> type : types) {
          {
            ICacheObj cachedT = this.cacheManager.getNodeByName(type.getKey());
            if ((cachedT != null)) {
              result.add(cachedT);
            }
          }
        }
      } else {
        for (final XPair<String, ITypeAttributes> typelabel : types) {
          result.add(this.cacheManager.addNode(typelabel.getKey(), "", null, ""));
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
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
      Intermediate _intermediate = new Intermediate(((ILinkContainer)linkable));
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
  
  public List<XPair<ILinkable, Boolean>> createLink(final ILinkable first, final ILinkable second, final Intermediate intermediate) {
    if (this.useCache) {
      this.removeFromCache(first, second);
    }
    String _key = LinkUtils.getLinkHigherType(first).getKey();
    Pair<String, String> _mappedTo = Pair.<String, String>of(GrammarConstants._FIRST, _key);
    String _key_1 = LinkUtils.getLinkHigherType(second).getKey();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of(GrammarConstants._SECOND, _key_1);
    final Map<String, String> types = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1));
    long _id = first.getType().getValue().getBaseNode().id();
    Pair<String, Long> _mappedTo_2 = Pair.<String, Long>of(GrammarConstants._FIRST, Long.valueOf(_id));
    long _id_1 = second.getType().getValue().getBaseNode().id();
    Pair<String, Long> _mappedTo_3 = Pair.<String, Long>of(GrammarConstants._SECOND, Long.valueOf(_id_1));
    final Map<String, Long> typeIDs = Collections.<String, Long>unmodifiableMap(CollectionLiterals.<String, Long>newHashMap(_mappedTo_2, _mappedTo_3));
    final Pair<CharSequence, Intermediate> firstQ = this.generateQuery(first, Neo4jConstants._SOURCE, types.get(GrammarConstants._FIRST), true);
    final Pair<CharSequence, Intermediate> secondQ = this.generateQuery(second, Neo4jConstants._TARGET, types.get(GrammarConstants._SECOND), false);
    if (((firstQ == null) || (secondQ == null))) {
      return null;
    }
    final HashMap<String, Intermediate> attributes = CollectionLiterals.<String, Intermediate>newHashMap();
    if ((intermediate != null)) {
      attributes.put(Neo4jConstants._MID, intermediate);
    }
    Intermediate _value = firstQ.getValue();
    boolean _tripleNotEquals = (_value != null);
    if (_tripleNotEquals) {
      attributes.put(Neo4jConstants._OUT_BOX, firstQ.getValue());
    }
    Intermediate _value_1 = secondQ.getValue();
    boolean _tripleNotEquals_1 = (_value_1 != null);
    if (_tripleNotEquals_1) {
      attributes.put(Neo4jConstants._IN_BOX, secondQ.getValue());
    }
    final String attrs = this.generateLinkType(attributes);
    final ArrayList<String> nonAttr = CollectionLiterals.<String>newArrayList(this.allGrammarAttrs);
    nonAttr.removeAll(attributes.keySet());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._S);
    _builder.append(")-[");
    _builder.append(Neo4jConstants._L1);
    _builder.append(":");
    _builder.append(NodeConstants.GRAMMAR_LINK_);
    _builder.append(" {");
    _builder.append(NodeConstants._TYPE);
    _builder.append(":\"");
    _builder.append(GrammarConstants._FIRST);
    _builder.append("\"}]->(");
    _builder.append(Neo4jConstants._NODE);
    _builder.append(")<-[");
    _builder.append(Neo4jConstants._L2);
    _builder.append(":");
    _builder.append(NodeConstants.GRAMMAR_LINK_);
    _builder.append(" {");
    _builder.append(NodeConstants._TYPE);
    _builder.append(":\"");
    _builder.append(GrammarConstants._SECOND);
    _builder.append("\"}]-(");
    _builder.append(Neo4jConstants._T);
    _builder.append(") WHERE (ID(");
    _builder.append(Neo4jConstants._S);
    _builder.append(") =");
    Long _get = typeIDs.get(GrammarConstants._FIRST);
    _builder.append(_get);
    _builder.append(" AND ID(");
    _builder.append(Neo4jConstants._T);
    _builder.append(")=");
    Long _get_1 = typeIDs.get(GrammarConstants._SECOND);
    _builder.append(_get_1);
    _builder.append(")");
    final String additionalQuery = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    {
      if ((first instanceof ILink)) {
        _builder_1.append("(");
        String _get_2 = types.get(GrammarConstants._FIRST);
        _builder_1.append(_get_2);
        _builder_1.append(")");
      } else {
        String _get_3 = types.get(GrammarConstants._FIRST);
        _builder_1.append(_get_3);
      }
    }
    _builder_1.append(Neo4jConstants.ARROW_);
    {
      if ((second instanceof ILink)) {
        _builder_1.append("(");
        String _get_4 = types.get(GrammarConstants._SECOND);
        _builder_1.append(_get_4);
        _builder_1.append(")");
      } else {
        String _get_5 = types.get(GrammarConstants._SECOND);
        _builder_1.append(_get_5);
      }
    }
    final Node node = this.grammarExistOrCreate(_builder_1.toString(), attrs, Neo4jConstants._NODE, nonAttr, additionalQuery, true);
    if ((node == null)) {
      return null;
    }
    StringConcatenation _builder_2 = new StringConcatenation();
    CharSequence _key_2 = firstQ.getKey();
    _builder_2.append(_key_2);
    _builder_2.newLineIfNotEmpty();
    CharSequence _key_3 = secondQ.getKey();
    _builder_2.append(_key_3);
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("MATCH (");
    _builder_2.append(Neo4jConstants._LINK);
    _builder_2.append(":");
    _builder_2.append(NodeConstants.GRAMMAR_CLUSTER_);
    _builder_2.append(") WHERE ID(");
    _builder_2.append(Neo4jConstants._LINK);
    _builder_2.append(") = ");
    long _id_2 = node.id();
    _builder_2.append(_id_2);
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("MERGE (");
    _builder_2.append(Neo4jConstants._SOURCE);
    _builder_2.append(")-[:");
    _builder_2.append(NodeConstants.GRAMMAR_LINK_);
    _builder_2.append(" {");
    _builder_2.append(NodeConstants._TYPE);
    _builder_2.append(":\"");
    _builder_2.append(Neo4jConstants.FIRST_);
    _builder_2.append("\"}]->(");
    _builder_2.append(Neo4jConstants._LINK);
    _builder_2.append(")<-[:");
    _builder_2.append(NodeConstants.GRAMMAR_LINK_);
    _builder_2.append(" {");
    _builder_2.append(NodeConstants._TYPE);
    _builder_2.append(":\"");
    _builder_2.append(Neo4jConstants.SECOND_);
    _builder_2.append("\"}]-(");
    _builder_2.append(Neo4jConstants._TARGET);
    _builder_2.append(")");
    _builder_2.newLineIfNotEmpty();
    _builder_2.append("RETURN ");
    _builder_2.append(Neo4jConstants._SOURCE);
    _builder_2.append(", ");
    _builder_2.append(Neo4jConstants._TARGET);
    _builder_2.append(", ");
    _builder_2.append(Neo4jConstants._LINK);
    String query = _builder_2.toString();
    List<Record> result = this.dictAccess.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.WRITE);
    if (this.useCache) {
      this.addToCache(result, first, second, attrs);
    }
    return this.recordToLink(result, first, second, attributes, Neo4jConstants._LINK);
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
  
  protected List<XPair<ILinkable, Boolean>> recordToLink(final List<Record> records, final ILinkable first, final ILinkable second, final Map<? extends String, ?> intermediate, final String varName) {
    List<XPair<ILinkable, Boolean>> result = null;
    if (((records != null) && (!records.isEmpty()))) {
      Record _get = records.get(0);
      boolean _tripleEquals = (_get == null);
      if (_tripleEquals) {
        return null;
      }
      HashMap<Long, List<Record>> recMap = new HashMap<Long, List<Record>>();
      for (final Record rec : records) {
        {
          Node link = rec.get(Neo4jConstants._LINK).asNode();
          if ((link != null)) {
            List<Record> map = recMap.get(Long.valueOf(link.id()));
            if ((map == null)) {
              map = CollectionLiterals.<Record>newArrayList();
              recMap.put(Long.valueOf(link.id()), map);
            }
            map.add(rec);
          }
        }
      }
      Set<Long> _keySet = recMap.keySet();
      for (final Long id : _keySet) {
        {
          this.semanticLinker.makeLink(first, second, intermediate, recMap.get(id));
          final List<ILink> allLinks = CollectionLiterals.<ILink>newArrayList();
          boolean _matched = false;
          if (first instanceof ILinkObj) {
            _matched=true;
            final Consumer<List<ILink>> _function = (List<ILink> e) -> {
              allLinks.addAll(e);
            };
            ((ILinkObj)first).getLinks().values().forEach(_function);
          }
          if (!_matched) {
            if (first instanceof ILink) {
              _matched=true;
              allLinks.addAll(((ILink)first).getLinks());
            }
          }
          for (final ILink link : allLinks) {
            {
              if ((result == null)) {
                result = CollectionLiterals.<XPair<ILinkable, Boolean>>newArrayList();
              }
              List<XPair<ILinkable, Boolean>> value = this.evaluateNext(link);
              if (((value != null) && (!value.isEmpty()))) {
                result.addAll(value);
              }
              XPair<ILinkable, Boolean> selfLink = new XPair<ILinkable, Boolean>(((ILinkable) link), Boolean.valueOf(false));
              final Function1<XPair<ILinkable, Boolean>, ILinkable> _function = (XPair<ILinkable, Boolean> e) -> {
                return e.getKey();
              };
              boolean _contains = ListExtensions.<XPair<ILinkable, Boolean>, ILinkable>map(result, _function).contains(selfLink.getKey());
              boolean _not = (!_contains);
              if (_not) {
                result.add(selfLink);
              }
            }
          }
        }
      }
    }
    return result;
  }
  
  protected Pair<CharSequence, Intermediate> generateQuery(final ILinkable linkable, final String varName, final String type, final boolean allowCardinal) {
    Pair<CharSequence, Intermediate> _switchResult = null;
    boolean _matched = false;
    if (linkable instanceof ILinkContainer) {
      _matched=true;
      Pair<CharSequence, Intermediate> _xblockexpression = null;
      {
        List<ILinkable> _elvis = null;
        List<ILinkable> _allInnerLinks = ((ILinkContainer)linkable).getAllInnerLinks();
        if (_allInnerLinks != null) {
          _elvis = _allInnerLinks;
        } else {
          _elvis = Collections.<ILinkable>unmodifiableList(CollectionLiterals.<ILinkable>newArrayList());
        }
        List<ILinkable> inner = _elvis;
        Pair<CharSequence, Intermediate> _xifexpression = null;
        if (((inner != null) && (!inner.isEmpty()))) {
          Pair<CharSequence, Intermediate> _xblockexpression_1 = null;
          {
            ILinkable innerFirst = inner.get(0);
            _xblockexpression_1 = this.createSentenceQuery(((ILinkContainer)linkable), varName);
          }
          _xifexpression = _xblockexpression_1;
        } else {
          Pair<CharSequence, Intermediate> _xifexpression_1 = null;
          int _length = ((ILinkContainer)linkable).length(false);
          boolean _equals = (_length == 1);
          if (_equals) {
            _xifexpression_1 = this.createSentenceQuery(((ILinkContainer)linkable), varName);
          } else {
            _xifexpression_1 = null;
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      _switchResult = _xblockexpression;
    }
    if (!_matched) {
      if (linkable instanceof IPanel) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("MATCH (:");
        _builder.append(NodeConstants._WORD);
        _builder.append(" {");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(":\"");
        String _lowerCase = ((IPanel)linkable).getToken().getName().toLowerCase();
        _builder.append(_lowerCase);
        _builder.append("\"})-[:");
        _builder.append(NodeConstants._OF_CLASS);
        _builder.append("]->(");
        _builder.append(varName);
        {
          if (((type != null) && (type.length() > 0))) {
            _builder.append(": ");
            _builder.append(NodeConstants._WORD_CLASS);
            _builder.append(" {");
            _builder.append(Neo4jConstants._NAME);
            _builder.append(":\"");
            _builder.append(type);
            _builder.append("\"}");
          }
        }
        _builder.append(")");
        _switchResult = new Pair<CharSequence, Intermediate>(_builder, 
          null);
      }
    }
    if (!_matched) {
      if (linkable instanceof ILink) {
        _matched=true;
        Pair<CharSequence, Intermediate> _xblockexpression = null;
        {
          if ((((ILink)linkable).hasCardinalType() && allowCardinal)) {
            return this.generateQuery(((ILink)linkable).getCardinalType(), varName, null, allowCardinal);
          }
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("MATCH (");
          _builder.append(varName);
          _builder.append(":");
          _builder.append(NodeConstants.GRAMMAR_CLUSTER_);
          _builder.append(") WHERE ID(");
          _builder.append(varName);
          _builder.append(") = ");
          Object _record = ((ILink) linkable).getLinkInfo().getRecord(Neo4jConstants._LINK);
          long _id = ((Node) _record).id();
          _builder.append(_id);
          _xblockexpression = new Pair<CharSequence, Intermediate>(_builder, null);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (linkable instanceof ICardinalLinkable) {
        _matched=true;
        _switchResult = this.generateQuery(((ICardinalLinkable)linkable).getBaseType(), varName, null, allowCardinal);
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
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
