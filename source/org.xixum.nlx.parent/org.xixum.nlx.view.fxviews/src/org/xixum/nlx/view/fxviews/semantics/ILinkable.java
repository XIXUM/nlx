/**
 * (c) XIXUM.ORG - all rights reserved
 */

package org.xixum.nlx.view.fxviews.semantics;

import java.util.List;
import java.util.Map;

import org.xixum.nlx.dictionary.grammar.types.IGrammarType;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.view.fxviews.views.IPanelContainer;
import org.xixum.utils.data.types.XPair;

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
