<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/semantics/util/IDelegates.xtend
package de.validas.nlx.view.fxviews.semantics.util

interface IDelegates { 
	
	interface Procedure<E> {	
		def void apply(E ev);
	}
	
	interface Procedure2<E, T> {	
		def void apply(E par, T ev);
	}
=======
package org.xixum.nlx.view.fxviews.semantics.util

interface IDelegates { 
	
	interface Procedure<E> {	
		def void apply(E ev);
	}
	
	interface Procedure2<E, T> {	
		def void apply(E par, T ev);
	}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/semantics/util/IDelegates.xtend
}