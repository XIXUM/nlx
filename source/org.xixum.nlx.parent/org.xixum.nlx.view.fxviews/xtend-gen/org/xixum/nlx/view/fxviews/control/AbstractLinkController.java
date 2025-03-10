package org.xixum.nlx.view.fxviews.control;

@SuppressWarnings("all")
public abstract class AbstractLinkController implements /* AbstractCanvasObjController */ILinkController {
  protected /* ILinkable */Object link;

  /* @FXML
   */public abstract void onDragStart(final /* MouseEvent */Object event);

  /* @FXML
   */public abstract void onDragAfter(final /* DragEvent */Object event);

  /* @FXML
   */public abstract void onDragEnd(final /* DragEvent */Object event);

  /* @FXML
   */public abstract void onDragOver(final /* DragEvent */Object event);
}
