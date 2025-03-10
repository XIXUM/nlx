/**
 * 
 */
package org.xixum.nlx.view.fxviews.access.elements;

import static org.xixum.nlx.dictionary.constants.DictionaryConstants._UNIT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import org.xixum.nlx.dictionary.DictItem;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeHierarchy;
import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.types.UnitType;
import de.validas.spedit.naturalLang.Unit;
import org.xixum.utils.data.types.XPair;
import javafx.scene.Node;

/**
 * @author schaller
 *
 */
public class UnitItem extends AbstractItem {

	String value; 
	/**
	 * @param el
	 */
	protected UnitItem(Unit el) {
		super(el);
		this.value = IterableExtensions.join(((Unit) el).getValue(), "");
		this.type = new UnitType(_UNIT, el.getUnit());
	}

//	@Override
//	public List<String> getItems() {
//		return null;
//	}

	@Override
	public String getName() {
		return value;
	}
	
	@Override
	public String getLabel() {
		return value;
	}

	@Override
	public String getCssClass() {
		return null;
	}

	@Override
	public Node instantiateTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ITypeHierarchy> getWordTypes() {
		return Collections.EMPTY_LIST;
	}

//	@Override
//	public void postProcess(ImplicitRulesOnDict grammar) {
//		// stub
//		
//	}

	@Override
	public List<XPair<String, ITypeAttributes>> getTypes() {
		return null;
	}

	/**
	 * shall return representative database node for Item
	 */
	@Override
	public org.neo4j.driver.v1.types.Node getBaseNode() {
		return null;
	}

	@Override
	public DictItem generateTokenInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * Factory Method for Class UnitItem
	 * @param el
	 * @return
	 */
	public static Collection<IItem> create(Unit el) {
		
		return new ArrayList<IItem>(Collections.singletonList(new UnitItem(el)));
	}
}
