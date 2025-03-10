package org.xixum.nlx.dictionary.grammar.utils;

import org.eclipse.emf.edit.EMFEditPlugin;

@SuppressWarnings("all")
public class StaticUtils {
  public static EMFEditPlugin getResourceLocator() {
    return EMFEditPlugin.INSTANCE;
  }

  public static String getString(final String key, final boolean translate) {
    return StaticUtils.getResourceLocator().getString(key, translate);
  }

  public static String getString(final String key) {
    return StaticUtils.getString(key, true);
  }
}
