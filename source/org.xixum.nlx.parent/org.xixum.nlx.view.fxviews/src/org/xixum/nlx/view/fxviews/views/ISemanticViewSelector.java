<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/views/ISemanticViewSelector.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.views;

import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;

import de.validas.nlx.dictionary.IDictionaryAccess;

/**
 * @author schaller
 *
 */
public interface ISemanticViewSelector {

	void setSelectionToViewer(List<?> selection);

	void setActionBars(IActionBars actionBars);
	
	void selectionChanged(IWorkbenchPart part, ISelection selection);

	void addViewer(ISemanticTrainViewPart myViewPart);
	
	public IDictionaryAccess getDictAccess();

	void removeViewer(ISemanticTrainViewPart myViewPart);

}
=======
/**
 * 
 */
package org.xixum.nlx.view.fxviews.views;

import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;

import org.xixum.nlx.dictionary.IDictionaryAccess;

/**
 * @author schaller
 *
 */
public interface ISemanticViewSelector {

	void setSelectionToViewer(List<?> selection);

	void setActionBars(IActionBars actionBars);
	
	void selectionChanged(IWorkbenchPart part, ISelection selection);

	void addViewer(ISemanticTrainViewPart myViewPart);
	
	public IDictionaryAccess getDictAccess();

	void removeViewer(ISemanticTrainViewPart myViewPart);

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/views/ISemanticViewSelector.java
