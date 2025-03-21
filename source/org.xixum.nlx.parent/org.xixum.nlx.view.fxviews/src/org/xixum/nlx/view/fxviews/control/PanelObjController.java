<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/control/PanelObjController.java
package de.validas.nlx.view.fxviews.control;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.TransferMode;

public class PanelObjController extends SmallPanelObjController {
	@FXML
	protected ComboBox<String> combobox;
	
	public PanelObjController() {
		super();
		hoverMode = (event)-> {
			event.acceptTransferModes(TransferMode.ANY);
		};
	}

	void initialize() {
		super.initialize();
        assert combobox != null : "fx:id=\"combobox\" was not injected: check your FXML file 'PanelObj.fxml'.";
	}
	
	/**
	 * @return the combobox
	 */
	public ComboBox<String> getCombobox() {
		return combobox;
	}

}
=======
package org.xixum.nlx.view.fxviews.control;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.TransferMode;

public class PanelObjController extends SmallPanelObjController {
	@FXML
	protected ComboBox<String> combobox;
	
	public PanelObjController() {
		super();
		hoverMode = (event)-> {
			event.acceptTransferModes(TransferMode.ANY);
		};
	}

	void initialize() {
		super.initialize();
        assert combobox != null : "fx:id=\"combobox\" was not injected: check your FXML file 'PanelObj.fxml'.";
	}
	
	/**
	 * @return the combobox
	 */
	public ComboBox<String> getCombobox() {
		return combobox;
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/control/PanelObjController.java
