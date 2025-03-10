package org.xixum.nlx.view.fxviews.semantics.types;

import java.util.HashMap;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.xixum.nlx.constants.Direction;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.type.ITypeAttributes;

@SuppressWarnings("all")
public abstract class AbstractLinkType /* implements ILinkType  */{
  protected String name;

  protected /* ILinkable */Object _parent;

  @Override
  public ILinkable setParent(final /* ILinkable */Object nodePanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractLinkType._parent refers to the missing type ILinkable");
  }

  @Override
  public CharSequence getNameClamped() {
    throw new Error("Unresolved compilation problems:"
      + "\nILink cannot be resolved to a type."
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable");
  }

  public void createAttributes(final ITypeAttributes dbAttrs) {
    throw new Error("Unresolved compilation problems:"
      + "\nIJavaFxObj cannot be resolved to a type."
      + "\nSmallPanelObjController cannot be resolved to a type."
      + "\nVBox cannot be resolved to a type."
      + "\nTitledPane cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field Platform is undefined"
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\nThe method clearAttribBox(Direction) from the type AbstractLinkType refers to the missing type Object"
      + "\nThe method clearAttribBox(Direction) from the type AbstractLinkType refers to the missing type Object"
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\nThe method createAttrEntry(Object, Node, Node, Relationship) from the type AttribUtils refers to the missing type Object"
      + "\ncontroller cannot be resolved"
      + "\nisFxApplicationThread cannot be resolved"
      + "\n! cannot be resolved"
      + "\nrunLater cannot be resolved"
      + "\ngetAttribVBox cannot be resolved"
      + "\ngetAccordion cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\n! cannot be resolved"
      + "\nvisible cannot be resolved");
  }

  public Object clearAttribBox(final Direction dir) {
    throw new Error("Unresolved compilation problems:"
      + "\nIJavaFxObj cannot be resolved to a type."
      + "\nSmallPanelObjController cannot be resolved to a type."
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\ncontroller cannot be resolved"
      + "\ngetAttribVBox cannot be resolved"
      + "\nchildren cannot be resolved"
      + "\nclear cannot be resolved");
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AbstractLinkType: ");
    _builder.append(this.name);
    return _builder.toString();
  }

  @Override
  public ILinkable getParent() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractLinkType._parent refers to the missing type ILinkable");
  }

  @Override
  public void newType() {
  }

  @Override
  public int getSelection() {
    return 0;
  }

  @Override
  public Object setSelection(final int selection) {
    return null;
  }

  @Override
  public /* HashMap<String, List<ILink>> */Object getLinks() {
    return null;
  }

  @Override
  public /* List<ILink> */Object getSelectedLink() {
    return null;
  }

  @Override
  public Object postProcess(final /* ILinkObj */Object precessor, final List<ITypeAttributes> attribs, final ImplicitRulesOnDict grammar) {
    return null;
  }

  @Override
  public Object getBaseType() {
    return null;
  }

  @Override
  public Object getTypeEls() {
    return null;
  }

  @Override
  public Object getTypeInfo() {
    return null;
  }
}
