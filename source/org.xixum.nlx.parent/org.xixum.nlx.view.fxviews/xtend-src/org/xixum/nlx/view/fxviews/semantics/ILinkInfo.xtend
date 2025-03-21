<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/semantics/ILinkInfo.xtend
package de.validas.nlx.view.fxviews.semantics

import org.neo4j.driver.v1.types.Node
import org.neo4j.driver.v1.Value
import org.neo4j.driver.v1.Record

interface ILinkInfo {
	def Object getRecord(String key)
	
	def Record getRecord()
=======
package org.xixum.nlx.view.fxviews.semantics

import java.util.List
import org.neo4j.driver.v1.Record

interface ILinkInfo {
	def Object getRecord(String key)
	
	def Record getRecord()
	
	def List<Record> getRecordMap()
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/semantics/ILinkInfo.xtend
}