package de.validas.nlx.view.fxviews.semantics.types;

import de.validas.nlx.view.fxviews.semantics.types.AbstractLinkType;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class UnitType extends AbstractLinkType {
  protected String unit;
  
  public UnitType(final String type, final String unit) {
    this.name = type;
    this.unit = unit;
  }
}
