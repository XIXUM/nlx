<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/semantics/util/AttribUtils.xtend
package de.validas.nlx.view.fxviews.semantics.util

import javafx.scene.layout.VBox
import org.neo4j.driver.v1.types.Node
import org.neo4j.driver.v1.types.Relationship
import javafx.scene.layout.HBox
import javafx.scene.control.Label
import javafx.scene.control.ComboBox

import static de.validas.nlx.constants.Neo4jConstants._NAME
import javafx.application.Platform

class AttribUtils {
	
	def static createAttrEntry(VBox box, Node source, Node target, Relationship relationship) {
		val hbox = new HBox()
		val label = new Label()
		val combo = new ComboBox()
		
		label.text = relationship.type
		combo.value = '''[«target.labels.get(0)»: «target.get(_NAME).asString»]'''
		if(Platform.fxApplicationThread){
			assign(label, combo, hbox, box)
		} else {
			Platform.runLater([|
				assign(label, combo, hbox, box)
			])
		}
	}
	
	def static assign(Label label, ComboBox<String> combo, HBox hbox, VBox box) {
		hbox.children.add(label)
		hbox.children.add(combo)
		box.children.add(hbox)
	}
	
=======
package org.xixum.nlx.view.fxviews.semantics.util

import javafx.scene.layout.VBox
import org.neo4j.driver.v1.types.Node
import org.neo4j.driver.v1.types.Relationship
import javafx.scene.layout.HBox
import javafx.scene.control.Label
import javafx.scene.control.ComboBox

import static org.xixum.nlx.constants.Neo4jConstants._NAME
import javafx.application.Platform

class AttribUtils {
	
	def static createAttrEntry(VBox box, Node source, Node target, Relationship relationship) {
		val hbox = new HBox()
		val label = new Label()
		val combo = new ComboBox()
		
		label.text = relationship.type
		combo.value = '''[«target.labels.get(0)»: «target.get(_NAME).asString»]'''
		if(Platform.fxApplicationThread){
			assign(label, combo, hbox, box)
		} else {
			Platform.runLater([|
				assign(label, combo, hbox, box)
			])
		}
	}
	
	def static assign(Label label, ComboBox<String> combo, HBox hbox, VBox box) {
		hbox.children.add(label)
		hbox.children.add(combo)
		box.children.add(hbox)
	}
	
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/semantics/util/AttribUtils.xtend
}