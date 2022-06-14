/**
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.naturalLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Url Adress</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.validas.spedit.naturalLang.UrlAdress#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.validas.spedit.naturalLang.UrlAdress#getUrl <em>Url</em>}</li>
 * </ul>
 *
 * @see de.validas.spedit.naturalLang.NaturalLangPackage#getUrlAdress()
 * @model
 * @generated
 */
public interface UrlAdress extends NoNElement
{
  /**
   * Returns the value of the '<em><b>Protocol</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Protocol</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Protocol</em>' attribute.
   * @see #setProtocol(String)
   * @see de.validas.spedit.naturalLang.NaturalLangPackage#getUrlAdress_Protocol()
   * @model
   * @generated
   */
  String getProtocol();

  /**
   * Sets the value of the '{@link de.validas.spedit.naturalLang.UrlAdress#getProtocol <em>Protocol</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Protocol</em>' attribute.
   * @see #getProtocol()
   * @generated
   */
  void setProtocol(String value);

  /**
   * Returns the value of the '<em><b>Url</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Url</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Url</em>' attribute list.
   * @see de.validas.spedit.naturalLang.NaturalLangPackage#getUrlAdress_Url()
   * @model unique="false"
   * @generated
   */
  EList<String> getUrl();

} // UrlAdress
