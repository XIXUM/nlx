package de.validas.nlx.view.fxviews.semantics.util;

import com.google.common.base.Objects;
import de.validas.nlx.dictionary.grammar.types.IGrammarType;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.view.fxviews.access.IItem;
import de.validas.nlx.view.fxviews.access.elements.ShortCutItem;
import de.validas.nlx.view.fxviews.access.elements.SmallItem;
import de.validas.nlx.view.fxviews.semantics.ILink;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.semantics.LinkStyle;
import de.validas.nlx.view.fxviews.semantics.constants.LinkConstants;
import de.validas.nlx.view.fxviews.semantics.types.LiteralType;
import de.validas.nlx.view.fxviews.semantics.types.WordType;
import de.validas.nlx.view.fxviews.visual.ContainerPanel;
import de.validas.nlx.view.fxviews.visual.IPanel;
import de.validas.nlx.view.fxviews.visual.NodePanel;
import de.validas.utils.data.lists.IAppendable;
import de.validas.utils.data.types.XPair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javax.annotation.Generated;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
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
  
  public static List<XPair<Integer, ILinkable>> traceAllRoots(final ILinkable sourceLink, final int depth, final boolean bidirect) {
    if ((sourceLink != null)) {
      final List<ILink> parents = CollectionLiterals.<ILink>newArrayList();
      if ((sourceLink instanceof NodePanel)) {
        Map<String, List<ILink>> _links = ((NodePanel)sourceLink).getLinks();
        Collection<List<ILink>> _values = null;
        if (_links!=null) {
          _values=_links.values();
        }
        final Consumer<List<ILink>> _function = (List<ILink> l) -> {
          parents.addAll(l);
        };
        _values.forEach(_function);
      } else {
        parents.addAll(sourceLink.getLink());
      }
      ArrayList<XPair<Integer, ILinkable>> result = CollectionLiterals.<XPair<Integer, ILinkable>>newArrayList();
      if (((parents != null) && (!parents.isEmpty()))) {
        for (final ILink link : parents) {
          {
            int _xifexpression = (int) 0;
            int _level = link.getLevel();
            boolean _greaterThan = (_level > depth);
            if (_greaterThan) {
              _xifexpression = link.getLevel();
            } else {
              _xifexpression = (depth + 1);
            }
            int l = _xifexpression;
            List<XPair<Integer, ILinkable>> trace = LinkUtils.traceAllRoots(link, l, bidirect);
            if ((trace != null)) {
              for (final XPair<Integer, ILinkable> el : trace) {
                if (((el.getValue().getLowerBound() >= sourceLink.getLowerBound()) || bidirect)) {
                  result.add(el);
                }
              }
            }
          }
        }
      }
      XPair<Integer, ILinkable> _xPair = new XPair<Integer, ILinkable>(Integer.valueOf(depth), sourceLink);
      result.add(_xPair);
      return result;
    }
    return null;
  }
  
  public static Boolean autoRoute(final ILinkObj startNode) {
    boolean eol = false;
    ILinkObj next = startNode;
    while ((!eol)) {
      {
        XPair<Integer, ILinkable> result = LinkUtils.doRoute(next);
        if ((result != null)) {
          IAppendable _successor = next.getSuccessor();
          next = ((ILinkObj) _successor);
          while (((next != null) && (next.getToken() instanceof SmallItem))) {
            IAppendable _successor_1 = next.getSuccessor();
            next = ((ILinkObj) _successor_1);
          }
        } else {
          boolean _xifexpression = false;
          if ((next == null)) {
            _xifexpression = eol = true;
          }
          return Boolean.valueOf(_xifexpression);
        }
      }
    }
    return null;
  }
  
  /**
   * selects highest level root
   */
  private static XPair<Integer, ILinkable> doRoute(final ILinkable link) {
    final List<XPair<Integer, ILinkable>> root = LinkUtils.traceAllRoots(link, 0, true);
    int max = 0;
    int maxSpan = 0;
    XPair<Integer, ILinkable> result = null;
    int i = 0;
    int selection = (-1);
    List<XPair<Integer, ILinkable>> _elvis = null;
    if (root != null) {
      _elvis = root;
    } else {
      _elvis = Collections.<XPair<Integer, ILinkable>>unmodifiableList(CollectionLiterals.<XPair<Integer, ILinkable>>newArrayList());
    }
    for (final XPair<Integer, ILinkable> el : _elvis) {
      {
        final ILinkable el_link = el.getValue();
        final int key = LinkUtils.traceLeaves(el_link, 0);
        if ((el_link instanceof ILink)) {
          final int maxLevel = ((ILink)el_link).getMaxLevel();
          int _higherBound = ((ILink)el_link).getHigherBound();
          int _lowerBound = ((ILink)el_link).getLowerBound();
          final int span = (_higherBound - _lowerBound);
          if (((maxLevel == 0) || (maxLevel >= key))) {
            if (((key < max) || LinkUtils.isDisabled(el))) {
              if ((result == null)) {
                result = el;
              }
            } else {
              if ((key > max)) {
                max = key;
                maxSpan = span;
                result = el;
                selection = i;
              } else {
                if ((key == max)) {
                  if ((span > maxSpan)) {
                    max = key;
                    maxSpan = span;
                    result = el;
                    selection = i;
                  }
                }
              }
            }
          }
          if ((result == null)) {
          }
        }
        i++;
      }
    }
    if ((result != null)) {
      for (i = 0; (i < root.size()); i++) {
        {
          XPair<Integer, ILinkable> el_1 = root.get(i);
          boolean _isDisabled = LinkUtils.isDisabled(el_1);
          boolean _not = (!_isDisabled);
          if (_not) {
            if ((i == selection)) {
              LinkUtils.selectRoute(el_1.getValue(), null, max);
            } else {
            }
          }
        }
      }
    }
    return result;
  }
  
  public static boolean isDisabled(final XPair<Integer, ILinkable> pair) {
    boolean _xblockexpression = false;
    {
      ILinkable v = pair.getValue();
      if ((v instanceof ILink)) {
        boolean _contains = ((ILink)v).getStyle().getClasses().contains(((Object[])Conversions.unwrapArray(LinkStyle.DISABLED.getClasses(), Object.class))[0]);
        if (_contains) {
          return true;
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public static int traceLeaves(final ILinkable linkable, final int level) {
    if ((linkable instanceof ILink)) {
      ILinkable _value = ((ILink)linkable).getStartLink().getValue();
      ILinkable _value_1 = ((ILink)linkable).getEndLink().getValue();
      List<ILinkable> links = Collections.<ILinkable>unmodifiableList(CollectionLiterals.<ILinkable>newArrayList(_value, _value_1));
      int max = 0;
      for (final ILinkable child : links) {
        {
          int branches = LinkUtils.traceLeaves(child, (level + 1));
          if ((branches > max)) {
            max = branches;
          }
        }
      }
      return max;
    }
    return (level + 1);
  }
  
  /**
   * deselect links recursively
   */
  public static void selectRoute(final ILinkable linkable, final String typeName, final int max) {
    if ((linkable instanceof ILinkObj)) {
      IItem token = ((ILinkObj)linkable).getToken();
      if ((token instanceof ShortCutItem)) {
        ((ShortCutItem)token).setSelection(typeName);
      }
    } else {
      if ((linkable instanceof ILink)) {
        ((ILink)linkable).setMaxLevel(max);
        ((ILink)linkable).getStyle().replaceStyle(LinkStyle.LOW_LINK, LinkStyle.LINK);
        LinkUtils.selectRoute(((ILink)linkable).getEndLink().getValue(), ((ILink)linkable).getEndLink().getKey(), max);
        LinkUtils.selectRoute(((ILink)linkable).getStartLink().getValue(), ((ILink)linkable).getStartLink().getKey(), max);
      }
    }
  }
  
  /**
   * deselect links recursively
   */
  public static void deselectRoute(final ILinkable linkable, final int max) {
    if ((linkable instanceof ILink)) {
      ((ILink)linkable).setMaxLevel(max);
      ((ILink)linkable).getStyle().replaceStyle(LinkStyle.LINK, LinkStyle.LOW_LINK);
      LinkUtils.deselectRoute(((ILink)linkable).getEndLink().getValue(), max);
      LinkUtils.deselectRoute(((ILink)linkable).getStartLink().getValue(), max);
    }
  }
  
  public static ILinkObj findNextAdjacentPanel(final ILinkable linkable, final boolean leftOf) {
    ILinkObj _xifexpression = null;
    if ((linkable instanceof ILinkObj)) {
      _xifexpression = ((ILinkObj)linkable);
    } else {
      ILinkObj _xblockexpression = null;
      {
        ILink link = ((ILink) linkable);
        ILinkObj startPanel = LinkUtils.findNextAdjacentPanel(link.getStartLink().getValue(), leftOf);
        ILinkObj endPanel = LinkUtils.findNextAdjacentPanel(link.getEndLink().getValue(), leftOf);
        int _index = startPanel.getIndex();
        int _index_1 = endPanel.getIndex();
        boolean dir = (_index < _index_1);
        boolean _xifexpression_1 = false;
        if (leftOf) {
          _xifexpression_1 = dir;
        } else {
          _xifexpression_1 = (!dir);
        }
        if (_xifexpression_1) {
          return endPanel;
        }
        _xblockexpression = startPanel;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public static Point2D linkToLinkCalculation(final ILink link, final boolean automatic) {
    if ((link == null)) {
      return null;
    }
    XPair<String, ILinkable> startLink = link.getStartLink();
    XPair<String, ILinkable> endLink = link.getEndLink();
    Point2D startPoint = LinkUtils.recursiveLinkToPoint(startLink, link, false);
    Point2D endPoint = LinkUtils.recursiveLinkToPoint(endLink, link, false);
    return LinkUtils.calculateLinkOffset(startPoint, endPoint);
  }
  
  /**
   * @param startPoint
   * @param endPoint
   * @return
   */
  public static Point2D calculateLinkOffset(final Point2D startPoint, final Point2D endPoint) {
    if (((startPoint == null) || (endPoint == null))) {
      return null;
    }
    double ey = endPoint.getY();
    double sy = startPoint.getY();
    double y = 0;
    if ((ey > sy)) {
      y = ey;
    } else {
      y = sy;
    }
    double _x = endPoint.getX();
    double _x_1 = startPoint.getX();
    double _plus = (_x + _x_1);
    double _divide = (_plus / 2);
    return new Point2D(_divide, (y + LinkConstants.LINK_HEIGHT));
  }
  
  public static Point2D recursiveLinkToPoint(final XPair<String, ILinkable> link, final ILink parent, final boolean automatic) {
    if ((link == null)) {
      return null;
    }
    ILinkable linkObj = link.getValue();
    boolean _matched = false;
    if (linkObj instanceof ContainerPanel) {
      _matched=true;
      return LinkUtils.midPointFromRoot(((IPanel)linkObj));
    }
    return LinkUtils.innerRecursionResolveLink(linkObj, parent, automatic);
  }
  
  public static Point2D midPointFromRoot(final IPanel opposite) {
    Node root = opposite.getRoot();
    if ((root != null)) {
      Bounds endBounds = root.getBoundsInParent();
      double _minX = endBounds.getMinX();
      double _maxX = endBounds.getMaxX();
      double _plus = (_minX + _maxX);
      double _divide = (_plus / 2);
      double _maxY = endBounds.getMaxY();
      return new Point2D(_divide, _maxY);
    } else {
      return new Point2D(0, 0);
    }
  }
  
  public static Point2D innerRecursionResolveLink(final ILinkable linkObj, final ILink parent, final boolean automatic) {
    boolean _equals = Objects.equal(linkObj, null);
    if (_equals) {
      return null;
    }
    boolean _matched = false;
    if (linkObj instanceof IPanel) {
      _matched=true;
      List<ILink> types = ((IPanel)linkObj).getLink();
      if (((types != null) && (!types.isEmpty()))) {
        for (final ILink type : types) {
          if ((type.equals(parent) || (parent == null))) {
            return LinkUtils.midPointFromRoot(((IPanel)linkObj));
          }
        }
      }
      return null;
    }
    return LinkUtils.linkToLinkCalculation(((ILink) linkObj), automatic);
  }
  
  public static XPair<String, ITypeAttributes> getLinkHigherType(final ILinkable linkable) {
    IGrammarType type = null;
    boolean _matched = false;
    if (linkable instanceof ContainerPanel) {
      _matched=true;
      type = ((ContainerPanel)linkable).getLinkType();
    }
    if (!_matched) {
      type = linkable.getLinkType();
    }
    boolean _matched_1 = false;
    if (type instanceof WordType) {
      _matched_1=true;
      return ((WordType)type).getBaseType();
    }
    if (!_matched_1) {
      if (type instanceof LiteralType) {
        _matched_1=true;
        String _name = ((LiteralType)type).getName();
        return new XPair<String, ITypeAttributes>(_name, null);
      }
    }
    return null;
  }
  
  /**
   * @param start
   * @param end
   */
  public static Pair<Integer, Integer> calculateBounds(final XPair<String, ILinkable> start, final XPair<String, ILinkable> end) {
    int high = 0;
    int low = 0;
    final ILinkable startV = start.getValue();
    final ILinkable endV = end.getValue();
    int _lowerBound = startV.getLowerBound();
    int _higherBound = endV.getHigherBound();
    boolean _lessThan = (_lowerBound < _higherBound);
    if (_lessThan) {
      low = startV.getLowerBound();
      high = endV.getHigherBound();
    } else {
      low = endV.getLowerBound();
      high = startV.getHigherBound();
    }
    return Pair.<Integer, Integer>of(Integer.valueOf(low), Integer.valueOf(high));
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
