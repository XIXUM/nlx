package org.xixum.nlx.dictionary.type;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.xixum.nlx.dictionary.type.elements.INodeEL;
import org.xixum.nlx.dictionary.type.elements.IRelationshipEL;
import org.xixum.nlx.dictionary.type.elements.NodeEL;

@SuppressWarnings("all")
public class TypeAttributes implements ITypeAttributes {
  private /* Node */Object baseNode;

  private Set<IRelationshipEL> attrs;

  private Set<INodeEL> source;

  private Set<INodeEL> target;

  public TypeAttributes(final /* Node */Object node, final Iterable<?> links, final /* Node */Object source, final /* Node */Object target) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor NodeEL(Object) refers to the missing type Object"
      + "\nThe constructor NodeEL(Object) refers to the missing type Object"
      + "\nThe method basicsConstructor(Node, Iterable<?>, NodeEL, NodeEL) from the type TypeAttributes refers to the missing type Node"
      + "\n!== cannot be resolved");
  }

  public TypeAttributes(final /* Node */Object node, final Iterable<?> links, final /* List<Node> */Object sourceELs, final /* List<Node> */Object targetELs) {
    throw new Error("Unresolved compilation problems:"
      + "\nRelationship cannot be resolved to a type."
      + "\nThe method or field endNodeId is undefined for the type Object"
      + "\nThe method or field startNodeId is undefined for the type Object"
      + "\nThe field TypeAttributes.baseNode refers to the missing type Node"
      + "\nThe constructor NodeEL(Object) refers to the missing type Object"
      + "\nThe constructor NodeEL(Object) refers to the missing type Object"
      + "\nThe method getNode() from the type INodeEL refers to the missing type Object"
      + "\nThe method getNode() from the type INodeEL refers to the missing type Object"
      + "\nThe method create(INodeEL, INodeEL, Object) from the type RelationshipEL refers to the missing type Object"
      + "\nid cannot be resolved"
      + "\nequals cannot be resolved"
      + "\nid cannot be resolved"
      + "\nequals cannot be resolved");
  }

  public TypeAttributes(final /* Node */Object node, final ITypeAttributes start, final ITypeAttributes end) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeAttributes.baseNode refers to the missing type Node");
  }

  public TypeAttributes(final /* Node */Object node, final Set<IRelationshipEL> links, final Set<INodeEL> sourceELs, final Set<INodeEL> targetELs) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeAttributes.baseNode refers to the missing type Node");
  }

  public Set<IRelationshipEL> basicsConstructor(final /* Node */Object node, final Iterable<?> links, final NodeEL sourceEL, final NodeEL targetEL) {
    throw new Error("Unresolved compilation problems:"
      + "\nRelationship cannot be resolved to a type."
      + "\nThe field TypeAttributes.baseNode refers to the missing type Node"
      + "\nThe method create(INodeEL, INodeEL, Object) from the type RelationshipEL refers to the missing type Object");
  }

  @Override
  public Node getBaseNode() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field TypeAttributes.baseNode refers to the missing type Node");
  }

  @Override
  public Object getAttrs() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getRelationship() from the type IRelationshipEL refers to the missing type Object");
  }

  @Override
  public /* List<Node> */Object getSource() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getNode() from the type INodeEL refers to the missing type Object");
  }

  @Override
  public /* List<Node> */Object getTarget() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getNode() from the type INodeEL refers to the missing type Object");
  }

  @Override
  public void merge(final ITypeAttributes attributes) {
    Collection<? extends IRelationshipEL> list = attributes.getAttrsEL();
    boolean _isEmpty = list.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.attrs.addAll(list);
    }
    this.source.addAll(attributes.getSourceEL());
    this.target.addAll(attributes.getTargetEL());
  }

  @Override
  public Collection<? extends INodeEL> getSourceEL() {
    return this.source;
  }

  @Override
  public Collection<? extends INodeEL> getTargetEL() {
    return this.target;
  }

  @Override
  public Collection<? extends IRelationshipEL> getAttrsEL() {
    return this.attrs;
  }
}
