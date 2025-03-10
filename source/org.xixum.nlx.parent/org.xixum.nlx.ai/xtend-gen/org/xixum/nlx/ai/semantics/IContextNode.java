package org.xixum.nlx.ai.semantics;

@SuppressWarnings("all")
public interface IContextNode {
  Object getAttribute(final String key);

  Object setAttribute(final String key, final Object value);
}
