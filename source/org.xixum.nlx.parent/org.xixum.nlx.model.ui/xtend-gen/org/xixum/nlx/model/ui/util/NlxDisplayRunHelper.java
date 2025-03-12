package org.xixum.nlx.model.ui.util;

import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.ui.util.DisplayRunHelper;

@SuppressWarnings("all")
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
