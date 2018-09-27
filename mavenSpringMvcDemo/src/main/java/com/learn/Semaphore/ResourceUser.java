package com.learn.Semaphore;
public class ResourceUser implements Runnable{  
    private ResourceManage resourceManage;  
    private int userId;  
    public ResourceUser(ResourceManage resourceManage, int userId) {  
        this.resourceManage = resourceManage;  
        this.userId = userId;  
    }  
    public void run(){  
        System.out.print("userId:"+userId+"׼��ʹ����Դ...\n");  
        try {
			resourceManage.useResource(userId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
        System.out.print("userId:"+userId+"ʹ����Դ���...\n");  
    }  
  
    public static void main(String[] args){  
        ResourceManage resourceManage = new ResourceManage();  
        Thread[] threads = new Thread[100];  
        for (int i = 0; i < 100; i++) {  
            Thread thread = new Thread(new ResourceUser(resourceManage,i));//���������Դʹ����  
            threads[i] = thread;  
        }  
        for(int i = 0; i < 100; i++){  
            Thread thread = threads[i];  
            try {  
                thread.start();//�����߳�  
            }catch (Exception e){  
                e.printStackTrace();  
            }  
        }  
    }  
}
