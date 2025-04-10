/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */
package org.xixum.nlx.view.fxviews.semantics;

import java.net.URL;
import org.xixum.nlx.view.fxviews.access.IJavaFxObj;
import org.xixum.nlx.view.fxviews.control.ICanvasController;
import org.xixum.nlx.view.fxviews.control.IContextMenu;
import org.xixum.nlx.view.fxviews.control.IController;
import org.xixum.nlx.view.fxviews.control.IDragController;
import org.xixum.nlx.view.fxviews.control.ILinkController;

@SuppressWarnings("all")
public class LinkPath implements IJavaFxObj {
  private final ILink parent;

  private URL resource;

  private /* Pane */Object linkPane;

  private /* Shape */Object shape;

  private ILinkController controller;

  private /* FXMLLoader */Object loader;

  protected IDragController dragController;

  private IContextMenu contextmenu;

  public LinkPath(final ILink parent, final IContextMenu menu) {
    throw new Error("Unresolved compilation problems:"
      + "\nFXMLLoader cannot be resolved."
      + "\nThe method or field linkPane is undefined for the type ICanvasController"
      + "\nThe field LinkPath.loader refers to the missing type FXMLLoader"
      + "\nThe field LinkPath.loader refers to the missing type FXMLLoader"
      + "\nThe field LinkPath.linkPane refers to the missing type Pane"
      + "\nsetClassLoader cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LinkPath.shape refers to the missing type Shape");
  }

  public void draw(final /* Point2D */Object startPoint, final /* Point2D */Object endPoint, final Runnable flagDraw) {
    throw new Error("Unresolved compilation problems:"
      + "\nPath cannot be resolved to a type."
      + "\nPath cannot be resolved to a type."
      + "\nThe method or field Platform is undefined"
      + "\nThe method or field Platform is undefined"
      + "\nThe field LinkPath.shape refers to the missing type Shape"
      + "\nThe field LinkPath.shape refers to the missing type Shape"
      + "\nThe field LinkPath.loader refers to the missing type FXMLLoader"
      + "\nThe field LinkPath.loader refers to the missing type FXMLLoader"
      + "\nThe method getContainer() from the type LinkPath refers to the missing type Shape"
      + "\nThe field LinkPath.shape refers to the missing type Shape"
      + "\nThe field LinkPath.shape refers to the missing type Shape"
      + "\nThe field LinkPath.shape refers to the missing type Shape"
      + "\nThe method adjustPath(Point2D, Point2D, ObservableList) from the type LinkPath refers to the missing type Object"
      + "\nThe field LinkPath.shape refers to the missing type Shape"
      + "\n=== cannot be resolved"
      + "\nload cannot be resolved"
      + "\ngetController cannot be resolved"
      + "\ngetStyleClass cannot be resolved"
      + "\nclear cannot be resolved"
      + "\naddAll cannot be resolved"
      + "\nsetLayoutX cannot be resolved"
      + "\ngetX cannot be resolved"
      + "\nsetLayoutY cannot be resolved"
      + "\ngetY cannot be resolved"
      + "\ngetElements cannot be resolved"
      + "\nfxApplicationThread cannot be resolved"
      + "\nrunLater cannot be resolved");
  }

  public void assignToCanvas(final Runnable flagDraw) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LinkPath.linkPane refers to the missing type Pane"
      + "\nThe field LinkPath.shape refers to the missing type Shape"
      + "\ngetChildren cannot be resolved"
      + "\nadd cannot be resolved");
  }

  public Object adjustPath(final /* Point2D */Object startPoint, final /* Point2D */Object endPoint, final /* ObservableList<PathElement> */Object elements) {
    throw new Error("Unresolved compilation problems:"
      + "\nVLineTo cannot be resolved to a type."
      + "\nVLineTo cannot be resolved to a type."
      + "\nArcTo cannot be resolved to a type."
      + "\nArcTo cannot be resolved to a type."
      + "\nHLineTo cannot be resolved to a type."
      + "\nHLineTo cannot be resolved to a type."
      + "\nArcTo cannot be resolved to a type."
      + "\nArcTo cannot be resolved to a type."
      + "\nVLineTo cannot be resolved to a type."
      + "\nVLineTo cannot be resolved to a type."
      + "\ngetY cannot be resolved"
      + "\n- cannot be resolved"
      + "\ngetY cannot be resolved"
      + "\ngetX cannot be resolved"
      + "\n- cannot be resolved"
      + "\ngetX cannot be resolved"
      + "\nget cannot be resolved"
      + "\nget cannot be resolved"
      + "\nget cannot be resolved"
      + "\nget cannot be resolved"
      + "\nget cannot be resolved"
      + "\ngetY cannot be resolved"
      + "\n> cannot be resolved"
      + "\ngetY cannot be resolved"
      + "\nsetY cannot be resolved"
      + "\nsetY cannot be resolved"
      + "\nsetX cannot be resolved"
      + "\nsetX cannot be resolved"
      + "\nsetY cannot be resolved"
      + "\nsetY cannot be resolved"
      + "\nsetY cannot be resolved"
      + "\nsetX cannot be resolved"
      + "\nsetX cannot be resolved"
      + "\nsetY cannot be resolved"
      + "\nsetY cannot be resolved");
  }

  public Object remove() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LinkPath.linkPane refers to the missing type Pane"
      + "\nThe field LinkPath.shape refers to the missing type Shape"
      + "\ngetChildren cannot be resolved"
      + "\nremove cannot be resolved");
  }
}
