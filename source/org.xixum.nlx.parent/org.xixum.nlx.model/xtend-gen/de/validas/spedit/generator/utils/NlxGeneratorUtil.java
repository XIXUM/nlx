package de.validas.spedit.generator.utils;

import de.validas.spedit.constants.NaturalLangConstants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Generated;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class NlxGeneratorUtil {
  private static Pattern pattern = Pattern.compile(NaturalLangConstants._DECIMAL_REGEX);
  
  public static IPath findResourceInWS(final Resource resource) {
    return ResourcesPlugin.getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true)).getLocation();
  }
  
  public static boolean isNumeric(final String strNum) {
    boolean _xblockexpression = false;
    {
      if ((strNum == null)) {
        return false;
      }
      _xblockexpression = NlxGeneratorUtil.pattern.matcher(strNum).matches();
    }
    return _xblockexpression;
  }
  
  public static String getNumeric(final String strNum) {
    String _xblockexpression = null;
    {
      if ((strNum == null)) {
        return null;
      }
      Matcher match = NlxGeneratorUtil.pattern.matcher(strNum);
      String _xifexpression = null;
      boolean _find = match.find();
      if (_find) {
        _xifexpression = match.group(0);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static Integer StrToNum(final String strNum) {
    int _xblockexpression = (int) 0;
    {
      if ((strNum == null)) {
        return null;
      }
      int i = 0;
      try {
        i = Integer.parseInt(strNum);
      } catch (final Throwable _t) {
        if (_t instanceof NumberFormatException) {
          return null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = i;
    }
    return Integer.valueOf(_xblockexpression);
  }
}
