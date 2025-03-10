package org.xixum.nlx.view.fxviews.semantics.types

import org.xixum.nlx.view.fxviews.semantics.constants.WebTypeConstants

class WebType extends AbstractLinkType  {
	
	new (WebTypeConstants type) {
		this.name = type.toString();		
	}
	
}
