/**
 * This class does most of the tasks in the dictionary
 * 
 * @author: schaller
 * all Rights reserved (c) felixschaller.com
 */
package org.xixum.nlx.dictionary;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.neo4j.driver.internal.value.IntegerValue;
import org.neo4j.driver.internal.value.ListValue;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.internal.value.NullValue;
import org.neo4j.driver.internal.value.PathValue;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.neo4j.driver.internal.value.StringValue;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.exceptions.ClientException;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IDbAccess;
import org.xixum.nlx.ai.neo4j.Neo4jAccess;
import org.xixum.nlx.ai.util.Arrow;
import org.xixum.nlx.ai.util.NodeUtil;
import org.xixum.nlx.constants.Direction;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.dictionary.constants.DictionaryConstants;
import org.xixum.nlx.dictionary.constants.NodeConstants;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeHierarchy;
import org.xixum.nlx.dictionary.type.ITypeInfo;
import org.xixum.nlx.dictionary.type.InterpunctionTypeAttribute;
import org.xixum.nlx.dictionary.type.TypeAttributes;
import org.xixum.nlx.dictionary.type.TypeHierarchy;
import org.xixum.nlx.dictionary.type.WordTypeInfo;
import org.xixum.nlx.dictionary.type.elements.INodeEL;
import org.xixum.nlx.dictionary.type.elements.IRelationshipEL;
import org.xixum.nlx.dictionary.util.ILogUtils;
import org.xixum.utils.data.types.XPair;

@Singleton
@SuppressWarnings("all")
public class DictionaryAccess implements IDictionaryAccess {
  protected final int cutoff = NodeConstants.SUFFIX_.length();

  protected final HashSet<String> prefixes = CollectionLiterals.<String>newHashSet(DictionaryConstants.PREFIX_CONST_.split(" "));

  protected final HashSet<String> suffixes = CollectionLiterals.<String>newHashSet(DictionaryConstants.SUFFIX_CONST_.split(" "));

  protected final HashMap<String, String> singularPlural = CollectionLiterals.<String, String>newHashMap(((Pair<? extends String, ? extends String>[])Conversions.unwrapArray(IterableExtensions.<String, Pair<String, String>>flatMap(((Iterable<String>)Conversions.doWrapArray(DictionaryConstants.SINGULAR_PLURAL_.split(" "))), ((Function1<String, Set<Pair<String, String>>>) (String e) -> {
    String[] pairs = e.split("->");
    String _get = pairs[0];
    String _get_1 = pairs[1];
    Pair<String, String> _mappedTo = Pair.<String, String>of(_get, _get_1);
    return Collections.<Pair<String, String>>unmodifiableSet(CollectionLiterals.<Pair<String, String>>newHashSet(_mappedTo));
  })), Pair.class)));

  protected final List<Pair<String, String>> comparatives = Collections.<Pair<String, String>>unmodifiableList(CollectionLiterals.<Pair<String, String>>newArrayList(Pair.<String, String>of(DictionaryConstants._COMPARATIVE_SUFFIX, null), Pair.<String, String>of(DictionaryConstants._COMPARATIVE_SUFFIX, Neo4jConstants._E)));

  protected final List<Pair<String, String>> superlatives = Collections.<Pair<String, String>>unmodifiableList(CollectionLiterals.<Pair<String, String>>newArrayList(Pair.<String, String>of(DictionaryConstants._SUPERLATIVE_SUFFIX, null), Pair.<String, String>of(DictionaryConstants._SUPERLATIVE_SUFFIX, Neo4jConstants._E)));

  protected IDbAccess dbAccessor;

  protected HashMap<String, String> unknownWordCache;

  protected boolean isConnected = false;

  protected HashMap<String, ITypeInfo> typeCache;

  @Inject
  protected IBuildLogger buildLogger;

  @Inject
  protected ILogUtils logUtil;

  private final List<String> filter = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(Neo4jConstants._HIT, Neo4jConstants._NAME));

  private final List<String> nodeFilter = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(NodeConstants._WORD, DictionaryConstants._WORD_CLASS, NodeConstants._TENSE, NodeConstants.GRAMMAR_CLUSTER_, NodeConstants._GRAMMAR, DictionaryConstants._SUFFIX, NodeConstants._INTERPUNCTION));

  private final Map<String, Function1<String, String>> typeCase = Collections.<String, Function1<String, String>>unmodifiableMap(CollectionLiterals.<String, Function1<String, String>>newHashMap(Pair.<String, Function1<String, String>>of(NodeConstants._WORD, ((Function1<String, String>) (String n) -> {
    return n.toLowerCase();
  })), Pair.<String, Function1<String, String>>of(NodeConstants._INTERPUNCTION, ((Function1<String, String>) (String n) -> {
    return n.toUpperCase();
  }))));

  /**
   * constructor needs Logger and DatabaseInterface
   */
  @Inject
  public DictionaryAccess(final IDbAccess dbAccessor, final ILogUtils logUtil) {
    this.logUtil = logUtil;
    boolean _isConnected = dbAccessor.isConnected();
    if (_isConnected) {
      this.dbAccessor = dbAccessor;
    }
    this.typeCache = CollectionLiterals.<String, ITypeInfo>newHashMap();
    HashMap<String, String> _hashMap = new HashMap<String, String>();
    this.unknownWordCache = _hashMap;
  }

  /**
   * @return the dbAccessor
   */
  @Override
  public IDbAccess getDbAccessor() {
    return this.dbAccessor;
  }

  /**
   * simple plural with just suffix extension w.o. replacement.
   * @Deprecated
   * @param word
   * @param suffix
   * @return
   */
  protected List<Record> pluralToSingular(final String word, final String suffix, final String type, final String rel, final boolean inverse) {
    Pair<Boolean, Direction> _mappedTo = Pair.<Boolean, Direction>of(Boolean.valueOf(false), Direction.LEFT);
    Pair<Boolean, Direction> _mappedTo_1 = Pair.<Boolean, Direction>of(Boolean.valueOf(true), Direction.RIGHT);
    final Map<Boolean, Direction> direction = Collections.<Boolean, Direction>unmodifiableMap(CollectionLiterals.<Boolean, Direction>newHashMap(_mappedTo, _mappedTo_1));
    return this.findSiblingAndMerge(word, null, Neo4jConstants._S, direction.get(Boolean.valueOf(inverse)), rel, type, type);
  }

  /**
   * simple plural with just suffix extension w.o. replacement.
   * @Deprecated
   * @param word
   * @param suffix
   * @return
   */
  protected List<Record> singularToPlural(final String word, final String suffix, final String type, final String rel, final boolean inverse) {
    Pair<Boolean, Direction> _mappedTo = Pair.<Boolean, Direction>of(Boolean.valueOf(false), Direction.RIGHT);
    Pair<Boolean, Direction> _mappedTo_1 = Pair.<Boolean, Direction>of(Boolean.valueOf(true), Direction.LEFT);
    final Map<Boolean, Direction> direction = Collections.<Boolean, Direction>unmodifiableMap(CollectionLiterals.<Boolean, Direction>newHashMap(_mappedTo, _mappedTo_1));
    return this.findSiblingAndMerge(word, Neo4jConstants._S, null, direction.get(Boolean.valueOf(inverse)), rel, type, type);
  }

  /**
   * create relation to relative member
   */
  protected List<Record> findSiblingAndMerge(final String wordToLc, final String replSuffix, final String suffix, final Direction direction, final String edgeType, final String sourceType, final String targetType) {
    List<Record> _xblockexpression = null;
    {
      if (((suffix != null) && (!wordToLc.endsWith(suffix)))) {
        return null;
      }
      if (((replSuffix == null) && (suffix == null))) {
        return null;
      }
      Arrow arrow = new Arrow(null, null, Direction.RIGHT);
      int baselen = 0;
      if ((suffix != null)) {
        int _length = wordToLc.length();
        int _length_1 = suffix.length();
        int _minus = (_length - _length_1);
        baselen = _minus;
      } else {
        baselen = wordToLc.length();
      }
      String base = wordToLc.substring(0, baselen);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(");
      _builder.append(Neo4jConstants._T);
      _builder.append(")");
      Pair<Direction, String> _mappedTo = Pair.<Direction, String>of(Direction.RIGHT, _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(");
      _builder_1.append(Neo4jConstants._N);
      _builder_1.append(")");
      Pair<Direction, String> _mappedTo_1 = Pair.<Direction, String>of(Direction.LEFT, _builder_1.toString());
      final Map<Direction, String> target = Collections.<Direction, String>unmodifiableMap(CollectionLiterals.<Direction, String>newHashMap(_mappedTo, _mappedTo_1));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("MATCH (");
      _builder_2.append(Neo4jConstants._N);
      _builder_2.append(": ");
      _builder_2.append(NodeConstants._WORD);
      _builder_2.append(" {");
      _builder_2.append(Neo4jConstants._NAME);
      _builder_2.append(":\"");
      _builder_2.append(wordToLc);
      _builder_2.append("\"})");
      CharSequence _generate = arrow.generate();
      _builder_2.append(_generate);
      _builder_2.append("(");
      _builder_2.append(DictionaryConstants._WORD_CLASS);
      _builder_2.append(" {");
      _builder_2.append(Neo4jConstants._NAME);
      _builder_2.append(":\"");
      _builder_2.append(sourceType);
      _builder_2.append("\"})");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("MATCH (");
      _builder_2.append(Neo4jConstants._T);
      _builder_2.append(": ");
      _builder_2.append(NodeConstants._WORD);
      _builder_2.append(" {");
      _builder_2.append(Neo4jConstants._NAME);
      _builder_2.append(":\"");
      _builder_2.append(base);
      {
        if ((replSuffix != null)) {
          _builder_2.append(replSuffix);
        }
      }
      _builder_2.append("\"})");
      CharSequence _generate_1 = arrow.generate();
      _builder_2.append(_generate_1);
      _builder_2.append("(");
      _builder_2.append(DictionaryConstants._WORD_CLASS);
      _builder_2.append(" {");
      _builder_2.append(Neo4jConstants._NAME);
      _builder_2.append(":\"");
      _builder_2.append(targetType);
      _builder_2.append("\"})");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("MERGE (");
      _builder_2.append(Neo4jConstants._G);
      _builder_2.append(": ");
      _builder_2.append(NodeConstants._GRAMMAR);
      _builder_2.append(" {");
      _builder_2.append(Neo4jConstants._NAME);
      _builder_2.append(":\"");
      _builder_2.append(edgeType);
      _builder_2.append("\"})");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("MERGE (");
      _builder_2.append(Neo4jConstants._N);
      _builder_2.append(")");
      CharSequence _generate_2 = new Arrow(null, edgeType, direction).generate();
      _builder_2.append(_generate_2);
      _builder_2.append("(");
      _builder_2.append(Neo4jConstants._T);
      _builder_2.append(")");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("MERGE ");
      String _get = target.get(direction);
      _builder_2.append(_get);
      CharSequence _generate_3 = new Arrow(null, NodeConstants._FORM, Direction.RIGHT).generate();
      _builder_2.append(_generate_3);
      _builder_2.append("(");
      _builder_2.append(Neo4jConstants._G);
      _builder_2.append(")");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("RETURN ");
      _builder_2.append(Neo4jConstants._N);
      _builder_2.append(", ");
      _builder_2.append(Neo4jConstants._T);
      _builder_2.append(", ");
      _builder_2.append(Neo4jConstants._G);
      final String query = _builder_2.toString();
      _xblockexpression = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.WRITE);
    }
    return _xblockexpression;
  }

  /**
   * Wrapper to assign plural to Singular
   */
  protected List<Record> singularToPluralRepl(final String wordToLc, final String replSuffix, final String suffix, final String type, final String rel, final boolean inverse) {
    Pair<Boolean, Direction> _mappedTo = Pair.<Boolean, Direction>of(Boolean.valueOf(false), Direction.RIGHT);
    Pair<Boolean, Direction> _mappedTo_1 = Pair.<Boolean, Direction>of(Boolean.valueOf(true), Direction.LEFT);
    final Map<Boolean, Direction> direction = Collections.<Boolean, Direction>unmodifiableMap(CollectionLiterals.<Boolean, Direction>newHashMap(_mappedTo, _mappedTo_1));
    return this.findSiblingAndMerge(wordToLc, replSuffix, suffix, direction.get(Boolean.valueOf(inverse)), rel, type, type);
  }

  /**
   * Wrapper to assign singular to plural
   */
  protected List<Record> pluralToSingularRepl(final String wordToLc, final String replSuffix, final String suffix, final String type, final String rel, final boolean inverse) {
    Pair<Boolean, Direction> _mappedTo = Pair.<Boolean, Direction>of(Boolean.valueOf(false), Direction.LEFT);
    Pair<Boolean, Direction> _mappedTo_1 = Pair.<Boolean, Direction>of(Boolean.valueOf(true), Direction.RIGHT);
    final Map<Boolean, Direction> direction = Collections.<Boolean, Direction>unmodifiableMap(CollectionLiterals.<Boolean, Direction>newHashMap(_mappedTo, _mappedTo_1));
    return this.findSiblingAndMerge(wordToLc, replSuffix, suffix, 
      direction.get(Boolean.valueOf(inverse)), rel, type, type);
  }

  /**
   * Provisional: should be replaced by implicit Rules in the Future
   */
  @Deprecated
  protected void continuousToRegular(final String word) {
    ArrayList<Record> result = CollectionLiterals.<Record>newArrayList();
    boolean _endsWith = word.endsWith(NodeConstants.SUFFIX_);
    if (_endsWith) {
      List<Record> _elvis = null;
      List<Record> _findSiblingAndMerge = this.findSiblingAndMerge(word, null, NodeConstants.SUFFIX_, Direction.LEFT, NodeConstants.CONTINUOUS_, DictionaryConstants.VERB_, DictionaryConstants.VERB_);
      if (_findSiblingAndMerge != null) {
        _elvis = _findSiblingAndMerge;
      } else {
        _elvis = Collections.<Record>unmodifiableList(CollectionLiterals.<Record>newArrayList());
      }
      Iterables.<Record>addAll(result, _elvis);
      List<Record> _elvis_1 = null;
      List<Record> _findSiblingAndMerge_1 = this.findSiblingAndMerge(word, Neo4jConstants._E, NodeConstants.SUFFIX_, Direction.LEFT, NodeConstants.CONTINUOUS_, DictionaryConstants.VERB_, DictionaryConstants.VERB_);
      if (_findSiblingAndMerge_1 != null) {
        _elvis_1 = _findSiblingAndMerge_1;
      } else {
        _elvis_1 = Collections.<Record>unmodifiableList(CollectionLiterals.<Record>newArrayList());
      }
      result.addAll(_elvis_1);
    } else {
      List<Record> _elvis_2 = null;
      List<Record> _findSiblingAndMerge_2 = this.findSiblingAndMerge(word, NodeConstants.SUFFIX_, null, Direction.RIGHT, NodeConstants.CONTINUOUS_, DictionaryConstants.VERB_, DictionaryConstants.VERB_);
      if (_findSiblingAndMerge_2 != null) {
        _elvis_2 = _findSiblingAndMerge_2;
      } else {
        _elvis_2 = Collections.<Record>unmodifiableList(CollectionLiterals.<Record>newArrayList());
      }
      result.addAll(_elvis_2);
      List<Record> _elvis_3 = null;
      List<Record> _findSiblingAndMerge_3 = this.findSiblingAndMerge(word, NodeConstants.SUFFIX_, Neo4jConstants._E, Direction.RIGHT, NodeConstants.CONTINUOUS_, DictionaryConstants.VERB_, DictionaryConstants.VERB_);
      if (_findSiblingAndMerge_3 != null) {
        _elvis_3 = _findSiblingAndMerge_3;
      } else {
        _elvis_3 = Collections.<Record>unmodifiableList(CollectionLiterals.<Record>newArrayList());
      }
      result.addAll(_elvis_3);
    }
    this.logResult(result, "Verb | continuous", "Continuous to Regular", word);
  }

  /**
   * Assign a new Word Type to a Word
   */
  @Override
  public TypeAttributes addTypeToWord(final String word, final String type) {
    TypeAttributes _xblockexpression = null;
    {
      String wordToLc = word.toLowerCase();
      String query = this.createTypeMatchQuery(wordToLc, NodeConstants._WORD, false, null, 1, 1).toString();
      String _query = query;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("WITH *");
      _builder.newLine();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._N);
      _builder.append(":");
      _builder.append(DictionaryConstants._WORD_CLASS);
      _builder.append(" {");
      _builder.append(Neo4jConstants._NAME);
      _builder.append(":\"");
      _builder.append(type);
      _builder.append("\"})");
      _builder.newLineIfNotEmpty();
      _builder.append("MERGE (");
      _builder.append(NodeConstants._M);
      _builder.append(")-[");
      _builder.append(Neo4jConstants._L2);
      _builder.append(":");
      _builder.append(Neo4jConstants._OF_CLASS);
      _builder.append("]->(");
      _builder.append(Neo4jConstants._N);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      String _string = this.createTypeReturn(NodeConstants._WORD, NodeConstants._M, Neo4jConstants._N).toString();
      _builder.append(_string);
      query = (_query + _builder);
      List<Record> result = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.WRITE);
      _xblockexpression = this.newTypeAttribute(result, wordToLc, type, Neo4jConstants._N, Neo4jConstants._L, NodeConstants._M, NodeConstants._W);
    }
    return _xblockexpression;
  }

  public CharSequence createTypeReturn(final String fromType, final String source, final String target) {
    CharSequence _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(source);
      _builder.append(",");
      _builder.append(target);
      _builder.append(", COLLECT({");
      _builder.append(Neo4jConstants._LK);
      _builder.append(":");
      _builder.append(Neo4jConstants._L);
      _builder.append(", ");
      _builder.append(Neo4jConstants._ATTR);
      _builder.append(":");
      _builder.append(NodeConstants._W);
      _builder.append("}) AS ");
      _builder.append(Neo4jConstants._ATTRS);
      Pair<String, String> _mappedTo = Pair.<String, String>of(NodeConstants._WORD, _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(Neo4jConstants._N);
      _builder_1.append(", COLLECT({");
      _builder_1.append(Neo4jConstants._LK);
      _builder_1.append(":");
      _builder_1.append(Neo4jConstants._L);
      _builder_1.append(", ");
      _builder_1.append(Neo4jConstants._ATTR);
      _builder_1.append(":");
      _builder_1.append(NodeConstants._W);
      _builder_1.append("}) AS ");
      _builder_1.append(Neo4jConstants._ATTRS);
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of(NodeConstants._INTERPUNCTION, _builder_1.toString());
      final Map<String, String> typeReturn = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("RETURN ");
      String _get = typeReturn.get(fromType);
      _builder_2.append(_get);
      _xblockexpression = _builder_2;
    }
    return _xblockexpression;
  }

  public CharSequence createTypeMatchQuery(final String nameToLc, final String fromType, final boolean selectType, final String typeName, final int min, final int max) {
    CharSequence _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(NodeConstants._M);
      _builder.append(":");
      _builder.append(NodeConstants._WORD);
      _builder.append(" {");
      _builder.append(Neo4jConstants._NAME);
      _builder.append(":\"");
      _builder.append(nameToLc);
      _builder.append("\"})");
      {
        if (selectType) {
          CharSequence _generate = new Arrow(Neo4jConstants._L2, Neo4jConstants._OF_CLASS, Direction.RIGHT).generate();
          _builder.append(_generate);
          _builder.append("(");
          _builder.append(Neo4jConstants._N);
          _builder.append(":");
          _builder.append(DictionaryConstants._WORD_CLASS);
          {
            if (((typeName != null) && (!typeName.isEmpty()))) {
              _builder.append(" {");
              _builder.append(Neo4jConstants._NAME);
              _builder.append(":\"");
              _builder.append(typeName);
              _builder.append("\"}");
            }
          }
          _builder.append(")");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("OPTIONAL MATCH ");
      _builder.append(Neo4jConstants._CL);
      _builder.append(" = (");
      _builder.append(NodeConstants._M);
      _builder.append(")-[");
      _builder.append(Neo4jConstants._L);
      _builder.append("*");
      _builder.append(min);
      _builder.append("..");
      _builder.append(max);
      _builder.append("]-(");
      _builder.append(NodeConstants._W);
      _builder.append(")");
      Pair<String, String> _mappedTo = Pair.<String, String>of(NodeConstants._WORD, _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MATCH (");
      _builder_1.append(Neo4jConstants._N);
      _builder_1.append(":");
      _builder_1.append(NodeConstants._INTERPUNCTION);
      _builder_1.append(" {");
      _builder_1.append(Neo4jConstants._NAME);
      _builder_1.append(":\"");
      _builder_1.append(nameToLc);
      _builder_1.append("\"})");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("OPTIONAL MATCH ");
      _builder_1.append(Neo4jConstants._CL);
      _builder_1.append(" = (");
      _builder_1.append(Neo4jConstants._N);
      _builder_1.append(")-[");
      _builder_1.append(Neo4jConstants._L);
      _builder_1.append("*");
      _builder_1.append(min);
      _builder_1.append("..");
      _builder_1.append(max);
      _builder_1.append("]-(");
      _builder_1.append(NodeConstants._W);
      _builder_1.append(")");
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of(NodeConstants._INTERPUNCTION, _builder_1.toString());
      final Map<String, String> typeMatch = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1));
      StringConcatenation _builder_2 = new StringConcatenation();
      String _get = typeMatch.get(fromType);
      _builder_2.append(_get);
      _builder_2.append(" WHERE NONE(");
      _builder_2.append(Neo4jConstants._A);
      _builder_2.append(" IN relationships(");
      _builder_2.append(Neo4jConstants._CL);
      _builder_2.append(") WHERE type(");
      _builder_2.append(Neo4jConstants._A);
      _builder_2.append(") = \'");
      _builder_2.append(Neo4jConstants._OF_CLASS);
      _builder_2.append("\') AND ");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("FILTER(");
      _builder_2.append(Neo4jConstants._A);
      _builder_2.append(" IN labels(");
      _builder_2.append(NodeConstants._W);
      _builder_2.append(") WHERE ");
      _builder_2.append(Neo4jConstants._A);
      _builder_2.append(" IN [");
      {
        boolean _hasElements = false;
        for(final String f : this.nodeFilter) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_2.appendImmediate(",", "");
          }
          _builder_2.append("\"");
          _builder_2.append(f);
          _builder_2.append("\"");
        }
      }
      _builder_2.append("])");
      _builder_2.newLineIfNotEmpty();
      _xblockexpression = _builder_2;
    }
    return _xblockexpression;
  }

  /**
   * replaces a WordType for a Word
   */
  @Override
  public TypeAttributes replaceTypeForWord(final String word, final String oldType, final String newType) {
    Object _xblockexpression = null;
    {
      String wordToLc = word.toLowerCase();
      List<XPair<String, ITypeAttributes>> types = this.getLinkTypes(wordToLc, NodeConstants._WORD).getTypes();
      for (final XPair<String, ITypeAttributes> type : types) {
        boolean _equals = type.getKey().equals(oldType);
        if (_equals) {
          String query = this.createTypeMatchQuery(wordToLc, NodeConstants._WORD, true, oldType, 1, 1).toString();
          String _query = query;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("DELETE ");
          _builder.append(Neo4jConstants._L2);
          _builder.newLineIfNotEmpty();
          _builder.append("WITH *");
          _builder.newLine();
          _builder.append("MATCH (");
          _builder.append(Neo4jConstants._B);
          _builder.append(":");
          _builder.append(DictionaryConstants._WORD_CLASS);
          _builder.append(" {");
          _builder.append(Neo4jConstants._NAME);
          _builder.append(":\"");
          _builder.append(newType);
          _builder.append("\"})\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("MERGE (");
          _builder.append(NodeConstants._M);
          _builder.append(")-[");
          _builder.append(Neo4jConstants._L3);
          _builder.append(":");
          _builder.append(Neo4jConstants._OF_CLASS);
          _builder.append("]->(");
          _builder.append(Neo4jConstants._B);
          _builder.append(")");
          _builder.newLineIfNotEmpty();
          String _string = this.createTypeReturn(NodeConstants._WORD, NodeConstants._M, Neo4jConstants._B).toString();
          _builder.append(_string);
          query = (_query + _builder);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(" ");
          _builder_1.append("/");
          _builder_1.newLine();
          _builder_1.append("DEBUG [DictionaryAccess:replaceTypeForWord]: ");
          _builder_1.append(query);
          InputOutput.<String>print(_builder_1.toString());
          List<Record> result = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.WRITE);
          return this.newTypeAttribute(result, wordToLc, newType, Neo4jConstants._N, Neo4jConstants._L3, NodeConstants._M, NodeConstants._W);
        }
      }
      _xblockexpression = null;
    }
    return ((TypeAttributes)_xblockexpression);
  }

  public TypeAttributes newTypeAttribute(final List<Record> result, final String wordToLc, final String newType, final String n, final String l, final String m, final String w) {
    Object _xblockexpression = null;
    {
      if (((result != null) && (!result.isEmpty()))) {
        Node _node = this.getNode(result.get(0).get(n));
        Relationship _relationship = this.getRelationship(result.get(0).get(l));
        Node _node_1 = this.getNode(result.get(0).get(m));
        Node _node_2 = this.getNode(result.get(0).get(w));
        TypeAttributes newTypeAtt = new TypeAttributes(_node, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(_relationship)), _node_1, _node_2);
        HashMap<String, ITypeAttributes> typesDef = CollectionLiterals.<String, ITypeAttributes>newHashMap();
        typesDef.put(newType, newTypeAtt);
        Node _node_3 = this.getNode(result.get(0).get(NodeConstants._M));
        WordTypeInfo _wordTypeInfo = new WordTypeInfo(_node_3, typesDef);
        this.addToWordCache(wordToLc, newType, _wordTypeInfo);
        this.dictPostProcess(wordToLc, newType);
        return newTypeAtt;
      }
      _xblockexpression = null;
    }
    return ((TypeAttributes)_xblockexpression);
  }

  @Override
  public void deleteTypeToWord(final String word, final String oldType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._S);
    _builder.append(":");
    _builder.append(NodeConstants._WORD);
    _builder.append(" {");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(":\"");
    String _lowerCase = word.toLowerCase();
    _builder.append(_lowerCase);
    _builder.append("\"})");
    _builder.newLineIfNotEmpty();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._A);
    _builder.append(":");
    _builder.append(DictionaryConstants._WORD_CLASS);
    _builder.append(" {");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(":\"");
    _builder.append(oldType);
    _builder.append("\"})");
    _builder.newLineIfNotEmpty();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._S);
    _builder.append(")-[");
    _builder.append(Neo4jConstants._L);
    _builder.append(":");
    _builder.append(Neo4jConstants._OF_CLASS);
    _builder.append("]->(");
    _builder.append(Neo4jConstants._A);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("DELETE ");
    _builder.append(Neo4jConstants._L);
    _builder.newLineIfNotEmpty();
    _builder.append("RETURN *  ");
    _builder.newLine();
    String query = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(" ");
    _builder_1.append("/");
    _builder_1.newLine();
    _builder_1.append("DEBUG [DictionaryAccess:replaceTypeForWord]: ");
    _builder_1.append(query);
    InputOutput.<String>print(_builder_1.toString());
    this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.WRITE);
  }

  public void addToWordCache(final String word, final String type, final ITypeInfo info) {
    boolean _containsKey = this.typeCache.containsKey(word);
    if (_containsKey) {
      HashMap<String, ITypeAttributes> typeMap = CollectionLiterals.<String, ITypeAttributes>newHashMap();
      List<XPair<String, ITypeAttributes>> _types = info.getTypes();
      for (final XPair<String, ITypeAttributes> typ : _types) {
        typeMap.put(typ.getKey(), typ.getValue());
      }
      this.typeCache.get(word).addTypes(typeMap);
    } else {
      boolean _containsKey_1 = this.unknownWordCache.containsKey(word);
      if (_containsKey_1) {
        this.typeCache.put(word, info);
        this.unknownWordCache.remove(word);
      }
    }
  }

  /**
   * Postprocess function that creates relationships to prefixes and common relatives
   */
  public List<Record> findPrefix(final String word, final List<String> prefixes, final int tol, final boolean linkIt) {
    Neo4jAccess.Action action = Neo4jAccess.Action.READ;
    if (linkIt) {
      action = Neo4jAccess.Action.WRITE;
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("UNWIND [");
    {
      boolean _hasElements = false;
      for(final String postfix : prefixes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append("\"");
        _builder.append(postfix);
        _builder.append("\"");
      }
    }
    _builder.append("] AS ");
    _builder.append(Neo4jConstants._LS);
    _builder.newLineIfNotEmpty();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._N);
    _builder.append(":");
    _builder.append(NodeConstants._WORD);
    _builder.append(" {");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(":\"");
    _builder.append(word);
    _builder.append("\"}) WHERE ");
    _builder.append(Neo4jConstants._N);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(" STARTS WITH ");
    _builder.append(Neo4jConstants._LS);
    _builder.append(" AND size(");
    _builder.append(Neo4jConstants._N);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(") > size(");
    _builder.append(Neo4jConstants._LS);
    _builder.append(") + ");
    _builder.append(tol);
    _builder.newLineIfNotEmpty();
    _builder.append("WITH *, substring(");
    _builder.append(Neo4jConstants._N);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(", size(");
    _builder.append(Neo4jConstants._LS);
    _builder.append("), size(");
    _builder.append(Neo4jConstants._N);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(")) AS ");
    _builder.append(DictionaryConstants._NX);
    _builder.newLineIfNotEmpty();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._T);
    _builder.append(":");
    _builder.append(NodeConstants._WORD);
    _builder.append(") WHERE size(");
    _builder.append(Neo4jConstants._T);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(") > size(");
    _builder.append(Neo4jConstants._LS);
    _builder.append(") AND size(");
    _builder.append(Neo4jConstants._T);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(") < size(");
    _builder.append(Neo4jConstants._N);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("WITH *, ");
    _builder.append(Neo4jConstants._T);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(" AS ");
    _builder.append(DictionaryConstants._TX);
    _builder.append(" WHERE ");
    _builder.append(DictionaryConstants._NX);
    _builder.append(" = ");
    _builder.append(DictionaryConstants._TX);
    _builder.newLineIfNotEmpty();
    {
      if (linkIt) {
        _builder.append("MERGE (");
        _builder.append(Neo4jConstants._S);
        _builder.append(":");
        _builder.append(DictionaryConstants._PREFIX);
        _builder.append(" {");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(":");
        _builder.append(Neo4jConstants._LS);
        _builder.append("})");
        _builder.newLineIfNotEmpty();
        _builder.append("MERGE (");
        _builder.append(Neo4jConstants._N);
        _builder.append(")");
        Pair<String, String> _mappedTo = Pair.<String, String>of(Neo4jConstants._NAME, Neo4jConstants._LS);
        CharSequence _generate = new Arrow(Neo4jConstants._L, DictionaryConstants._PREFIXED, Collections.<String, Serializable>unmodifiableMap(CollectionLiterals.<String, Serializable>newHashMap(_mappedTo)), Direction.RIGHT).generate();
        _builder.append(_generate);
        _builder.append("(");
        _builder.append(Neo4jConstants._T);
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("MERGE (");
        _builder.append(Neo4jConstants._N);
        _builder.append(")");
        CharSequence _generate_1 = new Arrow(Neo4jConstants._L2, DictionaryConstants._STARTS_WITH, null, Direction.RIGHT).generate();
        _builder.append(_generate_1);
        _builder.append("(");
        _builder.append(Neo4jConstants._S);
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("RETURN ");
        _builder.append(Neo4jConstants._L);
        _builder.append(", ");
        _builder.append(Neo4jConstants._L2);
        _builder.append(", ");
        _builder.append(Neo4jConstants._S);
        _builder.append(",");
      } else {
        _builder.newLineIfNotEmpty();
        _builder.append("RETURN");
      }
    }
    _builder.append(" ");
    _builder.append(Neo4jConstants._N);
    _builder.append(", ");
    _builder.append(Neo4jConstants._T);
    _builder.append(", ");
    _builder.append(DictionaryConstants._NX);
    _builder.append(", ");
    _builder.append(DictionaryConstants._TX);
    _builder.append(", ");
    _builder.append(Neo4jConstants._LS);
    String query = _builder.toString();
    List<Record> result = this.dbAccessor.runCodeRecords(query, action);
    return result;
  }

  /**
   * Postprocess function that creates relationships to suffixes and common relatives and
   *  adds transitions between common prefixes and relatives
   */
  public List<Record> findPostfixRelative(final String word, final List<String> postfixes, final int tol, final boolean isPostfix, final boolean linkIt) {
    Neo4jAccess.Action action = Neo4jAccess.Action.READ;
    if (linkIt) {
      action = Neo4jAccess.Action.WRITE;
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("UNWIND [");
    {
      boolean _hasElements = false;
      for(final String postfix : postfixes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append("\"");
        _builder.append(postfix);
        _builder.append("\"");
      }
    }
    _builder.append("] AS ");
    _builder.append(Neo4jConstants._LS);
    _builder.newLineIfNotEmpty();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._N);
    _builder.append(":");
    _builder.append(NodeConstants._WORD);
    {
      if (isPostfix) {
        _builder.append(" {");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(":\"");
        _builder.append(word);
        _builder.append("\"})");
      } else {
        _builder.append(") WHERE ");
        _builder.append(Neo4jConstants._N);
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(" ENDS WITH ");
        _builder.append(Neo4jConstants._LS);
        _builder.append(" AND size(");
        _builder.append(Neo4jConstants._N);
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(") > size(");
        _builder.append(Neo4jConstants._LS);
        _builder.append(") + ");
        _builder.append(tol);
      }
    }
    _builder.newLineIfNotEmpty();
    {
      if ((tol > 0)) {
        _builder.append("WITH *, substring(");
        _builder.append(Neo4jConstants._N);
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(", 0, size(");
        _builder.append(Neo4jConstants._N);
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(") - size(");
        _builder.append(Neo4jConstants._LS);
        _builder.append(") - ");
        _builder.append(tol);
        _builder.append(") AS ");
        _builder.append(DictionaryConstants._NX);
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("WITH *, substring(");
    _builder.append(Neo4jConstants._N);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(", 0, size(");
    _builder.append(Neo4jConstants._N);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(") - size(");
    _builder.append(Neo4jConstants._LS);
    _builder.append(")) AS ");
    _builder.append(DictionaryConstants._NY);
    _builder.newLineIfNotEmpty();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._T);
    _builder.append(":");
    _builder.append(NodeConstants._WORD);
    {
      if ((!isPostfix)) {
        _builder.append(" {");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(":\"");
        _builder.append(word);
        _builder.append("\"}");
      }
    }
    _builder.append(") WHERE size(");
    _builder.append(Neo4jConstants._T);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(") > size(");
    _builder.append(Neo4jConstants._LS);
    _builder.append(") AND size(");
    _builder.append(Neo4jConstants._T);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(") < size(");
    _builder.append(Neo4jConstants._N);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("WITH *, ");
    {
      if ((tol > 0)) {
        _builder.append("substring(");
        _builder.append(Neo4jConstants._T);
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(", 0, size(");
        _builder.append(DictionaryConstants._NX);
        _builder.append(")) AS ");
        _builder.append(DictionaryConstants._TX);
        _builder.append(",");
      }
    }
    _builder.append(" substring(");
    _builder.append(Neo4jConstants._T);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    _builder.append(", 0, size(");
    _builder.append(DictionaryConstants._NY);
    _builder.append(")) AS ");
    _builder.append(DictionaryConstants._TY);
    _builder.append(" WHERE (");
    {
      if ((tol > 0)) {
        _builder.append(DictionaryConstants._TX);
        _builder.append(" = ");
        _builder.append(DictionaryConstants._NX);
        _builder.append(" OR ");
      }
    }
    _builder.append(DictionaryConstants._TY);
    _builder.append(" = ");
    _builder.append(DictionaryConstants._NY);
    _builder.append(")");
    {
      if (linkIt) {
        _builder.newLineIfNotEmpty();
        _builder.append("MERGE (");
        _builder.append(Neo4jConstants._S);
        _builder.append(":");
        _builder.append(DictionaryConstants._SUFFIX);
        _builder.append(" {");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(":");
        _builder.append(Neo4jConstants._LS);
        _builder.append("})");
        _builder.newLineIfNotEmpty();
        _builder.append("MERGE (");
        _builder.append(Neo4jConstants._N);
        _builder.append(")");
        Pair<String, String> _mappedTo = Pair.<String, String>of(Neo4jConstants._NAME, Neo4jConstants._LS);
        CharSequence _generate = new Arrow(Neo4jConstants._L, DictionaryConstants._SUFFIXED, Collections.<String, Serializable>unmodifiableMap(CollectionLiterals.<String, Serializable>newHashMap(_mappedTo)), Direction.RIGHT).generate();
        _builder.append(_generate);
        _builder.append("(");
        _builder.append(Neo4jConstants._T);
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("MERGE (");
        _builder.append(Neo4jConstants._N);
        _builder.append(")");
        CharSequence _generate_1 = new Arrow(Neo4jConstants._L2, DictionaryConstants._ENDS_WITH, null, Direction.RIGHT).generate();
        _builder.append(_generate_1);
        _builder.append("(");
        _builder.append(Neo4jConstants._S);
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("WITH *, [");
        _builder.append(Neo4jConstants._X);
        _builder.append(" IN range(0, size(");
        _builder.append(Neo4jConstants._N);
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(") - size(");
        _builder.append(Neo4jConstants._LS);
        _builder.append(")) WHERE substring(");
        _builder.append(Neo4jConstants._N);
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(", 0, ");
        _builder.append(Neo4jConstants._X);
        _builder.append(") = substring(");
        _builder.append(Neo4jConstants._T);
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(", 0, ");
        _builder.append(Neo4jConstants._X);
        _builder.append(")][-1] AS ");
        _builder.append(Neo4jConstants._INDEX);
        _builder.newLineIfNotEmpty();
        _builder.append("WITH *, substring(");
        _builder.append(Neo4jConstants._N);
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(", 0, ");
        _builder.append(Neo4jConstants._INDEX);
        _builder.append(") AS ");
        _builder.append(DictionaryConstants._SUBSTR);
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("substring(");
        _builder.append(Neo4jConstants._N, "\t");
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME, "\t");
        _builder.append(", ");
        _builder.append(Neo4jConstants._INDEX, "\t");
        _builder.append(", size(");
        _builder.append(Neo4jConstants._N, "\t");
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME, "\t");
        _builder.append(") - size(");
        _builder.append(Neo4jConstants._LS, "\t");
        _builder.append(") - ");
        _builder.append(Neo4jConstants._INDEX, "\t");
        _builder.append(") AS ");
        _builder.append(DictionaryConstants._INFIX_N, "\t");
        _builder.append(", ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("substring(");
        _builder.append(Neo4jConstants._T, "\t");
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME, "\t");
        _builder.append(", ");
        _builder.append(Neo4jConstants._INDEX, "\t");
        _builder.append(", size(");
        _builder.append(Neo4jConstants._T, "\t");
        _builder.append(".");
        _builder.append(Neo4jConstants._NAME, "\t");
        _builder.append(") - ");
        _builder.append(Neo4jConstants._INDEX, "\t");
        _builder.append(") AS ");
        _builder.append(DictionaryConstants._INFIX_T, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("MERGE (");
        _builder.append(Neo4jConstants._IT);
        _builder.append(":");
        _builder.append(DictionaryConstants._INFIX_TRANSITION);
        _builder.append(" {");
        _builder.append(Neo4jConstants._NAME);
        _builder.append(":");
        _builder.append(DictionaryConstants._INFIX_N);
        _builder.append("})");
        _builder.newLineIfNotEmpty();
        _builder.append("MERGE (");
        _builder.append(Neo4jConstants._N);
        _builder.append(")");
        Pair<String, String> _mappedTo_1 = Pair.<String, String>of(Neo4jConstants._NAME, DictionaryConstants._SUBSTR);
        CharSequence _generate_2 = new Arrow(Neo4jConstants._F, DictionaryConstants._COMMON_PREFIX, Collections.<String, Serializable>unmodifiableMap(CollectionLiterals.<String, Serializable>newHashMap(_mappedTo_1)), Direction.RIGHT).generate();
        _builder.append(_generate_2);
        _builder.append("(");
        _builder.append(Neo4jConstants._IT);
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("MERGE (");
        _builder.append(Neo4jConstants._IT);
        _builder.append(")");
        Pair<String, String> _mappedTo_2 = Pair.<String, String>of(Neo4jConstants._NAME, DictionaryConstants._INFIX_T);
        CharSequence _generate_3 = new Arrow(Neo4jConstants._G, DictionaryConstants._TRANSIT_TO, Collections.<String, Serializable>unmodifiableMap(CollectionLiterals.<String, Serializable>newHashMap(_mappedTo_2)), Direction.RIGHT).generate();
        _builder.append(_generate_3);
        _builder.append("(");
        _builder.append(Neo4jConstants._T);
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("MERGE (");
        _builder.append(Neo4jConstants._IT);
        _builder.append(")");
        CharSequence _generate_4 = new Arrow(Neo4jConstants._H, DictionaryConstants._SUFFIXED, Direction.RIGHT).generate();
        _builder.append(_generate_4);
        _builder.append("(");
        _builder.append(Neo4jConstants._S);
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("RETURN ");
        _builder.append(Neo4jConstants._L);
        _builder.append(", ");
        _builder.append(Neo4jConstants._L2);
        _builder.append(", ");
        _builder.append(Neo4jConstants._S);
        _builder.append(", ");
        _builder.append(Neo4jConstants._IT);
        _builder.append(", ");
        _builder.append(Neo4jConstants._F);
        _builder.append(", ");
        _builder.append(Neo4jConstants._G);
        _builder.append(", ");
        _builder.append(Neo4jConstants._H);
        _builder.append(",");
      } else {
        _builder.newLineIfNotEmpty();
        _builder.append("RETURN");
      }
    }
    _builder.append(" ");
    _builder.append(Neo4jConstants._N);
    _builder.append(", ");
    _builder.append(Neo4jConstants._T);
    _builder.append(", ");
    _builder.append(Neo4jConstants._LS);
    String query = _builder.toString();
    List<Record> result = this.dbAccessor.runCodeRecords(query, action);
    return result;
  }

  /**
   * Provisionary: Grammar rule matchers should be modeled as ImplicitDictRule
   */
  @Override
  public void addToDictionary(final String word, final String type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Dictionary not connected: Entry: ");
    _builder.append(word);
    _builder.append(" of Type: ");
    _builder.append(type);
    _builder.append(" ");
    boolean _hasDB_Obj = this.hasDB_Obj(_builder.toString());
    boolean _not = (!_hasDB_Obj);
    if (_not) {
      return;
    }
    this.dbAccessor.ensureDbConnect();
    String wordToLc = word.toLowerCase();
    Record DictRec = this.getGlobalDict();
    if ((this.nodeExist(type) && (DictRec != null))) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MATCH (");
      _builder_1.append(Neo4jConstants._N);
      _builder_1.append(":");
      _builder_1.append(DictionaryConstants._WORD_CLASS);
      _builder_1.append(" {");
      _builder_1.append(Neo4jConstants._NAME);
      _builder_1.append(":\"");
      _builder_1.append(type);
      _builder_1.append("\"}) ");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("MATCH (");
      _builder_2.append(Neo4jConstants._T);
      _builder_2.append(": ");
      _builder_2.append(NodeConstants._DICTIONARY);
      _builder_2.append(" {");
      _builder_2.append(Neo4jConstants._NAME);
      _builder_2.append(":\"");
      _builder_2.append(DictionaryConstants._GLOBAL);
      _builder_2.append("\"})");
      this.connectionExist(_builder_1.toString(), Neo4jConstants._N, _builder_2.toString(), Neo4jConstants._T, Neo4jConstants._L);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("CREATE(");
      _builder_3.append(NodeConstants._M);
      _builder_3.append(":");
      _builder_3.append(NodeConstants._WORD);
      _builder_3.append(" {");
      _builder_3.append(Neo4jConstants._NAME);
      _builder_3.append(":\"");
      _builder_3.append(wordToLc);
      _builder_3.append("\"}) WITH ");
      _builder_3.append(NodeConstants._M);
      _builder_3.append(" ");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("MATCH (");
      _builder_3.append(Neo4jConstants._N);
      _builder_3.append(":");
      _builder_3.append(DictionaryConstants._WORD_CLASS);
      _builder_3.append(" {");
      _builder_3.append(Neo4jConstants._NAME);
      _builder_3.append(":\"");
      _builder_3.append(type);
      _builder_3.append("\"})");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("MERGE (");
      _builder_3.append(NodeConstants._M);
      _builder_3.append(")");
      CharSequence _generate = new Arrow(Neo4jConstants._L, Neo4jConstants._OF_CLASS, Direction.RIGHT).generate();
      _builder_3.append(_generate);
      _builder_3.append("(");
      _builder_3.append(Neo4jConstants._N);
      _builder_3.append(") ");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("RETURN ");
      _builder_3.append(Neo4jConstants._N);
      _builder_3.append(", ");
      _builder_3.append(NodeConstants._M);
      _builder_3.append(", ");
      _builder_3.append(Neo4jConstants._L);
      _builder_3.append(", type(");
      _builder_3.append(Neo4jConstants._L);
      _builder_3.append(") AS ");
      _builder_3.append(NodeConstants._TYPE);
      String query = _builder_3.toString();
      ArrayList<Record> allRecs = this.getAllRecords(this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.READ));
      if (((allRecs != null) && (!allRecs.isEmpty()))) {
        for (final Record rec : allRecs) {
          {
            Node baseNode = this.getNode(rec.get(Neo4jConstants._N));
            Node _node = this.getNode(rec.get(Neo4jConstants._N));
            Relationship _asRelationship = rec.get(Neo4jConstants._L).asRelationship();
            Node _node_1 = this.getNode(rec.get(NodeConstants._M));
            Node _node_2 = this.getNode(rec.get(Neo4jConstants._N));
            TypeAttributes newType = new TypeAttributes(_node, Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(_asRelationship)), _node_1, _node_2);
            HashMap<String, ITypeAttributes> types = CollectionLiterals.<String, ITypeAttributes>newHashMap();
            types.put(type, newType);
            Node _asNode = rec.get(Neo4jConstants._N).asNode();
            WordTypeInfo _wordTypeInfo = new WordTypeInfo(_asNode, types);
            this.addToWordCache(wordToLc, type, _wordTypeInfo);
          }
        }
        this.dictPostProcess(wordToLc, type);
      }
    }
  }

  /**
   * Postprocess words statically: To be replaced by implicit rules in the future...
   */
  public void dictPostProcess(final String wordToLc, final String type) {
    List<Record> result = null;
    boolean _matched = false;
    if (Objects.equals(type, DictionaryConstants.NOUN_)) {
      _matched=true;
      result = this.findSigularToPluralOrThirdP(wordToLc, DictionaryConstants.NOUN_, DictionaryConstants._PLURAL, false);
      this.logResult(result, "Noun | singular-plural", "Found singular to plural relation", wordToLc);
    }
    if (!_matched) {
      if (Objects.equals(type, DictionaryConstants.VERB_)) {
        _matched=true;
        this.continuousToRegular(wordToLc);
        result = this.findSigularToPluralOrThirdP(wordToLc, DictionaryConstants.VERB_, DictionaryConstants._BASEFORM, true);
        this.logResult(result, "Verb | third person", "Found verb relation to third person conjugation", wordToLc);
      }
    }
    if (!_matched) {
      if (Objects.equals(type, DictionaryConstants.ADJECTIVE_)) {
        _matched=true;
        result = this.findComparativeAndSuperlative(wordToLc);
        this.logResult(result, "Adjective | comperative-superlative", "Found comparative or superlative adjective relation", wordToLc);
      }
    }
    result = this.findShortCut(wordToLc);
    this.logResult(result, "All | shortcut", "Found shortcut relation", wordToLc);
  }

  /**
   * find comparative or superlative
   */
  public List<Record> findComparativeAndSuperlative(final String string) {
    ArrayList<Record> _xblockexpression = null;
    {
      ArrayList<Record> result = CollectionLiterals.<Record>newArrayList();
      ArrayList<Object> exaggerate = CollectionLiterals.<Object>newArrayList();
      for (final Pair<String, String> ex : this.comparatives) {
        boolean _endsWith = string.endsWith(ex.getKey());
        if (_endsWith) {
          List<Record> _elvis = null;
          List<Record> _findSiblingAndMerge = this.findSiblingAndMerge(string, ex.getValue(), ex.getKey(), Direction.LEFT, DictionaryConstants._COMPARATIVE, DictionaryConstants.ADJECTIVE_, DictionaryConstants.ADJECTIVE_);
          if (_findSiblingAndMerge != null) {
            _elvis = _findSiblingAndMerge;
          } else {
            _elvis = Collections.<Record>unmodifiableList(CollectionLiterals.<Record>newArrayList());
          }
          Iterables.<Record>addAll(result, _elvis);
        } else {
          List<Record> _elvis_1 = null;
          List<Record> _findSiblingAndMerge_1 = this.findSiblingAndMerge(string, ex.getKey(), ex.getValue(), Direction.RIGHT, DictionaryConstants._COMPARATIVE, DictionaryConstants.ADJECTIVE_, DictionaryConstants.ADJECTIVE_);
          if (_findSiblingAndMerge_1 != null) {
            _elvis_1 = _findSiblingAndMerge_1;
          } else {
            _elvis_1 = Collections.<Record>unmodifiableList(CollectionLiterals.<Record>newArrayList());
          }
          result.addAll(_elvis_1);
        }
      }
      boolean _isEmpty = result.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        return result;
      }
      for (final Pair<String, String> ex_1 : this.superlatives) {
        boolean _endsWith_1 = string.endsWith(ex_1.getKey());
        if (_endsWith_1) {
          List<Record> _elvis_2 = null;
          List<Record> _findSiblingAndMerge_2 = this.findSiblingAndMerge(string, ex_1.getValue(), ex_1.getKey(), Direction.LEFT, DictionaryConstants._SUPERLATIVE, DictionaryConstants.ADJECTIVE_, DictionaryConstants.ADJECTIVE_);
          if (_findSiblingAndMerge_2 != null) {
            _elvis_2 = _findSiblingAndMerge_2;
          } else {
            _elvis_2 = Collections.<Record>unmodifiableList(CollectionLiterals.<Record>newArrayList());
          }
          result.addAll(_elvis_2);
        } else {
          List<Record> _elvis_3 = null;
          List<Record> _findSiblingAndMerge_3 = this.findSiblingAndMerge(string, ex_1.getKey(), ex_1.getValue(), Direction.RIGHT, DictionaryConstants._SUPERLATIVE, DictionaryConstants.ADJECTIVE_, DictionaryConstants.ADJECTIVE_);
          if (_findSiblingAndMerge_3 != null) {
            _elvis_3 = _findSiblingAndMerge_3;
          } else {
            _elvis_3 = Collections.<Record>unmodifiableList(CollectionLiterals.<Record>newArrayList());
          }
          result.addAll(_elvis_3);
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  /**
   * check singular - plural
   */
  public List<Record> findSigularToPluralOrThirdP(final String word, final String type, final String rel, final boolean inverse) {
    Set<String> _keySet = this.singularPlural.keySet();
    for (final String singular : _keySet) {
      {
        String plural = this.singularPlural.get(singular);
        boolean _endsWith = word.endsWith(singular);
        if (_endsWith) {
          List<Record> result = this.singularToPluralRepl(word, plural, singular, type, rel, inverse);
          boolean _isEmpty = false;
          if (result!=null) {
            _isEmpty=result.isEmpty();
          }
          boolean _not = (!_isEmpty);
          if (_not) {
            return result;
          }
        }
        boolean _endsWith_1 = word.endsWith(plural);
        if (_endsWith_1) {
          List<Record> result_1 = this.pluralToSingularRepl(word, singular, plural, type, rel, inverse);
          boolean _isEmpty_1 = false;
          if (result_1!=null) {
            _isEmpty_1=result_1.isEmpty();
          }
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            return result_1;
          }
        }
      }
    }
    boolean _endsWith = word.endsWith("s");
    if (_endsWith) {
      return this.pluralToSingular(word, Neo4jConstants._S, type, rel, inverse);
    } else {
      return this.singularToPlural(word, Neo4jConstants._S, type, rel, inverse);
    }
  }

  /**
   * Adds relation to abbreviations and shortcuts if appropriate
   */
  public List<Record> findShortCut(final String sc) {
    List<Record> _xblockexpression = null;
    {
      HashSet<String> postfixes = this.suffixes;
      Set<String> _keySet = this.singularPlural.keySet();
      Iterables.<String>addAll(postfixes, _keySet);
      Collection<String> _values = this.singularPlural.values();
      Iterables.<String>addAll(postfixes, _values);
      postfixes.add(DictionaryConstants._COMPARATIVE_SUFFIX);
      postfixes.add(DictionaryConstants._SUPERLATIVE_SUFFIX);
      String shortC = sc;
      String suffix = "";
      for (final String pfx : this.suffixes) {
        boolean _endsWith = sc.endsWith(pfx);
        if (_endsWith) {
          int _length = sc.length();
          int _length_1 = pfx.length();
          int _minus = (_length - _length_1);
          shortC = sc.substring(0, _minus);
          suffix = pfx;
        }
      }
      boolean isPlural = (this.singularPlural.values().contains(suffix) || suffix.endsWith("s"));
      int _length_2 = suffix.length();
      boolean hasSuffix = (_length_2 > 0);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("WITH [");
      {
        boolean _hasElements = false;
        for(final String postfix : postfixes) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "");
          }
          _builder.append("\"");
          _builder.append(postfix);
          _builder.append("\"");
        }
      }
      _builder.append("] AS ");
      _builder.append(Neo4jConstants._LS);
      _builder.newLineIfNotEmpty();
      _builder.append("WITH *, \"");
      _builder.append(shortC);
      _builder.append("\" AS ");
      _builder.append(Neo4jConstants._SC);
      _builder.append(" ");
      {
        if (hasSuffix) {
          _builder.append(", \"");
          _builder.append(suffix);
          _builder.append("\" AS ");
          _builder.append(DictionaryConstants._SUFFIX);
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._N);
      _builder.append(":");
      _builder.append(NodeConstants._WORD);
      _builder.append(") WHERE ");
      _builder.append(Neo4jConstants._N);
      _builder.append(".");
      _builder.append(Neo4jConstants._NAME);
      _builder.append(" STARTS WITH ");
      _builder.append(Neo4jConstants._SC);
      _builder.append(" AND size(");
      _builder.append(Neo4jConstants._SC);
      _builder.append(") < size(");
      _builder.append(Neo4jConstants._N);
      _builder.append(".");
      _builder.append(Neo4jConstants._NAME);
      _builder.append(") AND NOT FILTER (");
      _builder.append(Neo4jConstants._E);
      _builder.append(" IN ");
      _builder.append(Neo4jConstants._LS);
      _builder.append(" WHERE ");
      _builder.append(Neo4jConstants._N);
      _builder.append(".");
      _builder.append(Neo4jConstants._NAME);
      _builder.append(" = ");
      _builder.append(Neo4jConstants._SC);
      _builder.append("+");
      _builder.append(Neo4jConstants._E);
      _builder.append(")");
      {
        if (hasSuffix) {
          _builder.append(" AND ");
          _builder.append(Neo4jConstants._N);
          _builder.append(".");
          _builder.append(Neo4jConstants._NAME);
          _builder.append(" ENDS WITH ");
          _builder.append(DictionaryConstants._SUFFIX);
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("OPTIONAL MATCH (");
      _builder.append(Neo4jConstants._N);
      _builder.append(":");
      _builder.append(NodeConstants._WORD);
      _builder.append(")");
      CharSequence _generate = new Arrow(Neo4jConstants._L, DictionaryConstants._PLURAL, null).generate();
      _builder.append(_generate);
      _builder.append("(");
      _builder.append(Neo4jConstants._T);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("CALL apoc.when(");
      _builder.append(Neo4jConstants._L);
      _builder.append(" IS NOT NULL, \"WITH ");
      _builder.append(Neo4jConstants._L);
      _builder.append(", ");
      _builder.append(Neo4jConstants._N);
      _builder.append(", ");
      {
        if (isPlural) {
          _builder.append("ENDNODE(");
        } else {
          _builder.append("STARTNODE(");
        }
      }
      _builder.append(Neo4jConstants._L);
      _builder.append(") as ");
      _builder.append(Neo4jConstants._R);
      _builder.append(" WHERE ");
      _builder.append(Neo4jConstants._R);
      _builder.append(" = ");
      _builder.append(Neo4jConstants._N);
      _builder.append(" RETURN ");
      _builder.append(Neo4jConstants._N);
      _builder.append(", ");
      _builder.append(Neo4jConstants._R);
      _builder.append(", ");
      _builder.append(Neo4jConstants._L);
      _builder.append("\", \"\", {");
      _builder.append(Neo4jConstants._N);
      _builder.append(":");
      _builder.append(Neo4jConstants._N);
      _builder.append(", ");
      _builder.append(Neo4jConstants._L);
      _builder.append(":");
      _builder.append(Neo4jConstants._L);
      _builder.append("}) YIELD ");
      _builder.append(Neo4jConstants._VALUE);
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("WITH ");
      _builder.append(Neo4jConstants._L);
      _builder.append(", ");
      _builder.append(Neo4jConstants._T);
      _builder.append(", ");
      _builder.append(Neo4jConstants._SC);
      _builder.append(", ");
      _builder.append(Neo4jConstants._N);
      _builder.append(" WHERE ");
      _builder.append(Neo4jConstants._N);
      _builder.append(".");
      _builder.append(Neo4jConstants._NAME);
      _builder.append(" <> ");
      _builder.append(Neo4jConstants._SC);
      _builder.append("  ");
      _builder.newLineIfNotEmpty();
      _builder.append("RETURN ");
      _builder.append(Neo4jConstants._N);
      _builder.append(", ");
      _builder.append(Neo4jConstants._L);
      _builder.append(", ");
      _builder.append(Neo4jConstants._T);
      _builder.append(", ");
      _builder.append(Neo4jConstants._SC);
      String query = _builder.toString();
      List<Record> result = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.READ);
      boolean _isEmpty = result.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        for (final Record rec : result) {
          {
            Node source = rec.get(Neo4jConstants._N).asNode();
            Value _get = rec.get(Neo4jConstants._L);
            boolean _not_1 = (!(_get instanceof NullValue));
            if (_not_1) {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("MATCH(");
              _builder_1.append(Neo4jConstants._N);
              _builder_1.append(":");
              _builder_1.append(NodeConstants._WORD);
              _builder_1.append(" {");
              _builder_1.append(Neo4jConstants._NAME);
              _builder_1.append(":\"");
              _builder_1.append(sc);
              _builder_1.append("\"})");
              _builder_1.newLineIfNotEmpty();
              _builder_1.append("MATCH(");
              _builder_1.append(Neo4jConstants._T);
              _builder_1.append(") WHERE ID(");
              _builder_1.append(Neo4jConstants._T);
              _builder_1.append(") = ");
              long _id = source.id();
              _builder_1.append(_id);
              _builder_1.newLineIfNotEmpty();
              _builder_1.append("MERGE (");
              _builder_1.append(Neo4jConstants._N);
              _builder_1.append(")");
              CharSequence _generate_1 = new Arrow(Neo4jConstants._L, NodeConstants._SHORT_CUT, Direction.LEFT).generate();
              _builder_1.append(_generate_1);
              _builder_1.append("(");
              _builder_1.append(Neo4jConstants._T);
              _builder_1.append(")");
              query = _builder_1.toString();
            } else {
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("MATCH(");
              _builder_2.append(Neo4jConstants._N);
              _builder_2.append(":");
              _builder_2.append(NodeConstants._WORD);
              _builder_2.append(" {");
              _builder_2.append(Neo4jConstants._NAME);
              _builder_2.append(":\"");
              _builder_2.append(sc);
              _builder_2.append("\"})");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("MATCH(");
              _builder_2.append(Neo4jConstants._T);
              _builder_2.append(") WHERE ID(");
              _builder_2.append(Neo4jConstants._T);
              _builder_2.append(") = ");
              long _id_1 = source.id();
              _builder_2.append(_id_1);
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("MERGE (");
              _builder_2.append(Neo4jConstants._N);
              _builder_2.append(")");
              CharSequence _generate_2 = new Arrow(Neo4jConstants._L, NodeConstants._SHORT_CUT, Direction.LEFT).generate();
              _builder_2.append(_generate_2);
              _builder_2.append("(");
              _builder_2.append(Neo4jConstants._T);
              _builder_2.append(")");
              query = _builder_2.toString();
            }
            if (hasSuffix) {
              String _query = query;
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("MERGE (");
              _builder_3.append(Neo4jConstants._S);
              _builder_3.append(":");
              _builder_3.append(DictionaryConstants._SUFFIX);
              _builder_3.append(" {");
              _builder_3.append(Neo4jConstants._NAME);
              _builder_3.append(":\"");
              _builder_3.append(suffix);
              _builder_3.append("\"})");
              _builder_3.newLineIfNotEmpty();
              _builder_3.append("MERGE (");
              _builder_3.append(Neo4jConstants._N);
              _builder_3.append(")");
              CharSequence _generate_3 = new Arrow(null, DictionaryConstants._SUFFIXED, Direction.RIGHT).generate();
              _builder_3.append(_generate_3);
              _builder_3.append("(");
              _builder_3.append(Neo4jConstants._S);
              _builder_3.append(")");
              CharSequence _generate_4 = new Arrow(null, DictionaryConstants._SUFFIXED, Direction.LEFT).generate();
              _builder_3.append(_generate_4);
              _builder_3.append("(");
              _builder_3.append(Neo4jConstants._T);
              _builder_3.append(")");
              _builder_3.newLineIfNotEmpty();
              _builder_3.append("RETURN *");
              _builder_3.newLine();
              query = (_query + _builder_3);
            }
            result = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.WRITE);
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  /**
   * check if a connection exist
   * @Deprecated: use getLinkTypes
   */
  @Deprecated
  protected boolean connectionExist(final String source, final String var1, final String target, final String var2, final String var3) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(source);
    _builder.newLineIfNotEmpty();
    _builder.append(target);
    _builder.newLineIfNotEmpty();
    _builder.append("MERGE (");
    _builder.append(var1);
    _builder.append(")-[");
    _builder.append(var3);
    _builder.append(":");
    _builder.append(Neo4jConstants._OF_CLASS);
    _builder.append("]->(");
    _builder.append(var2);
    _builder.append(") RETURN ");
    _builder.append(NodeConstants._TYPE);
    _builder.append("(");
    _builder.append(var3);
    _builder.append(")");
    String query = _builder.toString();
    List<Record> result = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.WRITE);
    boolean _isEmpty = result.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * initialize Dictionary
   */
  protected Record getGlobalDict() {
    boolean _hasDB_Obj = this.hasDB_Obj("Dictionary not connected to: GlobalDict");
    boolean _not = (!_hasDB_Obj);
    if (_not) {
      return null;
    }
    List<Record> result = this.dbAccessor.runCodeRecords(String.format("MATCH (%1$s:Dictionary {name:\'%2$s\'}) Return %1$s", Neo4jConstants._N, DictionaryConstants._GLOBAL), Neo4jAccess.Action.READ);
    boolean _isEmpty = result.isEmpty();
    if (_isEmpty) {
      result = this.dbAccessor.runCodeRecords(String.format("CREATE (n:Dictionary {name:\'%s\'})", DictionaryConstants._GLOBAL), Neo4jAccess.Action.WRITE);
    }
    boolean _isEmpty_1 = result.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      return result.get(0);
    } else {
      return null;
    }
  }

  /**
   * Logger API
   */
  protected void logResult(final List<Record> result, final String task, final String message, final String wordToLc) {
    if ((result == null)) {
      return;
    }
    boolean _isEmpty = result.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[");
      _builder.append(task);
      _builder.append("] ");
      _builder.append(message);
      _builder.append(": \"");
      _builder.append(wordToLc);
      _builder.append("\"");
      this.logUtil.logAccess("Info", 0, _builder.toString());
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("X [");
      _builder_1.append(task);
      _builder_1.append("] No grammar counterpart found yet: \"");
      _builder_1.append(wordToLc);
      _builder_1.append("\"");
      this.logUtil.logAccess("Info", 0, _builder_1.toString());
    }
  }

  /**
   * @Deprecated: Used by ImplicitRules:
   */
  @Deprecated
  @Override
  public ITypeInfo findInDictionary(final String word) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Dictionary not connected: Entry: ");
    _builder.append(word);
    boolean _hasDB_Obj = this.hasDB_Obj(_builder.toString());
    boolean _not = (!_hasDB_Obj);
    if (_not) {
      return null;
    }
    this.isConnected = this.dbAccessor.ensureDbConnect();
    String wordToLc = word.toLowerCase();
    ArrayList<Object> result = CollectionLiterals.<Object>newArrayList();
    boolean _containsKey = this.unknownWordCache.containsKey(wordToLc);
    if (_containsKey) {
      return null;
    }
    boolean _containsKey_1 = this.typeCache.containsKey(wordToLc);
    if (_containsKey_1) {
      return this.typeCache.get(wordToLc);
    }
    return this.getLinkTypes(wordToLc, NodeConstants._WORD);
  }

  /**
   * Used by IplicitRules:
   */
  @Override
  public List<String> listAllLabel(final String label) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._N);
    _builder.append(":");
    _builder.append(label);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("RETURN ");
    _builder.append(Neo4jConstants._N);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    List<Record> query_result = this.dbAccessor.runCodeRecords(_builder.toString(), Neo4jAccess.Action.READ);
    boolean _isEmpty = query_result.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Function<Record, String> _function = (Record rec) -> {
        return Objects.toString(rec.values().get(0).asString(), null);
      };
      List<String> labels = query_result.parallelStream().<String>map(_function).collect(Collectors.<String>toList());
      return labels;
    } else {
      return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
    }
  }

  /**
   * Used by IplicitRules:
   */
  @Override
  public List<String> listAllLabelTo(final String label, final String linkLabel, final String targetL) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._N);
    _builder.append(":");
    _builder.append(label);
    _builder.append(")-[:");
    _builder.append(linkLabel);
    _builder.append("]->(:");
    _builder.append(targetL);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("RETURN ");
    _builder.append(Neo4jConstants._N);
    _builder.append(".");
    _builder.append(Neo4jConstants._NAME);
    List<Record> query_result = this.dbAccessor.runCodeRecords(_builder.toString(), Neo4jAccess.Action.READ);
    boolean _isEmpty = query_result.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Function<Record, String> _function = (Record rec) -> {
        return Objects.toString(rec.values().get(0).asString(), null);
      };
      List<String> labels = query_result.parallelStream().<String>map(_function).collect(Collectors.<String>toList());
      return labels;
    } else {
      return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
    }
  }

  /**
   * Check for Database
   */
  protected boolean hasDB_Obj(final String msg) {
    if ((this.dbAccessor == null)) {
      this.logUtil.logAccess("hasDB", 1, msg);
      return false;
    }
    return true;
  }

  /**
   * Must be renamed as: wordClassExist
   * 
   * @param type
   * @return
   */
  protected boolean nodeExist(final String type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Dictionary not connected: Type: ");
    _builder.append(type);
    boolean _hasDB_Obj = this.hasDB_Obj(_builder.toString());
    boolean _not = (!_hasDB_Obj);
    if (_not) {
      return false;
    }
    String nodeName = type;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("MATCH (");
    _builder_1.append(Neo4jConstants._N);
    _builder_1.append(":");
    _builder_1.append(DictionaryConstants._WORD_CLASS);
    _builder_1.append(" {");
    _builder_1.append(Neo4jConstants._NAME);
    _builder_1.append(":\'");
    _builder_1.append(nodeName);
    _builder_1.append("\'}) ");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("RETURN ");
    _builder_1.append(Neo4jConstants._N);
    List<Record> result = this.dbAccessor.runCodeRecords(_builder_1.toString(), Neo4jAccess.Action.READ);
    boolean _isEmpty = result.isEmpty();
    if (_isEmpty) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("CREATE (");
      _builder_2.append(Neo4jConstants._N);
      _builder_2.append(":");
      _builder_2.append(DictionaryConstants._WORD_CLASS);
      _builder_2.append(" { ");
      _builder_2.append(Neo4jConstants._NAME);
      _builder_2.append(": \'");
      _builder_2.append(nodeName);
      _builder_2.append("\' })");
      this.dbAccessor.runCodeRecords(_builder_2.toString(), Neo4jAccess.Action.WRITE);
    }
    return true;
  }

  /**
   * UsedBy ImplicitRules:
   */
  protected boolean linkExist(final String from, final String to, final String type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Dictionary not connected: Type: ");
    _builder.append(type);
    boolean _hasDB_Obj = this.hasDB_Obj(_builder.toString());
    boolean _not = (!_hasDB_Obj);
    if (_not) {
      return false;
    }
    String nodeName = type;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("MATCH (");
    _builder_1.append(Neo4jConstants._N);
    _builder_1.append(":");
    _builder_1.append(DictionaryConstants._WORD_CLASS);
    _builder_1.append(" {");
    _builder_1.append(Neo4jConstants._NAME);
    _builder_1.append(":\'");
    _builder_1.append(nodeName);
    _builder_1.append("\'}) ");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("RETURN ");
    _builder_1.append(Neo4jConstants._N);
    List<Record> result = this.dbAccessor.runCodeRecords(_builder_1.toString(), Neo4jAccess.Action.READ);
    boolean _isEmpty = result.isEmpty();
    if (_isEmpty) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("CREATE (");
      _builder_2.append(Neo4jConstants._N);
      _builder_2.append(":");
      _builder_2.append(DictionaryConstants._WORD_CLASS);
      _builder_2.append(" { ");
      _builder_2.append(Neo4jConstants._NAME);
      _builder_2.append(": \'");
      _builder_2.append(nodeName);
      _builder_2.append("\' })");
      this.dbAccessor.runCodeRecords(_builder_2.toString(), Neo4jAccess.Action.WRITE);
    }
    return true;
  }

  /**
   * Another Check for Database
   */
  @Override
  public boolean isConnected() {
    if ((this.dbAccessor == null)) {
      return false;
    }
    if (this.isConnected) {
      return true;
    }
    this.isConnected = this.dbAccessor.ensureDbConnect();
    return this.isConnected;
  }

  /**
   * UsedBy ImplicitRules:
   * @Deprecated: use similar functions in Database API
   */
  @Deprecated
  public ArrayList<Record> getAllRecords(final List<Record> records) {
    ArrayList<Record> _xblockexpression = null;
    {
      ArrayList<Record> result = CollectionLiterals.<Record>newArrayList();
      for (final Record rec : records) {
        if ((rec instanceof Record)) {
          result.add(rec);
        }
      }
      ArrayList<Record> _xifexpression = null;
      boolean _isEmpty = result.isEmpty();
      if (_isEmpty) {
        _xifexpression = null;
      } else {
        _xifexpression = result;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  /**
   * Functions to extract results from records
   */
  public Node getFirstRecord(final List<Record> records, final String varName) {
    for (final Record rec : records) {
      if ((rec instanceof Record)) {
        return rec.get(varName).asNode();
      }
    }
    return null;
  }

  /**
   * Functions to extract results from records
   */
  public Iterable<?> getLabel(final Value value) {
    Iterable<?> _switchResult = null;
    boolean _matched = false;
    if (value instanceof NodeValue) {
      _matched=true;
      _switchResult = ((NodeValue)value).asNode().labels();
    }
    if (!_matched) {
      if (value instanceof RelationshipValue) {
        _matched=true;
        _switchResult = ((RelationshipValue)value).asRelationship().keys();
      }
    }
    if (!_matched) {
      if (value instanceof ListValue) {
        _matched=true;
        _switchResult = ((ListValue)value).asList();
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }

  /**
   * Functions to extract results from records
   */
  public Object getAttr(final Node node, final String name) {
    Object _xblockexpression = null;
    {
      if ((node == null)) {
        return null;
      }
      _xblockexpression = node.asMap().get(name);
    }
    return _xblockexpression;
  }

  /**
   * Functions to extract results from records
   */
  public Node getNode(final Value value) {
    if ((value instanceof NodeValue)) {
      return ((NodeValue)value).asNode();
    } else {
      return null;
    }
  }

  /**
   * Functions to extract results from records
   */
  public Relationship getRelationship(final Value value) {
    if ((value instanceof RelationshipValue)) {
      return ((RelationshipValue)value).asRelationship();
    } else {
      return null;
    }
  }

  /**
   * Functions to extract results from records
   */
  @Override
  public ITypeInfo getLinkTypes(final String name, final String fromType) {
    return this.getLinkTypes(name, fromType, false);
  }

  /**
   * Functions to extract results from records
   */
  @Override
  public ITypeInfo getLinkTypes(final String name, final String fromType, final boolean update) {
    WordTypeInfo _xblockexpression = null;
    {
      final int min = 1;
      final int max = 1;
      Pair<String, String> _mappedTo = Pair.<String, String>of(NodeConstants._WORD, NodeConstants._M);
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of(NodeConstants._INTERPUNCTION, Neo4jConstants._N);
      final Map<String, String> source = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1));
      final Function1<String, String> _function = (String n) -> {
        return n.toLowerCase();
      };
      Pair<String, Function1<String, String>> _mappedTo_2 = Pair.<String, Function1<String, String>>of(NodeConstants._WORD, _function);
      final Function1<String, String> _function_1 = (String n) -> {
        return n.toUpperCase();
      };
      Pair<String, Function1<String, String>> _mappedTo_3 = Pair.<String, Function1<String, String>>of(NodeConstants._INTERPUNCTION, _function_1);
      final Map<String, Function1<String, String>> switchCase = Collections.<String, Function1<String, String>>unmodifiableMap(CollectionLiterals.<String, Function1<String, String>>newHashMap(_mappedTo_2, _mappedTo_3));
      boolean _containsKey = source.containsKey(fromType);
      boolean _not = (!_containsKey);
      if (_not) {
        return null;
      }
      HashMap<String, ITypeAttributes> types = CollectionLiterals.<String, ITypeAttributes>newHashMap();
      if ((name == null)) {
        return null;
      }
      String nameToLc = this.typeCase.get(fromType).apply(name);
      if ((!update)) {
        boolean _containsKey_1 = this.typeCache.containsKey(nameToLc);
        if (_containsKey_1) {
          return this.typeCache.get(nameToLc);
        }
        boolean _containsKey_2 = this.unknownWordCache.containsKey(nameToLc);
        if (_containsKey_2) {
          return null;
        }
      }
      String wordToLc = "";
      boolean _containsKey_3 = switchCase.containsKey(fromType);
      if (_containsKey_3) {
        wordToLc = switchCase.get(fromType).apply(name);
      } else {
        wordToLc = name;
      }
      String query = this.createTypeMatchQuery(wordToLc, fromType, true, null, min, max).toString();
      String _query = query;
      String _string = this.createTypeReturn(fromType, NodeConstants._M, Neo4jConstants._N).toString();
      query = (_query + _string);
      List<Record> allRecs = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.READ);
      WordTypeInfo _xifexpression = null;
      if (((allRecs != null) && (!allRecs.isEmpty()))) {
        WordTypeInfo _xblockexpression_1 = null;
        {
          Node sourceNode = this.getNode(allRecs.get(0).get(NodeConstants._M));
          for (final Record rec : allRecs) {
            {
              Node baseNode = this.getNode(rec.get(Neo4jConstants._N));
              Object _attr = this.getAttr(baseNode, Neo4jConstants._NAME);
              final String typeName = ((String) _attr);
              List<Object> _asList = rec.get(Neo4jConstants._ATTRS).asList();
              for (final Object entry : _asList) {
                {
                  Object _get = ((Map) entry).get(Neo4jConstants._LK);
                  Node _node = this.getNode(rec.get(source.get(fromType)));
                  Object _get_1 = ((Map) entry).get(Neo4jConstants._ATTR);
                  TypeAttributes typeAttributes = new TypeAttributes(baseNode, ((List) _get), _node, ((Node) _get_1));
                  boolean _containsKey_4 = types.containsKey(typeName);
                  if (_containsKey_4) {
                    typeAttributes.merge(types.get(typeName));
                  }
                  types.put(typeName, typeAttributes);
                }
              }
            }
          }
          WordTypeInfo info = new WordTypeInfo(sourceNode, types);
          boolean _containsKey_4 = this.unknownWordCache.containsKey(nameToLc);
          if (_containsKey_4) {
            this.unknownWordCache.remove(nameToLc);
          }
          this.typeCache.put(nameToLc, info);
          _xblockexpression_1 = info;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        Object _xblockexpression_2 = null;
        {
          this.unknownWordCache.put(nameToLc, "");
          _xblockexpression_2 = null;
        }
        _xifexpression = ((WordTypeInfo)_xblockexpression_2);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  @Override
  public IBuildLogger getLogger() {
    return this.buildLogger;
  }

  /**
   * part of resolve type hierarchy. currently word type subtype hierarchy is unused.
   */
  @Override
  public List<ITypeHierarchy> resolveTypeHierarchy(final String root, final String branch) {
    List<ITypeHierarchy> _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Dictionary not connected: ");
      String _name = this.getClass().getName();
      _builder.append(_name);
      _builder.append(" resolveTypeHierarchy(String root)");
      boolean _hasDB_Obj = this.hasDB_Obj(_builder.toString());
      boolean _not = (!_hasDB_Obj);
      if (_not) {
        return null;
      }
      _xblockexpression = this.recursiveResolveByLabel(root, branch);
    }
    return _xblockexpression;
  }

  /**
   * part of resolve type hierarchy. currently word type subtype hierarchy is unused.
   */
  public List<ITypeHierarchy> recursiveResolveByLabel(final String root, final String branch) {
    List<ITypeHierarchy> _xblockexpression = null;
    {
      Arrow arrow = new Arrow(Neo4jConstants._L, Neo4jConstants._OF_CLASS, Direction.LEFT);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._N);
      _builder.append(":");
      _builder.append(root);
      _builder.append(")");
      CharSequence _generate = arrow.generate();
      _builder.append(_generate);
      _builder.append("(");
      _builder.append(Neo4jConstants._T);
      _builder.append(":");
      _builder.append(branch);
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("RETURN *");
      String query = _builder.toString();
      List<Record> result = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.READ);
      _xblockexpression = this.resolveQuery(result, Neo4jConstants._T, branch);
    }
    return _xblockexpression;
  }

  /**
   * part of resolve type hierarchy. currently word type subtype hierarchy is unused.
   */
  public List<ITypeHierarchy> recursiveResolveByNode(final Node node, final String branch) {
    List<ITypeHierarchy> _xblockexpression = null;
    {
      Arrow arrow = new Arrow(Neo4jConstants._L, Neo4jConstants._OF_CLASS, Direction.LEFT);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._N);
      _builder.append(")");
      CharSequence _generate = arrow.generate();
      _builder.append(_generate);
      _builder.append("(");
      _builder.append(Neo4jConstants._T);
      _builder.append(":");
      _builder.append(branch);
      _builder.append(") Where ID(");
      _builder.append(Neo4jConstants._N);
      _builder.append(") = ");
      long _id = node.id();
      _builder.append(_id);
      _builder.newLineIfNotEmpty();
      _builder.append("RETURN ");
      _builder.append(Neo4jConstants._T);
      String query = _builder.toString();
      List<Record> result = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.READ);
      _xblockexpression = this.resolveQuery(result, Neo4jConstants._T, branch);
    }
    return _xblockexpression;
  }

  /**
   * part of resolve type hierarchy. currently word type subtype hierarchy is unused.
   */
  public List<ITypeHierarchy> resolveQuery(final List<Record> records, final String varName, final String branch) {
    boolean _isEmpty = records.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List<ITypeHierarchy> types = CollectionLiterals.<ITypeHierarchy>newArrayList();
      for (final Record rec : records) {
        {
          Node node = rec.get(varName).asNode();
          List<ITypeHierarchy> _recursiveResolveByNode = this.recursiveResolveByNode(node, branch);
          TypeHierarchy _typeHierarchy = new TypeHierarchy(node, _recursiveResolveByNode);
          types.add(_typeHierarchy);
        }
      }
      return types;
    } else {
      return Collections.<ITypeHierarchy>unmodifiableList(CollectionLiterals.<ITypeHierarchy>newArrayList());
    }
  }

  @Override
  public void addSuccessor(final DictItem source, final DictItem target, final Set<String> targetTypes) {
    this.addSuccessor(source, target, targetTypes, Collections.<ITypeAttributes>unmodifiableList(CollectionLiterals.<ITypeAttributes>newArrayList()));
  }

  /**
   * PostProcess Job, requires better logging to precisely trace db-changes
   */
  @Override
  public void addSuccessor(final DictItem source, final DictItem target, final Set<String> targetTypes, final List<ITypeAttributes> attribs) throws ClientException {
    String typeExtension = "";
    if ((source == null)) {
      return;
    }
    String _type = source.getType();
    boolean _matched = false;
    if (Objects.equals(_type, NodeConstants._INTERPUNCTION)) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      {
        String _innerType = source.getInnerType();
        boolean _tripleNotEquals = (_innerType != null);
        if (_tripleNotEquals) {
          _builder.append(", ");
          _builder.append(NodeConstants._TYPE);
          _builder.append(":\"");
          String _innerType_1 = source.getInnerType();
          _builder.append(_innerType_1);
          _builder.append("\"");
        }
      }
      typeExtension = _builder.toString();
    }
    if (!_matched) {
      typeExtension = "";
    }
    String sourceQuery = "";
    String _type_1 = source.getType();
    boolean _equals = false;
    if (_type_1!=null) {
      _equals=_type_1.equals(DictionaryConstants._BRACKET_SENTENCE);
    }
    if (_equals) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(DictionaryConstants._CLUSTER_TYPE);
      _builder_1.append(" {");
      _builder_1.append(Neo4jConstants._NAME);
      _builder_1.append(": \"");
      String _type_2 = source.getType();
      _builder_1.append(_type_2);
      _builder_1.append("\"");
      _builder_1.append(typeExtension);
      _builder_1.append("}»");
      sourceQuery = _builder_1.toString();
    } else {
      String nameCase = source.getName();
      boolean _containsKey = this.typeCase.containsKey(source.getType());
      if (_containsKey) {
        nameCase = this.typeCase.get(source.getType()).apply(source.getName());
      }
      StringConcatenation _builder_2 = new StringConcatenation();
      String _type_3 = source.getType();
      _builder_2.append(_type_3);
      _builder_2.append(" {");
      _builder_2.append(Neo4jConstants._NAME);
      _builder_2.append(":\"");
      _builder_2.append(nameCase);
      _builder_2.append("\"");
      _builder_2.append(typeExtension);
      _builder_2.append("}");
      sourceQuery = _builder_2.toString();
    }
    Pair<String, Direction> _mappedTo = Pair.<String, Direction>of(DictionaryConstants._BASEFORM, Direction.IN);
    Pair<String, Direction> _mappedTo_1 = Pair.<String, Direction>of(DictionaryConstants._CONJUGATION, Direction.OUT);
    Pair<String, Direction> _mappedTo_2 = Pair.<String, Direction>of(DictionaryConstants._CONTINUOUS, Direction.IN);
    Pair<String, Direction> _mappedTo_3 = Pair.<String, Direction>of(DictionaryConstants._PLURAL, Direction.OUT);
    final Map<String, Direction> grammar_preset = Collections.<String, Direction>unmodifiableMap(CollectionLiterals.<String, Direction>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3));
    Pair<String, Direction> _mappedTo_4 = Pair.<String, Direction>of(DictionaryConstants._CONTINUOUS, Direction.OUT);
    final Map<String, Direction> additional_preset = Collections.<String, Direction>unmodifiableMap(CollectionLiterals.<String, Direction>newHashMap(_mappedTo_4));
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of(NodeConstants._WORD, DictionaryConstants._WORD_CLASS);
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of(NodeConstants._INTERPUNCTION, NodeConstants._INTERPUNCTION);
    final Map<String, String> targetClass = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_5, _mappedTo_6));
    for (final ITypeAttributes attr : attribs) {
      boolean _matched_1 = false;
      if (attr instanceof TypeAttributes) {
        _matched_1=true;
        INodeEL sourceNode = ((INodeEL[])Conversions.unwrapArray(((TypeAttributes)attr).getSourceEL(), INodeEL.class))[0];
        for (final Direction dir : Collections.<Direction>unmodifiableSet(CollectionLiterals.<Direction>newHashSet(Direction.IN, Direction.OUT))) {
          {
            final Function1<IRelationshipEL, Boolean> _function = (IRelationshipEL r) -> {
              boolean _xblockexpression = false;
              {
                final List<String> ls = IterableExtensions.<String>toList(this.opposite(r, dir).getNode().labels());
                final Predicate<String> _function_1 = (String el) -> {
                  return ls.contains(el);
                };
                _xblockexpression = this.nodeFilter.stream().anyMatch(_function_1);
              }
              return Boolean.valueOf(_xblockexpression);
            };
            List<IRelationshipEL> rels = IterableExtensions.<IRelationshipEL>toList(IterableExtensions.<IRelationshipEL>filter(sourceNode.getRelationship(dir), _function));
            for (final IRelationshipEL rel : rels) {
              {
                INodeEL targetNode = this.opposite(rel, dir);
                StringConcatenation _builder_3 = new StringConcatenation();
                _builder_3.append(NodeConstants._TYPE);
                _builder_3.append(":\"");
                String _asString = targetNode.getNode().get(Neo4jConstants._NAME).asString();
                _builder_3.append(_asString);
                _builder_3.append("\"");
                Pair<String, String> _mappedTo_7 = Pair.<String, String>of(DictionaryConstants._CONJUGATION, _builder_3.toString());
                Map<String, String> attrOptions = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo_7));
                boolean _equals_1 = rel.getRelationship().type().equals(DictionaryConstants._FOLLOWED_BY);
                boolean _not = (!_equals_1);
                if (_not) {
                  StringConcatenation _builder_4 = new StringConcatenation();
                  _builder_4.append(DictionaryConstants._FOLLOWED_BY);
                  _builder_4.append(" {");
                  _builder_4.append(NodeConstants._TYPE);
                  _builder_4.append(":\"");
                  String _name = dir.name();
                  _builder_4.append(_name);
                  _builder_4.append("\"}");
                  String linkType = _builder_4.toString();
                  Iterable<String> _labels = targetNode.getNode().labels();
                  boolean _contains = ((List) _labels).contains(NodeConstants._WORD);
                  if (_contains) {
                    String attrType = rel.getRelationship().type();
                    Direction pT = grammar_preset.get(attrType);
                    Direction aT = additional_preset.get(rel.getRelationship().type());
                    boolean _equals_2 = Objects.equals(aT, dir);
                    if (_equals_2) {
                      final Function1<IRelationshipEL, String> _function_1 = (IRelationshipEL r) -> {
                        return r.getRelationship().type();
                      };
                      boolean _contains_1 = ListExtensions.<IRelationshipEL, String>map(((List<IRelationshipEL>) rels), _function_1).contains(DictionaryConstants._BASEFORM);
                      boolean _not_1 = (!_contains_1);
                      if (_not_1) {
                        this.createBaseForm(sourceQuery, target.getName(), linkType, sourceNode.getNode(), targetNode.getNode(), targetNode.getNode().id());
                      }
                    }
                    if (((pT != null) && pT.equals(dir))) {
                      String option = attrOptions.get(attrType);
                      StringConcatenation _builder_5 = new StringConcatenation();
                      _builder_5.append(Neo4jConstants._N);
                      _builder_5.append(":");
                      _builder_5.append(NodeConstants._GRAMMAR);
                      _builder_5.append(" {");
                      _builder_5.append(Neo4jConstants._NAME);
                      _builder_5.append(":\"");
                      String _type_4 = rel.getRelationship().type();
                      _builder_5.append(_type_4);
                      _builder_5.append("\"");
                      {
                        if ((option != null)) {
                          _builder_5.append(", ");
                          _builder_5.append(option);
                        }
                      }
                      _builder_5.append("}");
                      Node intermed = NodeUtil.nodeExistOrCreate(this.dbAccessor, _builder_5.toString(), Neo4jConstants._N, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), false);
                      long intID = intermed.id();
                      if (pT != null) {
                        switch (pT) {
                          case IN:
                            StringConcatenation _builder_6 = new StringConcatenation();
                            String _type_5 = source.getType();
                            _builder_6.append(_type_5);
                            _builder_6.append(" {");
                            _builder_6.append(Neo4jConstants._NAME);
                            _builder_6.append(":\"");
                            Value _get = sourceNode.getNode().get(Neo4jConstants._NAME);
                            _builder_6.append(_get);
                            _builder_6.append("\"}");
                            StringConcatenation _builder_7 = new StringConcatenation();
                            _builder_7.append(NodeConstants._FORM);
                            NodeUtil.linkExistOrCreate(this.dbAccessor, _builder_6.toString(), "", _builder_7.toString(), targetNode.getNode().id(), intID);
                            break;
                          case OUT:
                            StringConcatenation _builder_8 = new StringConcatenation();
                            String _type_6 = target.getType();
                            _builder_8.append(_type_6);
                            _builder_8.append(" {");
                            _builder_8.append(Neo4jConstants._NAME);
                            _builder_8.append(":\"");
                            String _asString_1 = targetNode.getNode().get(Neo4jConstants._NAME).asString();
                            _builder_8.append(_asString_1);
                            _builder_8.append("\"}");
                            StringConcatenation _builder_9 = new StringConcatenation();
                            _builder_9.append(NodeConstants._FORM);
                            NodeUtil.linkExistOrCreate(
                              this.dbAccessor, _builder_8.toString(), 
                              "", _builder_9.toString(), 
                              targetNode.getNode().id(), intID);
                            break;
                          default:
                            break;
                        }
                      } else {
                      }
                      NodeUtil.linkExistOrCreate(this.dbAccessor, sourceQuery, "", linkType, source.getId(), intID);
                    }
                  } else {
                    NodeUtil.linkExistOrCreate(this.dbAccessor, sourceQuery, "", linkType, source.getId(), targetNode.getNode().id());
                  }
                }
              }
            }
          }
        }
      }
      if (!_matched_1) {
        if (attr instanceof InterpunctionTypeAttribute) {
          _matched_1=true;
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append(NodeConstants._INTERPUNCTION);
          _builder_3.append(" {");
          _builder_3.append(Neo4jConstants._NAME);
          _builder_3.append(":\"");
          Object _attrs = ((InterpunctionTypeAttribute)attr).getAttrs();
          _builder_3.append(_attrs);
          _builder_3.append("\"");
          {
            String _type_4 = ((InterpunctionTypeAttribute)attr).getType();
            boolean _tripleNotEquals_1 = (_type_4 != null);
            if (_tripleNotEquals_1) {
              _builder_3.append(", ");
              _builder_3.append(NodeConstants._TYPE);
              _builder_3.append(":\"");
              String _type_5 = ((InterpunctionTypeAttribute)attr).getType();
              _builder_3.append(_type_5);
              _builder_3.append("\"");
            }
          }
          _builder_3.append("}");
          String subQuery = _builder_3.toString();
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append(Neo4jConstants._N);
          _builder_4.append(":");
          _builder_4.append(subQuery);
          Node interp = NodeUtil.nodeExistOrCreate(this.dbAccessor, _builder_4.toString(), Neo4jConstants._N, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), false);
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append(DictionaryConstants._FOLLOWED_BY);
          NodeUtil.linkExistOrCreate(this.dbAccessor, sourceQuery, subQuery, _builder_5.toString(), (-1), interp.id());
        }
      }
    }
    boolean _equals_1 = target.getType().equals(NodeConstants._INTERPUNCTION);
    if (_equals_1) {
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(DictionaryConstants._FOLLOWED_BY);
      NodeUtil.linkExistOrCreate(this.dbAccessor, sourceQuery, "", _builder_3.toString(), source.getId(), target.getId());
    } else {
      for (final String type : targetTypes) {
        StringConcatenation _builder_4 = new StringConcatenation();
        String _get = targetClass.get(target.getType());
        _builder_4.append(_get);
        _builder_4.append(" {");
        _builder_4.append(Neo4jConstants._NAME);
        _builder_4.append(":\"");
        _builder_4.append(type);
        _builder_4.append("\"}");
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append(DictionaryConstants._FOLLOWED_BY);
        NodeUtil.linkExistOrCreate(this.dbAccessor, sourceQuery, _builder_4.toString(), _builder_5.toString(), source.getId(), target.getId());
      }
    }
  }

  public INodeEL opposite(final IRelationshipEL r, final Direction dir) {
    INodeEL _switchResult = null;
    if (dir != null) {
      switch (dir) {
        case IN:
          _switchResult = r.getStart();
          break;
        case OUT:
          _switchResult = r.getEnd();
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }

  public List<Node> filterAttributes(final List<Node> nodes) {
    ArrayList<Node> _xblockexpression = null;
    {
      ArrayList<Node> result = CollectionLiterals.<Node>newArrayList();
      for (final Node n : nodes) {
        Iterable<String> _labels = n.labels();
        for (final String l : _labels) {
          boolean _contains = this.nodeFilter.contains(l);
          if (_contains) {
            result.add(n);
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  public List<Record> createBaseForm(final String sourceQuery, final String target, final String linkType, final Node sourceNode, final Node targetNode, final long targetID) throws ClientException {
    List<Record> _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(Neo4jConstants._N);
      _builder.append(":");
      _builder.append(NodeConstants._GRAMMAR);
      _builder.append(" {");
      _builder.append(Neo4jConstants._NAME);
      _builder.append(":\"");
      _builder.append(DictionaryConstants._BASEFORM);
      _builder.append("\"}");
      Node intermed = NodeUtil.nodeExistOrCreate(this.dbAccessor, _builder.toString(), Neo4jConstants._N, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), false);
      long id = intermed.id();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(NodeConstants._FORM);
      NodeUtil.linkExistOrCreate(this.dbAccessor, "", "", _builder_1.toString(), targetID, id);
      _xblockexpression = NodeUtil.linkExistOrCreate(this.dbAccessor, sourceQuery, "", linkType, (-1), id);
    }
    return _xblockexpression;
  }

  /**
   * PostProcess Job, requires better logging to precisely trace db-changes
   */
  @Override
  public List<Record> processSuffix(final String word, final List<ITypeAttributes> attributes) throws ClientException {
    String intWord = word;
    for (final String suffix : this.suffixes) {
      boolean _endsWith = intWord.endsWith(suffix);
      if (_endsWith) {
        List<Record> pRes = this.findPrefix(intWord, CollectionLiterals.<String>newArrayList(((String[])Conversions.unwrapArray(this.prefixes, String.class))), 1, true);
        if (((pRes != null) && (!pRes.isEmpty()))) {
          String whichPx = pRes.get(0).get(Neo4jConstants._LS).asString();
          intWord = intWord.substring(whichPx.length(), intWord.length());
        }
        List<Record> res = this.findPostfixRelative(intWord, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(suffix)), 0, true, true);
        if (((res != null) && (!res.isEmpty()))) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(" ");
          _builder.append(">>  ");
          _builder.newLine();
          _builder.append("[DictAccess: processSuffix] Word: ");
          _builder.append(intWord);
          _builder.append(", Suffix: ");
          _builder.append(suffix);
          InputOutput.<String>print(_builder.toString());
          return res;
        }
      }
    }
    List<Record> res_1 = this.findPostfixRelative(intWord, CollectionLiterals.<String>newArrayList(((String[])Conversions.unwrapArray(this.suffixes, String.class))), 1, false, true);
    if (((res_1 != null) && (!res_1.isEmpty()))) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(" ");
      _builder_1.append(">> ");
      _builder_1.newLine();
      _builder_1.append("[DictAccess: precessSuffix] Base: ");
      _builder_1.append(intWord);
      _builder_1.append(", ");
      {
        boolean _hasElements = false;
        for(final Record rec : res_1) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_1.appendImmediate(", ", "");
          }
          _builder_1.append(" Target: ");
          String _asString = rec.get(Neo4jConstants._N).asNode().get(Neo4jConstants._NAME).asString();
          _builder_1.append(_asString);
          _builder_1.append(" Suffix: ");
          String _asString_1 = rec.get(Neo4jConstants._LS).asString();
          _builder_1.append(_asString_1);
        }
      }
      InputOutput.<String>print(_builder_1.toString());
      return res_1;
    }
    return null;
  }

  /**
   * PostProcess Job, requires better logging to precisely trace db-changes
   */
  @Override
  public List<Record> processPrefix(final String word, final List<ITypeAttributes> attributes) throws ClientException {
    List<Record> res = this.findPrefix(word, CollectionLiterals.<String>newArrayList(((String[])Conversions.unwrapArray(this.prefixes, String.class))), 1, true);
    if (((res != null) && (!res.isEmpty()))) {
      String whichPx = res.get(0).get(Neo4jConstants._LS).asString();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append(">>  ");
      _builder.newLine();
      _builder.append("[DictAccess: processPrefix] Word: ");
      _builder.append(word);
      _builder.append(", Suffix: ");
      _builder.append(whichPx);
      InputOutput.<String>print(_builder.toString());
      return res;
    }
    return null;
  }

  @Override
  public void deleteNode(final Node node) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[DictAccess] delete Node: ");
    String _asString = node.get(Neo4jConstants._NAME).asString();
    _builder.append(_asString);
    InputOutput.<String>println(_builder.toString());
  }

  @Override
  public List<Record> deletePatternFromNode(final Node node) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[DictAccess] delete pattern from Node: ");
    String _asString = node.get(Neo4jConstants._NAME).asString();
    _builder.append(_asString);
    InputOutput.<String>println(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("MATCH (");
    _builder_1.append(Neo4jConstants._N);
    _builder_1.append(") WHERE ID(");
    _builder_1.append(Neo4jConstants._N);
    _builder_1.append(") = ");
    long _id = node.id();
    _builder_1.append(_id);
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("MATCH (");
    _builder_1.append(Neo4jConstants._N);
    _builder_1.append(")-[");
    _builder_1.append(Neo4jConstants._L);
    _builder_1.append(":");
    _builder_1.append(DictionaryConstants._EXCLUDES);
    _builder_1.append("]->(");
    _builder_1.append(Neo4jConstants._T);
    _builder_1.append(")");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("DETACH DELETE ");
    _builder_1.append(Neo4jConstants._T);
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("RETURN *");
    String query = _builder_1.toString();
    List<Record> result = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.WRITE);
    return result;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public List<Record> disableNode(final Node node, final ITypeAttributes start, final ITypeAttributes end, final int cardinality, final XPair<String, ITypeAttributes> cardinalType) throws ClientException {
    List<Record> _xblockexpression = null;
    {
      Collection<? extends IRelationshipEL> _attrsEL = start.getAttrsEL();
      Pair<String, Collection<? extends IRelationshipEL>> _mappedTo = Pair.<String, Collection<? extends IRelationshipEL>>of(DictionaryConstants._START, _attrsEL);
      Collection<? extends IRelationshipEL> _attrsEL_1 = end.getAttrsEL();
      Pair<String, Collection<? extends IRelationshipEL>> _mappedTo_1 = Pair.<String, Collection<? extends IRelationshipEL>>of(DictionaryConstants._END, _attrsEL_1);
      Map<String, Collection<? extends IRelationshipEL>> attrs = Collections.<String, Collection<? extends IRelationshipEL>>unmodifiableMap(CollectionLiterals.<String, Collection<? extends IRelationshipEL>>newHashMap(_mappedTo, _mappedTo_1));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH (");
      _builder.append(Neo4jConstants._N);
      _builder.append(") WHERE ID(");
      _builder.append(Neo4jConstants._N);
      _builder.append(") = ");
      long _id = node.id();
      _builder.append(_id);
      String sourceNode = _builder.toString();
      String min = "1";
      Object max = null;
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(sourceNode);
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("MATCH ");
      _builder_1.append(Neo4jConstants._P);
      _builder_1.append(" = (");
      _builder_1.append(Neo4jConstants._N);
      _builder_1.append(")");
      CharSequence _generate = new Arrow(Neo4jConstants._L, DictionaryConstants._EXCLUDES, null, min, ((String)max), true, Direction.RIGHT).generate();
      _builder_1.append(_generate);
      _builder_1.append("(");
      _builder_1.append(NodeConstants._W);
      _builder_1.append(")");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("MATCH (");
      _builder_1.append(NodeConstants._W);
      _builder_1.append(")");
      CharSequence _generate_1 = new Arrow(Neo4jConstants._R, null, Direction.RIGHT).generate();
      _builder_1.append(_generate_1);
      _builder_1.append("(");
      _builder_1.append(Neo4jConstants._T);
      _builder_1.append(") WHERE NOT ");
      {
        if ((cardinality > 0)) {
          _builder_1.append("(");
          _builder_1.append(Neo4jConstants._T);
          _builder_1.append(":");
          _builder_1.append(DictionaryConstants._PATTERN);
          _builder_1.append(" OR ");
          _builder_1.append(Neo4jConstants._T);
          _builder_1.append(":");
          _builder_1.append(DictionaryConstants._REDUNDANCE);
          _builder_1.append(") ");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("MATCH (");
          _builder_1.append(NodeConstants._W);
          _builder_1.append(")");
          CharSequence _generate_2 = new Arrow(null, null, Direction.RIGHT).generate();
          _builder_1.append(_generate_2);
          _builder_1.append("(");
          _builder_1.append(Neo4jConstants._B);
          _builder_1.append(":");
          _builder_1.append(DictionaryConstants._REDUNDANCE);
          _builder_1.append(") WHERE ");
          _builder_1.append(Neo4jConstants._B);
          _builder_1.append(".");
          _builder_1.append(DictionaryConstants._CARDINALITY);
          _builder_1.append(" <= ");
          _builder_1.append(cardinality);
          _builder_1.newLineIfNotEmpty();
        } else {
          _builder_1.append(Neo4jConstants._T);
          _builder_1.append(":");
          _builder_1.append(DictionaryConstants._PATTERN);
          _builder_1.newLineIfNotEmpty();
        }
      }
      _builder_1.append("RETURN ");
      _builder_1.append(Neo4jConstants._N);
      _builder_1.append(", ");
      _builder_1.append(Neo4jConstants._L);
      _builder_1.append(", ");
      _builder_1.append(NodeConstants._W);
      _builder_1.append(", ");
      _builder_1.append(Neo4jConstants._P);
      _builder_1.append(", ");
      {
        if ((cardinality > 0)) {
          _builder_1.append(Neo4jConstants._B);
          _builder_1.append(", ");
        }
      }
      _builder_1.append("COLLECT({");
      _builder_1.append(Neo4jConstants._N);
      _builder_1.append(":");
      _builder_1.append(Neo4jConstants._T);
      _builder_1.append(", ");
      _builder_1.append(Neo4jConstants._L);
      _builder_1.append(":");
      _builder_1.append(Neo4jConstants._R);
      _builder_1.append("}) AS ");
      _builder_1.append(Neo4jConstants._ATTRS);
      String query = _builder_1.toString();
      List<Record> result = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.READ);
      if (((result != null) && (!result.isEmpty()))) {
        Record rec = result.get(0);
        final List<Long> excluded = CollectionLiterals.<Long>newArrayList();
        Node redundancy = NodeUtil.asNode(result.get(0).get(Neo4jConstants._B));
        int _size = result.size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          for (final Record rc : result) {
            {
              Value ov = rc.get(Neo4jConstants._P).asPath().end().get(DictionaryConstants._ORDINAL);
              Node red = NodeUtil.asNode(rc.get(Neo4jConstants._B));
              if ((ov instanceof StringValue)) {
                int _parseInt = Integer.parseInt(((StringValue)ov).asString());
                boolean _equals = (_parseInt == 0);
                if (_equals) {
                  rec = rc;
                }
              } else {
                if ((ov instanceof NullValue)) {
                  rec = rc;
                }
              }
              if ((red instanceof Node)) {
                redundancy = red;
              }
              List<Object> _asList = rc.get(Neo4jConstants._ATTRS).asList();
              ArrayList<Object> pAttr = new ArrayList<Object>(_asList);
              for (final Object el : pAttr) {
                if ((el instanceof Map)) {
                  Object _get = ((Map)el).get(Neo4jConstants._L);
                  Relationship l = ((Relationship) _get);
                  boolean _equals_1 = l.type().equals(DictionaryConstants._EXCLUDED);
                  if (_equals_1) {
                    excluded.add(Long.valueOf(l.get(Neo4jConstants._ID).asLong()));
                  }
                }
              }
            }
          }
        }
        ArrayList<IRelationshipEL> _newArrayList = CollectionLiterals.<IRelationshipEL>newArrayList();
        Pair<String, ArrayList<IRelationshipEL>> _mappedTo_2 = Pair.<String, ArrayList<IRelationshipEL>>of(DictionaryConstants._INCLUDED, _newArrayList);
        ArrayList<IRelationshipEL> _newArrayList_1 = CollectionLiterals.<IRelationshipEL>newArrayList();
        Pair<String, ArrayList<IRelationshipEL>> _mappedTo_3 = Pair.<String, ArrayList<IRelationshipEL>>of(DictionaryConstants._LEFT_OVER, _newArrayList_1);
        Map<String, ArrayList<IRelationshipEL>> startMap = Collections.<String, ArrayList<IRelationshipEL>>unmodifiableMap(CollectionLiterals.<String, ArrayList<IRelationshipEL>>newHashMap(_mappedTo_2, _mappedTo_3));
        ArrayList<IRelationshipEL> _newArrayList_2 = CollectionLiterals.<IRelationshipEL>newArrayList();
        Pair<String, ArrayList<IRelationshipEL>> _mappedTo_4 = Pair.<String, ArrayList<IRelationshipEL>>of(DictionaryConstants._INCLUDED, _newArrayList_2);
        ArrayList<IRelationshipEL> _newArrayList_3 = CollectionLiterals.<IRelationshipEL>newArrayList();
        Pair<String, ArrayList<IRelationshipEL>> _mappedTo_5 = Pair.<String, ArrayList<IRelationshipEL>>of(DictionaryConstants._LEFT_OVER, _newArrayList_3);
        Map<String, ArrayList<IRelationshipEL>> endMap = Collections.<String, ArrayList<IRelationshipEL>>unmodifiableMap(CollectionLiterals.<String, ArrayList<IRelationshipEL>>newHashMap(_mappedTo_4, _mappedTo_5));
        List<Object> _asList = rec.get(Neo4jConstants._ATTRS).asList();
        ArrayList<Map> attRaw = new ArrayList<Map>(((List<Map>) ((Object) _asList)));
        final Function1<Map, Boolean> _function = (Map it) -> {
          boolean _xblockexpression_1 = false;
          {
            Object _get = it.get(Neo4jConstants._L);
            final Relationship rel = ((Relationship) _get);
            boolean _contains = excluded.contains(Long.valueOf(rel.id()));
            _xblockexpression_1 = (!_contains);
          }
          return Boolean.valueOf(_xblockexpression_1);
        };
        List<Map> att = IterableExtensions.<Map>toList(IterableExtensions.<Map>filter(((List<Map>) attRaw), _function));
        HashSet<Map> elms = CollectionLiterals.<Map>newHashSet();
        Set<String> _keySet = attrs.keySet();
        for (final String d : _keySet) {
          Collection<? extends IRelationshipEL> _get = attrs.get(d);
          for (final IRelationshipEL r : _get) {
            {
              final Function1<Node, Boolean> _function_1 = (Node n) -> {
                return Boolean.valueOf((Long.valueOf(n.id()).equals(Long.valueOf(r.getStart().getID())) || Long.valueOf(n.id()).equals(Long.valueOf(r.getEnd().getID()))));
              };
              final Function1<Node, Boolean> isNode = _function_1;
              final Function1<Map, Boolean> _function_2 = (Map it) -> {
                boolean _xblockexpression_1 = false;
                {
                  Object _get_1 = it.get(Neo4jConstants._L);
                  final Relationship rel = ((Relationship) _get_1);
                  boolean _and = false;
                  if (!((rel.type().equals(r.getRelationship().type()) && (isNode.apply(((Node) it.get(Neo4jConstants._N)))).booleanValue()) && rel.get(Neo4jConstants._SOURCE).asString().equals(d))) {
                    _and = false;
                  } else {
                    Value _get_2 = rel.get(NodeConstants._TYPE);
                    String _asString = null;
                    if (_get_2!=null) {
                      _asString=_get_2.asString();
                    }
                    Value _get_3 = r.getRelationship().get(NodeConstants._TYPE);
                    String _asString_1 = null;
                    if (_get_3!=null) {
                      _asString_1=_get_3.asString();
                    }
                    boolean _equals = _asString.equals(_asString_1);
                    _and = _equals;
                  }
                  _xblockexpression_1 = _and;
                }
                return Boolean.valueOf(_xblockexpression_1);
              };
              Iterable<Map> filRes = IterableExtensions.<Map>filter(((List<Map>) att), _function_2);
              int _size_1 = IterableExtensions.size(filRes);
              boolean _greaterThan_1 = (_size_1 > 0);
              if (_greaterThan_1) {
                for (final Map el : filRes) {
                  {
                    Object _get_1 = el.get(Neo4jConstants._L);
                    final String elS = ((Relationship) _get_1).get(Neo4jConstants._SOURCE).asString();
                    boolean _matched = false;
                    if (Objects.equals(elS, DictionaryConstants._END)) {
                      _matched=true;
                      endMap.get(DictionaryConstants._INCLUDED).add(r);
                    }
                    if (!_matched) {
                      if (Objects.equals(elS, DictionaryConstants._START)) {
                        _matched=true;
                        startMap.get(DictionaryConstants._INCLUDED).add(r);
                      }
                    }
                    elms.add(el);
                  }
                }
              } else {
                boolean _matched = false;
                if (Objects.equals(d, DictionaryConstants._END)) {
                  _matched=true;
                  endMap.get(DictionaryConstants._LEFT_OVER).add(r);
                }
                if (!_matched) {
                  if (Objects.equals(d, DictionaryConstants._START)) {
                    _matched=true;
                    startMap.get(DictionaryConstants._LEFT_OVER).add(r);
                  }
                }
              }
            }
          }
        }
        int crd = (-1);
        if ((redundancy != null)) {
          Value _get_1 = redundancy.get(DictionaryConstants._CARDINALITY);
          if ((_get_1 instanceof IntegerValue)) {
            crd = redundancy.get(DictionaryConstants._CARDINALITY).asInt();
          }
        }
        att.removeAll(elms);
        int _size_1 = att.size();
        boolean _equals = (_size_1 == 0);
        if (_equals) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("[DictionaryAccess.disableNode] Pattern already covered (trigger delete)");
          InputOutput.<String>println(_builder_2.toString());
          return null;
        }
        Value _get_2 = result.get(0).get(Neo4jConstants._P);
        Node patternN = ((PathValue) _get_2).asPath().end();
        Value ord = patternN.get(DictionaryConstants._ORDINAL);
        int ordinal = 0;
        if ((ord instanceof NullValue)) {
          ordinal = 0;
        } else {
          ordinal = ord.asInt();
        }
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("MATCH(");
        _builder_3.append(Neo4jConstants._N);
        _builder_3.append(") WHERE ID(");
        _builder_3.append(Neo4jConstants._N);
        _builder_3.append(") = ");
        long _id_1 = ((Node) patternN).id();
        _builder_3.append(_id_1);
        _builder_3.newLineIfNotEmpty();
        {
          ArrayList<IRelationshipEL> _get_3 = startMap.get(DictionaryConstants._LEFT_OVER);
          for(final IRelationshipEL r_1 : _get_3) {
            _builder_3.append("MATCH (");
            _builder_3.append(Neo4jConstants._T);
            long _id_2 = r_1.getRelationship().id();
            _builder_3.append(_id_2);
            _builder_3.append(") WHERE ID(");
            _builder_3.append(Neo4jConstants._T);
            long _id_3 = r_1.getRelationship().id();
            _builder_3.append(_id_3);
            _builder_3.append(") = ");
            long _id_4 = r_1.getEnd().getNode().id();
            _builder_3.append(_id_4);
            _builder_3.newLineIfNotEmpty();
          }
        }
        {
          ArrayList<IRelationshipEL> _get_4 = endMap.get(DictionaryConstants._LEFT_OVER);
          for(final IRelationshipEL r_2 : _get_4) {
            _builder_3.append("MATCH (");
            _builder_3.append(Neo4jConstants._T);
            long _id_5 = r_2.getRelationship().id();
            _builder_3.append(_id_5);
            _builder_3.append(") WHERE ID(");
            _builder_3.append(Neo4jConstants._T);
            long _id_6 = r_2.getRelationship().id();
            _builder_3.append(_id_6);
            _builder_3.append(") = ");
            long _id_7 = r_2.getEnd().getNode().id();
            _builder_3.append(_id_7);
            _builder_3.newLineIfNotEmpty();
          }
        }
        {
          for(final Map ex : elms) {
            _builder_3.append("MATCH (");
            _builder_3.append(Neo4jConstants._T);
            Object _get_5 = ex.get(Neo4jConstants._L);
            long _id_8 = ((Relationship) _get_5).id();
            _builder_3.append(_id_8);
            _builder_3.append(") WHERE ID(");
            _builder_3.append(Neo4jConstants._T);
            Object _get_6 = ex.get(Neo4jConstants._L);
            long _id_9 = ((Relationship) _get_6).id();
            _builder_3.append(_id_9);
            _builder_3.append(") = ");
            Object _get_7 = ex.get(Neo4jConstants._N);
            long _id_10 = ((Node) _get_7).id();
            _builder_3.append(_id_10);
            _builder_3.newLineIfNotEmpty();
          }
        }
        {
          for(final Map a : att) {
            _builder_3.append("MATCH (");
            _builder_3.append(Neo4jConstants._T);
            Object _get_8 = a.get(Neo4jConstants._L);
            long _id_11 = ((Relationship) _get_8).id();
            _builder_3.append(_id_11);
            _builder_3.append(") WHERE ID(");
            _builder_3.append(Neo4jConstants._T);
            Object _get_9 = a.get(Neo4jConstants._L);
            long _id_12 = ((Relationship) _get_9).id();
            _builder_3.append(_id_12);
            _builder_3.append(") = ");
            Object _get_10 = a.get(Neo4jConstants._N);
            long _id_13 = ((Node) _get_10).id();
            _builder_3.append(_id_13);
            _builder_3.newLineIfNotEmpty();
          }
        }
        {
          if ((cardinality > 0)) {
            _builder_3.append("MATCH ");
            _builder_3.append(Neo4jConstants._P);
            _builder_3.append(" = (");
            _builder_3.append(Neo4jConstants._N);
            _builder_3.append(")");
            CharSequence _generate_3 = new Arrow(null, ((NodeConstants.GRAMMAR_LINK_ + "|") + DictionaryConstants._EXCLUDES), null, null, null, true, Direction.LEFT).generate();
            _builder_3.append(_generate_3);
            _builder_3.append("(");
            _builder_3.append(Neo4jConstants._C);
            _builder_3.append(") WHERE ");
            _builder_3.append(Neo4jConstants._C);
            _builder_3.append(".");
            _builder_3.append(Neo4jConstants._NAME);
            _builder_3.append(" = \"");
            String _key = cardinalType.getKey();
            _builder_3.append(_key);
            _builder_3.append("\"");
            _builder_3.newLineIfNotEmpty();
          }
        }
        {
          if (((crd > 0) && (crd > cardinality))) {
            _builder_3.append("MATCH (");
            _builder_3.append(Neo4jConstants._D);
            _builder_3.append(":");
            _builder_3.append(DictionaryConstants._REDUNDANCE);
            _builder_3.append(") WHERE ID(");
            _builder_3.append(Neo4jConstants._D);
            _builder_3.append(") = ");
            long _id_14 = redundancy.id();
            _builder_3.append(_id_14);
            _builder_3.newLineIfNotEmpty();
          }
        }
        _builder_3.append("MERGE(");
        _builder_3.append(NodeConstants._W);
        _builder_3.append(": ");
        _builder_3.append(DictionaryConstants._PATTERN);
        _builder_3.append(" {");
        CharSequence _createProperties = this.createProperties(patternN);
        _builder_3.append(_createProperties);
        {
          Value _get_11 = patternN.get(DictionaryConstants._ORDINAL);
          if ((_get_11 instanceof NullValue)) {
            _builder_3.append(", ");
            _builder_3.append(DictionaryConstants._ORDINAL);
            _builder_3.append(": ");
            _builder_3.append((ordinal + 1));
          }
        }
        _builder_3.append("})");
        _builder_3.newLineIfNotEmpty();
        _builder_3.append("MERGE(");
        _builder_3.append(Neo4jConstants._N);
        _builder_3.append(")");
        CharSequence _generate_4 = new Arrow(Neo4jConstants._L, DictionaryConstants._EXCLUDES, Direction.RIGHT).generate();
        _builder_3.append(_generate_4);
        _builder_3.append("(");
        _builder_3.append(NodeConstants._W);
        _builder_3.append(") ");
        _builder_3.newLineIfNotEmpty();
        {
          ArrayList<IRelationshipEL> _get_12 = startMap.get(DictionaryConstants._LEFT_OVER);
          for(final IRelationshipEL r_3 : _get_12) {
            _builder_3.append("MERGE(");
            _builder_3.append(NodeConstants._W);
            _builder_3.append(")");
            long _id_15 = r_3.getRelationship().id();
            String _plus = (Neo4jConstants._L + Long.valueOf(_id_15));
            Pair<String, String> _mappedTo_6 = Pair.<String, String>of(Neo4jConstants._SOURCE, DictionaryConstants._START);
            long _id_16 = r_3.getRelationship().id();
            Pair<String, Long> _mappedTo_7 = Pair.<String, Long>of(Neo4jConstants._ID, Long.valueOf(_id_16));
            HashMap<String, Serializable> _filterMap = this.filterMap(this.mergeMap(r_3.getRelationship().asMap(), Collections.<String, Serializable>unmodifiableMap(CollectionLiterals.<String, Serializable>newHashMap(_mappedTo_6, _mappedTo_7))), this.filter);
            CharSequence _generate_5 = new Arrow(_plus, DictionaryConstants._LEFT_OVER, _filterMap, Direction.RIGHT).generate();
            _builder_3.append(_generate_5);
            _builder_3.append("(");
            _builder_3.append(Neo4jConstants._T);
            long _id_17 = r_3.getRelationship().id();
            _builder_3.append(_id_17);
            _builder_3.append(")  ");
            _builder_3.newLineIfNotEmpty();
          }
        }
        {
          ArrayList<IRelationshipEL> _get_13 = endMap.get(DictionaryConstants._LEFT_OVER);
          for(final IRelationshipEL r_4 : _get_13) {
            _builder_3.append("MERGE(");
            _builder_3.append(NodeConstants._W);
            _builder_3.append(")");
            long _id_18 = r_4.getRelationship().id();
            String _plus_1 = (Neo4jConstants._L + Long.valueOf(_id_18));
            Pair<String, String> _mappedTo_8 = Pair.<String, String>of(Neo4jConstants._SOURCE, DictionaryConstants._END);
            long _id_19 = r_4.getRelationship().id();
            Pair<String, Long> _mappedTo_9 = Pair.<String, Long>of(Neo4jConstants._ID, Long.valueOf(_id_19));
            HashMap<String, Serializable> _filterMap_1 = this.filterMap(this.mergeMap(r_4.getRelationship().asMap(), Collections.<String, Serializable>unmodifiableMap(CollectionLiterals.<String, Serializable>newHashMap(_mappedTo_8, _mappedTo_9))), this.filter);
            CharSequence _generate_6 = new Arrow(_plus_1, DictionaryConstants._LEFT_OVER, _filterMap_1, Direction.RIGHT).generate();
            _builder_3.append(_generate_6);
            _builder_3.append("(");
            _builder_3.append(Neo4jConstants._T);
            long _id_20 = r_4.getRelationship().id();
            _builder_3.append(_id_20);
            _builder_3.append(")");
            _builder_3.newLineIfNotEmpty();
          }
        }
        {
          for(final Map ex_1 : elms) {
            _builder_3.append("MERGE(");
            _builder_3.append(NodeConstants._W);
            _builder_3.append(")");
            Object _get_14 = ex_1.get(Neo4jConstants._L);
            long _id_21 = ((Relationship) _get_14).id();
            String _plus_2 = (Neo4jConstants._L + Long.valueOf(_id_21));
            Object _get_15 = ex_1.get(Neo4jConstants._L);
            Object _get_16 = ex_1.get(Neo4jConstants._L);
            long _id_22 = ((Relationship) _get_16).id();
            Pair<String, Long> _mappedTo_10 = Pair.<String, Long>of(Neo4jConstants._ID, Long.valueOf(_id_22));
            HashMap<String, Serializable> _filterMap_2 = this.filterMap(this.mergeMap(((Relationship) _get_15).asMap(), Collections.<String, Serializable>unmodifiableMap(CollectionLiterals.<String, Serializable>newHashMap(_mappedTo_10))), this.filter);
            CharSequence _generate_7 = new Arrow(_plus_2, DictionaryConstants._INCLUDED, _filterMap_2, Direction.RIGHT).generate();
            _builder_3.append(_generate_7);
            _builder_3.append("(");
            _builder_3.append(Neo4jConstants._T);
            Object _get_17 = ex_1.get(Neo4jConstants._L);
            long _id_23 = ((Relationship) _get_17).id();
            _builder_3.append(_id_23);
            _builder_3.append(")");
            _builder_3.newLineIfNotEmpty();
          }
        }
        {
          for(final Map a_1 : att) {
            _builder_3.append("MERGE(");
            _builder_3.append(NodeConstants._W);
            _builder_3.append(")");
            Object _get_18 = a_1.get(Neo4jConstants._L);
            long _id_24 = ((Relationship) _get_18).id();
            String _plus_3 = (Neo4jConstants._L + Long.valueOf(_id_24));
            Object _get_19 = a_1.get(Neo4jConstants._L);
            Object _get_20 = a_1.get(Neo4jConstants._L);
            long _id_25 = ((Relationship) _get_20).id();
            Pair<String, Long> _mappedTo_11 = Pair.<String, Long>of(Neo4jConstants._ID, Long.valueOf(_id_25));
            HashMap<String, Serializable> _filterMap_3 = this.filterMap(this.mergeMap(((Relationship) _get_19).asMap(), Collections.<String, Serializable>unmodifiableMap(CollectionLiterals.<String, Serializable>newHashMap(_mappedTo_11))), this.filter);
            CharSequence _generate_8 = new Arrow(_plus_3, DictionaryConstants._EXCLUDED, _filterMap_3, Direction.RIGHT).generate();
            _builder_3.append(_generate_8);
            _builder_3.append("(");
            _builder_3.append(Neo4jConstants._T);
            Object _get_21 = a_1.get(Neo4jConstants._L);
            long _id_26 = ((Relationship) _get_21).id();
            _builder_3.append(_id_26);
            _builder_3.append(")");
            _builder_3.newLineIfNotEmpty();
          }
        }
        CharSequence _createRedundance = this.createRedundance(crd, cardinality, cardinalType);
        _builder_3.append(_createRedundance);
        _builder_3.newLineIfNotEmpty();
        _builder_3.append("RETURN *");
        _builder_3.newLine();
        query = _builder_3.toString();
        InputOutput.<String>println(query);
        result = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.WRITE);
      } else {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append(sourceNode);
        {
          Set<String> _keySet_1 = attrs.keySet();
          for(final String d_1 : _keySet_1) {
            _builder_4.newLineIfNotEmpty();
            {
              Collection<? extends IRelationshipEL> _get_22 = attrs.get(d_1);
              for(final IRelationshipEL r_5 : _get_22) {
                _builder_4.append("MATCH(");
                _builder_4.append(Neo4jConstants._T);
                long _id_27 = r_5.getRelationship().id();
                _builder_4.append(_id_27);
                _builder_4.append(") WHERE ID(");
                _builder_4.append(Neo4jConstants._T);
                long _id_28 = r_5.getRelationship().id();
                _builder_4.append(_id_28);
                _builder_4.append(") = ");
                long _iD = r_5.getEnd().getID();
                _builder_4.append(_iD);
                _builder_4.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          if ((cardinality > 0)) {
            _builder_4.append("MATCH(");
            _builder_4.append(Neo4jConstants._N);
            _builder_4.append(")");
            CharSequence _generate_9 = new Arrow(null, NodeConstants.GRAMMAR_LINK_, null, null, null, true, Direction.LEFT).generate();
            _builder_4.append(_generate_9);
            _builder_4.append("(");
            _builder_4.append(Neo4jConstants._C);
            _builder_4.append(") WHERE ");
            _builder_4.append(Neo4jConstants._C);
            _builder_4.append(".");
            _builder_4.append(Neo4jConstants._NAME);
            _builder_4.append(" = \"");
            String _key_1 = cardinalType.getKey();
            _builder_4.append(_key_1);
            _builder_4.append("\"");
          }
        }
        _builder_4.newLineIfNotEmpty();
        _builder_4.append("MERGE(");
        _builder_4.append(NodeConstants._W);
        _builder_4.append(": ");
        _builder_4.append(DictionaryConstants._PATTERN);
        _builder_4.append(" {");
        CharSequence _createProperties_1 = this.createProperties(node);
        _builder_4.append(_createProperties_1);
        _builder_4.append(", ");
        _builder_4.append(DictionaryConstants._ORDINAL);
        _builder_4.append(": 0");
        {
          if ((cardinality > 0)) {
            _builder_4.append(", ");
            _builder_4.append(DictionaryConstants._CARDINALITY);
            _builder_4.append(": ");
            _builder_4.append(cardinality);
          }
        }
        _builder_4.append("})");
        _builder_4.newLineIfNotEmpty();
        _builder_4.append("MERGE(");
        _builder_4.append(Neo4jConstants._N);
        _builder_4.append(")");
        CharSequence _generate_10 = new Arrow(Neo4jConstants._L, DictionaryConstants._EXCLUDES, Direction.RIGHT).generate();
        _builder_4.append(_generate_10);
        _builder_4.append("(");
        _builder_4.append(NodeConstants._W);
        _builder_4.append(")");
        _builder_4.newLineIfNotEmpty();
        {
          Set<String> _keySet_2 = attrs.keySet();
          for(final String d_2 : _keySet_2) {
            {
              Collection<? extends IRelationshipEL> _get_23 = attrs.get(d_2);
              for(final IRelationshipEL r_6 : _get_23) {
                _builder_4.append("MERGE(");
                _builder_4.append(NodeConstants._W);
                _builder_4.append(")");
                String _type = r_6.getRelationship().type();
                Pair<String, String> _mappedTo_12 = Pair.<String, String>of(Neo4jConstants._SOURCE, d_2);
                HashMap<String, Serializable> _filterMap_4 = this.filterMap(this.mergeMap(r_6.getRelationship().asMap(), Collections.<String, Serializable>unmodifiableMap(CollectionLiterals.<String, Serializable>newHashMap(_mappedTo_12))), this.filter);
                CharSequence _generate_11 = new Arrow(null, _type, _filterMap_4, Direction.RIGHT).generate();
                _builder_4.append(_generate_11);
                _builder_4.append("(");
                _builder_4.append(Neo4jConstants._T);
                long _id_29 = r_6.getRelationship().id();
                _builder_4.append(_id_29);
                _builder_4.append(")");
                _builder_4.newLineIfNotEmpty();
              }
            }
          }
        }
        CharSequence _createRedundance_1 = this.createRedundance(0, cardinality, cardinalType);
        _builder_4.append(_createRedundance_1);
        _builder_4.newLineIfNotEmpty();
        _builder_4.append("RETURN *");
        query = _builder_4.toString();
        InputOutput.<String>print(query);
        result = this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.WRITE);
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  public CharSequence createRedundance(final int crd, final int cardinality, final XPair<String, ITypeAttributes> cardinalType) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((cardinality > 0)) {
        {
          if (((crd > 0) && (crd > cardinality))) {
            _builder.newLineIfNotEmpty();
            _builder.append("MERGE (");
            _builder.append(Neo4jConstants._F);
            _builder.append(":");
            _builder.append(DictionaryConstants._REDUNDANCE);
            _builder.append(" {");
            _builder.append(Neo4jConstants._NAME);
            _builder.append("\"");
            String _key = cardinalType.getKey();
            _builder.append(_key);
            _builder.append("\", ");
            _builder.append(DictionaryConstants._CARDINALITY);
            _builder.append(": ");
            _builder.append(cardinality);
            _builder.append("})");
            CharSequence _generate = new Arrow(null, DictionaryConstants._EXTENDS, Direction.RIGHT).generate();
            _builder.append(_generate);
            _builder.append("(");
            _builder.append(Neo4jConstants._D);
            _builder.append(")");
            _builder.newLineIfNotEmpty();
            _builder.append("MERGE (");
            _builder.append(Neo4jConstants._F);
            _builder.append(")");
            CharSequence _generate_1 = new Arrow(null, Neo4jConstants._OF_CLASS, Direction.RIGHT).generate();
            _builder.append(_generate_1);
            _builder.append("(");
            _builder.append(Neo4jConstants._C);
            _builder.append(")");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("MERGE (");
            _builder.append(Neo4jConstants._F);
            _builder.append(":");
            _builder.append(DictionaryConstants._REDUNDANCE);
            _builder.append(" {");
            _builder.append(Neo4jConstants._NAME);
            _builder.append(":\"");
            String _key_1 = cardinalType.getKey();
            _builder.append(_key_1);
            _builder.append("\", ");
            _builder.append(DictionaryConstants._CARDINALITY);
            _builder.append(": ");
            _builder.append(cardinality);
            _builder.append("})");
            CharSequence _generate_2 = new Arrow(null, Neo4jConstants._OF_CLASS, Direction.RIGHT).generate();
            _builder.append(_generate_2);
            _builder.append("(");
            _builder.append(Neo4jConstants._C);
            _builder.append(")");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("MERGE (");
        _builder.append(NodeConstants._W);
        _builder.append(")");
        CharSequence _generate_3 = new Arrow(null, DictionaryConstants._REDUNDANT, Direction.RIGHT).generate();
        _builder.append(_generate_3);
        _builder.append("(");
        _builder.append(Neo4jConstants._F);
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence createProperties(final Node node) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Set<String> _keySet = node.asMap().keySet();
      boolean _hasElements = false;
      for(final String key : _keySet) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        {
          boolean _equals = key.equals(DictionaryConstants._ORDINAL);
          if (_equals) {
            _builder.append(key);
            _builder.append(":");
            int _asInt = node.get(key).asInt();
            int _plus = (_asInt + 1);
            _builder.append(_plus);
          } else {
            _builder.append(key);
            _builder.append(":");
            Object _valueToNum = NodeUtil.valueToNum(node.get(key));
            _builder.append(_valueToNum);
          }
        }
      }
    }
    return _builder;
  }

  public HashMap<String, Serializable> filterMap(final Map<String, Serializable> map, final List<String> filterKeys) {
    HashMap<String, Serializable> _xblockexpression = null;
    {
      HashMap<String, Serializable> result = new HashMap<String, Serializable>(map);
      for (final String key : filterKeys) {
        boolean _containsKey = result.containsKey(key);
        if (_containsKey) {
          result.remove(key);
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  public Map<String, Serializable> mergeMap(final Map<?, ?> map, final Map<String, Serializable> map2) {
    Map<String, Serializable> _xblockexpression = null;
    {
      Map<String, Serializable> result = CollectionLiterals.<String, Serializable>newHashMap();
      result.putAll(((Map<String, String>) ((Object) map)));
      result.putAll(map2);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  @Override
  public List<Record> defineForwardType(final Record record, final Direction dir) {
    Node source = null;
    Node target = null;
    if (dir != null) {
      switch (dir) {
        case START:
          source = record.get(Neo4jConstants._SOURCE).asNode();
          target = record.get(Neo4jConstants._LINK).asNode();
          break;
        case END:
          source = record.get(Neo4jConstants._TARGET).asNode();
          target = record.get(Neo4jConstants._LINK).asNode();
          break;
        default:
          break;
      }
    } else {
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._S);
    _builder.append(") WHERE ID(");
    _builder.append(Neo4jConstants._S);
    _builder.append(") = ");
    long _id = source.id();
    _builder.append(_id);
    _builder.newLineIfNotEmpty();
    _builder.append("MATCH (");
    _builder.append(Neo4jConstants._T);
    _builder.append(") WHERE ID(");
    _builder.append(Neo4jConstants._T);
    _builder.append(") = ");
    long _id_1 = target.id();
    _builder.append(_id_1);
    _builder.append("\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("MERGE (");
    _builder.append(Neo4jConstants._S);
    _builder.append(")-[");
    _builder.append(Neo4jConstants._L);
    _builder.append(":");
    _builder.append(DictionaryConstants._FORWARD);
    _builder.append("]->(");
    _builder.append(Neo4jConstants._T);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("RETURN *");
    String query = _builder.toString();
    InputOutput.<String>print(query);
    return this.dbAccessor.runCodeRecords(query, Neo4jAccess.Action.WRITE);
  }
}
