package com.learn.thread;
 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class ThreadPool {
	
	private ExecutorService pool = Executors.newFixedThreadPool(300);
	
	public static void main(String[] args){
		ThreadPool threadPool=new ThreadPool();
		System.out.println("������ʼ");
		for(int i=0;i<300;i++){
			threadPool.pool.execute(new Task(String.valueOf(i)));
			System.out.println("��"+i+"�������ύ");
		}
		System.out.println("���������");
		
	}
}
class Task implements Runnable{
	private String name="";
	Task(String name){
		this.name=name;
	}
	
	@Override
	public void run() {
		System.out.println("Thread-"+name+" start running");
		
	}
}
