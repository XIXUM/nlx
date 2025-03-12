/**
 * 
 */
package org.xixum.nlx.view.fxviews.access.elements;

import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.naturalLang.Word;

/**
 * @author schaller
 *
 */
public class FragmentItem extends WordItem {

	// protected String fragment;

	/**
	 * @param el
	 * @param dictAccess
	 */
	public FragmentItem(Word el, String fragment, IDictionaryAccess dictAccess) {
		super(el, dictAccess);
		this.name = fragment;
	}

	@Override
	public String getCssClass() {
		// set default color
		return null;
	}

	public static IItem create(Word el, String fragment, IDictionaryAccess dictAccess) {
		FragmentItem item = new FragmentItem(el, fragment, dictAccess);
		item.loadDictionary();
		return item;
	}

}
