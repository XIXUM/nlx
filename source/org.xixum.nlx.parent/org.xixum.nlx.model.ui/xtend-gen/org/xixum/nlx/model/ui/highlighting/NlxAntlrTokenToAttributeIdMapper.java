package org.xixum.nlx.model.ui.highlighting;

import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

@SuppressWarnings("all")
public class NlxAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {
  @Override
  protected String calculateId(final String tokenName, final int tokenType) {
    String _switchResult = null;
    if (tokenName != null) {
      switch (tokenName) {
        case "(":
        case ")":
        case "RULE_KOMMA":
          _switchResult = NaturalLangHighlightingStyles.KOMMA;
          break;
        case "RULE_FULL_STOP":
          _switchResult = NaturalLangHighlightingStyles.FULL_STOP;
          break;
        case "RULE_IT_ID":
          _switchResult = NaturalLangHighlightingStyles.ITWORD;
          break;
        case "RULE_ANY_OTHER":
        case "RULE_IGNORED":
          _switchResult = NaturalLangHighlightingStyles.IGNORED;
          break;
        case "RULE_MAIL":
          _switchResult = NaturalLangHighlightingStyles.EMAIL;
          break;
        case "RULE_URL":
          _switchResult = NaturalLangHighlightingStyles.URL;
          break;
        case "RULE_LIST_POINT":
          _switchResult = NaturalLangHighlightingStyles.LIST_POINT;
          break;
        case "RULE_DOUBLE":
        case "RULE_DOUBLE_EN":
        case "RULE_DOUBLE_DE":
          _switchResult = NaturalLangHighlightingStyles.DOUBLE;
          break;
        case "RULE_SYMBOLS":
        case "RULE_SMILEY":
        case "RULE_ARROW":
          _switchResult = NaturalLangHighlightingStyles.SYMBOLS;
          break;
        default:
          _switchResult = super.calculateId(tokenName, tokenType);
          break;
      }
    } else {
      _switchResult = super.calculateId(tokenName, tokenType);
    }
    return _switchResult;
  }
}
