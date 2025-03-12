/**
 * 
 */
package org.xixum.nlx.view.fxviews.access.elements;

import static org.xixum.nlx.dictionary.constants.DictionaryConstants._IGNORED_TEXT;
import static org.xixum.nlx.dictionary.constants.DictionaryConstants._QUOTE;
import static org.xixum.nlx.dictionary.constants.DictionaryConstants._SYMBOLS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.xixum.nlx.dictionary.DictItem;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.grammar.token.IGrammarLiteral;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeHierarchy;
import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkType;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.semantics.types.LiteralType;
import org.xixum.nlx.naturalLang.AllElements;
import org.xixum.nlx.naturalLang.IgnoredText;
import org.xixum.nlx.naturalLang.Quote;
import org.xixum.nlx.naturalLang.Symbols;
import org.xixum.utils.data.types.XPair;
import javafx.scene.Node;


/**
 * @author schaller
 *
 */
public class BasicItem extends AbstractItem {
	
	//protected static final String CSS_CLASS = "";
	
	protected String name;
	
	/**
	 * @param el
	 */
	protected BasicItem(EObject el) {
		super(el);
		if (el instanceof IgnoredText) {
			this.name = ((IgnoredText)el).getIgnored();
			this.type = new LiteralType(_IGNORED_TEXT, (ILinkable) parent);
		} else if (el instanceof Symbols) {
			this.name = ((Symbols)el).getSymbol();
			this.type = new LiteralType(_SYMBOLS, (ILinkable) parent);
		}else if (el instanceof Quote) {
			this.name = ((Quote)el).getQuote();	
			this.type = new LiteralType(_QUOTE, (ILinkable) parent);
		}
	}

	/** (non-Javadoc)
	 * @see org.xixum.nlx.view.fxviews.access.elements.AbstractItem#getItems()
	 */
//	@Override
//	public List<String> getItems() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	/** (non-Javadoc)
	 * @see org.xixum.nlx.view.fxviews.access.elements.AbstractItem#getName()
	 */
	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public String getCssClass() {
		return null; 
	}

	@Override
	public ILinkType getInternalType() {
		return type;
	}
	
	@Override
	public String toString() {
		return String.format("name: \"%s\" type: \"%s\"", name, type.toString());
	}

	@Override
	public Node instantiateTypes() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ITypeHierarchy> getWordTypes() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public void newType() {
		//Stub
	}

	@Override
	public void postProcess(ImplicitRulesOnDict grammar) {
		super.postProcess(grammar);
	}

	@Override
	public List<XPair<String, ITypeAttributes>> getTypes() {
		return null;
	}

	@Override
	public org.neo4j.driver.v1.types.Node getBaseNode() {
		return null;
	}

	@Override
	public DictItem generateTokenInfo() {
		return null;
	}

	@Override
	public String getLabel() {
		return name;
	}
	
	public static Collection<IItem> create(AllElements el) {
		return new ArrayList<IItem>(Collections.singletonList(new BasicItem(el)));
	}

}
