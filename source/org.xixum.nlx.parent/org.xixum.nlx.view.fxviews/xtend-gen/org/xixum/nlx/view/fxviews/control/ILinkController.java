package org.xixum.nlx.view.fxviews.control;

@SuppressWarnings("all")
public interface ILinkController {
  void setParent(final /* IJavaFxObj */Object link);

  void addDragController(final /* IDragController */Object controller);

  void setContextMenu(final IContextMenu menu);
}
