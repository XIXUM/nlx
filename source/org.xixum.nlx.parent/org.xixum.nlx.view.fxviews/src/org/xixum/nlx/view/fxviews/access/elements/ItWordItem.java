/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

package org.xixum.nlx.view.fxviews.access.elements;

import static org.xixum.nlx.dictionary.constants.DictionaryConstants._IT_WORD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.semantics.types.LiteralType;
import org.xixum.nlx.naturalLang.ItWord;

/**
 * @author schaller
 *
 */
public class ItWordItem extends BasicItem {
	
	protected static final String CSS_CLASS = "panelYellow";
	protected String name;

	/**
	 * @param el
	 */
	protected ItWordItem(ItWord el) {
		super(el);
		if (el instanceof ItWord) {
			this.name = IterableExtensions.join(((ItWord) el).getWord(), "");
			this.type = new LiteralType(_IT_WORD, (ILinkable) parent);
		}
	}

	public static Collection<IItem> create(ItWord el) {
		return new ArrayList<IItem>(Collections.singletonList(new ItWordItem(el)));
	}

	@Override
	public String getCssClass() {
		return CSS_CLASS;
	}

	@Override
	public String getName() {
		
		return name;
	}


}
