package org.xixum.nlx.view.fxviews.semantics.types

import org.xixum.nlx.dictionary.type.ITypeAttributes
import org.xixum.utils.data.lists.IAppendable
import org.xixum.utils.data.lists.IContainable
import org.xixum.utils.data.lists.IIndexable

interface ITypeElement extends IAppendable, IContainable, IIndexable{

	def ITypeAttributes getTypeAttributes()
	
	def void setTypeAttributes(ITypeAttributes attrs)
	
}