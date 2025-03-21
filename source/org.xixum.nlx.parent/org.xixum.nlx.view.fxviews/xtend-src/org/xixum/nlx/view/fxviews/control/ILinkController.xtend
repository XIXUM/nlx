<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/control/ILinkController.xtend
package de.validas.nlx.view.fxviews.control

import de.validas.nlx.view.fxviews.access.IJavaFxObj
import javafx.scene.control.ContextMenu

interface ILinkController{

	def void setParent(IJavaFxObj link)
	
	def void addDragController(IDragController controller)
	
	def void setSontextMenu(ContextMenu menu)
	
=======
package org.xixum.nlx.view.fxviews.control

import org.xixum.nlx.view.fxviews.access.IJavaFxObj
import javafx.scene.control.ContextMenu

interface ILinkController{

	def void setParent(IJavaFxObj link)
	
	def void addDragController(IDragController controller)
	
	def void setContextMenu(IContextMenu menu)
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/control/ILinkController.xtend
}