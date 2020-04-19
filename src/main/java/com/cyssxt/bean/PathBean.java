package com.cyssxt.bean;

import com.intellij.psi.PsiElement;

import java.util.ArrayList;
import java.util.List;

public class PathBean extends SpringBean {

    List<PathBean> pathBeans;

    public void add(PathBean pathBean){
        if(pathBeans==null){
            pathBeans = new ArrayList<>();
        }
        pathBeans.add(pathBean);
    }

    public List<PathBean> getPathBeans() {
        return pathBeans;
    }

    public void setPathBeans(List<PathBean> pathBeans) {
        this.pathBeans = pathBeans;
    }
    public PathBean() {
    }

    @Override
    public String toString() {
        return "PathBean{" +
                "path='" + path + '\'' +
                ", pathBeans=" + pathBeans +
                '}';
    }
}
