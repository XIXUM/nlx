<<<<<<< HEAD:source/de.validas.utils.IO/src/de/validas/utils/io/filesystem/File.java
package de.validas.utils.io.filesystem;

import com.google.common.io.Files;

import de.validas.utils.data.lists.IAppendable;


public class File extends Directory implements IFile {
	
	public final static char EXTENSION_SEPARATOR = '.';

	String extension;
	
	public File(String name) {
		this (Files.getNameWithoutExtension(name), Files.getFileExtension(name)); 
		
	}
	
	public File (String fileName, String extension) {
		super (fileName);
		this.extension = extension;
	}

	String getNameWoExtension(){
		return super.getName();
	}
	
	/* (non-Javadoc)
	 * @see de.validas.utils.io.filesystem.Directory#getName()
	 */
	@Override
	public String getName() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getName());
		sb.append(EXTENSION_SEPARATOR);
		sb.append(extension);
		return sb.toString();
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}
=======
package org.xixum.utils.io.filesystem;

import com.google.common.io.Files;

import org.xixum.utils.data.lists.IAppendable;


public class File extends Directory implements IFile {
	
	public final static char EXTENSION_SEPARATOR = '.';

	String extension;
	
	public File(String name) {
		this (Files.getNameWithoutExtension(name), Files.getFileExtension(name)); 
		
	}
	
	public File (String fileName, String extension) {
		super (fileName);
		this.extension = extension;
	}

	String getNameWoExtension(){
		return super.getName();
	}
	
	/* (non-Javadoc)
	 * @see org.xixum.utils.io.filesystem.Directory#getName()
	 */
	@Override
	public String getName() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getName());
		sb.append(EXTENSION_SEPARATOR);
		sb.append(extension);
		return sb.toString();
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.utils.IO/src/org/xixum/utils/io/filesystem/File.java
