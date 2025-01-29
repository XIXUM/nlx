package de.validas.nlx.dictionary.grammar.constants

import de.validas.nlx.dictionary.grammar.util.PluginUtils

abstract class AbstractConstantClass {
	
	protected def static String getString(String key) {
		return PluginUtils.INSTANCE.getString(key);
	}
}
