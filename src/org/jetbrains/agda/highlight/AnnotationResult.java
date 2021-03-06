package org.jetbrains.agda.highlight;

import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.agda.external.AgdaExternalAnnotation;

import java.util.List;

public class AnnotationResult {
    VirtualFile myFile;
    List<AgdaExternalAnnotation> myAnnotations;

    public AnnotationResult(VirtualFile file, List<AgdaExternalAnnotation> annotations) {
        myFile = file;
        myAnnotations = annotations;
    }
}
