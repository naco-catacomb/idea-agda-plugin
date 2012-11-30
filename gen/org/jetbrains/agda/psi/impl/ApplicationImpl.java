// This is a generated file. Not intended for manual editing.
package org.jetbrains.agda.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.jetbrains.agda.gen.parser.AgdaTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.jetbrains.agda.psi.*;

public class ApplicationImpl extends ASTWrapperPsiElement implements Application {

  public ApplicationImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public Application getApplication() {
    return findChildByClass(Application.class);
  }

  @Override
  @Nullable
  public Expression getExpression() {
    return findChildByClass(Expression.class);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitApplication(this);
    else super.accept(visitor);
  }

}
