<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/access/elements/KommaItem.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.access.elements;

import static de.validas.nlx.view.fxviews.access.ItemType.KOMMA;
import static de.validas.nlx.view.fxviews.semantics.constants.GrammarConstants._KOMMA;

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

/**
 * @author schaller
 *
 */
public class KommaItem extends TerminalItem {
	
	protected static final String CSS_CLASS = "panelLRed";
	//private IDictionaryAccess dictAccess;


	/**
	 * @param el
	 */
	protected KommaItem(Elements el, IDictionaryAccess dictAccess) {
		super(el, new InterpunctionType(el, KOMMA, ",", dictAccess), TokenPosition.INTERMEDIATE);
		//this.type = new InterpunctionType(el, KOMMA, dictAccess);
	}

	public static IItem create(IDictionaryAccess dictAccess) {
		return new KommaItem(null, dictAccess);
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
	
	
	//TODO: 06.04. create individual label provider
//	@Override
//	public String getName() { // <- labelProvider
//		if (type != null) {
//			if (type instanceof InterpunctionType) {
//				String inner = ((InterpunctionType) type).getBaseType().getKey();
//				if (inner == null) 
//					return ((InterpunctionType) type).getCathegory().name();
//				return inner;
//			}
//			return type.getName();
//		} else
//			return position.toString(); //@Deprecated
//	}

}
=======
/**
 * 
 */
package org.xixum.nlx.view.fxviews.access.elements;

import static org.xixum.nlx.dictionary.grammar.types.ItemType.KOMMA;

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
public class KommaItem extends TerminalItem {
	
	protected static final String CSS_CLASS = "panelLRed";
	//private IDictionaryAccess dictAccess;


	/**
	 * @param el
	 */
	protected KommaItem(Elements el, IDictionaryAccess dictAccess) {
		super(el, new InterpunctionType(el, KOMMA, ",", dictAccess), TokenPosition.INTERMEDIATE);
		//this.type = new InterpunctionType(el, KOMMA, dictAccess);
	}

	public static IItem create(IDictionaryAccess dictAccess) {
		return new KommaItem(null, dictAccess);
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
	
	
	//TODO: 06.04. create individual label provider
//	@Override
//	public String getName() { // <- labelProvider
//		if (type != null) {
//			if (type instanceof InterpunctionType) {
//				String inner = ((InterpunctionType) type).getBaseType().getKey();
//				if (inner == null) 
//					return ((InterpunctionType) type).getCathegory().name();
//				return inner;
//			}
//			return type.getName();
//		} else
//			return position.toString(); //@Deprecated
//	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/access/elements/KommaItem.java
