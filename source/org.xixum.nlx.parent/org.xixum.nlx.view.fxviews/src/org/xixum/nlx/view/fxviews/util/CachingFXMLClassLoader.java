<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.view.fxviews/src/de/validas/nlx/view/fxviews/util/CachingFXMLClassLoader.java
/**
 * Caching Class loader
 * Caches Classes for JavaFXML loader to speed up performance
 * (c) 2021 felixschaller.com
 */
package de.validas.nlx.view.fxviews.util;

/**
 * @author schaller
 *
 */
import java.io.IOException; 
import java.net.URL; 
import java.util.Enumeration; 
import java.util.HashMap; 
import java.util.Map; 

public class CachingFXMLClassLoader extends ClassLoader { 
  @SuppressWarnings("rawtypes")
  private final Map<String, Class> classes = new HashMap<String, Class>(); 
  private final ClassLoader parent; 

  public CachingFXMLClassLoader(ClassLoader parent) { 
    this.parent = parent; 
  } 

  @Override 
  public Class<?> loadClass(String name) throws ClassNotFoundException { 
    Class<?> c = findClass(name); 
    if ( c == null ) { 
      throw new ClassNotFoundException( name ); 
    } 
    return c; 
  } 

  @Override 
  protected Class<?> findClass( String className ) throws ClassNotFoundException { 
    if (classes.containsKey(className)) { 
      Class<?> result = classes.get(className); 
      return result; 
    } else { 
      try { 
        Class<?> result = parent.loadClass(className);  
        classes.put(className, result); 
        return result; 
      } catch (ClassNotFoundException ignore) { 
        classes.put(className, null); 
        return null; 
      } 
    } 
  } 

  @Override 
  public URL getResource( String name ) { 
    return parent.getResource(name); 
  } 

  @Override 
  public Enumeration<URL> getResources( String name ) throws IOException { 
    return parent.getResources(name); 
  } 

  @Override 
  public String toString() { 
    return parent.toString(); 
  } 

  @Override 
  public void setDefaultAssertionStatus(boolean enabled) { 
    parent.setDefaultAssertionStatus(enabled); 
  } 

  @Override 
  public void setPackageAssertionStatus(String packageName, boolean enabled) { 
    parent.setPackageAssertionStatus(packageName, enabled); 
  } 

  @Override 
  public void setClassAssertionStatus(String className, boolean enabled) { 
    parent.setClassAssertionStatus(className, enabled); 
  } 

  @Override 
  public void clearAssertionStatus() { 
    parent.clearAssertionStatus(); 
  } 
}
=======
/**
 * Caching Class loader
 * Caches Classes for JavaFXML loader to speed up performance
 * (c) 2021 felixschaller.com
 */
package org.xixum.nlx.view.fxviews.util;

/**
 * @author schaller
 *
 */
import java.io.IOException; 
import java.net.URL; 
import java.util.Enumeration; 
import java.util.HashMap; 
import java.util.Map; 

public class CachingFXMLClassLoader extends ClassLoader { 
  @SuppressWarnings("rawtypes")
  private final Map<String, Class> classes = new HashMap<String, Class>(); 
  private final ClassLoader parent; 

  public CachingFXMLClassLoader(ClassLoader parent) { 
    this.parent = parent; 
  } 

  @Override 
  public Class<?> loadClass(String name) throws ClassNotFoundException { 
    Class<?> c = findClass(name); 
    if ( c == null ) { 
      throw new ClassNotFoundException( name ); 
    } 
    return c; 
  } 

  @Override 
  protected Class<?> findClass( String className ) throws ClassNotFoundException { 
    if (classes.containsKey(className)) { 
      Class<?> result = classes.get(className); 
      return result; 
    } else { 
      try { 
        Class<?> result = parent.loadClass(className);  
        classes.put(className, result); 
        return result; 
      } catch (ClassNotFoundException ignore) { 
        classes.put(className, null); 
        return null; 
      } 
    } 
  } 

  @Override 
  public URL getResource( String name ) { 
    return parent.getResource(name); 
  } 

  @Override 
  public Enumeration<URL> getResources( String name ) throws IOException { 
    return parent.getResources(name); 
  } 

  @Override 
  public String toString() { 
    return parent.toString(); 
  } 

  @Override 
  public void setDefaultAssertionStatus(boolean enabled) { 
    parent.setDefaultAssertionStatus(enabled); 
  } 

  @Override 
  public void setPackageAssertionStatus(String packageName, boolean enabled) { 
    parent.setPackageAssertionStatus(packageName, enabled); 
  } 

  @Override 
  public void setClassAssertionStatus(String className, boolean enabled) { 
    parent.setClassAssertionStatus(className, enabled); 
  } 

  @Override 
  public void clearAssertionStatus() { 
    parent.clearAssertionStatus(); 
  } 
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.view.fxviews/src/org/xixum/nlx/view/fxviews/util/CachingFXMLClassLoader.java
