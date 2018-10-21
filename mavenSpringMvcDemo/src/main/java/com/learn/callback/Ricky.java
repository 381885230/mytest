package com.learn.callback;
/**
 * 一个名叫Ricky的同学解决老师提出的问题，原文出处http://www.cnblogs.com/xrq730/p/6424471.html
 */
public class Ricky implements Student {

    @Override
    public void resolveQuestion(Callback callback) {
        // 模拟解决问题
        try {
            Thread.sleep(1000);
            System.out.println("问题解决中。。。");
        } catch (InterruptedException e) {
            
        }
        
        // 回调，告诉老师作业写了多久
        callback.tellAnswer(3);
    }

}