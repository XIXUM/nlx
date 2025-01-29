package de.validas.nlx.view.fxviews.control;

import de.validas.nlx.view.fxviews.access.IJavaFxObj;
import de.validas.nlx.view.fxviews.control.IContextMenu;
import de.validas.nlx.view.fxviews.control.IDragController;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface ILinkController {
  public abstract void setParent(final IJavaFxObj link);
  
  public abstract void addDragController(final IDragController controller);
  
  public abstract void setContextMenu(final IContextMenu menu);
}
