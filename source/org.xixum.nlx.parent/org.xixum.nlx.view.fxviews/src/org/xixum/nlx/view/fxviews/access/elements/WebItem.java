<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/access/elements/WebItem.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.access.elements;

import static de.validas.nlx.view.fxviews.semantics.constants.WebTypeConstants._EMAIL;
import static de.validas.nlx.view.fxviews.semantics.constants.WebTypeConstants._URL;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import de.validas.nlx.view.fxviews.access.IItem;
import de.validas.nlx.view.fxviews.semantics.types.WebType;
import de.validas.spedit.naturalLang.MailAdress;
import de.validas.spedit.naturalLang.NoNElement;
import de.validas.spedit.naturalLang.UrlAdress;

/**
 * @author schaller
 *
 */
public class WebItem extends BasicItem implements IItem {

	/**
	 * @param el
	 */
	public WebItem(NoNElement el) {
		super(el);
		if(el instanceof UrlAdress) {
			this.name = IterableExtensions.join(((UrlAdress)el).getUrl(), "");
			this.type = new WebType(_URL);
		} else if (el instanceof MailAdress) {
			this.name = IterableExtensions.join(((MailAdress) el).getEmail(), "");
			this.type = new WebType(_EMAIL);
		}
	}

	public static IItem create(NoNElement el) {
		return new WebItem(el);
	}

}
=======
/**
 * 
 */
package org.xixum.nlx.view.fxviews.access.elements;

import static org.xixum.nlx.view.fxviews.semantics.constants.WebTypeConstants._EMAIL;
import static org.xixum.nlx.view.fxviews.semantics.constants.WebTypeConstants._URL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.view.fxviews.semantics.types.WebType;
import org.xixum.nlx.naturalLang.MailAdress;
import org.xixum.nlx.naturalLang.NoNElement;
import org.xixum.nlx.naturalLang.UrlAdress;

/**
 * @author schaller
 *
 */
public class WebItem extends BasicItem {

	/**
	 * @param el
	 */
	public WebItem(NoNElement el) {
		super(el);
		if(el instanceof UrlAdress) {
			this.name = IterableExtensions.join(((UrlAdress)el).getUrl(), "");
			this.type = new WebType(_URL);
		} else if (el instanceof MailAdress) {
			this.name = IterableExtensions.join(((MailAdress) el).getEmail(), "");
			this.type = new WebType(_EMAIL);
		}
	}

	public static Collection<IItem> create(NoNElement el) {
		return new ArrayList<IItem>(Collections.singletonList(new WebItem(el)));
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/access/elements/WebItem.java
