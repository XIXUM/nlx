package de.validas.nlx.dictionary.type;

import de.validas.nlx.dictionary.constants.NodeConstants;
import de.validas.nlx.dictionary.type.ITypeHierarchy;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class NoneTypeHierarchy implements ITypeHierarchy {
  @Override
  public String getType() {
    return NodeConstants._NONE;
  }
  
  @Override
  public List<ITypeHierarchy> getChildren() {
    List<ITypeHierarchy> empty = CollectionLiterals.<ITypeHierarchy>newArrayList();
    return empty;
  }
}
