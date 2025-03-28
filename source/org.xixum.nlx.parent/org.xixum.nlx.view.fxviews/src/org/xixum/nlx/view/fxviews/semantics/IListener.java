/**
 * (c) XIXUM.ORG - all rights reserved
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
