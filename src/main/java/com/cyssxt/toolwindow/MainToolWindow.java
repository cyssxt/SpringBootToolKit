package com.cyssxt.toolwindow;
import com.cyssxt.hanlder.HandlerFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.psi.*;
import com.intellij.ui.components.JBList;

import javax.swing.*;

public class MainToolWindow {
    public JList container;
    private ToolWindow toolWindow;
//    Map<String, List<SpringBean>> map = new HashMap<>();
//
//    public void parsePsiClasses(PsiClass[] psiClass){
//        if(psiClass==null){
//            return;
//        }
//        for(PsiClass temp:psiClass){
//            parsePsiClass(temp);
//        }
//
//    }
//    void parsePsiAnnotation(PsiAnnotation psiAnnotation){
//        String qualifiedName = psiAnnotation.getQualifiedName();
//        AnnotationMetaData annotationMetaData = AnnotationMetaData.getAnnotationMetaData(qualifiedName);
//        NavigatablePsiElement psiElement = (NavigatablePsiElement) psiAnnotation.getNavigationElement();
//        SpringBean springBean = new SpringBean(annotationMetaData,psiElement);
//        if(annotationMetaData!=null) {
//            List<SpringBean> springBeans = map.get(annotationMetaData.name());
//            if (springBeans == null) {
//                springBeans = new ArrayList<>();
//                map.put(annotationMetaData.name(), springBeans);
//            }
//            springBeans.add(springBean);
//        }
//    }
//
//    void parseMethod(PsiMethod psiMethod){
//        PsiAnnotation[] psiAnnotations = psiMethod.getAnnotations();
//        if(psiAnnotations==null){
//            for(PsiAnnotation psiAnnotation:psiAnnotations){
//                parsePsiAnnotation(psiAnnotation);
//            }
//        }
//    }
//
//    public void parsePsiClass(PsiClass psiClass){
//        PsiMethod[] psiMethods = psiClass.getMethods();
//        PsiAnnotation[] psiAnnotations = psiClass.getAnnotations();
//        if(psiAnnotations!=null){
//            for(PsiAnnotation psiAnnotation:psiAnnotations){
//                parsePsiAnnotation(psiAnnotation);
//            }
//        }
//        for(PsiMethod method:psiMethods){
//            parseMethod(method);
//        }
//    }
//
//    void initJTree(){
//        container = new JBList();
//        Iterator<Map.Entry<String, List<SpringBean>>> iterator = map.entrySet().iterator();
//        List<String> datas = new ArrayList<>();
//        while (iterator.hasNext()){
//            Map.Entry<String, List<SpringBean>> entry = iterator.next();
//            String key = entry.getKey();
//            List values = entry.getValue();
//            datas.add(String.format("%s ,Size:%d",key,values.size()));
//        }
//        container.setListData(datas.toArray());
//    }

    public MainToolWindow(ToolWindow toolWindow,Project project) {
        PsiManager psiManager = PsiManager.getInstance(project);
        VfsUtilCore.iterateChildrenRecursively(ProjectUtil.guessProjectDir(project), file -> {
            PsiFile psiFile = psiManager.findFile(file);
            if(psiFile instanceof PsiJavaFile){
                HandlerFactory.getInstance().parse((PsiJavaFile) psiFile);
                return true;
            }
            return true;
        }, fileOrDir -> true);
        initJTree();
    }

    private void initJTree() {
        container = new JBList();
    }

    public JComponent getContent(){
        return container;
    }


}
