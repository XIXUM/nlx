package org.xixum.utils.io.filesystem;

import org.xixum.utils.data.lists.IAppendable;

public interface IDirectory extends IAppendable{

	public String getName();
	public void setName(String name);
	public boolean exists();

}
