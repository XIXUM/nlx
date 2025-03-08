/**
 * 
 */
package de.validas.nlx.view.fxviews.access.elements;

import static de.validas.nlx.view.fxviews.semantics.constants.FxViewConstants._REGEX_ALPHA_CAPITAL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import de.validas.nlx.dictionary.IDictionaryAccess;
import de.validas.nlx.view.fxviews.access.IItem;
import de.validas.spedit.naturalLang.Word;
import de.validas.spedit.naturalLang.WordShort;

/**
 * @author schaller
 *
 */
public class WordItem extends ShortCutItem {
	
	/**
	 * @param el
	 * @param dictAccess 
	 */
	protected WordItem(WordShort el, IDictionaryAccess dictAccess) {
		super(el, dictAccess);
		if (el instanceof Word)
			this.name = IterableExtensions.join(((Word) el).getWord(), "");
	}
	
	public static Collection<IItem> create(WordShort el, IDictionaryAccess dictAccess) {
		EList<String> fragments = ((Word)el).getWord();
		if (el instanceof Word && fragments.size() > 1) {
			ArrayList<IItem> tokens = new ArrayList<IItem>();
			for(String fragment : fragments) {
				if (fragment.matches(_REGEX_ALPHA_CAPITAL)) {  //TODO: 24.08.22 difficult to rewrite DSL model here, because it adds another class layer inbetween
					tokens.add(FragmentItem.create((Word) el, fragment, dictAccess));
					
				} else {
					tokens.add(SeparatorItem.create(fragment, dictAccess));
				}
			}
			return tokens;
		} else {
			WordItem item = new WordItem(el, dictAccess);
			item.loadDictionary();
			return new ArrayList<IItem>(Collections.singletonList(item));
		}
	}

}
