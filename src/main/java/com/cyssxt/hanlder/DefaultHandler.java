package com.cyssxt.hanlder;

import com.cyssxt.constant.AnnotationMetaData;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class DefaultHandler<T> implements Handler<T>{

    PsiClass psiClass = null;
    Handler parent;
    T _instance;


    @Override
    public void parse(PsiClass psiClass, PsiAnnotation psiAnnotation,Handler parent) {
        this.psiClass = psiClass;
        this.parent = parent;
        T t = getInstance();
        parse(psiAnnotation,t);
        AnnotationMetaData[] nexts = getNext();
        if(nexts!=null){
            for(AnnotationMetaData annotationMetaData:nexts){
                AnnotationMetaData.Type[] types  = annotationMetaData.getTypes();
                for(AnnotationMetaData.Type type:types){
                    if(type == AnnotationMetaData.Type.METHOD && parent==null){
                        PsiMethod[] psiMethods = psiClass.getMethods();
                        for(PsiMethod psiMethod:psiMethods){
                            String qualifiedName = annotationMetaData.getQualifiedName();
                            PsiAnnotation temp = psiMethod.getAnnotation(qualifiedName);
                            if(temp!=null) {
                                Class handlerClass = annotationMetaData.getHandler();
                                Handler handler = null;
                                try {
                                    handler = (Handler) handlerClass.newInstance();
                                    handler.parse(psiClass,temp,this);
                                } catch (InstantiationException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public abstract void parse(PsiAnnotation psiAnnotation,T t);

    @Override
    public void next(PsiAnnotation psiAnnotation,T t) {
//        String qualifiedName = psiAnnotation.getQualifiedName();
//        AnnotationMetaData annotationMetaData = AnnotationMetaData.getAnnotationMetaData(qualifiedName);
//        if(annotationMetaData==null){
//            return;
//        }
//        Handler handler = annotationMetaData.getHandler();
//        handler.parse(psiClass,psiAnnotation);
    }

    public AnnotationMetaData[] getNext(){return null;}

    public T getInstance() {
        if(_instance==null){
            _instance = getNewInstance();
        }
        return _instance;
    }

}
