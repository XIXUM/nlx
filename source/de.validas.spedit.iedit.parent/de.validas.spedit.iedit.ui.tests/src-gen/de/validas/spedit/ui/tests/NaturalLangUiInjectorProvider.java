/*
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.ui.tests;

import com.google.inject.Injector;
import de.validas.spedit.iedit.ui.internal.IeditActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class NaturalLangUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return IeditActivator.getInstance().getInjector("de.validas.spedit.NaturalLang");
	}

}
