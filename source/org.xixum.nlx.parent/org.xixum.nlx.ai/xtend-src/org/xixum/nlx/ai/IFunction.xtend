/**
 * (c) XIXUM.ORG - all rights reserved
 */

package org.xixum.nlx.ai

/**
 * stubs for delegate functions
 * @author: felix schaller
 */

interface IFunction {
}

interface IFunction0<O> extends IFunction {
	def O apply();
}

interface IFunction1<I,O> extends IFunction {
	def O apply(I e);
}
