/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */
package org.xixum.nlx.view.fxviews.semantics.types

import org.eclipse.emf.common.util.EList

class UnitType extends AbstractLinkType {
	
	protected String unit
	
	new (String type, String unit){
		this.name = type
		this.unit = unit
	}
		
}
