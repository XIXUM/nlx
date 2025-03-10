/**
 * 
 */
package org.xixum.nlx.view.fxviews.access;

import java.util.ArrayList;
import java.util.List;
import org.xixum.utils.data.lists.LinkedList;

/**
 * @author schaller
 *
 */
public abstract class AbstractPanelAccessor implements IPanelsAccessor {
	
	protected LinkedList<IItem> tokenChain = new LinkedList<>();

	/**
	 * 
	 */
	public AbstractPanelAccessor() {
		
	}

	@Override
	public double size() {
		if (tokenChain == null)
			return 0;
		return tokenChain.size();
	}

	@Override
	public IItem getToken(int index) {
		if (index < tokenChain.size()) 
			return tokenChain.get(index);
		return null;
	}

	@Override
	public String getCssClass(int index) {
		if (index < tokenChain.size()) 
			return tokenChain.get(index).getCssClass();
		return null;
	}

}
