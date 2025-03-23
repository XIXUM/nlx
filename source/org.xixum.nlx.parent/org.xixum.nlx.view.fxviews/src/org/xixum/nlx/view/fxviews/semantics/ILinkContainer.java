/**
 * (c) XIXUM.ORG - all rights reserved
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
