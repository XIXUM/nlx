/**
 * generated by Xtext 2.16.0
 */
package org.xixum.nlx.model.ui.quickfix;

import com.google.inject.Inject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.quickfix.XtextResourceMarkerAnnotationModel;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.xixum.nlx.constants.NaturalLangConstants;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.model.ui.constants.EditorUiConstants;
import org.xixum.nlx.model.ui.editor.NaturalLangEditor;
import org.xixum.nlx.model.ui.editor.model.NlxDocument;
import org.xixum.nlx.presets.NlxDictConstants;
import org.xixum.utils.data.util.ClassUtil;

/**
 * Custom quickfixes.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
@SuppressWarnings("all")
public class NaturalLangQuickfixProvider extends DefaultQuickfixProvider {
  @Inject
  private IDictionaryAccess dictAcc;

  private final /* List<Map<String, Object>> */Object acceptors /* Skipped initializer because of errors */;

  @Fix(NaturalLangConstants._TRAIN_DICT_)
  public void trainDictionary(final Issue issue, final IssueResolutionAcceptor acceptor) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field NaturalLangQuickfixProvider.acceptors refers to the missing type Object");
  }

  public void internal_addToDictionary(final IXtextDocument document, final EObject element, final Issue issue, final NlxDictConstants constant) {
    final String word = issue.getData()[0];
    this.dictAcc.addToDictionary(word, constant.getNodeType());
    final IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
    if ((part instanceof NaturalLangEditor)) {
      final ISelection selection = ((NaturalLangEditor)part).getSelection();
      if ((selection != null)) {
        ((NaturalLangEditor)part).setSelection(selection);
      }
    }
    this.updateMarkers(document, issue, word);
  }

  /**
   * Goes through al Xtext markers and removes the trained Word
   */
  public void updateMarkers(final IXtextDocument document, final Issue issue, final String word) {
    try {
      if ((document instanceof NlxDocument)) {
        final List<IDocumentListener> ListenerList = ((NlxDocument)document).getDocumentListeners();
        for (final IDocumentListener listener : ListenerList) {
          {
            Object model = ClassUtil.getOuterClassInstOfAnonymous(listener);
            if ((model instanceof XtextResourceMarkerAnnotationModel)) {
              Iterator<Annotation> iterator2 = ((XtextResourceMarkerAnnotationModel)model).getAnnotationIterator();
              while (iterator2.hasNext()) {
                {
                  Annotation elm = iterator2.next();
                  if ((elm instanceof XtextAnnotation)) {
                    Issue iss = ((XtextAnnotation) elm).getIssue();
                    if ((((iss.getData() != null) && (!((List<String>)Conversions.doWrapArray(iss.getData())).isEmpty())) && (iss.getData()[0]).toLowerCase().equals((issue.getData()[0]).toLowerCase()))) {
                      ((XtextAnnotation)elm).markDeleted(true);
                      ((XtextResourceMarkerAnnotationModel)model).fireAnnotationChangedEvent(elm);
                    }
                  }
                  if (((elm instanceof MarkerAnnotation) && elm.getType().equals(EditorUiConstants._NLX_INFO_ANNOTATION_TYPE))) {
                    IMarker marker = ((MarkerAnnotation) elm).getMarker();
                    Map<String, Object> attributes = marker.getAttributes();
                    Object _get = attributes.get(EditorUiConstants._NLX_DATA_KEY);
                    String[] name = ((String) _get).split(":");
                    if (((((List<String>)Conversions.doWrapArray(name)).size() == 2) && (name[1]).equals(word))) {
                      elm.markDeleted(true);
                      ((XtextResourceMarkerAnnotationModel)model).fireAnnotationChangedEvent(elm);
                    }
                  }
                }
              }
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Fix(NaturalLangConstants._TYPO_)
  public void capitalizeName(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final IModification _function = (IModificationContext context) -> {
      final IXtextDocument xtextDocument = context.getXtextDocument();
      final String firstLetter = xtextDocument.get((issue.getOffset()).intValue(), 1);
      xtextDocument.replace((issue.getOffset()).intValue(), 1, firstLetter.toUpperCase());
    };
    acceptor.accept(issue, EditorUiConstants._UI_CAPITALIZE_NAME, EditorUiConstants._UI_CAPITALIZE_THE_NAME, EditorUiConstants._NLX_CAP_IMAGE_URL, _function);
  }
}
