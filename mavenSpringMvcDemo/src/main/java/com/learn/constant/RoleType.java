package com.learn.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色
* @ClassName: RoleType 
* 角色类型
* @author yuanjin 
*
 */
public enum RoleType {

	normal(1, "普通角色"),
	pcf(2,"PCF角色");

	private Integer key;

	private String value;

	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	private RoleType(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 根据key获取value
	 * 
	 * @param key : 键值key
	 * @return String
	 */
	public static String getValueByKey(Integer key) {
		RoleType[] enums = RoleType.values();
		for (int i = 0; i < enums.length; i++) {
			if (enums[i].getKey().equals(key)) {
				return enums[i].getValue();
			}
		}
		return null;
	}

	/**
	 * 转换为'Kv'列表
	 * 
	 * @return List<Kv>
	 */
	public static List<Kv> toKvs() {
		List<Kv> kvs = new ArrayList<Kv>();
		RoleType[] enums = RoleType.values();
		for (int i = 0; i < enums.length; i++) {
			Kv kv = new Kv();
			kv.setKey(enums[i].getKey().toString());
			kv.setValue(enums[i].getValue());
			kvs.add(kv);
		}
		return kvs;
	}
}