package org.xixum.nlx.view.fxviews.semantics.types;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeInfo;
import org.xixum.nlx.view.fxviews.semantics.ILink;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.semantics.constants.FxViewConstants;

@SuppressWarnings("all")
public class WordType extends LiteralType {
  protected ITypeInfo typeInfo;

  protected /* Pane */Object group;

  protected /* LinkedList<TypeElement> */Object elements;

  private int selection = 0;

  private final URL ressource = this.getClass().getResource(FxViewConstants.FXML_TYPE_CONTROL_FILE);

  private IDictionaryAccess dictAccess;

  public WordType(final ITypeInfo typeInfo, final ILinkable parent, final IDictionaryAccess dictAccess) {
    throw new Error("Unresolved compilation problems:"
      + "\nLinkedList cannot be resolved."
      + "\nThe field WordType.elements refers to the missing type LinkedList");
  }

  @Override
  public XPair getBaseType() {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved."
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nThe method generate() from the type WordType refers to the missing type Pane"
      + "\nsize cannot be resolved"
      + "\nget cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n=== cannot be resolved");
  }

  @Override
  public Object getTypeEls() {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved."
      + "\nThe method or field typeName is undefined for the type Object"
      + "\nThe method or field typeAttributes is undefined for the type Object"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nmap cannot be resolved");
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
      + "\nThe method getTypes() from the type ITypeInfo refers to the missing type Object"
      + "\nThe method getTypes() from the type ITypeInfo refers to the missing type Object"
      + "\nThe method addType(XPair, boolean) from the type WordType refers to the missing type Object"
      + "\nThe field WordType.group refers to the missing type Pane");
  }

  public Object addType(final /* XPair<String, ITypeAttributes> */Object type, final boolean withNone) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field Platform is undefined"
      + "\nThe field root is not visible"
      + "\nThe field root is not visible"
      + "\nThe field root is not visible"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nThe field WordType.group refers to the missing type Pane"
      + "\nThe field WordType.group refers to the missing type Pane"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nkey cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nsize cannot be resolved"
      + "\nfxApplicationThread cannot be resolved"
      + "\n! cannot be resolved"
      + "\nrunLater cannot be resolved"
      + "\ngetChildren cannot be resolved"
      + "\nadd cannot be resolved"
      + "\ngetChildren cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nadd cannot be resolved");
  }

  @Override
  public void removeType(final TypeElement element) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field Platform is undefined"
      + "\nThe field root is not visible"
      + "\nThe field WordType.group refers to the missing type Pane"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\ngetChildren cannot be resolved"
      + "\nremove cannot be resolved"
      + "\nisFxApplicationThread cannot be resolved"
      + "\n! cannot be resolved"
      + "\nrunLater cannot be resolved"
      + "\nremove cannot be resolved"
      + "\nremove cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n> cannot be resolved"
      + "\n- cannot be resolved");
  }

  @Override
  public void newType() {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved."
      + "\nThe method addType(XPair, boolean) from the type WordType refers to the missing type Object");
  }

  @Override
  public void setSelection(final int selection) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nsize cannot be resolved");
  }

  @Override
  public void update() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field sphere is undefined for the type TypeControlElController"
      + "\nThe method or field sphere is undefined for the type TypeControlElController"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nisFxApplicationThread cannot be resolved"
      + "\n! cannot be resolved"
      + "\nrunLater cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\nindex cannot be resolved"
      + "\ncontroller cannot be resolved"
      + "\ncontroller cannot be resolved"
      + "\ngetTypeAttributes cannot be resolved"
      + "\nsize cannot be resolved"
      + "\n> cannot be resolved"
      + "\ndeleteVisible cannot be resolved");
  }

  @Override
  public int getSelection() {
    return this.selection;
  }

  @Override
  public HashMap<String, List<ILink>> getLinks() {
    throw new Error("Unresolved compilation problems:"
      + "\nType mismatch: cannot convert from HashMap<Object, Object> to HashMap<String, List<ILink>>"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nname cannot be resolved"
      + "\ngetLink cannot be resolved"
      + "\n!== cannot be resolved");
  }

  @Override
  public List<ILink> getSelectedLink() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nsize cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlinks cannot be resolved"
      + "\nvalues cannot be resolved"
      + "\ntoList cannot be resolved");
  }

  public void setLinkTo(final String typeName, final ILink link) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nname cannot be resolved"
      + "\nequals cannot be resolved"
      + "\naddLink cannot be resolved");
  }

  public List<TypeElement> getAllTypes() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field WordType.elements refers to the missing type LinkedList");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe field WordType.elements refers to the missing type LinkedList"
      + "\nThe method getTypes() from the type ITypeInfo refers to the missing type Object"
      + "\nlinks cannot be resolved"
      + "\n!== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nlinks cannot be resolved"
      + "\nempty cannot be resolved"
      + "\n! cannot be resolved"
      + "\nindex cannot be resolved"
      + "\ntypeAttributes cannot be resolved"
      + "\nname cannot be resolved"
      + "\ntypeAttributes cannot be resolved"
      + "\nbaseNode cannot be resolved"
      + "\nid cannot be resolved"
      + "\nname cannot be resolved"
      + "\nkey cannot be resolved"
      + "\nvalue cannot be resolved");
  }
}
