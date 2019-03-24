package com.learn.proxy2.staticproxy;

/**
 * 3.定义代理类并实现业务接口 
 * 因为代理对象和被代理对象需要实现相同的接口
 * @author yuanjin
 * @date 2019年3月24日 下午5:02:09
 */
public class UserServiceProxy implements IUserService {

	// 被代理对象
	private IUserService target;

	// 通过构造方法传入被代理对象
	public UserServiceProxy(IUserService target) {
		this.target = target;
	}

	@Override
	public void add(String name) {
		System.out.println("准备向数据库中插入数据");
		target.add(name);
		System.out.println("插入数据库成功");
	}

}
