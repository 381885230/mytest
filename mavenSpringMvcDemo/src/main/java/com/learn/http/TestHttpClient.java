package com.learn.http;

public class TestHttpClient {

	public static void main(String[] args) {
		String url = "https://www.baidu.com/";
		String result = HttpClientUtil.get(url);
		System.out.println(result);
	}
}
