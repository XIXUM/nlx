/**
 * 
 */
package org.xixum.nlx.view.fxviews.access;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeHierarchy;
import org.xixum.nlx.view.fxviews.semantics.ILink;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkType;
import de.validas.spedit.naturalLang.AllElements;
import org.xixum.utils.data.lists.IAppendable;
import org.xixum.utils.data.lists.IIndexable;
import org.xixum.utils.data.lists.IContainable;
import org.xixum.utils.data.types.XPair;
import javafx.scene.Node;
import org.xixum.nlx.dictionary.DictItem;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.grammar.token.IGrammarItem;
import org.xixum.nlx.dictionary.grammar.types.IGrammarType;

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
