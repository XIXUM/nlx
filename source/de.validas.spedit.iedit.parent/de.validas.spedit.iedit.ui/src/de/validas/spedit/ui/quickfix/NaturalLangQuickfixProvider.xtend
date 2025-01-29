/*
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.ui.quickfix

import com.google.inject.Inject
import de.validas.nlx.dictionary.IDictionaryAccess
import de.validas.spedit.constants.NaturalLangConstants
import de.validas.spedit.presets.NlxDictConstants
import de.validas.spedit.ui.editor.model.NlxDocument
import de.validas.utils.data.util.ClassUtil
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.text.IDocumentListener
import org.eclipse.ui.texteditor.MarkerAnnotation
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.ui.editor.quickfix.XtextResourceMarkerAnnotationModel
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation
import org.eclipse.xtext.validation.Issue

import static de.validas.spedit.ui.constants.EditorUiConstants._NLX_CAP_IMAGE_URL
import static de.validas.spedit.ui.constants.EditorUiConstants._NLX_DATA_KEY
import static de.validas.spedit.ui.constants.EditorUiConstants._NLX_INFO_ANNOTATION_TYPE
import static de.validas.spedit.ui.constants.EditorUiConstants._NLX_TRAIN_IMAGE_URL
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_CAPITALIZE_NAME
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_CAPITALIZE_THE_NAME
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_MSG_NOUN
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_MSG_NAME
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_MSG_PRONOUN
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_MSG_ARTICLE
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_MSG_VERB
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_MSG_ADJECTIVE
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_MSG_ADVERB
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_MSG_PREPOSITION
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_MSG_CONJUNCTION
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_MSG_INTERJECTION
import static de.validas.spedit.ui.constants.EditorUiConstants._UI_MSG_UNDEFINED

import static de.validas.nlx.dictionary.constants.DictionaryConstants.NOUN_ 		
import static de.validas.nlx.dictionary.constants.DictionaryConstants.NAME_ 		
import static de.validas.nlx.dictionary.constants.DictionaryConstants.PRONOUN_ 	
import static de.validas.nlx.dictionary.constants.DictionaryConstants.ARTICLE_ 	
import static de.validas.nlx.dictionary.constants.DictionaryConstants.VERB_ 		
import static de.validas.nlx.dictionary.constants.DictionaryConstants.ADJECTIVE_ 	
import static de.validas.nlx.dictionary.constants.DictionaryConstants.ADVERB_ 		
import static de.validas.nlx.dictionary.constants.DictionaryConstants.PREPOSITION_ 
import static de.validas.nlx.dictionary.constants.DictionaryConstants.CONJUNCTION_ 
import static de.validas.nlx.dictionary.constants.DictionaryConstants.INTERJECTION_
import static de.validas.nlx.dictionary.constants.DictionaryConstants.UNDEFINED_ 	

import static de.validas.spedit.ui.constants.EditorUiConstants._DATA
import static de.validas.spedit.ui.constants.EditorUiConstants._LABEL
import static de.validas.spedit.ui.constants.EditorUiConstants._MSG
import de.validas.spedit.ui.editor.NaturalLangEditor
import org.eclipse.ui.PlatformUI

/**
 * Custom quickfixes.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
class NaturalLangQuickfixProvider extends DefaultQuickfixProvider {
	@Inject
	IDictionaryAccess dictAcc;
	val acceptors = #[
				#{_LABEL -> NOUN_ 			, _MSG -> _UI_MSG_NOUN			, _DATA -> NlxDictConstants.NOUN			},
				#{_LABEL -> NAME_ 			, _MSG -> _UI_MSG_NAME			, _DATA -> NlxDictConstants.NAME			},
				#{_LABEL -> PRONOUN_ 		, _MSG -> _UI_MSG_PRONOUN		, _DATA -> NlxDictConstants.PRONOUN 		},
				#{_LABEL -> ARTICLE_ 		, _MSG -> _UI_MSG_ARTICLE		, _DATA -> NlxDictConstants.ARTICLE 		},
				#{_LABEL -> VERB_ 			, _MSG -> _UI_MSG_VERB			, _DATA -> NlxDictConstants.VERB 			},
				#{_LABEL -> ADJECTIVE_ 		, _MSG -> _UI_MSG_ADJECTIVE		, _DATA -> NlxDictConstants.ADJECTIVE 		},
				#{_LABEL -> ADVERB_ 		, _MSG -> _UI_MSG_ADVERB		, _DATA -> NlxDictConstants.ADVERB 			},
				#{_LABEL -> PREPOSITION_ 	, _MSG -> _UI_MSG_PREPOSITION	, _DATA -> NlxDictConstants.PREPOSITION 	},
				#{_LABEL -> CONJUNCTION_ 	, _MSG -> _UI_MSG_CONJUNCTION	, _DATA -> NlxDictConstants.CONJUNCTION 	},
				#{_LABEL -> INTERJECTION_	, _MSG -> _UI_MSG_INTERJECTION	, _DATA -> NlxDictConstants.INTERJECTION	},
				#{_LABEL -> UNDEFINED_ 		, _MSG -> _UI_MSG_UNDEFINED		, _DATA -> NlxDictConstants.SPECIAL_TYPE	}
				
	]


@Fix(NaturalLangConstants._TRAIN_DICT_)
	def trainDictionary(Issue issue, IssueResolutionAcceptor acceptor) {
		
		for (accept : acceptors){
			acceptor.accept(issue, accept.get(_LABEL) as String, accept.get(_MSG) as String, _NLX_TRAIN_IMAGE_URL) [ element, context |
			val xtextDocument = context.xtextDocument
			internal_addToDictionary(xtextDocument, element, issue, accept.get(_DATA) as NlxDictConstants)
		]	
		}

	}

	def internal_addToDictionary(IXtextDocument document, EObject element, Issue issue, NlxDictConstants constant) {
		val String word = issue.data.get(0)
		dictAcc.addToDictionary(word, constant.nodeType);
		val part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if (part instanceof NaturalLangEditor){
			val selection = part.selection
			if (selection !== null)
				part.selection = selection
		}
		
		updateMarkers(document, issue, word);
	}

	/**
	 * Goes through al Xtext markers and removes the trained Word
	 */
	def updateMarkers(IXtextDocument document, Issue issue, String word) {
		if (document instanceof NlxDocument) {
			val List<IDocumentListener> ListenerList = document.getDocumentListeners()
			for (listener : ListenerList) {
				var model = ClassUtil.getOuterClassInstOfAnonymous(listener)
				if (model instanceof XtextResourceMarkerAnnotationModel) {
					var iterator2 = model.annotationIterator
					while (iterator2.hasNext) {
						var elm = iterator2.next
						if (elm instanceof XtextAnnotation) {
							var iss = (elm as XtextAnnotation).issue
							if (iss.data !== null && !iss.data.isEmpty && iss.data.get(0).toLowerCase.equals(issue.data.get(0).toLowerCase)) { //TODO: 05.10.21 causes Null-Pointer do a Null check
								elm.markDeleted(true)    
								model.fireAnnotationChangedEvent(elm)
							}														//TODO: 20.02.22 scroll restore. cursor is getting refreshed to top after this 
						}
						if (elm instanceof MarkerAnnotation && elm.type.equals(_NLX_INFO_ANNOTATION_TYPE)) {
							var marker = (elm as MarkerAnnotation).marker
							var attributes = marker.attributes
							var name = (attributes.get(_NLX_DATA_KEY) as String).split(':')
							if (name.size == 2 && name.get(1).equals(word)) {
								elm.markDeleted(true)
								//model.queueAnnotationChanged(elm)
								model.fireAnnotationChangedEvent(elm)
							}
						}
					}
					//model.updateMarkers(document)
				}
			}
		}
	}

@Fix(NaturalLangConstants._TYPO_)
	def capitalizeName(Issue issue, IssueResolutionAcceptor acceptor) {
		// val name = xtextDocument.get(issue.offset, issue.length)
		acceptor.accept(issue, _UI_CAPITALIZE_NAME, _UI_CAPITALIZE_THE_NAME, _NLX_CAP_IMAGE_URL) [ context |
			val xtextDocument = context.xtextDocument
			val firstLetter = xtextDocument.get(issue.offset, 1)
			xtextDocument.replace(issue.offset, 1, firstLetter.toUpperCase)
		]
	}

}
