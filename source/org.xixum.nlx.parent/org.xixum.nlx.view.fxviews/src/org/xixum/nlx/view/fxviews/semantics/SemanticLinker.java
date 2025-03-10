/**
 * 
 */
package org.xixum.nlx.view.fxviews.semantics;

import static org.xixum.nlx.constants.Neo4jConstants.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.neo4j.driver.internal.InternalRecord;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Node;

import org.xixum.nlx.view.fxviews.semantics.util.LinkUtils;
import org.xixum.utils.data.types.XPair;
import javafx.application.Platform;

/**
 * @author schaller
 *
 */
public class SemanticLinker {

	/**
	 * 
	 */
	protected IListener listener;
	
	public SemanticLinker() {
		
	}
	protected List<Node> getRecord4var(List<Record> records, String varName) {
		List<Node> result = null; 
		for (Record rec : records) {
			if (rec instanceof InternalRecord) {
				Value value = rec.get(varName);
				if (value instanceof NodeValue){
					if (result == null)
						result = Collections.emptyList();
					result.add(value.asNode());
				}
			}
		}
		return result;
	}

	public ILink makeLink(ILinkable start, ILinkable endPanel,  Map<? extends String, ? extends Object> intermed, List<Record> recMap) {
		try {
			if (start == null || endPanel == null) return null;
			System.out.printf("\n[SemanticLinker]: create Link %1$s \t Start: %2$s  End: %3$s", recMap.get(0).get(_LINK).asNode().get("name"), start.getName(), endPanel.getName());
			//expect recMap cannot be null or empty here
			String startType = recMap.get(0).get(_SOURCE).asNode().get(_NAME).asString();
			String endType = recMap.get(0).get(_TARGET).asNode().get(_NAME).asString();
			int level = LinkUtils.calculateLevel(start, endPanel);
			ILinkInfo linkInfo = null;
			if (recMap.size() > 1) {
				linkInfo = new PathLinkInfo(recMap);
			} else {
				linkInfo = new LinkInfo(recMap.get(0));
			}
			
			ILink link = 
					new SemanticLink(new XPair<String, ILinkable>(startType,start), 
					                      new XPair<String, ILinkable>(endType, endPanel), intermed, 
					                      linkInfo, level+1); 
			if (listener != null)
				Platform.runLater(()->{
					listener.update();
				});
			return link;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setListener(IListener linkListener) {
		this.listener = linkListener;
		
	}

}
