package de.validas.nlx.dictionary.grammar.types;

import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.dictionary.type.ITypeInfo;
import de.validas.utils.data.types.XPair;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public interface IGrammarType {
  public abstract String getName();
  
  public abstract ITypeInfo getTypeInfo();
  
  public abstract XPair<String, ITypeAttributes> getBaseType();
}
