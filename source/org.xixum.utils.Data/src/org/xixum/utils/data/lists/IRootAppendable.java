<<<<<<< HEAD:source/de.validas.utils.Data/src/de/validas/utils/data/lists/IRootAppendable.java
/**
 * 
 */
package de.validas.utils.data.lists;

/**
 * @author Felix Schaller
 *
 */
public interface IRootAppendable extends IAppendable {
	
	@Override
	default IAppendable getPrecessor() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.validas.utilsData.lists.IAppendable#setSuccessor(de.validas.utilsData.lists.IAppendable)
	 */
	@Override
	default void setPrecessor(IAppendable next) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Successor for Root Node not possible");
	}

	

}
=======
/**
 * 
 */
package org.xixum.utils.data.lists;

/**
 * @author Felix Schaller
 *
 */
public interface IRootAppendable extends IAppendable {
	
	@Override
	default IAppendable getPrecessor() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.xixum.utilsData.lists.IAppendable#setSuccessor(org.xixum.utilsData.lists.IAppendable)
	 */
	@Override
	default void setPrecessor(IAppendable next) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Successor for Root Node not possible");
	}

	

}
>>>>>>> 28be792edcf63b5c495498de39713fad9b7858d6:source/org.xixum.utils.Data/src/org/xixum/utils/data/lists/IRootAppendable.java
