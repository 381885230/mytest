package com.yuanjin.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		final Singer target = new Singer();
		ISinger proxy = (ISinger) Proxy.newProxyInstance(target.getClass()
				.getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("������ʺ�");
						// ִ��Ŀ����󷽷�
						Object returnValue = method.invoke(target, args);
						System.out.println("лл���");
						return returnValue;
					}
				});
		proxy.sing();
	}
}