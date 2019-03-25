package com.learn.volatiletest.tasktest;

/**
 * 1.对volatile变量的写会立即刷新到主存
 * 2.对volatile变量的读会读主存中的新值
 * 不出现死循环
 * @author yuanjin
 * @date 2019年3月25日 下午2:10:39
 */
public class Task2 implements Runnable {
	
	volatile boolean running=true;
	int i=0;

	@Override
	public void run() {
		while(running){
			i++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Task2 task=new Task2();
		Thread th=new Thread(task);
		th.start();
		Thread.sleep(10);
		task.running=false;
//		Thread.sleep(1000);
		System.out.println(task.i);
		System.out.println("program end");
		
	}

}
