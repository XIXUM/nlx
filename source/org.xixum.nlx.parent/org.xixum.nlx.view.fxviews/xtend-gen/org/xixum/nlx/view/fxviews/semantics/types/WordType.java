package org.xixum.nlx.view.fxviews.semantics.types;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.xixum.nlx.dictionary.DictItem;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.constants.NodeConstants;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeInfo;
import org.xixum.nlx.dictionary.type.NoneTypeAttributes;
import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.view.fxviews.semantics.ILink;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.semantics.constants.FxViewConstants;
import org.xixum.utils.data.lists.LinkedList;
import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public class WordType extends LiteralType {
  protected ITypeInfo typeInfo;

  protected /* Pane */Object group;

  protected LinkedList<TypeElement> elements;

  private int selection = 0;

  private final URL ressource = this.getClass().getResource(FxViewConstants.FXML_TYPE_CONTROL_FILE);

  private IDictionaryAccess dictAccess;

  public WordType(final ITypeInfo typeInfo, final ILinkable parent, final IDictionaryAccess dictAccess) {
    super(NodeConstants._WORD, parent);
    this.typeInfo = typeInfo;
    LinkedList<TypeElement> _linkedList = new LinkedList<TypeElement>();
    this.elements = _linkedList;
    this.dictAccess = dictAccess;
  }

  @Override
  public XPair<String, ITypeAttributes> getBaseType() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method generate() from the type WordType refers to the missing type Pane");
  }

  @Override
  public List<XPair<String, ITypeAttributes>> getTypeEls() {
    final Function1<TypeElement, XPair<String, ITypeAttributes>> _function = (TypeElement e) -> {
      return new XPair<String, ITypeAttributes>(e.typeName, e.typeAttributes);
    };
    return ListExtensions.<TypeElement, XPair<String, ITypeAttributes>>map(this.elements, _function);
  }

  @Override
  public ITypeInfo getTypeInfo() {
    return this.typeInfo;
  }

  @Override
  public Node getRoot() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field WordType.group refers to the missing type Pane"
      + "\nThe field WordType.group refers to the missing type Pane"
      + "\nThe method generate() from the type WordType refers to the missing type Pane"
      + "\nThe field WordType.group refers to the missing type Pane"
      + "\n=== cannot be resolved");
  }

  protected /* Pane */Object generate() {
    throw new Error("Unresolved compilation problems:"
      + "\nVBox cannot be resolved."
      + "\nThe field WordType.group refers to the missing type Pane"
      + "\nThe field WordType.group refers to the missing type Pane");
  }

  public boolean addType(final XPair<String, ITypeAttributes> type, final boolean withNone) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field Platform is undefined"
      + "\nThe method getRoot() from the type TypeElement refers to the missing type Node"
      + "\nThe field WordType.group refers to the missing type Pane"
      + "\nThe method getRoot() from the type TypeElement refers to the missing type Node"
      + "\nThe field WordType.group refers to the missing type Pane"
      + "\nThe method getRoot() from the type TypeElement refers to the missing type Node"
      + "\n!== cannot be resolved"
      + "\nfxApplicationThread cannot be resolved"
      + "\n! cannot be resolved"
      + "\nrunLater cannot be resolved"
      + "\ngetChildren cannot be resolved"
      + "\nadd cannot be resolved"
      + "\ngetChildren cannot be resolved"
      + "\nadd cannot be resolved");
  }

  @Override
  public void removeType(final TypeElement element) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field Platform is undefined"
      + "\nThe field WordType.group refers to the missing type Pane"
      + "\nThe method getRoot() from the type TypeElement refers to the missing type Node"
      + "\ngetChildren cannot be resolved"
      + "\nremove cannot be resolved"
      + "\nisFxApplicationThread cannot be resolved"
      + "\n! cannot be resolved"
      + "\nrunLater cannot be resolved");
  }

  @Override
  public void newType() {
    NoneTypeAttributes _noneTypeAttributes = new NoneTypeAttributes();
    XPair<String, ITypeAttributes> _xPair = new XPair<String, ITypeAttributes>(NodeConstants._NONE, _noneTypeAttributes);
    this.addType(_xPair, true);
    this.update();
  }

  @Override
  public void setSelection(final int selection) {
    int _size = this.elements.size();
    boolean _lessThan = (selection < _size);
    if (_lessThan) {
      this.selection = selection;
      this.update();
    }
  }

  @Override
  public void update() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field sphere is undefined for the type TypeControlElController"
      + "\nThe method or field sphere is undefined for the type TypeControlElController"
      + "\nThe method setDeleteVisible(boolean) from the type TypeElement refers to the missing type Object"
      + "\nisFxApplicationThread cannot be resolved"
      + "\n! cannot be resolved"
      + "\nrunLater cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\nvisible cannot be resolved");
  }

  @Override
  public int getSelection() {
    return this.selection;
  }

  @Override
  public HashMap<String, List<ILink>> getLinks() {
    HashMap<String, List<ILink>> _xblockexpression = null;
    {
      HashMap<String, List<ILink>> result = CollectionLiterals.<String, List<ILink>>newHashMap();
      for (final TypeElement type : this.elements) {
        {
          String name = type.getName();
          List<ILink> typeR = type.getLink(name);
          if ((typeR != null)) {
            result.put(name, typeR);
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  @Override
  public List<ILink> getSelectedLink() {
    List<ILink> _xifexpression = null;
    int _size = this.elements.size();
    boolean _lessThan = (this.selection < _size);
    if (_lessThan) {
      _xifexpression = IterableExtensions.<ILink>toList(this.elements.get(this.selection).getLinks().values());
    }
    return _xifexpression;
  }

  public void setLinkTo(final String typeName, final ILink link) {
    for (final TypeElement el : this.elements) {
      boolean _equals = el.getName().equals(typeName);
      if (_equals) {
        el.addLink(link);
      }
    }
  }

  public List<TypeElement> getAllTypes() {
    return this.elements;
  }

  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("NodeType: ");
    List<ILink> _selectedLink = this.getSelectedLink();
    _builder.append(_selectedLink);
    _builder.append(" Sel:");
    _builder.append(this.selection);
    return _builder.toString();
  }

  public void updateTypes(final HashMap<String, ITypeAttributes> map) {
    this.typeInfo.updateTypes(map);
    List<TypeElement> _allTypes = this.getAllTypes();
    for (final TypeElement type : _allTypes) {
      Set<String> _keySet = map.keySet();
      for (final String info : _keySet) {
        boolean _equals = info.equals(type.typeName);
        if (_equals) {
          type.setTypeAttributes(map.get(info));
        }
      }
    }
  }

  @Override
  public void postProcess(final ILinkObj precessor, final List<ITypeAttributes> attribs, final ImplicitRulesOnDict grammar) {
    ILinkable _parent = this.getParent();
    IItem token = ((ILinkObj) _parent).getToken();
    this.dictAccess.processPrefix(token.getName().toLowerCase(), attribs);
    this.dictAccess.processSuffix(token.getName().toLowerCase(), attribs);
    for (final TypeElement type : this.elements) {
      if (((type.getLinks() != null) && (!type.getLinks().isEmpty()))) {
        if (((precessor != null) && (this.selection == type.getIndex()))) {
          ArrayList<ITypeAttributes> intAttribs = new ArrayList<ITypeAttributes>(attribs);
          intAttribs.add(type.typeAttributes);
          IItem pT = precessor.getToken();
          ITypeInfo _typeInfo = pT.getInternalType().getTypeInfo();
          boolean _tripleNotEquals = (_typeInfo != null);
          if (_tripleNotEquals) {
            DictItem _generateTokenInfo = pT.generateTokenInfo();
            String _label = token.getLabel();
            String _name = token.getInternalType().getName();
            String _name_1 = type.getName();
            long _id = type.typeAttributes.getBaseNode().id();
            DictItem _dictItem = new DictItem(_label, _name, _name_1, _id);
            String _name_2 = type.getName();
            this.dictAccess.addSuccessor(_generateTokenInfo, _dictItem, Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(_name_2)), intAttribs);
            final HashMap<String, ITypeAttributes> map = CollectionLiterals.<String, ITypeAttributes>newHashMap();
            final Function1<XPair<String, ITypeAttributes>, Boolean> _function = (XPair<String, ITypeAttributes> v) -> {
              boolean _xblockexpression = false;
              {
                map.put(v.getKey(), v.getValue());
                _xblockexpression = true;
              }
              return Boolean.valueOf(_xblockexpression);
            };
            IterableExtensions.<XPair<String, ITypeAttributes>>forall(this.dictAccess.getLinkTypes(token.getName(), NodeConstants._WORD, true).getTypes(), _function);
            this.updateTypes(map);
          }
        }
      }
    }
  }
}
