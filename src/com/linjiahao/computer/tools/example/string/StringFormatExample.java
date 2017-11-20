/*
 * Copyright (c) 2017年11月20日14时18分52秒 林嘉豪 All rights reserved.
 */
package com.linjiahao.computer.tools.example.string;
import com.linjiahao.computer.tools.string.StringFormat;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
public class StringFormatExample {
	@Test
	public void simpleStringFormat() throws Exception {
		StringFormat stringFormat = new StringFormat("我的名字是：%name%\n我的年龄是：%age%");
		stringFormat.replaceValue("name","林嘉豪");
		stringFormat.replaceValue("age",20);
		String result = stringFormat.toString();
		Assert.assertEquals("格式化字符串失败！","我的名字是：林嘉豪\n我的年龄是：20",result);
		System.out.println(result);
	}
	@Test
	public void mapStringFormat() throws Exception {
		HashMap<Object,Object> hashMap=new HashMap<>();
		hashMap.put("name","林嘉豪");
		hashMap.put("age",20);
		StringFormat stringFormat = new StringFormat("我的名字是：%name%\n我的年龄是：%age%");
		stringFormat.replaceValue(hashMap);
		String result = stringFormat.toString();
		Assert.assertEquals("格式化字符串失败！","我的名字是：林嘉豪\n我的年龄是：20",result);
		System.out.println(result);
	}
	@Test
	public void fullStringFormat() throws  Exception{
		StringFormat stringFormat = new StringFormat("我的名字是：{name}\n我的年龄是：{age}");
		stringFormat.setSign("{","}");
		stringFormat.replaceValue("name","林嘉豪");
		stringFormat.replaceValue("age",20);
		String result = stringFormat.toString();
		Assert.assertEquals("格式化字符串失败！","我的名字是：林嘉豪\n我的年龄是：20",result);
		System.out.println(result);
	}
	@Test
	public void fullStringFormat2() throws  Exception{
		StringFormat stringFormat = new StringFormat("我的名字是：{{name}}\n我的年龄是：||age||");
		stringFormat.setBeforeSign("{{");
		stringFormat.setAfterSign("}}");
		stringFormat.replaceValue("name","林嘉豪");
		stringFormat.setBeforeSign("||");
		stringFormat.setAfterSign("||");
		stringFormat.replaceValue("age",20);
		String result = stringFormat.toString();
		Assert.assertEquals("格式化字符串失败！","我的名字是：林嘉豪\n我的年龄是：20",result);
		System.out.println(result);
	}

}
