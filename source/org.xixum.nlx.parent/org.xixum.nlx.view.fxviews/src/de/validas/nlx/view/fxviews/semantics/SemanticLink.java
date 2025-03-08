/**
 * (c) 2022 felixschaller.com
 */
package de.validas.nlx.view.fxviews.semantics;

import static de.validas.nlx.constants.Neo4jConstants._A;
import static de.validas.nlx.constants.Neo4jConstants._ATTR;
import static de.validas.nlx.constants.Neo4jConstants._HIT;
import static de.validas.nlx.constants.Neo4jConstants._LA;
import static de.validas.nlx.constants.Neo4jConstants._LINK;
import static de.validas.nlx.constants.Neo4jConstants._LK;
import static de.validas.nlx.constants.Neo4jConstants._LI;
import static de.validas.nlx.constants.Neo4jConstants._ID;
import static de.validas.nlx.constants.Neo4jConstants._NAME;
import static de.validas.nlx.constants.Neo4jConstants._R;
import static de.validas.nlx.constants.Neo4jConstants._SOURCE;
import static de.validas.nlx.constants.Neo4jConstants._TARGET;
import static de.validas.nlx.view.fxviews.semantics.constants.FxViewConstants._MENU_DELETE;
import static de.validas.nlx.view.fxviews.semantics.constants.FxViewConstants._MENU_UNDO;
import static de.validas.nlx.view.fxviews.semantics.constants.FxViewConstants._MENU_FORWARD_RIGHT;
import static de.validas.nlx.view.fxviews.semantics.constants.FxViewConstants._MENU_FORWARD_LEFT;
import static de.validas.nlx.constants.Neo4jConstants._P;
import static de.validas.nlx.dictionary.constants.DictionaryConstants._EXCLUDED;
import static de.validas.nlx.dictionary.constants.DictionaryConstants._INCLUDED;
import static de.validas.nlx.dictionary.constants.DictionaryConstants._LEFT_OVER;
import static de.validas.nlx.dictionary.constants.DictionaryConstants._ORDINAL;
import static de.validas.nlx.dictionary.constants.DictionaryConstants._CARDINALITY;
import static de.validas.nlx.view.fxviews.semantics.constants.GrammarConstants._SEPARATOR;
import static de.validas.nlx.view.fxviews.semantics.constants.GrammarConstants._START;
import static de.validas.nlx.view.fxviews.semantics.constants.GrammarConstants._END;
import static de.validas.nlx.view.fxviews.semantics.constants.FxViewConstants._FORWARD_LINK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.neo4j.driver.internal.value.IntegerValue;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.internal.value.NullValue;
import org.neo4j.driver.internal.value.StringValue;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;

import de.validas.nlx.constants.Direction;
import de.validas.nlx.dictionary.IDictionaryAccess;
import de.validas.nlx.dictionary.constants.AttributeSet;
import de.validas.nlx.dictionary.type.ITypeAttributes;
import de.validas.nlx.dictionary.type.LinkTypeAttribute;
import de.validas.nlx.dictionary.type.elements.IRelationshipEL;
import de.validas.nlx.view.fxviews.control.GrammarContextMenu;
import de.validas.nlx.view.fxviews.control.IContextMenu;
import de.validas.nlx.view.fxviews.control.IDragController;
import de.validas.nlx.view.fxviews.semantics.types.AbstractLinkType;
import de.validas.nlx.view.fxviews.semantics.types.CardinalType;
import de.validas.nlx.view.fxviews.semantics.types.ForwardType;
import de.validas.nlx.view.fxviews.semantics.types.IForwardLinkable;
import de.validas.nlx.view.fxviews.semantics.types.InterpunctionType;
import de.validas.nlx.view.fxviews.semantics.types.LiteralType;
import de.validas.nlx.view.fxviews.semantics.types.TypeElement;
import de.validas.nlx.view.fxviews.semantics.types.WordType;
import de.validas.nlx.view.fxviews.semantics.util.IDelegates.Procedure;
import de.validas.nlx.view.fxviews.semantics.util.LinkUtils;
import de.validas.nlx.view.fxviews.views.IPanelContainer;
import de.validas.utils.data.types.XPair;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

/**
 * @author schaller
 *
 */
@SuppressWarnings("rawtypes")
public class SemanticLink implements ILink {
	
	

	protected Set<ILink> links;
	protected XPair<String, ILinkable> startLink; // TODO: 15.03.22 replace by a typeElement class
	protected XPair<String, ILinkable> endLink;
	protected ILinkInfo linkInfo;
	protected ILinkType type;
	@Deprecated    //TODO: 18.08.22 why deprecated?
	protected ITypeAttributes linkAttribs;
	//protected IlinkObj forwardType;  // TODO: 14.03.2022 find out weather forward and cardinal types can be the same / are redundant
	protected ILinkable cardinalType; 
	
	protected ILinkable forwardType; //TODO: 10.01.2023 replace forward Type implicitly by selecting left or right branch
	
	protected LinkStyle linkStyle;

	protected LinkPath linkPath;
	protected IPanelContainer canvas;
	protected IDragController dragController;

	protected int maxLevel = 0;
	protected int level = 0;
	protected boolean drawn = false;
	protected IContextMenu menuItems;
	protected int lower;
	protected int higher;
	protected Map<? extends String, ? extends Object> intermediate;
	
	Procedure<MenuItem> setForwardLeft = mItem -> { //TODO: 23.06.22 disable others by menuSet
		if (forwardType != null && ((IForwardLinkable)forwardType).getDirection().equals(Direction.START)){
			((CheckMenuItem)mItem).setSelected(true);
		} else {
			((CheckMenuItem)mItem).setSelected(false);
		}
	};
	
	Procedure<MenuItem> setForwardRight = mItem -> {
		if (forwardType != null && ((IForwardLinkable)forwardType).getDirection().equals(Direction.END)){
			((CheckMenuItem)mItem).setSelected(true);
		} else {
			((CheckMenuItem)mItem).setSelected(false);
		}
	};
	
	//this delegate checks if forward type is selected or not
	private Procedure<Map> cmDelegate = mItems -> {
		String selected = "";
		if (forwardType instanceof IForwardLinkable) {
			Direction dir = ((IForwardLinkable) forwardType).getDirection();
			for (Object key : mItems.keySet()) {
				if (key instanceof String && key.equals(dir.name().toLowerCase())) {
					Object cmi = mItems.get(key);
					if (cmi instanceof CheckMenuItem) {
						((CheckMenuItem)cmi).setSelected(true);
						((CheckMenuItem)cmi).setDisable(false);
						selected = (String) key;
					}
				} 
			}
			if (!selected.isEmpty()) {
				for (Object key : mItems.keySet()) {
					if (key instanceof String && !key.equals(selected)) {
						Object cmi = mItems.get(key);
						if (cmi instanceof CheckMenuItem) {
							((CheckMenuItem)cmi).setSelected(false);
							((CheckMenuItem)cmi).setDisable(true);
						}
					} 
				}
			}
		}
		
	};
	
	
	private HashMap<String, MenuItem> menuList = new HashMap<String, MenuItem>(){
		/**
		 * Map that defines the available menues
		 */
		private static final long serialVersionUID = 1L;

	{
		MenuItem itemDelete = new MenuItem(_MENU_DELETE);
		itemDelete.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				disableLinkPattern(getCanvas().getViewPart().getDictAccess());
			}
		});
		put(_MENU_DELETE, itemDelete);
		
		MenuItem itemUndo = new MenuItem(_MENU_UNDO);
		itemUndo.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				undoLinkPattern(getCanvas().getViewPart().getDictAccess());
			}
		});
		put(_MENU_UNDO, itemUndo);
		
		MenuItem itemFFleft = new CheckMenuItem(_MENU_FORWARD_LEFT);
		itemFFleft.setUserData(setForwardLeft);
		itemFFleft.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				defineForwardType(getCanvas().getViewPart().getDictAccess(), Direction.START);
			}
		});
		put(_MENU_FORWARD_LEFT, itemFFleft);
		
		MenuItem itemFFright = new CheckMenuItem(_MENU_FORWARD_RIGHT);
		itemFFright.setUserData(setForwardRight);
		itemFFright.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				defineForwardType(getCanvas().getViewPart().getDictAccess(), Direction.END);
			}
		});
		put(_MENU_FORWARD_RIGHT, itemFFright);
		
		MenuItem itemSep = new SeparatorMenuItem();
		put(_SEPARATOR, itemSep);
//		
		
	}};
	
	
	//TODO: inverse filter criteria, name the keys to keep not the one to remove
	protected static final List<String> FILTER_PROPS_PATTERN = new ArrayList<>(
		    Arrays.asList(_SOURCE)
			);
	protected static final List<String> FILTER_PROPS_ATTRS = new ArrayList<>(
		    Arrays.asList(_HIT)
			);

	/**
	 * @param endPanel
	 * @param startPanel
	 * 
	 */

	// TODO: move link calculation in SemanticLink

	public SemanticLink(XPair<String, ILinkable> start, XPair<String, ILinkable> end,  Map<? extends String, ? extends Object> intermed, ILinkInfo linkInfo, int level) {
		this(start, end, intermed, linkInfo, level, null);
	}

	public SemanticLink(XPair<String, ILinkable> start, XPair<String, ILinkable> end, Map<? extends String, ? extends Object> intermed, ILinkInfo linkInfo, int level,
			LinkStyle style) {
		// boolean pass = false;
		try {
			this.startLink = start;
			this.endLink = end;
			this.level = level;
			this.intermediate = intermed;
			ILinkable startConn = start.getValue();
			ILinkable endConn = end.getValue();
			this.links = new HashSet<ILink>();
			this.linkInfo = linkInfo;
			this.canvas = startConn.getCanvas();
			this.linkStyle = LinkStyle.create(LinkStyle.CLEAR); //Initializing just in case of unexpected exceptions, because it can never be null elsewhere...
			endConn.setLink(end.getKey(), this);
			startConn.setLink(start.getKey(), this);
			linkAttribs = new LinkTypeAttribute((Node) linkInfo.getRecord(_LINK), start.getValue().getType().getValue(),
					end.getValue().getType().getValue());
			// TODO: consider to create a more specific class type:
			this.type = new LiteralType(((Node) linkInfo.getRecord(_LINK)).get(_NAME).asString(), this);
			this.dragController = canvas.getViewPart().getDragController();
			
			createForwardType();
			
			Pair<Integer, Integer> pair = LinkUtils.calculateBounds(start, end);
			this.lower = pair.getKey();
			this.higher = pair.getValue();
			
			this.canvas.addLinkBuffer(this);
			
			List<String> menuSet = Collections.<String>unmodifiableList(Arrays.asList(_MENU_DELETE, _SEPARATOR, _MENU_FORWARD_LEFT, _MENU_FORWARD_RIGHT)); 
			
			ILink parentS = null;
			ILink parentE = null;
			startConn = start.getValue();
			endConn = end.getValue();
			if (startConn instanceof ILink)
				parentS = (ILink) startConn;
			if (endConn instanceof ILink)
				parentE = (ILink) endConn;
			
			if (style == null) {

				if (parentS != null || parentE != null) {  //FIXME: 18.03.22 double null check
					if ((parentS != null && parentS.getStyle().contains(LinkStyle.DISABLED)) || (parentE != null && parentE.getStyle().contains(LinkStyle.DISABLED)) ) //TODO: 20.03.22 optimize redundant if's by setting states and decide by switch later
						this.linkStyle = LinkStyle.create(LinkStyle.DISABLED);
					else	
						this.linkStyle = clalculateLinkStyle();
//					
				} else
					this.linkStyle = clalculateLinkStyle();
				if (parentS != null && linkStyle.contains(LinkStyle.DISABLED) &&  !parentS.getStyle().contains(LinkStyle.DISABLED)) {  // offer undo function if no parent is disabled
					menuSet = Collections.<String>unmodifiableList(Arrays.asList(_MENU_UNDO));
				}
			} else if ((parentS != null && parentS.getStyle().contains(LinkStyle.DISABLED)) || (parentE != null && parentE.getStyle().contains(LinkStyle.DISABLED)))
					this.linkStyle = LinkStyle.create(LinkStyle.DISABLED);
			else 
				this.linkStyle = style;
			
			Map<String, String> mnemonics  = new HashMap<String, String>() {/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
	
			{
			    put(_START, start.getKey());
			    put(_END, end.getKey());
			}};
			this.menuItems = createMenuItems(menuSet, mnemonics);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void createForwardType() {
		Record rec = this.linkInfo.getRecord();

		Value source = rec.get(_SOURCE);
		Value target = rec.get(_TARGET);
		
		if (!(rec.get(_START) instanceof NullValue)) {
			forwardType = new ForwardType(this, Direction.START, source.asNode());
			this.linkStyle = LinkUtils.addStyle(this.linkStyle, LinkStyle.FORWARD_LINK);
			return;
		}
		
		if (!(rec.get(_END) instanceof NullValue)) {
			forwardType = new ForwardType(this, Direction.END, target.asNode());
			this.linkStyle = LinkUtils.addStyle(this.linkStyle, LinkStyle.FORWARD_LINK);
		}
		
	}

	@SuppressWarnings("unchecked")
	private LinkStyle clalculateLinkStyle() {
		Map<AttributeSet, Collection<? extends IRelationshipEL>> attributes = Stream
				.of(new Object[][] {
						{ AttributeSet.START, ((LinkTypeAttribute) linkAttribs).getAttrsEL(AttributeSet.START) },
						{ AttributeSet.END, ((LinkTypeAttribute) linkAttribs).getAttrsEL(AttributeSet.END) }, })
				.collect(Collectors.toMap(data -> (AttributeSet) data[0],
						data -> (Collection<? extends IRelationshipEL>) data[1]));
		
		Map<AttributeSet, Collection<? extends IRelationshipEL>> leftOvers = new HashMap<AttributeSet, Collection<? extends IRelationshipEL>>() {
			private static final long serialVersionUID = -6626213785875888632L;
		{
			put(AttributeSet.START, (Collection<? extends IRelationshipEL>) ((HashSet)attributes.get(AttributeSet.START)).clone());
			put(AttributeSet.END, (Collection<? extends IRelationshipEL>) ((HashSet)attributes.get(AttributeSet.END)).clone());
		}};
		
		LinkStyle style = this.linkStyle;
		// Find Redundant patterns and set
		style = checkRedundance(style);

		Record rec = linkInfo.getRecord();  // set base pattern
		List<Relationship> excluded = new ArrayList<>();
		List<Relationship> included = new ArrayList<>(); // for Debugging purposes only
		List<Relationship> leftOver = new ArrayList<>();
		if (linkInfo instanceof PathLinkInfo) {
			List<Record> records = ((PathLinkInfo)linkInfo).getRecordMap();
			for(Record rc : records) {
				Value red = rc.get(_R);  
				if (!(red instanceof NullValue) && cardinalType != null && red.asNode().get(_CARDINALITY).asInt() != cardinalType.getCardinality())
					continue; // should ignore patterns with deviating ordinal
				Value ov = rc.get(_A).asNode().get(_ORDINAL);
				if (ov instanceof IntegerValue) { //select root pattern
					if (ov.asInt() == 0)
						rec = rc;
				} else if (ov instanceof NullValue) {
					rec = rc;			
				}
				
				//add exclude patterns
				ArrayList<Object> pAttr = new ArrayList<Object>(rc.get(_ATTR).asList());
				for (Object el : pAttr) {
					if (el instanceof Map) {
						Map lk = (Map) ((Map) el).get(_LK);
						Relationship l = (Relationship) lk.get(_LA);
						if (l.type().equals(_EXCLUDED)) {
							excluded.add(l);
						} else if (l.type().equals(_INCLUDED)) {
							included.add(l);
						} else if (l.type().equals(_LEFT_OVER)) {
							leftOver.add(l);
						}
					}
				}
			}
		} 
		Value a = rec.get(_A);
		List<Object> attr = null;
		if (!a.isNull()) {
			attr = new ArrayList<Object>(rec.get(_ATTR).asList());
			for (AttributeSet setKey : attributes.keySet())
				for (IRelationshipEL latt : attributes.get(setKey)) {
					Relationship ar = latt.getRelationship();
					Map found = null;
					for (Object el : attr) {
						if (el instanceof Map) {
							Map lk = (Map) ((Map) el).get(_LK);
							Relationship l = (Relationship) lk.get(_LA);
							if (ar.type().equals(l.type())) {
								if (l.get(_SOURCE).asString().equals(setKey.toString().toLowerCase())) {
									int dir = 0;
									if (ar.endNodeId() == l.endNodeId()) // TODO: 20.01.22 just for debug purposes,
																			// replace by logical OR in the future
										dir = 2;
									if (ar.startNodeId() == l.endNodeId())
										dir = 1;
									if (dir > 0) {
										Map<String, Object> propsL = new HashMap<String, Object>(l.asMap());
										for (String key : FILTER_PROPS_PATTERN) {
											propsL.remove(key);
										}
										Map<String, Object> propsA = new HashMap<String, Object>(ar.asMap());
										for (String key : FILTER_PROPS_ATTRS) {
											propsA.remove(key);
										}
										boolean match = false;
										if (!propsL.isEmpty() && !propsA.isEmpty()) {
											if (propsL.equals(propsA))
												match = true;
										} else
											match = true;
										if (match) {
											found = (Map) el;
											leftOvers.get(setKey).remove(latt);
											break;
										}
									}
								}
							}

						}

					}
					if (found != null)
						attr.remove(found);
				}
			
		}
		
//		remove attributes from exclusion patterns
		Set<Object> remove = new HashSet<>();
				
		for(Relationship rel : excluded) {  //TODO: 18.08.22 just collect ID's not entire Relationships
			for (Object at : attr) {
				
				if ((long)((Map) ((Map) at).get(_LK)).get(_LI) == rel.get(_ID).asLong()) {
					remove.add(at);
				}
			}
			if (!remove.isEmpty()) {
				attr.removeAll(remove);
				remove.clear();
			}
		}
		
		if (attr != null && attr.isEmpty()) {
			Value red = rec.get(_R);
			if (cardinalType != null && red instanceof NodeValue) {
				if (getCardinality() >= red.asNode().get(_CARDINALITY).asInt())
					style = LinkUtils.addStyle(style, LinkStyle.DISABLED);
				else
					style = LinkUtils.addStyle(style, LinkStyle.LOW_LINK);
			} else {
				style = LinkUtils.addStyle(style, LinkStyle.DISABLED);
			}
		} else {
			style = LinkUtils.addStyle(style, LinkStyle.LOW_LINK);
		
		}
		

		return style;
	}


	private LinkStyle checkRedundance(LinkStyle style) {
		LinkStyle newStyle = LinkStyle.create(new ArrayList<String>());
		boolean intermedMatches = false;
		Map<? extends String, ? extends Object> intermed = startLink.getValue().getIntermediate();
		if (intermed != null && intermediate !=null && (compareIntermed(intermed,endLink.getValue().getIntermediate()) || compareIntermed(intermed,intermediate)))	
			intermedMatches = true;
		String cardinalStart;
		String cardinalEnd;
		if (startLink.getValue() instanceof ILink && ((ILink)startLink.getValue()).hasCardinalType())
			cardinalStart =  ((ILink)startLink.getValue()).getCardinalType().getName();
		else
			cardinalStart = startLink.getKey(); //TODO: 25.08.22 use id
		
		if (endLink.getValue() instanceof ILink && ((ILink)endLink.getValue()).hasCardinalType())
			cardinalEnd =  ((ILink)endLink.getValue()).getCardinalType().getName();
		else
			cardinalEnd = endLink.getKey();
		
		if (cardinalStart.equals(cardinalEnd) && intermedMatches) {
			this.cardinalType = new CardinalType(this, startLink, endLink, linkAttribs);
			newStyle.add(style);
			newStyle.add(LinkStyle.DASHED);
			return newStyle;
		}

		return style;
	}

	private boolean compareIntermed(Map<? extends String, ? extends Object> intermed,
			Map<? extends String, ? extends Object> intermed2) {
		Set<String> ik1 = (Set<String>) intermed.keySet();
		Set<String> ik2 = (Set<String>) intermed2.keySet();
		if (ik1.equals(ik2)) {
			for(String k1 : ik1) {
				for(String k2 : ik2) {
					Object iv1 = intermed.get(k1);
					Object iv2 = intermed2.get(k2);
					if (iv1 instanceof Intermediate && iv2 instanceof Intermediate) {
						ILinkType it1 = ((Intermediate)iv1).getType(); 
						ILinkType it2 = ((Intermediate)iv2).getType(); 
						if (it1.getClass().equals(it2.getClass()))
							return ((InterpunctionType)it1).getCathegory().equals(((InterpunctionType)it2).getCathegory());
					}
				}
			}
			return ik1.isEmpty();
		}
			
		return false;
	}

	/**
	 * @return the cardinalType
	 */
	@Override
	public ILinkable getCardinalType() {
		return cardinalType;
	}
	
	@Override
	public boolean hasCardinalType() {
		return cardinalType != null;
	}
	
	/**
	 * @return the cardinalType
	 */
	@Override
	public ILinkable getForwardType() {
		return forwardType;
	}
	
	@Override
	public boolean hasForwardType() {
		return forwardType != null;
	}


	@SuppressWarnings("unchecked")
	private IContextMenu createMenuItems(List<String> menuSet, Map<String, String> mnemonics) {
		if (menuItems == null)
			menuItems = new GrammarContextMenu(cmDelegate);
		
		XPair<String,String> newMn = null;
		for (String item : menuSet) {
			MenuItem mItem = menuList.get(item);
			String mn = mItem.getText();
			if (mn != null) {
				for (String key : mnemonics.keySet()) {
					String escaped = String.format("{%s}", key);
					if (mn.contains(escaped)) {
						newMn = new XPair<>(key, mn.replace(escaped, mnemonics.get(key)));
						break;
					} else {
						newMn = new XPair<>(item, mn);
					}
				}
				mItem.setText(newMn.getValue());
				Object data = mItem.getUserData();
				if (data instanceof Procedure<?>) {
					((Procedure<MenuItem>)data).apply(mItem);
				}
			} else {
				newMn = new XPair<>(item, mn);
			}
			if (newMn != null)
				menuItems.add(newMn.getKey(), mItem);
		}
		// TODO: 06.12.21 returns a field, may be externalized into static Method.
		return menuItems;
	}

	private void disableLinkPattern(IDictionaryAccess dictAccess) {

		try {
			int cardinality =0;
			XPair<String, ITypeAttributes> attrs = null;
			if (cardinalType != null) {
				cardinality = getCardinality();
				attrs = cardinalType.getType();
			}
			dictAccess.disableNode((Node) linkInfo.getRecord(_LINK),
					((LinkTypeAttribute) linkAttribs).getParent(AttributeSet.START),
					((LinkTypeAttribute) linkAttribs).getParent(AttributeSet.END), cardinality, attrs);
			this.linkStyle = LinkStyle.create(LinkStyle.DISABLED);  //TODO: disable also all downstream links
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	private void undoLinkPattern(IDictionaryAccess dictAccess) {
		//TODO: 18.03.22 currently just delete but replace by pattern
		try {
			dictAccess.deletePatternFromNode((Node) linkInfo.getRecord(_LINK));
			this.linkStyle = LinkStyle.create(LinkStyle.LOW_LINK);  // should recaluculate route here
			//TODO: 20.03.22 Update LinkTypes and its descendants
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	private void defineForwardType(IDictionaryAccess dictAccess, Direction dir) {
		try { //TODO: 10.01.23 remove catch block
			dictAccess.defineForwardType(linkInfo.getRecord(), dir);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the linkInfo
	 */
	@Override
	public ILinkInfo getLinkInfo() {
		return linkInfo;
	}

/**
 * @deprecated: use getLinks
 */
	@Override
	@Deprecated
	public List<ILink> getLink() { //
		return new ArrayList<ILink>(getLinks());
	}

/**
 * gets the linked types	
 * @return: List<ILink>
 */
	@Override
	public Set<ILink> getLinks() { //
		return links;
	}

	public void addLink(ILink link) {
		final Function1<ILink, Long> _function = (ILink r) -> {
			return ((Node) r.getLinkInfo().getRecord(_LINK)).id();
		};
		List<Long> ids = ListExtensions.<ILink, Long>map(new ArrayList<ILink>(links), _function);
		if (!ids.contains(((Node) link.getLinkInfo().getRecord(_LINK)).id()))
			this.links.add(link);
	}

	/**
	 * @deprecated: use getLinks
	 */
	@Deprecated
	@Override
	public List<ILink> getParent() {
		return getLink();
	}

	/**
	 * @return the startPanel
	 */
	public XPair<String, ILinkable> getStartLink() {
		return startLink;
	}

	/**
	 * @return the endPanel
	 */
	public XPair<String, ILinkable> getEndLink() {
		return endLink;
	}

	@Override
	public XPair<String, ILinkable> getOpposite(ILinkable node) {
		if (startLink != null && startLink.getValue().equals(node))
			return endLink;
		else
			return startLink;
	}

	@Override
	public LinkPath getRoot() {
		return linkPath;
	}

	public boolean detach(ILinkable origin) {
		XPair<String, ILinkable> opposite = getOpposite(origin);
		if (links!=null && !links.isEmpty()) {
			ArrayList<ILink> register = new ArrayList<ILink>();
			for (ILink link : links) {
				if (link.detach(this))
					link.removeLink();
					register.add(link); 
			}
			links.removeAll(register);
		}
		ILinkable linkTarget = opposite.getValue();
		startLink = null;
		endLink = null;
		if (linkTarget instanceof ILinkObj) {
			String typeName = opposite.getKey();
			ILinkType literalType = (ILinkType) ((ILinkObj)linkTarget).getToken().getInternalType();
			if (literalType instanceof WordType) {
				List<XPair<String, ILinkable>> register = new ArrayList<XPair<String, ILinkable>>();
				List<TypeElement> types = ((WordType)literalType).getAllTypes();
				for (TypeElement typeEl: types) {
					
					if (typeEl.getName().equals(typeName)) {
						HashMap<XPair<String, ILinkable>, ILink> typeLinks = typeEl.getLinks();
						for (XPair<String, ILinkable> typeKey : typeLinks.keySet()) {
							if (typeLinks.get(typeKey).equals(this))
								register.add(typeKey);  //register elms for deletion to avoid concurrent mod
						}
						
						for(XPair<String, ILinkable>e: register)
							return typeLinks.remove(e) != null;
					}
				}
			}
			//TODO: 07.12.22 put other types below
		} else if (linkTarget instanceof ILink) {
			return ((ILink)linkTarget).getLinks().remove(this);
		} 
//		else
//			return false;
		
		return false;
	}
	

	@Override
	public ILinkType getLinkType() {
		return type;
	}

	@Override
	public String toString() {
		XPair<String, ILinkable> start = getStartLink();
		XPair<String, ILinkable> end = getEndLink();

		return String.format("Start: [%1$s]->[%2$s] End: [%3$s]->[%4$s] ", start.getKey(),
				start.getValue().getName(), end.getKey(), end.getValue().getName());
	}

	@Override
	public IPanelContainer getCanvas() {
		return canvas;
	}

	@Override
	public String getName() {
		return ((Node)linkInfo.getRecord(_LINK)).get(_NAME).asString();
	}

	@Override
	public XPair<String, ITypeAttributes> getType() {
		return new XPair<>(getName(), linkAttribs);
	}

	// TODO: 30.11.21 this is a bad interface.
	@Deprecated
	@Override
	public List<XPair<String, ITypeAttributes>> getTypes() {
		List<XPair<String, ITypeAttributes>> types = new ArrayList<>();
		types.add(getType());
		return types;
	}

	@Override
	public void setStyle(LinkStyle style) {
		linkStyle = style;
	}

	@Override
	public LinkStyle getStyle() {
		return linkStyle;
	}

	@Override
	public void setLink(String type, ILink link) {
		// Ignore type
		// this.links.add(link);
		addLink(link);
	}

	@Override
	public int getLevel() {

		return level;
	}

	@Override
	public int getMaxLevel() {

		return maxLevel;
	}

	@Override
	public void setMaxLevel(int max) {
		maxLevel = max;
	}

	@Override
	public IDragController getDragController() {
		return dragController;
	}

	@Override
	public void removeLink() {
		if(Platform.isFxApplicationThread())
			scheduleRemove();
		else
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					scheduleRemove();
				}
			});
	}

	protected void scheduleRemove() {
		if (linkPath != null && drawn) {
			//avoid changes from other threads during delete
			synchronized(this) {
				//TODO: debugging
				boolean success = linkPath.remove();
				if (success) {
					linkPath = null;
					drawn = false;
				}
			}
		}
	}

	@Override
	public void draw(Point2D startPoint, Point2D endPoint) {
		if (!drawn || linkPath == null) {
			linkPath = new LinkPath(this, menuItems);
			linkPath.draw(startPoint, endPoint, ()->{drawn = true;}); // TODO: 12.05.21 add CSS hierarchy attribute here
		}
	}

	@Override
	public int getLowerBound() {
		return lower;
	}

	@Override
	public int getHigherBound() {
		return higher;
	}

	@Override
	public int getCardinality() {
		if (cardinalType == null)
			return 0;
		
		return cardinalType.getCardinality();
	}

	@Override
	public Map<? extends String, ? extends Object> getIntermediate() {
		return intermediate;
	}

}