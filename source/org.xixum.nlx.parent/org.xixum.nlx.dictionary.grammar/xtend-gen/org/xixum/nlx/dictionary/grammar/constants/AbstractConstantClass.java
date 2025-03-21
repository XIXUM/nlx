package org.xixum.nlx.dictionary.grammar.constants;

import org.xixum.nlx.dictionary.grammar.util.PluginUtils;

@SuppressWarnings("all")
public abstract class AbstractConstantClass {
  protected static String getString(final String key) {
    return PluginUtils.INSTANCE.getString(key);
  }
}
