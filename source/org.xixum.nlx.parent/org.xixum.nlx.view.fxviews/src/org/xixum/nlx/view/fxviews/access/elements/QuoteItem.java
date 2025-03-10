/**
 * 
 */
package org.xixum.nlx.view.fxviews.access.elements;

import static org.xixum.nlx.dictionary.constants.DictionaryConstants._QUOTE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.semantics.types.LiteralType;
import de.validas.spedit.naturalLang.Quote;

/**
 * @author schaller
 *
 */
public class QuoteItem extends BasicItem {

	/**
	 * @param el
	 */
	protected QuoteItem(Quote el) {
		super(el);
		this.name = el.getQuote();
		this.type = new LiteralType(_QUOTE, (ILinkable) parent);
	}
	
	/**
	 * Factory for Class
	 * @param el
	 * @return QuoteItem
	 */
	public static Collection<IItem> create(Quote el) {
		return new ArrayList<IItem>(Collections.singletonList(new QuoteItem(el)));
	}

}
