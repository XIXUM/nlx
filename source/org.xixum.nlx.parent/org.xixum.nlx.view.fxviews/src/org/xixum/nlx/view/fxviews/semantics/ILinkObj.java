<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/semantics/ILinkObj.java
package de.validas.nlx.view.fxviews.semantics;

import java.util.List;
import java.util.Map;

import de.validas.nlx.view.fxviews.access.IItem;
import de.validas.nlx.view.fxviews.control.ICanvasController;
import de.validas.utils.data.lists.IAppendable;

public interface ILinkObj extends ILinkable, IAppendable {

	int getIndex();

	IItem getToken();

	ICanvasController getCanvasController();
	
	public Map<String, List<ILink>> getLinks();

}
=======
package org.xixum.nlx.view.fxviews.semantics;

import java.util.List;
import java.util.Map;

import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.view.fxviews.control.ICanvasController;
import org.xixum.utils.data.lists.IAppendable;

public interface ILinkObj extends ILinkable, IAppendable {

	int getIndex();

	IItem getToken();

	ICanvasController getCanvasController();
	
	public Map<String, List<ILink>> getLinks();

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/semantics/ILinkObj.java
