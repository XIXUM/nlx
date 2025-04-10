/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */
package org.xixum.nlx.view.fxviews.cache;

@SuppressWarnings("all")
public interface ICacheLink extends ICacheObj {
  ICacheObj getOutLink();

  ICacheObj getInLink();

  String getAttrs();
}
