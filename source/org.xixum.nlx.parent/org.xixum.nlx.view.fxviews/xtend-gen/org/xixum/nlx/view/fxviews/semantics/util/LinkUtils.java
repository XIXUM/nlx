package org.xixum.nlx.view.fxviews.semantics.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.xixum.nlx.view.fxviews.semantics.ILink;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.semantics.LinkStyle;
import org.xixum.nlx.view.fxviews.visual.IPanel;

@SuppressWarnings("all")
public class LinkUtils {
  /**
   * similar to FindRoot in semantic linker but with different behavior
   */
  public static List<ILinkable> traceRoot(final ILinkable sourceLink) {
    if ((sourceLink instanceof ILinkable)) {
      ArrayList<ILinkable> results = CollectionLiterals.<ILinkable>newArrayList();
      List<ILink> _elvis = null;
      List<ILink> _link = sourceLink.getLink();
      if (_link != null) {
        _elvis = _link;
      } else {
        _elvis = Collections.<ILink>unmodifiableList(CollectionLiterals.<ILink>newArrayList());
      }
      for (final ILink parent : _elvis) {
        results.addAll(LinkUtils.traceRoot(parent));
      }
      boolean _isEmpty = results.isEmpty();
      if (_isEmpty) {
        return Collections.<ILinkable>unmodifiableList(CollectionLiterals.<ILinkable>newArrayList(sourceLink));
      } else {
        return results;
      }
    } else {
      return null;
    }
  }

  public static /* List<XPair<Integer, ILinkable>> */Object traceAllRoots(final ILinkable sourceLink, final int depth, final boolean bidirect) {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved."
      + "\nThe method traceAllRoots(ILinkable, int, boolean) from the type LinkUtils refers to the missing type XPair"
      + "\nvalue cannot be resolved"
      + "\nlowerBound cannot be resolved"
      + "\n>= cannot be resolved"
      + "\n|| cannot be resolved");
  }

  public static Boolean autoRoute(final ILinkObj startNode) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field successor is undefined for the type ILinkObj"
      + "\nThe method or field successor is undefined for the type ILinkObj"
      + "\nThe method doRoute(ILinkable) from the type LinkUtils refers to the missing type XPair"
      + "\n!== cannot be resolved");
  }

  /**
   * selects highest level root
   */
  private static XPair doRoute(final ILinkable link) {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved to a type."
      + "\nThe method traceAllRoots(ILinkable, int, boolean) from the type LinkUtils refers to the missing type XPair"
      + "\nThe method isDisabled(XPair) from the type LinkUtils refers to the missing type XPair"
      + "\nThe method isDisabled(XPair) from the type LinkUtils refers to the missing type XPair"
      + "\nvalue cannot be resolved"
      + "\nmaxLevel cannot be resolved"
      + "\nhigherBound cannot be resolved"
      + "\n- cannot be resolved"
      + "\nlowerBound cannot be resolved"
      + "\n== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\n>= cannot be resolved"
      + "\n=== cannot be resolved"
      + "\n> cannot be resolved"
      + "\n=== cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nvalue cannot be resolved");
  }

  public static boolean isDisabled(final /* XPair<Integer, ILinkable> */Object pair) {
    throw new Error("Unresolved compilation problems:"
      + "\nvalue cannot be resolved"
      + "\nstyle cannot be resolved"
      + "\nclasses cannot be resolved"
      + "\ncontains cannot be resolved");
  }

  public static int traceLeaves(final ILinkable linkable, final int level) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field startLink is undefined for the type ILink"
      + "\nThe method or field endLink is undefined for the type ILink"
      + "\nvalue cannot be resolved"
      + "\nvalue cannot be resolved");
  }

  /**
   * deselect links recursively
   */
  public static void selectRoute(final ILinkable linkable, final String typeName, final int max) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field endLink is undefined for the type ILink"
      + "\nThe method or field endLink is undefined for the type ILink"
      + "\nThe method or field startLink is undefined for the type ILink"
      + "\nThe method or field startLink is undefined for the type ILink"
      + "\nvalue cannot be resolved"
      + "\nkey cannot be resolved"
      + "\nvalue cannot be resolved"
      + "\nkey cannot be resolved");
  }

  /**
   * deselect links recursively
   */
  public static void deselectRoute(final ILinkable linkable, final int max) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field endLink is undefined for the type ILink"
      + "\nThe method or field startLink is undefined for the type ILink"
      + "\nvalue cannot be resolved"
      + "\nvalue cannot be resolved");
  }

  public static ILinkObj findNextAdjacentPanel(final ILinkable linkable, final boolean leftOf) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field startLink is undefined for the type ILink"
      + "\nThe method or field endLink is undefined for the type ILink"
      + "\nvalue cannot be resolved"
      + "\nvalue cannot be resolved");
  }

  public static /* Point2D */Object linkToLinkCalculation(final ILink link, final boolean automatic) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getStartLink() is undefined for the type ILink"
      + "\nThe method getEndLink() is undefined for the type ILink"
      + "\nThe method recursiveLinkToPoint(XPair, ILink, boolean) from the type LinkUtils refers to the missing type Point2D"
      + "\nThe method recursiveLinkToPoint(XPair, ILink, boolean) from the type LinkUtils refers to the missing type Point2D"
      + "\nThe method calculateLinkOffset(Point2D, Point2D) from the type LinkUtils refers to the missing type Point2D");
  }

  /**
   * @param startPoint
   * @param endPoint
   * @return
   */
  public static /* Point2D */Object calculateLinkOffset(final /* Point2D */Object startPoint, final /* Point2D */Object endPoint) {
    throw new Error("Unresolved compilation problems:"
      + "\nPoint2D cannot be resolved."
      + "\n=== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\n=== cannot be resolved"
      + "\ngetY cannot be resolved"
      + "\ngetY cannot be resolved"
      + "\n> cannot be resolved"
      + "\ngetX cannot be resolved"
      + "\n+ cannot be resolved"
      + "\ngetX cannot be resolved"
      + "\n/ cannot be resolved");
  }

  public static /* Point2D */Object recursiveLinkToPoint(final /* XPair<String, ILinkable> */Object link, final ILink parent, final boolean automatic) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method midPointFromRoot(IPanel) from the type LinkUtils refers to the missing type Point2D"
      + "\n=== cannot be resolved"
      + "\ngetValue cannot be resolved");
  }

  public static /* Point2D */Object midPointFromRoot(final IPanel opposite) {
    throw new Error("Unresolved compilation problems:"
      + "\nBounds cannot be resolved to a type."
      + "\nThe method or field root is undefined for the type IPanel"
      + "\nPoint2D cannot be resolved."
      + "\nPoint2D cannot be resolved."
      + "\n!== cannot be resolved"
      + "\nboundsInParent cannot be resolved"
      + "\nminX cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nmaxX cannot be resolved"
      + "\n/ cannot be resolved"
      + "\nmaxY cannot be resolved");
  }

  public static Object innerRecursionResolveLink(final ILinkable linkObj, final ILink parent, final boolean automatic) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method midPointFromRoot(IPanel) from the type LinkUtils refers to the missing type Point2D"
      + "\nThe method linkToLinkCalculation(ILink, boolean) from the type LinkUtils refers to the missing type Point2D");
  }

  public static Object getLinkHigherType(final ILinkable linkable) {
    throw new Error("Unresolved compilation problems:"
      + "\nXPair cannot be resolved.");
  }

  /**
   * @param start
   * @param end
   */
  public static Pair<Integer, Integer> calculateBounds(final /* XPair<String, ILinkable> */Object start, final /* XPair<String, ILinkable> */Object end) {
    throw new Error("Unresolved compilation problems:"
      + "\ngetValue cannot be resolved"
      + "\ngetValue cannot be resolved"
      + "\ngetLowerBound cannot be resolved"
      + "\n< cannot be resolved"
      + "\ngetHigherBound cannot be resolved"
      + "\ngetLowerBound cannot be resolved"
      + "\ngetHigherBound cannot be resolved"
      + "\ngetLowerBound cannot be resolved"
      + "\ngetHigherBound cannot be resolved");
  }

  public static LinkStyle addStyle(final LinkStyle style, final LinkStyle newStyle) {
    if ((style == null)) {
      return LinkStyle.create(newStyle);
    } else {
      style.add(newStyle);
    }
    return style;
  }

  /**
   * @param start
   * @param endPanel
   * @return
   */
  public static int calculateLevel(final ILinkable start, final ILinkable endPanel) {
    int _xblockexpression = (int) 0;
    {
      int level = 0;
      List<ILinkable> _asList = Arrays.<ILinkable>asList(start, endPanel);
      for (final ILinkable linkable : _asList) {
        if ((linkable instanceof ILink)) {
          int l = ((ILink)linkable).getLevel();
          if ((l > level)) {
            level = l;
          }
        }
      }
      _xblockexpression = level;
    }
    return _xblockexpression;
  }
}
