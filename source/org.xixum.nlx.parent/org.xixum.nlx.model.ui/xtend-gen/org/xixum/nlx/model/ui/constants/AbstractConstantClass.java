package org.xixum.nlx.model.ui.constants;

import org.xixum.nlx.model.ui.util.PluginUtils;

@SuppressWarnings("all")
public abstract class AbstractConstantClass {
  protected static String getString(final String key) {
    return PluginUtils.INSTANCE.getString(key);
  }
}
