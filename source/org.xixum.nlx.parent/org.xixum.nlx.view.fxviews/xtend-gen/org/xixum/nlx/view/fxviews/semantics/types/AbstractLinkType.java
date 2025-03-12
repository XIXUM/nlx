package org.xixum.nlx.view.fxviews.semantics.types;

import java.util.HashMap;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.xixum.nlx.constants.Direction;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeInfo;
import org.xixum.nlx.view.fxviews.semantics.ILink;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkType;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public abstract class AbstractLinkType implements ILinkType {
  protected String name;

  protected ILinkable _parent;

  @Override
  public void setParent(final ILinkable nodePanel) {
    this._parent = nodePanel;
  }

  @Override
  public String getNameClamped() {
    String _xifexpression = null;
    ILinkable _parent = this.getParent();
    if ((_parent instanceof ILink)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(");
      _builder.append(this.name);
      _builder.append(")");
      _xifexpression = _builder.toString();
    } else {
      _xifexpression = this.name;
    }
    return _xifexpression;
  }

  public void createAttributes(final ITypeAttributes dbAttrs) {
    throw new Error("Unresolved compilation problems:"
      + "\nVBox cannot be resolved to a type."
      + "\nTitledPane cannot be resolved to a type."
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field Platform is undefined"
      + "\nThe method getAttribVBox(Direction) is undefined for the type SmallPanelObjController"
      + "\nThe method getAccordion(Direction) is undefined for the type SmallPanelObjController"
      + "\nThe method clearAttribBox(Direction) from the type AbstractLinkType refers to the missing type Object"
      + "\nThe method clearAttribBox(Direction) from the type AbstractLinkType refers to the missing type Object"
      + "\nThe method createAttrEntry(VBox, Node, Node, Relationship) from the type AttribUtils refers to the missing type Object"
      + "\nisFxApplicationThread cannot be resolved"
      + "\n! cannot be resolved"
      + "\nrunLater cannot be resolved"
      + "\nvisible cannot be resolved"
      + "\n! cannot be resolved"
      + "\nvisible cannot be resolved");
  }

  public Object clearAttribBox(final Direction dir) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getAttribVBox(Direction) is undefined for the type SmallPanelObjController"
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
    return this._parent;
  }

  @Override
  public void newType() {
  }

  @Override
  public int getSelection() {
    return 0;
  }

  @Override
  public void setSelection(final int selection) {
  }

  @Override
  public HashMap<String, List<ILink>> getLinks() {
    return null;
  }

  @Override
  public List<ILink> getSelectedLink() {
    return null;
  }

  @Override
  public void postProcess(final ILinkObj precessor, final List<ITypeAttributes> attribs, final ImplicitRulesOnDict grammar) {
  }

  @Override
  public XPair<String, ITypeAttributes> getBaseType() {
    return null;
  }

  @Override
  public List<XPair<String, ITypeAttributes>> getTypeEls() {
    return null;
  }

  @Override
  public ITypeInfo getTypeInfo() {
    return null;
  }
}
