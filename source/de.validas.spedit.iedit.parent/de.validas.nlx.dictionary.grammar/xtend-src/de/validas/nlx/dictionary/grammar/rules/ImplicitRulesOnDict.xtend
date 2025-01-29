package de.validas.nlx.dictionary.grammar.rules

import de.validas.nlx.ai.IParserDriver
import de.validas.nlx.ai.ParserDriver
import de.validas.nlx.ai.neo4j.Neo4jAccess.Action
import de.validas.nlx.dictionary.IDictionaryAccess
import de.validas.nlx.dictionary.grammar.factories.PredicateFactory
import de.validas.nlx.dictionary.grammar.factories.RuleNodeFactory
import de.validas.nlx.dictionary.grammar.nodes.ImplRuleNode
import de.validas.nlx.dictionary.grammar.runnables.ImplRuleRunnable
import de.validas.nlx.dictionary.grammar.token.IGrammarItem
import de.validas.spedit.naturalLang.New_Line
import de.validas.spedit.naturalLang.Sentence
import de.validas.spedit.naturalLang.SubSentence
import de.validas.spedit.naturalLang.Word
import de.validas.utils.data.lists.IAppendable
import de.validas.utils.data.types.XPair
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.builder.debug.IBuildLogger
import org.neo4j.driver.internal.value.NodeValue
import org.neo4j.driver.v1.Record
import org.neo4j.driver.v1.types.Node

import static de.validas.nlx.constants.Neo4jConstants._NODE
import static de.validas.nlx.constants.Neo4jConstants._TOKEN
import static de.validas.nlx.dictionary.constants.NodeConstants._IMPL_DICT_RULE
import static de.validas.nlx.dictionary.constants.NodeConstants._KOMMA
import de.validas.nlx.dictionary.grammar.factories.ContextFactory

class ImplicitRulesOnDict {

	protected IDictionaryAccess dictAcc
	protected IParserDriver driver
	protected List<ImplRuleNode> rules
	
//	@Inject
//	private IBuildLogger buildLogger;

	/**
	 * MOVE THIS Class into Dictionary Plugin --> cyclic dependency
	 */
	new(IDictionaryAccess dictAcc, IBuildLogger logger) {
		this.dictAcc = dictAcc
		
		this.driver = new ParserDriver(dictAcc.dbAccessor, 
									new RuleNodeFactory(),
									new PredicateFactory(dictAcc.dbAccessor),
									new ContextFactory(),
									logger
									)
	}
		
	/**
	 * Start Rule checking:
	 */
	def solve(IGrammarItem item) {
		if (!dictAcc.isConnected()) {
			return
		}
		if (rules === null || rules.isEmpty())
			createImplRules(item)
		else
			updateRules(item)
				
		var List<Thread> runners = new ArrayList<Thread>()
		// create Threads
		for (rule : rules){
			runners.add(new ImplRuleRunnable(rule, item)) //TODO: 19.09.22 Item already in rule
		}
		// runners dispatch (do not limit on maximum parallel threads yet)
		for (runner : runners) {
			runner.start() 
		}
		// runners join
		for (runner : runners) {
			runner.join()
			if (runner instanceof ImplRuleRunnable) 
				runner.getResult
		}
			
	}
	
	def updateRules(IGrammarItem item) {
		for (rule:rules) {
			rule.setAttribute(_TOKEN, item)
		}
	}


	/**
	 * 
	 */
	def void createImplRules(IAppendable item) {
		
		// TODO: preconfig. currently local
		var List<Record> result = driver.dbAccessor.runCodeRecords('''
MATCH («_NODE»:«_IMPL_DICT_RULE»)
RETURN «_NODE»''', Action.READ)

		var List<ImplRuleNode> ruleNodes = new ArrayList<ImplRuleNode>()
		for (Record record : result) {
			var Node node = (record.get(_NODE.toString()) as NodeValue).asNode
			ruleNodes.add(new ImplRuleNode(node, item, driver.newCache))
		}
		this.rules = ruleNodes
	}

	/**
	 * creates chain on element Base
	 */
	@Deprecated
	def EList<XPair<EObject, String>> generateChain(Sentence sentence) {
		var chain = new BasicEList();
		var int index = 0;
		for (ssentence : sentence.subsentence) {
			if (index > 0) {
				chain.add(new XPair<EObject, String>(null, _KOMMA))
			}
			for (element : (ssentence as SubSentence).elements) {
				if (! (element instanceof New_Line))
					chain.add(new XPair<EObject, String>(element, null))
			}
			index++
		}
		return chain
	}

	def boolean checkAllWordsTrained(EList<XPair<EObject, String>> chain) {
		// get type
		for (touple : chain) {
			if (touple.key instanceof Word) {
				var String[] chunks = (touple.key as Word).word //TODO: word now has subobjects
				for (chunk : chunks) {
					// TODO: find complete training via AnnotarionInfo. This is quick solution
					var result = dictAcc.findInDictionary(chunk)
					if(result !== null) 
									return false;
					touple.value = result.types.get(0).key;
				}
			}
		}
		true
	}
}
