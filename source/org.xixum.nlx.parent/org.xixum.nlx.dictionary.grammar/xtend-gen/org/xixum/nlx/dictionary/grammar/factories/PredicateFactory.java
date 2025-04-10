package org.xixum.nlx.dictionary.grammar.factories;

import java.util.Objects;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.neo4j.driver.v1.types.Relationship;
import org.xixum.nlx.ai.IDbAccess;
import org.xixum.nlx.ai.IPredicateFactory;
import org.xixum.nlx.ai.semantics.INode;
import org.xixum.nlx.ai.semantics.IPredicate;
import org.xixum.nlx.dictionary.constants.PredicateConstants;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateDO;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateENDS_WITH;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateENTER_RULE;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateEQUALS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateEXTENDS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateFIND;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateGET;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateGET_NAME;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateIS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateLINK_TO;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateNEXT;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateOF;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateOF_CLASS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicatePREVIOUS;
import org.xixum.nlx.dictionary.grammar.nodes.interfaces.IPredicateTARGET;
import org.xixum.nlx.dictionary.grammar.predicates.Predicate;

@SuppressWarnings("all")
public class PredicateFactory implements IPredicateFactory {
  private IDbAccess dbAccessor;

  public PredicateFactory(final IDbAccess access) {
    this.dbAccessor = access;
  }

  @Override
  public IPredicate create(final RelationshipValue value, final INode nodeStart, final INode nodeEnd) {
    Predicate _xblockexpression = null;
    {
      Relationship rel = value.asRelationship();
      String typeName = rel.type().toLowerCase();
      Predicate _switchResult = null;
      boolean _matched = false;
      if (Objects.equals(typeName, PredicateConstants.LINK_INSTANCE_TO_)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.LINK_TO_)) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
          @Override
          public INode execute() {
            INode _xblockexpression = null;
            {
              final Function1<String, INode> _function = (String t) -> {
                return this.doLinkTo(t);
              };
              Function1<String, INode> delegate = _function;
              INode _xifexpression = null;
              if ((this.nodeEnd instanceof IPredicateLINK_TO)) {
                _xifexpression = ((IPredicateLINK_TO)this.nodeEnd).linkTo(this.nodeStart, this.relation, delegate);
              }
              _xblockexpression = _xifexpression;
            }
            return _xblockexpression;
          }
        };
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.IS_)) {
          _matched=true;
        }
        if (!_matched) {
          if (Objects.equals(typeName, PredicateConstants.INSTANCE_OF_)) {
            _matched=true;
          }
        }
        if (_matched) {
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateIS)) {
                return ((IPredicateIS)this.nodeEnd).is(this.nodeStart);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.TARGET_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateTARGET)) {
                return ((IPredicateTARGET)this.nodeEnd).target(this.nodeStart);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.EQUALS_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateEQUALS)) {
                return ((IPredicateEQUALS)this.nodeEnd).equals(this.nodeStart);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.NEXT_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateNEXT)) {
                return ((IPredicateNEXT)this.nodeEnd).next(this.nodeStart);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.PREVIOUS_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicatePREVIOUS)) {
                return ((IPredicatePREVIOUS)this.nodeEnd).previous(this.nodeStart);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.DO_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateDO)) {
                return ((IPredicateDO)this.nodeEnd).Do(this.nodeStart);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.ENTER_RULE_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateENTER_RULE)) {
                return ((IPredicateENTER_RULE)this.nodeEnd).enterRule(this.nodeStart);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.EXTENDS_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateEXTENDS)) {
                return ((IPredicateEXTENDS)this.nodeEnd).Extends(this.nodeStart);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.GET_TARGET_)) {
          _matched=true;
        }
        if (!_matched) {
          if (Objects.equals(typeName, PredicateConstants.GET_SOURCE_)) {
            _matched=true;
          }
        }
        if (_matched) {
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateGET)) {
                return ((IPredicateGET)this.nodeEnd).get(this.nodeStart, this.relation);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.ENDS_WITH_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateENDS_WITH)) {
                return ((IPredicateENDS_WITH)this.nodeEnd).endsWith(this.nodeStart);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.OF_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateOF)) {
                return ((IPredicateOF)this.nodeEnd).of(this.nodeStart, this.relation);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.GET_NAME_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateGET_NAME)) {
                return ((IPredicateGET_NAME)this.nodeEnd).getName(this.nodeStart, this.relation);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.FIND_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateFIND)) {
                return ((IPredicateFIND)this.nodeEnd).find(this.nodeStart, this.relation);
              }
              return null;
            }
          };
        }
      }
      if (!_matched) {
        if (Objects.equals(typeName, PredicateConstants.OF_CLASS_)) {
          _matched=true;
          _switchResult = new Predicate(rel, nodeStart, nodeEnd, this.dbAccessor, typeName) {
            @Override
            public INode execute() {
              if ((this.nodeEnd instanceof IPredicateOF_CLASS)) {
                return ((IPredicateOF_CLASS)this.nodeEnd).ofClass(this.nodeStart, this.relation);
              }
              return null;
            }
          };
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
