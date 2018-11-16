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
	 * 转换为'KAV'列表
	 * 
	 * @return List<Kav>
	 */
	public static List<Kv> toKavs() {
		List<Kv> l_kavs = new ArrayList<Kv>();
		RoleType[] enums = RoleType.values();
		for (int i = 0; i < enums.length; i++) {
			Kv kav = new Kv();
			kav.setKey(enums[i].getKey().toString());
			kav.setValue(enums[i].getValue());
			l_kavs.add(kav);
		}
		return l_kavs;
	}
}