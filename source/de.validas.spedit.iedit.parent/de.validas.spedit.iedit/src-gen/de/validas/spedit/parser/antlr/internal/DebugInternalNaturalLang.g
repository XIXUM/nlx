/*
 * generated by Xtext 2.16.0
 */
grammar DebugInternalNaturalLang;

// Rule Model
ruleModel:
	ruleSentenceType
	*
;

// Rule SentenceType
ruleSentenceType:
	ruleWhitespace?
	(
		(
			(ruleChapterSentence)=>
			ruleChapterSentence
		)
		    |
		ruleParagraphBlock
		    |
		ruleTable
	)
	ruleParagraph
;

// Rule Paragraph
ruleParagraph:
	(
		RULE_NEWLINE+
		    |
		RULE_END
	)
;

// Rule ParagraphBlock
ruleParagraphBlock:
	ruleBlockElement
	+
;

// Rule BlockElement
ruleBlockElement:
	(
		ruleSentenceChain
		    |
		ruleIgnoredText
		    |
		ruleFootNote
		    |
		(
			(ruleListSentence)=>
			ruleListSentence
		)
	)
;

// Rule FootNote
ruleFootNote:
	rulesimpleNum
	RULE_BR_CL
	ruleSentenceChain
;

// Rule TableLine
ruleTableLine:
	RULE_TABLE_LINE
;

// Rule TableBorder
ruleTableBorder:
	(
		ruleTableColumnSeparator
		    |
		ruleTableLine
	)
;

// Rule TableRow
ruleTableRow:
	ruleTableBorder
	ruleLineSentenceChain
	?
	(
		ruleTableBorder
		ruleLineSentenceChain
		?
	)*
	ruleTableBorder
;

// Rule TableColumnSeparator
ruleTableColumnSeparator:
	RULE_HORIZ_SEP
;

// Rule Table
ruleTable:
	ruleTableLine
	RULE_NEWLINE
	(
		ruleTableRow
		RULE_NEWLINE
	)+
	(
		ruleTableLine
		RULE_NEWLINE
		(
			ruleTableRow
			RULE_NEWLINE
		)+
	)*
	ruleTableLine
;

// Rule LineSentenceChain
ruleLineSentenceChain:
	ruleLineSentence
	(
		RULE_FULL_STOP_IM
		ruleLineSentence
	)*
	RULE_FULL_STOP_IM
	?
;

// Rule SentenceChain
ruleSentenceChain:
	(
		(ruleSentence
		)=>
		ruleSentence
	)
	(
		RULE_FULL_STOP_IM
		ruleSentenceX
	)*
	(
		RULE_FULL_STOP_NL
		    |
		RULE_NEWLINE
	)
;

// Rule SentenceChainX
ruleSentenceChainX:
	ruleSentence
	(
		RULE_FULL_STOP_IM
		ruleSentenceX
	)*
	(
		((
			RULE_FULL_STOP_NL
			    |
			RULE_NEWLINE
			    |
			RULE_KOMMA
		)
		)=>
		(
			RULE_FULL_STOP_NL
			    |
			RULE_NEWLINE
			    |
			RULE_KOMMA
		)
	)
;

// Rule Sentence
ruleSentence:
	ruleSubSentence
	(
		RULE_KOMMA
		ruleTrailSubSentence
	)*
;

// Rule LineSentence
ruleLineSentence:
	ruleLineSubSentence
	(
		RULE_KOMMA
		ruleLineSubSentence
	)*
;

// Rule FreeSentence
ruleFreeSentence:
	ruleFreeSubSentence
	(
		RULE_KOMMA
		ruleFreeSubSentence
	)*
;

// Rule SentenceX
ruleSentenceX:
	ruleTrailSubSentence
	(
		RULE_KOMMA
		ruleTrailSubSentence
	)*
;

// Rule ListSentence
ruleListSentence:
	ruleListPoint
	(
		ruleSentenceChainX
		    |
		RULE_NEWLINE
	)
;

// Rule ChapterSentence
ruleChapterSentence:
	(
		(
			(ruleChapter_Unit_Low
			)=>
			ruleChapter_Unit_Low
		)
		    |
		ruleChapterAlpha
		    |
		ruleChapter_Unit_HI
	)
	ruleLineSentenceChain
;

// Rule SubSentence
ruleSubSentence:
	(
		ruleNoNElement
		(
			RULE_SPACE
			ruleElements
		)*
		    |
		ruleNoNElementX
		(
			RULE_SPACE
			ruleElements
		)+
	)
	(
		RULE_SPACE?
		ruleNew_Line
		RULE_SPACE?
		ruleNoNElementX2
		(
			RULE_SPACE
			ruleElements
		)*
	)*
	RULE_SPACE?
;

// Rule TrailSubSentence
ruleTrailSubSentence:
	ruleElements
	(
		RULE_SPACE
		ruleElements
	)*
	(
		RULE_SPACE?
		ruleNew_Line
		RULE_SPACE?
		(
			(ruleNoNElementX2
			)=>
			ruleNoNElementX2
		)
		(
			RULE_SPACE
			ruleElements
		)*
	)*
	RULE_SPACE?
;

// Rule FreeSubSentence
ruleFreeSubSentence:
	(
		RULE_SPACE
		    |
		ruleNew_Line
	)*
	ruleAllElements
	(
		(
			RULE_SPACE
			    |
			ruleNew_Line
		)+
		ruleAllElements
	)*
	(
		RULE_SPACE
		    |
		ruleNew_Line
	)*
;

// Rule LineSubSentence
ruleLineSubSentence:
	ruleElements
	(
		RULE_SPACE
		ruleElements
	)*
	RULE_SPACE?
;

// Rule ListPoint
ruleListPoint:
	(
		RULE_MULTI
		    |
		RULE_DASH
		    |
		ruleListPointNum
		    |
		RULE_MINUS
	)
;

// Rule ListPointNum
ruleListPointNum:
	(
		RULE_INT
		(
			RULE_DOT
			RULE_BR_CL
			RULE_SPACE
			    |
			RULE_FULL_STOP_IM
		)
		    |
		RULE_ALPHA
		(
			RULE_DOT
			RULE_BR_CL
			RULE_SPACE
			    |
			RULE_FULL_STOP_IM
		)
	)
;

// Rule NoNElement
ruleNoNElement:
	(
		ruleQuote
		    |
		ruleBrackets
		    |
		ruleWord
		    |
		ruleSymbolsX
		    |
		ruleIgnoredText
		    |
		ruleShortCut
		    |
		ruleHashNumber
		    |
		ruleUrlAdress
		    |
		ruleMailAdress
		    |
		ruleFormula
		    |
		ruleArray
		    |
		ruleItWord
	)
;

// Rule Brackets
ruleBrackets:
	(
		ruleBracketSentence
		    |
		ruleExtBracketSentence
		    |
		ruleExtBracketSentenceC
	)
;

// Rule NoNElementX
ruleNoNElementX:
	(
		ruleNoNElement
		    |
		ruleWordShort
	)
;

// Rule NoNElementX2
ruleNoNElementX2:
	(
		ruleSimpleUnit
		    |
		ruleUnit
		    |
		ruleNoNElement
		    |
		ruleChapterAlpha
	)
;

// Rule Elements
ruleElements:
	(
		ruleSymbols
		    |
		(
			(ruleNoNElementX2)=>
			ruleNoNElementX2
		)
		    |
		ruleWordShort
	)
;

// Rule AllElements
ruleAllElements:
	(
		(
			(ruleElements)=>
			ruleElements
		)
		    |
		ruleNew_Line
	)
;

// Rule BracketSentence
ruleBracketSentence:
	RULE_BR_O
	(
		ruleFreeSentence
		(
			ruleFullStop
			ruleFreeSentence
		)*
	)?
	(
		RULE_DOT
		    |RULE_FS
		    |ruleFullStop
	)?
	(
		RULE_SPACE
		    |
		RULE_NEWLINE
	)*
	RULE_SPACE?
	(
		(RULE_BR_CL
		)=>
		RULE_BR_CL
	)
;

// Rule ExtBracketSentence
ruleExtBracketSentence:
	RULE_EXBR_O
	(
		ruleFreeSentence
		(
			ruleFullStop
			ruleFreeSentence
		)*
	)?
	(
		RULE_DOT
		    |RULE_FS
		    |ruleFullStop
	)?
	RULE_SPACE?
	(
		(RULE_EXBR_CL
		)=>
		RULE_EXBR_CL
	)
;

// Rule ExtBracketSentenceC
ruleExtBracketSentenceC:
	RULE_EXBRC_O
	(
		ruleFreeSentence
		(
			ruleFullStop
			ruleFreeSentence
		)*
	)?
	(
		RULE_DOT
		    |RULE_FS
		    |ruleFullStop
	)?
	RULE_SPACE?
	(
		(RULE_EXBRC_CL
		)=>
		RULE_EXBRC_CL
	)
;

// Rule FullStop
ruleFullStop:
	(
		RULE_FULL_STOP_NL
		    |
		RULE_FULL_STOP_IM
	)
;

// Rule Word
ruleWord:
	(
		ruleFragmentX
		    |
		(
			(ruleFragment
			)=>
			ruleFragment
		)
		(
			ruleSeparatorsL
			ruleFragment
		)+
	)
	ruleSeparatorsL
	?
;

// Rule WordShort
ruleWordShort:
	RULE_ALPHA
;

// Rule FragmentX
ruleFragmentX:
	(
		RULE_ID
		    |
		RULE_ID_C
		    |
		RULE_ALL_ALPHA
	)
;

// Rule Fragment
ruleFragment:
	(
		ruleFragmentX
		    |
		RULE_ALPHA
	)
;

// Rule Asterisk
ruleAsterisk:
	(
		RULE_MULTI
		RULE_MULTI?
		    |
		ruleFragment
		RULE_MULTI
		    |
		ruleItWordEl
		RULE_MULTI
	)
;

// Rule HashP
ruleHashP:
	RULE_HASH
;

// Rule ItWord
ruleItWord:
	(
		(
			(
				ruleSeparatorsIt
				+
				    |
				ruleHashP
				    |
				RULE_MULTI
				    |
				RULE_CURRENCY
			)
			(
				ruleItWordElXx
				    |
				ruleFragment
			)
			    |
			(
				ruleItWordEl
				    |
				RULE_CURL
				    |
				RULE_ALL_ALPHA
				RULE_COLON
			)
		)
		(
			ruleAllSep
			+
			ruleItWordElXx
		)*
		    |
		(
			(
				(ruleFragment
				)=>
				ruleFragment
			)
			    |
			ruleAsterisk
		)
		(
			ruleSeparatorsIt
			+
			ruleItWordElXx
			    |
			ruleAllSep
			+
			ruleItWordElX
		)
		(
			ruleAllSep
			+
			ruleItWordElXx
		)*
	)
	ruleAllSep
	*
;

// Rule Whitespace
ruleWhitespace:
	(
		RULE_SPACE
		    |
		RULE_SPACE?
		RULE_NEWLINE
		RULE_SPACE?
	)
;

// Rule ItWordEl
ruleItWordEl:
	(
		RULE_IT_ID
		    |
		RULE_DOUBLE_DOT
	)
;

// Rule ItWordElurl
ruleItWordElurl:
	(
		RULE_IT_ID
		    |
		RULE_ID_ALL
		    |
		RULE_ID
	)
;

// Rule ItWordElX
ruleItWordElX:
	(
		ruleItWordEl
		    |
		RULE_INT
		    |
		RULE_HEX_NUMBER
		    |
		RULE_ID_ALL
	)
;

// Rule ItWordElXx
ruleItWordElXx:
	(
		RULE_ALL_ALPHA
		    |
		RULE_ALPHA
		    |
		(
			(ruleItWordElX)=>
			ruleItWordElX
		)
		    |
		ruleFragment
		    |
		ruleAsterisk
		    |
		RULE_ID_C
		    |
		RULE_CURL
	)+
;

// Rule SeparatorsL
ruleSeparatorsL:
	(
		RULE_SLASH
		    |
		RULE_SEPARATORS
		    |
		RULE_DASH
		    |
		RULE_MINUS
	)
;

// Rule SeparatorsIt
ruleSeparatorsIt:
	(
		RULE_DOT
		    |
		RULE_SEPARATORS_IT
		    |
		RULE_COLON
	)
;

// Rule AllSep
ruleAllSep:
	(
		ruleSeparatorsIt
		    |
		ruleSeparatorsL
	)
;

// Rule Quote
ruleQuote:
	RULE_STRING
;

// Rule Unit
ruleUnit:
	RULE_MINUS
	?
	(
		(ruleNumber
		)=>
		ruleNumber
	)
	(
		RULE_CURRENCY
		    |
		RULE_ID
		    |
		RULE_PERCENT
	)?
;

// Rule SimpleUnit
ruleSimpleUnit:
	(
		rulechapterNum
		    |
		ruleItNum
		    |
		RULE_HEX_NUMBER
	)
;

// Rule Chapter_Unit_HI
ruleChapter_Unit_HI:
	rulechapterNum
	RULE_SPACE?
;

// Rule Chapter_Unit_Low
ruleChapter_Unit_Low:
	ruledecimalNumEN
	RULE_SPACE?
;

// Rule HashNumber
ruleHashNumber:
	(
		RULE_HASH
		    |RULE_PARAGR
	)
	ruleNumber
;

// Rule ChapterAlpha
ruleChapterAlpha:
	(
		RULE_ID_C
		    |
		RULE_ALL_ALPHA
	)
	RULE_DOT
	ruleChapterIntermediate
	(
		(
			RULE_DOT
			    |
			RULE_MINUS
		)
		ruleChapterIntermediate
	)*
	RULE_SPACE
;

// Rule ChapterIntermediate
ruleChapterIntermediate:
	(
		RULE_ID_C
		    |
		RULE_ID_ALL
		    |
		(
			(RULE_INT)=>
			RULE_INT
		)
		    |
		RULE_IT_ID
		    |
		RULE_ALL_ALPHA
		    |
		RULE_ALPHA
	)
;

// Rule SymbolsX
ruleSymbolsX:
	ruleSpecialSymbols
;

// Rule SpecialCh
ruleSpecialCh:
	(
		RULE_PERCENT
		    |
		RULE_DASH
		    |
		RULE_MINUS
		    |
		RULE_SEPARATORS
		    |
		RULE_MULTI
	)
;

// Rule Symbols
ruleSymbols:
	ruleSpecialCh
;

// Rule ShortcutGen
ruleShortcutGen:
	(
		RULE_ALL_ALPHA
		    |
		RULE_ALPHA
	)
	(
		RULE_DOT
		(
			RULE_ALL_ALPHA
			    |
			RULE_ALPHA
		)
	)+
	RULE_DOT
;

// Rule ShortcutLib
ruleShortcutLib:
	RULE_SHORTCUTS
;

// Rule ShortCut
ruleShortCut:
	(
		ruleShortcutLib
		    |
		ruleShortcutGen
	)
;

// Rule IgnoredText
ruleIgnoredText:
	RULE_IGNORED
;

// Rule simpleNum
rulesimpleNum:
	RULE_INT
;

// Rule ItNum
ruleItNum:
	RULE_INT
	(
		(
			RULE_SEPARATORS_IT
			    |
			RULE_COLON
			    |
			RULE_DASH
			    |
			RULE_MINUS
			    |
			RULE_SLASH
		)
		RULE_INT
	)+
	(
		RULE_KM
		RULE_INT
	)?
;

// Rule SpecialSymbols
ruleSpecialSymbols:
	(
		RULE_SLASH
		    |
		RULE_OPERATORS
		    |
		RULE_ARROW
		    |
		RULE_SMILEY
		    |
		RULE_TRIPLE_DOT
	)
;

// Rule decimalNumEN
ruledecimalNumEN:
	RULE_INT
	RULE_DOT
	RULE_INT
;

// Rule decimalNumDE
ruledecimalNumDE:
	RULE_INT
	RULE_KM
	RULE_INT
;

// Rule chapterNum
rulechapterNum:
	RULE_INT
	(
		RULE_DOT
		ruleChapterIntermediate
	)+
;

// Rule Number
ruleNumber:
	(
		rulesimpleNum
		    |
		ruledecimalNumEN
		    |
		ruledecimalNumDE
	)
;

// Rule UrlAdress
ruleUrlAdress:
	RULE_URL_PROTOCOL
	ruleItWordElurl
	(
		ruleAllSep
		+
		(
			ruleItWordElXx
			    |
			rulesimpleNum
			    |
			ruleFragment
		)
	)*
	ruleAllSep
	*
;

// Rule EmailAT
ruleEmailAT:
	RULE_AT
;

// Rule MailAdress
ruleMailAdress:
	(
		ruleItWord
		    |
		ruleWord
	)
	ruleEmailAT
	(
		(ruleItWord
		)=>
		ruleItWord
	)
;

// Rule Formula
ruleFormula:
	ruleEmailAT
	?
	(
		ruleItWord
		    |
		ruleWord
	)
	ruleBracketSentence
	(
		RULE_DOT
		(
			ruleItWord
			    |
			ruleWord
		)
		ruleBracketSentence
	)*
;

// Rule Array
ruleArray:
	(
		ruleItWord
		    |
		ruleWord
	)
	ruleExtBracketSentence
	+
;

// Rule New_Line
ruleNew_Line:
	RULE_NEWLINE
;

RULE_COLON : ':';

RULE_DOT : '.';

RULE_FS : (RULE_DOT|';'|RULE_INTERJ|RULE_COLON);

fragment RULE_INTERJ : ('?'|'!');

RULE_KM : ',';

RULE_SPACE : (' '|'\t')+ {skip();};

RULE_NEWLINE : '\r'? '\n';

RULE_CURL : '~';

RULE_OPERATORS : (RULE_AND RULE_AND?|RULE_EXP|RULE_PLUS|RULE_CURL|RULE_EQUAL RULE_EQUAL?|RULE_INTERJ RULE_EQUAL|RULE_GT RULE_EQUAL|RULE_SM RULE_EQUAL|RULE_GT RULE_GT|RULE_SM RULE_SM);

fragment RULE_WS : (RULE_NEWLINE|RULE_SPACE);

RULE_ARROW : (RULE_MINUS* RULE_GT|RULE_SM RULE_MINUS*);

RULE_FULL_STOP_IM : RULE_FS RULE_SPACE;

RULE_FULL_STOP_NL : RULE_FS RULE_SPACE? RULE_NEWLINE;

RULE_END : EOF;

RULE_KOMMA : RULE_KM RULE_WS;

RULE_ALPHA : ('a'..'z'|'\u00E4'..'\u00FC'|'\u00DF'|'\u00E0'..'\u00F9'|'\u00E1'..'\u00FA');

RULE_ALL_ALPHA : (RULE_ALPHA_CAPITAL|RULE_ALPHA);

RULE_ID : RULE_ALL_ALPHA RULE_ALPHA+;

RULE_ID_C : RULE_ALPHA_CAPITAL RULE_ALPHA_CAPITAL+;

RULE_AT : '@';

RULE_HEX_NUMBER : '0x' ('0'..'9'|'A'..'F')+;

fragment RULE_ALPHA_CAPITAL : ('A'..'Z'|'\u00C4'..'\u00DC'|'\u00C0'..'\u00D9'|'\u00C1'..'\u00DA');

fragment RULE_ALPHA_NUMERIC : (RULE_ALPHA|'0'..'9');

RULE_MINUS : '-';

RULE_PERCENT : '%';

fragment RULE_EQUAL : '=';

fragment RULE_EXP : '^';

fragment RULE_AND : '&';

RULE_SEPARATORS : ('\''|'\u2019'|'\u00B4'|RULE_BACKSLASH);

RULE_SEPARATORS_IT : (RULE_UNDERSCORE|RULE_COLON);

RULE_INT : ('0'..'9')+;

fragment RULE_UNDERSCORE : '_';

RULE_BR_O : '(';

RULE_EXBR_O : '[';

RULE_EXBRC_O : '{';

RULE_BR_CL : ')';

RULE_EXBR_CL : ']';

RULE_EXBRC_CL : '}';

fragment RULE_GT : '>';

fragment RULE_SM : '<';

RULE_IT_ID : (RULE_ALPHA|RULE_ALPHA_CAPITAL) RULE_ALPHA_NUMERIC_C+;

RULE_DOUBLE_DOT : RULE_DOT RULE_DOT;

RULE_TRIPLE_DOT : RULE_DOT RULE_DOT RULE_DOT;

fragment RULE_DECORATIONS : (RULE_EQUAL RULE_EQUAL RULE_EQUAL+|RULE_MULTI RULE_MULTI RULE_MULTI+|RULE_HASH RULE_HASH+|RULE_DOT RULE_DOT RULE_DOT RULE_DOT+|RULE_MINUS RULE_MINUS+);

RULE_IGNORED : RULE_DECORATIONS;

RULE_SMILEY : (':)'|':-)'|';)'|';-)'|':D'|':('|':-('|'\u00A9'|'\u00AE');

RULE_URL_PROTOCOL : ('http' 's'? '://'|'ftp://'|'ssh://'|'svn://');

RULE_HASH : '#';

RULE_PARAGR : '\u00A7';

fragment RULE_PLUS : '+';

RULE_MULTI : '*';

RULE_DASH : ('\u2013'|'\u2014');

RULE_HORIZ_SEP : '|';

fragment RULE_BACKSLASH : '\\';

RULE_SLASH : '/';

RULE_CURRENCY : ('$'|'\u20AC');

fragment RULE_ALPHA_NUMERIC_C : (RULE_ALPHA_CAPITAL|RULE_ALPHA_NUMERIC);

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\u201C' ( options {greedy=false;} : . )*'\u201D');

RULE_TABLE_LINE : RULE_PLUS RULE_MINUS+ (RULE_PLUS RULE_MINUS+)* RULE_PLUS;

RULE_ID_ALL : RULE_ALPHA_NUMERIC_C RULE_ALPHA_NUMERIC_C+;

RULE_SHORTCUTS : ('etc.'|'asf.'|'bzw.'|'bspw.'|'Evtl.'|'evtl.'|'Inc.'|'inc.'|'Bspw.'|'Bzw.'|'Dr.'|'Prof.'|'Ing.'|'med.');

RULE_ANY_OTHER : .;
