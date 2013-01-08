/* The following code was generated by JFlex 1.4.3 on 03.01.13 23:42 */

package org.jetbrains.agda.parser;

import java.util.*;
import com.intellij.lexer.*;
import com.intellij.psi.*;
import org.jetbrains.agda.gen.parser.AgdaTokenTypes;
import com.intellij.psi.tree.IElementType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 03.01.13 23:42 from the specification file
 * <tt>C:/Users/Atsky/Dropbox/agda-plugin/src/org/jetbrains/agda/parser/Agda.flex</tt>
 */
class _AgdaLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int BLOCK_COMMENT = 4;
  public static final int YYINITIAL = 0;
  public static final int INDENT = 6;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3, 3
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\2\1\3\1\0\1\2\23\0\1\2\2\0\1\45\4\0"+
    "\1\11\1\12\3\0\1\4\1\5\1\16\12\1\1\13\1\14\1\0"+
    "\1\15\1\17\35\0\1\6\4\0\1\27\1\43\1\37\1\26\1\22"+
    "\1\41\1\44\1\31\1\24\2\0\1\21\1\33\1\25\1\34\1\36"+
    "\1\0\1\32\1\40\1\23\1\35\1\0\1\30\1\42\2\0\1\10"+
    "\1\0\1\7\u05e2\0\12\0\206\0\12\0\u026c\0\12\0\166\0\12\0"+
    "\166\0\12\0\166\0\12\0\166\0\12\0\167\0\11\0\166\0\12\0"+
    "\166\0\12\0\166\0\12\0\340\0\12\0\166\0\12\0\106\0\12\0"+
    "\u0116\0\12\0\u031f\0\11\0\u046e\0\12\0\46\0\12\0\u012c\0\12\0"+
    "\u0842\0\1\20\155\0\1\46\udd0f\0\12\0\346\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\1\1\1\2\1\3\1\4\1\1\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\15\1\1\17\1\20\1\0\1\21\1\22\1\23\1\0"+
    "\1\24\1\1\1\0\1\1\1\25\16\1\1\26\1\27"+
    "\1\30\1\31\16\1\1\32\2\1\1\33\4\1\1\34"+
    "\6\1\1\35\1\1\1\36\3\1\1\37\3\1\1\40"+
    "\1\1\1\41\1\42\1\43\1\44\1\45\1\46\1\1"+
    "\1\47\5\1\1\50\2\1\1\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[120];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\47\0\116\0\165\0\234\0\303\0\352\0\u0111"+
    "\0\u0138\0\47\0\u015f\0\47\0\u0186\0\47\0\47\0\234"+
    "\0\47\0\234\0\234\0\u01ad\0\u01d4\0\u01fb\0\u0222\0\u0249"+
    "\0\u0270\0\u0297\0\u02be\0\u02e5\0\u030c\0\u0333\0\u035a\0\u0381"+
    "\0\234\0\47\0\u03a8\0\165\0\u03cf\0\47\0\u0111\0\u03f6"+
    "\0\47\0\u041d\0\u0444\0\u046b\0\u0492\0\u04b9\0\u04e0\0\u0507"+
    "\0\u052e\0\u0555\0\u057c\0\u05a3\0\u05ca\0\u05f1\0\u0618\0\u063f"+
    "\0\u0666\0\u068d\0\47\0\47\0\47\0\234\0\u06b4\0\u06db"+
    "\0\u0702\0\u0729\0\u0750\0\u0777\0\u079e\0\u07c5\0\u07ec\0\u0813"+
    "\0\u083a\0\u0861\0\u0888\0\u08af\0\47\0\u08d6\0\u08fd\0\234"+
    "\0\u0924\0\u094b\0\u0972\0\u0999\0\234\0\u09c0\0\u09e7\0\u0a0e"+
    "\0\u0a35\0\u0a5c\0\u0a83\0\u0aaa\0\u0ad1\0\234\0\u0af8\0\u0b1f"+
    "\0\u0b46\0\234\0\u0b6d\0\u0b94\0\u0bbb\0\234\0\u0be2\0\234"+
    "\0\234\0\234\0\234\0\234\0\234\0\u0c09\0\234\0\u0c30"+
    "\0\u0c57\0\u0c7e\0\u0ca5\0\u0ccc\0\234\0\u0cf3\0\u0d1a\0\234";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[120];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\2\5\1\23"+
    "\1\24\2\5\1\25\1\5\1\26\1\5\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\5\1\37"+
    "\3\5\1\40\1\41\47\0\4\42\1\43\42\42\2\0"+
    "\1\44\1\45\43\0\2\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\32\5\1\0\1\6\47\0\1\7"+
    "\44\0\2\46\1\47\44\46\2\5\2\0\1\50\1\0"+
    "\1\5\4\0\1\5\1\0\2\5\1\23\27\5\16\0"+
    "\1\51\34\0\1\52\42\0\2\5\2\0\1\5\1\0"+
    "\1\5\4\0\1\5\1\0\5\5\1\53\26\5\2\0"+
    "\1\5\1\0\1\5\4\0\1\5\1\0\10\5\1\54"+
    "\5\5\1\55\15\5\2\0\1\5\1\0\1\5\4\0"+
    "\1\5\1\0\12\5\1\56\21\5\2\0\1\5\1\0"+
    "\1\5\4\0\1\5\1\0\14\5\1\57\17\5\2\0"+
    "\1\5\1\0\1\5\4\0\1\5\1\0\7\5\1\60"+
    "\24\5\2\0\1\5\1\0\1\5\4\0\1\5\1\0"+
    "\5\5\1\61\26\5\2\0\1\5\1\0\1\5\4\0"+
    "\1\5\1\0\17\5\1\62\14\5\2\0\1\5\1\0"+
    "\1\5\4\0\1\5\1\0\21\5\1\63\12\5\2\0"+
    "\1\5\1\0\1\5\4\0\1\5\1\0\23\5\1\64"+
    "\10\5\2\0\1\5\1\0\1\5\4\0\1\5\1\0"+
    "\17\5\1\65\1\66\13\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\17\5\1\67\14\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\7\5\1\70\7\5"+
    "\1\71\14\5\2\0\1\72\1\0\1\5\4\0\1\5"+
    "\1\0\32\5\7\42\1\73\37\42\2\0\2\45\43\0"+
    "\3\50\1\0\43\50\45\74\1\75\1\74\2\5\2\0"+
    "\1\5\1\0\1\5\4\0\1\5\1\0\6\5\1\76"+
    "\25\5\2\0\1\5\1\0\1\5\4\0\1\5\1\0"+
    "\24\5\1\77\7\5\2\0\1\5\1\0\1\5\4\0"+
    "\1\5\1\0\21\5\1\100\12\5\2\0\1\5\1\0"+
    "\1\5\4\0\1\5\1\0\6\5\1\101\25\5\2\0"+
    "\1\5\1\0\1\5\4\0\1\5\1\0\5\5\1\102"+
    "\26\5\2\0\1\5\1\0\1\5\4\0\1\5\1\0"+
    "\11\5\1\103\22\5\2\0\1\5\1\0\1\5\4\0"+
    "\1\5\1\0\22\5\1\104\11\5\2\0\1\5\1\0"+
    "\1\5\4\0\1\5\1\0\11\5\1\105\22\5\2\0"+
    "\1\5\1\0\1\5\4\0\1\5\1\0\5\5\1\106"+
    "\26\5\2\0\1\5\1\0\1\5\4\0\1\5\1\0"+
    "\7\5\1\107\24\5\2\0\1\5\1\0\1\5\4\0"+
    "\1\5\1\0\23\5\1\110\10\5\2\0\1\5\1\0"+
    "\1\5\4\0\1\5\1\0\26\5\1\111\5\5\2\0"+
    "\1\5\1\0\1\5\4\0\1\5\1\0\10\5\1\112"+
    "\23\5\2\0\1\5\1\0\1\5\4\0\1\5\1\0"+
    "\5\5\1\113\26\5\2\0\1\5\1\0\1\5\4\0"+
    "\1\5\1\0\15\5\1\114\16\5\2\0\1\5\1\0"+
    "\1\5\1\115\3\0\1\5\1\0\34\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\7\5\1\116\24\5"+
    "\2\0\1\5\1\0\1\5\4\0\1\5\1\0\17\5"+
    "\1\117\14\5\2\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\0\12\5\1\120\21\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\15\5\1\121\16\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\7\5\1\122\24\5"+
    "\2\0\1\5\1\0\1\5\4\0\1\5\1\0\17\5"+
    "\1\123\14\5\2\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\0\20\5\1\124\13\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\10\5\1\125\23\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\10\5\1\126\23\5"+
    "\2\0\1\5\1\0\1\5\4\0\1\5\1\0\6\5"+
    "\1\127\25\5\2\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\0\4\5\1\130\27\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\23\5\1\131\10\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\4\5\1\132\27\5"+
    "\2\0\1\5\1\0\1\5\4\0\1\5\1\0\12\5"+
    "\1\133\21\5\2\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\0\25\5\1\134\6\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\15\5\1\135\16\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\5\5\1\136\26\5"+
    "\2\0\1\5\1\0\1\5\4\0\1\5\1\0\10\5"+
    "\1\137\23\5\2\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\0\15\5\1\140\16\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\4\5\1\141\27\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\27\5\1\142\4\5"+
    "\2\0\1\5\1\0\1\5\4\0\1\5\1\0\20\5"+
    "\1\143\13\5\2\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\0\7\5\1\144\24\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\6\5\1\145\25\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\11\5\1\146\22\5"+
    "\2\0\1\5\1\0\1\5\4\0\1\5\1\0\4\5"+
    "\1\147\27\5\2\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\0\4\5\1\150\10\5\1\151\16\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\6\5\1\152\25\5"+
    "\2\0\1\5\1\0\1\5\4\0\1\5\1\0\27\5"+
    "\1\153\4\5\2\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\0\11\5\1\154\22\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\5\5\1\155\26\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\4\5\1\156\27\5"+
    "\2\0\1\5\1\0\1\5\4\0\1\5\1\0\22\5"+
    "\1\157\11\5\2\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\0\15\5\1\160\16\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\4\5\1\41\27\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\12\5\1\161\21\5"+
    "\2\0\1\5\1\0\1\5\4\0\1\5\1\0\20\5"+
    "\1\162\13\5\2\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\0\6\5\1\163\25\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\22\5\1\164\11\5\2\0\1\5"+
    "\1\0\1\5\4\0\1\5\1\0\5\5\1\165\26\5"+
    "\2\0\1\5\1\0\1\5\4\0\1\5\1\0\6\5"+
    "\1\166\25\5\2\0\1\5\1\0\1\5\4\0\1\5"+
    "\1\0\17\5\1\167\14\5\2\0\1\5\1\0\1\5"+
    "\4\0\1\5\1\0\15\5\1\170\14\5";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3393];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\10\2\0\5\1\1\11\1\1\1\11\1\1"+
    "\2\11\1\1\1\11\20\1\1\11\1\0\2\1\1\11"+
    "\1\0\1\1\1\11\1\0\20\1\3\11\17\1\1\11"+
    "\53\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[120];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private LinkedList<Integer> prevIndentSize = new LinkedList<Integer>(Collections.singleton(0));


  _AgdaLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  _AgdaLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 194) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
      return;

    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL.charAt(zzCurrentPosL++);
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 20: 
          { return AgdaTokenTypes.END_OF_LINE_COMMENT;
          }
        case 42: break;
        case 38: 
          { return AgdaTokenTypes.MODULE_KEYWORD;
          }
        case 43: break;
        case 6: 
          { return AgdaTokenTypes.LAMBDA;
          }
        case 44: break;
        case 35: 
          { return AgdaTokenTypes.IMPORT_KEYWORD;
          }
        case 45: break;
        case 21: 
          { return AgdaTokenTypes.IN_KEYWORD;
          }
        case 46: break;
        case 19: 
          { yybegin(YYINITIAL);
        CharSequence yytext = yytext();
        int indentSize = yytext.length() - 2;
        yypushback(1);
        if (yytext.charAt(yytext.length() - 1) == '\n') {
            return TokenType.WHITE_SPACE;
        }

        if (indentSize > prevIndentSize.getLast()) {
          return TokenType.WHITE_SPACE;
        } else if (indentSize < prevIndentSize.getLast()) {
          prevIndentSize.removeLast();
          yypushback(yytext.length() - 1);
          return AgdaTokenTypes.VIRTUAL_RIGHT_PAREN;
        } else {
          return AgdaTokenTypes.VIRTUAL_SEMICOLON;
        }
          }
        case 47: break;
        case 41: 
          { yybegin(INDENT);
                        return AgdaTokenTypes.CONSTRUCTOR_KEYWORD;
          }
        case 48: break;
        case 3: 
          { return TokenType.WHITE_SPACE;
          }
        case 49: break;
        case 11: 
          { return AgdaTokenTypes.COLON;
          }
        case 50: break;
        case 12: 
          { return AgdaTokenTypes.SEMICOLON;
          }
        case 51: break;
        case 24: 
          { return AgdaTokenTypes.PRAGMA_OPEN;
          }
        case 52: break;
        case 39: 
          { return AgdaTokenTypes.PUBLIC_KEYWORD;
          }
        case 53: break;
        case 37: 
          { return AgdaTokenTypes.RECORD_KEYWORD;
          }
        case 54: break;
        case 29: 
          { return AgdaTokenTypes.INFIX_KEYWORD;
          }
        case 55: break;
        case 28: 
          { return AgdaTokenTypes.OPEN_KEYWORD;
          }
        case 56: break;
        case 36: 
          { return AgdaTokenTypes.HIDING_KEYWORD;
          }
        case 57: break;
        case 32: 
          { yybegin(INDENT);
                        return AgdaTokenTypes.FIELD_KEYWORD;
          }
        case 58: break;
        case 27: 
          { return AgdaTokenTypes.DATA_KEYWORD;
          }
        case 59: break;
        case 9: 
          { return AgdaTokenTypes.LEFT_PAREN;
          }
        case 60: break;
        case 1: 
          { return AgdaTokenTypes.ID;
          }
        case 61: break;
        case 25: 
          { return AgdaTokenTypes.LET_KEYWORD;
          }
        case 62: break;
        case 40: 
          { yybegin(INDENT);
                        return AgdaTokenTypes.POSTULATE_KEYWORD;
          }
        case 63: break;
        case 33: 
          { return AgdaTokenTypes.INFIXL_KEYWORD;
          }
        case 64: break;
        case 13: 
          { return AgdaTokenTypes.ASSIGNMENT;
          }
        case 65: break;
        case 17: 
          { yybegin(YYINITIAL);
     return TokenType.WHITE_SPACE;
          }
        case 66: break;
        case 10: 
          { return AgdaTokenTypes.RIGHT_PAREN;
          }
        case 67: break;
        case 2: 
          { return AgdaTokenTypes.NUMBER;
          }
        case 68: break;
        case 4: 
          { return AgdaTokenTypes.VIRTUAL_RIGHT_PAREN;
          }
        case 69: break;
        case 34: 
          { return AgdaTokenTypes.INFIXR_KEYWORD;
          }
        case 70: break;
        case 8: 
          { return AgdaTokenTypes.LEFT_BRACE;
          }
        case 71: break;
        case 26: 
          { return AgdaTokenTypes.PRAGMA_CLOSE;
          }
        case 72: break;
        case 23: 
          { yybegin(BLOCK_COMMENT); return AgdaTokenTypes.COMMENT;
          }
        case 73: break;
        case 16: 
          { return AgdaTokenTypes.COMMENT;
          }
        case 74: break;
        case 5: 
          { return AgdaTokenTypes.DOT;
          }
        case 75: break;
        case 31: 
          { return AgdaTokenTypes.USING_KEYWORD;
          }
        case 76: break;
        case 14: 
          { return AgdaTokenTypes.ARROW;
          }
        case 77: break;
        case 7: 
          { return AgdaTokenTypes.RIGHT_BRACE;
          }
        case 78: break;
        case 18: 
          { yybegin(YYINITIAL);
     CharSequence yytext = yytext();
     int indentSize = yytext.length() - yytext.toString().lastIndexOf("\n") - 1;
     if (prevIndentSize.getLast() < indentSize) {
        prevIndentSize.addLast(indentSize);
        return AgdaTokenTypes.VIRTUAL_LEFT_PAREN;
     } else if (prevIndentSize.getLast() == indentSize) {
        return AgdaTokenTypes.VIRTUAL_SEMICOLON;
     } else {
        return TokenType.WHITE_SPACE;
     }
          }
        case 79: break;
        case 30: 
          { yybegin(INDENT);
                        return AgdaTokenTypes.WHERE_KEYWORD;
          }
        case 80: break;
        case 15: 
          { return AgdaTokenTypes.FORALL;
          }
        case 81: break;
        case 22: 
          { yybegin(YYINITIAL); return AgdaTokenTypes.COMMENT;
          }
        case 82: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
