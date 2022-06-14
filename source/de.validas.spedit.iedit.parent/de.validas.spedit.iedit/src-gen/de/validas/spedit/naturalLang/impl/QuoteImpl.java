/**
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.naturalLang.impl;

import de.validas.spedit.naturalLang.NaturalLangPackage;
import de.validas.spedit.naturalLang.Quote;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quote</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.validas.spedit.naturalLang.impl.QuoteImpl#getQuote <em>Quote</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QuoteImpl extends NoNElementImpl implements Quote
{
  /**
   * The default value of the '{@link #getQuote() <em>Quote</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuote()
   * @generated
   * @ordered
   */
  protected static final String QUOTE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getQuote() <em>Quote</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuote()
   * @generated
   * @ordered
   */
  protected String quote = QUOTE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QuoteImpl()
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
    return NaturalLangPackage.Literals.QUOTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getQuote()
  {
    return quote;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuote(String newQuote)
  {
    String oldQuote = quote;
    quote = newQuote;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NaturalLangPackage.QUOTE__QUOTE, oldQuote, quote));
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
      case NaturalLangPackage.QUOTE__QUOTE:
        return getQuote();
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
      case NaturalLangPackage.QUOTE__QUOTE:
        setQuote((String)newValue);
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
      case NaturalLangPackage.QUOTE__QUOTE:
        setQuote(QUOTE_EDEFAULT);
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
      case NaturalLangPackage.QUOTE__QUOTE:
        return QUOTE_EDEFAULT == null ? quote != null : !QUOTE_EDEFAULT.equals(quote);
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (quote: ");
    result.append(quote);
    result.append(')');
    return result.toString();
  }

} //QuoteImpl
