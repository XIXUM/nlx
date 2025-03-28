/**
 * (c) XIXUM.ORG - all rights reserved
 * @author felix.schaller
 */

package org.xixum.nlx.view.fxviews.semantics.util

import org.xixum.nlx.dictionary.type.ITypeAttributes
import org.xixum.nlx.view.fxviews.access.elements.ShortCutItem
import org.xixum.nlx.view.fxviews.access.elements.SmallItem
import org.xixum.nlx.view.fxviews.semantics.ILink
import org.xixum.nlx.view.fxviews.semantics.ILinkObj
import org.xixum.nlx.view.fxviews.semantics.ILinkType
import org.xixum.nlx.view.fxviews.semantics.ILinkable
import org.xixum.nlx.view.fxviews.semantics.LinkStyle
import org.xixum.nlx.view.fxviews.semantics.types.LiteralType
import org.xixum.nlx.view.fxviews.semantics.types.WordType
import org.xixum.nlx.view.fxviews.visual.ContainerPanel
import org.xixum.nlx.view.fxviews.visual.IPanel
import org.xixum.nlx.view.fxviews.visual.NodePanel
import org.xixum.utils.data.types.XPair
import java.util.List
import java.util.Map
import javafx.geometry.Bounds
import javafx.geometry.Point2D

import static org.xixum.nlx.view.fxviews.semantics.constants.LinkConstants.LINK_HEIGHT
import java.util.ArrayList
import java.util.Arrays
import org.xixum.nlx.dictionary.grammar.types.IGrammarType

class LinkUtils {
	/**
	 * similar to FindRoot in semantic linker but with different behavior
	 */
	def static List<ILinkable> traceRoot(ILinkable sourceLink) { // find highest rule
		if (sourceLink instanceof ILinkable) {
			var results = newArrayList()
			for (parent : sourceLink.getLink() ?: #[])
				results.addAll(traceRoot(parent))
			if (results.empty)
				return #[sourceLink]
			else
				return results
		} else {
			return null
		}
	}

	def static List<XPair<Integer, ILinkable>> traceAllRoots(ILinkable sourceLink, int depth, boolean bidirect) { // find highest rule
		if (sourceLink !== null) {
			val List<ILink> parents = newArrayList()
			if (sourceLink instanceof NodePanel) {
				sourceLink.getLinks()?.values.forEach[l | parents.addAll(l)]
			} else {
				parents.addAll(sourceLink.getLink())
			}
			var result = newArrayList()
			if (parents !== null && !parents.empty) { // nullcheck obsolete
				for (link : parents) {
					var l = if (link.level > depth) link.level else depth + 1
					var trace = traceAllRoots(link, l, bidirect)
					if (trace !== null)
						for (el : trace){
							if (el.value.lowerBound >= sourceLink.lowerBound || bidirect) // recurse only into links that are right of sourcelink
								result.add(el)
						}
				}
			}
			result.add(new XPair<Integer, ILinkable>(depth, sourceLink))
			return result
		} 
		return null
	}

	def static autoRoute(ILinkObj startNode) {
		var eol = false
		var ILinkObj next = startNode
		while (!eol) {
			var result = doRoute(next)
			if (result !== null) {
				next = next.successor as ILinkObj
				while (next !== null && next.token instanceof SmallItem) {
					next = next.successor as ILinkObj
				}
			} else
				return if (next === null)
					eol = true
		}
	}

	/**
	 * selects highest level root
	 */
	private def static doRoute(ILinkable link) {
		val root = LinkUtils.traceAllRoots(link, 0, true)
		var max = 0
		var maxSpan = 0
		var XPair<Integer, ILinkable> result = null
		var i = 0
		var selection = -1
		for (el : root ?: #[]) {
			val el_link = el.value
			val key = traceLeaves(el_link, 0)
			if (el_link instanceof ILink) {
				val maxLevel = el_link.maxLevel
				val span = el_link.higherBound - el_link.lowerBound
				if (maxLevel == 0 || maxLevel >= key )
					if (key < max || isDisabled(el)) {
						if (result === null)
							result = el
					} else {
						if(key > max){ 	// if not ambiguous decide by level
							max = key
							maxSpan = span
							result = el
							selection = i
						} else if(key === max){ // if level i ambiguous decide by span
							if (span > maxSpan){
								max = key
								maxSpan = span
								result = el
								selection = i
							}
						}
					}
					if (result === null) {
						
					}
			}
			i++
		}
		if (result !== null) {
			for (i = 0; i < root.size(); i++) {
				var el = root.get(i)
				if (!isDisabled(el)) //TODO: 23.03.22 redundant check
					if (i === selection) {
						selectRoute(el.value, null, max)
					} else {
						//deselectRoute(el.value, max)
					}
			}
		}
		return result
	}
	
	def static isDisabled(XPair<Integer, ILinkable> pair) {
		var v = pair.value
		if (v instanceof ILink){
			if (v.style.classes.contains(LinkStyle.DISABLED.classes.get(0)))
				return true
		}
		false
	}

	def static int traceLeaves(ILinkable linkable, int level) {
		if (linkable instanceof ILink) {
			var links = #[linkable.startLink.value, linkable.endLink.value]
			var int max = 0
			for (child : links) {
				var branches = traceLeaves(child, level + 1)
				if (branches > max)
					max = branches
			}
			return max
		}
		return level + 1
	}


	/**
	 * deselect links recursively
	 */
	def static void selectRoute(ILinkable linkable, String typeName, int max) {
		if (linkable instanceof ILinkObj) { 
			var token = linkable.token
			if (token instanceof ShortCutItem) {
				token.selection = typeName
			}
		} else if (linkable instanceof ILink) {
			linkable.maxLevel = max
			linkable.style.replaceStyle(LinkStyle.LOW_LINK, LinkStyle.LINK) //TODO: 21.03.22 omit overriding dash
			selectRoute(linkable.endLink.value, linkable.endLink.key, max)
			selectRoute(linkable.startLink.value, linkable.startLink.key, max)
		}
	}

	/**
	 * deselect links recursively
	 */
	def static void deselectRoute(ILinkable linkable, int max) {
		if (linkable instanceof ILink) {
			linkable.maxLevel = max
			linkable.style.replaceStyle(LinkStyle.LINK, LinkStyle.LOW_LINK)
			deselectRoute(linkable.endLink.value,  max)
			deselectRoute(linkable.startLink.value,  max)
		}
	}

	def static ILinkObj findNextAdjacentPanel(ILinkable linkable, boolean leftOf) {
		if (linkable instanceof ILinkObj) {
			linkable
		} else {
			var ILink link = (linkable as ILink)
			var startPanel = findNextAdjacentPanel(link.startLink.value, leftOf)
			var endPanel = findNextAdjacentPanel(link.endLink.value, leftOf)
			var dir = (startPanel.index < endPanel.index)
			if (if (leftOf) dir else !dir)
				return endPanel
			startPanel
		}
	}
	
	def static Point2D linkToLinkCalculation(ILink link, boolean automatic) {
		if (link === null)
			return null
		var startLink = link.getStartLink()
		var endLink = link.getEndLink()

		var startPoint = recursiveLinkToPoint(startLink, link, false) // TODO: might be obsolete if method gets point
																		// from parent
		var endPoint = recursiveLinkToPoint(endLink, link, false)
		return calculateLinkOffset(startPoint, endPoint)
	}
	
	/**
	 * @param startPoint
	 * @param endPoint
	 * @return
	 */
	def static Point2D calculateLinkOffset(Point2D startPoint, Point2D endPoint) {
		if (startPoint === null || endPoint === null)
			return null
		var ey = endPoint.getY()
		var sy = startPoint.getY()
		var double y = 0
		if (ey > sy)
			y = ey
		else
			y = sy
		return new Point2D((endPoint.getX() + startPoint.getX()) / 2, y + LINK_HEIGHT)
	}
	
	def static Point2D recursiveLinkToPoint(XPair<String,ILinkable> link, ILink parent, boolean automatic) {
		if (link === null)
			return null
		var linkObj = link.getValue()
		switch (linkObj){
			ContainerPanel: {
				// makes no sense:
//				var typesAll = (linkObj as ContainerPanel).getInnerLink()
//				for (ILinkable type : typesAll?:#[]) 
//					if (type.getName().equals(link.getKey()))
//						return midPointFromRoot(linkObj)	
				
				return  midPointFromRoot(linkObj)
			} 
			default: 
				return innerRecursionResolveLink(linkObj, parent, automatic)
		}
	}
	
	def static Point2D midPointFromRoot(IPanel opposite) {
		var root = opposite.root
		if (root !== null){
			var Bounds endBounds = root.boundsInParent
			return new Point2D((endBounds.minX + endBounds.maxX) / 2, endBounds.maxY)
		} else 
			return new Point2D(0,0)
	}
	
	def static innerRecursionResolveLink(ILinkable linkObj, ILink parent,  boolean automatic){
		if (linkObj == null)
			return null
		switch (linkObj){
			IPanel: {
				var types = linkObj.getLink()
				if (types !== null && !types.isEmpty())  // TODO: 17.09.21 may be optimized to better find out if link matches object
					for (ILink type : types) {
						if (type.equals(parent) || parent === null)
							return midPointFromRoot(linkObj)
					}
				return null
			} 
			default: 
				return linkToLinkCalculation(linkObj as ILink, automatic)	
		}
	}
	
	def static getLinkHigherType(ILinkable linkable) { // consider to move Method in ILinkable
		var IGrammarType type = null
		switch linkable {
			ContainerPanel:{
				type = linkable.linkType
			}
			default: {
				type = linkable.linkType
			}
		}
		switch type {
			WordType: {
				return type.baseType //Due TypeAttributes Names are in key 
			}
			LiteralType: {
				return new XPair<String, ITypeAttributes>(type.getName, null)
			}
		}
	}
	
		/**
	 * @param start
	 * @param end
	 */
	def static calculateBounds(XPair<String, ILinkable> start, XPair<String, ILinkable> end) {
		var high = 0 
		var low = 0
		val startV = start.getValue()
		val endV = end.getValue()
		
		if (startV.getLowerBound()<endV.getHigherBound()) {
			low = startV.getLowerBound()
			high = endV.getHigherBound()
		} else {
			low = endV.getLowerBound()
			high = startV.getHigherBound()
		}
		return low -> high
	}
	
	def static addStyle(LinkStyle style, LinkStyle newStyle) {
		if (style === null){
			return LinkStyle.create(newStyle)
		} else {
			style.add(newStyle)
		}
		return style	
	}
	
	/**
	 * @param start
	 * @param endPanel
	 * @return
	 */
	def static calculateLevel(ILinkable start, ILinkable endPanel) {
		var level = 0
		//TODO: 18.08.22 better use Math.max
		for (ILinkable linkable : Arrays.asList(start, endPanel)) { // gather highest link hierarchy
			if (linkable instanceof ILink) {
				var l = linkable.getLevel()
				if(l > level)
					level = l
			}
		}
		level
	}
	
}
