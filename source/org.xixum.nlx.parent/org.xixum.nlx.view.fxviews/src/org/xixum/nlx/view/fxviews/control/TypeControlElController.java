package org.xixum.nlx.view.fxviews.control;

import static org.xixum.nlx.view.fxviews.semantics.constants.FxViewConstants._CIRCLE_BUTTON;
import static org.xixum.nlx.view.fxviews.semantics.constants.FxViewConstants._DELETE_BUTTON;

import org.xixum.nlx.view.fxviews.access.IJavaFxObj;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;

public class TypeControlElController extends AbstractController {
	protected IDragController dragController;
	
	@FXML
	private Circle button;
	@FXML
	private Sphere sphere;
	@FXML
	private PhongMaterial materialPhong;
	@FXML
	private ComboBox<String> mainCombo;
	@FXML
	private ComboBox<String> subCombo;
    @FXML
    private HBox secondRow;
    @FXML
    private AnchorPane deleteContainer;
    @FXML
    private Circle deleteIcon;
    
	@FXML
	public void circleClicked(MouseEvent event) {
		//System.out.println("[TypeControlEL]: CircleClicked");
		executeListeners(_CIRCLE_BUTTON, event);
	}
	
    @FXML
    void deleteClicked(MouseEvent event) {
    	executeListeners(_DELETE_BUTTON, event);
    }

	
	/**
	 * @return the button
	 */
	public Circle getButton() {
		return button;
	}

	/**
	 * @return the sphere
	 */
	public Sphere getSphere() {
		return sphere;
	}

	/**
	 * @return the materialPhong
	 */
	public PhongMaterial getMaterialPhong() {
		return materialPhong;
	}

	/**
	 * @return the mainCombo
	 */
	public ComboBox<String> getMainCombo() {
		return mainCombo;
	}

	/**
	 * @return the subCombo
	 */
	public ComboBox<String> getSubCombo() {
		return subCombo;
	}

	/**
	 * @return the dragController
	 */
	public IDragController getDragController() {
		return dragController;
	}

	/**
	 * @return the secondRow
	 */
	public HBox getSecondRow() {
		return secondRow;
	}

	/**
	 * @return the parent
	 */
	public IJavaFxObj getParent() {
		return parent;
	}

	@Override
	public void addDragController(IDragController controller) {
		if (dragController == null)
			dragController = controller;
	}

	/**
	 * @return the deleteContainer
	 */
	public AnchorPane getDeleteContainer() {
		return deleteContainer;
	}

	/**
	 * @return the deleteIcon
	 */
	public Circle getDeleteIcon() {
		return deleteIcon;
	}
	
	
	@Override
	@FXML
    void initialize() {
		super.initialize();
        assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'TypeControl.fxml'.";
        assert materialPhong != null : "fx:id=\"materialPhong\" was not injected: check your FXML file 'TypeControl.fxml'.";
        assert subCombo != null : "fx:id=\"subCombo\" was not injected: check your FXML file 'TypeControl.fxml'.";
        assert secondRow != null : "fx:id=\"secondRow\" was not injected: check your FXML file 'TypeControl.fxml'.";
        assert sphere != null : "fx:id=\"sphere\" was not injected: check your FXML file 'TypeControl.fxml'.";
        assert deleteContainer != null : "fx:id=\"deleteContainer\" was not injected: check your FXML file 'TypeControl.fxml'.";
        assert mainCombo != null : "fx:id=\"mainCombo\" was not injected: check your FXML file 'TypeControl.fxml'.";
        assert deleteIcon != null : "fx:id=\"deleteIcon\" was not injected: check your FXML file 'TypeControl.fxml'.";
    }
}
