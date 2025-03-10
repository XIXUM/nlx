package org.xixum.nlx.view.fxviews.access;

import org.xixum.nlx.view.fxviews.control.ICanvasController;
import org.xixum.nlx.view.fxviews.control.IController;

public interface IJavaFxObj {

	Object getParent();
	IController getController();
	ICanvasController getCanvasController();

}
