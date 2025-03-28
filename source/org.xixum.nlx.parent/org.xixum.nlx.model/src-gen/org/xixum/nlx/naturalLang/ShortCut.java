/**
 * generated by Xtext 2.16.0
 */
package org.xixum.nlx.naturalLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Short Cut</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xixum.nlx.naturalLang.ShortCut#getShortcut <em>Shortcut</em>}</li>
 * </ul>
 *
 * @see org.xixum.nlx.naturalLang.NaturalLangPackage#getShortCut()
 * @model
 * @generated
 */
public interface ShortCut extends NoNElement
{
  /**
   * Returns the value of the '<em><b>Shortcut</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Shortcut</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Shortcut</em>' containment reference.
   * @see #setShortcut(EObject)
   * @see org.xixum.nlx.naturalLang.NaturalLangPackage#getShortCut_Shortcut()
   * @model containment="true"
   * @generated
   */
  EObject getShortcut();

  /**
   * Sets the value of the '{@link org.xixum.nlx.naturalLang.ShortCut#getShortcut <em>Shortcut</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Shortcut</em>' containment reference.
   * @see #getShortcut()
   * @generated
   */
  void setShortcut(EObject value);

} // ShortCut
