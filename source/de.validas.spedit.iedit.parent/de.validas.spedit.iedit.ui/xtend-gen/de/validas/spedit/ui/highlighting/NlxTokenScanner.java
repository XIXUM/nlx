package de.validas.spedit.ui.highlighting;

import com.google.inject.Inject;
import de.validas.spedit.ui.highlighting.NlxTokenToAttributeMapper;
import javax.annotation.Generated;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.TokenScanner;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class NlxTokenScanner extends TokenScanner {
  @Inject
  private NlxTokenToAttributeMapper tokenIdMapper;
  
  @Override
  public void setTokenIdMapper(final AbstractAntlrTokenToAttributeIdMapper tokenIdMapper) {
    this.setTokenIdMapper(tokenIdMapper);
  }
  
  @Override
  public IToken createToken(final ILexerTokenRegion currentToken) {
    String id = this.tokenIdMapper.getId(currentToken.getLexerTokenType());
    TextAttribute _attribute = this.getAttribute(id);
    Token token = new Token(_attribute);
    return token;
  }
  
  @Override
  public AbstractAntlrTokenToAttributeIdMapper getTokenIdMapper() {
    return this.tokenIdMapper;
  }
}
