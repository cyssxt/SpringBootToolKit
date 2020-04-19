package com.cyssxt.hanlder;

import com.cyssxt.bean.ParentPathBean;
import com.cyssxt.constant.AnnotationAttributeConstant;
import com.cyssxt.constant.AnnotationMetaData;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiAnnotationMemberValue;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.java.PsiLiteralExpressionImpl;

public class RestControllerHandler extends DefaultHandler<ParentPathBean> {


    @Override
    public void parse(PsiAnnotation psiAnnotation,ParentPathBean pathBean) {
//        PsiAnnotation temp = psiClass.getAnnotation(AnnotationMetaData.RequestMapping.getQualifiedName());
//        if(temp!=null) {
//            PsiAnnotationMemberValue psiAnnotationMemberValue = temp.findAttributeValue(AnnotationAttributeConstant.VALUE);
//            String path = ((PsiLiteralExpressionImpl) psiAnnotationMemberValue).getInnerText();
//            PsiElement psiElement = psiClass.getNavigationElement();
//            pathBean.setPath(path);
//            pathBean.setPsiElement(psiElement);
//        }
    }

//    @Override
//    public AnnotationMetaData[] getNext() {
//        return new AnnotationMetaData[]{AnnotationMetaData.RequestMapping};
//    }

    @Override
    public ParentPathBean getNewInstance() {
        return new ParentPathBean();
    }
}

