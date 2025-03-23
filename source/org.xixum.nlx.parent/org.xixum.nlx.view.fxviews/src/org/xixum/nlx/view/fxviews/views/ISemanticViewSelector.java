/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

package org.xixum.nlx.view.fxviews.views;

import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;

import org.xixum.nlx.dictionary.IDictionaryAccess;

public interface ISemanticViewSelector {

	void setSelectionToViewer(List<?> selection);

	void setActionBars(IActionBars actionBars);
	
	void selectionChanged(IWorkbenchPart part, ISelection selection);

	void addViewer(ISemanticTrainViewPart myViewPart);
	
	public IDictionaryAccess getDictAccess();

	void removeViewer(ISemanticTrainViewPart myViewPart);

}
