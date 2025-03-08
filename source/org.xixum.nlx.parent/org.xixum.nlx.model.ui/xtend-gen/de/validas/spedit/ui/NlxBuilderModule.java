package de.validas.spedit.ui;

import com.google.inject.AbstractModule;
import de.validas.spedit.ui.editor.NlxBuildConsole;
import javax.annotation.Generated;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.builder.debug.IBuildLogger;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class NlxBuilderModule extends AbstractModule {
  public NlxBuilderModule() {
  }
  
  @Override
  public void configure() {
    this.<IExtensionRegistry>bind(IExtensionRegistry.class).toInstance(Platform.getExtensionRegistry());
    this.<IExtensionRegistry>bind(IExtensionRegistry.class).toInstance(Platform.getExtensionRegistry());
    this.<IBuildLogger>bind(IBuildLogger.class).to(NlxBuildConsole.Logger.class);
  }
}
