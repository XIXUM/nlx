<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/semantics/types/ICardinalLinkable.xtend
/**
 * @author: Felix Schaller
 */

package de.validas.nlx.view.fxviews.semantics.types

import de.validas.nlx.view.fxviews.semantics.ILinkable
import de.validas.utils.data.types.XPair

/**
 * extends ILinkable for cardinal type forwarding
 */

interface ICardinalLinkable extends ILinkable {
	def ILinkable getBaseType()
	
	def XPair<String, ILinkable> getStart()
	
	def XPair<String, ILinkable> getEnd()
=======
/**
 * @author: Felix Schaller
 */

package org.xixum.nlx.view.fxviews.semantics.types

import org.xixum.nlx.view.fxviews.semantics.ILinkable
import org.xixum.utils.data.types.XPair

/**
 * extends ILinkable for cardinal type forwarding
 */

interface ICardinalLinkable extends ILinkable {
	def ILinkable getBaseType()
	
	def XPair<String, ILinkable> getStart()
	
	def XPair<String, ILinkable> getEnd()
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/semantics/types/ICardinalLinkable.xtend
}