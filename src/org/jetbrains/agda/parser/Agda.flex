package org.jetbrains.agda.parser;

import java.util.*;
import com.intellij.lexer.*;
import com.intellij.psi.*;
import org.jetbrains.agda.gen.parser.AgdaTokenTypes;
import com.intellij.psi.tree.IElementType;

%%

%unicode
%class _AgdaLexer
%implements FlexLexer

%{

%}


%function advance
%type IElementType
%eof{
  return;
%eof}

%xstate STRING, BLOCK_COMMENT

DIGIT=[0-9]
WHITE_SPACE_CHAR=[\ \t\f]
INDENT=[\n] {WHITE_SPACE_CHAR}*
EOL_COMMENT="--"[^\n]*
LETTER = [^0-9{}().\ \n\t\f;\\]
IDENTIFIER_PART=[:digit:]|{LETTER}|[\\]
IDENTIFIER={LETTER} {IDENTIFIER_PART}*

%%

<BLOCK_COMMENT>([^-]|"-"[^}])+ {return AgdaTokenTypes.COMMENT;}
<BLOCK_COMMENT>("-}") {  yybegin(YYINITIAL); return AgdaTokenTypes.COMMENT; }


({WHITE_SPACE_CHAR})+ { return TokenType.WHITE_SPACE; }
{INDENT}              { return TokenType.NEW_LINE_INDENT; }
{EOL_COMMENT}         { return AgdaTokenTypes.END_OF_LINE_COMMENT; }
"{"                   { return AgdaTokenTypes.LEFT_BRACE; }
"}"                   { return AgdaTokenTypes.RIGHT_BRACE; }
"("                   { return AgdaTokenTypes.LEFT_PAREN; }
")"                   { return AgdaTokenTypes.RIGHT_PAREN; }
":"                   { return AgdaTokenTypes.COLON;}
";"                   { return AgdaTokenTypes.SEMICOLON;}
"."                   { return AgdaTokenTypes.DOT; }
"="                   { return AgdaTokenTypes.ASSIGNMENT; }
"\\/"                 { return AgdaTokenTypes.ID; } // Hack
"\\"                  { return AgdaTokenTypes.LAMBDA; }
(->)|(\u2192)         { return AgdaTokenTypes.ARROW; }
"let"                 { return AgdaTokenTypes.LET_KEYWORD; }
"in"                  { return AgdaTokenTypes.IN_KEYWORD; }
"data"                { return AgdaTokenTypes.DATA_KEYWORD; }
"where"               { return AgdaTokenTypes.WHERE_KEYWORD; }
"module"              { return AgdaTokenTypes.MODULE_KEYWORD; }
"open"                { return AgdaTokenTypes.OPEN_KEYWORD; }
"import"              { return AgdaTokenTypes.IMPORT_KEYWORD; }
"record"              { return AgdaTokenTypes.RECORD_KEYWORD; }
"postulate"           { return AgdaTokenTypes.POSTULATE_KEYWORD; }
"mutual"              { return AgdaTokenTypes.MUTUAL_KEYWORD; }
"infix"               { return AgdaTokenTypes.INFIX_KEYWORD; }
"infixl"              { return AgdaTokenTypes.INFIXL_KEYWORD; }
"infixr"              { return AgdaTokenTypes.INFIXR_KEYWORD; }
"constructor"         { return AgdaTokenTypes.CONSTRUCTOR_KEYWORD; }
"field"               { return AgdaTokenTypes.FIELD_KEYWORD; }
"public"              { return AgdaTokenTypes.PUBLIC_KEYWORD; }
"using"               { return AgdaTokenTypes.USING_KEYWORD; }
"hiding"              { return AgdaTokenTypes.HIDING_KEYWORD; }
"{-#"                 { return AgdaTokenTypes.PRAGMA_OPEN; }
"#-}"                 { return AgdaTokenTypes.PRAGMA_CLOSE; }
"{-"[^#]              { yybegin(BLOCK_COMMENT); return AgdaTokenTypes.COMMENT; }
({DIGIT})+            { return AgdaTokenTypes.NUMBER; }
(forall)|(\u2200)     { return AgdaTokenTypes.FORALL; }


{IDENTIFIER}          { return AgdaTokenTypes.ID; }
.                     { return TokenType.BAD_CHARACTER; }