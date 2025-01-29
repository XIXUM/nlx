package de.validas.nlx.dictionary.grammar.utils;

import javax.annotation.Generated;
import org.eclipse.emf.edit.EMFEditPlugin;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
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
