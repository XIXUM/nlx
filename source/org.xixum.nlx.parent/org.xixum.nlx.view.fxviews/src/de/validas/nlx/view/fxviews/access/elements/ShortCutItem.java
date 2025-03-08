/**
 * 
 */
package de.validas.nlx.view.fxviews.access.elements;

import static de.validas.nlx.dictionary.constants.NodeConstants._WORD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.validas.nlx.dictionary.DictItem;
import de.validas.nlx.dictionary.IDictionaryAccess;
import de.validas.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.dictionary.type.ITypeHierarchy;
import de.validas.nlx.dictionary.type.ITypeInfo;
import de.validas.nlx.view.fxviews.access.IItem;
import de.validas.nlx.view.fxviews.access.IJavaFxObj;
import de.validas.nlx.view.fxviews.semantics.ILink;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.ILinkType;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.semantics.types.LiteralType;
import de.validas.nlx.view.fxviews.semantics.types.TypeElement;
import de.validas.nlx.view.fxviews.semantics.types.WordType;
import de.validas.nlx.view.fxviews.visual.NodePanel;
import de.validas.spedit.naturalLang.EString;
import de.validas.spedit.naturalLang.ShortCut;
import de.validas.utils.data.lists.IAppendable;
import de.validas.utils.data.types.XPair;
import javafx.scene.Node;

/**
 * @author schaller
 *
 */
public class ShortCutItem extends TypedItem { // TODO differentiate Items by derived Interfaces

	protected IDictionaryAccess dictAccess;

	protected static final String CSS_CLASS = "panelGreen";

	/**
	 * @param el
	 * @param dictAccess
	 */
	protected ShortCutItem(EObject el, IDictionaryAccess dictAccess) {
		super(el);
		this.dictAccess = dictAccess;

		if (el instanceof ShortCut)
			this.name = ((EString) ((ShortCut) el).getShortcut()).getShortcut();
	}

	/**
	 * Duplicate Method from:
	 * de.validas.spedit.validation.NaturalLangValidator.checkWordIsInDict(Elements)
	 * 
	 * @param name
	 * @return
	 */
	protected ILinkType getTypeFromDictionary(String name) {
		if (!dictAccess.isConnected())
			return null;
		if (type == null) {
			ITypeInfo info = dictAccess.getLinkTypes(name, _WORD);
			type =	new WordType(info, (ILinkable) parent, dictAccess); //TODO: maybe better set 'this' as parent
		}
		return type;
	}

	/**
	 * @return the dictAccess
	 */
	public IDictionaryAccess getDictAccess() {
		return dictAccess;
	}

	/**
	 * @return the selection
	 */
	public int getSelection() {
		return type.getSelection();
	}

	/**
	 * @param selection the selection to set
	 */
	public void setSelection(int selection) {
		type.setSelection(selection);
	}

	public void setSelection(String key) { // TODO: replace this by a HashMap
		int i = 0;
		if (type instanceof WordType) {
			for (TypeElement k : ((WordType)type).getAllTypes()) {
				if (k.getName().equals(key)) {
					type.setSelection(i);
					return;
				}
				i++;
			}
		}
		// else do not change if key not found
	}

	public void loadDictionary() {
		if (this.dictAccess != null) {
			this.type =  getTypeFromDictionary(this.name);
		}
	}

	@Override
	public String getCssClass() {
		return CSS_CLASS;
	}

	/* (non-Javadoc)
	 * @see de.validas.nlx.view.fxviews.access.elements.BasicItem#instantiateTypes()
	 */
	@Override
	public Node instantiateTypes() {
		// IObjController controller = (IObjController) parent.getController();
		if (type instanceof LiteralType) {
			return ((LiteralType)type).getRoot();
		} else 
			return null;
	}
	
	/**
	 * pipe to ViewPart. only used by TypeElement 
	 */
	@Override
	public List<ITypeHierarchy> getWordTypes() {
		IJavaFxObj parent = getParent();
		if (parent instanceof NodePanel) {
			return ((NodePanel) parent).getViewPart().getTypeHierarchy();
		}
		return null;
	}

	public void newType() {
		type.newType();
	}
	
	@Override
	public void setLinkTo(String typeName, ILink link) {
		if (type instanceof WordType){
			((WordType)type).setLinkTo(typeName, link);
		}
		
	}

	/* (non-Javadoc)
	 * @see de.validas.nlx.view.fxviews.access.elements.BasicItem#postProcess()
	 */
	@Override
	public void postProcess(ImplicitRulesOnDict grammar) {
		//ILinkType intType = getInternalType(); 
		super.postProcess(grammar);
		if (type != null) {
			IAppendable precessor = getPrecessor();
			if (precessor != null) {
				List<ITypeAttributes> attribs = new ArrayList<>();
				type.postProcess((ILinkObj) ((IItem)precessor).getParent(), attribs, grammar);
			}
		}
	}
	
	@Override
	public List<XPair<String, ITypeAttributes>> getTypes(){
		WordType intType = (WordType) getInternalType();
		if (intType != null) {
			return intType.getTypeEls();
		}
		return null;
	}
	
	@Override
	public org.neo4j.driver.v1.types.Node getBaseNode() {
		ITypeInfo info = type.getTypeInfo();
		if (info != null)
			return type.getTypeInfo().getBase();
		return null;
	}
	
	@Override
	public DictItem generateTokenInfo() {
		// TODO Auto-generated method stub
		return new DictItem(name, getInternalType().getName(), getInternalType().getBaseType().getKey(), generateID());
	}
	
	/**
	 * Public Factory of Class
	 * 
	 * @param el
	 * @param dictAccess
	 * @return
	 */
	public static Collection<IItem> create(ShortCut el, IDictionaryAccess dictAccess) {
		ShortCutItem item = new ShortCutItem((EObject) el, dictAccess);
		item.loadDictionary();
		return  new ArrayList<IItem>(Collections.singletonList(item));
	}


}
