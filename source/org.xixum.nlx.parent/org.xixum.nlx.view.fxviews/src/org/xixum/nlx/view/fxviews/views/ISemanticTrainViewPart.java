<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/views/ISemanticTrainViewPart.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.views;

import java.util.List;

import org.eclipse.ui.IViewPart;

import de.validas.nlx.constants.Direction;
import de.validas.nlx.dictionary.IDictionaryAccess;
import de.validas.nlx.dictionary.type.ITypeHierarchy;
import de.validas.nlx.view.fxviews.access.IPanelsAccessor;
import de.validas.nlx.view.fxviews.cache.INodeCacheManager;
import de.validas.nlx.view.fxviews.control.IDragController;
import de.validas.nlx.view.fxviews.control.SemanticFxViewController;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.semantics.LinkProcessor;
import de.validas.nlx.view.fxviews.semantics.SemanticLinker;
import de.validas.nlx.view.fxviews.views.SemanticFxViewPart.UpdateMessage;
import de.validas.nlx.view.fxviews.views.SemanticFxViewPart.UpdateTask;
import de.validas.utils.data.lists.LinkedList;
import javafx.scene.layout.HBox;

/**
 * @author schaller
 *
 */
public interface ISemanticTrainViewPart extends IViewPart{
	
	public void createPanels(IPanelsAccessor accessor, SemanticFxViewPart.UpdateMessage update);
	
	public LinkedList<ILinkObj> getPanelChain() ;	
	
	public SemanticFxViewController getCanvasController(); 

	public IDragController getDragController();

	public void connectNode(ILinkable sourcePanel, ILinkable parentPanel, Direction dir);  
	
	public IDictionaryAccess getDictAccess();

	public LinkProcessor getProcessor();

	public SemanticLinker getSemanticLinker();

	public List<ITypeHierarchy> getTypeHierarchy();

	public INodeCacheManager cacheManager();

	public void setPanelStack(IPanelsAccessor panelsAccessor,  UpdateMessage updateMSG);

	public UpdateTask<Boolean> getCreatePanelsTask(); 
	
	public Thread getBackgroundThread();

	public void setBackgroundThread(Thread bgThread);
	
	public String getBgThreadName();

}
=======
/**
 * 
 */
package org.xixum.nlx.view.fxviews.views;

import java.util.List;

import org.eclipse.ui.IViewPart;

import org.xixum.nlx.constants.Direction;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.type.ITypeHierarchy;
import org.xixum.nlx.view.fxviews.access.IPanelsAccessor;
import org.xixum.nlx.view.fxviews.cache.INodeCacheManager;
import org.xixum.nlx.view.fxviews.control.IDragController;
import org.xixum.nlx.view.fxviews.control.SemanticFxViewController;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.semantics.LinkProcessor;
import org.xixum.nlx.view.fxviews.semantics.SemanticLinker;
import org.xixum.nlx.view.fxviews.views.SemanticFxViewPart.UpdateMessage;
import org.xixum.nlx.view.fxviews.views.SemanticFxViewPart.UpdateTask;
import org.xixum.utils.data.lists.LinkedList;
import javafx.scene.layout.HBox;

/**
 * @author schaller
 *
 */
public interface ISemanticTrainViewPart extends IViewPart{
	
	public void createPanels(IPanelsAccessor accessor, SemanticFxViewPart.UpdateMessage update);
	
	public LinkedList<ILinkObj> getPanelChain() ;	
	
	public SemanticFxViewController getCanvasController(); 

	public IDragController getDragController();

	public void connectNode(ILinkable sourcePanel, ILinkable parentPanel, Direction dir);  
	
	public IDictionaryAccess getDictAccess();

	public LinkProcessor getProcessor();

	public SemanticLinker getSemanticLinker();

	public List<ITypeHierarchy> getTypeHierarchy();

	public INodeCacheManager cacheManager();

	public void setPanelStack(IPanelsAccessor panelsAccessor,  UpdateMessage updateMSG);

	public UpdateTask<Boolean> getCreatePanelsTask(); 
	
	public Thread getBackgroundThread();

	public void setBackgroundThread(Thread bgThread);
	
	public String getBgThreadName();

	public ImplicitRulesOnDict getImplicitGrammar();

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/views/ISemanticTrainViewPart.java
