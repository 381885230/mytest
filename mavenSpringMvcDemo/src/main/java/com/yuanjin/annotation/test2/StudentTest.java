package com.yuanjin.annotation.test2;
 
public class StudentTest {
 
	public static void main(String[] args) throws Exception {
		Student stu = new Student();
		stu.init();
		stu.show();
		stu.init("ÀîËÄ", 21, false);
		stu.show();
	}
 
}
