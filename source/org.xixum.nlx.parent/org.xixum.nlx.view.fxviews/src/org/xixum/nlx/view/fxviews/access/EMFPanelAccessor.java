/**
 * (c) XIXUM.ORG - all rights reserved
 */

package org.xixum.nlx.view.fxviews.access;

import org.xixum.nlx.dictionary.IDictionaryAccess;

/**
 * @author schaller
 *
 */
public class EMFPanelAccessor extends AbstractPanelAccessor {

	protected IDictionaryAccess dictAccess;
	/**
	 * 
	 */
	public EMFPanelAccessor(IDictionaryAccess dictAccess) {
		this.dictAccess = dictAccess;
	}
}
