<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/semantics/ILinkable.java
package de.validas.nlx.view.fxviews.semantics;

import java.util.List;
import java.util.Map;

import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.view.fxviews.views.IPanelContainer;
import de.validas.utils.data.types.XPair;

/**
 * @author schaller
 *
 */
public interface ILinkable {

	void setLink(String type, ILink link);

	public ILinkType getLinkType();
	
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
=======
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
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/semantics/ILinkable.java
