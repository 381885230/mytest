package com.learn.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/**
 * JSON字符串自动转换
 */
public class TestJsonToMap {

	public static void main(String[] args) {

		String str = "{\"0\":\"张三\",\"1\":\"李四\",\"2\":\"王五\",\"3\":\"马六\"}";
		// 第一种方式
		Map maps = (Map) JSON.parse(str);
		System.out.println("第1种方式：这个是用JSON类来解析JSON字符串!!!");
		for (Object map : maps.entrySet()) {
			System.out.println(((Map.Entry) map).getKey() + " "+ ((Map.Entry) map).getValue());
		}

		// 第二种方式
		Map mapTypes = JSON.parseObject(str);
		System.out.println("第1种方式：这个是用JSON类的parseObject来解析JSON字符串!!!");
		for (Object obj : mapTypes.keySet()) {
			System.out.println("key为：" + obj + "值为：" + mapTypes.get(obj));
		}

		// 第三种方式
		Map mapType = JSON.parseObject(str, Map.class);
		System.out.println("第3种方式：这个是用JSON类,指定解析类型来解析JSON字符串!!!");
		for (Object obj : mapType.keySet()) {
			System.out.println("key为：" + obj + "值为：" + mapType.get(obj));
		}

		// 第四种方式
		/**
		 * JSONObject是Map接口的一个实现类
		 */
		Map json = (Map) JSONObject.parse(str);
		System.out.println("第4种方式：这个是用JSONObject类的parse方法来解析JSON字符串!!!");
		for (Object map : json.entrySet()) {
			System.out.println(((Map.Entry) map).getKey() + "  "+ ((Map.Entry) map).getValue());
		}

		// 第五种方式
		/**
		 * JSONObject是Map接口的一个实现类
		 */
		JSONObject jsonObject = JSONObject.parseObject(str);
		System.out.println("第5种方式：这个是用JSONObject的parseObject方法来解析JSON字符串!!!");
		for (Object map : json.entrySet()) {
			System.out.println(((Map.Entry) map).getKey() + "  "+ ((Map.Entry) map).getValue());
		}

		// 第六种方式
		/**
		 * JSONObject是Map接口的一个实现类
		 */
		System.out.println("第6种方式：这个是用JSONObject的parseObject方法并执行返回类型来解析JSON字符串!!!");
		for (Object map : json.entrySet()) {
			System.out.println(((Map.Entry) map).getKey() + "  "+ ((Map.Entry) map).getValue());
		}
		System.out.println(json);
	}
}