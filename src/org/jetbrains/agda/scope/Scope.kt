package org.jetbrains.agda.scope

import com.intellij.psi.PsiElement
import java.util.HashMap

abstract class Scope {
    public abstract fun traverse(function : (String, PsiElement) -> Boolean) : Boolean

    public fun getVisibleDeclarations() : MutableMap<String, PsiElement> {
        val declarations : MutableMap<String, PsiElement> = HashMap<String, PsiElement>()
        traverse {name, value ->
            declarations.put(name, value);
            false;
        }
        return declarations;
    }

    fun <A> traverseList(list : List<A>, inline traverseFunction : (A) -> Boolean) : Boolean {
        for (value in list) {
            if (traverseFunction(value))  {
                return true;
            }
        }
        return false;
    }
}