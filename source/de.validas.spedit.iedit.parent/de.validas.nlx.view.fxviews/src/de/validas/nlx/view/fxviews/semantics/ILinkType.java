package de.validas.nlx.view.fxviews.semantics;

import java.util.HashMap;
import java.util.List;

import de.validas.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import de.validas.nlx.dictionary.grammar.types.IGrammarType;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.utils.data.types.XPair;

public interface ILinkType extends IGrammarType{
	public String getNameClamped();
	public void setParent(ILinkable nodePanel);
	public ILinkable getParent();
	public void newType();
	public int getSelection();
	public void setSelection(int selection);
	public HashMap<String, List<ILink>> getLinks();
	public List<ILink> getSelectedLink();
	public void postProcess(ILinkObj precessor, List<ITypeAttributes> attribs, ImplicitRulesOnDict grammar);
	public List<XPair<String, ITypeAttributes>> getTypeEls(); 
}
