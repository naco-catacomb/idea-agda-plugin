// This is a generated file. Not intended for manual editing.
package org.jetbrains.agda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface Application extends PsiElement {

  @Nullable
  Application getApplication();

  @NotNull
  List<Expression> getExpressionList();

  @NotNull
  List<FqName> getFqNameList();

  @NotNull
  List<GoalExpression> getGoalExpressionList();

  @NotNull
  List<NumberExpression> getNumberExpressionList();

  @NotNull
  List<SubstituteImplisit> getSubstituteImplisitList();

}
