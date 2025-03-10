<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.perspective/src/de/validas/nlx/perspective/PerspectiveFactory.java
/**
 * 
 */
package de.validas.nlx.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @author schaller
 *
 */
public class PerspectiveFactory implements IPerspectiveFactory {

	/**
	 * 
	 */
	public PerspectiveFactory() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.
	 * IPageLayout)
	 */
	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.setFixed(true);
	}

}
=======
/**
 * 
 */
package org.xixum.nlx.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @author schaller
 *
 */
public class PerspectiveFactory implements IPerspectiveFactory {

	/**
	 * 
	 */
	public PerspectiveFactory() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.
	 * IPageLayout)
	 */
	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.setFixed(true);
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.perspective/src/org/xixum/nlx/perspective/PerspectiveFactory.java
