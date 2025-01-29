package de.validas.nlx.view.fxviews.semantics.types

import de.validas.nlx.constants.Direction
import de.validas.nlx.dictionary.grammar.rules.ImplicitRulesOnDict
import de.validas.nlx.dictionary.type.ITypeAttributes
import de.validas.nlx.view.fxviews.access.IJavaFxObj
import de.validas.nlx.view.fxviews.control.PanelObjExtController
import de.validas.nlx.view.fxviews.semantics.ILink
import de.validas.nlx.view.fxviews.semantics.ILinkObj
import de.validas.nlx.view.fxviews.semantics.ILinkType
import de.validas.nlx.view.fxviews.semantics.ILinkable
import de.validas.nlx.view.fxviews.semantics.util.AttribUtils
import java.util.HashMap
import java.util.List
import javafx.application.Platform
import javafx.scene.control.TitledPane
import javafx.scene.layout.VBox
import org.neo4j.driver.internal.value.ListValue
import org.neo4j.driver.v1.types.Relationship

import static de.validas.nlx.dictionary.constants.NodeConstants._TYPE
import de.validas.nlx.view.fxviews.control.SmallPanelObjController

abstract class AbstractLinkType implements ILinkType {
	protected var String name
	protected var ILinkable _parent

	override setParent(ILinkable nodePanel) {
		this._parent = nodePanel
	}

	override getNameClamped() {
		// TODO: should not be neccesary to check parent because Object related behavior will control it.
		if (this.parent instanceof ILink)
			'''(«name»)'''
		else
			name
	}
	
	def createAttributes(ITypeAttributes dbAttrs) { //TODO: 05.04.22 redundant move in superclass

		var attrs = dbAttrs?.attrs as List<?> ?: #[]
		var control = ((parent as IJavaFxObj).controller as SmallPanelObjController)

		if (attrs === null) {
			return
		}

		for (dir: #[Direction.IN, Direction.OUT]){
			if (!Platform.isFxApplicationThread)
				Platform.runLater([|
					clearAttribBox(dir)         //TODO: this should call also atribute creation otherwhise conflicts with below's new creation
				])
			else
				clearAttribBox(dir)
		}
		for (attr : attrs) {
			if (attr instanceof Relationship){
				var end = attr.endNodeId
				var start = attr.startNodeId
				var source = dbAttrs.source.get(0) //can only contain entity 1
				var targets = dbAttrs.target

				var VBox attribCtrl
				//var long dest_id
				var TitledPane accordion
				var Pair<Long ,Direction> directions
				var type = attr.get(_TYPE)
				var els = newArrayList
				
				//dest_id = end
				if (type!== null) {
					if (type instanceof ListValue) 
						els.addAll(type.asList)
					else
						els.add(type.asString)
					
					for (el : els) { 
						if (el.equals(Direction.IN.name)){
							directions = end -> Direction.IN
						}else if (source.id.equals(end)){
								directions = start -> Direction.IN
						} else {
							directions = end -> Direction.OUT
						}
										
						if (directions.key !==  source.id){
							attribCtrl = control.getAttribVBox(directions.value)
							accordion = control.getAccordion(directions.value)
							if (!accordion.visible)
								accordion.visible = true
		
							for (target : targets){
									if (target.id.equals(directions.key)){
										if (parent instanceof ILinkObj){
											AttribUtils.createAttrEntry(attribCtrl, source, target, attr)
										}
									}
								}
								
						}
					}
				}
			}
		}
	}
	
	def clearAttribBox(Direction dir){
		var control = ((parent as IJavaFxObj).controller as SmallPanelObjController)
		control.getAttribVBox(dir).children.clear
	}

	override getName() {
		this.name
	}

	override toString() {
		return '''AbstractLinkType: «name»'''
	}

	override getParent() {
		_parent
	}

	override void newType() {
		// stub
	}

	override getSelection() {
		0
	}

	override setSelection(int selection) {
		// stub
	}

	override HashMap<String, List<ILink>> getLinks() {
		null
	}

	override List<ILink> getSelectedLink() {
		null;
	}
	
	override postProcess(ILinkObj precessor, List<ITypeAttributes> attribs, ImplicitRulesOnDict grammar){
		
	}
	
	override getBaseType()
	{
		null
	}
	
	override getTypeEls() {
		null
	}
	
	override getTypeInfo(){
		null
	}
	
}
