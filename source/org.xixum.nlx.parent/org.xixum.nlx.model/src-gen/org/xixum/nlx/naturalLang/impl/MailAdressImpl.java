/**
 * generated by Xtext 2.16.0
 */
package org.xixum.nlx.naturalLang.impl;

import org.xixum.nlx.naturalLang.MailAdress;
import org.xixum.nlx.naturalLang.NaturalLangPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mail Adress</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xixum.nlx.naturalLang.impl.MailAdressImpl#getEmail <em>Email</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MailAdressImpl extends NoNElementImpl implements MailAdress
{
  /**
   * The cached value of the '{@link #getEmail() <em>Email</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmail()
   * @generated
   * @ordered
   */
  protected EList<EObject> email;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MailAdressImpl()
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
    return NaturalLangPackage.Literals.MAIL_ADRESS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getEmail()
  {
    if (email == null)
    {
      email = new EObjectContainmentEList<EObject>(EObject.class, this, NaturalLangPackage.MAIL_ADRESS__EMAIL);
    }
    return email;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case NaturalLangPackage.MAIL_ADRESS__EMAIL:
        return ((InternalEList<?>)getEmail()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case NaturalLangPackage.MAIL_ADRESS__EMAIL:
        return getEmail();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case NaturalLangPackage.MAIL_ADRESS__EMAIL:
        getEmail().clear();
        getEmail().addAll((Collection<? extends EObject>)newValue);
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
      case NaturalLangPackage.MAIL_ADRESS__EMAIL:
        getEmail().clear();
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
      case NaturalLangPackage.MAIL_ADRESS__EMAIL:
        return email != null && !email.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MailAdressImpl
