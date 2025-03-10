package org.xixum.nlx.view.fxviews.semantics.types;

import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.neo4j.driver.v1.types.Node;
import org.xixum.nlx.dictionary.IDictionaryAccess;
import org.xixum.nlx.dictionary.grammar.rules.ImplicitRulesOnDict;
import org.xixum.nlx.dictionary.grammar.token.IGrammarInterpunction;
import org.xixum.nlx.dictionary.grammar.types.ItemType;
import org.xixum.nlx.dictionary.type.ITypeAttributes;

@SuppressWarnings("all")
public class InterpunctionType extends AbstractLinkType implements IGrammarInterpunction {
  protected /* SubClassType */Object subClass;

  protected String type;

  private ItemType cathegory;

  private IDictionaryAccess dictAccess;

  private Node node;

  private ITypeAttributes attrs;

  public InterpunctionType(final EObject el, final ItemType type, final IDictionaryAccess dictAccess) {
    this(el, type, null, dictAccess);
  }

  public InterpunctionType(final EObject el, final ItemType cathegory, final String separator, final IDictionaryAccess dictAccess) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field StringUtils is undefined"
      + "\nThe method or field EXT_BRACKET_SENTENCE is undefined"
      + "\nThe method or field BRACKET_SENTENCE is undefined"
      + "\nThe method or field INTERPUNCTION is undefined"
      + "\nThe field InterpunctionType.subClass refers to the missing type SubClassType"
      + "\nThe field InterpunctionType.subClass refers to the missing type SubClassType"
      + "\nThe field InterpunctionType.subClass refers to the missing type SubClassType"
      + "\nspecial_escape cannot be resolved");
  }

  @Override
  public ILinkable setParent(final /* ILinkable */Object nodePanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nILinkObj cannot be resolved to a type."
      + "\nTerminalItem cannot be resolved to a type."
      + "\nILinkObj cannot be resolved to a type."
      + "\nTerminalItem cannot be resolved to a type."
      + "\nThe field AbstractLinkType._parent refers to the missing type ILinkable"
      + "\nThe field AbstractLinkType._parent refers to the missing type ILinkable"
      + "\nThe field AbstractLinkType._parent refers to the missing type ILinkable"
      + "\ntoken cannot be resolved"
      + "\nposition cannot be resolved"
      + "\nname cannot be resolved"
      + "\ntoken cannot be resolved"
      + "\nposition cannot be resolved"
      + "\nname cannot be resolved");
  }

  public SubClassType getSubClass() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field InterpunctionType.subClass refers to the missing type SubClassType");
  }

  @Override
  public Object getBaseType() {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved.");
  }

  @Override
  public ItemType getCathegory() {
    return this.cathegory;
  }

  public String generate(final String attr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(attr);
    _builder.append(":\"");
    _builder.append(this.cathegory);
    _builder.append("\"");
    {
      if ((this.type != null)) {
        _builder.append(", ");
        _builder.append(attr);
        _builder.append("Type:\"");
        _builder.append(this.type);
        _builder.append("\"");
      }
    }
    return _builder.toString();
  }

  public void update() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getTypes() from the type ITypeInfo refers to the missing type Object"
      + "\nkey cannot be resolved"
      + "\nequals cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nvalue cannot be resolved");
  }

  @Override
  public Node getNode() {
    return this.node;
  }

  @Override
  public Object postProcess(final /* ILinkObj */Object precessor, final List<ITypeAttributes> attribs, final ImplicitRulesOnDict grammar) {
    throw new Error("Unresolved compilation problems:"
      + "\nILinkObj cannot be resolved to a type."
      + "\nTerminalItem cannot be resolved to a type."
      + "\nType mismatch: cannot convert from void to Object"
      + "\nType mismatch: cannot convert from void to Object"
      + "\nThe method getParent() from the type AbstractLinkType refers to the missing type ILinkable"
      + "\nThe function must return a result of type Object."
      + "\ntoken cannot be resolved"
      + "\n!== cannot be resolved"
      + "\ntoken cannot be resolved"
      + "\ninternalType cannot be resolved"
      + "\ntypeInfo cannot be resolved"
      + "\n=== cannot be resolved"
      + "\ngetPosition cannot be resolved"
      + "\ngenerateTokenInfo cannot be resolved"
      + "\ngenerateTokenInfo cannot be resolved"
      + "\ntoString cannot be resolved");
  }
}
