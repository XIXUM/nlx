/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

package org.xixum.nlx.view.fxviews.cache

import java.util.Collection
import org.neo4j.driver.v1.Record
import org.neo4j.driver.v1.types.Node

interface ICacheObj {
	
	def void setOutLink(ICacheObj obj)
	
	def void setInLink(ICacheObj obj)
	
	def Collection<ICacheObj>  getOutLinks()
	
	def Collection<ICacheObj>  getInLinks()
	
	def Node getNode()
	
	def Record getRecord()
	
	def String getName()
	
	def boolean hasAttrs(String string)
	
}