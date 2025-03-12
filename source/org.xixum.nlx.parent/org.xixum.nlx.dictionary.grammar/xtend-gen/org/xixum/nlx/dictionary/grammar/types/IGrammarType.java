package org.xixum.nlx.dictionary.grammar.types;

import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.dictionary.type.ITypeInfo;
import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public interface IGrammarType {
  String getName();

  ITypeInfo getTypeInfo();

  XPair<String, ITypeAttributes> getBaseType();
}
