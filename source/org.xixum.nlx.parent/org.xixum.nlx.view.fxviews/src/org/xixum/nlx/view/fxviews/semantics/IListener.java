<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/semantics/IListener.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.semantics;

import de.validas.utils.data.lists.LinkedList;

/**
 * @author schaller
 *
 */
public interface IListener {
	public LinkedList<ILinkObj> getPanelChain();
	public void setPanelChain(LinkedList<ILinkObj> panelChain);
	void update();
}
=======
/**
 * 
 */
package org.xixum.nlx.view.fxviews.semantics;

import org.xixum.utils.data.lists.LinkedList;

/**
 * @author schaller
 *
 */
public interface IListener {
	public LinkedList<ILinkObj> getPanelChain();
	public void setPanelChain(LinkedList<ILinkObj> panelChain);
	void update();
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/semantics/IListener.java
