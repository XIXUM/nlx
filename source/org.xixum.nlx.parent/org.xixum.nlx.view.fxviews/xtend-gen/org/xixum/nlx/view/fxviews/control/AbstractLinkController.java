/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */
package org.xixum.nlx.view.fxviews.control;

import org.xixum.nlx.view.fxviews.semantics.ILinkable;

@SuppressWarnings("all")
public abstract class AbstractLinkController extends AbstractCanvasObjController implements ILinkController {
  protected ILinkable link;

  /* @FXML
   */public abstract void onDragStart(final /* MouseEvent */Object event);

  /* @FXML
   */public abstract void onDragAfter(final /* DragEvent */Object event);

  /* @FXML
   */public abstract void onDragEnd(final /* DragEvent */Object event);

  /* @FXML
   */public abstract void onDragOver(final /* DragEvent */Object event);
}
