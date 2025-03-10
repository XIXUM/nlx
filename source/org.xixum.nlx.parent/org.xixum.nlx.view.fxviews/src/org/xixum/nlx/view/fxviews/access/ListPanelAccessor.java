/**
 * 
 */
package org.xixum.nlx.view.fxviews.access;

import static org.xixum.nlx.dictionary.constants.DictionaryConstants._NONE_TYPE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.xixum.nlx.dictionary.DictItem;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeHierarchy;
import org.xixum.nlx.view.fxviews.access.elements.AbstractItem;
import org.xixum.nlx.view.fxviews.semantics.ILink;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkType;
import org.xixum.nlx.view.fxviews.semantics.types.LiteralType;
import org.xixum.nlx.view.fxviews.visual.NodePanel;
import de.validas.spedit.naturalLang.AllElements;
import org.xixum.utils.data.lists.LinkedList;
import org.xixum.utils.data.types.XPair;
import javafx.beans.value.ChangeListener;
import javafx.scene.Node;

/**
 * @author schaller
 *
 */
public class ListPanelAccessor extends AbstractPanelAccessor {

	

	public class Item extends AbstractItem {
		protected String name;
		protected List<String> items;
		protected int selection;
		protected ChangeListener<? super String> listener;
		protected NodePanel parent;
		
		protected final ILinkType OBJ_NONETYPE = new LiteralType(_NONE_TYPE, null);
		
		protected static final String CSS_CLASS = "panelYellow";

		public Item(String name, List<String> items, int selection) {
			super();
			this.name = name;
			this.items = items;
			this.selection = selection;
			this.listener = (obs, oldItem, newItem) -> {
				if (newItem != null) {
					setSelection(newItem);
				}
			};
		}

		/**
		 * @return the items
		 */
		public List<String> getItems() {
			return items;
		}

		/**
		 * @return the selection
		 */
		public int getSelection() {
			return selection;
		}

		/**
		 * @param selection the selection to set
		 */
		public void setSelection(int selection) {
			this.selection = selection;
		}

		public String getSelectedItem() {
			return items.get(selection);
		}

		public void setSelection(String key) { //TODO: replace this by a HashMap
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).equals(key)) {
					selection = i;
					return;
				}	
			}
			// else do not change if key not found
		}

		public ChangeListener<? super String> getSelectionChangedListener() {
			return listener;
		}

		public void setSelectionChangedListener(ChangeListener<? super String> listener) {
			this.listener = listener;
		}

		@Override
		public String getCssClass() {
			return CSS_CLASS;
		}

		/**
		 * @return the parent
		 */
		public NodePanel getParent() {
			return parent;
		}

		/**
		 * @param parent the parent to set
		 */
		public void setParent(IJavaFxObj parent) {
			this.parent = (NodePanel) parent;
		}

		@Override
		public ILinkType getInternalType() {
			return OBJ_NONETYPE;
		}

		@Override
		public AllElements getElement() {
			return null;
		}

		@Override
		public Node instantiateTypes() {
			// method stub
			return null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<ITypeHierarchy> getWordTypes() {
			return Collections.EMPTY_LIST;
		}

		@Override
		public void newType() {
			//method stub
		}

		@Override
		public void setLinkTo(String type, ILink link) {
			//method stub
		}

		@Override
		public void postProcess(ImplicitRulesOnDict grammar) {
			// method stub
			
		}

		@Override
		public List<XPair<String, ITypeAttributes>> getTypes() {
			return null;
		}

		@Override
		public org.neo4j.driver.v1.types.Node getBaseNode() {
			// method stub
			return null;
		}
		
		public long generateID()
		{
			return -1;
		}

		@Override
		public DictItem generateTokenInfo() {
			return null;
		}

		@Override
		public String getLabel() {
			// TODO Auto-generated method stub
			return name;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}

	}

	/**
	 * @param list
	 * @param demoList
	 * 
	 */
	public ListPanelAccessor(List<String> items, List<String> list) {
		tokenChain = new LinkedList<>();

		for (String token : list) {
			tokenChain.add(new Item(token, items, 0));
		}
	}
}
