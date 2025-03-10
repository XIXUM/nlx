/**
 * Extended Hash Set for INetworkEL types
 */
package org.xixum.nlx.dictionary.type;

import java.util.Collection;
import java.util.HashSet;
import org.xixum.nlx.dictionary.type.elements.INetworkEL;

@SuppressWarnings("all")
public class XHashSet<E extends INetworkEL> extends HashSet<E> {
  private boolean internalCall = false;

  public XHashSet() {
    super();
  }

  public XHashSet(final Collection<? extends E> els) {
    super(els);
  }

  @Override
  public boolean add(final E el) {
    if ((!this.internalCall)) {
      Object[] _array = this.toArray();
      for (final Object x : _array) {
        if ((x instanceof INetworkEL)) {
          boolean _equals = Long.valueOf(el.getID()).equals(Long.valueOf(((INetworkEL)x).getID()));
          if (_equals) {
            return false;
          }
        }
      }
    }
    return super.add(el);
  }

  @Override
  public boolean addAll(final Collection<? extends E> elms) {
    boolean _xblockexpression = false;
    {
      HashSet<INetworkEL> remain = new HashSet<INetworkEL>(elms);
      Object[] _array = this.toArray();
      for (final Object x : _array) {
        if ((x instanceof INetworkEL)) {
          this.compareInner(((INetworkEL)x), remain);
        }
      }
      this.internalCall = true;
      super.addAll(((Collection<? extends E>) remain));
      _xblockexpression = this.internalCall = false;
    }
    return _xblockexpression;
  }

  public HashSet<INetworkEL> compareInner(final INetworkEL x, final HashSet<INetworkEL> remain) {
    for (final INetworkEL el : remain) {
      boolean _equals = Long.valueOf(el.getID()).equals(Long.valueOf(x.getID()));
      if (_equals) {
        x.mergeRel(el);
        remain.remove(el);
        return remain;
      }
    }
    return null;
  }
}
