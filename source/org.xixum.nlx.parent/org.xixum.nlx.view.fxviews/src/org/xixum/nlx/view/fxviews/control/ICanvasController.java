/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

package org.xixum.nlx.view.fxviews.control;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public interface ICanvasController extends IController {
	
	public Point2D createAbsolutePos(double sceneX, double sceneY);

	public Pane getLinkPane();

}
