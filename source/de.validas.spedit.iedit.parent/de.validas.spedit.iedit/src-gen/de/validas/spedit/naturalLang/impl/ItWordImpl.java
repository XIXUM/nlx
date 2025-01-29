/**
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.naturalLang.impl;

import de.validas.spedit.naturalLang.ItWord;
import de.validas.spedit.naturalLang.NaturalLangPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>It Word</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.validas.spedit.naturalLang.impl.ItWordImpl#getWord <em>Word</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItWordImpl extends NoNElementImpl implements ItWord
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ItWordImpl()
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
    return NaturalLangPackage.Literals.IT_WORD;
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
      word = new EDataTypeEList<String>(String.class, this, NaturalLangPackage.IT_WORD__WORD);
    }
    return word;
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
      case NaturalLangPackage.IT_WORD__WORD:
        return getWord();
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
      case NaturalLangPackage.IT_WORD__WORD:
        getWord().clear();
        getWord().addAll((Collection<? extends String>)newValue);
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
      case NaturalLangPackage.IT_WORD__WORD:
        getWord().clear();
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
      case NaturalLangPackage.IT_WORD__WORD:
        return word != null && !word.isEmpty();
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
    result.append(" (word: ");
    result.append(word);
    result.append(')');
    return result.toString();
  }

} //ItWordImpl
