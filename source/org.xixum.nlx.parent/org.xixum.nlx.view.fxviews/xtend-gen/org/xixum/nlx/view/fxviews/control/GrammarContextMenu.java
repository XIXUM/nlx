package org.xixum.nlx.view.fxviews.control;

import java.util.Map;
import org.xixum.nlx.view.fxviews.semantics.util.IDelegates;

@SuppressWarnings("all")
public class GrammarContextMenu implements IContextMenu {
  private /* Map<String, MenuItem> */Object menuItems;

  private IDelegates.Procedure<Map> delegate;

  private /* ContextMenu */Object menu;

  public GrammarContextMenu(final IDelegates.Procedure<Map> delegate) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor GrammarContextMenu(Map<String, MenuItem>, Procedure<Map>) refers to the missing type MenuItem");
  }

  public GrammarContextMenu(final /* Map<String, MenuItem> */Object menuItems, final IDelegates.Procedure<Map> delegate) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field GrammarContextMenu.menuItems refers to the missing type MenuItem");
  }

  @Override
  public IDelegates.Procedure<Map> getMenuDelegate() {
    return this.delegate;
  }

  @Override
  public /* Map<String, MenuItem> */Object getMenuItems() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field GrammarContextMenu.menuItems refers to the missing type MenuItem");
  }

  @Override
  public ContextMenu getMenu() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field GrammarContextMenu.menu refers to the missing type ContextMenu");
  }

  @Override
  public IContextMenu create() {
    throw new Error("Unresolved compilation problems:"
      + "\nContextMenu cannot be resolved."
      + "\nThe field GrammarContextMenu.menu refers to the missing type ContextMenu"
      + "\nThe field GrammarContextMenu.menuItems refers to the missing type MenuItem"
      + "\nThe field GrammarContextMenu.menuItems refers to the missing type MenuItem"
      + "\nThe field GrammarContextMenu.menu refers to the missing type ContextMenu"
      + "\nThe field GrammarContextMenu.menuItems refers to the missing type MenuItem"
      + "\ngetItems cannot be resolved"
      + "\naddAll cannot be resolved");
  }

  @Override
  public boolean add(final String item, final /* MenuItem */Object mItem) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field GrammarContextMenu.menuItems refers to the missing type MenuItem"
      + "\n!== cannot be resolved");
  }
}
