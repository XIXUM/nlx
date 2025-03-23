/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

package org.xixum.nlx.view.fxviews.visual;

import org.xixum.nlx.view.fxviews.access.IPanelsAccessor;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;

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
