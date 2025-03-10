package org.xixum.nlx.view.fxviews.semantics.types

import org.xixum.nlx.view.fxviews.semantics.ILinkable
import org.xixum.nlx.constants.Direction
import org.neo4j.driver.v1.types.Node

interface IForwardLinkable extends ILinkable {
	
	def Direction getDirection()
	def Node getForwarType()
	
}