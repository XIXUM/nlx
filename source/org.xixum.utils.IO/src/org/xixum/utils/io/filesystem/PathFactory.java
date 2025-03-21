<<<<<<< HEAD:source/de.validas.utils.IO/src/de/validas/utils/io/filesystem/PathFactory.java
package de.validas.utils.io.filesystem;

import de.validas.utils.data.lists.IAppendable;

public class PathFactory {

	public PathFactory() {

	}

	public IAppendable createDevice(String device) {
		return new LocalDevice(device);
	}
	
	public IAppendable createUncDevice(String device) {
		return new UncDevice(device);
	}
	
	public IAppendable createDirectory(String directory) {
		return new Directory(directory);
	}
	
	public IAppendable createFile(String file) {
		return new File(file);
	}

	public IAppendable createHost(String host) {
		return new Host(host);	
	}

	public IAppendable createDirOrUnc(PathElement precessor, String segment) {
		if (precessor instanceof IHost)
			return new UncDevice(segment);
		else 
			return new Directory(segment);
	}


}
=======
package org.xixum.utils.io.filesystem;

import org.xixum.utils.data.lists.IAppendable;

public class PathFactory {

	public PathFactory() {

	}

	public IAppendable createDevice(String device) {
		return new LocalDevice(device);
	}
	
	public IAppendable createUncDevice(String device) {
		return new UncDevice(device);
	}
	
	public IAppendable createDirectory(String directory) {
		return new Directory(directory);
	}
	
	public IAppendable createFile(String file) {
		return new File(file);
	}

	public IAppendable createHost(String host) {
		return new Host(host);	
	}

	public IAppendable createDirOrUnc(PathElement precessor, String segment) {
		if (precessor instanceof IHost)
			return new UncDevice(segment);
		else 
			return new Directory(segment);
	}


}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.utils.IO/src/org/xixum/utils/io/filesystem/PathFactory.java
