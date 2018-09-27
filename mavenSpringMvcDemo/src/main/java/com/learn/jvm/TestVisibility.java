package com.learn.jvm;

import java.util.ArrayList;
import java.util.List;

public class TestVisibility {
    public static boolean flag = false;

    public static void main(String[] args) {
        List<Thread> thdList = new ArrayList<Thread>();
        for(int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable(){
                public void run() {
                    while (true) {
                        if (flag) {
                            // �����м��Σ����ܲ������ӡ����Ҳ���ܻ��ӡ����
                            // �������ӡ�����ʾThread��������Ȼ�ǹ����ڴ��е�flag
                            // ���Գ��Խ�flag���volatile�����м��ο���
                                  System.out.println(Thread.currentThread().getId() + " is true now"); 
                        }
                    }
                }
            });
            t.start();
            thdList.add(t);
        }

        flag = true;
        System.out.println("set flag true");

        // �ȴ��߳�ִ�����
        try {
            for (Thread t : thdList) {
                t.join();
            }
        } catch (Exception e) {

        }
    }
}