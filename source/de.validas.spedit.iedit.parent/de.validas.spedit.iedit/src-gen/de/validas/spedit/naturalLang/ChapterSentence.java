/**
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.naturalLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Chapter Sentence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.validas.spedit.naturalLang.ChapterSentence#getChapterNumber <em>Chapter Number</em>}</li>
 *   <li>{@link de.validas.spedit.naturalLang.ChapterSentence#getHeadline <em>Headline</em>}</li>
 * </ul>
 *
 * @see de.validas.spedit.naturalLang.NaturalLangPackage#getChapterSentence()
 * @model
 * @generated
 */
public interface ChapterSentence extends SentenceType
{
  /**
   * Returns the value of the '<em><b>Chapter Number</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Chapter Number</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Chapter Number</em>' containment reference.
   * @see #setChapterNumber(EObject)
   * @see de.validas.spedit.naturalLang.NaturalLangPackage#getChapterSentence_ChapterNumber()
   * @model containment="true"
   * @generated
   */
  EObject getChapterNumber();

  /**
   * Sets the value of the '{@link de.validas.spedit.naturalLang.ChapterSentence#getChapterNumber <em>Chapter Number</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Chapter Number</em>' containment reference.
   * @see #getChapterNumber()
   * @generated
   */
  void setChapterNumber(EObject value);

  /**
   * Returns the value of the '<em><b>Headline</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Headline</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Headline</em>' containment reference.
   * @see #setHeadline(LineSentenceChain)
   * @see de.validas.spedit.naturalLang.NaturalLangPackage#getChapterSentence_Headline()
   * @model containment="true"
   * @generated
   */
  LineSentenceChain getHeadline();

  /**
   * Sets the value of the '{@link de.validas.spedit.naturalLang.ChapterSentence#getHeadline <em>Headline</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Headline</em>' containment reference.
   * @see #getHeadline()
   * @generated
   */
  void setHeadline(LineSentenceChain value);

} // ChapterSentence
