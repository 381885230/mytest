package com.learn.annotation.test4;
/**
 * 一个用到了自定义的注解的类
 */
public class OneClass {
	
	@MyAnnotation(parameter1="YES", parameter2=10000)
	public void oneMethod () {
	}
}
