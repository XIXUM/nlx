package org.xixum.nlx.view.fxviews.semantics.types;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.constants.NodeConstants;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeHierarchy;
import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.view.fxviews.access.IJavaFxObj;
import org.xixum.nlx.view.fxviews.access.elements.ShortCutItem;
import org.xixum.nlx.view.fxviews.control.ICanvasController;
import org.xixum.nlx.view.fxviews.control.IController;
import org.xixum.nlx.view.fxviews.control.IDragController;
import org.xixum.nlx.view.fxviews.control.IElmController;
import org.xixum.nlx.view.fxviews.semantics.ILink;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.semantics.util.IDelegates;
import org.xixum.utils.data.lists.AbstractAppendable;
import org.xixum.utils.data.lists.IAppendable;
import org.xixum.utils.data.lists.LinkedList;
import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public class TypeElement extends AbstractAppendable implements IJavaFxObj, ITypeElement {
  protected String typeName;

  protected ITypeAttributes typeAttributes;

  private LiteralType parent;

  protected LinkedList<? extends IAppendable> container;

  private /* Node */Object root;

  private IElmController controller;

  private IDragController dragController;

  private /* FXMLLoader */Object loader;

  private int index;

  private HashMap<XPair<String, ILinkable>, ILink> links;

  private IDictionaryAccess dictAccess;

  protected /* ChangeListener<? super String> */Object listener;

  private boolean withNone;

  private /* Map<ComboBox<String>, ChangeListener<? super String>> */Object listeners;

  private /* IDelegates.Procedure2<IJavaFxObj, Event> */Object plusButton = ((IDelegates.Procedure2<IJavaFxObj, Object>) (IJavaFxObj parent, Object event) -> {
    Object wordT = parent.getParent();
    if ((wordT instanceof WordType)) {
      ((WordType)wordT).setSelection(this.index);
      ((WordType)wordT).getParent().getCanvas().getLinkListener().update();
    }
  });

  private /* IDelegates.Procedure2<IJavaFxObj, Event> */Object deleteButton = ((IDelegates.Procedure2<IJavaFxObj, Object>) (IJavaFxObj parent, Object event) -> {
    this.deleteTypeInDict(this.typeName);
  });

  public TypeElement(final String name, final ITypeAttributes attributes, final int index, final LiteralType parent, final URL ressource) {
    this(name, attributes, index, parent, ressource, false);
  }

  public TypeElement(final String name, final ITypeAttributes attributes, final int index, final LiteralType parent, final URL ressource, final boolean withNone) {
    throw new Error("Unresolved compilation problems:"
      + "\nFXMLLoader cannot be resolved."
      + "\nThe field TypeElement.loader refers to the missing type FXMLLoader"
      + "\nThe field TypeElement.loader refers to the missing type FXMLLoader"
      + "\nThe field TypeElement.listeners refers to the missing type ComboBox"
      + "\nsetClassLoader cannot be resolved");
  }

  public void create() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field secondRow is undefined for the type TypeControlElController"
      + "\nThe method or field secondRow is undefined for the type TypeControlElController"
      + "\nThe method or field deleteContainer is undefined for the type TypeControlElController"
      + "\nThe method or field deleteContainer is undefined for the type TypeControlElController"
      + "\nThe method or field sphere is undefined for the type TypeControlElController"
      + "\nThe method or field sphere is undefined for the type TypeControlElController"
      + "\nThe method or field deleteContainer is undefined for the type TypeControlElController"
      + "\nThe method or field deleteContainer is undefined for the type TypeControlElController"
      + "\nThe method addListener(String, Procedure2<IJavaFxObj, Event>) is undefined for the type TypeControlElController"
      + "\nThe method addListener(String, Procedure2<IJavaFxObj, Event>) is undefined for the type TypeControlElController"
      + "\nThe field TypeElement.root refers to the missing type Node"
      + "\nThe field TypeElement.loader refers to the missing type FXMLLoader"
      + "\nThe field TypeElement.loader refers to the missing type FXMLLoader"
      + "\nThe field TypeElement.plusButton refers to the missing type Event"
      + "\nThe field TypeElement.deleteButton refers to the missing type Event"
      + "\nload cannot be resolved"
      + "\ngetController cannot be resolved"
      + "\nmanagedProperty cannot be resolved"
      + "\nbind cannot be resolved"
      + "\nvisibleProperty cannot be resolved"
      + "\nmanagedProperty cannot be resolved"
      + "\nbind cannot be resolved"
      + "\nvisibleProperty cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\nvisible cannot be resolved");
  }

  public void addItems(final List<ITypeHierarchy> types) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field mainCombo is undefined for the type TypeControlElController"
      + "\nThe method or field secondRow is undefined for the type TypeControlElController"
      + "\nThe method or field mainCombo is undefined for the type TypeControlElController"
      + "\nThe method setSelectionChangedListener(ComboBox, ChangeListener) from the type TypeElement refers to the missing type ComboBox"
      + "\nitems cannot be resolved"
      + "\n+= cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nvisible cannot be resolved");
  }

  public Object setDeleteVisible(final boolean visibility) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field deleteContainer is undefined for the type TypeControlElController"
      + "\nThe method or field deleteContainer is undefined for the type TypeControlElController"
      + "\nisFxApplicationThread cannot be resolved"
      + "\n! cannot be resolved"
      + "\nrunLater cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\nvisible cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.root refers to the missing type Node");
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

  public void setSelectionChangedListener(final /* ComboBox<String> */Object combo, final /* ChangeListener<? super String> */Object listener) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.listeners refers to the missing type ComboBox"
      + "\n!== cannot be resolved"
      + "\nvalueProperty cannot be resolved"
      + "\naddListener cannot be resolved");
  }

  public /* ChangeListener<? super String> */Object getSelectionChangedListener() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.listener refers to the missing type ChangeListener");
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
