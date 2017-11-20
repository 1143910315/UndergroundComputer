/*
 * Copyright (c) 2017年11月20日14时18分52秒 林嘉豪 All rights reserved.
 */
package com.linjiahao.computer.tools.string;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringFormat {
	//private String pendingString;
	private StringBuffer pendingString = new StringBuffer();
	private String beforeSign = "%";
	private String afterSign = "%";
	public StringFormat(String pendingString) {
		this.pendingString.append(pendingString);
	}
	/**
	 * 设置键值前标志
	 *
	 * @param beforeSign 如果不调用此方法或者参数null，则用“%”作为开头
	 */
	public void setBeforeSign(String beforeSign) {
		this.beforeSign = beforeSign == null ? "%" : beforeSign;
	}
	/**
	 * 设置键值后标志
	 *
	 * @param afterSign 如果不调用此方法或者参数null，则用“%”作为结尾
	 */
	public void setAfterSign(String afterSign) {
		this.afterSign = afterSign == null ? "%" : afterSign;
	}
	/**
	 * 设置键值后标志
	 *
	 * @param beforeSign 如果不调用此方法或者参数null，则用“%”作为开头
	 * @param afterSign  如果不调用此方法或者参数null，则用“%”作为结尾
	 */
	public void setSign(String beforeSign, String afterSign) {
		setBeforeSign(beforeSign);
		setAfterSign(afterSign);
	}
	/**
	 * 将字符串的所有beforeSign + keyName + afterSign替换为为value
	 *
	 * @param keyName 被替换关键字
	 * @param value   替换的值
	 */
	public void replaceValue(String keyName, String value) {
		String replace = beforeSign + keyName + afterSign;
		int index = pendingString.indexOf(replace);
		if (index != -1) {
			pendingString.replace(index, index + replace.length(), value);
		}
	}
	/**
	 * 将字符串的所有beforeSign + K + afterSign替换为为V
	 *
	 * @param map 用Map替换文本里的键和值
	 */
	public void replaceValue( Map map) {
		for (Object k : map.keySet()){
			replaceValue(k.toString(),map.get(k).toString());
		}
	}
	/**
	 * 将字符串的所有beforeSign + keyName + afterSign替换为为value.toString()
	 *
	 * @param keyName 被替换关键字
	 * @param value   替换的值
	 */
	public void replaceValue(String keyName, Object value) {
		replaceValue(keyName, value.toString());
	}
	@Override
	public String toString() {
		return pendingString.toString();
	}
}
