package de.validas.nlx.view.fxviews.semantics.types;

import de.validas.nlx.constants.Direction;
import de.validas.nlx.dictionary.constants.NodeConstants;
import de.validas.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.dictionary.type.ITypeInfo;
import de.validas.nlx.view.fxviews.access.IJavaFxObj;
import de.validas.nlx.view.fxviews.control.IController;
import de.validas.nlx.view.fxviews.control.SmallPanelObjController;
import de.validas.nlx.view.fxviews.semantics.ILink;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.ILinkType;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.semantics.util.AttribUtils;
import de.validas.utils.data.types.XPair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.neo4j.driver.internal.value.ListValue;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
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
    List<?> _elvis = null;
    Object _attrs = null;
    if (dbAttrs!=null) {
      _attrs=dbAttrs.getAttrs();
    }
    if (((List<?>) _attrs) != null) {
      _elvis = ((List<?>) _attrs);
    } else {
      _elvis = Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList());
    }
    List<?> attrs = _elvis;
    ILinkable _parent = this.getParent();
    IController _controller = ((IJavaFxObj) _parent).getController();
    SmallPanelObjController control = ((SmallPanelObjController) _controller);
    if ((attrs == null)) {
      return;
    }
    for (final Direction dir : Collections.<Direction>unmodifiableList(CollectionLiterals.<Direction>newArrayList(Direction.IN, Direction.OUT))) {
      boolean _isFxApplicationThread = Platform.isFxApplicationThread();
      boolean _not = (!_isFxApplicationThread);
      if (_not) {
        final Runnable _function = () -> {
          this.clearAttribBox(dir);
        };
        Platform.runLater(_function);
      } else {
        this.clearAttribBox(dir);
      }
    }
    for (final Object attr : attrs) {
      if ((attr instanceof Relationship)) {
        long end = ((Relationship)attr).endNodeId();
        long start = ((Relationship)attr).startNodeId();
        Node source = dbAttrs.getSource().get(0);
        List<Node> targets = dbAttrs.getTarget();
        VBox attribCtrl = null;
        TitledPane accordion = null;
        Pair<Long, Direction> directions = null;
        Value type = ((Relationship)attr).get(NodeConstants._TYPE);
        ArrayList<Object> els = CollectionLiterals.<Object>newArrayList();
        if ((type != null)) {
          if ((type instanceof ListValue)) {
            els.addAll(((ListValue)type).asList());
          } else {
            els.add(type.asString());
          }
          for (final Object el : els) {
            {
              boolean _equals = el.equals(Direction.IN.name());
              if (_equals) {
                Pair<Long, Direction> _mappedTo = Pair.<Long, Direction>of(Long.valueOf(end), Direction.IN);
                directions = _mappedTo;
              } else {
                boolean _equals_1 = Long.valueOf(source.id()).equals(Long.valueOf(end));
                if (_equals_1) {
                  Pair<Long, Direction> _mappedTo_1 = Pair.<Long, Direction>of(Long.valueOf(start), Direction.IN);
                  directions = _mappedTo_1;
                } else {
                  Pair<Long, Direction> _mappedTo_2 = Pair.<Long, Direction>of(Long.valueOf(end), Direction.OUT);
                  directions = _mappedTo_2;
                }
              }
              Long _key = directions.getKey();
              long _id = source.id();
              boolean _tripleNotEquals = ((_key).longValue() != _id);
              if (_tripleNotEquals) {
                attribCtrl = control.getAttribVBox(directions.getValue());
                accordion = control.getAccordion(directions.getValue());
                boolean _isVisible = accordion.isVisible();
                boolean _not_1 = (!_isVisible);
                if (_not_1) {
                  accordion.setVisible(true);
                }
                for (final Node target : targets) {
                  boolean _equals_2 = Long.valueOf(target.id()).equals(directions.getKey());
                  if (_equals_2) {
                    ILinkable _parent_1 = this.getParent();
                    if ((_parent_1 instanceof ILinkObj)) {
                      AttribUtils.createAttrEntry(attribCtrl, source, target, ((Relationship)attr));
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void clearAttribBox(final Direction dir) {
    ILinkable _parent = this.getParent();
    IController _controller = ((IJavaFxObj) _parent).getController();
    SmallPanelObjController control = ((SmallPanelObjController) _controller);
    control.getAttribVBox(dir).getChildren().clear();
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
