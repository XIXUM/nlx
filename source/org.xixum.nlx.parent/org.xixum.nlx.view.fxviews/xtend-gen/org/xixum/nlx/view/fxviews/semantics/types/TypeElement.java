package org.xixum.nlx.view.fxviews.semantics.types;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.xixum.nlx.dictionary.IDictionaryAccess;
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

@SuppressWarnings("all")
public class TypeElement implements /* AbstractAppendable */IJavaFxObj, ITypeElement {
  protected String typeName;

  protected ITypeAttributes typeAttributes;

  private LiteralType parent;

  protected /* LinkedList<? extends IAppendable> */Object container;

  private /* Node */Object root;

  private IElmController controller;

  private IDragController dragController;

  private /* FXMLLoader */Object loader;

  private int index;

  private /* HashMap<XPair<String, ILinkable>, ILink> */Object links;

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
      + "\nThe field TypeElement.links refers to the missing type XPair"
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
      + "\nThe method size() is undefined for the type Object"
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
      + "\n< cannot be resolved"
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
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from TypeElement to TypeElement");
  }

  public void removeLinks() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.links refers to the missing type XPair"
      + "\nThe field TypeElement.links refers to the missing type XPair"
      + "\nThe field TypeElement.links refers to the missing type XPair");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getOpposite(ILinkable) is undefined for the type ILink"
      + "\nThe method containsKeyPair(HashMap<XPair, ILink>, XPair) from the type TypeElement refers to the missing type XPair"
      + "\nThe field TypeElement.links refers to the missing type XPair"
      + "\nThe field TypeElement.links refers to the missing type XPair");
  }

  public boolean containsKeyPair(final /* HashMap<XPair<String, ILinkable>, ILink> */Object map, final /* XPair<String, ILinkable> */Object pair) {
    throw new Error("Unresolved compilation problems:"
      + "\nkey cannot be resolved"
      + "\nequals cannot be resolved"
      + "\nkey cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nequals cannot be resolved"
      + "\nvalue cannot be resolved");
  }

  public /* HashMap<XPair, ILink> */Object getLinks() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.links refers to the missing type XPair");
  }

  public List<ILink> getLink(final String name) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.links refers to the missing type XPair");
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
  public /* LinkedList<? extends IAppendable> */Object getContainer() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.container refers to the missing type LinkedList");
  }

  @Override
  public <E/*  extends IAppendable */> void setContainer(final /* LinkedList<E> */Object linkedList) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.container refers to the missing type LinkedList");
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
