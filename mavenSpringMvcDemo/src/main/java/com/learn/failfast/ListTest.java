package com.learn.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		// test1();

		test2();
	}

	private static void test2() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i + "");
		}
		Iterator<String> iterator = list.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			if (i == 3) {
				iterator.remove(); // 迭代器的remove()方法
			}
			System.out.println(iterator.next());
			i++;
		}
	}

	private static void test1() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i + "");
		}

		for (int i = 0; i < 10; i++) {
			if (i == 3) {
				list.remove(3);// no exception
			}
		}

		Iterator<String> iterator = list.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			if (i == 3) {
				// list.remove(3);//exception
			}
			System.out.println(iterator.next());
			i++;
		}
	}
}
