package de.validas.nlx.view.fxviews.semantics.types;

import com.google.common.collect.Iterables;
import de.validas.nlx.dictionary.IDictionaryAccess;
import de.validas.nlx.dictionary.constants.NodeConstants;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.dictionary.type.ITypeHierarchy;
import de.validas.nlx.dictionary.type.NoneTypeHierarchy;
import de.validas.nlx.view.fxviews.access.IItem;
import de.validas.nlx.view.fxviews.access.IJavaFxObj;
import de.validas.nlx.view.fxviews.access.elements.ShortCutItem;
import de.validas.nlx.view.fxviews.control.ICanvasController;
import de.validas.nlx.view.fxviews.control.IController;
import de.validas.nlx.view.fxviews.control.IDragController;
import de.validas.nlx.view.fxviews.control.IElmController;
import de.validas.nlx.view.fxviews.control.TypeControlElController;
import de.validas.nlx.view.fxviews.semantics.ILink;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.semantics.constants.FxViewConstants;
import de.validas.nlx.view.fxviews.semantics.types.ITypeElement;
import de.validas.nlx.view.fxviews.semantics.types.LiteralType;
import de.validas.nlx.view.fxviews.semantics.types.WordType;
import de.validas.nlx.view.fxviews.semantics.util.IDelegates;
import de.validas.utils.data.lists.AbstractAppendable;
import de.validas.utils.data.lists.IAppendable;
import de.validas.utils.data.lists.LinkedList;
import de.validas.utils.data.types.XPair;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Sphere;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class TypeElement extends AbstractAppendable implements IJavaFxObj, ITypeElement {
  protected String typeName;
  
  protected ITypeAttributes typeAttributes;
  
  private LiteralType parent;
  
  protected LinkedList<? extends IAppendable> container;
  
  private Node root;
  
  private IElmController controller;
  
  private IDragController dragController;
  
  private FXMLLoader loader;
  
  private int index;
  
  private HashMap<XPair<String, ILinkable>, ILink> links;
  
  private IDictionaryAccess dictAccess;
  
  protected ChangeListener<? super String> listener;
  
  private boolean withNone;
  
  private Map<ComboBox<String>, ChangeListener<? super String>> listeners;
  
  private IDelegates.Procedure2<IJavaFxObj, Event> plusButton = ((IDelegates.Procedure2<IJavaFxObj, Event>) (IJavaFxObj parent, Event event) -> {
    Object wordT = parent.getParent();
    if ((wordT instanceof WordType)) {
      ((WordType)wordT).setSelection(this.index);
      ((WordType)wordT).getParent().getCanvas().getLinkListener().update();
    }
  });
  
  private IDelegates.Procedure2<IJavaFxObj, Event> deleteButton = ((IDelegates.Procedure2<IJavaFxObj, Event>) (IJavaFxObj parent, Event event) -> {
    this.deleteTypeInDict(this.typeName);
  });
  
  public TypeElement(final String name, final ITypeAttributes attributes, final int index, final LiteralType parent, final URL ressource) {
    this(name, attributes, index, parent, ressource, false);
  }
  
  public TypeElement(final String name, final ITypeAttributes attributes, final int index, final LiteralType parent, final URL ressource, final boolean withNone) {
    this.parent = parent;
    FXMLLoader _fXMLLoader = new FXMLLoader(ressource);
    this.loader = _fXMLLoader;
    this.loader.setClassLoader(parent.getParent().getCanvas().getFxClassLoader());
    this.listeners = CollectionLiterals.<ComboBox<String>, ChangeListener<? super String>>newHashMap();
    this.typeName = name;
    this.typeAttributes = attributes;
    this.index = index;
    this.withNone = withNone;
    this.links = CollectionLiterals.<XPair<String, ILinkable>, ILink>newHashMap();
    ILinkable _parent = parent.getParent();
    IItem _token = ((ILinkObj) _parent).getToken();
    this.dictAccess = ((ShortCutItem) _token).getDictAccess();
  }
  
  public void create() {
    try {
      this.root = this.loader.<Node>load();
      this.controller = this.loader.<IElmController>getController();
      if ((this.controller instanceof TypeControlElController)) {
        ((TypeControlElController)this.controller).getSecondRow().managedProperty().bind(((TypeControlElController)this.controller).getSecondRow().visibleProperty());
        ((TypeControlElController)this.controller).getDeleteContainer().managedProperty().bind(((TypeControlElController)this.controller).getDeleteContainer().visibleProperty());
        Collection<? extends ITypeHierarchy> _elvis = null;
        ILinkable _parent = null;
        if (this.parent!=null) {
          _parent=this.parent.getParent();
        }
        IItem _token = null;
        if (((ILinkObj) _parent)!=null) {
          _token=((ILinkObj) _parent).getToken();
        }
        Collection<? extends ITypeHierarchy> _wordTypes = null;
        if (_token!=null) {
          _wordTypes=_token.getWordTypes();
        }
        if (_wordTypes != null) {
          _elvis = _wordTypes;
        } else {
          _elvis = Collections.<ITypeHierarchy>unmodifiableList(CollectionLiterals.<ITypeHierarchy>newArrayList());
        }
        ArrayList<ITypeHierarchy> items = new ArrayList<ITypeHierarchy>(_elvis);
        if (this.withNone) {
          NoneTypeHierarchy _noneTypeHierarchy = new NoneTypeHierarchy();
          items.add(0, _noneTypeHierarchy);
        }
        this.addItems(items);
        int _selection = this.parent.getSelection();
        boolean _notEquals = (_selection != this.index);
        if (_notEquals) {
          Sphere _sphere = ((TypeControlElController)this.controller).getSphere();
          _sphere.setVisible(false);
        } else {
          Sphere _sphere_1 = ((TypeControlElController)this.controller).getSphere();
          _sphere_1.setVisible(true);
        }
        int _size = this.parent.getTypeEls().size();
        boolean _lessThan = (_size < 1);
        if (_lessThan) {
          AnchorPane _deleteContainer = ((TypeControlElController)this.controller).getDeleteContainer();
          _deleteContainer.setVisible(false);
        } else {
          AnchorPane _deleteContainer_1 = ((TypeControlElController)this.controller).getDeleteContainer();
          _deleteContainer_1.setVisible(true);
        }
        ((TypeControlElController)this.controller).addListener(FxViewConstants._CIRCLE_BUTTON, this.plusButton);
        ((TypeControlElController)this.controller).addListener(FxViewConstants._DELETE_BUTTON, this.deleteButton);
      }
      this.controller.addDragController(this.dragController);
      this.controller.setParent(this);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        ILinkable _parent_1 = this.parent.getParent();
        InputOutput.<String>print(((ILinkObj) _parent_1).getToken().getName());
        ex.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void addItems(final List<ITypeHierarchy> types) {
    if ((this.controller instanceof TypeControlElController)) {
      ComboBox<String> combo = ((TypeControlElController)this.controller).getMainCombo();
      if ((this.typeName != null)) {
        ObservableList<String> _items = combo.getItems();
        final Function1<ITypeHierarchy, String> _function = (ITypeHierarchy t) -> {
          return t.getType();
        };
        List<String> _map = ListExtensions.<ITypeHierarchy, String>map(types, _function);
        Iterables.<String>addAll(_items, _map);
        combo.setValue(this.typeName);
        HBox _secondRow = ((TypeControlElController)this.controller).getSecondRow();
        _secondRow.setVisible(false);
      }
      final ChangeListener<String> _function_1 = (ObservableValue<? extends String> obs, String oldValue, String newValue) -> {
        if ((newValue != null)) {
          boolean _equals = oldValue.equals(NodeConstants._NONE);
          if (_equals) {
            this.addTypeToDict(newValue);
          } else {
            boolean _alreadyExist = this.alreadyExist(newValue);
            if (_alreadyExist) {
              this.deleteTypeInDict(oldValue);
            } else {
              this.replaceTypeInDict(oldValue, newValue);
            }
          }
        }
        this.typeName = newValue;
      };
      this.setSelectionChangedListener(((TypeControlElController)this.controller).getMainCombo(), _function_1);
    }
  }
  
  public void setDeleteVisible(final boolean visibility) {
    if ((this.controller instanceof TypeControlElController)) {
      boolean _isFxApplicationThread = Platform.isFxApplicationThread();
      boolean _not = (!_isFxApplicationThread);
      if (_not) {
        final Runnable _function = () -> {
          AnchorPane _deleteContainer = ((TypeControlElController)this.controller).getDeleteContainer();
          _deleteContainer.setVisible(visibility);
        };
        Platform.runLater(_function);
      } else {
        AnchorPane _deleteContainer = ((TypeControlElController)this.controller).getDeleteContainer();
        _deleteContainer.setVisible(visibility);
      }
    }
  }
  
  public boolean alreadyExist(final String string) {
    boolean _xblockexpression = false;
    {
      if ((this.parent instanceof WordType)) {
        final Function1<TypeElement, String> _function = (TypeElement e) -> {
          return e.getName();
        };
        final List<String> keys = ListExtensions.<TypeElement, String>map(((WordType)this.parent).getAllTypes(), _function);
        return keys.contains(string);
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public void deleteTypeInDict(final String type) {
    ILinkable _parent = this.parent.getParent();
    IItem _token = ((ILinkObj) _parent).getToken();
    String name = ((ShortCutItem) _token).getName();
    boolean _equals = type.equals(NodeConstants._NONE);
    boolean _not = (!_equals);
    if (_not) {
      this.dictAccess.deleteTypeToWord(name, type);
    }
    this.removeLinks();
    this.parent.removeType(this);
  }
  
  public void removeLinks() {
    ArrayList<XPair<String, ILinkable>> removes = CollectionLiterals.<XPair<String, ILinkable>>newArrayList();
    Set<XPair<String, ILinkable>> _keySet = this.links.keySet();
    for (final XPair<String, ILinkable> key : _keySet) {
      boolean _detach = this.links.get(key).detach(this.parent.getParent());
      if (_detach) {
        removes.add(key);
      }
    }
    for (final XPair<String, ILinkable> e : removes) {
      this.links.remove(e);
    }
  }
  
  public void replaceTypeInDict(final String oldType, final String newType) {
    ILinkable _parent = this.parent.getParent();
    IItem _token = ((ILinkObj) _parent).getToken();
    String name = ((ShortCutItem) _token).getName();
    this.typeAttributes = this.dictAccess.replaceTypeForWord(name, oldType, newType);
    this.removeLinks();
  }
  
  public ITypeAttributes addTypeToDict(final String type) {
    ITypeAttributes _xblockexpression = null;
    {
      ILinkable _parent = this.parent.getParent();
      IItem _token = ((ILinkObj) _parent).getToken();
      String name = ((ShortCutItem) _token).getName();
      _xblockexpression = this.typeAttributes = this.dictAccess.addTypeToWord(name, type);
    }
    return _xblockexpression;
  }
  
  public Node getRoot() {
    return this.root;
  }
  
  @Override
  public Object getParent() {
    return this.parent;
  }
  
  @Override
  public IController getController() {
    return this.controller;
  }
  
  @Override
  public ICanvasController getCanvasController() {
    ICanvasController _xblockexpression = null;
    {
      ILinkable panel = this.parent.getParent();
      ICanvasController _xifexpression = null;
      if ((panel instanceof ILinkObj)) {
        _xifexpression = ((ILinkObj)panel).getCanvasController();
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String getName() {
    return this.typeName;
  }
  
  /**
   * @Deprecated: use getName()
   */
  @Deprecated
  public String getBaseType() {
    return this.typeName;
  }
  
  public ILink addLink(final ILink link) {
    ILink _xblockexpression = null;
    {
      ILinkable source = this.parent.getParent();
      XPair<String, ILinkable> target = link.getOpposite(source);
      ILink _xifexpression = null;
      boolean _containsKeyPair = this.containsKeyPair(this.links, target);
      boolean _not = (!_containsKeyPair);
      if (_not) {
        _xifexpression = this.links.put(target, link);
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean containsKeyPair(final HashMap<XPair<String, ILinkable>, ILink> map, final XPair<String, ILinkable> pair) {
    boolean _xblockexpression = false;
    {
      Set<XPair<String, ILinkable>> _keySet = map.keySet();
      for (final XPair<String, ILinkable> pairEl : _keySet) {
        if ((pairEl.getKey().equals(pair.getKey()) && pairEl.getValue().equals(pair.getValue()))) {
          return true;
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public HashMap<XPair<String, ILinkable>, ILink> getLinks() {
    return this.links;
  }
  
  public List<ILink> getLink(final String name) {
    List<ILink> _xifexpression = null;
    boolean _equals = name.equals(this.typeName);
    if (_equals) {
      _xifexpression = IterableExtensions.<ILink>toList(this.links.values());
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public void setSelectionChangedListener(final ComboBox<String> combo, final ChangeListener<? super String> listener) {
    if ((this.controller instanceof TypeControlElController)) {
      if ((listener != null)) {
        combo.valueProperty().addListener(listener);
        this.listeners.put(combo, listener);
      }
    }
  }
  
  public ChangeListener<? super String> getSelectionChangedListener() {
    return this.listener;
  }
  
  @Override
  public ITypeAttributes getTypeAttributes() {
    return this.typeAttributes;
  }
  
  @Override
  public void setTypeAttributes(final ITypeAttributes attrs) {
    this.typeAttributes = attrs;
  }
  
  @Override
  public LinkedList<? extends IAppendable> getContainer() {
    return this.container;
  }
  
  @Override
  public <E extends IAppendable> void setContainer(final LinkedList<E> linkedList) {
    this.container = linkedList;
  }
  
  @Override
  public int getIndex() {
    return this.index;
  }
  
  @Override
  public void setIndex(final int i) {
    this.index = i;
  }
}
