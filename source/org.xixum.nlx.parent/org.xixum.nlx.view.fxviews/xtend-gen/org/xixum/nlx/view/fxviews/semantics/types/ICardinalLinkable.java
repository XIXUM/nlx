/**
 * (c) XIXUM.ORG - all rights reserved
 * 
 * @author: Felix Schaller
 */
package org.xixum.nlx.view.fxviews.semantics.types;

import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.utils.data.types.XPair;

/**
 * extends ILinkable for cardinal type forwarding
 */
@SuppressWarnings("all")
public interface ICardinalLinkable extends ILinkable {
  ILinkable getBaseType();

  XPair<String, ILinkable> getStart();

  XPair<String, ILinkable> getEnd();
}
