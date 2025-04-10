/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */
package org.xixum.nlx.view.fxviews.semantics;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.xixum.nlx.naturalLang.BracketSentence;
import org.xixum.nlx.naturalLang.ExtBracketSentence;
import org.xixum.nlx.naturalLang.impl.WordImpl;
import org.xixum.nlx.view.fxviews.semantics.types.InterpunctionType;

@SuppressWarnings("all")
public class Intermediate {
  protected EObject element = null;

  protected ILinkContainer container = null;

  protected ILinkType type;

  public Intermediate(final ILinkType type, final EObject element) {
    this.element = element;
    this.type = type;
  }

  public Intermediate(final ILinkContainer container) {
    this.container = container;
  }

  public String generate(final String attr) {
    String _xblockexpression = null;
    {
      String value = null;
      if ((this.element != null)) {
        value = this.element.eClass().getName();
      }
      if ((this.container != null)) {
        EObject _element = this.container.getToken().getElement();
        final EObject el = _element;
        boolean _matched = false;
        if (el instanceof WordImpl) {
          _matched=true;
          return null;
        }
        if (!_matched) {
          if (el instanceof ExtBracketSentence) {
            _matched=true;
          }
          if (!_matched) {
            if (el instanceof BracketSentence) {
              _matched=true;
            }
          }
          if (_matched) {
            value = ((BracketSentence)el).eClass().getName();
          }
        }
      } else {
        final ILinkType type = this.type;
        boolean _matched_1 = false;
        if (type instanceof InterpunctionType) {
          _matched_1=true;
          return ((InterpunctionType)this.type).generate(attr);
        }
        value = this.type.getName();
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(attr);
      _builder.append(":\"");
      _builder.append(value);
      _builder.append("\"");
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }

  public ILinkType getType() {
    return this.type;
  }

  public ILinkContainer getContainer() {
    return this.container;
  }
}
