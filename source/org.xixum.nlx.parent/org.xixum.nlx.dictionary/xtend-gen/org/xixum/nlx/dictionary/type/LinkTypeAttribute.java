package org.xixum.nlx.dictionary.type;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.dictionary.constants.AttributeSet;
import org.xixum.nlx.dictionary.constants.DictionaryConstants;
import org.xixum.nlx.dictionary.type.elements.INetworkEL;
import org.xixum.nlx.dictionary.type.elements.INodeEL;
import org.xixum.nlx.dictionary.type.elements.IRelationshipEL;

@SuppressWarnings("all")
public class LinkTypeAttribute implements ITypeAttributes {
  private Map<String, ITypeAttributes> parent;

  private Node linkBase;

  public LinkTypeAttribute(final Node linkNode, final ITypeAttributes source, final ITypeAttributes target) {
    this.parent = CollectionLiterals.<String, ITypeAttributes>newHashMap();
    this.parent.put(DictionaryConstants._START, source);
    this.parent.put(DictionaryConstants._END, target);
    this.linkBase = linkNode;
  }

  @Override
  public Node getBaseNode() {
    return this.linkBase;
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
    ITypeAttributes start = this.parent.get(DictionaryConstants._START);
    ITypeAttributes end = this.parent.get(DictionaryConstants._END);
    return new TypeAttributes(this.linkBase, start, end);
  }

  /**
   * @param mactchTarget: also target tye must match
   * @param includeBoth: include matches from start and end although they are partially redundant
   */
  public ITypeAttributes intersection(final Node basenode, final boolean matchTarget, final boolean includeBoth) {
    HashSet<IRelationshipEL> selected = CollectionLiterals.<IRelationshipEL>newHashSet();
    HashSet<INodeEL> srcs = CollectionLiterals.<INodeEL>newHashSet();
    HashSet<INodeEL> trg = CollectionLiterals.<INodeEL>newHashSet();
    ITypeAttributes start = this.parent.get(DictionaryConstants._START);
    ITypeAttributes end = this.parent.get(DictionaryConstants._END);
    Collection<? extends IRelationshipEL> _attrsEL = start.getAttrsEL();
    for (final IRelationshipEL relStart : _attrsEL) {
      Collection<? extends IRelationshipEL> _attrsEL_1 = end.getAttrsEL();
      for (final IRelationshipEL relEnd : _attrsEL_1) {
        boolean _equals = relStart.getRelationship().type().equals(relEnd.getRelationship().type());
        if (_equals) {
          INodeEL _xifexpression = null;
          boolean _contains = start.getTargetEL().contains(relStart.getEnd());
          if (_contains) {
            _xifexpression = relStart.getEnd();
          } else {
            _xifexpression = relStart.getStart();
          }
          INodeEL nodeS = _xifexpression;
          INodeEL _xifexpression_1 = null;
          boolean _contains_1 = end.getTargetEL().contains(relEnd.getEnd());
          if (_contains_1) {
            _xifexpression_1 = relEnd.getEnd();
          } else {
            _xifexpression_1 = relEnd.getStart();
          }
          INodeEL nodeE = _xifexpression_1;
          if ((nodeS.getNode().equals(nodeE.getNode()) && matchTarget)) {
            final boolean isStRemote = start.getSourceEL().contains(relStart.getStart());
            selected.add(relStart);
            INodeEL _xifexpression_2 = null;
            if (isStRemote) {
              _xifexpression_2 = relStart.getEnd();
            } else {
              _xifexpression_2 = relStart.getStart();
            }
            trg.add(_xifexpression_2);
            INodeEL _xifexpression_3 = null;
            if (isStRemote) {
              _xifexpression_3 = relStart.getStart();
            } else {
              _xifexpression_3 = relStart.getEnd();
            }
            srcs.add(_xifexpression_3);
            if (includeBoth) {
              final boolean isEnRemote = end.getSourceEL().contains(relEnd.getStart());
              selected.add(relEnd);
              INodeEL _xifexpression_4 = null;
              if (isEnRemote) {
                _xifexpression_4 = relEnd.getEnd();
              } else {
                _xifexpression_4 = relEnd.getStart();
              }
              trg.add(_xifexpression_4);
              INodeEL _xifexpression_5 = null;
              if (isEnRemote) {
                _xifexpression_5 = relEnd.getStart();
              } else {
                _xifexpression_5 = relEnd.getEnd();
              }
              srcs.add(_xifexpression_5);
            }
          }
        }
      }
    }
    int _size = selected.size();
    boolean _equals_1 = (_size == 0);
    if (_equals_1) {
      return null;
    }
    Node base = null;
    Node _baseNode = this.getBaseNode();
    boolean _tripleNotEquals = (_baseNode != null);
    if (_tripleNotEquals) {
      base = basenode;
    } else {
      base = this.linkBase;
    }
    return new TypeAttributes(base, selected, srcs, trg);
  }

  @Override
  public Object getAttrs() {
    return this.getAttrs(AttributeSet.ALL);
  }

  @Override
  public List<Node> getSource() {
    return this.getSource(AttributeSet.ALL);
  }

  public List<Node> getSource(final AttributeSet set) {
    List<Node> _switchResult = null;
    if (set != null) {
      switch (set) {
        case ALL:
          _switchResult = this.merge4Link().getSource();
          break;
        case START:
          _switchResult = this.parent.get(DictionaryConstants._START).getSource();
          break;
        case END:
          _switchResult = this.parent.get(DictionaryConstants._END).getSource();
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
  public List<Node> getTarget() {
    return this.getTarget(AttributeSet.ALL);
  }

  public List<Node> getTarget(final AttributeSet set) {
    List<Node> _switchResult = null;
    if (set != null) {
      switch (set) {
        case ALL:
          _switchResult = this.merge4Link().getTarget();
          break;
        case START:
          _switchResult = this.parent.get(DictionaryConstants._START).getTarget();
          break;
        case END:
          _switchResult = this.parent.get(DictionaryConstants._END).getTarget();
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
