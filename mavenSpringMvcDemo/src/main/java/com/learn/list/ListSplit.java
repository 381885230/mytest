package com.learn.list;

import java.util.ArrayList;
import java.util.List;

public class ListSplit {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < 520; i++) {
			list.add(i);
		}
		ListSplit.test1(list);
	}

	public static void test1(List<Object> dataList) {
		int batchsize = 50;
		List<Object> newList = new ArrayList<Object>();
		for (int i = 0; i < dataList.size(); i++) {// 分批次处理
			newList.add(dataList.get(i));

			if (batchsize == newList.size() || i == dataList.size() - 1) {

				printList(newList);
				newList.clear();
				System.out.println("");
				System.out.println("=====");

			}
		}
	}

	public static void printList(List<Object> dataList) {
		for (Object str : dataList) {
			System.out.print(str + " -- ");
		}
	}
}