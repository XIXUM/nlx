<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/control/PanelsDragController.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.control;

import java.util.ArrayList;
import java.util.List;

/**
 * @author schaller
 *
 */
public class PanelsDragController implements IDragController {

	protected List<IDragevent> dragevents;
	/**
	 * 
	 */
	public PanelsDragController() {
		dragevents = new ArrayList<>();
	}

	@Override
	public void add(IDragevent dragevent) {
		dragevents.add(dragevent);
	}
	
	public void clear() {
		dragevents = new ArrayList<>();
	}

	@Override
	public List<IDragevent> getEvents() {
		
		return dragevents;
	}
	
}
=======
/**
 * 
 */
package org.xixum.nlx.view.fxviews.control;

import java.util.ArrayList;
import java.util.List;

/**
 * @author schaller
 *
 */
public class PanelsDragController implements IDragController {

	protected List<IDragevent> dragevents;
	/**
	 * 
	 */
	public PanelsDragController() {
		dragevents = new ArrayList<>();
	}

	@Override
	public void add(IDragevent dragevent) {
		dragevents.add(dragevent);
	}
	
	public void clear() {
		dragevents = new ArrayList<>();
	}

	@Override
	public List<IDragevent> getEvents() {
		
		return dragevents;
	}
	
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/control/PanelsDragController.java
