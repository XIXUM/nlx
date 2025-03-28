package org.xixum.nlx.model.ui

import com.google.inject.AbstractModule
import org.eclipse.core.runtime.IExtensionRegistry
import org.eclipse.core.runtime.Platform
import org.xixum.nlx.model.ui.editor.NlxBuildConsole
import org.eclipse.xtext.builder.debug.IBuildLogger

class NlxBuilderModule extends AbstractModule{

	new() {

	}

	override configure() {
		bind(IExtensionRegistry).toInstance(Platform.getExtensionRegistry());

		bind(IExtensionRegistry).toInstance(Platform.getExtensionRegistry());
	
		bind(IBuildLogger).to(NlxBuildConsole.Logger)

	}

}
