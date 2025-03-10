package org.xixum.nlx.view.fxviews.semantics.types

import org.xixum.nlx.dictionary.DictItem
import org.xixum.nlx.dictionary.IDictionaryAccess
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict
import org.xixum.nlx.dictionary.type.ITypeAttributes
import org.xixum.nlx.dictionary.type.ITypeInfo
import org.xixum.nlx.dictionary.type.NoneTypeAttributes
import org.xixum.nlx.view.fxviews.control.TypeControlElController
import org.xixum.nlx.view.fxviews.semantics.ILink
import org.xixum.nlx.view.fxviews.semantics.ILinkObj
import org.xixum.nlx.view.fxviews.semantics.ILinkable
import org.xixum.utils.data.lists.LinkedList
import org.xixum.utils.data.types.XPair
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import javafx.application.Platform
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox

import static org.xixum.nlx.dictionary.constants.NodeConstants._NONE
import static org.xixum.nlx.dictionary.constants.NodeConstants._WORD
import static org.xixum.nlx.view.fxviews.semantics.constants.FxViewConstants.FXML_TYPE_CONTROL_FILE

class WordType extends LiteralType {

	protected var ITypeInfo typeInfo //Grammar Data
	protected Pane group
	protected LinkedList<TypeElement> elements //GUI Data


	int selection = 0

	val ressource = getClass().getResource(FXML_TYPE_CONTROL_FILE)

	IDictionaryAccess dictAccess

	new(ITypeInfo typeInfo, ILinkable parent, IDictionaryAccess dictAccess) {
		super(_WORD,parent) //TODO: 24.01.22 maybe set Name to token name
		this.typeInfo = typeInfo
		this.elements = new LinkedList()
		this.dictAccess = dictAccess
	}

	override getBaseType(){
		//typeInfo.activeType
		var TypeElement el
		if (selection < elements.size())
			el = elements.get(selection)
		else if (elements.size() === 0){
			var res = dictAccess.getLinkTypes((_parent as ILinkObj).token.name, _WORD, true)
			if (res!== null){
				typeInfo = res
				generate
			} 
//			else
//				newType

		} else
			return null
		if (el !== null)
			return new XPair<String, ITypeAttributes>(el.name, el.getTypeAttributes)
		null
	}

	override getTypeEls(){
		elements.map[e | new XPair<String, ITypeAttributes>(e.typeName, e.typeAttributes)]
	}
	
	override getTypeInfo(){
		typeInfo 
	}

	override getRoot(){
		if (group === null)
			group = generate()
		update
		group
	}

	protected def Pane generate() {
		group = new VBox
		if (typeInfo?.types !== null)
			for (type : typeInfo.types){
				addType(type, false)
			}
		group
	}

	def addType(XPair<String, ITypeAttributes> type, boolean withNone){
		val el = new TypeElement(type.key, type.value, elements.size, this, ressource, withNone)
		el.create
		if (el.root !== null)
			if (!Platform.fxApplicationThread)
				Platform.runLater([|
					group.getChildren.add(el.root)
				])
			else
				group.getChildren.add(el.root)
		elements.add(el)
	}
	
	override removeType(TypeElement element) {
		group.getChildren.remove(element.root)
		if (!Platform.isFxApplicationThread)
			Platform.runLater([|
				elements.remove(element)
				])
		else
			elements.remove(element)
		val numEls = elements.size()
		if (selection >= numEls && numEls > 0)
			selection = numEls - 1
		else 
			selection = 0
		update
	}

	override newType() {
		addType(new XPair<String, ITypeAttributes>(_NONE, new NoneTypeAttributes), true);
		update
	}

	override setSelection(int selection) {
		if (selection< elements.size()){
			this.selection = selection
			update
		}
	}

	override update() {
		val visibilityDelegate = [TypeControlElController ctr, boolean vis | 
			if (!Platform.isFxApplicationThread)
				Platform.runLater([|
					ctr.sphere.visible = vis
				])
			else
				ctr.sphere.visible = vis
		]
		for (el : elements){
			if (selection != el.index){
				visibilityDelegate.apply((el.controller as TypeControlElController), false)
			} else {
				visibilityDelegate.apply((el.controller as TypeControlElController), true)
				createAttributes(el.getTypeAttributes)
			}
			var visibility = false
			if (elements.size > 1){
				visibility = true 
			} else 
				visibility = false				
			for (ctrl : elements){ // concurrent modification?
				ctrl.deleteVisible = visibility 
			}
		}
	}

	override getSelection() {
		selection
	}

	override HashMap<String, List<ILink>> getLinks() {
		var result = newHashMap()
		for (type : elements){
			var name = type.name
			var typeR = type.getLink(name)
			if (typeR !== null){ //TODO: if may be obsolete
				result.put(name,typeR)
			}
		}
		result
	}

	override List<ILink> getSelectedLink() {
		if (selection<elements.size){
			elements.get(selection).links.values.toList
		}
	}

	def setLinkTo(String typeName, ILink link){
		for (el : elements){            //TODO: [05.07.21] replace by HashMap with typeID
			if (el.name.equals(typeName))
				el.addLink = link
		}
	}

	def List<TypeElement> getAllTypes(){
		return elements
	}

	override toString() {
		return '''NodeType: «selectedLink» Sel:«selection»''';
	}

	def updateTypes(HashMap<String, ITypeAttributes> map) {
		typeInfo.updateTypes(map)  // is already updated
		for (type : allTypes){
			for (info: map.keySet)
				if (info.equals(type.typeName))
					type.setTypeAttributes = map.get(info)
		}
	}

	override postProcess(ILinkObj precessor, List<ITypeAttributes> attribs, ImplicitRulesOnDict grammar) {
		var token = (parent as ILinkObj).token
		dictAccess.processPrefix(token.name.toLowerCase, attribs)
		dictAccess.processSuffix(token.name.toLowerCase, attribs)
		
		//grammar.solve((parent as ILinkObj).token)

//		if(links !== null){
		for (type : elements){ //TODO: make lambda funct with map
			if (type.links !== null && !type.links.empty){			// check links per type - not globally
				if (precessor!== null && selection == type.index){
					var intAttribs = new ArrayList<ITypeAttributes>(attribs)
					intAttribs.add(type.typeAttributes)
					var pT = precessor.token 
					if (pT.internalType.typeInfo !== null){
						dictAccess.addSuccessor(pT.generateTokenInfo,   //TODO:11.04.2022 inconsistent Interface
							new DictItem(token.label, token.internalType.name, type.name, type.typeAttributes.baseNode.id), #{type.name}, intAttribs
						)
						val HashMap<String, ITypeAttributes> map = newHashMap
						dictAccess.getLinkTypes(token.name, _WORD, true).types.forall[ v | map.put(v.key, v.value) true]
						updateTypes(map)
					}
				}
			}
		}



	}
	
	



}
