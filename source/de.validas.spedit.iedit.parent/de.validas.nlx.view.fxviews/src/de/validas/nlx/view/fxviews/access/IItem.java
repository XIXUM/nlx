/**
 * 
 */
package de.validas.nlx.view.fxviews.access;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.dictionary.type.ITypeHierarchy;
import de.validas.nlx.view.fxviews.semantics.ILink;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.ILinkType;
import de.validas.spedit.naturalLang.AllElements;
import de.validas.utils.data.lists.IAppendable;
import de.validas.utils.data.lists.IIndexable;
import de.validas.utils.data.lists.IContainable;
import de.validas.utils.data.types.XPair;
import javafx.scene.Node;
import de.validas.nlx.dictionary.DictItem;
import de.validas.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import de.validas.nlx.dictionary.grammar.token.IGrammarItem;
import de.validas.nlx.dictionary.grammar.types.IGrammarType;

/**
 * @author schaller
 *
 */
public interface IItem extends IGrammarItem {

	String getSelectedItem();

	String getCssClass();

	void setParent(IJavaFxObj nodePanel);
	
	IJavaFxObj getParent();

	Node instantiateTypes();
	
	void postProcess(ImplicitRulesOnDict grammar);

	void newType();

	void setLinkTo(String type, ILink link);

	public abstract Collection<? extends ITypeHierarchy> getWordTypes();

	List<XPair<String, ITypeAttributes>> getTypes();

	public abstract DictItem generateTokenInfo();

}
