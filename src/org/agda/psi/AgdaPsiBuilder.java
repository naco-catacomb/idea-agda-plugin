package org.agda.psi;


import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.agda.parser.AgdaElementType;

public class AgdaPsiBuilder {
    public static PsiElement build(ASTNode node) {
        if (node.getElementType() instanceof AgdaElementType) {
            PsiElement psi = ((AgdaElementType) node.getElementType()).createPsi(node);
            if (psi != null) {
                return psi;
            }
        }

        return new AgdaASTWrapper(node);
    }
}
