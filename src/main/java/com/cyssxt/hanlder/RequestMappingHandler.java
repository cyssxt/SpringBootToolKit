package com.cyssxt.hanlder;

import com.cyssxt.bean.PathBean;
import com.cyssxt.constant.AnnotationAttributeConstant;
import com.cyssxt.constant.AnnotationMetaData;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiAnnotationMemberValue;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.compiled.ClsArrayInitializerMemberValueImpl;
import com.intellij.psi.impl.source.tree.java.PsiLiteralExpressionImpl;


public class RequestMappingHandler extends DefaultHandler<PathBean> {

    @Override
    public void parse(PsiAnnotation psiAnnotation, PathBean pathBean) {
        if(psiAnnotation!=null) {
            PsiElement psiElement = psiAnnotation.getNavigationElement();
//            System.out.println(psiClass.getQualifiedName());
            PsiAnnotationMemberValue psiAnnotationMemberValue = psiAnnotation.findAttributeValue(AnnotationAttributeConstant.VALUE);
            System.out.println("RequestMappingHandler="+psiAnnotation.getQualifiedName());
            if(psiAnnotationMemberValue instanceof PsiLiteralExpressionImpl) {
                String path = ((PsiLiteralExpressionImpl) psiAnnotationMemberValue).getInnerText();
                pathBean.setPath(path);
                pathBean.setPsiElement(psiElement);
                if (parent != null) {
                    ((PathBean) ((DefaultHandler) parent).getInstance()).add(pathBean);
                }
            }else if(psiAnnotationMemberValue instanceof ClsArrayInitializerMemberValueImpl){
                String path = psiAnnotationMemberValue.getChildren()[0].getText();
                pathBean.setPath(path);
                if (parent != null) {
                    ((PathBean) ((DefaultHandler) parent).getInstance()).add(pathBean);
                }
            }
        }
    }

    @Override
    public AnnotationMetaData[] getNext() {
        return new AnnotationMetaData[]{AnnotationMetaData.RequestMapping};
    }

    @Override
    public PathBean getNewInstance() {
        return new PathBean();
    }
}
