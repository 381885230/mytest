package com.learn.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 添加list的方式
 * @author yuanjin
 * @date 2019年3月4日 下午5:19:09
 */
public class ListAddTest {

	public static void main(String[] args) {

		//生成匿名内部内进行初始化
		ArrayList<String> list = new ArrayList<String>() {
			{
				add("xxxxx");
				add("yyyyyy");
			}
		};
		System.out.println(JSON.toJSONString(list));

		//Arrays.asList
		ArrayList<String> obj = new ArrayList<String>(Arrays.asList("11", "44", "33", "22"));
		System.out.println(JSON.toJSONString(obj));

		//常规方式
		ArrayList<String> obj2 = new ArrayList<String>();
		List list2 = Arrays.asList("111", "444", "333", "222");
		obj2.addAll(list2);
		
		System.out.println(JSON.toJSONString(obj2));
		
		//Collections.ncopies
		ArrayList<String> obj3 = new ArrayList<String>(Collections.nCopies(4,"666"));//把element复制count次填入ArrayList中
		System.out.println(JSON.toJSONString(obj3));
		
	}

}
