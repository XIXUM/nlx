<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/xtend-src/de/validas/nlx/dictionary/type/NoneTypeHierarchy.xtend
package de.validas.nlx.dictionary.type

import de.validas.nlx.dictionary.type.ITypeHierarchy
import java.util.List
import static de.validas.nlx.dictionary.constants.NodeConstants._NONE

class NoneTypeHierarchy implements ITypeHierarchy {
	
	override getType() {
		_NONE
	}
	
	override getChildren() {
		var List<ITypeHierarchy> empty = newArrayList
		return empty
	}
	
=======
package org.xixum.nlx.dictionary.type

import org.xixum.nlx.dictionary.type.ITypeHierarchy
import java.util.List
import static org.xixum.nlx.dictionary.constants.NodeConstants._NONE

class NoneTypeHierarchy implements ITypeHierarchy {
	
	override getType() {
		_NONE
	}
	
	override getChildren() {
		var List<ITypeHierarchy> empty = newArrayList
		return empty
	}
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/xtend-src/org/xixum/nlx/dictionary/type/NoneTypeHierarchy.xtend
}