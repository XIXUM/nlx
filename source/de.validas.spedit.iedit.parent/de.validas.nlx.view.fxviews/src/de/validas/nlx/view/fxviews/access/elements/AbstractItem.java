/**
 * 
 */
package de.validas.nlx.view.fxviews.access.elements;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.validas.nlx.dictionary.DictItem;
import de.validas.nlx.dictionary.IDictionaryAccess;
import de.validas.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.dictionary.type.ITypeHierarchy;
import de.validas.nlx.view.fxviews.access.IItem;
import de.validas.nlx.view.fxviews.access.IJavaFxObj;
import de.validas.nlx.view.fxviews.semantics.ILink;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.ILinkType;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.spedit.naturalLang.AllElements;
import de.validas.spedit.naturalLang.WordShort;
import de.validas.utils.data.lists.AbstractAppendable;
import de.validas.utils.data.lists.IAppendable;
import de.validas.utils.data.lists.IContainable;
import de.validas.utils.data.lists.LinkedList;
import de.validas.utils.data.types.XPair;
import javafx.scene.Node;

/**
 * @author schaller
 *
 */
public abstract class AbstractItem extends AbstractAppendable implements IItem {

	protected EObject element;
	protected IJavaFxObj parent;
	protected ILinkType type;
	protected LinkedList<? extends IAppendable> container;
	protected int index;
	/**
	 * Abstract Class for Items
	 */
	public AbstractItem(EObject el) {
		this.element = el;
	}
	
	public AbstractItem() {
		this.element = null;
	}

	@Override
	public abstract String getName();

	@Override
	public String getSelectedItem() {
		
		return null;
	}

	@Override
	public void postProcess(ImplicitRulesOnDict grammar) {
		if (grammar!= null)
			grammar.solve(this);
		else
			System.out.print("grammar:null"); //TODO: 02.12.22 use logger from grammar
	}

	
	@Override
	public void setParent(IJavaFxObj nodePanel) {
		this.parent = nodePanel;
		if (type!= null)
			this.type.setParent((ILinkable) nodePanel);  //TODO: 01.03.22 parent should be Item not Panel
	}
	
	@Override
	public IJavaFxObj getParent( ) {
		return parent;
	}
	
	@Override
	public ILinkType getInternalType() {
		return type;
	}
	
	@Override
	public String toString() {
		return type.toString();
	}

	/**
	 * @return the element
	 */
	public EObject getElement() {
		return element;
	}
	
	@Override
	public void newType() {
		//stub
	}
	
	@Override
	public long generateID() {
		org.neo4j.driver.v1.types.Node node = getBaseNode();
		if (node == null) return -1;
		
		return node.id();
		
	}
	
	@Override
	public void setLinkTo(String type, ILink link) {
		//stub
	}
	
	public abstract List<XPair<String, ITypeAttributes>> getTypes();

	@Override
	public LinkedList<? extends IAppendable> getContainer() {
		// TODO Auto-generated method stub
		return container;
	}

	@Override
	public <E extends IAppendable> void setContainer(LinkedList<E> linkedList) {
		this.container = linkedList;
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
		
	}

}
