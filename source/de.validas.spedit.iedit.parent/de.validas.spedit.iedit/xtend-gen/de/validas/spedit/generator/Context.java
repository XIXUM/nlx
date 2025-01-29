package de.validas.spedit.generator;

import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Context {
  private int leading;
  
  private int trailing;
  
  public Context(final int leading, final int trailing) {
    this.leading = leading;
    this.trailing = trailing;
  }
  
  public Context() {
    this.leading = 0;
    this.trailing = 0;
  }
  
  public int setLeading(final int leading) {
    int _xblockexpression = (int) 0;
    {
      this.leading = leading;
      _xblockexpression = this.trailing = 0;
    }
    return _xblockexpression;
  }
  
  public int getLeading() {
    return this.leading;
  }
  
  public int setTrailing(final int trailing) {
    return this.trailing = trailing;
  }
  
  public int getTrailing() {
    return this.trailing;
  }
  
  public int incLeading() {
    return this.leading++;
  }
  
  public int incTrailing() {
    return this.trailing++;
  }
  
  public String generate() {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((this.leading > 0)) {
        _builder.append(this.leading);
      }
    }
    {
      if (((this.leading > 0) && (this.trailing > 0))) {
        _builder.append(".");
      }
    }
    {
      if ((this.trailing > 0)) {
        _builder.append(this.trailing);
      }
    }
    return _builder.toString();
  }
}
