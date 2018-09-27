package com.learn.thread.method;
/**
 * �̵߳�Эͬ���� join����
 */
public class TestJoin {

    // �ж���Ƭ�Ƿ��������
    public static boolean isFinish = false;

    public static void main(String[] args) {
        // ����ͼƬ���߳�
        final Thread download = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("download:��ʼ����ͼƬ");
                for(int i = 0; i <= 100; i++){
                    System.out.println("download:�����" + i + "%");
                    try{
                        Thread.sleep(50);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("download:ͼƬ�������");
                isFinish = true;
            }
        });
        download.start();

        // ������ʾͼƬ���߳�
        Thread showImg = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("show:׼����ʾͼƬ");
                // �ȴ������̹߳���������,��ִ������Ĵ���,
                try{
                    // ��ʱ��ʾͼƬ���߳̾ͽ�������״̬,�ȴ�download�߳����н���,����ִ������Ĵ��롣ע��ǧ��Ҫ����ԶҲ�����˵��߳��ϵȴ�
                    download.join();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                if(!isFinish){
                    throw new RuntimeException("show:ͼƬ��û��������");
                }
                System.out.println("show:ͼƬ��ʾ��ɣ�");
            }
        });
        showImg.start();
    }

}