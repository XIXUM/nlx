/**
 * 
 */
package org.xixum.nlx.view.fxviews.access.elements;


import static org.xixum.nlx.dictionary.grammar.types.ItemType.FULLSTOP;

import java.util.Collections;
import java.util.List;

import org.xixum.nlx.constants.TokenPosition;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.type.ITypeHierarchy;
import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.view.fxviews.semantics.types.InterpunctionType;
import org.xixum.nlx.naturalLang.Elements;

/**
 * @author schaller
 *
 */
public class FullStopItem extends TerminalItem {
	
	protected static final String CSS_CLASS = "panelDRed";
	//private IDictionaryAccess dictAccess;

	/**
	 * @param el
	 */
	protected FullStopItem(Elements el, IDictionaryAccess dictAccess) {
		super(el, new InterpunctionType(el, FULLSTOP, dictAccess), TokenPosition.INTERMEDIATE);
	}

	public static IItem create(IDictionaryAccess dictAccess) {
		return new FullStopItem(null, dictAccess);
	}

	@Override
	public String getCssClass() {
		return CSS_CLASS;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ITypeHierarchy> getWordTypes() {
		return Collections.EMPTY_LIST;
	}

}
