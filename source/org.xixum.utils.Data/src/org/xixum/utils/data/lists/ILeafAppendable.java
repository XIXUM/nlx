<<<<<<< HEAD:source/de.validas.utils.Data/src/de/validas/utils/data/lists/ILeafAppendable.java
package de.validas.utils.data.lists;

public interface ILeafAppendable extends IAppendable {

	/* (non-Javadoc)
	 * @see de.validas.utilsData.lists.IAppendable#getSuccessor()
	 */
	@Override
	default IAppendable getSuccessor() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.validas.utilsData.lists.IAppendable#setSuccessor(de.validas.utilsData.lists.IAppendable)
	 */
	@Override
	default void setSuccessor(IAppendable next) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Successor for Leaf Node not possible");
	}

}
=======
package org.xixum.utils.data.lists;

public interface ILeafAppendable extends IAppendable {

	/* (non-Javadoc)
	 * @see org.xixum.utilsData.lists.IAppendable#getSuccessor()
	 */
	@Override
	default IAppendable getSuccessor() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.xixum.utilsData.lists.IAppendable#setSuccessor(org.xixum.utilsData.lists.IAppendable)
	 */
	@Override
	default void setSuccessor(IAppendable next) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Successor for Leaf Node not possible");
	}

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.utils.Data/src/org/xixum/utils/data/lists/ILeafAppendable.java
