/**
 * generated by Xtext 2.16.0
 */
package org.xixum.nlx.naturalLang.provider;


import org.xixum.nlx.naturalLang.NaturalLangFactory;
import org.xixum.nlx.naturalLang.NaturalLangPackage;
import org.xixum.nlx.naturalLang.SubSentence;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.xixum.nlx.naturalLang.SubSentence} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SubSentenceItemProvider 
	extends TrailSubSentenceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubSentenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns SubSentence.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SubSentence"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_SubSentence_type");
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SubSentence.class)) {
			case NaturalLangPackage.SUB_SENTENCE__ELEMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createModel()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createSentenceType()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createParagraphBlock()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createBlockElement()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createFootNote()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createTableBorder()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createTableLine()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createTableRow()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createTableColumnSeparator()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createTable()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createLineSentenceChain()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createSentenceChain()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createSentenceChainX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createLineSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createFreeSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createSentenceX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createListSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createChapterSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createTrailSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createFreeSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createLineSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createNoNElementX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createNoNElement()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createBrackets()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createAllElements()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createElements()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createNoNElementX2()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createBracketSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createWord()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createWordShort()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createItWord()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createQuote()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createUnit()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createSimpleUnit()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createChapter_Unit_HI()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createChapter_Unit_Low()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createHashNumber()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createChapterAlpha()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createSymbolsX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createSymbols()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createShortcutGen()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createShortcutLib()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createShortCut()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createIgnoredText()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createUrlAdress()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createEmailAT()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createMailAdress()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createFormula()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createArray()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createNew_Line()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createExtBracketSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SUB_SENTENCE__ELEMENTS,
				 NaturalLangFactory.eINSTANCE.createEString()));
	}

}
