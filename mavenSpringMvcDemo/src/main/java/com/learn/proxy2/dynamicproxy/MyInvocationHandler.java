package com.learn.proxy2.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 创建InvocationHandler接口的实现类
 * @author yuanjin
 * @date 2019年3月24日 下午5:28:18
 */
public class MyInvocationHandler implements InvocationHandler {

	// 被代理对象，Object类型
	private Object target;

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.println("准备向数据库中插入数据");
		Object returnvalue = method.invoke(target, args);
		System.out.println("准备向数据库中插入数据");
		return returnvalue;
	}
}
