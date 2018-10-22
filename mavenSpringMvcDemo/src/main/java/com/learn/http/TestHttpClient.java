package com.learn.http;

public class TestHttpClient {

	public static void main(String[] args) {
		String url = "http://172.16.21.102:8022/api/cacBeanMall/index.app";
		String result = HttpClientUtil.get(url);
		System.out.println(result);
	}
}
