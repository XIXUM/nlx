package de.validas.spedit.converters;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.validas.spedit.converters.NlxValueConverter;
import javax.annotation.Generated;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.xtext.XtextValueConverters;

@Singleton
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class NaturalLangValueConverters extends XtextValueConverters {
  @Inject
  protected NlxValueConverter nlxValueConverter;
  
  @ValueConverter(rule = "STRING")
  @Override
  public IValueConverter<String> STRING() {
    return this.nlxValueConverter;
  }
  
  @ValueConverter(rule = "org.eclipse.xtext.common.Terminals.STRING")
  @Override
  public IValueConverter<String> TerminalsSTRING() {
    return this.nlxValueConverter;
  }
  
  @ValueConverter(rule = "de.validas.spedit.NaturalLang.STRING")
  public IValueConverter<String> NlxSTRING() {
    return this.nlxValueConverter;
  }
  
  @ValueConverter(rule = "de.validas.spedit.NaturalLang.Number")
  public IValueConverter<String> NlxNumber() {
    return this.nlxValueConverter;
  }
  
  @ValueConverter(rule = "de.validas.spedit.NaturalLang.ALPHA_NUMERIC_C")
  public IValueConverter<String> NlxAlphaNumeric() {
    return this.nlxValueConverter;
  }
}
