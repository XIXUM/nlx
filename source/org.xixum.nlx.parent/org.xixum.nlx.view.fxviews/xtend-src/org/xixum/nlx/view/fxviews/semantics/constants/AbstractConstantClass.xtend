<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/semantics/constants/AbstractConstantClass.xtend
package de.validas.nlx.view.fxviews.semantics.constants

import de.validas.nlx.view.fxviews.util.PluginUtils

abstract class AbstractConstantClass {
	
	protected def static String getString(String key) {
		return PluginUtils.INSTANCE.getString(key);
	}
=======
package org.xixum.nlx.view.fxviews.semantics.constants

import org.xixum.nlx.view.fxviews.util.PluginUtils

abstract class AbstractConstantClass {
	
	protected def static String getString(String key) {
		return PluginUtils.INSTANCE.getString(key);
	}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/semantics/constants/AbstractConstantClass.xtend
}