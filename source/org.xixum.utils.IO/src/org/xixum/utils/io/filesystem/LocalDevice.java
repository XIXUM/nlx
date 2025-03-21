<<<<<<< HEAD:source/de.validas.utils.IO/src/de/validas/utils/io/filesystem/LocalDevice.java
/**
 * 
 */
package de.validas.utils.io.filesystem;

/**
 * @author Felix Schaller
 *
 */
public class LocalDevice extends PathElement implements ILocalDevice {

	/**
	 * @param name
	 */
	public LocalDevice(String name) {
		super(name);
	}
	/* (non-Javadoc)
	 * @see de.validas.utils.io.filesystem.IDevice#getDeviceName()
	 */
	@Override
	public String getDeviceName() {		
		return name;
	}
	
	public void setDeviceName(String name) {
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
public class LocalDevice extends PathElement implements ILocalDevice {

	/**
	 * @param name
	 */
	public LocalDevice(String name) {
		super(name);
	}
	/* (non-Javadoc)
	 * @see org.xixum.utils.io.filesystem.IDevice#getDeviceName()
	 */
	@Override
	public String getDeviceName() {		
		return name;
	}
	
	public void setDeviceName(String name) {
		this.name = name;
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.utils.IO/src/org/xixum/utils/io/filesystem/LocalDevice.java
