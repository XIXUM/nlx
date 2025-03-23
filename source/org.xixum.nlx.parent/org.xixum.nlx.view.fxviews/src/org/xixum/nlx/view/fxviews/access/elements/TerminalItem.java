/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

package org.xixum.nlx.view.fxviews.access.elements;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.neo4j.driver.v1.types.Node;

import org.xixum.nlx.constants.TokenPosition;
import org.xixum.nlx.dictionary.DictItem;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeHierarchy;
import org.xixum.nlx.view.fxviews.access.IItem;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkType;
import org.xixum.nlx.view.fxviews.semantics.types.InterpunctionType;
import org.xixum.utils.data.lists.IAppendable;
import org.xixum.utils.data.types.XPair;

/**
 * @author schaller
 *
 */
public class TerminalItem extends SmallItem {
	
	//private final static String FULL_STOP = ".";
	protected static final String CSS_CLASS = "panelDRed";
	protected TokenPosition position;

	/**
	 * @param el
	 */
	protected TerminalItem(EObject el, ILinkType type, TokenPosition pos) {
		super(el);
		this.type = type;  //TODO: 29.03.22 consider empty Type instead of NULL
		this.position = pos;
		//this.type = new InterpunctionType(el, FULLSTOP);
	}

	/* (non-Javadoc)
	 * @see org.xixum.nlx.view.fxviews.access.elements.AbstractItem#getName()
	 */
	@Override
	public String getName() { //TODO: <- should be labelProvider
		if (type != null) {
			if (type instanceof InterpunctionType) {
				String inner = ((InterpunctionType) type).getBaseType().getKey();
				if (inner == null) 
					return ((InterpunctionType) type).getCathegory().name();
				return inner;
			}
			return type.getName();
		} else
			return position.toString(); //@Deprecated
	}
	
	/**
	 * Label Provider
	 */
	@Override
	public String getLabel() {
		return type.getBaseType().getKey();	
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

	@Override
	public void postProcess(ImplicitRulesOnDict grammar) { //TODO: 29.09.22 redundant with ShortCutItem introduce intermediate class Layer for common routines
		super.postProcess(grammar);
		if (type != null) {
			IAppendable precessor = getPrecessor();
			if (precessor != null) {
				List<ITypeAttributes> attribs = new ArrayList<>();
				type.postProcess((ILinkObj) ((IItem)precessor).getParent(), attribs, grammar);
			}
		}
	}
	
	/**
	 * @return the position
	 */
	public TokenPosition getPosition() {
		return position;
	}

	@Override
	public Node getBaseNode() {
		return ((InterpunctionType)type).getNode();
	}

	@Override
	public DictItem generateTokenInfo() {
		if (type instanceof InterpunctionType) {  //TODO: 13.04.22 inconsistent interface, avoid this check
			TokenPosition pos = getPosition();
			switch (pos){
				case INTERMEDIATE:	{
					return new DictItem(((InterpunctionType)type).getCathegory().name(), type.getName(), generateID());	
				}
				case START:
				case END:{ 
					return new DictItem(pos.toString(), type.getName(), generateID());	
				}
				//TODO: 13.04.22 create default state
			}
		} 
		return null;
	}
	
	@Override
	public List<XPair<String, ITypeAttributes>> getTypes() {
		return Collections.singletonList(((InterpunctionType) type).getBaseType());
	}
	
	@Override
	public long generateID(){
		
		if (type instanceof InterpunctionType) {
			Node node = ((InterpunctionType)type).getNode();
			return node != null ? node.id() : -1;  //TODO: null-safe should be obsolete here...
		}
		return -1;
	}
	
	/**
	 * Static Factory method
	 * @param el
	 * @param type
	 * @return
	 */
	public static IItem create(EObject el, ILinkType type, TokenPosition pos) {
		return new TerminalItem(el, type, pos);
	}

}
