package org.xixum.nlx.ai;

@SuppressWarnings("all")
public interface IFunction1<I extends Object, O extends Object> extends IFunction {
  O apply(final I e);
}
