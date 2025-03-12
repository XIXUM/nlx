/**
 * generated by Xtext 2.16.0
 */
package org.xixum.nlx.naturalLang.impl;

import org.xixum.nlx.naturalLang.EString;
import org.xixum.nlx.naturalLang.NaturalLangPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EString</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xixum.nlx.naturalLang.impl.EStringImpl#getWord <em>Word</em>}</li>
 *   <li>{@link org.xixum.nlx.naturalLang.impl.EStringImpl#getShortcut <em>Shortcut</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EStringImpl extends ShortcutGenImpl implements EString
{
  /**
   * The cached value of the '{@link #getWord() <em>Word</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWord()
   * @generated
   * @ordered
   */
  protected EList<String> word;

  /**
   * The default value of the '{@link #getShortcut() <em>Shortcut</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortcut()
   * @generated
   * @ordered
   */
  protected static final String SHORTCUT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getShortcut() <em>Shortcut</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShortcut()
   * @generated
   * @ordered
   */
  protected String shortcut = SHORTCUT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EStringImpl()
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
    return NaturalLangPackage.Literals.ESTRING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getWord()
  {
    if (word == null)
    {
      word = new EDataTypeEList<String>(String.class, this, NaturalLangPackage.ESTRING__WORD);
    }
    return word;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getShortcut()
  {
    return shortcut;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShortcut(String newShortcut)
  {
    String oldShortcut = shortcut;
    shortcut = newShortcut;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, NaturalLangPackage.ESTRING__SHORTCUT, oldShortcut, shortcut));
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
      case NaturalLangPackage.ESTRING__WORD:
        return getWord();
      case NaturalLangPackage.ESTRING__SHORTCUT:
        return getShortcut();
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
      case NaturalLangPackage.ESTRING__WORD:
        getWord().clear();
        getWord().addAll((Collection<? extends String>)newValue);
        return;
      case NaturalLangPackage.ESTRING__SHORTCUT:
        setShortcut((String)newValue);
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
      case NaturalLangPackage.ESTRING__WORD:
        getWord().clear();
        return;
      case NaturalLangPackage.ESTRING__SHORTCUT:
        setShortcut(SHORTCUT_EDEFAULT);
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
      case NaturalLangPackage.ESTRING__WORD:
        return word != null && !word.isEmpty();
      case NaturalLangPackage.ESTRING__SHORTCUT:
        return SHORTCUT_EDEFAULT == null ? shortcut != null : !SHORTCUT_EDEFAULT.equals(shortcut);
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
    result.append(" (word: ");
    result.append(word);
    result.append(", shortcut: ");
    result.append(shortcut);
    result.append(')');
    return result.toString();
  }

} //EStringImpl
