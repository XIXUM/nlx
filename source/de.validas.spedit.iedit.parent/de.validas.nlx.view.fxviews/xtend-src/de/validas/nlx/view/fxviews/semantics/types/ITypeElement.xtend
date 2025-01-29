package de.validas.nlx.view.fxviews.semantics.types

import de.validas.nlx.dictionary.type.ITypeAttributes
import de.validas.utils.data.lists.IAppendable
import de.validas.utils.data.lists.IContainable
import de.validas.utils.data.lists.IIndexable

interface ITypeElement extends IAppendable, IContainable, IIndexable{

	def ITypeAttributes getTypeAttributes()
	
	def void setTypeAttributes(ITypeAttributes attrs)
	
}