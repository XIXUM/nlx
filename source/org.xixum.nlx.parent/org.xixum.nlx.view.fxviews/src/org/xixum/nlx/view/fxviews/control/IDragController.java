/**
 * (c) XIXUM.ORG - all rights reserved
 */

package org.xixum.nlx.view.fxviews.control;

import java.util.List;

/**
 * @author schaller
 *
 */
public interface IDragController {

	void add(IDragevent dragevent);

	void clear();

	List<IDragevent> getEvents();

}
