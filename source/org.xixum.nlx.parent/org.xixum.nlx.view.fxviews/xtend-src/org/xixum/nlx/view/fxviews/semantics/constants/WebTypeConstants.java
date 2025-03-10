<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/semantics/constants/WebTypeConstants.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.semantics.constants;

/**
 * @author schaller
 *
 */
@Deprecated
public enum WebTypeConstants {
        _URL("Url"), 
        _EMAIL("Email");
        
        private String name;
        private WebTypeConstants(String name) {
            this.name = name;
        }
       
        @Override
        public String toString(){
            return name;
        } 

}
=======
/**
 * 
 */
package org.xixum.nlx.view.fxviews.semantics.constants;

/**
 * @author schaller
 *
 */
@Deprecated
public enum WebTypeConstants {
        _URL("Url"), 
        _EMAIL("Email");
        
        private String name;
        private WebTypeConstants(String name) {
            this.name = name;
        }
       
        @Override
        public String toString(){
            return name;
        } 

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/semantics/constants/WebTypeConstants.java
