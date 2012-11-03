package org.agda.parser;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;


public interface AgdaTokenTypes {
  IElementType WHITE_SPACE = TokenType.WHITE_SPACE;
  IElementType LINE_END = new AgdaElementType("NEW_LINE");
  IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;

  IElementType END_OF_LINE_COMMENT = new AgdaElementType("END_OF_LINE_COMMENT");
  IElementType VALUE_CHARACTERS = new AgdaElementType("VALUE_CHARACTERS");
  IElementType SPEC_CHARACTERS = new AgdaElementType("SPEC_CHARACTERS");
  IElementType KEYWORD = new AgdaElementType("KEYWORD");

  IElementType L_PAREN = new AgdaElementType("L_PAREN");
  IElementType R_PAREN = new AgdaElementType("R_PAREN");

  IElementType L_CURLY = new AgdaElementType("L_CURLY");
  IElementType R_CURLY = new AgdaElementType("R_CURLY");


  TokenSet COMMENTS = TokenSet.create(END_OF_LINE_COMMENT);
  TokenSet WHITESPACES = TokenSet.create(WHITE_SPACE, LINE_END);


}