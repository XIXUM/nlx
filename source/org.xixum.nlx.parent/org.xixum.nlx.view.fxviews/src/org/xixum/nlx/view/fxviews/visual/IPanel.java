<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/visual/IPanel.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.visual;

import de.validas.nlx.view.fxviews.access.IPanelsAccessor;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * @author schaller
 *
 */
public interface IPanel extends ILinkObj {

	void configure(IPanelsAccessor accessor);

//	void selectItem(String newValue);
//
//	void addSelectionChangedListener(ChangeListener<? super String> selectionChangedListener);

	Node getRoot();

	void setListeners(ChangeListener<? super Bounds> changeListener);

	void scheduleDraw();

	Parent load();

}
=======
/**
 * 
 */
package org.xixum.nlx.view.fxviews.visual;

import org.xixum.nlx.view.fxviews.access.IPanelsAccessor;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * @author schaller
 *
 */
public interface IPanel extends ILinkObj {

	void configure(IPanelsAccessor accessor);

//	void selectItem(String newValue);
//
//	void addSelectionChangedListener(ChangeListener<? super String> selectionChangedListener);

	Node getRoot();

	void setListeners(ChangeListener<? super Bounds> changeListener);

	void scheduleDraw();

	Parent load();

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/visual/IPanel.java
