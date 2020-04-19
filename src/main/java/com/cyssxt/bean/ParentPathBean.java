package com.cyssxt.bean;

import java.util.ArrayList;
import java.util.List;

public class ParentPathBean extends PathBean {
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
}
