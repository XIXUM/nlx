package de.validas.nlx.view.fxviews.semantics.types

import de.validas.nlx.view.fxviews.semantics.ILinkable
import de.validas.nlx.constants.Direction
import org.neo4j.driver.v1.types.Node

interface IForwardLinkable extends ILinkable {
	
	def Direction getDirection()
	def Node getForwarType()
	
}