package de.validas.nlx.view.fxviews.semantics.types;

import de.validas.nlx.dictionary.grammar.token.IGrammarLiteral;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.semantics.types.AbstractLinkType;
import de.validas.nlx.view.fxviews.semantics.types.TypeElement;
import javafx.scene.Node;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class LiteralType extends AbstractLinkType implements IGrammarLiteral {
  public LiteralType(final String name, final ILinkable parent) {
    this.name = name;
    this.setParent(parent);
  }
  
  public Node getRoot() {
    return null;
  }
  
  public void removeType(final TypeElement element) {
  }
  
  public void update() {
  }
}
