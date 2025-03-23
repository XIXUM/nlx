/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

package org.xixum.nlx.view.fxviews.semantics

import java.util.List
import org.neo4j.driver.v1.Record

interface ILinkInfo {
	def Object getRecord(String key)
	
	def Record getRecord()
	
	def List<Record> getRecordMap()
	
}