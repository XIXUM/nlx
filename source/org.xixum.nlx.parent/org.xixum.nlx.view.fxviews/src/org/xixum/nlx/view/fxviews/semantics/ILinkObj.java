/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

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
