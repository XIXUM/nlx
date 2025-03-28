/**
 * (c) XIXUM.ORG - all rights reserved
 *
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
}