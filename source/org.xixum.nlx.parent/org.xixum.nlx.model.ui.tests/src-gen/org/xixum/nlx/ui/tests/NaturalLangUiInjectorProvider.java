<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.spedit.iedit.ui.tests/src-gen/de/validas/spedit/ui/tests/NaturalLangUiInjectorProvider.java
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
=======
/*
 * generated by Xtext 2.16.0
 */
package org.xixum.nlx.ui.tests;

import com.google.inject.Injector;

import org.eclipse.xtext.testing.IInjectorProvider;
import org.xixum.nlx.model.model.ui.internal.IeditActivator;

public class NaturalLangUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return IeditActivator.getInstance().getInjector("org.xixum.nlx.naturalLang");
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.model.ui.tests/src-gen/org/xixum/nlx/ui/tests/NaturalLangUiInjectorProvider.java
