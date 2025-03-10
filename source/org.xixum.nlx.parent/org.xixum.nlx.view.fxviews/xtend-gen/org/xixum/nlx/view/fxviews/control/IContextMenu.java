package org.xixum.nlx.view.fxviews.control;

import java.util.Map;
import org.xixum.nlx.view.fxviews.semantics.util.IDelegates;

@SuppressWarnings("all")
public interface IContextMenu {
  IDelegates.Procedure<Map> getMenuDelegate();

  /* ContextMenu */Object getMenu();

  /* Map<String, MenuItem> */Object getMenuItems();

  IContextMenu create();

  boolean add(final String item, final /* MenuItem */Object mItem);
}
