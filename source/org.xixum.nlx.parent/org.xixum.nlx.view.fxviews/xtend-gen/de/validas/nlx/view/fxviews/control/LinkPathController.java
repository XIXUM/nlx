package de.validas.nlx.view.fxviews.control;

import de.validas.nlx.constants.Direction;
import de.validas.nlx.view.fxviews.access.IJavaFxObj;
import de.validas.nlx.view.fxviews.access.elements.SmallItem;
import de.validas.nlx.view.fxviews.control.AbstractLinkController;
import de.validas.nlx.view.fxviews.control.DragContainer;
import de.validas.nlx.view.fxviews.control.Dragevent;
import de.validas.nlx.view.fxviews.control.IContextMenu;
import de.validas.nlx.view.fxviews.control.IDragevent;
import de.validas.nlx.view.fxviews.control.SemanticFxViewController;
import de.validas.nlx.view.fxviews.semantics.ILink;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.semantics.LinkPath;
import de.validas.nlx.view.fxviews.semantics.LinkStyle;
import de.validas.nlx.view.fxviews.semantics.SemanticLink;
import de.validas.nlx.view.fxviews.semantics.util.IDelegates;
import de.validas.nlx.view.fxviews.semantics.util.LinkUtils;
import de.validas.nlx.view.fxviews.views.ISemanticTrainViewPart;
import de.validas.nlx.view.fxviews.visual.NodePanel;
import de.validas.utils.data.lists.IAppendable;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.shape.Path;
import javafx.stage.Window;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class LinkPathController extends AbstractLinkController {
  @FXML
  private ResourceBundle resources;
  
  @FXML
  private URL location;
  
  @FXML
  private Path path;
  
  private ContextMenu cm;
  
  private IContextMenu menuHandler;
  
  public LinkPathController() {
    super();
    final IDelegates.Procedure<DragEvent> _function = (DragEvent event) -> {
      event.acceptTransferModes(TransferMode.ANY);
    };
    this.hoverMode = _function;
  }
  
  @FXML
  @Override
  public void onDragStart(final MouseEvent event) {
    InputOutput.<String>print("\n[LinkPathController]: onDragStart");
    double startX = event.getSceneX();
    double startY = event.getSceneY();
    if ((this.dragController != null)) {
      Dragevent _dragevent = new Dragevent(startX, startY, this);
      this.dragController.add(_dragevent);
    }
    Object source = event.getSource();
    if ((source instanceof Path)) {
      Dragboard db = ((Path)source).startDragAndDrop(TransferMode.ANY);
      ClipboardContent content = new ClipboardContent();
      DragContainer container = new DragContainer();
      container.addData("source", ((Path)source).toString());
      content.put(DragContainer.AddLink, container);
      db.setContent(content);
    }
    if ((this.canvas instanceof SemanticFxViewController)) {
      ((SemanticFxViewController) this.canvas).createLineVisual(((int) startX), ((int) startY));
    }
    event.consume();
  }
  
  @FXML
  @Override
  public void onDragAfter(final DragEvent event) {
    InputOutput.<String>print("\n[LinkPathController]: onDragAfter");
    this.visualClear();
    event.consume();
  }
  
  @FXML
  @Override
  public void onDragEnd(final DragEvent event) {
    InputOutput.<String>print("\n[LinkPathController]: onDragEnd");
    this.visualClear();
    Object _content = event.getDragboard().getContent(DragContainer.AddLink);
    DragContainer container = ((DragContainer) _content);
    if ((container == null)) {
      return;
    }
    IDragevent dragEvent = this.getDragEvent();
    IJavaFxObj source = dragEvent.getController().getParent();
    Point2D sourcePoint = dragEvent.getPoint2D();
    Direction dir = null;
    double _x = sourcePoint.getX();
    double _sceneX = event.getSceneX();
    boolean _lessThan = (_x < _sceneX);
    if (_lessThan) {
      dir = Direction.RIGHT;
    } else {
      dir = Direction.LEFT;
    }
    if ((source != null)) {
      Object _parent = ((LinkPath) this.parent).getParent();
      ISemanticTrainViewPart view = ((SemanticLink) _parent).getCanvas().getViewPart();
      boolean _matched = false;
      if (source instanceof LinkPath) {
        _matched=true;
        Object _parent_1 = ((LinkPath)source).getParent();
        Object _parent_2 = this.parent.getParent();
        view.connectNode(((SemanticLink) _parent_1), ((ILinkable) _parent_2), dir);
      }
      if (!_matched) {
        if (source instanceof NodePanel) {
          _matched=true;
          Object _parent_1 = this.parent.getParent();
          view.connectNode(((ILinkable) source), ((ILinkable) _parent_1), dir);
        }
      }
    }
    if ((this.dragController != null)) {
      this.dragController.clear();
    }
    event.consume();
  }
  
  @FXML
  @Override
  public void onDragOver(final DragEvent event) {
    event.acceptTransferModes(TransferMode.NONE);
    IDragevent dragEvent = this.getDragEvent();
    IJavaFxObj source = dragEvent.getController().getParent();
    Point2D sourcePoint = dragEvent.getPoint2D();
    ILinkObj neigbour = null;
    boolean _matched = false;
    if (source instanceof LinkPath) {
      _matched=true;
      String _string = ((LinkPath)source).toString();
      String _plus = (": " + _string);
      InputOutput.<String>print(_plus);
      Object sourceLink = ((LinkPath)source).getParent();
      Object targetLink = this.parent.getParent();
      boolean _not = (!(((ILink) sourceLink).getStyle().equals(LinkStyle.DISABLED) || ((ILink) targetLink).getStyle().equals(LinkStyle.DISABLED)));
      if (_not) {
        ILinkObj first = null;
        ILinkObj second = null;
        double _x = sourcePoint.getX();
        double _sceneX = event.getSceneX();
        boolean _lessThan = (_x < _sceneX);
        if (_lessThan) {
          first = LinkUtils.findNextAdjacentPanel(((ILink) sourceLink), true);
          second = LinkUtils.findNextAdjacentPanel(((ILink) targetLink), false);
        } else {
          Object _parent = this.parent.getParent();
          first = LinkUtils.findNextAdjacentPanel(((ILink) _parent), true);
          Object _parent_1 = ((LinkPath)source).getParent();
          second = LinkUtils.findNextAdjacentPanel(((ILink) _parent_1), false);
        }
        int _index = second.getIndex();
        int _index_1 = first.getIndex();
        int delta = (_index - _index_1);
        if (((delta == 1) || ((delta == 2) && (((ILinkObj) first.getSuccessor()).getToken() instanceof SmallItem)))) {
          this.hoverMode.apply(event);
        }
      }
    }
    if (!_matched) {
      if (source instanceof NodePanel) {
        _matched=true;
        double _x = sourcePoint.getX();
        double _sceneX = event.getSceneX();
        boolean _greaterThan = (_x > _sceneX);
        if (_greaterThan) {
          Object _parent = this.parent.getParent();
          IAppendable _successor = LinkUtils.findNextAdjacentPanel(((ILink) _parent), true).getSuccessor();
          neigbour = ((ILinkObj) _successor);
          while ((neigbour.getToken() instanceof SmallItem)) {
            IAppendable _successor_1 = neigbour.getSuccessor();
            neigbour = ((ILinkObj) _successor_1);
          }
        } else {
          Object _parent_1 = this.parent.getParent();
          IAppendable _precessor = LinkUtils.findNextAdjacentPanel(((ILink) _parent_1), false).getPrecessor();
          neigbour = ((ILinkObj) _precessor);
          while ((neigbour.getToken() instanceof SmallItem)) {
            IAppendable _precessor_1 = neigbour.getPrecessor();
            neigbour = ((ILinkObj) _precessor_1);
          }
        }
        if ((neigbour == null)) {
          return;
        }
        boolean _equals = neigbour.equals(source);
        if (_equals) {
          this.hoverMode.apply(event);
        }
      }
    }
    Point2D absolutePos = this.canvas.createAbsolutePos(event.getSceneX(), event.getSceneY());
    double _x = absolutePos.getX();
    double _y = absolutePos.getY();
    this.visualDraw(((int) _x), ((int) _y));
    event.consume();
  }
  
  @FXML
  public void onHoverStart(final MouseEvent event) {
  }
  
  @FXML
  public void onHoverEnd(final MouseEvent event) {
  }
  
  @FXML
  public void onMouseClicked(final MouseEvent event) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("\\");
    _builder.newLine();
    _builder.append("[LinkPathController]: onMouseClicked -> ");
    Object _parent = this.parent.getParent();
    _builder.append(_parent);
    _builder.append(" ");
    InputOutput.<String>print(_builder.toString());
  }
  
  @FXML
  public void onContextMenu(final ContextMenuEvent event) {
    Object _source = event.getSource();
    Window win = ((Node) _source).getScene().getWindow();
    this.menuHandler.getMenuDelegate().apply(this.menuHandler.getMenuItems());
    double _x = win.getX();
    double _sceneX = event.getSceneX();
    double _plus = (_x + _sceneX);
    double _y = win.getY();
    double _sceneY = event.getSceneY();
    double _plus_1 = (_y + _sceneY);
    this.cm.show(win, _plus, _plus_1);
  }
  
  @FXML
  @Override
  public void initialize() {
    if ((this.path == null)) {
      throw new NoSuchElementException("\nfx:id=\"path\" was not injected: check your FXML file \'LinkPath.fxml\'.");
    }
  }
  
  public Path getPath() {
    return this.path;
  }
  
  @Override
  public void setContextMenu(final IContextMenu menu) {
    this.menuHandler = menu;
    ContextMenu _menu = null;
    if (menu!=null) {
      _menu=menu.getMenu();
    }
    this.cm = _menu;
  }
}
