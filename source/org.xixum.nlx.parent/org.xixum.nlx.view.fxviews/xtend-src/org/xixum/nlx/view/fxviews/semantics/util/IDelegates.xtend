/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

package org.xixum.nlx.view.fxviews.semantics.util

interface IDelegates { 
	
	interface Procedure<E> {	
		def void apply(E ev);
	}
	
	interface Procedure2<E, T> {	
		def void apply(E par, T ev);
	}
}