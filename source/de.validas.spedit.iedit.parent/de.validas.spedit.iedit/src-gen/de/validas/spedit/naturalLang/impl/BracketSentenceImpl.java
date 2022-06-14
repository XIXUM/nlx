/**
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.naturalLang.impl;

import de.validas.spedit.naturalLang.BracketSentence;
import de.validas.spedit.naturalLang.FreeSentence;
import de.validas.spedit.naturalLang.NaturalLangPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bracket Sentence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.validas.spedit.naturalLang.impl.BracketSentenceImpl#getOpen <em>Open</em>}</li>
 *   <li>{@link de.validas.spedit.naturalLang.impl.BracketSentenceImpl#getBrackedSentences <em>Bracked Sentences</em>}</li>
 *   <li>{@link de.validas.spedit.naturalLang.impl.BracketSentenceImpl#getSeparator <em>Separator</em>}</li>
 *   <li>{@link de.validas.spedit.naturalLang.impl.BracketSentenceImpl#getClose <em>Close</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BracketSentenceImpl extends BracketsImpl implements BracketSentence
{
  /**
   * The default value of the '{@link #getOpen() <em>Open</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpen()
   * @generated
   * @ordered
   */
  protected static final String OPEN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOpen() <em>Open</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpen()
   * @generated
   * @ordered
   */
  protected String open = OPEN_EDEFAULT;

  /**
   * The cached value of the '{@link #getBrackedSentences() <em>Bracked Sentences</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBrackedSentences()
   * @generated
   * @ordered
   */
  protected EList<FreeSentence> brackedSentences;

  /**
   * The cached value of the '{@link #getSeparator() <em>Separator</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeparator()
   * @generated
   * @ordered
   */
  protected EList<String> separator;

  /**
   * The default value of the '{@link #getClose() <em>Close</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClose()
   * @generated
   * @ordered
   */
  protected static final String CLOSE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getClose() <em>Close</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClose()
   * @generated
   * @ordered
   */
  protected String close = CLOSE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BracketSentenceImpl()
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
    return NaturalLangPackage.Literals.BRACKET_SENTENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOpen()
  {
    return open;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpen(String newOpen)
  {
    String oldOpen = open;
    open = newOpen;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NaturalLangPackage.BRACKET_SENTENCE__OPEN, oldOpen, open));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FreeSentence> getBrackedSentences()
  {
    if (brackedSentences == null)
    {
      brackedSentences = new EObjectContainmentEList<FreeSentence>(FreeSentence.class, this, NaturalLangPackage.BRACKET_SENTENCE__BRACKED_SENTENCES);
    }
    return brackedSentences;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getSeparator()
  {
    if (separator == null)
    {
      separator = new EDataTypeEList<String>(String.class, this, NaturalLangPackage.BRACKET_SENTENCE__SEPARATOR);
    }
    return separator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getClose()
  {
    return close;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClose(String newClose)
  {
    String oldClose = close;
    close = newClose;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NaturalLangPackage.BRACKET_SENTENCE__CLOSE, oldClose, close));
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
      case NaturalLangPackage.BRACKET_SENTENCE__BRACKED_SENTENCES:
        return ((InternalEList<?>)getBrackedSentences()).basicRemove(otherEnd, msgs);
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
      case NaturalLangPackage.BRACKET_SENTENCE__OPEN:
        return getOpen();
      case NaturalLangPackage.BRACKET_SENTENCE__BRACKED_SENTENCES:
        return getBrackedSentences();
      case NaturalLangPackage.BRACKET_SENTENCE__SEPARATOR:
        return getSeparator();
      case NaturalLangPackage.BRACKET_SENTENCE__CLOSE:
        return getClose();
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
      case NaturalLangPackage.BRACKET_SENTENCE__OPEN:
        setOpen((String)newValue);
        return;
      case NaturalLangPackage.BRACKET_SENTENCE__BRACKED_SENTENCES:
        getBrackedSentences().clear();
        getBrackedSentences().addAll((Collection<? extends FreeSentence>)newValue);
        return;
      case NaturalLangPackage.BRACKET_SENTENCE__SEPARATOR:
        getSeparator().clear();
        getSeparator().addAll((Collection<? extends String>)newValue);
        return;
      case NaturalLangPackage.BRACKET_SENTENCE__CLOSE:
        setClose((String)newValue);
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
      case NaturalLangPackage.BRACKET_SENTENCE__OPEN:
        setOpen(OPEN_EDEFAULT);
        return;
      case NaturalLangPackage.BRACKET_SENTENCE__BRACKED_SENTENCES:
        getBrackedSentences().clear();
        return;
      case NaturalLangPackage.BRACKET_SENTENCE__SEPARATOR:
        getSeparator().clear();
        return;
      case NaturalLangPackage.BRACKET_SENTENCE__CLOSE:
        setClose(CLOSE_EDEFAULT);
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
      case NaturalLangPackage.BRACKET_SENTENCE__OPEN:
        return OPEN_EDEFAULT == null ? open != null : !OPEN_EDEFAULT.equals(open);
      case NaturalLangPackage.BRACKET_SENTENCE__BRACKED_SENTENCES:
        return brackedSentences != null && !brackedSentences.isEmpty();
      case NaturalLangPackage.BRACKET_SENTENCE__SEPARATOR:
        return separator != null && !separator.isEmpty();
      case NaturalLangPackage.BRACKET_SENTENCE__CLOSE:
        return CLOSE_EDEFAULT == null ? close != null : !CLOSE_EDEFAULT.equals(close);
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
    result.append(" (open: ");
    result.append(open);
    result.append(", separator: ");
    result.append(separator);
    result.append(", close: ");
    result.append(close);
    result.append(')');
    return result.toString();
  }

} //BracketSentenceImpl
