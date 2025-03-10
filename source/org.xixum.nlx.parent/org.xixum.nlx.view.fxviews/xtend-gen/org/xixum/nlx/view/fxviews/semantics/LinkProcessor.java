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

import com.google.common.collect.Iterables;
import de.validas.spedit.presets.NlxDictConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.util.NodeUtil;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.constants.NodeConstants;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.view.fxviews.cache.ICacheObj;
import org.xixum.nlx.view.fxviews.cache.INodeCacheManager;

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

  protected final String[] wordTArray = ((String[])Conversions.unwrapArray(Iterables.<String>concat(((Iterable<? extends String>)Conversions.doWrapArray(this.wordDefault)), NlxDictConstants.getAllTypes()), String.class));

  protected final List<String> wordTypes = (List<String>)Conversions.doWrapArray(this.wordTArray);

  protected IDictionaryAccess dictAccess;

  protected /* SemanticLinker */Object semanticLinker;

  protected INodeCacheManager cacheManager;

  private boolean useCache = false;

  public LinkProcessor(final IDictionaryAccess dictAccess, final /* SemanticLinker */Object linker, final INodeCacheManager manager) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LinkProcessor.semanticLinker refers to the missing type SemanticLinker");
  }

  /**
   * resolves the Grammar tree for the sentence
   */
  public /* List<XPair<ILinkable, Boolean>> */Object evaluateNext(final /* ILinkable */Object source) {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nSmallItem cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nSmallItem cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nKommaItem cannot be resolved to a type."
      + "\nSeparatorItem cannot be resolved to a type."
      + "\nILink cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nILink cannot be resolved to a type."
      + "\nILinkable cannot be resolved to a type."
      + "\nILinkable cannot be resolved to a type."
      + "\nILinkable cannot be resolved to a type."
      + "\nXPair cannot be resolved to a type."
      + "\nXPair cannot be resolved."
      + "\nXPair cannot be resolved."
      + "\nXPair cannot be resolved."
      + "\nXPair cannot be resolved."
      + "\nThe method stream() is undefined for the type Object"
      + "\nXPair cannot be resolved."
      + "\nXPair cannot be resolved."
      + "\nXPair cannot be resolved."
      + "\nXPair cannot be resolved."
      + "\nILinkable cannot be resolved to a type."
      + "\nILinkable cannot be resolved to a type."
      + "\nThe method findNextAdjacentPanel(ILinkable, boolean) from the type LinkUtils refers to the missing type ILinkObj"
      + "\nThe constructor Intermediate(Object, EObject) refers to the missing type Object"
      + "\nThe SeparatorItem is already covered by the caught KommaItem"
      + "\nThe KommaItem is already covered by the caught SeparatorItem"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThe method traceAllRoots(ILinkable, int, boolean) from the type LinkUtils refers to the missing type XPair"
      + "\nThe method findNextAdjacentPanel(ILinkable, boolean) from the type LinkUtils refers to the missing type ILinkObj"
      + "\nThe method addAllExcl(Set<XPair>, List<XPair>) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method evaluateNext(ILinkable) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method addExcl(Set<XPair>, XPair) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method addAllExcl(Set<XPair>, List<XPair>) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method evaluateNext(ILinkable) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method addExcl(Set<XPair>, XPair) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method findLink(ILinkable, ILinkable, HashMap<String, Intermediate>) from the type LinkProcessor refers to the missing type XPair"
      + "\ntoken cannot be resolved"
      + "\nsuccessor cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nsuccessor cannot be resolved"
      + "\nsuccessor cannot be resolved"
      + "\n!== cannot be resolved"
      + "\ntoken cannot be resolved"
      + "\ntoken cannot be resolved"
      + "\ninternalType cannot be resolved"
      + "\nelement cannot be resolved"
      + "\nsuccessor cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nsuccessor cannot be resolved"
      + "\nlinks cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nvalues cannot be resolved"
      + "\nstream cannot be resolved"
      + "\nflatMap cannot be resolved"
      + "\ncollect cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nlink cannot be resolved"
      + "\nindex cannot be resolved"
      + "\n>= cannot be resolved"
      + "\nindex cannot be resolved"
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
  public Object postProcess(final /* ILinkObj */Object linkable, final ImplicitRulesOnDict grammar) {
    throw new Error("Unresolved compilation problems:"
      + "\nILinkObj cannot be resolved to a type."
      + "\nsuccessor cannot be resolved"
      + "\ngetTypes cannot be resolved"
      + "\n!== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\ngetTypes cannot be resolved"
      + "\nempty cannot be resolved"
      + "\n! cannot be resolved"
      + "\ntoken cannot be resolved"
      + "\n!== cannot be resolved"
      + "\npostProcess cannot be resolved");
  }

  public /* List<XPair<ILinkable, Boolean>> */Object findLink(final /* ILinkable */Object first, final /* ILinkable */Object second, final HashMap<String, Intermediate> attributes) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method findInCache(ILinkable, ILinkable, HashMap<String, Intermediate>) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method recordToLink(List<Record>, ILinkable, ILinkable, Map<? extends String, ?>, String) from the type LinkProcessor refers to the missing type XPair"
      + "\nThe method generateQuery(ILinkable, String, String, boolean) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method generateQuery(ILinkable, String, String, boolean) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method addToCache(List<Record>, ILinkable, ILinkable, String) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method recordToLink(List<Record>, ILinkable, ILinkable, Map<? extends String, ?>, String) from the type LinkProcessor refers to the missing type XPair");
  }

  protected ArrayList<ICacheObj> extractFromRec(final List<Record> records, final String varName, final boolean not_empty, final /* ILinkable */Object token) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method nodeToTypes(ILinkable, boolean) from the type LinkProcessor refers to the missing type ILinkable");
  }

  protected ArrayList<ICacheObj> nodeToTypes(final /* ILinkable */Object node, final boolean useCache) {
    throw new Error("Unresolved compilation problems:"
      + "\ntypes cannot be resolved"
      + "\n=== cannot be resolved"
      + "\nkey cannot be resolved"
      + "\nkey cannot be resolved");
  }

  protected void addToCache(final List<Record> records, final /* ILinkable */Object first, final /* ILinkable */Object second, final String attrs) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method extractFromRec(List<Record>, String, boolean, ILinkable) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method extractFromRec(List<Record>, String, boolean, ILinkable) from the type LinkProcessor refers to the missing type ILinkable");
  }

  protected ArrayList<ICacheObj> findInCache(final /* ILinkable */Object first, final /* ILinkable */Object second, final HashMap<String, Intermediate> attributes) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method nodeToTypes(ILinkable, boolean) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method nodeToTypes(ILinkable, boolean) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method addGrammarAttrib(ILinkable, String, HashMap<String, Intermediate>) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method addGrammarAttrib(ILinkable, String, HashMap<String, Intermediate>) from the type LinkProcessor refers to the missing type ILinkable");
  }

  public Intermediate addGrammarAttrib(final /* ILinkable */Object linkable, final String channel, final HashMap<String, Intermediate> map) {
    throw new Error("Unresolved compilation problems:"
      + "\nILinkContainer cannot be resolved to a type."
      + "\nThe constructor Intermediate(Object) refers to the missing type Object");
  }

  protected void removeFromCache(final /* ILinkable */Object first, final /* ILinkable */Object second) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method nodeToTypes(ILinkable, boolean) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method nodeToTypes(ILinkable, boolean) from the type LinkProcessor refers to the missing type ILinkable");
  }

  public /* List<XPair<ILinkable, Boolean>> */Object createLink(final /* ILinkable */Object first, final /* ILinkable */Object second, final Intermediate intermediate) {
    throw new Error("Unresolved compilation problems:"
      + "\nILink cannot be resolved to a type."
      + "\nILink cannot be resolved to a type."
      + "\nThe method removeFromCache(ILinkable, ILinkable) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method getLinkHigherType(ILinkable) from the type LinkUtils refers to the missing type Object"
      + "\nThe method getLinkHigherType(ILinkable) from the type LinkUtils refers to the missing type Object"
      + "\nThe method generateQuery(ILinkable, String, String, boolean) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method generateQuery(ILinkable, String, String, boolean) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method addToCache(List<Record>, ILinkable, ILinkable, String) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method recordToLink(List<Record>, ILinkable, ILinkable, Map<? extends String, ?>, String) from the type LinkProcessor refers to the missing type XPair"
      + "\nkey cannot be resolved"
      + "\nkey cannot be resolved"
      + "\ntype cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nbaseNode cannot be resolved"
      + "\nid cannot be resolved"
      + "\ntype cannot be resolved"
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

  protected /* List<XPair> */Object recordToLink(final List<Record> records, final /* ILinkable */Object first, final /* ILinkable */Object second, final Map<? extends String, ?> intermediate, final String varName) {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved to a type."
      + "\nILink cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nILink cannot be resolved to a type."
      + "\nILinkable cannot be resolved to a type."
      + "\nXPair cannot be resolved."
      + "\nILinkable cannot be resolved to a type."
      + "\nThe field LinkProcessor.semanticLinker refers to the missing type SemanticLinker"
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThe method evaluateNext(ILinkable) from the type LinkProcessor refers to the missing type XPair"
      + "\nmakeLink cannot be resolved"
      + "\nlinks cannot be resolved"
      + "\nvalues cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\nlinks cannot be resolved"
      + "\nkey cannot be resolved"
      + "\nkey cannot be resolved");
  }

  protected Pair<CharSequence, Intermediate> generateQuery(final /* ILinkable */Object linkable, final String varName, final String type, final boolean allowCardinal) {
    throw new Error("Unresolved compilation problems:"
      + "\nILinkContainer cannot be resolved to a type."
      + "\nIPanel cannot be resolved to a type."
      + "\nILink cannot be resolved to a type."
      + "\nILink cannot be resolved to a type."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nUnreachable code: The case can never match. It is already handled by a previous condition."
      + "\nThe method createSentenceQuery(ILinkContainer, String) from the type LinkProcessor refers to the missing type ILinkContainer"
      + "\nThe method createSentenceQuery(ILinkContainer, String) from the type LinkProcessor refers to the missing type ILinkContainer"
      + "\nThe method generateQuery(ILinkable, String, String, boolean) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nThe method generateQuery(ILinkable, String, String, boolean) from the type LinkProcessor refers to the missing type ILinkable"
      + "\nallInnerLinks cannot be resolved"
      + "\n?: cannot be resolved"
      + "\n!== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nempty cannot be resolved"
      + "\n! cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlength cannot be resolved"
      + "\n== cannot be resolved"
      + "\ntoken cannot be resolved"
      + "\nname cannot be resolved"
      + "\ntoLowerCase cannot be resolved"
      + "\nhasCardinalType cannot be resolved"
      + "\n&& cannot be resolved"
      + "\ncardinalType cannot be resolved"
      + "\nlinkInfo cannot be resolved"
      + "\ngetRecord cannot be resolved"
      + "\nbaseType cannot be resolved");
  }

  public Pair<CharSequence, Intermediate> createSentenceQuery(final /* ILinkContainer */Object linkable, final String varName) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor Intermediate(Object) refers to the missing type Object"
      + "\nlinkType cannot be resolved"
      + "\nname cannot be resolved");
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
