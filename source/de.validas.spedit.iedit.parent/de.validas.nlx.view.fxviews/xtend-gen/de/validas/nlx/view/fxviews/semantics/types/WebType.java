package de.validas.nlx.view.fxviews.semantics.types;

import de.validas.nlx.view.fxviews.semantics.constants.WebTypeConstants;
import de.validas.nlx.view.fxviews.semantics.types.AbstractLinkType;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class WebType extends AbstractLinkType {
  public WebType(final WebTypeConstants type) {
    this.name = type.toString();
  }
}
