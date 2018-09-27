package com.yuanjin.proxy.dynamicProxy;
/**
 * 目标对象实现了某一接口
 */
public class Singer implements ISinger {
	public void sing() {
		System.out.println("Singer:唱一首歌");
	}
}