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

public class CompiledTypePragmaImpl extends ASTWrapperPsiElement implements CompiledTypePragma {

  public CompiledTypePragmaImpl(ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public NameDeclaration getNameDeclaration() {
    return findChildByClass(NameDeclaration.class);
  }

  @Override
  @Nullable
  public PragmaString getPragmaString() {
    return findChildByClass(PragmaString.class);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) ((Visitor)visitor).visitCompiledTypePragma(this);
    else super.accept(visitor);
  }

}
