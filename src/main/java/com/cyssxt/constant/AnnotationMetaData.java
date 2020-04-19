package com.cyssxt.constant;

import com.cyssxt.hanlder.*;

import java.util.HashMap;
import java.util.Map;

public enum AnnotationMetaData {

//    Component("org.springframework.stereotype.Component",new Type[]{Type.TYPE},ComponentHandler.class),
//    Service("org.springframework.stereotype.Service",new Type[]{Type.TYPE},ServiceHandler.class),
//    Controller("org.springframework.stereotype.Controller",new Type[]{Type.TYPE},ControllerHandler.class),
//    RestController("org.springframework.web.bind.annotation.RestController",new Type[]{Type.TYPE},RestControllerHandler.class);
//    Repository("org.springframework.web.bind.annotation.Repository",new Type[]{Type.TYPE},RepositoryHandler.class),
    RequestMapping("org.springframework.web.bind.annotation.RequestMapping",new Type[]{Type.TYPE,Type.METHOD},RequestMappingHandler.class);
//    Resource("javax.annotation.Resource",new Type[]{Type.FIELD},ResourceHandler.class);
    String qualifiedName;
    Class<? extends Handler> handler;
    Type[] types;


    public enum Type{
        FIELD,METHOD,TYPE
    }
    public interface Callback{
        void foreach(AnnotationMetaData annotationMetaData);
    }

    public Class getHandler() {
        return handler;
    }

    private static Map<String, AnnotationMetaData > methodMap = new HashMap<>();
    private static Map<String, AnnotationMetaData > typeMap = new HashMap<>();
    private static Map<String, AnnotationMetaData > map;

    AnnotationMetaData(String qualifiedName,Type[] types,Class<? extends Handler> handler) {
        this.qualifiedName = qualifiedName;
        this.handler = handler;
        this.types = types;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }
    public synchronized static  void iterator(Type type,Callback callback){
        for (AnnotationMetaData annotationMetaData : AnnotationMetaData.values()) {
            Type[] types = annotationMetaData.types;
            for(Type temp:types){
                if(type==temp){
                    callback.foreach(annotationMetaData);
                }
            }
        }
    }
    public synchronized static AnnotationMetaData getAnnotationMetaData(String qualifiedName) {
        if (null == map) {
            map = new HashMap<>();
            for (AnnotationMetaData annotationMetaData : AnnotationMetaData.values()) {
                map.put(annotationMetaData.getQualifiedName(),annotationMetaData);
            }
        }
        return map.get(qualifiedName);
    }

    public Type[] getTypes() {
        return types;
    }
}

