package org.xixum.nlx.dictionary.grammar.types;

import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public interface IGrammarType {
  String getName();

  /* ITypeInfo */Object getTypeInfo();

  /* XPair<String, ITypeAttributes> */Object getBaseType();
}
