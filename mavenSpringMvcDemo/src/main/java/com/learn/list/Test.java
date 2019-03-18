package com.learn.list;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		doTest();
	}

	private static void doTest() {
		List<String> dataList = new ArrayList<>();
		dataList.add("11");
		dataList.add("22");
		dataList.add("33");
		dataList.add("44");
		dataList.add("55");
		dataList.add("66");
		dataList.add("77");
		dataList.add("88");
		dataList.add("99");

		listExcute(dataList);

	}

	private static void listExcute(List<String> dataList) {
		if (null != dataList && dataList.size() > 0) {
			int batchsize = 2;// 限制条数,【修改这里】
			Integer size = dataList.size();
			if (batchsize < size) {// 判断是否有必要分批
				int part = size / batchsize;// 分批数
				System.out.println("共有 ： " + size + "条，！" + " 分为 ：" + part + "批");
				for (int i = 0; i < part; i++) {
					List<String> listPage = dataList.subList(0, batchsize);
					System.out.println("第" + (i + 1) + "次,执行处理:" + listPage);
					dataList.subList(0, batchsize).clear();
				}
				if (!dataList.isEmpty()) {
					System.out.println("最后一批数据,执行处理:" + dataList);// 表示最后剩下的数据
				}
			} else {
				System.out.println("不需要分批,执行处理:" + dataList);
			}
		} else {
			System.out.println("没有数据!!!");
		}
	}
}