/**
 * @author: Felix Schaller
 */
package org.xixum.nlx.view.fxviews.semantics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.xixum.nlx.view.fxviews.semantics.constants.FxViewConstants;

@SuppressWarnings("all")
public class LinkStyle {
  /**
   * defines the character of the link. for style and for attribution
   */
  public static final LinkStyle CLEAR = new LinkStyle(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()));

  public static final LinkStyle LINK = new LinkStyle(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(FxViewConstants._LINK)));

  public static final LinkStyle DISABLED = new LinkStyle(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(FxViewConstants._DISABLED)));

  public static final LinkStyle LOW_LINK = new LinkStyle(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(FxViewConstants._LOW_LINK)));

  public static final LinkStyle DASHED = new LinkStyle(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(FxViewConstants._DASHED)));

  public static final LinkStyle FORWARD_LINK = new LinkStyle(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(FxViewConstants._FORWARD_LINK)));

  protected Set<String> styleClasses;

  protected /* Color */Object color;

  private LinkStyle(final List<String> styleClasses, final /* Color */Object color) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field LinkStyle.color refers to the missing type Color");
  }

  private LinkStyle(final List<String> styleClasses) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor LinkStyle(List<String>, Color) refers to the missing type Color");
  }

  public Set<String> getClasses() {
    return this.styleClasses;
  }

  public Set<String> add(final LinkStyle style) {
    Set<String> _xblockexpression = null;
    {
      Set<String> _classes = style.getClasses();
      ArrayList<String> cls = new ArrayList<String>(_classes);
      cls.addAll(0, this.styleClasses);
      _xblockexpression = this.styleClasses = IterableExtensions.<String>toSet(cls);
    }
    return _xblockexpression;
  }

  public Set<String> replaceStyle(final LinkStyle oldStyle, final LinkStyle newStyle) {
    Set<String> _xblockexpression = null;
    {
      Set<String> olcls = oldStyle.getClasses();
      Set<String> _xifexpression = null;
      boolean _containsAll = this.styleClasses.containsAll(olcls);
      if (_containsAll) {
        Set<String> _xblockexpression_1 = null;
        {
          ArrayList<String> cls = new ArrayList<String>(this.styleClasses);
          cls.removeAll(olcls);
          this.styleClasses = IterableExtensions.<String>toSet(cls);
          _xblockexpression_1 = this.add(newStyle);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public static LinkStyle create(final LinkStyle style) {
    Set<String> _classes = style.getClasses();
    ArrayList<String> _arrayList = new ArrayList<String>(_classes);
    return new LinkStyle(_arrayList);
  }

  public static LinkStyle create(final List<String> styleClasses) {
    ArrayList<String> _arrayList = new ArrayList<String>(styleClasses);
    return new LinkStyle(_arrayList);
  }

  public boolean contains(final LinkStyle style) {
    return this.styleClasses.containsAll(style.getClasses());
  }
}
