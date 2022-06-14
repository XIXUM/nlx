/**
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.naturalLang.provider;


import de.validas.spedit.naturalLang.NaturalLangFactory;
import de.validas.spedit.naturalLang.NaturalLangPackage;
import de.validas.spedit.naturalLang.TableRow;

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
 * This is the item provider adapter for a {@link de.validas.spedit.naturalLang.TableRow} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TableRowItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableRowItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(NaturalLangPackage.Literals.TABLE_ROW__CONTENT);
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
	 * This returns TableRow.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TableRow"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_TableRow_type");
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

		switch (notification.getFeatureID(TableRow.class)) {
			case NaturalLangPackage.TABLE_ROW__CONTENT:
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
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createModel()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createSentenceType()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createParagraphBlock()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createBlockElement()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createFootNote()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createTableBorder()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createTableLine()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createTableRow()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createTableColumnSeparator()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createTable()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createLineSentenceChain()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createSentenceChain()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createSentenceChainX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createLineSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createFreeSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createSentenceX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createListSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createChapterSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createTrailSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createFreeSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createLineSubSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createNoNElementX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createNoNElement()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createBrackets()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createAllElements()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createElements()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createNoNElementX2()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createBracketSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createWord()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createWordShort()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createItWord()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createQuote()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createUnit()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createSimpleUnit()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createChapter_Unit_HI()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createChapter_Unit_Low()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createHashNumber()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createChapterAlpha()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createSymbolsX()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createSymbols()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createShortcutGen()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createShortcutLib()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createShortCut()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createIgnoredText()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createUrlAdress()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createEmailAT()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createMailAdress()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createFormula()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createArray()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createNew_Line()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createExtBracketSentence()));

		newChildDescriptors.add
			(createChildParameter
				(NaturalLangPackage.Literals.TABLE_ROW__CONTENT,
				 NaturalLangFactory.eINSTANCE.createEString()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return NaturalLangEditPlugin.INSTANCE;
	}

}
