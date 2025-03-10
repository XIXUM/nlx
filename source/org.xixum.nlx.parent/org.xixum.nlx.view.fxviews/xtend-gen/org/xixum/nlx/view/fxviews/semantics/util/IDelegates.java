package org.xixum.nlx.view.fxviews.semantics.util;

@SuppressWarnings("all")
public interface IDelegates {
  interface Procedure<E extends Object> {
    void apply(final E ev);
  }

  interface Procedure2<E extends Object, T extends Object> {
    void apply(final E par, final T ev);
  }
}
