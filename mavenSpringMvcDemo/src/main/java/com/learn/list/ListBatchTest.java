package com.learn.list;

import java.util.ArrayList;
import java.util.List;

public class ListBatchTest {

	public static final int BATCH_SIZE=2;
	
	public static void main(String[] args) {
		List<String> allList=new ArrayList<>();
		for(int i=0;i<14;i++){
			allList.add(String.valueOf(i));
		}
		
		int batchCount=allList.size()/BATCH_SIZE+1;
		for(int i=0;i<batchCount;i++){
			List<String> sublist=new ArrayList<>();
			if(i==batchCount-1){
				sublist=allList.subList(i*BATCH_SIZE, allList.size());
			}else{
				sublist=allList.subList(i*BATCH_SIZE, (i+1)*BATCH_SIZE);
			}
			//验证顺序
			for(String s:sublist){
				System.out.print(s+",");
			}
			//do something
			System.out.println("=====================");
		}
		
		
		
	}

}
