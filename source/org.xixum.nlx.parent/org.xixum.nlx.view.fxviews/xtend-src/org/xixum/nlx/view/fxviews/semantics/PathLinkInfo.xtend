/**
 * (c)2025 xixum.org 
 */
package org.xixum.nlx.view.fxviews.semantics;

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
