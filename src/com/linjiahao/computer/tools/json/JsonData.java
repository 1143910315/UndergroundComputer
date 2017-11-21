/*
 * Copyright (c) 2017年11月20日18时38分20秒 林嘉豪 All rights reserved.
 */
package com.linjiahao.computer.tools.json;
public interface JsonData {
	/**
	 * 推测json数据是数组数据，并取出该索引的数据。该方法不判断json是否有效。
	 * @param index 要取出的数组索引位置。
	 * @return 用于迭代获取数据。
	 */
	public JsonData A(int index);
	/**
	 * 推测json数据是对象数据，并取出该索引的数据。该方法不判断json是否有效。
	 * @param key 要取出的对象的键。
	 * @return 用于迭代获取数据。
	 */
	public JsonData O(String key);
	/**
	 * 返回上一级的数据。
	 * @return 用于迭代获取数据。
	 */
	public JsonData P();
	/**
	 * 返回原始数据。
	 * @return 用于迭代获取数据。
	 */
	public JsonData H();
	/**
	 * 推测该数据为整数数据。
	 * @return 数据的整数。
	 */
	public int i();
	/**
	 * 推测该数据为字符串。
	 * @return 数据的字符串。
	 */
	public String s();
}
