/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

package org.xixum.nlx.view.fxviews.control

import org.xixum.nlx.view.fxviews.semantics.ILinkable
import javafx.fxml.FXML
import javafx.scene.input.MouseEvent
import javafx.scene.input.DragEvent

abstract class AbstractLinkController extends AbstractCanvasObjController implements ILinkController {
	
	protected ILinkable link
	
	@FXML
	def void onDragStart(MouseEvent event) 

	@FXML
	def void onDragAfter(DragEvent event)
	 
	@FXML
	def void onDragEnd(DragEvent event)

	@FXML
	def void onDragOver(DragEvent event) 
	
}