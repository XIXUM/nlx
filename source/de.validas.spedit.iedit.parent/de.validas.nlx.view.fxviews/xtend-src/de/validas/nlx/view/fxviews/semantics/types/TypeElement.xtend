package de.validas.nlx.view.fxviews.semantics.types

import de.validas.nlx.dictionary.IDictionaryAccess
import de.validas.nlx.dictionary.type.ITypeAttributes
import de.validas.nlx.dictionary.type.ITypeHierarchy
import de.validas.nlx.dictionary.type.NoneTypeHierarchy
import de.validas.nlx.view.fxviews.access.IJavaFxObj
import de.validas.nlx.view.fxviews.access.elements.ShortCutItem
import de.validas.nlx.view.fxviews.control.IDragController
import de.validas.nlx.view.fxviews.control.IElmController
import de.validas.nlx.view.fxviews.control.TypeControlElController
import de.validas.nlx.view.fxviews.semantics.ILink
import de.validas.nlx.view.fxviews.semantics.ILinkObj
import de.validas.nlx.view.fxviews.semantics.ILinkable
import de.validas.nlx.view.fxviews.semantics.util.IDelegates.Procedure2
import de.validas.utils.data.types.XPair
import java.net.URL
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import javafx.beans.value.ChangeListener
import javafx.event.Event
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.control.ComboBox

import static de.validas.nlx.dictionary.constants.NodeConstants._NONE
import static de.validas.nlx.view.fxviews.semantics.constants.FxViewConstants._CIRCLE_BUTTON
import static de.validas.nlx.view.fxviews.semantics.constants.FxViewConstants._DELETE_BUTTON
import de.validas.utils.data.lists.LinkedList
import de.validas.utils.data.lists.IAppendable
import de.validas.utils.data.lists.AbstractAppendable
import javafx.application.Platform

class TypeElement extends AbstractAppendable implements IJavaFxObj, ITypeElement {
	protected String typeName
	protected ITypeAttributes typeAttributes
	LiteralType parent
	protected LinkedList<? extends IAppendable> container
	Node root
	IElmController controller;
	IDragController dragController;
	FXMLLoader loader
	int index
	HashMap<XPair<String, ILinkable>,ILink> links
	
	IDictionaryAccess dictAccess
	
	protected ChangeListener<? super String> listener;
	boolean withNone
	
	Map<ComboBox<String>, ChangeListener<? super String>> listeners
	
	Procedure2<IJavaFxObj, Event> plusButton = [parent, event |
		var wordT = parent.parent
		if (wordT instanceof WordType) {
			wordT.selection = index
			wordT.parent.canvas.linkListener.update
			//wordT.update	
		}
	]
	
	Procedure2<IJavaFxObj, Event> deleteButton = [parent, event |
		deleteTypeInDict(typeName)
	]
	
	

	new(String name, ITypeAttributes attributes, int index, LiteralType parent, URL ressource) {
		this(name, attributes, index, parent, ressource, false)
	}
	
	new(String name, ITypeAttributes attributes, int index, LiteralType parent, URL ressource, boolean withNone) {
		this.parent = parent
		this.loader = new FXMLLoader(ressource)
		loader.setClassLoader(parent.parent.canvas.fxClassLoader);
		listeners = newHashMap()
		typeName = name
		typeAttributes = attributes
		this.index = index
		this.withNone = withNone
		this.links = newHashMap()
		this.dictAccess = ((parent.parent as ILinkObj).token as ShortCutItem).dictAccess
	}

	def create() {
		// TODO: consider to find common Abstract Class or Interface with all JavaFx Objects
		try {
			root = loader.load();
			controller = loader.getController();
			if (controller instanceof TypeControlElController) {
				controller.secondRow.managedProperty.bind(controller.secondRow.visibleProperty)
				controller.deleteContainer.managedProperty.bind(controller.deleteContainer.visibleProperty)
				var items = new ArrayList((parent?.getParent as ILinkObj)?.token?.wordTypes ?: #[])
				if (withNone)
					items.add(0, new NoneTypeHierarchy())
				addItems(items);
				if (parent.selection != index){
					controller.sphere.visible = false
				} else {
					controller.sphere.visible = true
				}
				if (parent.typeEls.size()<1)
					controller.deleteContainer.visible = false
				else 	
					controller.deleteContainer.visible = true
				controller.addListener(_CIRCLE_BUTTON, plusButton);
				controller.addListener(_DELETE_BUTTON, deleteButton);
			}
			controller.addDragController(dragController);
			controller.setParent(this);
		} catch (Exception ex) {
			print((parent.parent as ILinkObj).token.name)
			ex.printStackTrace()
		}
	}

	def addItems(List<ITypeHierarchy> types) {
		if (controller instanceof TypeControlElController) {
			var combo = controller.mainCombo
			if (typeName !== null) {  // Second level WordType deprecated
				combo.items += types.map[t|t.type]
				combo.value = typeName

				controller.secondRow.visible = false
			}

			setSelectionChangedListener(controller.mainCombo, [Object obs, String oldValue, String newValue | 
						if (newValue !== null)
							if (oldValue.equals(_NONE)){
								addTypeToDict(newValue) 
							} else if (alreadyExist(newValue)) { // Each type can only exist once delete old if another already existing type chosen
								deleteTypeInDict(oldValue)
							} else {
								replaceTypeInDict(oldValue, newValue)
							}
							typeName = newValue
					]);
					
		}
	}
	
	def setDeleteVisible(boolean visibility){
		if (controller instanceof TypeControlElController)
			if (!Platform.isFxApplicationThread)
				Platform.runLater([| 
					controller.deleteContainer.visible = visibility	
				])
			else
				controller.deleteContainer.visible = visibility
	}
	
	
	
	def alreadyExist(String string) {
		if (parent instanceof WordType){ //TODO: 06.12.22 extend for other types in the future
			val keys = parent.allTypes.map[e | e.name]
			return keys.contains(string)
		}
		false
	}
	
	def deleteTypeInDict(String type) {
		var name = ((parent.parent as ILinkObj).token as ShortCutItem).name
		if (!type.equals(_NONE))
			dictAccess.deleteTypeToWord(name, type)

		removeLinks
			
		parent.removeType(this) 
	}
	
	def removeLinks() {
		var removes = newArrayList
		for (key :links.keySet)
			if (links.get(key).detach(parent.parent))
				removes.add(key) // register deletions
		//avoid concurrent mod
		for (e : removes)
			links.remove(e)
	}
	
	def replaceTypeInDict(String oldType, String newType) {
		var name = ((parent.parent as ILinkObj).token as ShortCutItem).name
		typeAttributes  = dictAccess.replaceTypeForWord(name, oldType, newType)
		removeLinks
	}
	
	def addTypeToDict(String type) {
		var name = ((parent.parent as ILinkObj).token as ShortCutItem).name
		typeAttributes  = dictAccess.addTypeToWord(name, type)

		//TODO: 11.08.21 - launch linkProcssor for new Type here 
	}

	def getRoot() {
		root
	}
	

	override getParent() {
		parent
	}

	override getController() {
		controller
	}

	override getCanvasController() {
		var ILinkable panel = parent.parent
		if (panel instanceof ILinkObj) {
			panel.canvasController
		} else
			null
	}
	
	def getName(){
		typeName
	}
	
	/**
	 * @Deprecated: use getName()
	 */
	@Deprecated
	def getBaseType(){
		typeName
	}
	
	def addLink(ILink link) {
		var source = parent.parent
		var target = link.getOpposite(source)
		if (!containsKeyPair(links,target)){	
			this.links.put(target, link)
		} else {
			null
		}
	}
	
	def containsKeyPair(HashMap<XPair<String, ILinkable>, ILink> map, XPair<String, ILinkable> pair) {
		for (pairEl : map.keySet){
			if (pairEl.key.equals(pair.key) && pairEl.value.equals(pair.value))
				return true
		}
		false
	}
	
	def getLinks(){
		this.links
	}
	
	def getLink(String name){
		if (name.equals(typeName))
			this.links.values().toList
		else
			null	
	}
	
	def void setSelectionChangedListener(ComboBox<String> combo, ChangeListener<? super String> listener) {
		if (controller instanceof TypeControlElController)
			if (listener !== null){
				combo.valueProperty().addListener(listener);
				this.listeners.put(combo,listener);	
			}
	}



	def ChangeListener<? super String> getSelectionChangedListener() {
		return listener;
	}
	
	override getTypeAttributes() {
		typeAttributes
	}
	
	override setTypeAttributes(ITypeAttributes attrs){
		typeAttributes = attrs
	}
	
	override LinkedList<? extends IAppendable> getContainer() {
		return container;
	}

	override <E extends IAppendable> void setContainer(LinkedList<E> linkedList) {
		this.container = linkedList;
	}

	override int getIndex() {
		// TODO Auto-generated method stub
		return index;
	}

	override void setIndex(int i) {
		this.index = i;
		
	}
}
