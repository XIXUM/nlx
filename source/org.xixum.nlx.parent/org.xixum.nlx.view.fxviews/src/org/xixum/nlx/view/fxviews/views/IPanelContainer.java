/**
 * 
 */
package org.xixum.nlx.view.fxviews.views;

import java.util.List;

import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.view.fxviews.control.ICanvasController;
import org.xixum.nlx.view.fxviews.control.IController;
import org.xixum.nlx.view.fxviews.semantics.ILink;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.IListener;
import org.xixum.nlx.view.fxviews.semantics.SemanticLink;
import org.xixum.utils.data.lists.LinkedList;

/**
 * @author schaller
 *
 */
public interface IPanelContainer {

	ICanvasController getCanvasController();

	ISemanticTrainViewPart getViewPart();

	LinkedList<ILinkObj> getPanelChain();
	
	IController getController();
	
	ClassLoader getFxClassLoader();

	IListener getLinkListener();
	
	List<ILink> getLinkBuffer();

	void addLinkBuffer(ILink semanticLink);

	boolean isPostprocess();
	
	//ImplicitRulesOnDict getImplicitGrammar();

}
