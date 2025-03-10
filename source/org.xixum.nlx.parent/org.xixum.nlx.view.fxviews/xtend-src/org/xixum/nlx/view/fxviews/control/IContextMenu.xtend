package org.xixum.nlx.view.fxviews.control

import org.xixum.nlx.view.fxviews.semantics.util.IDelegates.Procedure
import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import java.util.Map

interface IContextMenu {

	def Procedure<Map> getMenuDelegate()	
	
	def ContextMenu getMenu()
	
	def Map<String,MenuItem> getMenuItems()
	
	def IContextMenu create()
	
	def boolean add(String item, MenuItem mItem)

}