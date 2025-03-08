package de.validas.nlx.dictionary.constants;

import de.validas.nlx.dictionary.util.PluginUtils;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public abstract class AbstractConstantClass {
  protected static String getString(final String key) {
    return PluginUtils.INSTANCE.getString(key);
  }
}
