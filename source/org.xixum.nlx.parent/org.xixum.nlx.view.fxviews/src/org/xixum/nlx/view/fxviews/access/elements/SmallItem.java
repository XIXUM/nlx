<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/access/elements/SmallItem.java
/**
 *
 */
package de.validas.nlx.view.fxviews.access.elements;

import org.eclipse.emf.ecore.EObject;

import de.validas.nlx.view.fxviews.semantics.types.InterpunctionType;
import javafx.scene.Node;

/**
 * @author schaller
 *	
 *	Abstract class to Gather SmallItem Features
 */
public abstract class SmallItem extends AbstractItem {

	/**
	 * @param el
	 */
	public SmallItem(EObject el) {
		super(el);
	}
	
	@Override
	public boolean hasComboBox() {
		return false;
	}
	
	@Override
	public Node instantiateTypes() {
		update();
		return null;
	}

	protected void update() {
		if (type instanceof InterpunctionType) {
			((InterpunctionType)type).update();
		}
	}
	

}
=======
/**
 *
 */
package org.xixum.nlx.view.fxviews.access.elements;

import org.eclipse.emf.ecore.EObject;

import org.xixum.nlx.view.fxviews.semantics.types.InterpunctionType;
import javafx.scene.Node;

/**
 * @author schaller
 *	
 *	Abstract class to Gather SmallItem Features
 */
public abstract class SmallItem extends AbstractItem {

	/**
	 * @param el
	 */
	public SmallItem(EObject el) {
		super(el);
	}
	
	@Override
	public Node instantiateTypes() {
		update();
		return null;
	}

	protected void update() {
		if (type instanceof InterpunctionType) {
			((InterpunctionType)type).update();
		}
	}
	

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/access/elements/SmallItem.java
