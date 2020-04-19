package com.cyssxt.hanlder;

import com.cyssxt.constant.AnnotationMetaData;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiClass;

import java.util.List;

public interface Handler<T> {
    void parse(PsiClass psiClass, PsiAnnotation psiAnnotation,Handler parent);

    void next(PsiAnnotation psiAnnotation,T t);

    T getNewInstance();
}
