package com.learn.annotation.inherited;

import java.util.Arrays;

/**
 * 也就是说注解和普通类的区别是如果一个子类想获取到父类上的注解信息， 
 *那么必须在父类上使用的注解上面 加上@Inherit关键字 

* @ClassName: TestMain
* @author yuanjin
* @date 2018年11月1日
 */
public class TestMain {
	public static void main(String[] args) {

		Class<Sub> clazz = Sub.class;

/*		System.out.println("============================Field===========================");
		System.out.println(Arrays.toString(clazz.getFields()));
		System.out.println(Arrays.toString(clazz.getDeclaredFields())); // all +
																		// 自身
		System.out.println("============================Method===========================");
		System.out.println(Arrays.toString(clazz.getMethods())); // public + 继承
		// all + 自身
		System.out.println(Arrays.toString(clazz.getDeclaredMethods()));
		System.out.println("============================Constructor===========================");
		System.out.println(Arrays.toString(clazz.getConstructors()));
		System.out.println(Arrays.toString(clazz.getDeclaredConstructors()));
		System.out.println("============================AnnotatedElement===========================");*/
		// 注解BTable是否存在于元素上
		System.out.println(clazz.isAnnotationPresent(BTable.class));
		// 如果存在该元素的指定类型的注释DBTable2，则返回这些注释，否则返回 null。
		System.out.println(clazz.getAnnotation(BTable.class));
		// 继承
		System.out.println(Arrays.toString(clazz.getAnnotations()));
		System.out.println(Arrays.toString(clazz.getDeclaredAnnotations())); //// 自身
	}
}