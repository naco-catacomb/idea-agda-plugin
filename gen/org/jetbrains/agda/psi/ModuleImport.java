// This is a generated file. Not intended for manual editing.
package org.jetbrains.agda.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ModuleImport extends PsiElement {

  @Nullable
  AsName getAsName();

  @Nullable
  FqName getFqName();

  @Nullable
  Renaming getRenaming();

  @Nullable
  UsingOrHiding getUsingOrHiding();

}
