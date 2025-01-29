package de.validas.nlx.view.fxviews.semantics.types;

import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.view.fxviews.semantics.ILinkObj;
import de.validas.nlx.view.fxviews.semantics.ILinkable;
import de.validas.nlx.view.fxviews.semantics.types.LiteralType;
import de.validas.nlx.view.fxviews.visual.ContainerPanel;
import de.validas.utils.data.lists.LinkedList;
import de.validas.utils.data.types.XPair;
import java.util.List;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
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
