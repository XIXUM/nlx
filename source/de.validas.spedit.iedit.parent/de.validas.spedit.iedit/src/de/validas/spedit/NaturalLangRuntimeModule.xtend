/*
 * generated by Xtext 2.16.0
 */
package de.validas.spedit

import de.validas.spedit.converters.NaturalLangValueConverters
import de.validas.spedit.naming.NlxDeclarativeQualifiedNameProvider
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.naming.IQualifiedNameProvider

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class NaturalLangRuntimeModule extends AbstractNaturalLangRuntimeModule {
	
		// contributed by org.eclipse.xtext.xtext.generator.exporting.QualifiedNamesFragment2
	override Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		NlxDeclarativeQualifiedNameProvider;
	}
	
	override Class<? extends IValueConverterService> bindIValueConverterService() {
		NaturalLangValueConverters;
	}
	
}
