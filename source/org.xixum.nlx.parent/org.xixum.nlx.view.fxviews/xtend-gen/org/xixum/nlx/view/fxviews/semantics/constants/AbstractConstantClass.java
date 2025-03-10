package org.xixum.nlx.view.fxviews.semantics.constants;

import org.xixum.nlx.view.fxviews.util.PluginUtils;

@SuppressWarnings("all")
public abstract class AbstractConstantClass {
  protected static String getString(final String key) {
    return PluginUtils.INSTANCE.getString(key);
  }
}
