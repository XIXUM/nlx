/**
 * (c) XIXUM.ORG - all rights reserved
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
