/**
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.naturalLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foot Note</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.validas.spedit.naturalLang.FootNote#getNumber <em>Number</em>}</li>
 *   <li>{@link de.validas.spedit.naturalLang.FootNote#getSentenceChain <em>Sentence Chain</em>}</li>
 * </ul>
 *
 * @see de.validas.spedit.naturalLang.NaturalLangPackage#getFootNote()
 * @model
 * @generated
 */
public interface FootNote extends BlockElement
{
  /**
   * Returns the value of the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number</em>' attribute.
   * @see #setNumber(String)
   * @see de.validas.spedit.naturalLang.NaturalLangPackage#getFootNote_Number()
   * @model
   * @generated
   */
  String getNumber();

  /**
   * Sets the value of the '{@link de.validas.spedit.naturalLang.FootNote#getNumber <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' attribute.
   * @see #getNumber()
   * @generated
   */
  void setNumber(String value);

  /**
   * Returns the value of the '<em><b>Sentence Chain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sentence Chain</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sentence Chain</em>' containment reference.
   * @see #setSentenceChain(SentenceChain)
   * @see de.validas.spedit.naturalLang.NaturalLangPackage#getFootNote_SentenceChain()
   * @model containment="true"
   * @generated
   */
  SentenceChain getSentenceChain();

  /**
   * Sets the value of the '{@link de.validas.spedit.naturalLang.FootNote#getSentenceChain <em>Sentence Chain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sentence Chain</em>' containment reference.
   * @see #getSentenceChain()
   * @generated
   */
  void setSentenceChain(SentenceChain value);

} // FootNote
