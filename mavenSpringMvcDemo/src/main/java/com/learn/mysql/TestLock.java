package com.learn.mysql;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLock {    
    public static void main(String[] args) throws InterruptedException {
        //�����̳߳أ�������10���̣߳���ִ��100��+1����
        final int THREAD_COUNT=10;
        final int RUN_TIME=50;
        
        ExecutorService threadPool=Executors.newFixedThreadPool(THREAD_COUNT);
        //��CountDownLatch��֤���̵߳ȴ������������
        CountDownLatch count=new CountDownLatch(RUN_TIME);
        
        for(int i=0;i<RUN_TIME;i++)
            threadPool.execute(new LostUpdate(count));
        
        threadPool.shutdown();
        count.await();
        //��ʾ��������ִ����
        System.out.println("finish");
    }
}