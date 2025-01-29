package de.validas.nlx.view.fxviews.control;

import de.validas.nlx.view.fxviews.semantics.util.IDelegates;
import java.util.Map;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IContextMenu {
  public abstract IDelegates.Procedure<Map> getMenuDelegate();
  
  public abstract ContextMenu getMenu();
  
  public abstract Map<String, MenuItem> getMenuItems();
  
  public abstract IContextMenu create();
  
  public abstract boolean add(final String item, final MenuItem mItem);
}
