package com.learn.volatiletest.tasktest;



/**
 * 同步块存在如下语义：
 * 1.进入同步块，访问共享变量会去读取主存
 * 2.退出同步块，本地内存对共享变量的修改会立即刷新到主存
 * 
 * 不出现死循环：用同步块解决
 * @author yuanjin
 * @date 2019年3月25日 下午2:10:39
 */
public class Task3 implements Runnable {
	
	boolean running=true;
	int i=0;

	@Override
	public void run() {
		while(isRunning()){
			i++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Task3 task=new Task3();
		Thread th=new Thread(task);
		th.start();
		Thread.sleep(10);
		task.setRunning(false);
		//		Thread.sleep(1000);
		System.out.println(task.i);
		System.out.println("program end");
		
	}

	public synchronized boolean isRunning() {
		return running;
	}

	public synchronized void setRunning(boolean running) {
		this.running = running;
	}
	
}
