package org.xixum.nlx.model.ui.editor;

import com.google.inject.ImplementedBy;
import org.eclipse.xtext.builder.debug.IBuildLogger;
import org.xixum.nlx.model.ui.editor.NlxBuildConsole;

@ImplementedBy(NlxBuildConsole.Logger.class)
@SuppressWarnings("all")
public interface INlxBuildLogger extends IBuildLogger {
}
