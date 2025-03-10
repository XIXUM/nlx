<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/access/ContextData.java
package de.validas.nlx.view.fxviews.access;

import org.eclipse.emf.common.util.EList;

public class ContextData {
	private int pos;
	private EList<String> separators;
	private String end;
	private String start;

	public ContextData() {
	}

	public ContextData(int pos, EList<String> separators, String start, String end) {
		this.pos = pos;
		this.separators = separators;
		this.start = start;
		this.end = end;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public EList<String> getSeparators() {
		return separators;
	}

	public void setSeparators(EList<String> separators) {
		this.separators = separators;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}
=======
package org.xixum.nlx.view.fxviews.access;

import org.eclipse.emf.common.util.EList;

public class ContextData {
	private int pos;
	private EList<String> separators;
	private String end;
	private String start;

	public ContextData() {
	}

	public ContextData(int pos, EList<String> separators, String start, String end) {
		this.pos = pos;
		this.separators = separators;
		this.start = start;
		this.end = end;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public EList<String> getSeparators() {
		return separators;
	}

	public void setSeparators(EList<String> separators) {
		this.separators = separators;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/access/ContextData.java
}