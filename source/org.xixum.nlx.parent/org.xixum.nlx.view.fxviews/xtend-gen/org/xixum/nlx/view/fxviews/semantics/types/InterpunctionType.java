package org.xixum.nlx.view.fxviews.semantics.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.ai.IDbAccess;
import org.xixum.nlx.ai.neo4j.Neo4jAccess;
import org.xixum.nlx.ai.util.Arrow;
import org.xixum.nlx.ai.util.NodeUtil;
import org.xixum.nlx.constants.Direction;
import org.xixum.nlx.constants.Neo4jConstants;
import org.xixum.nlx.constants.TokenPosition;
import org.xixum.nlx.dictionary.DictItem;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.constants.DictionaryConstants;
import org.xixum.nlx.dictionary.constants.NodeConstants;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.grammar.token.IGrammarInterpunction;
import org.xixum.nlx.dictionary.grammar.types.IGrammarType;
import org.xixum.nlx.dictionary.grammar.types.ItemType;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeInfo;
import org.xixum.nlx.naturalLang.BracketSentence;
import org.xixum.nlx.naturalLang.ExtBracketSentence;
import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.view.fxviews.access.elements.TerminalItem;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.semantics.constants.SubClassType;
import org.xixum.utils.data.types.XPair;
import org.xixum.utils.data.util.StringUtils;

@SuppressWarnings("all")
public class InterpunctionType extends AbstractLinkType implements IGrammarInterpunction {
  protected SubClassType subClass;

  protected String type;

  private ItemType cathegory;

  private IDictionaryAccess dictAccess;

  private Node node;

  private ITypeAttributes attrs;

  public InterpunctionType(final EObject el, final ItemType type, final IDictionaryAccess dictAccess) {
    this(el, type, null, dictAccess);
  }

  public InterpunctionType(final EObject el, final ItemType cathegory, final String separator, final IDictionaryAccess dictAccess) {
    this.cathegory = cathegory;
    this.name = NodeConstants._INTERPUNCTION;
    if ((separator != null)) {
      final String clean = separator.replaceAll("\\s", "");
      boolean _isEmpty = clean.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        this.type = clean;
      } else {
        this.type = StringUtils.special_escape(separator);
      }
    }
    if ((el instanceof ExtBracketSentence)) {
      this.subClass = SubClassType.EXT_BRACKET_SENTENCE;
    } else {
      if ((el instanceof BracketSentence)) {
        this.subClass = SubClassType.BRACKET_SENTENCE;
      } else {
        this.subClass = SubClassType.INTERPUNCTION;
      }
    }
    this.dictAccess = dictAccess;
  }

  @Override
  public void setParent(final ILinkable nodePanel) {
    this._parent = nodePanel;
    IDbAccess _dbAccessor = this.dictAccess.getDbAccessor();
    boolean _tripleNotEquals = (_dbAccessor != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("MATCH(");
      _builder.append(Neo4jConstants._N);
      _builder.append(":");
      _builder.append(NodeConstants._INTERPUNCTION);
      _builder.append(" {");
      _builder.append(Neo4jConstants._NAME);
      _builder.append(":\"");
      _builder.append(this.cathegory);
      _builder.append("\"");
      {
        if ((this.type != null)) {
          _builder.append(", ");
          _builder.append(NodeConstants._TYPE);
          _builder.append(":\"");
          _builder.append(this.type);
          _builder.append("\"");
        }
      }
      _builder.append("})");
      CharSequence _generate = new Arrow(Neo4jConstants._L, DictionaryConstants._AT, null).generate();
      _builder.append(_generate);
      _builder.append("(");
      _builder.append(Neo4jConstants._A);
      _builder.append(":");
      _builder.append(DictionaryConstants._POSITION);
      _builder.append(" {");
      _builder.append(Neo4jConstants._NAME);
      _builder.append(":\"");
      IItem _token = ((ILinkObj) this._parent).getToken();
      String _name = ((TerminalItem) _token).getPosition().name();
      _builder.append(_name);
      _builder.append("\"})");
      _builder.newLineIfNotEmpty();
      {
        if ((this.type != null)) {
          _builder.append("MATCH(");
          _builder.append(Neo4jConstants._N);
          _builder.append(")");
          CharSequence _generate_1 = new Arrow(Neo4jConstants._L2, DictionaryConstants._OF_TYPE, null).generate();
          _builder.append(_generate_1);
          _builder.append("(");
          _builder.append(Neo4jConstants._B);
          _builder.append(":");
          _builder.append(DictionaryConstants._CHAR);
          _builder.append(" {");
          _builder.append(Neo4jConstants._NAME);
          _builder.append(":\"");
          _builder.append(this.type);
          _builder.append("\"})");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("RETURN *");
      String query = _builder.toString();
      List<Record> result = this.dictAccess.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.READ);
      this.node = NodeUtil.getFirstRecord(result, Neo4jConstants._N);
      if (((result == null) || result.isEmpty())) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("MERGE (");
        _builder_1.append(Neo4jConstants._N);
        _builder_1.append(":");
        _builder_1.append(NodeConstants._INTERPUNCTION);
        _builder_1.append(" {");
        _builder_1.append(Neo4jConstants._NAME);
        _builder_1.append(":\"");
        _builder_1.append(this.cathegory);
        _builder_1.append("\"");
        {
          if ((this.type != null)) {
            _builder_1.append(", ");
            _builder_1.append(NodeConstants._TYPE);
            _builder_1.append(":\"");
            _builder_1.append(this.type);
            _builder_1.append("\"");
          }
        }
        _builder_1.append("})");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("MERGE (");
        _builder_1.append(Neo4jConstants._A);
        _builder_1.append(":");
        _builder_1.append(DictionaryConstants._POSITION);
        _builder_1.append(" {");
        _builder_1.append(Neo4jConstants._NAME);
        _builder_1.append(":\"");
        IItem _token_1 = ((ILinkObj) this._parent).getToken();
        String _name_1 = ((TerminalItem) _token_1).getPosition().name();
        _builder_1.append(_name_1);
        _builder_1.append("\"})");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("MERGE (");
        _builder_1.append(Neo4jConstants._C);
        _builder_1.append(":");
        _builder_1.append(Neo4jConstants._CLASS);
        _builder_1.append(" {");
        _builder_1.append(Neo4jConstants._NAME);
        _builder_1.append(":\"");
        _builder_1.append(NodeConstants._INTERPUNCTION);
        _builder_1.append("\"})");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("MERGE (");
        _builder_1.append(Neo4jConstants._N);
        _builder_1.append(")");
        CharSequence _generate_2 = new Arrow(Neo4jConstants._LL, Neo4jConstants._OF_CLASS, Direction.RIGHT).generate();
        _builder_1.append(_generate_2);
        _builder_1.append("(");
        _builder_1.append(Neo4jConstants._C);
        _builder_1.append(")");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("MERGE (");
        _builder_1.append(Neo4jConstants._N);
        _builder_1.append(")");
        CharSequence _generate_3 = new Arrow(Neo4jConstants._L, DictionaryConstants._AT, Direction.RIGHT).generate();
        _builder_1.append(_generate_3);
        _builder_1.append("(");
        _builder_1.append(Neo4jConstants._A);
        _builder_1.append(")");
        _builder_1.newLineIfNotEmpty();
        {
          if ((this.type != null)) {
            _builder_1.append("MERGE (");
            _builder_1.append(Neo4jConstants._B);
            _builder_1.append(":");
            _builder_1.append(DictionaryConstants._CHAR);
            _builder_1.append(" {");
            _builder_1.append(Neo4jConstants._NAME);
            _builder_1.append(":\"");
            _builder_1.append(this.type);
            _builder_1.append("\"})");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("MERGE (");
            _builder_1.append(Neo4jConstants._N);
            _builder_1.append(")");
            CharSequence _generate_4 = new Arrow(Neo4jConstants._L2, DictionaryConstants._OF_TYPE, Direction.RIGHT).generate();
            _builder_1.append(_generate_4);
            _builder_1.append("(");
            _builder_1.append(Neo4jConstants._B);
            _builder_1.append(")");
            _builder_1.newLineIfNotEmpty();
          }
        }
        _builder_1.append("RETURN *");
        query = _builder_1.toString();
        InputOutput.<String>println((query + "\n"));
        this.node = NodeUtil.getFirstRecord(this.dictAccess.getDbAccessor().runCodeRecords(query, Neo4jAccess.Action.WRITE), Neo4jConstants._N);
      }
    }
  }

  public SubClassType getSubClass() {
    return this.subClass;
  }

  @Override
  public XPair<String, ITypeAttributes> getBaseType() {
    return new XPair<String, ITypeAttributes>(this.type, null);
  }

  @Override
  public ItemType getCathegory() {
    return this.cathegory;
  }

  public String generate(final String attr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(attr);
    _builder.append(":\"");
    _builder.append(this.cathegory);
    _builder.append("\"");
    {
      if ((this.type != null)) {
        _builder.append(", ");
        _builder.append(attr);
        _builder.append("Type:\"");
        _builder.append(this.type);
        _builder.append("\"");
      }
    }
    return _builder.toString();
  }

  public void update() {
    boolean _isConnected = this.dictAccess.isConnected();
    if (_isConnected) {
      ITypeInfo info = this.dictAccess.getLinkTypes(this.cathegory.toString(), NodeConstants._INTERPUNCTION, true);
      if ((info != null)) {
        List<XPair<String, ITypeAttributes>> _types = info.getTypes();
        for (final XPair<String, ITypeAttributes> typ : _types) {
          {
            boolean _equals = typ.getKey().equals(this.cathegory.toString());
            if (_equals) {
              this.createAttributes(typ.getValue());
            }
            if ((this.attrs == null)) {
              this.attrs = typ.getValue();
            } else {
              this.attrs.merge(typ.getValue());
            }
          }
        }
      }
    }
  }

  @Override
  public Node getNode() {
    return this.node;
  }

  @Override
  public void postProcess(final ILinkObj precessor, final List<ITypeAttributes> attribs, final ImplicitRulesOnDict grammar) {
    ILinkable _parent = this.getParent();
    IItem token = ((ILinkObj) _parent).getToken();
    if ((this.type != null)) {
      if ((precessor != null)) {
        ArrayList<ITypeAttributes> intAttribs = new ArrayList<ITypeAttributes>(attribs);
        intAttribs.add(this.attrs);
        IItem pT = precessor.getToken();
        IGrammarType _internalType = pT.getInternalType();
        ITypeInfo _typeInfo = null;
        if (_internalType!=null) {
          _typeInfo=_internalType.getTypeInfo();
        }
        boolean _tripleEquals = (_typeInfo == null);
        if (_tripleEquals) {
          return;
        }
        TokenPosition pos = ((TerminalItem) token).getPosition();
        if (pos != null) {
          switch (pos) {
            case INTERMEDIATE:
              DictItem _generateTokenInfo = pT.generateTokenInfo();
              String _name = this.cathegory.name();
              long _xifexpression = (long) 0;
              if ((this.node != null)) {
                _xifexpression = this.node.id();
              } else {
                _xifexpression = (-1);
              }
              DictItem _dictItem = new DictItem(_name, this.name, _xifexpression);
              String _name_1 = this.cathegory.name();
              this.dictAccess.addSuccessor(_generateTokenInfo, _dictItem, Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(_name_1)), intAttribs);
              break;
            case START:
            case END:
              DictItem _generateTokenInfo_1 = pT.generateTokenInfo();
              String _string = pos.toString();
              long _id = this.node.id();
              DictItem _dictItem_1 = new DictItem(_string, this.name, _id);
              String _name_2 = this.cathegory.name();
              this.dictAccess.addSuccessor(_generateTokenInfo_1, _dictItem_1, Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(_name_2)), intAttribs);
              break;
            default:
              break;
          }
        }
      }
    }
  }
}
