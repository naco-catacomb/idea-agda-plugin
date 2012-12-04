// This is a generated file. Not intended for manual editing.
package org.jetbrains.agda.gen.parser;

import org.jetbrains.annotations.*;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static org.jetbrains.agda.gen.parser.AgdaTokenTypes.*;
import static org.jetbrains.agda.parser.AgdaParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class AgdaParser implements PsiParser {

  public static Logger LOG_ = Logger.getInstance("org.jetbrains.agda.gen.parser.AgdaParser");

  @NotNull
  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    int level_ = 0;
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this);
    if (root_ == A_NAME) {
      result_ = a_name(builder_, level_ + 1);
    }
    else if (root_ == APPLICATION) {
      result_ = application(builder_, level_ + 1);
    }
    else if (root_ == BINDING) {
      result_ = binding(builder_, level_ + 1);
    }
    else if (root_ == CONSTRUCTORS) {
      result_ = constructors(builder_, level_ + 1);
    }
    else if (root_ == DATA_DECLARATION) {
      result_ = data_declaration(builder_, level_ + 1);
    }
    else if (root_ == EXPRESSION) {
      result_ = expression(builder_, level_ + 1);
    }
    else if (root_ == FQ_NAME) {
      result_ = fqName(builder_, level_ + 1);
    }
    else if (root_ == FUNCTION_DECLARATION) {
      result_ = function_declaration(builder_, level_ + 1);
    }
    else if (root_ == FUNCTION_TYPE) {
      result_ = function_type(builder_, level_ + 1);
    }
    else if (root_ == FUNCTION_TYPE_DECLARATION) {
      result_ = function_type_declaration(builder_, level_ + 1);
    }
    else if (root_ == IDS) {
      result_ = ids(builder_, level_ + 1);
    }
    else if (root_ == LAMBDA_EXPRESSION) {
      result_ = lambda_expression(builder_, level_ + 1);
    }
    else if (root_ == MODULE_DECLARATION) {
      result_ = module_declaration(builder_, level_ + 1);
    }
    else if (root_ == MODULE_IMPORT) {
      result_ = module_import(builder_, level_ + 1);
    }
    else if (root_ == NEW_LINE) {
      result_ = new_line(builder_, level_ + 1);
    }
    else if (root_ == RENAMING) {
      result_ = renaming(builder_, level_ + 1);
    }
    else if (root_ == TELE_ARROW) {
      result_ = tele_arrow(builder_, level_ + 1);
    }
    else if (root_ == TELESCOPE) {
      result_ = telescope(builder_, level_ + 1);
    }
    else if (root_ == TYPE_SIGNATURE) {
      result_ = type_signature(builder_, level_ + 1);
    }
    else if (root_ == USING_OR_HIDING) {
      result_ = using_or_hiding(builder_, level_ + 1);
    }
    else {
      Marker marker_ = builder_.mark();
      result_ = parse_root_(root_, builder_, level_);
      while (builder_.getTokenType() != null) {
        builder_.advanceLexer();
      }
      marker_.done(root_);
    }
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return root(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // id
  public static boolean a_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "a_name")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, ID);
    if (result_) {
      marker_.done(A_NAME);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // (atom_expr maybe_application)
  public static boolean application(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "application")) return false;
    return application_0(builder_, level_ + 1);
  }

  // atom_expr maybe_application
  private static boolean application_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "application_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<application>");
    result_ = atom_expr(builder_, level_ + 1);
    result_ = result_ && maybe_application(builder_, level_ + 1);
    if (result_) {
      marker_.done(APPLICATION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // "as" id
  static boolean as_name(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "as_name")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, "as");
    result_ = result_ && consumeToken(builder_, ID);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // ("(" expression ")") | ("(" ")") | "{" "!!" "}" | "." | a_name
  static boolean atom_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "atom_expr")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = atom_expr_0(builder_, level_ + 1);
    if (!result_) result_ = atom_expr_1(builder_, level_ + 1);
    if (!result_) result_ = atom_expr_2(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, DOT);
    if (!result_) result_ = a_name(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // ("(" expression ")")
  private static boolean atom_expr_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "atom_expr_0")) return false;
    return atom_expr_0_0(builder_, level_ + 1);
  }

  // "(" expression ")"
  private static boolean atom_expr_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "atom_expr_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_PAREN);
    result_ = result_ && expression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // ("(" ")")
  private static boolean atom_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "atom_expr_1")) return false;
    return atom_expr_1_0(builder_, level_ + 1);
  }

  // "(" ")"
  private static boolean atom_expr_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "atom_expr_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_PAREN);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // "{" "!!" "}"
  private static boolean atom_expr_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "atom_expr_2")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_BRACE);
    result_ = result_ && consumeToken(builder_, "!!");
    result_ = result_ && consumeToken(builder_, RIGHT_BRACE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // (new_line "{" ids (":" expression)? "}") | (new_line "(" ids (":" expression)? ")")
  public static boolean binding(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binding")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<binding>");
    result_ = binding_0(builder_, level_ + 1);
    if (!result_) result_ = binding_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(BINDING);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // (new_line "{" ids (":" expression)? "}")
  private static boolean binding_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binding_0")) return false;
    return binding_0_0(builder_, level_ + 1);
  }

  // new_line "{" ids (":" expression)? "}"
  private static boolean binding_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binding_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = new_line(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LEFT_BRACE);
    result_ = result_ && ids(builder_, level_ + 1);
    result_ = result_ && binding_0_0_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_BRACE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (":" expression)?
  private static boolean binding_0_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binding_0_0_3")) return false;
    binding_0_0_3_0(builder_, level_ + 1);
    return true;
  }

  // (":" expression)
  private static boolean binding_0_0_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binding_0_0_3_0")) return false;
    return binding_0_0_3_0_0(builder_, level_ + 1);
  }

  // ":" expression
  private static boolean binding_0_0_3_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binding_0_0_3_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COLON);
    result_ = result_ && expression(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (new_line "(" ids (":" expression)? ")")
  private static boolean binding_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binding_1")) return false;
    return binding_1_0(builder_, level_ + 1);
  }

  // new_line "(" ids (":" expression)? ")"
  private static boolean binding_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binding_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = new_line(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LEFT_PAREN);
    result_ = result_ && ids(builder_, level_ + 1);
    result_ = result_ && binding_1_0_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (":" expression)?
  private static boolean binding_1_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binding_1_0_3")) return false;
    binding_1_0_3_0(builder_, level_ + 1);
    return true;
  }

  // (":" expression)
  private static boolean binding_1_0_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binding_1_0_3_0")) return false;
    return binding_1_0_3_0_0(builder_, level_ + 1);
  }

  // ":" expression
  private static boolean binding_1_0_3_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binding_1_0_3_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COLON);
    result_ = result_ && expression(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // binding *
  static boolean bindings(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "bindings")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!binding(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "bindings");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // type_signature (VIRTUAL_SEMICOLON type_signature) *
  public static boolean constructors(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "constructors")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = type_signature(builder_, level_ + 1);
    result_ = result_ && constructors_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(CONSTRUCTORS);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // (VIRTUAL_SEMICOLON type_signature) *
  private static boolean constructors_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "constructors_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!constructors_1_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "constructors_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // (VIRTUAL_SEMICOLON type_signature)
  private static boolean constructors_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "constructors_1_0")) return false;
    return constructors_1_0_0(builder_, level_ + 1);
  }

  // VIRTUAL_SEMICOLON type_signature
  private static boolean constructors_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "constructors_1_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, VIRTUAL_SEMICOLON);
    result_ = result_ && type_signature(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // "data" id bindings ":" expression "where" (VIRTUAL_LEFT_PAREN constructors VIRTUAL_RIGHT_PAREN) ?
  public static boolean data_declaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_declaration")) return false;
    if (!nextTokenIs(builder_, DATA_KEYWORD)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, DATA_KEYWORD);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, ID));
    result_ = pinned_ && report_error_(builder_, bindings(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, COLON)) && result_;
    result_ = pinned_ && report_error_(builder_, expression(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, WHERE_KEYWORD)) && result_;
    result_ = pinned_ && data_declaration_6(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(DATA_DECLARATION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // (VIRTUAL_LEFT_PAREN constructors VIRTUAL_RIGHT_PAREN) ?
  private static boolean data_declaration_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_declaration_6")) return false;
    data_declaration_6_0(builder_, level_ + 1);
    return true;
  }

  // (VIRTUAL_LEFT_PAREN constructors VIRTUAL_RIGHT_PAREN)
  private static boolean data_declaration_6_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_declaration_6_0")) return false;
    return data_declaration_6_0_0(builder_, level_ + 1);
  }

  // VIRTUAL_LEFT_PAREN constructors VIRTUAL_RIGHT_PAREN
  private static boolean data_declaration_6_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "data_declaration_6_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, VIRTUAL_LEFT_PAREN);
    result_ = result_ && constructors(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, VIRTUAL_RIGHT_PAREN);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // module_declaration | module_import | data_declaration |
  //       function_type_declaration | function_declaration | expression | VIRTUAL_SEMICOLON | VIRTUAL_RIGHT_PAREN
  static boolean declaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "declaration")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = module_declaration(builder_, level_ + 1);
    if (!result_) result_ = module_import(builder_, level_ + 1);
    if (!result_) result_ = data_declaration(builder_, level_ + 1);
    if (!result_) result_ = function_type_declaration(builder_, level_ + 1);
    if (!result_) result_ = function_declaration(builder_, level_ + 1);
    if (!result_) result_ = expression(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, VIRTUAL_SEMICOLON);
    if (!result_) result_ = consumeToken(builder_, VIRTUAL_RIGHT_PAREN);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // tele_arrow | lambda_expression | maybe_function_type
  public static boolean expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expression")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expression>");
    result_ = tele_arrow(builder_, level_ + 1);
    if (!result_) result_ = lambda_expression(builder_, level_ + 1);
    if (!result_) result_ = maybe_function_type(builder_, level_ + 1);
    if (result_) {
      marker_.done(EXPRESSION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // id ('.' id) *
  public static boolean fqName(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fqName")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, ID);
    result_ = result_ && fqName_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(FQ_NAME);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // ('.' id) *
  private static boolean fqName_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fqName_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!fqName_1_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "fqName_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // ('.' id)
  private static boolean fqName_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fqName_1_0")) return false;
    return fqName_1_0_0(builder_, level_ + 1);
  }

  // '.' id
  private static boolean fqName_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "fqName_1_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && consumeToken(builder_, ID);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // expression "=" expression
  public static boolean function_declaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_declaration")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<function declaration>");
    result_ = expression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ASSIGNMENT);
    pinned_ = result_; // pin = 2
    result_ = result_ && expression(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(FUNCTION_DECLARATION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // maybe_application ARROW maybe_function_type
  public static boolean function_type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_type")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<function type>");
    result_ = maybe_application(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ARROW);
    result_ = result_ && maybe_function_type(builder_, level_ + 1);
    if (result_) {
      marker_.done(FUNCTION_TYPE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // id ":" expression
  public static boolean function_type_declaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_type_declaration")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, ID);
    result_ = result_ && consumeToken(builder_, COLON);
    pinned_ = result_; // pin = 2
    result_ = result_ && expression(builder_, level_ + 1);
    if (result_ || pinned_) {
      marker_.done(FUNCTION_TYPE_DECLARATION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // id+
  public static boolean ids(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ids")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, ID);
    int offset_ = builder_.getCurrentOffset();
    while (result_) {
      if (!consumeToken(builder_, ID)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "ids");
        break;
      }
      offset_ = next_offset_;
    }
    if (result_) {
      marker_.done(IDS);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // fqName (';' fqName) *
  static boolean import_names(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_names")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = fqName(builder_, level_ + 1);
    result_ = result_ && import_names_1(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (';' fqName) *
  private static boolean import_names_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_names_1")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!import_names_1_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "import_names_1");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // (';' fqName)
  private static boolean import_names_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_names_1_0")) return false;
    return import_names_1_0_0(builder_, level_ + 1);
  }

  // ';' fqName
  private static boolean import_names_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "import_names_1_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, SEMICOLON);
    result_ = result_ && fqName(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // "\\" "(" id ":" expression ")" ARROW expression
  public static boolean lambda_expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lambda_expression")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<lambda expression>");
    result_ = consumeToken(builder_, "\\");
    result_ = result_ && consumeToken(builder_, LEFT_PAREN);
    result_ = result_ && consumeToken(builder_, ID);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && expression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    result_ = result_ && consumeToken(builder_, ARROW);
    result_ = result_ && expression(builder_, level_ + 1);
    if (result_) {
      marker_.done(LAMBDA_EXPRESSION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // application | atom_expr
  static boolean maybe_application(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "maybe_application")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = application(builder_, level_ + 1);
    if (!result_) result_ = atom_expr(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // function_type | maybe_application
  static boolean maybe_function_type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "maybe_function_type")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = function_type(builder_, level_ + 1);
    if (!result_) result_ = maybe_application(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // 'module' fqName bindings "where"
  public static boolean module_declaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_declaration")) return false;
    if (!nextTokenIs(builder_, MODULE_KEYWORD)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, null);
    result_ = consumeToken(builder_, MODULE_KEYWORD);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, fqName(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, bindings(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, WHERE_KEYWORD) && result_;
    if (result_ || pinned_) {
      marker_.done(MODULE_DECLARATION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // 'open' ? 'import' fqName as_name? using_or_hiding? renaming?
  public static boolean module_import(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_import")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<module import>");
    result_ = module_import_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, "import");
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, fqName(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, module_import_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, module_import_4(builder_, level_ + 1)) && result_;
    result_ = pinned_ && module_import_5(builder_, level_ + 1) && result_;
    if (result_ || pinned_) {
      marker_.done(MODULE_IMPORT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, pinned_, _SECTION_GENERAL_, null);
    return result_ || pinned_;
  }

  // 'open' ?
  private static boolean module_import_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_import_0")) return false;
    consumeToken(builder_, "open");
    return true;
  }

  // as_name?
  private static boolean module_import_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_import_3")) return false;
    as_name(builder_, level_ + 1);
    return true;
  }

  // using_or_hiding?
  private static boolean module_import_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_import_4")) return false;
    using_or_hiding(builder_, level_ + 1);
    return true;
  }

  // renaming?
  private static boolean module_import_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_import_5")) return false;
    renaming(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // VIRTUAL_LEFT_PAREN | VIRTUAL_RIGHT_PAREN | VIRTUAL_SEMICOLON | ()
  public static boolean new_line(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "new_line")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<new line>");
    result_ = consumeToken(builder_, VIRTUAL_LEFT_PAREN);
    if (!result_) result_ = consumeToken(builder_, VIRTUAL_RIGHT_PAREN);
    if (!result_) result_ = consumeToken(builder_, VIRTUAL_SEMICOLON);
    if (!result_) result_ = new_line_3(builder_, level_ + 1);
    if (result_) {
      marker_.done(NEW_LINE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // ()
  private static boolean new_line_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "new_line_3")) return false;
    return new_line_3_0(builder_, level_ + 1);
  }

  private static boolean new_line_3_0(PsiBuilder builder_, int level_) {
    return true;
  }

  /* ********************************************************** */
  // ! (VIRTUAL_RIGHT_PAREN | VIRTUAL_SEMICOLON)
  static boolean recover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "recover")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_NOT_, null);
    result_ = !recover_0(builder_, level_ + 1);
    marker_.rollbackTo();
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_NOT_, null);
    return result_;
  }

  // (VIRTUAL_RIGHT_PAREN | VIRTUAL_SEMICOLON)
  private static boolean recover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "recover_0")) return false;
    return recover_0_0(builder_, level_ + 1);
  }

  // VIRTUAL_RIGHT_PAREN | VIRTUAL_SEMICOLON
  private static boolean recover_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "recover_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, VIRTUAL_RIGHT_PAREN);
    if (!result_) result_ = consumeToken(builder_, VIRTUAL_SEMICOLON);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // new_line "renaming" "(" renamings ")"
  public static boolean renaming(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "renaming")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<renaming>");
    result_ = new_line(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, "renaming");
    result_ = result_ && consumeToken(builder_, LEFT_PAREN);
    result_ = result_ && renamings(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    if (result_) {
      marker_.done(RENAMING);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // id "to" id (new_line ";" id "to" id)*
  static boolean renamings(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "renamings")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, ID);
    result_ = result_ && consumeToken(builder_, "to");
    result_ = result_ && consumeToken(builder_, ID);
    result_ = result_ && renamings_3(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // (new_line ";" id "to" id)*
  private static boolean renamings_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "renamings_3")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!renamings_3_0(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "renamings_3");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  // (new_line ";" id "to" id)
  private static boolean renamings_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "renamings_3_0")) return false;
    return renamings_3_0_0(builder_, level_ + 1);
  }

  // new_line ";" id "to" id
  private static boolean renamings_3_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "renamings_3_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = new_line(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    result_ = result_ && consumeToken(builder_, ID);
    result_ = result_ && consumeToken(builder_, "to");
    result_ = result_ && consumeToken(builder_, ID);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // declaration *
  static boolean root(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "root")) return false;
    int offset_ = builder_.getCurrentOffset();
    while (true) {
      if (!declaration(builder_, level_ + 1)) break;
      int next_offset_ = builder_.getCurrentOffset();
      if (offset_ == next_offset_) {
        empty_element_parsed_guard_(builder_, offset_, "root");
        break;
      }
      offset_ = next_offset_;
    }
    return true;
  }

  /* ********************************************************** */
  // telescope ARROW expression
  public static boolean tele_arrow(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tele_arrow")) return false;
    if (!nextTokenIs(builder_, LEFT_PAREN) && !nextTokenIs(builder_, LEFT_BRACE)
        && replaceVariants(builder_, 2, "<tele arrow>")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<tele arrow>");
    result_ = telescope(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ARROW);
    result_ = result_ && expression(builder_, level_ + 1);
    if (result_) {
      marker_.done(TELE_ARROW);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // ("{" type_signature "}") | ("(" type_signature ")")
  public static boolean telescope(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "telescope")) return false;
    if (!nextTokenIs(builder_, LEFT_PAREN) && !nextTokenIs(builder_, LEFT_BRACE)
        && replaceVariants(builder_, 2, "<telescope>")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<telescope>");
    result_ = telescope_0(builder_, level_ + 1);
    if (!result_) result_ = telescope_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(TELESCOPE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // ("{" type_signature "}")
  private static boolean telescope_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "telescope_0")) return false;
    return telescope_0_0(builder_, level_ + 1);
  }

  // "{" type_signature "}"
  private static boolean telescope_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "telescope_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_BRACE);
    result_ = result_ && type_signature(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_BRACE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // ("(" type_signature ")")
  private static boolean telescope_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "telescope_1")) return false;
    return telescope_1_0(builder_, level_ + 1);
  }

  // "(" type_signature ")"
  private static boolean telescope_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "telescope_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_PAREN);
    result_ = result_ && type_signature(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // ids ":" expression
  public static boolean type_signature(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "type_signature")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = ids(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && expression(builder_, level_ + 1);
    if (result_) {
      marker_.done(TYPE_SIGNATURE);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // ('using' '(' import_names ')') | ('hiding' '(' import_names ')')
  public static boolean using_or_hiding(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "using_or_hiding")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<using or hiding>");
    result_ = using_or_hiding_0(builder_, level_ + 1);
    if (!result_) result_ = using_or_hiding_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(USING_OR_HIDING);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // ('using' '(' import_names ')')
  private static boolean using_or_hiding_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "using_or_hiding_0")) return false;
    return using_or_hiding_0_0(builder_, level_ + 1);
  }

  // 'using' '(' import_names ')'
  private static boolean using_or_hiding_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "using_or_hiding_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, "using");
    result_ = result_ && consumeToken(builder_, LEFT_PAREN);
    result_ = result_ && import_names(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // ('hiding' '(' import_names ')')
  private static boolean using_or_hiding_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "using_or_hiding_1")) return false;
    return using_or_hiding_1_0(builder_, level_ + 1);
  }

  // 'hiding' '(' import_names ')'
  private static boolean using_or_hiding_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "using_or_hiding_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, "hiding");
    result_ = result_ && consumeToken(builder_, LEFT_PAREN);
    result_ = result_ && import_names(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

}