package org.xixum.nlx.model.ui.editor;

import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.google.inject.Singleton;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.eclipse.xtext.builder.debug.XtextBuildConsole;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class NlxBuildConsole extends XtextBuildConsole {
  public static class Factory extends XtextBuildConsole.Factory {
    @Override
    public void openConsole() {
      IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
      final Iterable<XtextBuildConsole> console = Iterables.<XtextBuildConsole>filter(((Iterable<?>)Conversions.doWrapArray(consoleManager.getConsoles())), XtextBuildConsole.class);
      if ((console != null)) {
        consoleManager.removeConsoles(((IConsole[])Conversions.unwrapArray(console, IConsole.class)));
      }
      NlxBuildConsole _nlxBuildConsole = new NlxBuildConsole();
      consoleManager.addConsoles(new IConsole[] { _nlxBuildConsole });
    }
  }

  @Singleton
  public static class Logger extends XtextBuildConsole.Logger implements INlxBuildLogger {
    private static IBuildLogger delegate;

    @Override
    public void log(final Object it) {
      if ((NlxBuildConsole.Logger.delegate != null)) {
        NlxBuildConsole.Logger.delegate.log(it);
      }
      final IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
      final NlxBuildConsole console = IterableExtensions.<NlxBuildConsole>head(Iterables.<NlxBuildConsole>filter(((Iterable<?>)Conversions.doWrapArray(consoleManager.getConsoles())), NlxBuildConsole.class));
      if ((console != null)) {
        String _name = Thread.currentThread().getName();
        String _plus = ("[" + _name);
        String _plus_1 = (_plus + "] ");
        String _switchResult = null;
        boolean _matched = false;
        if (it instanceof Throwable) {
          _matched=true;
          _switchResult = Throwables.getStackTraceAsString(((Throwable)it));
        }
        if (!_matched) {
          _switchResult = it.toString();
        }
        String _plus_2 = (_plus_1 + _switchResult);
        console.println(_plus_2);
      }
    }

    @Override
    public IBuildLogger registerDelegate(final IBuildLogger delegate) {
      return NlxBuildConsole.Logger.delegate = delegate;
    }
  }

  public NlxBuildConsole() {
    super();
  }
}
