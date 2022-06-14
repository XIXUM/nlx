/*
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.validas.spedit.ide.contentassist.antlr.internal.InternalNaturalLangParser;
import de.validas.spedit.services.NaturalLangGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class NaturalLangParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(NaturalLangGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, NaturalLangGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getSentenceTypeAccess().getAlternatives_1(), "rule__SentenceType__Alternatives_1");
			builder.put(grammarAccess.getParagraphAccess().getAlternatives(), "rule__Paragraph__Alternatives");
			builder.put(grammarAccess.getBlockElementAccess().getAlternatives(), "rule__BlockElement__Alternatives");
			builder.put(grammarAccess.getTableBorderAccess().getAlternatives(), "rule__TableBorder__Alternatives");
			builder.put(grammarAccess.getSentenceChainAccess().getAlternatives_3(), "rule__SentenceChain__Alternatives_3");
			builder.put(grammarAccess.getSentenceChainXAccess().getAlternatives_3_0(), "rule__SentenceChainX__Alternatives_3_0");
			builder.put(grammarAccess.getListSentenceAccess().getAlternatives_1(), "rule__ListSentence__Alternatives_1");
			builder.put(grammarAccess.getChapterSentenceAccess().getAlternatives_0(), "rule__ChapterSentence__Alternatives_0");
			builder.put(grammarAccess.getSubSentenceAccess().getAlternatives_1(), "rule__SubSentence__Alternatives_1");
			builder.put(grammarAccess.getFreeSubSentenceAccess().getAlternatives_1(), "rule__FreeSubSentence__Alternatives_1");
			builder.put(grammarAccess.getFreeSubSentenceAccess().getAlternatives_3_0(), "rule__FreeSubSentence__Alternatives_3_0");
			builder.put(grammarAccess.getFreeSubSentenceAccess().getAlternatives_4(), "rule__FreeSubSentence__Alternatives_4");
			builder.put(grammarAccess.getListPointAccess().getAlternatives(), "rule__ListPoint__Alternatives");
			builder.put(grammarAccess.getListPointNumAccess().getAlternatives(), "rule__ListPointNum__Alternatives");
			builder.put(grammarAccess.getListPointNumAccess().getAlternatives_0_1(), "rule__ListPointNum__Alternatives_0_1");
			builder.put(grammarAccess.getListPointNumAccess().getAlternatives_1_1(), "rule__ListPointNum__Alternatives_1_1");
			builder.put(grammarAccess.getNoNElementAccess().getAlternatives(), "rule__NoNElement__Alternatives");
			builder.put(grammarAccess.getBracketsAccess().getAlternatives(), "rule__Brackets__Alternatives");
			builder.put(grammarAccess.getNoNElementXAccess().getAlternatives(), "rule__NoNElementX__Alternatives");
			builder.put(grammarAccess.getNoNElementX2Access().getAlternatives(), "rule__NoNElementX2__Alternatives");
			builder.put(grammarAccess.getElementsAccess().getAlternatives(), "rule__Elements__Alternatives");
			builder.put(grammarAccess.getAllElementsAccess().getAlternatives(), "rule__AllElements__Alternatives");
			builder.put(grammarAccess.getBracketSentenceAccess().getSeparatorAlternatives_3_0(), "rule__BracketSentence__SeparatorAlternatives_3_0");
			builder.put(grammarAccess.getBracketSentenceAccess().getAlternatives_4(), "rule__BracketSentence__Alternatives_4");
			builder.put(grammarAccess.getExtBracketSentenceAccess().getSeparatorAlternatives_3_0(), "rule__ExtBracketSentence__SeparatorAlternatives_3_0");
			builder.put(grammarAccess.getExtBracketSentenceCAccess().getSeparatorAlternatives_3_0(), "rule__ExtBracketSentenceC__SeparatorAlternatives_3_0");
			builder.put(grammarAccess.getFullStopAccess().getAlternatives(), "rule__FullStop__Alternatives");
			builder.put(grammarAccess.getWordAccess().getAlternatives_0(), "rule__Word__Alternatives_0");
			builder.put(grammarAccess.getFragmentXAccess().getAlternatives(), "rule__FragmentX__Alternatives");
			builder.put(grammarAccess.getFragmentAccess().getAlternatives(), "rule__Fragment__Alternatives");
			builder.put(grammarAccess.getAsteriskAccess().getAlternatives(), "rule__Asterisk__Alternatives");
			builder.put(grammarAccess.getItWordAccess().getAlternatives_0(), "rule__ItWord__Alternatives_0");
			builder.put(grammarAccess.getItWordAccess().getAlternatives_0_0_0(), "rule__ItWord__Alternatives_0_0_0");
			builder.put(grammarAccess.getItWordAccess().getAlternatives_0_0_0_0_0(), "rule__ItWord__Alternatives_0_0_0_0_0");
			builder.put(grammarAccess.getItWordAccess().getAlternatives_0_0_0_0_1(), "rule__ItWord__Alternatives_0_0_0_0_1");
			builder.put(grammarAccess.getItWordAccess().getAlternatives_0_0_0_1(), "rule__ItWord__Alternatives_0_0_0_1");
			builder.put(grammarAccess.getItWordAccess().getAlternatives_0_1_0(), "rule__ItWord__Alternatives_0_1_0");
			builder.put(grammarAccess.getItWordAccess().getAlternatives_0_1_1(), "rule__ItWord__Alternatives_0_1_1");
			builder.put(grammarAccess.getWhitespaceAccess().getAlternatives(), "rule__Whitespace__Alternatives");
			builder.put(grammarAccess.getItWordElAccess().getAlternatives(), "rule__ItWordEl__Alternatives");
			builder.put(grammarAccess.getItWordElurlAccess().getAlternatives(), "rule__ItWordElurl__Alternatives");
			builder.put(grammarAccess.getItWordElXAccess().getAlternatives(), "rule__ItWordElX__Alternatives");
			builder.put(grammarAccess.getItWordElXxAccess().getAlternatives(), "rule__ItWordElXx__Alternatives");
			builder.put(grammarAccess.getSeparatorsLAccess().getAlternatives(), "rule__SeparatorsL__Alternatives");
			builder.put(grammarAccess.getSeparatorsItAccess().getAlternatives(), "rule__SeparatorsIt__Alternatives");
			builder.put(grammarAccess.getAllSepAccess().getAlternatives(), "rule__AllSep__Alternatives");
			builder.put(grammarAccess.getUnitAccess().getAlternatives_2(), "rule__Unit__Alternatives_2");
			builder.put(grammarAccess.getSimpleUnitAccess().getAlternatives(), "rule__SimpleUnit__Alternatives");
			builder.put(grammarAccess.getHashNumberAccess().getSignAlternatives_1_0(), "rule__HashNumber__SignAlternatives_1_0");
			builder.put(grammarAccess.getChapterAlphaAccess().getAlternatives_1(), "rule__ChapterAlpha__Alternatives_1");
			builder.put(grammarAccess.getChapterAlphaAccess().getAlternatives_4_0(), "rule__ChapterAlpha__Alternatives_4_0");
			builder.put(grammarAccess.getChapterIntermediateAccess().getAlternatives(), "rule__ChapterIntermediate__Alternatives");
			builder.put(grammarAccess.getSpecialChAccess().getAlternatives(), "rule__SpecialCh__Alternatives");
			builder.put(grammarAccess.getShortcutGenAccess().getAlternatives_1(), "rule__ShortcutGen__Alternatives_1");
			builder.put(grammarAccess.getShortcutGenAccess().getAlternatives_2_1(), "rule__ShortcutGen__Alternatives_2_1");
			builder.put(grammarAccess.getShortCutAccess().getAlternatives(), "rule__ShortCut__Alternatives");
			builder.put(grammarAccess.getItNumAccess().getAlternatives_1_0(), "rule__ItNum__Alternatives_1_0");
			builder.put(grammarAccess.getSpecialSymbolsAccess().getAlternatives(), "rule__SpecialSymbols__Alternatives");
			builder.put(grammarAccess.getNumberAccess().getAlternatives(), "rule__Number__Alternatives");
			builder.put(grammarAccess.getUrlAdressAccess().getAlternatives_2_1(), "rule__UrlAdress__Alternatives_2_1");
			builder.put(grammarAccess.getMailAdressAccess().getAlternatives_0(), "rule__MailAdress__Alternatives_0");
			builder.put(grammarAccess.getFormulaAccess().getAlternatives_1(), "rule__Formula__Alternatives_1");
			builder.put(grammarAccess.getFormulaAccess().getAlternatives_3_1(), "rule__Formula__Alternatives_3_1");
			builder.put(grammarAccess.getArrayAccess().getAlternatives_0(), "rule__Array__Alternatives_0");
			builder.put(grammarAccess.getSentenceTypeAccess().getGroup(), "rule__SentenceType__Group__0");
			builder.put(grammarAccess.getFootNoteAccess().getGroup(), "rule__FootNote__Group__0");
			builder.put(grammarAccess.getTableRowAccess().getGroup(), "rule__TableRow__Group__0");
			builder.put(grammarAccess.getTableRowAccess().getGroup_3(), "rule__TableRow__Group_3__0");
			builder.put(grammarAccess.getTableAccess().getGroup(), "rule__Table__Group__0");
			builder.put(grammarAccess.getTableAccess().getGroup_2(), "rule__Table__Group_2__0");
			builder.put(grammarAccess.getTableAccess().getGroup_3(), "rule__Table__Group_3__0");
			builder.put(grammarAccess.getTableAccess().getGroup_3_2(), "rule__Table__Group_3_2__0");
			builder.put(grammarAccess.getLineSentenceChainAccess().getGroup(), "rule__LineSentenceChain__Group__0");
			builder.put(grammarAccess.getLineSentenceChainAccess().getGroup_2(), "rule__LineSentenceChain__Group_2__0");
			builder.put(grammarAccess.getSentenceChainAccess().getGroup(), "rule__SentenceChain__Group__0");
			builder.put(grammarAccess.getSentenceChainAccess().getGroup_2(), "rule__SentenceChain__Group_2__0");
			builder.put(grammarAccess.getSentenceChainXAccess().getGroup(), "rule__SentenceChainX__Group__0");
			builder.put(grammarAccess.getSentenceChainXAccess().getGroup_2(), "rule__SentenceChainX__Group_2__0");
			builder.put(grammarAccess.getSentenceChainXAccess().getGroup_3(), "rule__SentenceChainX__Group_3__0");
			builder.put(grammarAccess.getSentenceAccess().getGroup(), "rule__Sentence__Group__0");
			builder.put(grammarAccess.getSentenceAccess().getGroup_2(), "rule__Sentence__Group_2__0");
			builder.put(grammarAccess.getLineSentenceAccess().getGroup(), "rule__LineSentence__Group__0");
			builder.put(grammarAccess.getLineSentenceAccess().getGroup_2(), "rule__LineSentence__Group_2__0");
			builder.put(grammarAccess.getFreeSentenceAccess().getGroup(), "rule__FreeSentence__Group__0");
			builder.put(grammarAccess.getFreeSentenceAccess().getGroup_2(), "rule__FreeSentence__Group_2__0");
			builder.put(grammarAccess.getSentenceXAccess().getGroup(), "rule__SentenceX__Group__0");
			builder.put(grammarAccess.getSentenceXAccess().getGroup_2(), "rule__SentenceX__Group_2__0");
			builder.put(grammarAccess.getListSentenceAccess().getGroup(), "rule__ListSentence__Group__0");
			builder.put(grammarAccess.getChapterSentenceAccess().getGroup(), "rule__ChapterSentence__Group__0");
			builder.put(grammarAccess.getSubSentenceAccess().getGroup(), "rule__SubSentence__Group__0");
			builder.put(grammarAccess.getSubSentenceAccess().getGroup_1_0(), "rule__SubSentence__Group_1_0__0");
			builder.put(grammarAccess.getSubSentenceAccess().getGroup_1_0_1(), "rule__SubSentence__Group_1_0_1__0");
			builder.put(grammarAccess.getSubSentenceAccess().getGroup_1_1(), "rule__SubSentence__Group_1_1__0");
			builder.put(grammarAccess.getSubSentenceAccess().getGroup_1_1_1(), "rule__SubSentence__Group_1_1_1__0");
			builder.put(grammarAccess.getSubSentenceAccess().getGroup_2(), "rule__SubSentence__Group_2__0");
			builder.put(grammarAccess.getSubSentenceAccess().getGroup_2_4(), "rule__SubSentence__Group_2_4__0");
			builder.put(grammarAccess.getTrailSubSentenceAccess().getGroup(), "rule__TrailSubSentence__Group__0");
			builder.put(grammarAccess.getTrailSubSentenceAccess().getGroup_1(), "rule__TrailSubSentence__Group_1__0");
			builder.put(grammarAccess.getTrailSubSentenceAccess().getGroup_1_1(), "rule__TrailSubSentence__Group_1_1__0");
			builder.put(grammarAccess.getTrailSubSentenceAccess().getGroup_1_2(), "rule__TrailSubSentence__Group_1_2__0");
			builder.put(grammarAccess.getTrailSubSentenceAccess().getGroup_1_2_4(), "rule__TrailSubSentence__Group_1_2_4__0");
			builder.put(grammarAccess.getFreeSubSentenceAccess().getGroup(), "rule__FreeSubSentence__Group__0");
			builder.put(grammarAccess.getFreeSubSentenceAccess().getGroup_3(), "rule__FreeSubSentence__Group_3__0");
			builder.put(grammarAccess.getLineSubSentenceAccess().getGroup(), "rule__LineSubSentence__Group__0");
			builder.put(grammarAccess.getLineSubSentenceAccess().getGroup_2(), "rule__LineSubSentence__Group_2__0");
			builder.put(grammarAccess.getListPointNumAccess().getGroup_0(), "rule__ListPointNum__Group_0__0");
			builder.put(grammarAccess.getListPointNumAccess().getGroup_0_1_0(), "rule__ListPointNum__Group_0_1_0__0");
			builder.put(grammarAccess.getListPointNumAccess().getGroup_1(), "rule__ListPointNum__Group_1__0");
			builder.put(grammarAccess.getListPointNumAccess().getGroup_1_1_0(), "rule__ListPointNum__Group_1_1_0__0");
			builder.put(grammarAccess.getBracketSentenceAccess().getGroup(), "rule__BracketSentence__Group__0");
			builder.put(grammarAccess.getBracketSentenceAccess().getGroup_2(), "rule__BracketSentence__Group_2__0");
			builder.put(grammarAccess.getBracketSentenceAccess().getGroup_2_1(), "rule__BracketSentence__Group_2_1__0");
			builder.put(grammarAccess.getExtBracketSentenceAccess().getGroup(), "rule__ExtBracketSentence__Group__0");
			builder.put(grammarAccess.getExtBracketSentenceAccess().getGroup_2(), "rule__ExtBracketSentence__Group_2__0");
			builder.put(grammarAccess.getExtBracketSentenceAccess().getGroup_2_1(), "rule__ExtBracketSentence__Group_2_1__0");
			builder.put(grammarAccess.getExtBracketSentenceCAccess().getGroup(), "rule__ExtBracketSentenceC__Group__0");
			builder.put(grammarAccess.getExtBracketSentenceCAccess().getGroup_2(), "rule__ExtBracketSentenceC__Group_2__0");
			builder.put(grammarAccess.getExtBracketSentenceCAccess().getGroup_2_1(), "rule__ExtBracketSentenceC__Group_2_1__0");
			builder.put(grammarAccess.getWordAccess().getGroup(), "rule__Word__Group__0");
			builder.put(grammarAccess.getWordAccess().getGroup_0_1(), "rule__Word__Group_0_1__0");
			builder.put(grammarAccess.getWordAccess().getGroup_0_1_0(), "rule__Word__Group_0_1_0__0");
			builder.put(grammarAccess.getWordAccess().getGroup_0_1_1(), "rule__Word__Group_0_1_1__0");
			builder.put(grammarAccess.getWordShortAccess().getGroup(), "rule__WordShort__Group__0");
			builder.put(grammarAccess.getAsteriskAccess().getGroup_0(), "rule__Asterisk__Group_0__0");
			builder.put(grammarAccess.getAsteriskAccess().getGroup_1(), "rule__Asterisk__Group_1__0");
			builder.put(grammarAccess.getAsteriskAccess().getGroup_2(), "rule__Asterisk__Group_2__0");
			builder.put(grammarAccess.getItWordAccess().getGroup(), "rule__ItWord__Group__0");
			builder.put(grammarAccess.getItWordAccess().getGroup_0_0(), "rule__ItWord__Group_0_0__0");
			builder.put(grammarAccess.getItWordAccess().getGroup_0_0_0_0(), "rule__ItWord__Group_0_0_0_0__0");
			builder.put(grammarAccess.getItWordAccess().getGroup_0_0_0_1_2(), "rule__ItWord__Group_0_0_0_1_2__0");
			builder.put(grammarAccess.getItWordAccess().getGroup_0_0_1(), "rule__ItWord__Group_0_0_1__0");
			builder.put(grammarAccess.getItWordAccess().getGroup_0_1(), "rule__ItWord__Group_0_1__0");
			builder.put(grammarAccess.getItWordAccess().getGroup_0_1_1_0(), "rule__ItWord__Group_0_1_1_0__0");
			builder.put(grammarAccess.getItWordAccess().getGroup_0_1_1_1(), "rule__ItWord__Group_0_1_1_1__0");
			builder.put(grammarAccess.getItWordAccess().getGroup_0_1_2(), "rule__ItWord__Group_0_1_2__0");
			builder.put(grammarAccess.getWhitespaceAccess().getGroup_1(), "rule__Whitespace__Group_1__0");
			builder.put(grammarAccess.getUnitAccess().getGroup(), "rule__Unit__Group__0");
			builder.put(grammarAccess.getSimpleUnitAccess().getGroup_0(), "rule__SimpleUnit__Group_0__0");
			builder.put(grammarAccess.getChapter_Unit_HIAccess().getGroup(), "rule__Chapter_Unit_HI__Group__0");
			builder.put(grammarAccess.getChapter_Unit_LowAccess().getGroup(), "rule__Chapter_Unit_Low__Group__0");
			builder.put(grammarAccess.getHashNumberAccess().getGroup(), "rule__HashNumber__Group__0");
			builder.put(grammarAccess.getChapterAlphaAccess().getGroup(), "rule__ChapterAlpha__Group__0");
			builder.put(grammarAccess.getChapterAlphaAccess().getGroup_4(), "rule__ChapterAlpha__Group_4__0");
			builder.put(grammarAccess.getSymbolsXAccess().getGroup(), "rule__SymbolsX__Group__0");
			builder.put(grammarAccess.getSymbolsAccess().getGroup(), "rule__Symbols__Group__0");
			builder.put(grammarAccess.getShortcutGenAccess().getGroup(), "rule__ShortcutGen__Group__0");
			builder.put(grammarAccess.getShortcutGenAccess().getGroup_2(), "rule__ShortcutGen__Group_2__0");
			builder.put(grammarAccess.getShortcutLibAccess().getGroup(), "rule__ShortcutLib__Group__0");
			builder.put(grammarAccess.getItNumAccess().getGroup(), "rule__ItNum__Group__0");
			builder.put(grammarAccess.getItNumAccess().getGroup_1(), "rule__ItNum__Group_1__0");
			builder.put(grammarAccess.getItNumAccess().getGroup_2(), "rule__ItNum__Group_2__0");
			builder.put(grammarAccess.getDecimalNumENAccess().getGroup(), "rule__DecimalNumEN__Group__0");
			builder.put(grammarAccess.getDecimalNumDEAccess().getGroup(), "rule__DecimalNumDE__Group__0");
			builder.put(grammarAccess.getChapterNumAccess().getGroup(), "rule__ChapterNum__Group__0");
			builder.put(grammarAccess.getChapterNumAccess().getGroup_1(), "rule__ChapterNum__Group_1__0");
			builder.put(grammarAccess.getUrlAdressAccess().getGroup(), "rule__UrlAdress__Group__0");
			builder.put(grammarAccess.getUrlAdressAccess().getGroup_2(), "rule__UrlAdress__Group_2__0");
			builder.put(grammarAccess.getMailAdressAccess().getGroup(), "rule__MailAdress__Group__0");
			builder.put(grammarAccess.getFormulaAccess().getGroup(), "rule__Formula__Group__0");
			builder.put(grammarAccess.getFormulaAccess().getGroup_3(), "rule__Formula__Group_3__0");
			builder.put(grammarAccess.getArrayAccess().getGroup(), "rule__Array__Group__0");
			builder.put(grammarAccess.getNew_LineAccess().getGroup(), "rule__New_Line__Group__0");
			builder.put(grammarAccess.getModelAccess().getSentencesAssignment(), "rule__Model__SentencesAssignment");
			builder.put(grammarAccess.getSentenceTypeAccess().getPEndAssignment_2(), "rule__SentenceType__PEndAssignment_2");
			builder.put(grammarAccess.getParagraphBlockAccess().getBlockAssignment(), "rule__ParagraphBlock__BlockAssignment");
			builder.put(grammarAccess.getFootNoteAccess().getNumberAssignment_0(), "rule__FootNote__NumberAssignment_0");
			builder.put(grammarAccess.getFootNoteAccess().getSentenceChainAssignment_2(), "rule__FootNote__SentenceChainAssignment_2");
			builder.put(grammarAccess.getTableLineAccess().getContentAssignment(), "rule__TableLine__ContentAssignment");
			builder.put(grammarAccess.getTableRowAccess().getContentAssignment_1(), "rule__TableRow__ContentAssignment_1");
			builder.put(grammarAccess.getTableRowAccess().getContentAssignment_2(), "rule__TableRow__ContentAssignment_2");
			builder.put(grammarAccess.getTableRowAccess().getContentAssignment_3_0(), "rule__TableRow__ContentAssignment_3_0");
			builder.put(grammarAccess.getTableRowAccess().getContentAssignment_3_1(), "rule__TableRow__ContentAssignment_3_1");
			builder.put(grammarAccess.getTableRowAccess().getContentAssignment_4(), "rule__TableRow__ContentAssignment_4");
			builder.put(grammarAccess.getTableColumnSeparatorAccess().getCharAssignment(), "rule__TableColumnSeparator__CharAssignment");
			builder.put(grammarAccess.getTableAccess().getLinesAssignment_0(), "rule__Table__LinesAssignment_0");
			builder.put(grammarAccess.getTableAccess().getLinesAssignment_2_0(), "rule__Table__LinesAssignment_2_0");
			builder.put(grammarAccess.getTableAccess().getLinesAssignment_3_0(), "rule__Table__LinesAssignment_3_0");
			builder.put(grammarAccess.getTableAccess().getLinesAssignment_3_2_0(), "rule__Table__LinesAssignment_3_2_0");
			builder.put(grammarAccess.getTableAccess().getLinesAssignment_4(), "rule__Table__LinesAssignment_4");
			builder.put(grammarAccess.getLineSentenceChainAccess().getSentencesAssignment_1(), "rule__LineSentenceChain__SentencesAssignment_1");
			builder.put(grammarAccess.getLineSentenceChainAccess().getSeparatorsAssignment_2_0(), "rule__LineSentenceChain__SeparatorsAssignment_2_0");
			builder.put(grammarAccess.getLineSentenceChainAccess().getSentencesAssignment_2_1(), "rule__LineSentenceChain__SentencesAssignment_2_1");
			builder.put(grammarAccess.getLineSentenceChainAccess().getEndpointAssignment_3(), "rule__LineSentenceChain__EndpointAssignment_3");
			builder.put(grammarAccess.getSentenceChainAccess().getSentencesAssignment_1(), "rule__SentenceChain__SentencesAssignment_1");
			builder.put(grammarAccess.getSentenceChainAccess().getSeparatorsAssignment_2_0(), "rule__SentenceChain__SeparatorsAssignment_2_0");
			builder.put(grammarAccess.getSentenceChainAccess().getSentencesAssignment_2_1(), "rule__SentenceChain__SentencesAssignment_2_1");
			builder.put(grammarAccess.getSentenceChainAccess().getEndpointAssignment_3_0(), "rule__SentenceChain__EndpointAssignment_3_0");
			builder.put(grammarAccess.getSentenceChainAccess().getEndpointAssignment_3_1(), "rule__SentenceChain__EndpointAssignment_3_1");
			builder.put(grammarAccess.getSentenceChainXAccess().getSentencesAssignment_1(), "rule__SentenceChainX__SentencesAssignment_1");
			builder.put(grammarAccess.getSentenceChainXAccess().getSeparatorsAssignment_2_0(), "rule__SentenceChainX__SeparatorsAssignment_2_0");
			builder.put(grammarAccess.getSentenceChainXAccess().getSentencesAssignment_2_1(), "rule__SentenceChainX__SentencesAssignment_2_1");
			builder.put(grammarAccess.getSentenceChainXAccess().getEndpointAssignment_3_0_0(), "rule__SentenceChainX__EndpointAssignment_3_0_0");
			builder.put(grammarAccess.getSentenceChainXAccess().getEndpointAssignment_3_0_1(), "rule__SentenceChainX__EndpointAssignment_3_0_1");
			builder.put(grammarAccess.getSentenceChainXAccess().getEndpointAssignment_3_0_2(), "rule__SentenceChainX__EndpointAssignment_3_0_2");
			builder.put(grammarAccess.getSentenceAccess().getSubsentenceAssignment_1(), "rule__Sentence__SubsentenceAssignment_1");
			builder.put(grammarAccess.getSentenceAccess().getSubsentenceAssignment_2_1(), "rule__Sentence__SubsentenceAssignment_2_1");
			builder.put(grammarAccess.getLineSentenceAccess().getSubsentenceAssignment_1(), "rule__LineSentence__SubsentenceAssignment_1");
			builder.put(grammarAccess.getLineSentenceAccess().getSubsentenceAssignment_2_1(), "rule__LineSentence__SubsentenceAssignment_2_1");
			builder.put(grammarAccess.getFreeSentenceAccess().getSubsentenceAssignment_1(), "rule__FreeSentence__SubsentenceAssignment_1");
			builder.put(grammarAccess.getFreeSentenceAccess().getSubsentenceAssignment_2_1(), "rule__FreeSentence__SubsentenceAssignment_2_1");
			builder.put(grammarAccess.getSentenceXAccess().getSubsentenceAssignment_1(), "rule__SentenceX__SubsentenceAssignment_1");
			builder.put(grammarAccess.getSentenceXAccess().getSubsentenceAssignment_2_1(), "rule__SentenceX__SubsentenceAssignment_2_1");
			builder.put(grammarAccess.getListSentenceAccess().getListpointAssignment_0(), "rule__ListSentence__ListpointAssignment_0");
			builder.put(grammarAccess.getListSentenceAccess().getSentenceChainAssignment_1_0(), "rule__ListSentence__SentenceChainAssignment_1_0");
			builder.put(grammarAccess.getChapterSentenceAccess().getChapterNumberAssignment_0_0(), "rule__ChapterSentence__ChapterNumberAssignment_0_0");
			builder.put(grammarAccess.getChapterSentenceAccess().getChapterNumberAssignment_0_1(), "rule__ChapterSentence__ChapterNumberAssignment_0_1");
			builder.put(grammarAccess.getChapterSentenceAccess().getChapterNumberAssignment_0_2(), "rule__ChapterSentence__ChapterNumberAssignment_0_2");
			builder.put(grammarAccess.getChapterSentenceAccess().getHeadlineAssignment_1(), "rule__ChapterSentence__HeadlineAssignment_1");
			builder.put(grammarAccess.getSubSentenceAccess().getElementsAssignment_1_0_0(), "rule__SubSentence__ElementsAssignment_1_0_0");
			builder.put(grammarAccess.getSubSentenceAccess().getElementsAssignment_1_0_1_1(), "rule__SubSentence__ElementsAssignment_1_0_1_1");
			builder.put(grammarAccess.getSubSentenceAccess().getElementsAssignment_1_1_0(), "rule__SubSentence__ElementsAssignment_1_1_0");
			builder.put(grammarAccess.getSubSentenceAccess().getElementsAssignment_1_1_1_1(), "rule__SubSentence__ElementsAssignment_1_1_1_1");
			builder.put(grammarAccess.getSubSentenceAccess().getElementsAssignment_2_1(), "rule__SubSentence__ElementsAssignment_2_1");
			builder.put(grammarAccess.getSubSentenceAccess().getElementsAssignment_2_3(), "rule__SubSentence__ElementsAssignment_2_3");
			builder.put(grammarAccess.getSubSentenceAccess().getElementsAssignment_2_4_1(), "rule__SubSentence__ElementsAssignment_2_4_1");
			builder.put(grammarAccess.getTrailSubSentenceAccess().getElementsAssignment_1_0(), "rule__TrailSubSentence__ElementsAssignment_1_0");
			builder.put(grammarAccess.getTrailSubSentenceAccess().getElementsAssignment_1_1_1(), "rule__TrailSubSentence__ElementsAssignment_1_1_1");
			builder.put(grammarAccess.getTrailSubSentenceAccess().getElementsAssignment_1_2_1(), "rule__TrailSubSentence__ElementsAssignment_1_2_1");
			builder.put(grammarAccess.getTrailSubSentenceAccess().getElementsAssignment_1_2_3(), "rule__TrailSubSentence__ElementsAssignment_1_2_3");
			builder.put(grammarAccess.getTrailSubSentenceAccess().getElementsAssignment_1_2_4_1(), "rule__TrailSubSentence__ElementsAssignment_1_2_4_1");
			builder.put(grammarAccess.getFreeSubSentenceAccess().getElementsAssignment_1_1(), "rule__FreeSubSentence__ElementsAssignment_1_1");
			builder.put(grammarAccess.getFreeSubSentenceAccess().getElementsAssignment_2(), "rule__FreeSubSentence__ElementsAssignment_2");
			builder.put(grammarAccess.getFreeSubSentenceAccess().getElementsAssignment_3_0_1(), "rule__FreeSubSentence__ElementsAssignment_3_0_1");
			builder.put(grammarAccess.getFreeSubSentenceAccess().getElementsAssignment_3_1(), "rule__FreeSubSentence__ElementsAssignment_3_1");
			builder.put(grammarAccess.getFreeSubSentenceAccess().getElementsAssignment_4_1(), "rule__FreeSubSentence__ElementsAssignment_4_1");
			builder.put(grammarAccess.getLineSubSentenceAccess().getElementsAssignment_1(), "rule__LineSubSentence__ElementsAssignment_1");
			builder.put(grammarAccess.getLineSubSentenceAccess().getElementsAssignment_2_1(), "rule__LineSubSentence__ElementsAssignment_2_1");
			builder.put(grammarAccess.getBracketSentenceAccess().getOpenAssignment_1(), "rule__BracketSentence__OpenAssignment_1");
			builder.put(grammarAccess.getBracketSentenceAccess().getBrackedSentencesAssignment_2_0(), "rule__BracketSentence__BrackedSentencesAssignment_2_0");
			builder.put(grammarAccess.getBracketSentenceAccess().getSeparatorAssignment_2_1_0(), "rule__BracketSentence__SeparatorAssignment_2_1_0");
			builder.put(grammarAccess.getBracketSentenceAccess().getBrackedSentencesAssignment_2_1_1(), "rule__BracketSentence__BrackedSentencesAssignment_2_1_1");
			builder.put(grammarAccess.getBracketSentenceAccess().getSeparatorAssignment_3(), "rule__BracketSentence__SeparatorAssignment_3");
			builder.put(grammarAccess.getBracketSentenceAccess().getCloseAssignment_6(), "rule__BracketSentence__CloseAssignment_6");
			builder.put(grammarAccess.getExtBracketSentenceAccess().getOpenAssignment_1(), "rule__ExtBracketSentence__OpenAssignment_1");
			builder.put(grammarAccess.getExtBracketSentenceAccess().getBrackedSentencesAssignment_2_0(), "rule__ExtBracketSentence__BrackedSentencesAssignment_2_0");
			builder.put(grammarAccess.getExtBracketSentenceAccess().getSeparatorAssignment_2_1_0(), "rule__ExtBracketSentence__SeparatorAssignment_2_1_0");
			builder.put(grammarAccess.getExtBracketSentenceAccess().getBrackedSentencesAssignment_2_1_1(), "rule__ExtBracketSentence__BrackedSentencesAssignment_2_1_1");
			builder.put(grammarAccess.getExtBracketSentenceAccess().getSeparatorAssignment_3(), "rule__ExtBracketSentence__SeparatorAssignment_3");
			builder.put(grammarAccess.getExtBracketSentenceAccess().getCloseAssignment_5(), "rule__ExtBracketSentence__CloseAssignment_5");
			builder.put(grammarAccess.getExtBracketSentenceCAccess().getOpenAssignment_1(), "rule__ExtBracketSentenceC__OpenAssignment_1");
			builder.put(grammarAccess.getExtBracketSentenceCAccess().getBrackedSentencesAssignment_2_0(), "rule__ExtBracketSentenceC__BrackedSentencesAssignment_2_0");
			builder.put(grammarAccess.getExtBracketSentenceCAccess().getSeparatorAssignment_2_1_0(), "rule__ExtBracketSentenceC__SeparatorAssignment_2_1_0");
			builder.put(grammarAccess.getExtBracketSentenceCAccess().getBrackedSentencesAssignment_2_1_1(), "rule__ExtBracketSentenceC__BrackedSentencesAssignment_2_1_1");
			builder.put(grammarAccess.getExtBracketSentenceCAccess().getSeparatorAssignment_3(), "rule__ExtBracketSentenceC__SeparatorAssignment_3");
			builder.put(grammarAccess.getExtBracketSentenceCAccess().getCloseAssignment_5(), "rule__ExtBracketSentenceC__CloseAssignment_5");
			builder.put(grammarAccess.getWordAccess().getWordAssignment_0_0(), "rule__Word__WordAssignment_0_0");
			builder.put(grammarAccess.getWordAccess().getWordAssignment_0_1_0_0(), "rule__Word__WordAssignment_0_1_0_0");
			builder.put(grammarAccess.getWordAccess().getWordAssignment_0_1_1_0(), "rule__Word__WordAssignment_0_1_1_0");
			builder.put(grammarAccess.getWordAccess().getWordAssignment_0_1_1_1(), "rule__Word__WordAssignment_0_1_1_1");
			builder.put(grammarAccess.getWordAccess().getWordAssignment_1(), "rule__Word__WordAssignment_1");
			builder.put(grammarAccess.getWordShortAccess().getWordAssignment_1(), "rule__WordShort__WordAssignment_1");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_0_0_0_0(), "rule__ItWord__WordAssignment_0_0_0_0_0_0");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_0_0_0_1(), "rule__ItWord__WordAssignment_0_0_0_0_0_1");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_0_0_0_2(), "rule__ItWord__WordAssignment_0_0_0_0_0_2");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_0_0_0_3(), "rule__ItWord__WordAssignment_0_0_0_0_0_3");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_0_0_1_0(), "rule__ItWord__WordAssignment_0_0_0_0_1_0");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_0_0_1_1(), "rule__ItWord__WordAssignment_0_0_0_0_1_1");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_0_1_0(), "rule__ItWord__WordAssignment_0_0_0_1_0");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_0_1_1(), "rule__ItWord__WordAssignment_0_0_0_1_1");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_0_1_2_0(), "rule__ItWord__WordAssignment_0_0_0_1_2_0");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_0_1_2_1(), "rule__ItWord__WordAssignment_0_0_0_1_2_1");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_1_0(), "rule__ItWord__WordAssignment_0_0_1_0");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_0_1_1(), "rule__ItWord__WordAssignment_0_0_1_1");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_1_0_0(), "rule__ItWord__WordAssignment_0_1_0_0");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_1_0_1(), "rule__ItWord__WordAssignment_0_1_0_1");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_1_1_0_0(), "rule__ItWord__WordAssignment_0_1_1_0_0");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_1_1_0_1(), "rule__ItWord__WordAssignment_0_1_1_0_1");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_1_1_1_0(), "rule__ItWord__WordAssignment_0_1_1_1_0");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_1_1_1_1(), "rule__ItWord__WordAssignment_0_1_1_1_1");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_1_2_0(), "rule__ItWord__WordAssignment_0_1_2_0");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_0_1_2_1(), "rule__ItWord__WordAssignment_0_1_2_1");
			builder.put(grammarAccess.getItWordAccess().getWordAssignment_1(), "rule__ItWord__WordAssignment_1");
			builder.put(grammarAccess.getQuoteAccess().getQuoteAssignment(), "rule__Quote__QuoteAssignment");
			builder.put(grammarAccess.getUnitAccess().getSignatureAssignment_0(), "rule__Unit__SignatureAssignment_0");
			builder.put(grammarAccess.getUnitAccess().getValueAssignment_1(), "rule__Unit__ValueAssignment_1");
			builder.put(grammarAccess.getUnitAccess().getUnitAssignment_2_0(), "rule__Unit__UnitAssignment_2_0");
			builder.put(grammarAccess.getUnitAccess().getUnitAssignment_2_1(), "rule__Unit__UnitAssignment_2_1");
			builder.put(grammarAccess.getUnitAccess().getUnitAssignment_2_2(), "rule__Unit__UnitAssignment_2_2");
			builder.put(grammarAccess.getSimpleUnitAccess().getValueAssignment_0_1(), "rule__SimpleUnit__ValueAssignment_0_1");
			builder.put(grammarAccess.getSimpleUnitAccess().getValueAssignment_1(), "rule__SimpleUnit__ValueAssignment_1");
			builder.put(grammarAccess.getSimpleUnitAccess().getValueAssignment_2(), "rule__SimpleUnit__ValueAssignment_2");
			builder.put(grammarAccess.getChapter_Unit_HIAccess().getValueAssignment_1(), "rule__Chapter_Unit_HI__ValueAssignment_1");
			builder.put(grammarAccess.getChapter_Unit_LowAccess().getValueAssignment_1(), "rule__Chapter_Unit_Low__ValueAssignment_1");
			builder.put(grammarAccess.getHashNumberAccess().getSignAssignment_1(), "rule__HashNumber__SignAssignment_1");
			builder.put(grammarAccess.getHashNumberAccess().getValueAssignment_2(), "rule__HashNumber__ValueAssignment_2");
			builder.put(grammarAccess.getChapterAlphaAccess().getValueAssignment_1_0(), "rule__ChapterAlpha__ValueAssignment_1_0");
			builder.put(grammarAccess.getChapterAlphaAccess().getValueAssignment_1_1(), "rule__ChapterAlpha__ValueAssignment_1_1");
			builder.put(grammarAccess.getChapterAlphaAccess().getValueAssignment_2(), "rule__ChapterAlpha__ValueAssignment_2");
			builder.put(grammarAccess.getChapterAlphaAccess().getValueAssignment_3(), "rule__ChapterAlpha__ValueAssignment_3");
			builder.put(grammarAccess.getChapterAlphaAccess().getValueAssignment_4_0_0(), "rule__ChapterAlpha__ValueAssignment_4_0_0");
			builder.put(grammarAccess.getChapterAlphaAccess().getValueAssignment_4_0_1(), "rule__ChapterAlpha__ValueAssignment_4_0_1");
			builder.put(grammarAccess.getChapterAlphaAccess().getValueAssignment_4_1(), "rule__ChapterAlpha__ValueAssignment_4_1");
			builder.put(grammarAccess.getSymbolsXAccess().getSymbolAssignment_1(), "rule__SymbolsX__SymbolAssignment_1");
			builder.put(grammarAccess.getSymbolsAccess().getSymbolAssignment_1(), "rule__Symbols__SymbolAssignment_1");
			builder.put(grammarAccess.getShortcutGenAccess().getWordAssignment_1_0(), "rule__ShortcutGen__WordAssignment_1_0");
			builder.put(grammarAccess.getShortcutGenAccess().getWordAssignment_1_1(), "rule__ShortcutGen__WordAssignment_1_1");
			builder.put(grammarAccess.getShortcutGenAccess().getWordAssignment_2_0(), "rule__ShortcutGen__WordAssignment_2_0");
			builder.put(grammarAccess.getShortcutGenAccess().getWordAssignment_2_1_0(), "rule__ShortcutGen__WordAssignment_2_1_0");
			builder.put(grammarAccess.getShortcutGenAccess().getWordAssignment_2_1_1(), "rule__ShortcutGen__WordAssignment_2_1_1");
			builder.put(grammarAccess.getShortcutGenAccess().getWordAssignment_3(), "rule__ShortcutGen__WordAssignment_3");
			builder.put(grammarAccess.getShortcutLibAccess().getShortcutAssignment_1(), "rule__ShortcutLib__ShortcutAssignment_1");
			builder.put(grammarAccess.getShortCutAccess().getShortcutAssignment_0(), "rule__ShortCut__ShortcutAssignment_0");
			builder.put(grammarAccess.getShortCutAccess().getShortcutAssignment_1(), "rule__ShortCut__ShortcutAssignment_1");
			builder.put(grammarAccess.getIgnoredTextAccess().getIgnoredAssignment(), "rule__IgnoredText__IgnoredAssignment");
			builder.put(grammarAccess.getUrlAdressAccess().getProtocolAssignment_0(), "rule__UrlAdress__ProtocolAssignment_0");
			builder.put(grammarAccess.getUrlAdressAccess().getUrlAssignment_1(), "rule__UrlAdress__UrlAssignment_1");
			builder.put(grammarAccess.getUrlAdressAccess().getUrlAssignment_2_0(), "rule__UrlAdress__UrlAssignment_2_0");
			builder.put(grammarAccess.getUrlAdressAccess().getUrlAssignment_2_1_0(), "rule__UrlAdress__UrlAssignment_2_1_0");
			builder.put(grammarAccess.getUrlAdressAccess().getUrlAssignment_2_1_1(), "rule__UrlAdress__UrlAssignment_2_1_1");
			builder.put(grammarAccess.getUrlAdressAccess().getUrlAssignment_2_1_2(), "rule__UrlAdress__UrlAssignment_2_1_2");
			builder.put(grammarAccess.getUrlAdressAccess().getUrlAssignment_3(), "rule__UrlAdress__UrlAssignment_3");
			builder.put(grammarAccess.getEmailATAccess().getEmailAssignment(), "rule__EmailAT__EmailAssignment");
			builder.put(grammarAccess.getMailAdressAccess().getEmailAssignment_0_0(), "rule__MailAdress__EmailAssignment_0_0");
			builder.put(grammarAccess.getMailAdressAccess().getEmailAssignment_0_1(), "rule__MailAdress__EmailAssignment_0_1");
			builder.put(grammarAccess.getMailAdressAccess().getEmailAssignment_1(), "rule__MailAdress__EmailAssignment_1");
			builder.put(grammarAccess.getMailAdressAccess().getEmailAssignment_2(), "rule__MailAdress__EmailAssignment_2");
			builder.put(grammarAccess.getFormulaAccess().getNameAssignment_0(), "rule__Formula__NameAssignment_0");
			builder.put(grammarAccess.getFormulaAccess().getNameAssignment_1_0(), "rule__Formula__NameAssignment_1_0");
			builder.put(grammarAccess.getFormulaAccess().getNameAssignment_1_1(), "rule__Formula__NameAssignment_1_1");
			builder.put(grammarAccess.getFormulaAccess().getParametersAssignment_2(), "rule__Formula__ParametersAssignment_2");
			builder.put(grammarAccess.getFormulaAccess().getNameAssignment_3_1_0(), "rule__Formula__NameAssignment_3_1_0");
			builder.put(grammarAccess.getFormulaAccess().getNameAssignment_3_1_1(), "rule__Formula__NameAssignment_3_1_1");
			builder.put(grammarAccess.getFormulaAccess().getParametersAssignment_3_2(), "rule__Formula__ParametersAssignment_3_2");
			builder.put(grammarAccess.getArrayAccess().getNameAssignment_0_0(), "rule__Array__NameAssignment_0_0");
			builder.put(grammarAccess.getArrayAccess().getNameAssignment_0_1(), "rule__Array__NameAssignment_0_1");
			builder.put(grammarAccess.getArrayAccess().getParametersAssignment_1(), "rule__Array__ParametersAssignment_1");
			builder.put(grammarAccess.getNew_LineAccess().getNlAssignment_1(), "rule__New_Line__NlAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private NaturalLangGrammarAccess grammarAccess;

	@Override
	protected InternalNaturalLangParser createParser() {
		InternalNaturalLangParser result = new InternalNaturalLangParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_SPACE" };
	}

	public NaturalLangGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(NaturalLangGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
