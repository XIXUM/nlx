<<<<<<< HEAD:source/de.validas.utils.IO/src/de/validas/utils/io/filesystem/FileExt.java
/**
 * 
 */
package de.validas.utils.io.filesystem;

/**
 * @author Felix Schaller
 *
 */
public class FileExt {

	/**
	 * holds Extension of Files
	 */
	protected String name;
	
	
	public FileExt() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public String getNameWSeparator() {
		return String.format(".{0}", name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
=======
/**
 * 
 */
package org.xixum.utils.io.filesystem;

/**
 * @author Felix Schaller
 *
 */
public class FileExt {

	/**
	 * holds Extension of Files
	 */
	protected String name;
	
	
	public FileExt() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public String getNameWSeparator() {
		return String.format(".{0}", name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.utils.IO/src/org/xixum/utils/io/filesystem/FileExt.java
