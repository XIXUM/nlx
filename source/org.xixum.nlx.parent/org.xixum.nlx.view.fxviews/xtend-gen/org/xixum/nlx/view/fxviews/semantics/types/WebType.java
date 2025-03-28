package org.xixum.nlx.view.fxviews.semantics.types;

import org.xixum.nlx.view.fxviews.semantics.constants.WebTypeConstants;

@SuppressWarnings("all")
public class WebType extends AbstractLinkType {
  public WebType(final WebTypeConstants type) {
    this.name = type.toString();
  }
}
