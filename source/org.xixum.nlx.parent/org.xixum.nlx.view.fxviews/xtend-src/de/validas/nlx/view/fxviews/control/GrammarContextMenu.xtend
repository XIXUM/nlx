package de.validas.nlx.view.fxviews.control

import de.validas.nlx.view.fxviews.semantics.util.IDelegates.Procedure
import java.util.Map
import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import java.util.LinkedHashMap

class GrammarContextMenu implements IContextMenu {
	
	Map<String,MenuItem> menuItems
	Procedure<Map> delegate
	ContextMenu menu

	new (Procedure<Map> delegate){
		this(new LinkedHashMap(), delegate)
	}
	
	new (Map<String,MenuItem> menuItems, Procedure<Map> delegate){
		this.menuItems = menuItems
		this.delegate = delegate
	}
	
	override getMenuDelegate(){
		delegate
	}
	
	override getMenuItems(){
		menuItems
	}
	
	override getMenu(){
		menu
	}
	
	override create() {
		//TODO: 03.11.21 generate menue items dynamically in the future
		
		menu = new ContextMenu();
    	if (menuItems!== null && !menuItems.empty){
    		try {
	    		menu.getItems().addAll(menuItems.values);
	    	} 
	    	catch (java.lang.UnsupportedOperationException | java.util.ConcurrentModificationException e){
	    		//TODO: 07.12.22 unclear handling of this
	    		print('''\
«					»[DEBUG, GrammarContextMenu]: java.lang.UnsupportedOperationException''')
	    	}
	        this    
	    }
	}
	
	override add(String item, MenuItem mItem){
		if (menuItems.put(item, mItem) !== null)
			true
		else
			false
	}

}