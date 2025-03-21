<<<<<<< HEAD:source/de.validas.utils.Data/src/de/validas/utils/data/util/ClassUtil.java
/**
 * 
 */
package de.validas.utils.data.util;

/**
 * @author schaller
 *
 */
import java.lang.reflect.Field;

public class ClassUtil {

	/**
	 * Static Methods for Classes
	 */
	
	public static Object getOuterClassInstOfAnonymous(Object obj){
		Class <?> inner = obj.getClass();
		if (!inner.isAnonymousClass()) return null;
		Field field = null;
		try {
			field = inner.getDeclaredField("this$0");
			field.setAccessible(true);
			return field.get(obj);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
=======
/**
 * 
 */
package org.xixum.utils.data.util;

/**
 * @author schaller
 *
 */
import java.lang.reflect.Field;

public class ClassUtil {

	/**
	 * Static Methods for Classes
	 */
	
	public static Object getOuterClassInstOfAnonymous(Object obj){
		Class <?> inner = obj.getClass();
		if (!inner.isAnonymousClass()) return null;
		Field field = null;
		try {
			field = inner.getDeclaredField("this$0");
			field.setAccessible(true);
			return field.get(obj);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.utils.Data/src/org/xixum/utils/data/util/ClassUtil.java
