package com.learn.synchronizedtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountingSync2 implements Runnable {
    //共享资源(临界资源)
    static int i = 0;

    /**
     * synchronized 修饰实例方法
     */
    synchronized void getI() {
        if (i % 1000000 == 0) {
            System.out.println(i);
        }
    }

    public synchronized void increase() {
        i++;
        getI();
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
        System.out.println(i);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        AccountingSync2 accountingSync2 = new AccountingSync2();
        exec.execute(accountingSync2);
        exec.execute(accountingSync2);
        exec.shutdown();
    }
}

