<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/control/IElmController.java
package de.validas.nlx.view.fxviews.control;

import de.validas.nlx.view.fxviews.access.IJavaFxObj;
import de.validas.nlx.view.fxviews.semantics.util.IDelegates.Procedure2;
import javafx.event.Event;

public interface IElmController extends IController {
	
	public abstract void setParent(IJavaFxObj element);
	public IJavaFxObj getParent();
	public abstract void addDragController(IDragController controller);
	void addListener(String event, Procedure2<IJavaFxObj, Event> proc);

}
=======
package org.xixum.nlx.view.fxviews.control;

import org.xixum.nlx.view.fxviews.access.IJavaFxObj;
import org.xixum.nlx.view.fxviews.semantics.util.IDelegates.Procedure2;
import javafx.event.Event;

public interface IElmController extends IController {
	
	public abstract void setParent(IJavaFxObj element);
	public IJavaFxObj getParent();
	public abstract void addDragController(IDragController controller);
	void addListener(String event, Procedure2<IJavaFxObj, Event> proc);

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/control/IElmController.java
