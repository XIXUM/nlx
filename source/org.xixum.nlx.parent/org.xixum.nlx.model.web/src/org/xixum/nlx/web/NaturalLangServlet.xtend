/*
 * generated by Xtext 2.16.0
 */
package org.xixum.nlx.web

import javax.servlet.annotation.WebServlet
import org.eclipse.xtext.util.DisposableRegistry
import org.eclipse.xtext.web.servlet.XtextServlet

/**
 * Deploy this class into a servlet container to enable DSL-specific services.
 */
@WebServlet(name = 'XtextServices', urlPatterns = '/xtext-service/*')
class NaturalLangServlet extends XtextServlet {
	
	DisposableRegistry disposableRegistry
	
	override init() {
		super.init()
		val injector = new NaturalLangWebSetup().createInjectorAndDoEMFRegistration()
		disposableRegistry = injector.getInstance(DisposableRegistry)
	}
	
	override destroy() {
		if (disposableRegistry !== null) {
			disposableRegistry.dispose()
			disposableRegistry = null
		}
		super.destroy()
	}
	
}
