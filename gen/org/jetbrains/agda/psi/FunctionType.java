// This is a generated file. Not intended for manual editing.
package org.jetbrains.agda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FunctionType extends PsiElement {

  @Nullable
  Application getApplication();

  @NotNull
  List<Expression> getExpressionList();

  @Nullable
  FqName getFqName();

  @NotNull
  MaybeNewLine getMaybeNewLine();

  @Nullable
  NumberExpression getNumberExpression();

  @Nullable
  SubstituteImplisit getSubstituteImplisit();

}
