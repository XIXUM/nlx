package de.validas.nlx.dictionary.grammar.types

import de.validas.nlx.dictionary.type.ITypeInfo
import de.validas.nlx.dictionary.type.ITypeAttributes
import de.validas.utils.data.types.XPair

interface IGrammarType {
		def String getName()
		def ITypeInfo getTypeInfo()
		def XPair<String, ITypeAttributes> getBaseType()
}