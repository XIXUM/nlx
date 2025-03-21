<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/semantics/PathLinkInfo.java
/**
 * (c)2022 felixschaller.com 
 */
package de.validas.nlx.view.fxviews.semantics;

/**
 * @author schaller
 */

import java.util.List;

import org.neo4j.driver.v1.Record;

/**
 * class that extends LinkInfo to store exclusion patterns
 * @author schaller
 *
 */
public class PathLinkInfo extends LinkInfo implements ILinkInfo {

	private List<Record> recMap;

	public PathLinkInfo(List<Record> recMap) {
		//TODO: 03.06.2022 should check for empty List or null
		super(recMap.get(0));
		this.recMap = recMap;
	}

	public List<Record> getRecordMap() {
		return recMap;
	}

}
=======
/**
 * (c)2022 felixschaller.com 
 */
package org.xixum.nlx.view.fxviews.semantics;

/**
 * @author schaller
 */

import java.util.List;

import org.neo4j.driver.v1.Record;

/**
 * class that extends LinkInfo to store exclusion patterns
 * @author schaller
 *
 */
public class PathLinkInfo extends LinkInfo implements ILinkInfo {

	private List<Record> recMap;

	new(List<Record> recMap) {
		//TODO: 03.06.2022 should check for empty List or null
		super(recMap.get(0));
		this.recMap = recMap;
	}

	override getRecordMap() {
		return recMap;
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/semantics/PathLinkInfo.xtend
