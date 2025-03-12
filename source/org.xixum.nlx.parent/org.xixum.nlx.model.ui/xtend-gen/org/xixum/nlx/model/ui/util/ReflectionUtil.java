package org.xixum.nlx.model.ui.util;

import java.lang.reflect.Field;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ReflectionUtil {
  public static Object getPrivateFromSuper(final Object obj, final String name) {
    try {
      Field[] fields = obj.getClass().getSuperclass().getDeclaredFields();
      for (final Field field : fields) {
        boolean _equals = field.getName().equals(name);
        if (_equals) {
          field.setAccessible(true);
          return field.get(obj);
        }
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
