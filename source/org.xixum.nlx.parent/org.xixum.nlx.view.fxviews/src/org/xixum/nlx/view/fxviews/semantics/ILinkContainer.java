<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/semantics/ILinkContainer.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.semantics;

import java.util.List;

import de.validas.nlx.view.fxviews.control.IContainerController;
import de.validas.nlx.view.fxviews.views.IPanelContainer;

/**
 * @author schaller
 *
 */
public interface ILinkContainer extends ILinkObj {

	public abstract boolean getIsResolved();
	public abstract IContainerController getController();
	public List<ILinkable> getInnerLink();
	public IPanelContainer getParent();
	List<ILinkable> getAllInnerLinks();
	
}
=======
/**
 * 
 */
package org.xixum.nlx.view.fxviews.semantics;

import java.util.List;

import org.xixum.nlx.view.fxviews.control.IContainerController;
import org.xixum.nlx.view.fxviews.views.IPanelContainer;

/**
 * @author schaller
 *
 */
public interface ILinkContainer extends ILinkObj {

	public abstract boolean getIsResolved();
	public abstract IContainerController getController();
	public List<ILinkable> getInnerLink();
	public IPanelContainer getParent();
	List<ILinkable> getAllInnerLinks();
	public abstract int length(boolean terminals);
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/semantics/ILinkContainer.java
