<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.spedit.iedit.ui/src/de/validas/spedit/ui/editor/validation/NlxAnnotationIssueProcessor.java
/**
 * 
 */
package de.validas.spedit.ui.editor.validation;

import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import de.validas.spedit.ui.editor.NaturalLangEditor;

/**
 * @author Felix Schaller
 *
 */
public class NlxAnnotationIssueProcessor extends AnnotationIssueProcessor {

	/**
	 * @param xtextDocument
	 * @param annotationModel
	 * @param issueResolutionProvider
	 */
	public NlxAnnotationIssueProcessor(IXtextDocument xtextDocument, IAnnotationModel annotationModel,
			IssueResolutionProvider issueResolutionProvider) {
		super(xtextDocument, annotationModel, issueResolutionProvider);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean isRelevantAnnotationType(String type) {
		//TODO: get types from preferences
		return type.equals(XtextEditor.ERROR_ANNOTATION_TYPE) || type.equals(XtextEditor.WARNING_ANNOTATION_TYPE) || type.equals(NaturalLangEditor.INFO_ANNOTATION_TYPE) || type.equals(XtextEditor.INFO_ANNOTATION_TYPE);
	}

}
=======
/**
 * 
 */
package org.xixum.nlx.model.ui.editor.validation;

import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;

import static org.xixum.nlx.model.ui.constants.EditorUiConstants.INFO_ANNOTATION_TYPE;

/**
 * @author Felix Schaller
 *
 */
public class NlxAnnotationIssueProcessor extends AnnotationIssueProcessor {

	/**
	 * @param xtextDocument
	 * @param annotationModel
	 * @param issueResolutionProvider
	 */
	public NlxAnnotationIssueProcessor(IXtextDocument xtextDocument, IAnnotationModel annotationModel,
			IssueResolutionProvider issueResolutionProvider) {
		super(xtextDocument, annotationModel, issueResolutionProvider);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean isRelevantAnnotationType(String type) {
		//TODO: get types from preferences
		return type.equals(XtextEditor.ERROR_ANNOTATION_TYPE) || type.equals(XtextEditor.WARNING_ANNOTATION_TYPE) || type.equals(INFO_ANNOTATION_TYPE) || type.equals(XtextEditor.INFO_ANNOTATION_TYPE);
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.model.ui/src/org/xixum/nlx/ui/editor/validation/NlxAnnotationIssueProcessor.java
