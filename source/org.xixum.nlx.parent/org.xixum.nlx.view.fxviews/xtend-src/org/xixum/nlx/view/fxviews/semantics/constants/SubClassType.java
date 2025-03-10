<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/xtend-src/de/validas/nlx/view/fxviews/semantics/constants/SubClassType.java
/**
 * 
 */
package de.validas.nlx.view.fxviews.semantics.constants;

/**
 * @author schaller
 * @deprecated: replace by plugin.properties constants
 */
@Deprecated
public enum SubClassType {
        EXT_BRACKET_SENTENCE("ExtBracketSentence"), 
        BRACKET_SENTENCE("BracketSentence"), 
        INTERPUNCTION("Interpunction"),
	    SEPARATOR("Separator");
        
        private String name;
        private SubClassType(String name) {
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
 * @deprecated: replace by plugin.properties constants
 */
@Deprecated
public enum SubClassType {
        EXT_BRACKET_SENTENCE("ExtBracketSentence"), 
        BRACKET_SENTENCE("BracketSentence"), 
        INTERPUNCTION("Interpunction"),
	    SEPARATOR("Separator");
        
        private String name;
        private SubClassType(String name) {
            this.name = name;
        }
       
        @Override
        public String toString(){
            return name;
        } 

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/xtend-src/org/xixum/nlx/view/fxviews/semantics/constants/SubClassType.java
