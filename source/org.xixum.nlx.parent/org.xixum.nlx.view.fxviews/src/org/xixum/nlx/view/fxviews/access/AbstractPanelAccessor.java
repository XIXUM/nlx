<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/access/AbstractPanelAccessor.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.access;

import java.util.ArrayList;
import java.util.List;

/**
 * @author schaller
 *
 */
public abstract class AbstractPanelAccessor implements IPanelsAccessor {
	
	protected List<IItem> tokenChain = new ArrayList<>();

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
	public boolean hasComboBox(int index) {
		if (index < tokenChain.size()) 
			return tokenChain.get(index).hasComboBox();
		return false;
	}

	@Override
	public String getCssClass(int index) {
		if (index < tokenChain.size()) 
			return tokenChain.get(index).getCssClass();
		return null;
	}

}
=======
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
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/access/AbstractPanelAccessor.java
