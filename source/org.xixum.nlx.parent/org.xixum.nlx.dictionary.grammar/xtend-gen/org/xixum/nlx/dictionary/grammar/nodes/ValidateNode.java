package org.xixum.nlx.dictionary.grammar.nodes;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.xixum.nlx.ai.semantics.INode;

@SuppressWarnings("all")
public class ValidateNode {
  private INode errorNode;

  private INode nodeStart;

  private List<String> strings;

  public ValidateNode(final INode node, final INode node2, final List<String> strings) {
    this.nodeStart = node;
    List<String> _elvis = null;
    if (strings != null) {
      _elvis = strings;
    } else {
      _elvis = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
    }
    this.strings = _elvis;
    this.errorNode = null;
  }

  public HashMap<String, INode> validate() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field index is undefined for the type IGrammarItem");
  }

  public boolean hasAnnotation() {
    boolean _xifexpression = false;
    if ((this.errorNode == null)) {
      _xifexpression = false;
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
  }

  public INode getAnnotation() {
    return this.errorNode;
  }
}
