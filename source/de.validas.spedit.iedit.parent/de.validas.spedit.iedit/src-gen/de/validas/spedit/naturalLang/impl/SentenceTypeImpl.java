/**
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.naturalLang.impl;

import de.validas.spedit.naturalLang.NaturalLangPackage;
import de.validas.spedit.naturalLang.SentenceType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sentence Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.validas.spedit.naturalLang.impl.SentenceTypeImpl#getPEnd <em>PEnd</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SentenceTypeImpl extends MinimalEObjectImpl.Container implements SentenceType
{
  /**
   * The default value of the '{@link #getPEnd() <em>PEnd</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPEnd()
   * @generated
   * @ordered
   */
  protected static final String PEND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPEnd() <em>PEnd</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPEnd()
   * @generated
   * @ordered
   */
  protected String pEnd = PEND_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SentenceTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return NaturalLangPackage.Literals.SENTENCE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPEnd()
  {
    return pEnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPEnd(String newPEnd)
  {
    String oldPEnd = pEnd;
    pEnd = newPEnd;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NaturalLangPackage.SENTENCE_TYPE__PEND, oldPEnd, pEnd));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case NaturalLangPackage.SENTENCE_TYPE__PEND:
        return getPEnd();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case NaturalLangPackage.SENTENCE_TYPE__PEND:
        setPEnd((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case NaturalLangPackage.SENTENCE_TYPE__PEND:
        setPEnd(PEND_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case NaturalLangPackage.SENTENCE_TYPE__PEND:
        return PEND_EDEFAULT == null ? pEnd != null : !PEND_EDEFAULT.equals(pEnd);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (pEnd: ");
    result.append(pEnd);
    result.append(')');
    return result.toString();
  }

} //SentenceTypeImpl
