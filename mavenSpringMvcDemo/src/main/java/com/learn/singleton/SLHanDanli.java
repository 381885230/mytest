package com.learn.singleton;
public class SLHanDanli {
    private static volatile SLHanDanli dl = null;
    private SLHanDanli(){}
    public static SLHanDanli getInstance(){
        if(dl == null){
            synchronized (SLHanDanli.class) {
                if(dl == null){
                    dl = new SLHanDanli();
                }
            }
        }
        return dl;
    }
}