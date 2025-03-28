/**
 * generated by Xtext 2.16.0
 */
package org.xixum.nlx.naturalLang.provider;


import org.xixum.nlx.naturalLang.NaturalLangFactory;
import org.xixum.nlx.naturalLang.NaturalLangPackage;
import org.xixum.nlx.naturalLang.SentenceChain;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.xixum.nlx.naturalLang.SentenceChain} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SentenceChainItemProvider extends BlockElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SentenceChainItemProvider(AdapterFactory adapterFactory) {
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

			addSeparatorsPropertyDescriptor(object);
			addEndpointPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Separators feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSeparatorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SentenceChain_separators_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SentenceChain_separators_feature", "_UI_SentenceChain_type"),
				 NaturalLangPackage.Literals.SENTENCE_CHAIN__SEPARATORS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Endpoint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEndpointPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SentenceChain_endpoint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SentenceChain_endpoint_feature", "_UI_SentenceChain_type"),
				 NaturalLangPackage.Literals.SENTENCE_CHAIN__ENDPOINT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES);
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
	 * This returns SentenceChain.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SentenceChain"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SentenceChain)object).getEndpoint();
		return label == null || label.length() == 0 ?
			getString("_UI_SentenceChain_type") :
			getString("_UI_SentenceChain_type") + " " + label;
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

		switch (notification.getFeatureID(SentenceChain.class)) {
			case NaturalLangPackage.SENTENCE_CHAIN__SEPARATORS:
			case NaturalLangPackage.SENTENCE_CHAIN__ENDPOINT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case NaturalLangPackage.SENTENCE_CHAIN__SENTENCES:
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
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createModel()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createSentenceType()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createParagraphBlock()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createBlockElement()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createFootNote()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createTableBorder()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createTableLine()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createTableRow()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createTableColumnSeparator()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createTable()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createLineSentenceChain()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createSentenceChain()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createSentenceChainX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createLineSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createFreeSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createSentenceX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createListSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createChapterSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createTrailSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createFreeSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createLineSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createNoNElementX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createNoNElement()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createBrackets()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createAllElements()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createElements()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createNoNElementX2()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createBracketSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createWord()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createWordShort()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createItWord()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createQuote()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createUnit()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createSimpleUnit()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createChapter_Unit_HI()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createChapter_Unit_Low()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createHashNumber()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createChapterAlpha()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createSymbolsX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createSymbols()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createShortcutGen()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createShortcutLib()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createShortCut()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createIgnoredText()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createUrlAdress()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createEmailAT()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createMailAdress()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createFormula()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createArray()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createNew_Line()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createExtBracketSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.SENTENCE_CHAIN__SENTENCES,
				 NaturalLangFactory.eINSTANCE.createEString()));
	}

}
