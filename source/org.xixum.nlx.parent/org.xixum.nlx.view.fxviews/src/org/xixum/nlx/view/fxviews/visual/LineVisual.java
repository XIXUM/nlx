<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/visual/LineVisual.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.visual;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 * @author schaller
 *
 */
public class LineVisual implements IVisual {

	protected int startX;
	protected int startY;
	protected Pane canvas;
	protected Line lineGeom;

	/**
	 * @param parent
	 * @param startY
	 * @param startX
	 * 
	 */
	public LineVisual(int startX, int startY, Pane origin) {
		this.startX = startX;
		this.startY = startY;
		canvas = origin;
		lineGeom = new Line(startX, startY, startX, startY);
		canvas.getChildren().add(lineGeom);
	}

	@Override
	public void draw(int x, int y) {
		if (lineGeom != null) {
			lineGeom.setEndX(x);
			lineGeom.setEndY(y);

		}
	}

	@Override
	public void clear() {
		canvas.getChildren().remove(lineGeom);
		lineGeom = null;
	}

}
=======
/**
 * 
 */
package org.xixum.nlx.view.fxviews.visual;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 * @author schaller
 *
 */
public class LineVisual implements IVisual {

	protected int startX;
	protected int startY;
	protected Pane canvas;
	protected Line lineGeom;

	/**
	 * @param parent
	 * @param startY
	 * @param startX
	 * 
	 */
	public LineVisual(int startX, int startY, Pane origin) {
		this.startX = startX;
		this.startY = startY;
		canvas = origin;
		lineGeom = new Line(startX, startY, startX, startY);
		canvas.getChildren().add(lineGeom);
	}

	@Override
	public void draw(int x, int y) {
		if (lineGeom != null) {
			lineGeom.setEndX(x);
			lineGeom.setEndY(y);

		}
	}

	@Override
	public void clear() {
		canvas.getChildren().remove(lineGeom);
		lineGeom = null;
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/visual/LineVisual.java
