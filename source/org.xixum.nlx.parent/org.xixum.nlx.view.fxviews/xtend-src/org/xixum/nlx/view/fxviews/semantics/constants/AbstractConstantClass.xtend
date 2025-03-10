package org.xixum.nlx.view.fxviews.semantics.constants

import org.xixum.nlx.view.fxviews.util.PluginUtils

abstract class AbstractConstantClass {
	
	protected def static String getString(String key) {
		return PluginUtils.INSTANCE.getString(key);
	}
}