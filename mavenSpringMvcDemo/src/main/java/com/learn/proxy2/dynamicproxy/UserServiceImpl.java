package com.learn.proxy2.dynamicproxy;

/**
 * 2.被代理类实现业务接口
 * @author yuanjin
 * @date 2019年3月24日 下午5:00:20
 */
public class UserServiceImpl implements IUserService {

	@Override
	public void add(String name) {
		System.out.println("add name="+name+" into database");
	}

}
