package de.validas.nlx.view.fxviews.semantics;

import java.util.List;
import java.util.Map;

import de.validas.nlx.dictionary.grammar.types.IGrammarType;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.view.fxviews.views.IPanelContainer;
import de.validas.utils.data.types.XPair;

/**
 * @author schaller
 *
 */
public interface ILinkable {

	void setLink(String type, ILink link);

	public IGrammarType getLinkType();
	
	public IPanelContainer getCanvas();

	public String getName();

	public abstract List<XPair<String, ITypeAttributes>> getTypes();

	XPair<String, ITypeAttributes> getType();
	
	public List<ILink> getLink();

	public int getLowerBound();
	
	public int getHigherBound();

	public int getCardinality();

	Map<? extends String, ? extends Object> getIntermediate();
	
}
