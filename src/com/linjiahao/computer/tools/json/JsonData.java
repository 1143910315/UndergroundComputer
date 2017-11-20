/*
 * Copyright (c) 2017年11月20日18时38分20秒 林嘉豪 All rights reserved.
 */
package com.linjiahao.computer.tools.json;
public interface JsonData {
	/**
	 * 推测json数据是数组数据，
	 * @param index
	 * @return
	 */
	public JsonData A(int index);
	public JsonData O(String key);
	public JsonData P();
	public JsonData H();
	public int i();
	public String s();
}
