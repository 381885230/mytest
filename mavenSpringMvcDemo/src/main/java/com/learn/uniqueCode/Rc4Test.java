package com.learn.uniqueCode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class Rc4Test {
   
	public static void main(String[] args) {
//		String inviteCode=String.valueOf(System.currentTimeMillis());
		
		Set<String> set=new HashSet<String>();
	    for(int i=0;i<1000;i++){
	    	   int min = 1;
	    	   int max = 9999;
	    	   int intBounded = min + ((int) (new Random().nextFloat() * (max - min)));
	    	String code=RC4Util.encry_RC4_string(String.format("%07d", intBounded), UUID.randomUUID().toString());
//		    String code=RC4Util.encry_RC4_string(String.format("%07d", 5921044),UUID.randomUUID().toString() );
	    	System.out.println(code.toString());
//	    	System.out.println(Math.random());
//	    	int randomNumber = (int) Math.round(Math.random()*(max-min)+min);  
	    	System.out.println();
	    	set.add(code);
	    }
		System.out.println(set.size());
	}
}
