package com.learn.failfast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TestMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put(i + "", i + "");
		}

		for (int i = 0; i < 10; i++) {
			if (i == 3) {
				map.remove(3 + "");
			}
		}
		
		
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		int i = 0;
		while (it.hasNext()) {
			if (i == 3) {
//				map.remove(3 + "");
			}
			Entry<String, String> entry = it.next();
			System.out.println("key= " + entry.getKey() + " and value= "
					+ entry.getValue());
			i++;
		}
	}
}
