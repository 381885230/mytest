package com.learn.reflectInf;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.alibaba.fastjson.JSON;

public class MyProxyView implements InvocationHandler {

	public static Object newInstance(Class[] interfaces) {
		return Proxy.newProxyInstance(MyProxyView.class.getClassLoader(),
				interfaces, new MyProxyView());
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		System.out.println("调用的方法名称为:" + methodName);
		Class<?> returnType = method.getReturnType();
		System.out.println("返回的类型为" + returnType.getName());
		// 这里测试下使用json解析数据后返回.
		Object parseObject = JSON.parseObject("{res:\"ff\"}", returnType);

		// 通过注解去取注解上的value
		Annotation parameterAnnotations[][] = method.getParameterAnnotations();
		for (int i = 0; i < parameterAnnotations.length; i++) {
			for (Annotation annotation : parameterAnnotations[i]) {
				if (Param.class.equals(annotation.annotationType())) {
					Param o = ((Param) annotation);
					String value = o.value();
					System.out.println(value);
				}
			}
		}

		return parseObject;
	}

	public static void main(String[] args) {
		IExample example = (IExample) MyProxyView
				.newInstance(new Class[] { IExample.class });

		// aduit bean 1 在接口执行的时候就会去调invoke 方法
		example.setName("my example", 9);
		example.setDesc("my proxy example");
		// aduit bean 2
		Map<String, Object> name = example.getName();
		System.out.println(name.get("res"));
		System.out.println("exmaple name : " + example.getName());
		System.out.println("exmaple desc : " + example.getDesc());
		// System.out.println();
	}
}