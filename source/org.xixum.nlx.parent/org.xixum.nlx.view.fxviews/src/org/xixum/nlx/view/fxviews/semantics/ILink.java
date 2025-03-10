/**
 * 
 */
package org.xixum.nlx.view.fxviews.semantics;

import java.util.List;
import java.util.Set;

import org.xixum.nlx.view.fxviews.control.IDragController;
import org.xixum.utils.data.types.XPair;
import javafx.geometry.Point2D;
import org.xixum.nlx.view.fxviews.semantics.LinkStyle;
import org.xixum.nlx.view.fxviews.semantics.types.TypeElement;

/**
 * @author schaller
 *
 */
public interface ILink extends ILinkable {

	public List<ILink> getParent();

	public XPair<String, ILinkable> getOpposite(ILinkable node);

	public XPair<String, ILinkable> getStartLink();

	public XPair<String, ILinkable> getEndLink();

	public LinkPath getRoot();

	public ILinkInfo getLinkInfo();
	
	public Set<ILink> getLinks();

	public void setStyle(LinkStyle style);

	public LinkStyle getStyle();

	public int getLevel();

	public int getMaxLevel();

	public void setMaxLevel(int i);

	public abstract IDragController getDragController();

	public void removeLink();

	public void draw(Point2D startPoint, Point2D endPoint);
	
	public ILinkable getCardinalType();
	
	public boolean hasCardinalType();
	
	public ILinkable getForwardType();
	
	public boolean hasForwardType();
	
	public boolean detach(ILinkable origin);

}
