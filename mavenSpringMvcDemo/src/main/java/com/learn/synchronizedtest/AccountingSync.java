package com.learn.synchronizedtest;
public class AccountingSync implements Runnable{
    //共享资源(临界资源)
    static int i=0;
 
    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        i++;
    }
//	public void increase() {
//		i++;
//	}
    
    @Override
    public void run() {
        for(int j=0;j<1000;j++){
            increase();
            System.out.println(Thread.currentThread().getName()+"=="+i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AccountingSync instance=new AccountingSync();
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
    /**
     * 输出结果:
     * 20000
     */
}
