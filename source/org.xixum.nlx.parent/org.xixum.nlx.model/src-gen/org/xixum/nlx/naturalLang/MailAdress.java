/**
 * generated by Xtext 2.16.0
 */
package org.xixum.nlx.naturalLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mail Adress</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xixum.nlx.naturalLang.MailAdress#getEmail <em>Email</em>}</li>
 * </ul>
 *
 * @see org.xixum.nlx.naturalLang.NaturalLangPackage#getMailAdress()
 * @model
 * @generated
 */
public interface MailAdress extends NoNElement
{
  /**
   * Returns the value of the '<em><b>Email</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Email</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Email</em>' containment reference list.
   * @see org.xixum.nlx.naturalLang.NaturalLangPackage#getMailAdress_Email()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getEmail();

} // MailAdress
