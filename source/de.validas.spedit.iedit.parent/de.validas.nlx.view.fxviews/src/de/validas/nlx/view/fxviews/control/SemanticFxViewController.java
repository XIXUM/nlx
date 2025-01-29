package de.validas.nlx.view.fxviews.control;

import de.validas.nlx.view.fxviews.visual.IVisual;
import de.validas.nlx.view.fxviews.visual.LineVisual;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;

import javafx.scene.shape.Path;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseDragEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

import javafx.scene.input.DragEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;


public class SemanticFxViewController implements ICanvasController {


    @FXML
    private ProgressIndicator indicator;
    @FXML
    private Pane overlayPane;
	@FXML
	protected AnchorPane anchorPane;
	@FXML
	protected VBox vBox;
	@FXML
	protected ScrollPane scrollpane;
	@FXML
	protected ChoiceBox<String> choiceBox;
	@FXML
	protected ComboBox<String> comboBox;
	@FXML
	protected Button button;
	@FXML
	protected Path path;
	@FXML
	protected HBox panelStack;
	@FXML
	protected Pane linkPane;
    @FXML
    private Label statusMessage;

	protected IVisual lineVisual;

	// Event Listener on AnchorPane[#anchorPane].onContextMenuRequested
	@FXML
	public void onContextMenu(ContextMenuEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#button].onDragOver
	@FXML
	public void sceneDragOver(DragEvent event) {
		event.acceptTransferModes(TransferMode.NONE);
		if (lineVisual != null) {
			Point2D absolutePos = createAbsolutePos(event.getSceneX(), event.getSceneY());
			lineVisual.draw((int) absolutePos.getX(), (int) absolutePos.getY());
		}
		event.consume();
	}

	public Point2D createAbsolutePos(double sceneX, double sceneY) {
		//TODO: provisional calculate new offset via listener only when scroll is changed  
		double contentH = scrollpane.getContent().getBoundsInLocal().getHeight();
		double contentW = scrollpane.getContent().getBoundsInLocal().getWidth();
		double winH = scrollpane.getBoundsInLocal().getHeight();
		double winW = scrollpane.getBoundsInLocal().getWidth();
		double offsetY = (contentH - winH)* scrollpane.getVvalue() - scrollpane.getBoundsInParent().getMinY();
		double offsetX = (contentW - winW)* scrollpane.getHvalue() - scrollpane.getBoundsInParent().getMinX();
		return new Point2D(offsetX + sceneX, offsetY + sceneY);
	}

	// Event Listener on ScrollPane[#scrollpane].onMouseDragOver
	@FXML
	public void sceneMouseDragOver(MouseDragEvent event) {
		// do nothing
	}

	// Event Listener on ScrollPane[#scrollpane].onMouseDragReleased
	@FXML
	public void sceneDragReleased(MouseDragEvent event) {
		// do nothing
	}

	// Event Listener on Button[#button].onContextMenuRequested
	@FXML
	public void contextMenuButton(ContextMenuEvent event) {
		// TODO just for Testing
	}

	// Event Listener on Button[#button].onDragDropped
	@FXML
	public void dragButtonDropped(DragEvent event) {
		// TODO just for Testing
	}

	// Event Listener on Button[#button].onDragOver
	@FXML
	public void buttonDragOver(DragEvent event) {
		// TODO just for Testing
	}

	// Event Listener on Button[#button].onMouseDragOver
	@FXML
	public void mouseButtonDragOver(MouseDragEvent event) {
		// TODO just for Testing
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'SemanticFXView.fxml'.";
		assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'SemanticFXView.fxml'.";
		assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'SemanticFXView.fxml'.";
		assert path != null : "fx:id=\"path\" was not injected: check your FXML file 'SemanticFXView.fxml'.";
		assert vBox != null : "fx:id=\"vBox\" was not injected: check your FXML file 'SemanticFXView.fxml'.";
		assert panelStack != null : "fx:id=\"panelStack\" was not injected: check your FXML file 'SemanticFXView.fxml'.";
		assert linkPane != null : "fx:id=\"linkPane\" was not injected: check your FXML file 'SemanticFXView.fxml'.";
		assert overlayPane != null : "fx:id=\"overlayPane\" was not injected: check your FXML file 'SemanticFXView.fxml'.";
		assert indicator != null : "fx:id=\"indicator\" was not injected: check your FXML file 'SemanticFXView.fxml'.";
		assert statusMessage != null : "fx:id=\"statusMessage\" was not injected: check your FXML file 'SemanticFXView.fxml'.";
	}

	/**
	 * @return the anchorPane
	 */
	public AnchorPane getAnchorPane() {
		return anchorPane;
	}

	/**
	 * @return the panelStack
	 */
	public HBox getPanelStack() {
		return panelStack;
	}

	/**
	 * @return the vBox
	 */
	public VBox getvBox() {
		return vBox;
	}

	/**
	 * @return the linkPane
	 */
	public Pane getLinkPane() {
		return linkPane;
	}

	/**
	 * @return the choiceBox
	 */
	public ChoiceBox<String> getChoiceBox() {
		return choiceBox;
	}

	/**
	 * @return the comboBox
	 */
	public ComboBox<String> getComboBox() {
		return comboBox;
	}

	/**
	 * @return the button
	 */
	public Button getButton() {
		return button;
	}

	/**
	 * @return the path
	 */
	public Path getPath() {
		return path;
	}

	/**
	 * @return the scrollpane
	 */
	public ScrollPane getScrollpane() {
		return scrollpane;
	}

	/**
	 * @return the lineVisual
	 */
	public IVisual getLineVisual() {
		return lineVisual;
	}

	/**
	 * @param lineVisual the lineVisual to set
	 */
	public void setLineVisual(IVisual lineVisual) {
		this.lineVisual = lineVisual;
	}

	public void createLineVisual(int startX, int startY) {
		Point2D absolutePos = createAbsolutePos(startX, startY);
		lineVisual = new LineVisual((int) absolutePos.getX(), (int) absolutePos.getY(), anchorPane);
	}

	/**
	 * @return the indicator
	 */
	public ProgressIndicator getIndicator() {
		return indicator;
	}

	/**
	 * @return the overlayPane
	 */
	public Pane getOverlayPane() {
		return overlayPane;
	}
	
	/**
	 * @return the statusMessage
	 */
	public Label getStatusMessage() {
		return statusMessage;
	}

}
