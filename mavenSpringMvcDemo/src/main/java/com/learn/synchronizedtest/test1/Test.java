package com.learn.synchronizedtest.test1;

import java.util.ArrayList;

public class Test {
	public static final int SIZE=10;

	public static void main(String[] args) {
//		final InsertData insertData = new InsertData();
//		final InsertDataThis insertData = new InsertDataThis();
		final InsertDataObject insertData = new InsertDataObject();


		new Thread() {
			public void run() {
				insertData.insert(Thread.currentThread());
			};
		}.start();

		new Thread() {
			public void run() {
				insertData.insert(Thread.currentThread());
			};
		}.start();
	}
}

class InsertData {
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();

	public synchronized void insert(Thread thread) {
		for (int i = 0; i < Test.SIZE; i++) {
			System.out.println(thread.getName() + "在插入数据" + i);
			arrayList.add(i);
		}
	}
}


class InsertDataThis {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
     
    public void insert(Thread thread){
        synchronized (this) {
            for(int i=0;i<Test.SIZE;i++){
                System.out.println(thread.getName()+"在插入数据"+i);
                arrayList.add(i);
            }
        }
    }
}	

class InsertDataObject {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Object object = new Object();
     
    public void insert(Thread thread){
        synchronized (object) {
            for(int i=0;i<Test.SIZE;i++){
                System.out.println(thread.getName()+"在插入数据"+i);
                arrayList.add(i);
            }
        }
    }
}

