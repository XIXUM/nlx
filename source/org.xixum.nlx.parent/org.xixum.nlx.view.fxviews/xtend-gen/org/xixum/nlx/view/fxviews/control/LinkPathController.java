package org.xixum.nlx.view.fxviews.control;

import java.net.URL;
import java.util.ResourceBundle;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class LinkPathController extends AbstractLinkController {
  /* @FXML
   */private ResourceBundle resources;

  /* @FXML
   */private URL location;

  /* @FXML
   */private /* Path */Object path;

  private /* ContextMenu */Object cm;

  private IContextMenu menuHandler;

  public LinkPathController() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method hoverMode((Object)=>Object) is undefined"
      + "\nThe method acceptTransferModes(Object) is undefined for the type Object"
      + "\nThe method or field TransferMode is undefined"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nANY cannot be resolved");
  }

  /* @FXML */@Override
  public void onDragStart(final /* MouseEvent */Object event) {
    throw new Error("Unresolved compilation problems:"
      + "\nPath cannot be resolved to a type."
      + "\nThe method or field TransferMode is undefined"
      + "\nClipboardContent cannot be resolved."
      + "\nThe method or field AddLink is undefined for the type Class<DragContainer>"
      + "\nCannot cast from Object to int"
      + "\nCannot cast from Object to int"
      + "\ngetSceneX cannot be resolved"
      + "\ngetSceneY cannot be resolved"
      + "\ngetSource cannot be resolved"
      + "\nstartDragAndDrop cannot be resolved"
      + "\nANY cannot be resolved"
      + "\ntoString cannot be resolved"
      + "\nput cannot be resolved"
      + "\nsetContent cannot be resolved"
      + "\nconsume cannot be resolved");
  }

  /* @FXML */@Override
  public void onDragAfter(final /* DragEvent */Object event) {
    throw new Error("Unresolved compilation problems:"
      + "\nconsume cannot be resolved");
  }

  /* @FXML */@Override
  public void onDragEnd(final /* DragEvent */Object event) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field AddLink is undefined for the type Class<DragContainer>"
      + "\nThe method getPoint2D() is undefined for the type IDragevent"
      + "\ngetDragboard cannot be resolved"
      + "\ngetContent cannot be resolved"
      + "\ngetX cannot be resolved"
      + "\n< cannot be resolved"
      + "\ngetSceneX cannot be resolved"
      + "\nconsume cannot be resolved");
  }

  /* @FXML */@Override
  public void onDragOver(final /* DragEvent */Object event) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field TransferMode is undefined"
      + "\nThe method or field point2D is undefined for the type IDragevent"
      + "\nThe method or field successor is undefined for the type ILinkObj"
      + "\nThe method or field hoverMode is undefined"
      + "\nThe method or field successor is undefined for the type Object"
      + "\nThe method getSuccessor() is undefined for the type ILinkObj"
      + "\nThe method or field precessor is undefined for the type Object"
      + "\nThe method getPrecessor() is undefined for the type ILinkObj"
      + "\nThe method or field hoverMode is undefined"
      + "\nThe method createAbsolutePos(Object, Object) is undefined for the type ICanvasController"
      + "\nType mismatch: cannot convert from Object to ILinkObj"
      + "\nType mismatch: cannot convert from Object to ILinkObj"
      + "\nType mismatch: cannot convert from Object to ILinkObj"
      + "\nType mismatch: cannot convert from Object to ILinkObj"
      + "\nCannot cast from Object to int"
      + "\nCannot cast from Object to int"
      + "\nacceptTransferModes cannot be resolved"
      + "\nNONE cannot be resolved"
      + "\ngetX cannot be resolved"
      + "\n< cannot be resolved"
      + "\ngetSceneX cannot be resolved"
      + "\napply cannot be resolved"
      + "\ngetX cannot be resolved"
      + "\n> cannot be resolved"
      + "\ngetSceneX cannot be resolved"
      + "\napply cannot be resolved"
      + "\ngetSceneX cannot be resolved"
      + "\ngetSceneY cannot be resolved"
      + "\ngetX cannot be resolved"
      + "\ngetY cannot be resolved"
      + "\nconsume cannot be resolved");
  }

  /* @FXML
   */public void onHoverStart(final /* MouseEvent */Object event) {
  }

  /* @FXML
   */public void onHoverEnd(final /* MouseEvent */Object event) {
  }

  /* @FXML
   */public void onMouseClicked(final /* MouseEvent */Object event) {
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

  /* @FXML
   */public void onContextMenu(final /* ContextMenuEvent */Object event) {
    throw new Error("Unresolved compilation problems:"
      + "\nNode cannot be resolved to a type."
      + "\nThe method getMenuItems() from the type IContextMenu refers to the missing type MenuItem"
      + "\nThe field LinkPathController.cm refers to the missing type ContextMenu"
      + "\nsource cannot be resolved"
      + "\nscene cannot be resolved"
      + "\nwindow cannot be resolved"
      + "\nshow cannot be resolved"
      + "\nx cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nsceneX cannot be resolved"
      + "\ny cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nsceneY cannot be resolved");
  }

  /* @FXML */@Override
  public void initialize() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LinkPathController.path refers to the missing type // fx:id=\"path\"\n\tPath"
      + "\n=== cannot be resolved");
  }

  public // fx:id="path"
  	Path getPath() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LinkPathController.path refers to the missing type // fx:id=\"path\"\n\tPath");
  }

  @Override
  public void setContextMenu(final IContextMenu menu) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LinkPathController.cm refers to the missing type ContextMenu"
      + "\nThe method getMenu() from the type IContextMenu refers to the missing type ContextMenu");
  }
}
