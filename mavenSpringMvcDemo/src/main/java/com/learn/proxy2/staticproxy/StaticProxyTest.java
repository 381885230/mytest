package com.learn.proxy2.staticproxy;

/**
 * 4.客户端调用
 * 
 * @author yuanjin
 * @date 2019年3月24日 下午5:04:34
 */
public class StaticProxyTest {

	public static void main(String[] args) {

		IUserService target = new UserServiceImpl();
		UserServiceProxy proxy = new UserServiceProxy(target);
		proxy.add("yuanjin");

	}

}
