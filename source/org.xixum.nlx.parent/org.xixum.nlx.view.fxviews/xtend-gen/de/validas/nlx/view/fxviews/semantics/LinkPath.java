package de.validas.nlx.view.fxviews.semantics;

import de.validas.nlx.view.fxviews.access.IJavaFxObj;
import de.validas.nlx.view.fxviews.control.ICanvasController;
import de.validas.nlx.view.fxviews.control.IContextMenu;
import de.validas.nlx.view.fxviews.control.IController;
import de.validas.nlx.view.fxviews.control.IDragController;
import de.validas.nlx.view.fxviews.control.ILinkController;
import de.validas.nlx.view.fxviews.semantics.ILink;
import de.validas.nlx.view.fxviews.semantics.constants.FxViewConstants;
import de.validas.nlx.view.fxviews.semantics.constants.LinkConstants;
import java.io.IOException;
import java.net.URL;
import java.util.Set;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Shape;
import javafx.scene.shape.VLineTo;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class LinkPath implements IJavaFxObj {
  private final ILink parent;
  
  private URL resource;
  
  private Pane linkPane;
  
  private Shape shape;
  
  private ILinkController controller;
  
  private FXMLLoader loader;
  
  protected IDragController dragController;
  
  private IContextMenu contextmenu;
  
  public LinkPath(final ILink parent, final IContextMenu menu) {
    this.resource = this.getClass().getResource(FxViewConstants.FXML_LINK_PATH_FILE);
    FXMLLoader _fXMLLoader = new FXMLLoader(this.resource);
    this.loader = _fXMLLoader;
    this.loader.setClassLoader(parent.getCanvas().getFxClassLoader());
    this.parent = parent;
    this.dragController = parent.getDragController();
    this.linkPane = this.getCanvasController().getLinkPane();
    this.contextmenu = menu;
  }
  
  @Override
  public ICanvasController getCanvasController() {
    IController _controller = this.parent.getCanvas().getController();
    return ((ICanvasController) _controller);
  }
  
  @Override
  public IController getController() {
    return ((IController) this.controller);
  }
  
  @Override
  public Object getParent() {
    return this.parent;
  }
  
  public Shape getContainer() {
    return this.shape;
  }
  
  public void draw(final Point2D startPoint, final Point2D endPoint, final Runnable flagDraw) {
    if ((this.shape == null)) {
      try {
        this.shape = this.loader.<Shape>load();
        Object _controller = this.loader.<Object>getController();
        this.controller = ((ILinkController) _controller);
        this.controller.addDragController(this.dragController);
        IContextMenu _create = null;
        if (this.contextmenu!=null) {
          _create=this.contextmenu.create();
        }
        this.controller.setContextMenu(_create);
        this.controller.setParent(this);
        Set<String> style = this.parent.getStyle().getClasses();
        if ((style != null)) {
          ObservableList<String> classes = this.getContainer().getStyleClass();
          classes.clear();
          classes.addAll(style);
        }
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException e = (IOException)_t;
          e.printStackTrace();
          return;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    if ((this.shape instanceof Path)) {
      ((Path)this.shape).setLayoutX(startPoint.getX());
      ((Path)this.shape).setLayoutY(startPoint.getY());
      this.adjustPath(startPoint, endPoint, ((Path) this.shape).getElements());
      boolean _isFxApplicationThread = Platform.isFxApplicationThread();
      if (_isFxApplicationThread) {
        this.assignToCanvas(flagDraw);
      } else {
        final Runnable _function = () -> {
          synchronized (this) {
            this.assignToCanvas(flagDraw);
          }
        };
        Platform.runLater(_function);
      }
    }
  }
  
  public void assignToCanvas(final Runnable flagDraw) {
    this.linkPane.getChildren().add(this.shape);
    flagDraw.run();
  }
  
  public void adjustPath(final Point2D startPoint, final Point2D endPoint, final ObservableList<PathElement> elements) {
    double _y = endPoint.getY();
    double _y_1 = startPoint.getY();
    double deltaY = (_y - _y_1);
    double _x = endPoint.getX();
    double _x_1 = startPoint.getX();
    double deltaX = (_x - _x_1);
    PathElement _get = elements.get(1);
    VLineTo vLine1 = ((VLineTo) _get);
    PathElement _get_1 = elements.get(2);
    ArcTo arc1 = ((ArcTo) _get_1);
    PathElement _get_2 = elements.get(3);
    HLineTo hLine = ((HLineTo) _get_2);
    PathElement _get_3 = elements.get(4);
    ArcTo arc2 = ((ArcTo) _get_3);
    PathElement _get_4 = elements.get(5);
    VLineTo vLine2 = ((VLineTo) _get_4);
    double diameter = (LinkConstants.ARC_RADIUS * 2);
    double radius = 0;
    if ((deltaX < diameter)) {
      radius = (deltaX / 2);
    } else {
      radius = LinkConstants.ARC_RADIUS;
    }
    double _y_2 = endPoint.getY();
    double _y_3 = startPoint.getY();
    boolean _greaterThan = (_y_2 > _y_3);
    if (_greaterThan) {
      vLine1.setY((LinkConstants.OFFSET + deltaY));
      arc1.setY(((LinkConstants.OFFSET + radius) + deltaY));
      hLine.setX((deltaX - radius));
      arc2.setX(deltaX);
      arc2.setY((LinkConstants.OFFSET + deltaY));
      vLine2.setY(deltaY);
    } else {
      arc1.setY((LinkConstants.OFFSET + radius));
      hLine.setX((deltaX - radius));
      arc2.setX(deltaX);
      arc2.setY(LinkConstants.OFFSET);
      vLine2.setY(deltaY);
    }
  }
  
  public boolean remove() {
    boolean result = this.linkPane.getChildren().remove(this.shape);
    return result;
  }
}
