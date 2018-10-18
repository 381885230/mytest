package com.learn.restTemplate;

import org.springframework.web.client.RestTemplate;

import scala.util.parsing.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		RestTemplate restTemplate=new RestTemplate();
		//get json数据
		JSONObject json = restTemplate.getForEntity("http://www.baidu.com", JSONObject.class).getBody();
		System.out.println(json);
		
	}

}
