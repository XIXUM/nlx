<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/access/elements/FragmentItem.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.access.elements;

import de.validas.nlx.dictionary.IDictionaryAccess;
import de.validas.nlx.view.fxviews.access.IItem;
import de.validas.spedit.naturalLang.Word;

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
=======
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
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/access/elements/FragmentItem.java
