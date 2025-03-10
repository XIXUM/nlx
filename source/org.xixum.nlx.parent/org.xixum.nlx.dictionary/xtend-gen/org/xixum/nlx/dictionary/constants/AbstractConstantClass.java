package org.xixum.nlx.dictionary.constants;

import org.xixum.nlx.dictionary.util.PluginUtils;

@SuppressWarnings("all")
public abstract class AbstractConstantClass {
  protected static String getString(final String key) {
    return PluginUtils.INSTANCE.getString(key);
  }
}
