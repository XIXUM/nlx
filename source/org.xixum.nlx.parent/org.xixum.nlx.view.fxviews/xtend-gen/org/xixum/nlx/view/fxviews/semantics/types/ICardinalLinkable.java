/**
 * @author: Felix Schaller
 */
package org.xixum.nlx.view.fxviews.semantics.types;

/**
 * extends ILinkable for cardinal type forwarding
 */
@SuppressWarnings("all")
public interface ICardinalLinkable /* extends ILinkable  */{
  /* ILinkable */Object getBaseType();

  /* XPair<String, ILinkable> */Object getStart();

  /* XPair<String, ILinkable> */Object getEnd();
}
