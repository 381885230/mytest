package com.learn.singleton;
public class ClassInnerClassDanli {
    public static class DanliHolder{
        private static ClassInnerClassDanli dl = new ClassInnerClassDanli();
    }
    private ClassInnerClassDanli(){}
    public static ClassInnerClassDanli getInstance(){
        return DanliHolder.dl;
    }
}