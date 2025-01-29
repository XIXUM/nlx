package de.validas.spedit.ui.util;

import javax.annotation.Generated;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.ui.util.DisplayRunHelper;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class NlxDisplayRunHelper extends DisplayRunHelper {
  public static void runSyncInDisplayThread(final Runnable runnable) {
    Display _current = Display.getCurrent();
    boolean _tripleEquals = (_current == null);
    if (_tripleEquals) {
      Display.getDefault().syncExec(runnable);
    } else {
      Display.getCurrent().syncExec(runnable);
    }
  }
  
  public static void runAsyncInDisplayThread(final Runnable runnable) {
    Display _current = Display.getCurrent();
    boolean _tripleEquals = (_current == null);
    if (_tripleEquals) {
      Display.getDefault().asyncExec(runnable);
    } else {
      Display.getCurrent().asyncExec(runnable);
    }
  }
}
