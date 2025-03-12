/**
 * 
 */
package org.xixum.nlx.view.fxviews.access.elements;

import static org.xixum.nlx.dictionary.grammar.types.ItemType.SEPARATOR;

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
public class SeparatorItem extends TerminalItem {
	
	protected static final String CSS_CLASS = "panelDRed"; //TODO: externalize this
	
	//protected String separator;

	/**
	 * @param el
	 */
	public SeparatorItem(Elements el, String separator, IDictionaryAccess dictAccess) {
		super(el, new InterpunctionType(el, SEPARATOR, separator, dictAccess), TokenPosition.INTERMEDIATE);
		//this.separator = separator;
		//this.type = new InterpunctionType(el, SEPARATOR, separator, dictAccess);
	}

	
	@Override
	public String getCssClass() {
		return CSS_CLASS;
	}

	@Override
	public String getName() {
		return ((InterpunctionType)type).getCathegory().name();
	}


//	@Override
//	public Node instantiateTypes() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ITypeHierarchy> getWordTypes() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * static factory method
	 * @param separator
	 * @param dictAccess
	 * @return
	 */
	public static IItem create(String separator, IDictionaryAccess dictAccess) {
		return new SeparatorItem(null, separator, dictAccess);
	}

}
