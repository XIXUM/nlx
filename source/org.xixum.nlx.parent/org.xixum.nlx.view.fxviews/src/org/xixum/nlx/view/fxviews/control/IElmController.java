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
