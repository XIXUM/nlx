package de.validas.nlx.dictionary.grammar.constants;

import de.validas.nlx.dictionary.grammar.util.PluginUtils;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public abstract class AbstractConstantClass {
  protected static String getString(final String key) {
    return PluginUtils.INSTANCE.getString(key);
  }
}
