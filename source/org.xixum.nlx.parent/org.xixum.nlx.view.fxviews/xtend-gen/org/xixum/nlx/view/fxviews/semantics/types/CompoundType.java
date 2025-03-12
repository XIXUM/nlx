package org.xixum.nlx.view.fxviews.semantics.types;

import java.util.List;
import org.xixum.nlx.dictionary.type.ITypeAttributes;
import org.xixum.nlx.view.fxviews.semantics.ILinkObj;
import org.xixum.nlx.view.fxviews.semantics.ILinkable;
import org.xixum.nlx.view.fxviews.visual.ContainerPanel;
import org.xixum.utils.data.lists.LinkedList;
import org.xixum.utils.data.types.XPair;

@SuppressWarnings("all")
public class CompoundType extends LiteralType {
  public CompoundType(final String name, final ILinkable parent) {
    super(name, parent);
  }

  @Override
  public XPair<String, ITypeAttributes> getBaseType() {
    Object _xblockexpression = null;
    {
      if ((this._parent != null)) {
        List<ILinkable> link = ((ContainerPanel) this._parent).getInnerLink();
        if ((link != null)) {
          int _size = link.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            List<XPair<String, ITypeAttributes>> types = link.get(0).getTypes();
            if (((types != null) && (types.size() > 0))) {
              return types.get(0);
            }
          } else {
            LinkedList<ILinkObj> chain = ((ContainerPanel) this._parent).getPanelChain();
            int _size_1 = chain.size();
            boolean _lessEqualsThan = (_size_1 <= 3);
            if (_lessEqualsThan) {
              ILinkObj _get = chain.get(1);
              return ((ILinkObj) _get).getType();
            }
          }
        } else {
          int _length = ((ContainerPanel) this._parent).length(false);
          boolean _equals = (_length == 1);
          if (_equals) {
            return ((ContainerPanel) this._parent).getPanelChain().get(1).getType();
          }
        }
      }
      _xblockexpression = null;
    }
    return ((XPair<String, ITypeAttributes>)_xblockexpression);
  }
}
