package de.validas.nlx.view.fxviews.control;

import de.validas.nlx.view.fxviews.control.IContextMenu;
import de.validas.nlx.view.fxviews.semantics.util.IDelegates;
import java.util.ConcurrentModificationException;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class GrammarContextMenu implements IContextMenu {
  private Map<String, MenuItem> menuItems;
  
  private IDelegates.Procedure<Map> delegate;
  
  private ContextMenu menu;
  
  public GrammarContextMenu(final IDelegates.Procedure<Map> delegate) {
    this(new LinkedHashMap<String, MenuItem>(), delegate);
  }
  
  public GrammarContextMenu(final Map<String, MenuItem> menuItems, final IDelegates.Procedure<Map> delegate) {
    this.menuItems = menuItems;
    this.delegate = delegate;
  }
  
  @Override
  public IDelegates.Procedure<Map> getMenuDelegate() {
    return this.delegate;
  }
  
  @Override
  public Map<String, MenuItem> getMenuItems() {
    return this.menuItems;
  }
  
  @Override
  public ContextMenu getMenu() {
    return this.menu;
  }
  
  @Override
  public IContextMenu create() {
    GrammarContextMenu _xblockexpression = null;
    {
      ContextMenu _contextMenu = new ContextMenu();
      this.menu = _contextMenu;
      GrammarContextMenu _xifexpression = null;
      if (((this.menuItems != null) && (!this.menuItems.isEmpty()))) {
        GrammarContextMenu _xblockexpression_1 = null;
        {
          try {
            this.menu.getItems().addAll(this.menuItems.values());
          } catch (final Throwable _t) {
            if (_t instanceof UnsupportedOperationException || _t instanceof ConcurrentModificationException) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("\\");
              _builder.newLine();
              _builder.append("[DEBUG, GrammarContextMenu]: java.lang.UnsupportedOperationException");
              InputOutput.<String>print(_builder.toString());
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          _xblockexpression_1 = this;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean add(final String item, final MenuItem mItem) {
    boolean _xifexpression = false;
    MenuItem _put = this.menuItems.put(item, mItem);
    boolean _tripleNotEquals = (_put != null);
    if (_tripleNotEquals) {
      _xifexpression = true;
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
}
