package com.cyssxt.bean;

import com.cyssxt.constant.AnnotationMetaData;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;

public class SpringBean {
    PsiElement psiElement;
    String path;
    String controller;
    public SpringBean(){}

    public PsiElement getPsiElement() {
        return psiElement;
    }

    public void setPsiElement(PsiElement psiElement) {
        this.psiElement = psiElement;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }
}
