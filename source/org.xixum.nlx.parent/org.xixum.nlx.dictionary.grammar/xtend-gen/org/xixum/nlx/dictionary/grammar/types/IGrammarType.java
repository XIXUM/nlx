package org.xixum.nlx.dictionary.grammar.types;

import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeInfo;

@SuppressWarnings("all")
public interface IGrammarType {
  String getName();

  ITypeInfo getTypeInfo();

  /* XPair<String, ITypeAttributes> */Object getBaseType();
}
