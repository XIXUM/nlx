<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/semantics/LinkInfo.xtend
package de.validas.nlx.view.fxviews.semantics

import de.validas.nlx.view.fxviews.semantics.ILinkInfo
import org.neo4j.driver.v1.types.Node
import org.neo4j.driver.internal.value.NodeValue
import org.neo4j.driver.internal.value.NullValue
import org.neo4j.driver.internal.value.ListValue
import org.neo4j.driver.v1.Record

class LinkInfo implements ILinkInfo {
	
	protected Record record
	
	new(Record rec) {
		this.record = rec
	}
	
	override getRecord(String key) {
		var value = record.get(key)
		switch (value){
			NodeValue:{
				value.asNode
			}
			NullValue:{
				null
			}
			ListValue:{
				value.asList
			}
			default: {
				null;
			}
		}
	}
	
	override getRecord() {
		record
	}
	
	
	
=======
package org.xixum.nlx.view.fxviews.semantics

import org.xixum.nlx.view.fxviews.semantics.ILinkInfo
import org.neo4j.driver.v1.types.Node
import org.neo4j.driver.internal.value.NodeValue
import org.neo4j.driver.internal.value.NullValue
import org.neo4j.driver.internal.value.ListValue
import org.neo4j.driver.v1.Record

class LinkInfo implements ILinkInfo {
	
	protected Record record
	
	new(Record rec) {
		this.record = rec
	}
	
	override getRecord(String key) {
		var value = record.get(key)
		switch (value){
			NodeValue:{
				value.asNode
			}
			NullValue:{
				null
			}
			ListValue:{
				value.asList
			}
			default: {
				null;
			}
		}
	}
	
	override getRecord() {
		record
	}
	
	override getRecordMap() {
		return #[record];
	}
	
	
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/semantics/LinkInfo.xtend
}