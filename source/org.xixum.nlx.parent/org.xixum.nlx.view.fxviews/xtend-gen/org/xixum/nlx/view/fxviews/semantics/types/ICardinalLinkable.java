/**
 * @author: Felix Schaller
 */
package org.xixum.nlx.view.fxviews.semantics.types;

import org.xixum.nlx.view.fxviews.semantics.ILinkable;

/**
 * extends ILinkable for cardinal type forwarding
 */
@SuppressWarnings("all")
public interface ICardinalLinkable extends ILinkable {
  ILinkable getBaseType();

  /* XPair<String, ILinkable> */Object getStart();

  /* XPair<String, ILinkable> */Object getEnd();
}
