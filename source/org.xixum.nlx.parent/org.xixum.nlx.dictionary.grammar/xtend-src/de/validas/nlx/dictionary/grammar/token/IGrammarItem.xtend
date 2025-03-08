/**
 * 
 */
package de.validas.nlx.dictionary.grammar.token;

import de.validas.utils.data.lists.IAppendable
import de.validas.utils.data.lists.IContainable
import de.validas.utils.data.lists.IIndexable
import org.eclipse.emf.ecore.EObject
import org.neo4j.driver.v1.types.Node
import de.validas.nlx.dictionary.grammar.types.IGrammarType

/**
 * @author schaller
 *
 */
public interface IGrammarItem extends IAppendable, IContainable, IIndexable{

	def abstract String getName();
	
	def abstract String getLabel();
	
	def abstract EObject getElement();
	
	def abstract Node getBaseNode();

	def abstract long generateID();
	
	def abstract IGrammarType getInternalType();

}
