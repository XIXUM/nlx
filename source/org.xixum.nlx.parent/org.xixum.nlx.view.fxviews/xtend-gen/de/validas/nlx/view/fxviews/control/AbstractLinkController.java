package de.validas.nlx.view.fxviews.control;

import de.validas.nlx.view.fxviews.control.AbstractCanvasObjController;
import de.validas.nlx.view.fxviews.control.ILinkController;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import javafx.fxml.FXML;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public abstract class AbstractLinkController extends AbstractCanvasObjController implements ILinkController {
  protected ILinkable link;
  
  @FXML
  public abstract void onDragStart(final MouseEvent event);
  
  @FXML
  public abstract void onDragAfter(final DragEvent event);
  
  @FXML
  public abstract void onDragEnd(final DragEvent event);
  
  @FXML
  public abstract void onDragOver(final DragEvent event);
}
