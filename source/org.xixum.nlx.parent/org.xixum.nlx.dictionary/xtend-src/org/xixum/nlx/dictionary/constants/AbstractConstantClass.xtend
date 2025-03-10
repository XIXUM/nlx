<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/xtend-src/de/validas/nlx/dictionary/constants/AbstractConstantClass.xtend
package de.validas.nlx.dictionary.constants

import de.validas.nlx.dictionary.util.PluginUtils

abstract class AbstractConstantClass {
	
	protected def static String getString(String key) {
		return PluginUtils.INSTANCE.getString(key);
	}
}
=======
package org.xixum.nlx.dictionary.constants

import org.xixum.nlx.dictionary.util.PluginUtils

abstract class AbstractConstantClass {
	
	protected def static String getString(String key) {
		return PluginUtils.INSTANCE.getString(key);
	}
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/xtend-src/org/xixum/nlx/dictionary/constants/AbstractConstantClass.xtend
