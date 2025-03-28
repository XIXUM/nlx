package org.xixum.nlx.dictionary.type;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.xixum.nlx.dictionary.constants.AttributeSet;
import org.xixum.nlx.dictionary.constants.DictionaryConstants;
import org.xixum.nlx.dictionary.type.elements.INetworkEL;
import org.xixum.nlx.dictionary.type.elements.INodeEL;
import org.xixum.nlx.dictionary.type.elements.IRelationshipEL;

@SuppressWarnings("all")
public class LinkTypeAttribute implements ITypeAttributes {
  private Map<String, ITypeAttributes> parent;

  private /* Node */Object linkBase;

  public LinkTypeAttribute(final /* Node */Object linkNode, final ITypeAttributes source, final ITypeAttributes target) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LinkTypeAttribute.linkBase refers to the missing type Node");
  }

  @Override
  public Object getBaseNode() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LinkTypeAttribute.linkBase refers to the missing type Node");
  }

  public ITypeAttributes getParent(final AttributeSet set) {
    ITypeAttributes _switchResult = null;
    if (set != null) {
      switch (set) {
        case ALL:
          _switchResult = this.merge4Link();
          break;
        case START:
          _switchResult = this.parent.get(DictionaryConstants._START);
          break;
        case END:
          _switchResult = this.parent.get(DictionaryConstants._END);
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    return _switchResult;
  }

  public Object getAttrs(final AttributeSet set) {
    Object _switchResult = null;
    if (set != null) {
      switch (set) {
        case ALL:
          _switchResult = this.merge4Link().getAttrs();
          break;
        case START:
          _switchResult = this.parent.get(DictionaryConstants._START).getAttrs();
          break;
        case END:
          _switchResult = this.parent.get(DictionaryConstants._END).getAttrs();
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    return _switchResult;
  }

  public ITypeAttributes merge4Link() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor TypeAttributes(Object, ITypeAttributes, ITypeAttributes) refers to the missing type Object"
      + "\nThe field LinkTypeAttribute.linkBase refers to the missing type Node");
  }

  /**
   * @param mactchTarget: also target tye must match
   * @param includeBoth: include matches from start and end although they are partially redundant
   */
  public ITypeAttributes intersection(final /* Node */Object basenode, final boolean matchTarget, final boolean includeBoth) {
    throw new Error("Unresolved compilation problems:"
      + "\nNode cannot be resolved to a type."
      + "\nThe method getRelationship() from the type IRelationshipEL refers to the missing type Object"
      + "\nThe method getRelationship() from the type IRelationshipEL refers to the missing type Object"
      + "\nThe method getNode() from the type INodeEL refers to the missing type Object"
      + "\nThe method getNode() from the type INodeEL refers to the missing type Object"
      + "\nThe method getBaseNode() from the type LinkTypeAttribute refers to the missing type Object"
      + "\nThe field LinkTypeAttribute.linkBase refers to the missing type Node"
      + "\nThe constructor TypeAttributes(Object, Set<IRelationshipEL>, Set<INodeEL>, Set<INodeEL>) refers to the missing type Object"
      + "\ntype cannot be resolved"
      + "\nequals cannot be resolved"
      + "\ntype cannot be resolved"
      + "\nequals cannot be resolved"
      + "\n&& cannot be resolved"
      + "\n!== cannot be resolved");
  }

  @Override
  public Object getAttrs() {
    return this.getAttrs(AttributeSet.ALL);
  }

  @Override
  public /* List<Object> */Object getSource() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getSource(AttributeSet) from the type LinkTypeAttribute refers to the missing type Object");
  }

  public /* List<Object> */Object getSource(final AttributeSet set) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getSource() from the type ITypeAttributes refers to the missing type Object"
      + "\nThe method getSource() from the type ITypeAttributes refers to the missing type Object"
      + "\nThe method getSource() from the type ITypeAttributes refers to the missing type Object");
  }

  @Override
  public /* List<Object> */Object getTarget() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getTarget(AttributeSet) from the type LinkTypeAttribute refers to the missing type Object");
  }

  public /* List<Object> */Object getTarget(final AttributeSet set) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getTarget() from the type ITypeAttributes refers to the missing type Object"
      + "\nThe method getTarget() from the type ITypeAttributes refers to the missing type Object"
      + "\nThe method getTarget() from the type ITypeAttributes refers to the missing type Object");
  }

  @Override
  public void merge(final ITypeAttributes attributes) {
  }

  public XHashSet<INetworkEL> mergeELs(final Collection<? extends INetworkEL> els, final Collection<? extends INetworkEL> els2) {
    XHashSet<INetworkEL> _xblockexpression = null;
    {
      XHashSet<INetworkEL> result = new XHashSet<INetworkEL>(els);
      result.addAll(els2);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  @Override
  public Collection<? extends INodeEL> getSourceEL() {
    return this.getSourceEL(AttributeSet.ALL);
  }

  public Collection<? extends INodeEL> getSourceEL(final AttributeSet set) {
    Collection<? extends INodeEL> _switchResult = null;
    if (set != null) {
      switch (set) {
        case ALL:
          XHashSet<INetworkEL> _mergeELs = this.mergeELs(this.parent.get(DictionaryConstants._START).getSourceEL(), this.parent.get(DictionaryConstants._END).getSourceEL());
          _switchResult = ((Collection<? extends INodeEL>) _mergeELs);
          break;
        case START:
          _switchResult = this.parent.get(DictionaryConstants._START).getSourceEL();
          break;
        case END:
          _switchResult = this.parent.get(DictionaryConstants._END).getSourceEL();
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    return _switchResult;
  }

  @Override
  public Collection<? extends INodeEL> getTargetEL() {
    return this.getTargetEL(AttributeSet.ALL);
  }

  public Collection<? extends INodeEL> getTargetEL(final AttributeSet set) {
    Collection<? extends INodeEL> _switchResult = null;
    if (set != null) {
      switch (set) {
        case ALL:
          XHashSet<INetworkEL> _mergeELs = this.mergeELs(this.parent.get(DictionaryConstants._START).getTargetEL(), this.parent.get(DictionaryConstants._END).getTargetEL());
          _switchResult = ((Collection<? extends INodeEL>) _mergeELs);
          break;
        case START:
          _switchResult = this.parent.get(DictionaryConstants._START).getTargetEL();
          break;
        case END:
          _switchResult = this.parent.get(DictionaryConstants._END).getTargetEL();
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    return _switchResult;
  }

  @Override
  public Collection<? extends IRelationshipEL> getAttrsEL() {
    return this.getAttrsEL(AttributeSet.ALL);
  }

  public Collection<? extends IRelationshipEL> getAttrsEL(final AttributeSet set) {
    Collection<? extends IRelationshipEL> _switchResult = null;
    if (set != null) {
      switch (set) {
        case ALL:
          XHashSet<INetworkEL> _mergeELs = this.mergeELs(this.parent.get(DictionaryConstants._START).getAttrsEL(), this.parent.get(DictionaryConstants._END).getAttrsEL());
          _switchResult = ((Collection<? extends IRelationshipEL>) _mergeELs);
          break;
        case START:
          _switchResult = this.parent.get(DictionaryConstants._START).getAttrsEL();
          break;
        case END:
          _switchResult = this.parent.get(DictionaryConstants._END).getAttrsEL();
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    return _switchResult;
  }
}
