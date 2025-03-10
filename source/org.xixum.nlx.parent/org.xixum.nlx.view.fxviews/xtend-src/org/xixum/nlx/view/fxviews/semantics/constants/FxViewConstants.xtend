<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/semantics/constants/FxViewConstants.xtend
package de.validas.nlx.view.fxviews.semantics.constants

import de.validas.nlx.view.fxviews.semantics.constants.AbstractConstantClass

class FxViewConstants extends AbstractConstantClass {
	
	public static val FXML_LINK_PATH_FILE 		= getString("FXML_LINK_PATH_FILE")
	public static val FXML_DESCR_FILE 			= getString("FXML_DESCR_FILE")	
	public static val FXML_PANEL_FILE 			= getString("FXML_PANEL_FILE") 			//	/PanelObj.fxml
	public static val FXML_SMALL_PANEL_FILE 	= getString("FXML_SMALL_PANEL_FILE")	// 	/SmallPanelObj.fxml
	public static val FXML_CONTAINER_FILE 		= getString("FXML_CONTAINER_FILE") 		//	/Container.fxml
	public static val FXML_TYPE_CONTROL_FILE	= getString("FXML_TYPE_CONTROL_FILE")
	
	public static val NLX_BACKGROUND_THREAD 	= getString("NLX_BACKGROUND_THREAD")	// "NLX Background Thread"
	
	public static val _CIRCLE_BUTTON			= getString("_CIRCLE_BUTTON") 			// "CircleButton";	
	public static val _MOUSE_PRESSED			= getString("_MOUSE_PRESSED")
	
	public static val _LINK						= getString("_LINK")
	public static val _LOW_LINK					= getString("_LOW_LINK")
	public static val _DISABLED					= getString("_DISABLED")
	public static val _DASHED					= getString("_DASHED")					// Dashed
	
	// Menu Items
	
	public static val _MENU_DELETE 				= getString("_MENU_DELETE")  			// "delete"
	public static val _MENU_UNDO 				= getString("_MENU_UNDO")  				// "undo"
	

=======
package org.xixum.nlx.view.fxviews.semantics.constants

import org.xixum.nlx.view.fxviews.semantics.constants.AbstractConstantClass

class FxViewConstants extends AbstractConstantClass {
	
	public static val FXML_LINK_PATH_FILE 		= getString("FXML_LINK_PATH_FILE")
	public static val FXML_DESCR_FILE 			= getString("FXML_DESCR_FILE")	
	public static val FXML_PANEL_FILE 			= getString("FXML_PANEL_FILE") 			//	/PanelObj.fxml
	public static val FXML_SMALL_PANEL_FILE 	= getString("FXML_SMALL_PANEL_FILE")	// 	/SmallPanelObj.fxml
	public static val FXML_CONTAINER_FILE 		= getString("FXML_CONTAINER_FILE") 		//	/Container.fxml
	public static val FXML_TYPE_CONTROL_FILE	= getString("FXML_TYPE_CONTROL_FILE")
	
	public static val NLX_BACKGROUND_THREAD 	= getString("NLX_BACKGROUND_THREAD")	// "NLX Background Thread"
	
	public static val _CIRCLE_BUTTON			= getString("_CIRCLE_BUTTON") 			// "CircleButton";	
	public static val _MOUSE_PRESSED			= getString("_MOUSE_PRESSED")
	public static val _DELETE_BUTTON			= getString("_DELETE_BUTTON")
	
	public static val _LINK						= getString("_LINK")
	public static val _LOW_LINK					= getString("_LOW_LINK")
	public static val _DISABLED					= getString("_DISABLED")
	public static val _DASHED					= getString("_DASHED")					// Dashed
	public static val _FORWARD_LINK				= getString("_FORWARD_LINK")			// forwardLink
	
	// Menu Items
	
	public static val _MENU_DELETE 				= getString("_MENU_DELETE")  			// "delete"
	public static val _MENU_UNDO 				= getString("_MENU_UNDO")  				// "undo"
	public static val _MENU_FORWARD_LEFT		= getString("_MENU_FORWARD_LEFT")		// "forward type left"
	public static val _MENU_FORWARD_RIGHT		= getString("_MENU_FORWARD_RIGHT")		// "forward type right"
	
	public static val _REGEX_ALPHA_CAPITAL		= getString("_REGEX_ALPHA_CAPITAL")		// "[a-zA-Z]+"

>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/semantics/constants/FxViewConstants.xtend
}