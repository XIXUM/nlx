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
import org.xixum.nlx.view.fxviews.semantics.util.IDelegates;

@SuppressWarnings("all")
public class TypeElement implements /* AbstractAppendable, IJavaFxObj */ITypeElement {
  protected String typeName;

  protected ITypeAttributes typeAttributes;

  private LiteralType parent;

  protected /* LinkedList<? extends IAppendable> */Object container;

  private /* Node */Object root;

  private /* IElmController */Object controller;

  private /* IDragController */Object dragController;

  private /* FXMLLoader */Object loader;

  private int index;

  private /* HashMap<XPair<String, ILinkable>, ILink> */Object links;

  private IDictionaryAccess dictAccess;

  protected /* ChangeListener<? super String> */Object listener;

  private boolean withNone;

  private /* Map<ComboBox<String>, ChangeListener<? super String>> */Object listeners;

  private /* IDelegates.Procedure2<IJavaFxObj, Event> */Object plusButton /* Skipped initializer because of errors */;

  private /* IDelegates.Procedure2<IJavaFxObj, Event> */Object deleteButton = ((IDelegates.Procedure2<Object, Object>) (Object parent, Object event) -> {
    this.deleteTypeInDict(this.typeName);
  });

  public TypeElement(final String name, final ITypeAttributes attributes, final int index, final LiteralType parent, final URL ressource) {
    this(name, attributes, index, parent, ressource, false);
  }

  public TypeElement(final String name, final ITypeAttributes attributes, final int index, final LiteralType parent, final URL ressource, final boolean withNone) {
    throw new Error("Unresolved compilation problems:"
      + "\nILinkObj cannot be resolved to a type."
      + "\nShortCutItem cannot be resolved to a type."
      + "\nFXMLLoader cannot be resolved."
      + "\nThe field TypeElement.loader refers to the missing type FXMLLoader"
      + "\nThe field TypeElement.loader refers to the missing type FXMLLoader"
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\nThe field TypeElement.listeners refers to the missing type ComboBox"
      + "\nThe field TypeElement.links refers to the missing type XPair"
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\nsetClassLoader cannot be resolved"
      + "\ncanvas cannot be resolved"
      + "\nfxClassLoader cannot be resolved"
      + "\ntoken cannot be resolved"
      + "\ndictAccess cannot be resolved");
  }

  public Object create() {
    throw new Error("Unresolved compilation problems:"
      + "\nTypeControlElController cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nThe method size() is undefined for the type Object"
      + "\nThe field TypeElement.root refers to the missing type Node"
      + "\nThe field TypeElement.loader refers to the missing type FXMLLoader"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.loader refers to the missing type FXMLLoader"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.plusButton refers to the missing type IJavaFxObj"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.deleteButton refers to the missing type IJavaFxObj"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.dragController refers to the missing type IDragController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\nload cannot be resolved"
      + "\ngetController cannot be resolved"
      + "\nsecondRow cannot be resolved"
      + "\nmanagedProperty cannot be resolved"
      + "\nbind cannot be resolved"
      + "\nsecondRow cannot be resolved"
      + "\nvisibleProperty cannot be resolved"
      + "\ndeleteContainer cannot be resolved"
      + "\nmanagedProperty cannot be resolved"
      + "\nbind cannot be resolved"
      + "\ndeleteContainer cannot be resolved"
      + "\nvisibleProperty cannot be resolved"
      + "\ntoken cannot be resolved"
      + "\nwordTypes cannot be resolved"
      + "\n?: cannot be resolved"
      + "\nsphere cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\nsphere cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\n< cannot be resolved"
      + "\ndeleteContainer cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\ndeleteContainer cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\naddListener cannot be resolved"
      + "\naddListener cannot be resolved"
      + "\naddDragController cannot be resolved"
      + "\nsetParent cannot be resolved"
      + "\ntoken cannot be resolved"
      + "\nname cannot be resolved");
  }

  public void addItems(final List<ITypeHierarchy> types) {
    throw new Error("Unresolved compilation problems:"
      + "\nTypeControlElController cannot be resolved to a type."
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe method setSelectionChangedListener(ComboBox, ChangeListener) from the type TypeElement refers to the missing type ComboBox"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nmainCombo cannot be resolved"
      + "\nitems cannot be resolved"
      + "\n+= cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nsecondRow cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\nmainCombo cannot be resolved");
  }

  public Object setDeleteVisible(final boolean visibility) {
    throw new Error("Unresolved compilation problems:"
      + "\nTypeControlElController cannot be resolved to a type."
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field Platform is undefined"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
      + "\nisFxApplicationThread cannot be resolved"
      + "\n! cannot be resolved"
      + "\nrunLater cannot be resolved"
      + "\ndeleteContainer cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\ndeleteContainer cannot be resolved"
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
      + "\nILinkObj cannot be resolved to a type."
      + "\nShortCutItem cannot be resolved to a type."
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\ntoken cannot be resolved"
      + "\nname cannot be resolved");
  }

  public void removeLinks() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.links refers to the missing type XPair"
      + "\nThe field TypeElement.links refers to the missing type XPair"
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\nThe field TypeElement.links refers to the missing type XPair"
      + "\ndetach cannot be resolved");
  }

  public void replaceTypeInDict(final String oldType, final String newType) {
    throw new Error("Unresolved compilation problems:"
      + "\nILinkObj cannot be resolved to a type."
      + "\nShortCutItem cannot be resolved to a type."
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\ntoken cannot be resolved"
      + "\nname cannot be resolved");
  }

  public ITypeAttributes addTypeToDict(final String type) {
    throw new Error("Unresolved compilation problems:"
      + "\nILinkObj cannot be resolved to a type."
      + "\nShortCutItem cannot be resolved to a type."
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\ntoken cannot be resolved"
      + "\nname cannot be resolved");
  }

  public Node getRoot() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.root refers to the missing type Node");
  }

  @Override
  public LiteralType getParent() {
    return this.parent;
  }

  @Override
  public IElmController getController() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.controller refers to the missing type IElmController");
  }

  @Override
  public Object getCanvasController() {
    throw new Error("Unresolved compilation problems:"
      + "\nILinkable cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\ncanvasController cannot be resolved");
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

  public ILink addLink(final /* ILink */Object link) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\nThe method containsKeyPair(HashMap<XPair, ILink>, XPair) from the type TypeElement refers to the missing type XPair"
      + "\nThe field TypeElement.links refers to the missing type XPair"
      + "\nThe field TypeElement.links refers to the missing type XPair"
      + "\ngetOpposite cannot be resolved");
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

  public /* List<ILink> */Object getLink(final String name) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeElement.links refers to the missing type XPair");
  }

  public void setSelectionChangedListener(final /* ComboBox<String> */Object combo, final /* ChangeListener<? super String> */Object listener) {
    throw new Error("Unresolved compilation problems:"
      + "\nTypeControlElController cannot be resolved to a type."
      + "\nThe field TypeElement.controller refers to the missing type IElmController"
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
