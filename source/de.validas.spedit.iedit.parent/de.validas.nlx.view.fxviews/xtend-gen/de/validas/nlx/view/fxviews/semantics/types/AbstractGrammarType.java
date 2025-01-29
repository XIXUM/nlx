package de.validas.nlx.view.fxviews.semantics.types;

import de.validas.nlx.dictionary.grammar.types.IGrammarType;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.view.fxviews.semantics.ILink;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.views.IPanelContainer;
import de.validas.utils.data.types.XPair;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class AbstractGrammarType implements ILinkable {
  protected ILinkable parent;
  
  @Override
  public IPanelContainer getCanvas() {
    return this.parent.getCanvas();
  }
  
  @Override
  public int getHigherBound() {
    return 0;
  }
  
  @Override
  public List<ILink> getLink() {
    return null;
  }
  
  @Override
  public IGrammarType getLinkType() {
    return null;
  }
  
  @Override
  public int getLowerBound() {
    return 0;
  }
  
  @Override
  public String getName() {
    return null;
  }
  
  @Override
  public XPair<String, ITypeAttributes> getType() {
    return null;
  }
  
  @Override
  public List<XPair<String, ITypeAttributes>> getTypes() {
    return null;
  }
  
  @Override
  public int getCardinality() {
    return 0;
  }
  
  @Override
  public Map<? extends String, ?> getIntermediate() {
    return this.parent.getIntermediate();
  }
  
  @Override
  public void setLink(final String type, final ILink link) {
  }
}
