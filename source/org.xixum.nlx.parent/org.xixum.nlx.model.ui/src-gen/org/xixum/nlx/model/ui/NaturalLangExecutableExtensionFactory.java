<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.spedit.iedit.ui/src-gen/de/validas/spedit/ui/NaturalLangExecutableExtensionFactory.java
/*
 * generated by Xtext 2.16.0
 */
package de.validas.spedit.ui;

import com.google.inject.Injector;
import de.validas.spedit.iedit.ui.internal.IeditActivator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class NaturalLangExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(IeditActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		IeditActivator activator = IeditActivator.getInstance();
		return activator != null ? activator.getInjector(IeditActivator.DE_VALIDAS_SPEDIT_NATURALLANG) : null;
	}

}
=======
/*
 * generated by Xtext 2.16.0
 */
package org.xixum.nlx.model.ui;

import com.google.inject.Injector;

import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.xixum.nlx.model.ui.internal.IeditActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class NaturalLangExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(IeditActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		IeditActivator activator = IeditActivator.getInstance();
		return activator != null ? activator.getInjector(IeditActivator.DE_VALIDAS_SPEDIT_NATURALLANG) : null;
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.model.ui/src-gen/org/xixum/nlx/ui/NaturalLangExecutableExtensionFactory.java
