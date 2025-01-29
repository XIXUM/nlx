package de.validas.nlx.dictionary.type.elements;

import de.validas.nlx.constants.Direction;
import de.validas.nlx.dictionary.type.elements.INetworkEL;
import de.validas.nlx.dictionary.type.elements.INodeEL;
import de.validas.nlx.dictionary.type.elements.IRelationshipEL;
import de.validas.nlx.dictionary.type.elements.NetworkEL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.neo4j.driver.v1.types.Node;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class NodeEL extends NetworkEL implements INodeEL {
  protected Node node;
  
  protected List<IRelationshipEL> relsIN;
  
  protected List<IRelationshipEL> relsOUT;
  
  public NodeEL(final Node node, final List<IRelationshipEL> rels) {
    this.node = node;
    this.addAllRels(rels);
  }
  
  public NodeEL(final Node node) {
    this.node = node;
    this.relsIN = CollectionLiterals.<IRelationshipEL>newArrayList();
    this.relsOUT = CollectionLiterals.<IRelationshipEL>newArrayList();
  }
  
  @Override
  public Node getNode() {
    return this.node;
  }
  
  @Override
  public boolean addAllRels(final List<IRelationshipEL> relationships) {
    boolean _xblockexpression = false;
    {
      boolean success = true;
      for (final IRelationshipEL rel : relationships) {
        {
          boolean respond = this.addRel(rel);
          if (success) {
            success = respond;
          }
        }
      }
      _xblockexpression = success;
    }
    return _xblockexpression;
  }
  
  @Override
  public List<IRelationshipEL> getRelationship(final Direction set) {
    List<IRelationshipEL> _switchResult = null;
    if (set != null) {
      switch (set) {
        case IN:
          _switchResult = this.relsIN;
          break;
        case OUT:
          _switchResult = this.relsOUT;
          break;
        case ALL:
          ArrayList<IRelationshipEL> _xblockexpression = null;
          {
            ArrayList<IRelationshipEL> all = CollectionLiterals.<IRelationshipEL>newArrayList();
            all.addAll(this.relsIN);
            all.addAll(this.relsOUT);
            _xblockexpression = all;
          }
          _switchResult = _xblockexpression;
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
  public boolean addRel(final IRelationshipEL rel) {
    boolean _xblockexpression = false;
    {
      long endID = rel.getRelationship().endNodeId();
      long startID = rel.getRelationship().startNodeId();
      long iD = this.node.id();
      if ((Long.valueOf(iD).equals(Long.valueOf(startID)) && (!this.relsOUT.contains(rel)))) {
        return this.relsOUT.add(rel);
      }
      if ((Long.valueOf(iD).equals(Long.valueOf(endID)) && (!this.relsIN.contains(rel)))) {
        return this.relsIN.add(rel);
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  @Override
  public long getID() {
    return this.node.id();
  }
  
  @Override
  public void mergeRel(final INetworkEL el) {
    if ((el instanceof NodeEL)) {
      final Function1<IRelationshipEL, Boolean> _function = (IRelationshipEL r) -> {
        Boolean _xblockexpression = null;
        {
          this.addRel(r);
          _xblockexpression = r.relink(this);
        }
        return _xblockexpression;
      };
      IterableExtensions.<IRelationshipEL>forall(((NodeEL)el).getRelationship(Direction.ALL), _function);
    }
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<String> _labels = this.node.labels();
      boolean _hasElements = false;
      for(final String label : _labels) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        _builder.append(label);
      }
    }
    _builder.append(" | ");
    Map<String, Object> _asMap = this.node.asMap();
    _builder.append(_asMap);
    return _builder.toString();
  }
}
