package org.xixum.nlx.view.fxviews.control

import org.xixum.nlx.view.fxviews.access.IJavaFxObj
import javafx.scene.control.ContextMenu

interface ILinkController{

	def void setParent(IJavaFxObj link)
	
	def void addDragController(IDragController controller)
	
	def void setContextMenu(IContextMenu menu)
	
}