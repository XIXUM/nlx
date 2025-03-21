<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/control/AbstractController.java
package de.validas.nlx.view.fxviews.control;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import de.validas.nlx.view.fxviews.access.IJavaFxObj;
import de.validas.nlx.view.fxviews.semantics.util.IDelegates.Procedure2;
import javafx.event.Event;
import javafx.fxml.FXML;

public abstract class AbstractController implements IElmController {
	
	protected IJavaFxObj parent;
	
	
	protected HashMap<String, List<Procedure2<IJavaFxObj, Event>>> listeners;
	
	
	
	@Override
	public void setParent(IJavaFxObj element) {
		this.parent = element;
	}
	
	@Override
	public IJavaFxObj getParent() {
		return parent;
	}
	
	protected void executeListeners(String key, Event event) {
		if (listeners.containsKey(key)){
			for (Procedure2<IJavaFxObj, Event> listener : listeners.get(key)) {
				listener.apply(parent, event);
			}
		}
		
	}
	
	@Override
	public void addListener(String event, Procedure2<IJavaFxObj, Event> proc) {
		if (listeners.containsKey(event)) {
			listeners.get(event).add(proc);
		} else {
			listeners.put(event, Arrays.asList(proc));
		}
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		listeners = new HashMap<String, List<Procedure2<IJavaFxObj, Event>>>();
	}

}
=======
package org.xixum.nlx.view.fxviews.control;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.xixum.nlx.view.fxviews.access.IJavaFxObj;
import org.xixum.nlx.view.fxviews.semantics.util.IDelegates.Procedure2;
import javafx.event.Event;
import javafx.fxml.FXML;

public abstract class AbstractController implements IElmController {
	
	protected IJavaFxObj parent;
	
	
	protected HashMap<String, List<Procedure2<IJavaFxObj, Event>>> listeners;
	
	
	
	@Override
	public void setParent(IJavaFxObj element) {
		this.parent = element;
	}
	
	@Override
	public IJavaFxObj getParent() {
		return parent;
	}
	
	protected void executeListeners(String key, Event event) {
		if (listeners.containsKey(key)){
			for (Procedure2<IJavaFxObj, Event> listener : listeners.get(key)) {
				listener.apply(parent, event);
			}
		}
		
	}
	
	@Override
	public void addListener(String event, Procedure2<IJavaFxObj, Event> proc) {
		if (listeners.containsKey(event)) {
			listeners.get(event).add(proc);
		} else {
			listeners.put(event, Arrays.asList(proc));
		}
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		listeners = new HashMap<String, List<Procedure2<IJavaFxObj, Event>>>();
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/control/AbstractController.java
