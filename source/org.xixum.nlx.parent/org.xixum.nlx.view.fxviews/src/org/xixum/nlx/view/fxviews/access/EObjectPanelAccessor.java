/**
 * 
 */
package org.xixum.nlx.view.fxviews.access;

import static org.xixum.nlx.dictionary.grammar.types.ItemType.BRACKETCLOSE;
import static org.xixum.nlx.dictionary.grammar.types.ItemType.BRACKETOPEN;
import static org.xixum.nlx.dictionary.grammar.types.ItemType.COLON;
import static org.xixum.nlx.dictionary.grammar.types.ItemType.EXCLAMATION_M;
import static org.xixum.nlx.dictionary.grammar.types.ItemType.FULLSTOP;
import static org.xixum.nlx.dictionary.grammar.types.ItemType.NEWLINE;
import static org.xixum.nlx.dictionary.grammar.types.ItemType.QUESTION_M;
import static org.xixum.nlx.dictionary.grammar.types.ItemType.SEMICOLON;
import static org.xixum.nlx.dictionary.grammar.types.ItemType.START;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._BRACKETCLOSE;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._BRACKETOPEN;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._COLON;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._EXCLAMATION_M;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._EXX_BR_CLOSE;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._EXX_BR_OPEN;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._EX_BR_CLOSE;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._EX_BR_OPEN;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._FULL_STOP;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._QUESTION_M;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._SEMI_COLON;
import static org.xixum.nlx.view.fxviews.semantics.constants.GrammarConstants._START;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.xixum.nlx.constants.TokenPosition;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.grammar.types.ItemType;
import org.xixum.nlx.view.fxviews.access.elements.BasicItem;
import org.xixum.nlx.view.fxviews.access.elements.ContainerItem;
import org.xixum.nlx.view.fxviews.access.elements.ItWordItem;
import org.xixum.nlx.view.fxviews.access.elements.KommaItem;
import org.xixum.nlx.view.fxviews.access.elements.QuoteItem;
import org.xixum.nlx.view.fxviews.access.elements.ShortCutItem;
import org.xixum.nlx.view.fxviews.access.elements.TerminalItem;
import org.xixum.nlx.view.fxviews.access.elements.UnitItem;
import org.xixum.nlx.view.fxviews.access.elements.WebItem;
import org.xixum.nlx.view.fxviews.access.elements.WordItem;
import org.xixum.nlx.view.fxviews.semantics.ILinkType;
import org.xixum.nlx.view.fxviews.semantics.types.InterpunctionType;
import de.validas.spedit.naturalLang.AllElements;
import de.validas.spedit.naturalLang.BracketSentence;
import de.validas.spedit.naturalLang.Elements;
import de.validas.spedit.naturalLang.ExtBracketSentence;
import de.validas.spedit.naturalLang.FreeSentence;
import de.validas.spedit.naturalLang.ItWord;
import de.validas.spedit.naturalLang.MailAdress;
import de.validas.spedit.naturalLang.NoNElement;
import de.validas.spedit.naturalLang.Quote;
import de.validas.spedit.naturalLang.Sentence;
import de.validas.spedit.naturalLang.ShortCut;
import de.validas.spedit.naturalLang.SubSentence;
import de.validas.spedit.naturalLang.Unit;
import de.validas.spedit.naturalLang.UrlAdress;
import de.validas.spedit.naturalLang.Word;
import de.validas.spedit.naturalLang.WordShort;
import org.xixum.utils.data.types.XPair;

/**
 * @author schaller
 *
 */
public class EObjectPanelAccessor extends EMFPanelAccessor {

	protected EList<FreeSentence> sentences;
	protected ContextData context;
	
	protected static final HashMap<String, ItemType> SEPARATORS = new HashMap<String, ItemType>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = -1937942971201580243L;

	{
		put(_START, START);  //TODO: 04.04.22 maybe define as "BLANK"
		
		put(_FULL_STOP, FULLSTOP);
		put(_COLON, COLON);
		put(_SEMI_COLON, SEMICOLON);
		put(_QUESTION_M, QUESTION_M);
		put(_EXCLAMATION_M, EXCLAMATION_M);
		
		put(_BRACKETOPEN, BRACKETOPEN);
		put(_EX_BR_OPEN, BRACKETOPEN);
		put(_EXX_BR_OPEN, BRACKETOPEN);
		
		put(_BRACKETCLOSE, BRACKETCLOSE);
		put(_EX_BR_CLOSE, BRACKETCLOSE);
		put(_EXX_BR_CLOSE, BRACKETCLOSE);
	}};

	/**
	 * creates sentence from sentence chain
	 * @param sentenceObject
	 * @param dictAccess
	 */
	public EObjectPanelAccessor(XPair<EList<FreeSentence>, ContextData> sentenceObject, IDictionaryAccess dictAccess) {
		super(dictAccess);
		if (sentenceObject!=null) {
			this.sentences = sentenceObject.getKey();
			this.context = sentenceObject.getValue();
			createElementsFromBlock(sentences);
		}
	}

	protected void createElements(EList<Elements> elements) {

		
		for (Elements el : elements) {
			if (el instanceof Elements) {
				if (el instanceof BracketSentence || el instanceof ExtBracketSentence) {
					
					tokenChain.add(ContainerItem.create((BracketSentence) el, null, dictAccess)); 
					
				} else {
					if (el instanceof Word || el instanceof WordShort) 
						tokenChain.addAll(WordItem.create((WordShort) el, dictAccess)); //TODO: 14.12.22 try to use annotated access via reflection instead
					else if (el instanceof Unit )
						tokenChain.addAll(UnitItem.create((Unit) el));
					else if (el instanceof ItWord)
						tokenChain.addAll(ItWordItem.create((ItWord)el));
					else if (el instanceof ShortCut)
						tokenChain.addAll(ShortCutItem.create((ShortCut)el, dictAccess));
					else if (el instanceof MailAdress || el instanceof UrlAdress)
						tokenChain.addAll(WebItem.create((NoNElement)el));
					else if (el instanceof Quote)
						tokenChain.addAll(QuoteItem.create((Quote)el));
					else if (el.getNl() == null)
						tokenChain.addAll(BasicItem.create((AllElements)el));
					//TODO: 29.03.22 introduce new line Element later
				}
			}
			//TODO: else -> handle NewLine 
		}
		
	}

	@SuppressWarnings("unchecked")
	protected void createElementsFromBlock(EList<FreeSentence> chain) {
		
		
		//TODO: 29.03.22 provisional, define sentence's end point. Define bigger context in sentence-chains later
		String end = null;
		String start = null;
		int pos = context.getPos();
		ILinkType separator = null;
		if (chain.size() <= 0 )
			return;
		
		EList<String> separators = context.getSeparators();
		
		if (pos < separators.size()) {
			end = separators.get(pos);
		} else {
			end = context.getEnd();
		}
		if (pos == 0) {
			start = context.getStart();
		}
		FreeSentence first = chain.get(0);
		FreeSentence last = chain.get(chain.size()-1);
		if (start != null) {
			separator = createStart(start, first, separator);
		} else {  // Blank start
			separator = new InterpunctionType(first, SEPARATORS.get(_START), dictAccess);
		}
		tokenChain.add(TerminalItem.create(first, separator, TokenPosition.START));
		int i = pos;
		for (FreeSentence fSentence : chain) {
			if (fSentence instanceof Sentence) {
				List<EObject> subSentences = ((Sentence) fSentence).getSubsentence();
				
				boolean firstElement = true;
				//TODO: support Colon Full stop as Well
								
				for (EObject subs : subSentences) {
					if (!firstElement)
						tokenChain.add(KommaItem.create(dictAccess));
					firstElement = false;
					createElements((EList)((SubSentence) subs).getElements());
				}
				//TODO: 24.03.22 Add Item with attributes
				
			}
			separator = null;
			if (i < separators.size()) {
				separator = createIntermediate(separators.get(i), fSentence, null);
				tokenChain.add(TerminalItem.create(last, separator, TokenPosition.INTERMEDIATE));
			} else if (end != null) {
				separator = createEnd(end, last, separator);
				tokenChain.add(TerminalItem.create(last, separator, TokenPosition.END));
			}
			i++;
		}
		
	}
	
	/**
	 * creates intermediate interpunctions
	 * @param interm
	 * @param fSentence
	 * @param separator
	 * @return
	 */
	private ILinkType createIntermediate(String interm, FreeSentence fSentence, ILinkType separator) {
		String clean = interm.replaceAll("\\s", "");
		ItemType ityp = clean.isEmpty()? NEWLINE: SEPARATORS.get(clean); 
		return new InterpunctionType(fSentence, SEPARATORS.get(interm.replaceAll("\\s", "")), interm, dictAccess);
	}

	/**
	 * creates start interpunctions
	 * @param start
	 * @param first
	 * @param separator
	 * @return
	 */
	private ILinkType createStart(String start, FreeSentence first, ILinkType separator) {
		
		return new InterpunctionType(first, SEPARATORS.get(start.replaceAll("\\s", "")), start, dictAccess);
	}

	/**
	 * creates end interpunctions
	 * @param end
	 * @param fSentence
	 * @param separator
	 * @return
	 */
	protected ILinkType createEnd(String end, FreeSentence fSentence, ILinkType separator) {
		String clean = end.replaceAll("\\s", "");
		ItemType ityp = clean.isEmpty()? NEWLINE: SEPARATORS.get(clean);  
		return new InterpunctionType(fSentence, ityp, end, dictAccess); //TODO: 31.03.2022 only set parameter in switch
	}

}
