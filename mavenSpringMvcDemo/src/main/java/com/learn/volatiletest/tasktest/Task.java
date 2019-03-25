package com.learn.volatiletest.tasktest;

/**
 * 出现死循环
 * @author yuanjin
 * @date 2019年3月25日 下午2:10:39
 */
public class Task implements Runnable {
	
	boolean running=true;
	int i=0;

	@Override
	public void run() {
		while(running){
			i++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Task task=new Task();
		Thread th=new Thread(task);
		th.start();
		Thread.sleep(10);
		task.running=false;
		Thread.sleep(1000);
		System.out.println(task.i);
		System.out.println("program end");
		
	}

}
