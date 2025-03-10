<<<<<<< HEAD:source/de.validas.utils.Data/src/de/validas/utils/data/util/StringUtils.java
package de.validas.utils.data.util;

public class StringUtils {

		/**
		 * escape()
		 *
		 * Escape a give String to make it safe to be printed or stored.
		 *
		 * @param s The input String.
		 * @return The output String.
		 **/
		public static String escape(String s){
		  return s.replace("\\", "\\\\")
		          .replace("\t", "\\t")
		          .replace("\b", "\\b")
		          .replace("\n", "\\n")
		          .replace("\r", "\\r")
		          .replace("\f", "\\f")
		          .replace("\'", "\\'")
		          .replace("\"", "\\\"");
		}
		
		/**
		 * escape()
		 *
		 * Escape a give String to make it safe to be printed or stored.
		 *
		 * @param s The input String.
		 * @return The output String.
		 **/
		public static String special_escape(String s){
		  return s.replace("\\", "{bs}")
		          .replace("\t", "{t}")
		          .replace("\b", "{b}")
		          .replace("\n", "{n}")
		          .replace("\r", "{r}")
		          .replace("\f", "{f}")
		          .replace("\'", "{'}")
		          .replace("\"", "{quote}");
		}
}
=======
package org.xixum.utils.data.util;

public class StringUtils {

		/**
		 * escape()
		 *
		 * Escape a give String to make it safe to be printed or stored.
		 *
		 * @param s The input String.
		 * @return The output String.
		 **/
		public static String escape(String s){
		  return s.replace("\\", "\\\\")
		          .replace("\t", "\\t")
		          .replace("\b", "\\b")
		          .replace("\n", "\\n")
		          .replace("\r", "\\r")
		          .replace("\f", "\\f")
		          .replace("\'", "\\'")
		          .replace("\"", "\\\"");
		}
		
		/**
		 * escape()
		 *
		 * Escape a give String to make it safe to be printed or stored.
		 *
		 * @param s The input String.
		 * @return The output String.
		 **/
		public static String special_escape(String s){
		  return s.replace("\\", "{bs}")
		          .replace("\t", "{t}")
		          .replace("\b", "{b}")
		          .replace("\n", "{n}")
		          .replace("\r", "{r}")
		          .replace("\f", "{f}")
		          .replace("\'", "{'}")
		          .replace("\"", "{quote}");
		}
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.utils.Data/src/org/xixum/utils/data/util/StringUtils.java
