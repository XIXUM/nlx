package de.validas.nlx.view.fxviews.semantics.types;

import de.validas.nlx.dictionary.DictItem;
import de.validas.nlx.dictionary.IDictionaryAccess;
import de.validas.nlx.dictionary.constants.NodeConstants;
import de.validas.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.dictionary.type.ITypeInfo;
import de.validas.nlx.dictionary.type.NoneTypeAttributes;
import de.validas.nlx.view.fxviews.access.IItem;
import de.validas.nlx.view.fxviews.control.IController;
import de.validas.nlx.view.fxviews.control.TypeControlElController;
import de.validas.nlx.view.fxviews.semantics.ILink;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.semantics.constants.FxViewConstants;
import de.validas.nlx.view.fxviews.semantics.types.LiteralType;
import de.validas.nlx.view.fxviews.semantics.types.TypeElement;
import de.validas.utils.data.lists.LinkedList;
import de.validas.utils.data.types.XPair;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Sphere;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class WordType extends LiteralType {
  protected ITypeInfo typeInfo;
  
  protected Pane group;
  
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
    Object _xblockexpression = null;
    {
      TypeElement el = null;
      int _size = this.elements.size();
      boolean _lessThan = (this.selection < _size);
      if (_lessThan) {
        el = this.elements.get(this.selection);
      } else {
        int _size_1 = this.elements.size();
        boolean _tripleEquals = (_size_1 == 0);
        if (_tripleEquals) {
          ITypeInfo res = this.dictAccess.getLinkTypes(((ILinkObj) this._parent).getToken().getName(), NodeConstants._WORD, true);
          if ((res != null)) {
            this.typeInfo = res;
            this.generate();
          }
        } else {
          return null;
        }
      }
      if ((el != null)) {
        String _name = el.getName();
        ITypeAttributes _typeAttributes = el.getTypeAttributes();
        return new XPair<String, ITypeAttributes>(_name, _typeAttributes);
      }
      _xblockexpression = null;
    }
    return ((XPair<String, ITypeAttributes>)_xblockexpression);
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
    Pane _xblockexpression = null;
    {
      if ((this.group == null)) {
        this.group = this.generate();
      }
      this.update();
      _xblockexpression = this.group;
    }
    return _xblockexpression;
  }
  
  protected Pane generate() {
    Pane _xblockexpression = null;
    {
      VBox _vBox = new VBox();
      this.group = _vBox;
      List<XPair<String, ITypeAttributes>> _types = null;
      if (this.typeInfo!=null) {
        _types=this.typeInfo.getTypes();
      }
      boolean _tripleNotEquals = (_types != null);
      if (_tripleNotEquals) {
        List<XPair<String, ITypeAttributes>> _types_1 = this.typeInfo.getTypes();
        for (final XPair<String, ITypeAttributes> type : _types_1) {
          this.addType(type, false);
        }
      }
      _xblockexpression = this.group;
    }
    return _xblockexpression;
  }
  
  public boolean addType(final XPair<String, ITypeAttributes> type, final boolean withNone) {
    boolean _xblockexpression = false;
    {
      String _key = type.getKey();
      ITypeAttributes _value = type.getValue();
      int _size = this.elements.size();
      final TypeElement el = new TypeElement(_key, _value, _size, this, this.ressource, withNone);
      el.create();
      Node _root = el.getRoot();
      boolean _tripleNotEquals = (_root != null);
      if (_tripleNotEquals) {
        boolean _isFxApplicationThread = Platform.isFxApplicationThread();
        boolean _not = (!_isFxApplicationThread);
        if (_not) {
          final Runnable _function = () -> {
            this.group.getChildren().add(el.getRoot());
          };
          Platform.runLater(_function);
        } else {
          this.group.getChildren().add(el.getRoot());
        }
      }
      _xblockexpression = this.elements.add(el);
    }
    return _xblockexpression;
  }
  
  @Override
  public void removeType(final TypeElement element) {
    this.group.getChildren().remove(element.getRoot());
    boolean _isFxApplicationThread = Platform.isFxApplicationThread();
    boolean _not = (!_isFxApplicationThread);
    if (_not) {
      final Runnable _function = () -> {
        this.elements.remove(element);
      };
      Platform.runLater(_function);
    } else {
      this.elements.remove(element);
    }
    final int numEls = this.elements.size();
    if (((this.selection >= numEls) && (numEls > 0))) {
      this.selection = (numEls - 1);
    } else {
      this.selection = 0;
    }
    this.update();
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
    final Procedure2<TypeControlElController, Boolean> _function = (TypeControlElController ctr, Boolean vis) -> {
      boolean _isFxApplicationThread = Platform.isFxApplicationThread();
      boolean _not = (!_isFxApplicationThread);
      if (_not) {
        final Runnable _function_1 = () -> {
          Sphere _sphere = ctr.getSphere();
          _sphere.setVisible(vis);
        };
        Platform.runLater(_function_1);
      } else {
        Sphere _sphere = ctr.getSphere();
        _sphere.setVisible(vis);
      }
    };
    final Procedure2<TypeControlElController, Boolean> visibilityDelegate = _function;
    for (final TypeElement el : this.elements) {
      {
        int _index = el.getIndex();
        boolean _notEquals = (this.selection != _index);
        if (_notEquals) {
          IController _controller = el.getController();
          visibilityDelegate.apply(((TypeControlElController) _controller), Boolean.valueOf(false));
        } else {
          IController _controller_1 = el.getController();
          visibilityDelegate.apply(((TypeControlElController) _controller_1), Boolean.valueOf(true));
          this.createAttributes(el.getTypeAttributes());
        }
        boolean visibility = false;
        int _size = this.elements.size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          visibility = true;
        } else {
          visibility = false;
        }
        for (final TypeElement ctrl : this.elements) {
          ctrl.setDeleteVisible(visibility);
        }
      }
    }
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
