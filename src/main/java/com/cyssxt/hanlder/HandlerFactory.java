package com.cyssxt.hanlder;

import com.cyssxt.constant.AnnotationMetaData;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiJavaFile;
import sun.tools.java.Type;

import java.util.HashMap;
import java.util.Map;

public class HandlerFactory {

    private static HandlerFactory _instance=null;

    private Map<String,Handler> items = new HashMap<>();

    public synchronized static HandlerFactory getInstance(){
        if(_instance==null){
            _instance = new HandlerFactory();
        }
        return _instance;
    }

    public void parse(PsiJavaFile psiFile) {
        PsiClass[] psiClasses = psiFile.getClasses();
        if(psiClasses!=null){
            for (PsiClass psiClass:psiClasses){
                AnnotationMetaData.iterator(AnnotationMetaData.Type.TYPE, annotationMetaData -> {
                    String qualifiedName = annotationMetaData.getQualifiedName();
                    PsiAnnotation psiAnnotation = psiClass.getAnnotation(qualifiedName);
                    if(annotationMetaData!=null){
                        Class baseHandler = annotationMetaData.getHandler();
                        try {
                            Handler handler = (Handler) baseHandler.newInstance();
                            handler.parse(psiClass,psiAnnotation,null);
                            System.out.println(((DefaultHandler)handler).getInstance());
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}
