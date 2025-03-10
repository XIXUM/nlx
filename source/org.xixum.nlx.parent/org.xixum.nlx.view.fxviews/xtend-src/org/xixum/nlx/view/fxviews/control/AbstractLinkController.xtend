<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/control/AbstractLinkController.xtend
package de.validas.nlx.view.fxviews.control

import de.validas.nlx.view.fxviews.semantics.ILinkable
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
	
=======
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
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/control/AbstractLinkController.xtend
}