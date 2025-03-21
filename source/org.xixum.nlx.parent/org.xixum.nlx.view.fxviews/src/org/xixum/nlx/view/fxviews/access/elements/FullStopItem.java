<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/access/elements/FullStopItem.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.access.elements;


import static de.validas.nlx.view.fxviews.access.ItemType.FULLSTOP;

import java.util.Collections;
import java.util.List;

import de.validas.nlx.dictionary.IDictionaryAccess;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.dictionary.type.ITypeHierarchy;
import de.validas.nlx.view.fxviews.access.IItem;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.types.InterpunctionType;
import de.validas.spedit.naturalLang.Elements;
import javafx.scene.Node;

import static de.validas.nlx.view.fxviews.semantics.constants.GrammarConstants._FULL_STOP;

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
=======
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
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/access/elements/FullStopItem.java
