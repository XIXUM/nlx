<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/control/IObjController.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.control;

import de.validas.nlx.view.fxviews.access.IJavaFxObj;
import de.validas.nlx.view.fxviews.semantics.util.IDelegates.Procedure2;
import javafx.event.Event;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Pane;

/**
 * @author schaller
 *
 */
public interface IObjController extends IElmController {
	
	public Pane getPanel();
	public Labeled getLabel(); 
	public void addDragController(IDragController controller);
	public void setParent(IJavaFxObj nodePanel);
	public IJavaFxObj getParent();
	public void addListener(String string, Procedure2<IJavaFxObj, Event> plusButton); 
}
=======
/**
 * 
 */
package org.xixum.nlx.view.fxviews.control;

import org.xixum.nlx.view.fxviews.access.IJavaFxObj;
import org.xixum.nlx.view.fxviews.semantics.util.IDelegates.Procedure2;
import javafx.event.Event;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Pane;

/**
 * @author schaller
 *
 */
public interface IObjController extends IElmController {
	
	public Pane getPanel();
	public Labeled getLabel(); 
	public void addDragController(IDragController controller);
	public void setParent(IJavaFxObj nodePanel);
	public IJavaFxObj getParent();
	public void addListener(String string, Procedure2<IJavaFxObj, Event> plusButton); 
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/control/IObjController.java
