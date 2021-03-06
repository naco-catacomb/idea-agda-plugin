package org.jetbrains.agda.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * @author Evgeny.Kurbatsky
 */
public class ExternalAgdaParser implements PsiParser {

    @NotNull
    @Override
    public ASTNode parse(IElementType root, PsiBuilder builder) {
        final PsiBuilder.Marker rootMarker = builder.mark();

        new AgdaParsing(builder).parseFile();

        rootMarker.done(root);
        return builder.getTreeBuilt();
    }

}
