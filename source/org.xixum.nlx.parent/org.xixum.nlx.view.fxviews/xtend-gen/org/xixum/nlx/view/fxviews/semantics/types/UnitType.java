package org.xixum.nlx.view.fxviews.semantics.types;

@SuppressWarnings("all")
public class UnitType extends AbstractLinkType {
  protected String unit;

  public UnitType(final String type, final String unit) {
    this.name = type;
    this.unit = unit;
  }
}
