package org.xixum.nlx.dictionary.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.dictionary.type.elements.INodeEL;
import org.xixum.nlx.dictionary.type.elements.IRelationshipEL;
import org.xixum.nlx.dictionary.type.elements.NodeEL;
import org.xixum.nlx.dictionary.type.elements.RelationshipEL;

@SuppressWarnings("all")
public class TypeAttributes implements ITypeAttributes {
  private Node baseNode;

  private Set<IRelationshipEL> attrs;

  private Set<INodeEL> source;

  private Set<INodeEL> target;

  public TypeAttributes(final Node node, final Iterable<?> links, final Node source, final Node target) {
    XHashSet<INodeEL> _xHashSet = new XHashSet<INodeEL>();
    this.source = _xHashSet;
    NodeEL sourceEL = new NodeEL(source);
    this.source.add(sourceEL);
    XHashSet<INodeEL> _xHashSet_1 = new XHashSet<INodeEL>();
    this.target = _xHashSet_1;
    NodeEL targetEL = null;
    if ((target != null)) {
      NodeEL _nodeEL = new NodeEL(target);
      targetEL = _nodeEL;
      this.target.add(targetEL);
    }
    this.basicsConstructor(node, links, sourceEL, targetEL);
  }

  public TypeAttributes(final Node node, final Iterable<?> links, final List<Node> sourceELs, final List<Node> targetELs) {
    this.baseNode = node;
    XHashSet<INodeEL> _xHashSet = new XHashSet<INodeEL>();
    this.source = _xHashSet;
    final Function1<Node, NodeEL> _function = (Node e) -> {
      return new NodeEL(e);
    };
    this.source.addAll(ListExtensions.<Node, NodeEL>map(sourceELs, _function));
    XHashSet<INodeEL> _xHashSet_1 = new XHashSet<INodeEL>();
    this.target = _xHashSet_1;
    final Function1<Node, NodeEL> _function_1 = (Node e) -> {
      return new NodeEL(e);
    };
    this.target.addAll(ListExtensions.<Node, NodeEL>map(targetELs, _function_1));
    final ArrayList<IRelationshipEL> list = CollectionLiterals.<IRelationshipEL>newArrayList();
    Iterable<?> _elvis = null;
    if (links != null) {
      _elvis = links;
    } else {
      _elvis = Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList());
    }
    for (final Object rel : _elvis) {
      if ((rel instanceof Relationship)) {
        final long end = ((Relationship)rel).endNodeId();
        final long start = ((Relationship)rel).startNodeId();
        final Function1<INodeEL, Boolean> _function_2 = (INodeEL n) -> {
          boolean _xifexpression = false;
          boolean _equals = Long.valueOf(n.getNode().id()).equals(Long.valueOf(start));
          if (_equals) {
            final Function1<INodeEL, Boolean> _function_3 = (INodeEL t) -> {
              boolean _xifexpression_1 = false;
              boolean _equals_1 = Long.valueOf(t.getNode().id()).equals(Long.valueOf(end));
              if (_equals_1) {
                _xifexpression_1 = list.add(RelationshipEL.create(n, t, ((Relationship)rel)));
              }
              return Boolean.valueOf(_xifexpression_1);
            };
            _xifexpression = IterableExtensions.<INodeEL>forall(this.target, _function_3);
          }
          return Boolean.valueOf(_xifexpression);
        };
        IterableExtensions.<INodeEL>forall(this.source, _function_2);
      }
    }
    this.attrs = IterableExtensions.<IRelationshipEL>toSet(list);
  }

  public TypeAttributes(final Node node, final ITypeAttributes start, final ITypeAttributes end) {
    this.baseNode = node;
    Collection<? extends IRelationshipEL> _attrsEL = start.getAttrsEL();
    XHashSet<IRelationshipEL> _xHashSet = new XHashSet<IRelationshipEL>(_attrsEL);
    this.attrs = _xHashSet;
    this.attrs.addAll(end.getAttrsEL());
    Collection<? extends INodeEL> _sourceEL = start.getSourceEL();
    XHashSet<INodeEL> _xHashSet_1 = new XHashSet<INodeEL>(_sourceEL);
    this.source = _xHashSet_1;
    this.source.addAll(end.getSourceEL());
    Collection<? extends INodeEL> _targetEL = start.getTargetEL();
    XHashSet<INodeEL> _xHashSet_2 = new XHashSet<INodeEL>(_targetEL);
    this.target = _xHashSet_2;
    this.target.addAll(end.getTargetEL());
  }

  public TypeAttributes(final Node node, final Set<IRelationshipEL> links, final Set<INodeEL> sourceELs, final Set<INodeEL> targetELs) {
    this.baseNode = node;
    this.attrs = links;
    this.source = sourceELs;
    this.target = targetELs;
  }

  public Set<IRelationshipEL> basicsConstructor(final Node node, final Iterable<?> links, final NodeEL sourceEL, final NodeEL targetEL) {
    Set<IRelationshipEL> _xblockexpression = null;
    {
      this.baseNode = node;
      ArrayList<IRelationshipEL> list = CollectionLiterals.<IRelationshipEL>newArrayList();
      Iterable<?> _elvis = null;
      if (links != null) {
        _elvis = links;
      } else {
        _elvis = Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList());
      }
      for (final Object rel : _elvis) {
        if ((rel instanceof Relationship)) {
          list.add(RelationshipEL.create(sourceEL, targetEL, ((Relationship)rel)));
        }
      }
      _xblockexpression = this.attrs = IterableExtensions.<IRelationshipEL>toSet(list);
    }
    return _xblockexpression;
  }

  @Override
  public Node getBaseNode() {
    return this.baseNode;
  }

  @Override
  public Object getAttrs() {
    Iterable<Relationship> _map = null;
    if (this.attrs!=null) {
      final Function1<IRelationshipEL, Relationship> _function = (IRelationshipEL e) -> {
        return e.getRelationship();
      };
      _map=IterableExtensions.<IRelationshipEL, Relationship>map(this.attrs, _function);
    }
    return IterableExtensions.<Relationship>toList(_map);
  }

  @Override
  public List<Node> getSource() {
    final Function1<INodeEL, Node> _function = (INodeEL e) -> {
      return e.getNode();
    };
    return ListExtensions.<INodeEL, Node>map(IterableExtensions.<INodeEL>toList(this.source), _function);
  }

  @Override
  public List<Node> getTarget() {
    final Function1<INodeEL, Node> _function = (INodeEL e) -> {
      return e.getNode();
    };
    return ListExtensions.<INodeEL, Node>map(IterableExtensions.<INodeEL>toList(this.target), _function);
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
