<<<<<<< HEAD:source/de.validas.spedit.iedit.parent/de.validas.nlx.dictionary/src/de/validas/nlx/dictionary/util/ILogUtils.java
package de.validas.nlx.dictionary.util;

import com.google.inject.ImplementedBy;

@ImplementedBy(LogUtils.class)
public interface ILogUtils {
	public void logAccess(String logType, int max, String msg);
}
=======
package org.xixum.nlx.dictionary.util;

import com.google.inject.ImplementedBy;

@ImplementedBy(LogUtils.class)
public interface ILogUtils {
	public void logAccess(String logType, int max, String msg);
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.nlx.parent/org.xixum.nlx.dictionary/src/org/xixum/nlx/dictionary/util/ILogUtils.java
