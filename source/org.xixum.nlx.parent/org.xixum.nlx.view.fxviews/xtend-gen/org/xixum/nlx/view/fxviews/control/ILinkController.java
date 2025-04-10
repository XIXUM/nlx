/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */
package org.xixum.nlx.view.fxviews.control;

import org.xixum.nlx.view.fxviews.access.IJavaFxObj;

@SuppressWarnings("all")
public interface ILinkController {
  void setParent(final IJavaFxObj link);

  void addDragController(final IDragController controller);

  void setContextMenu(final IContextMenu menu);
}
