/*
 * Copyright (c) 2017年11月21日21时47分01秒 林嘉豪 All rights reserved.
 */
package com.linjiahao.computer.tools.example.json;
import com.linjiahao.computer.tools.json.JsonDecode;
import org.junit.Assert;
import org.junit.Test;
public class JsonDecodeExample {
	@Test
	public void simpleArrayJsonDecode() throws Exception {
		JsonDecode jsonDecode = new JsonDecode("[1,  \r\n\n\r \n\t 2   ,3]");
		Assert.assertEquals("解析后的数字不对！",2,jsonDecode.A(1).i());
	}
	@Test
	public void chaosArrayJsonDecode() throws Exception {
		JsonDecode jsonDecode = new JsonDecode("[1,  {1,2,[5{1,2},6]}2   ,3]");
		Assert.assertEquals("解析后的字符串不对！","  {1,2,[5{1,2},6]}2   ",jsonDecode.A(1).s());
		 jsonDecode = new JsonDecode("[1,  [1,2,[3,4]]   ,3]");
		Assert.assertEquals("解析后的字符串不对！","  [1,2,[3,4]]   ",jsonDecode.A(1).s());
		jsonDecode = new JsonDecode("[1,  [1,2,\"[[[\"]   ,3]");
		Assert.assertEquals("解析后的字符串不对！","  [1,2,\"[[[\"]   ",jsonDecode.A(1).s());
		jsonDecode = new JsonDecode("[1,  [1,2,{{{{{]   ,3]");
		Assert.assertEquals("解析后的字符串不对！","  [1,2,{{{{{]   ",jsonDecode.A(1).s());
		jsonDecode = new JsonDecode("[1,  [1,2,{{{{{]   ,3]");
		Assert.assertEquals("解析后的字符串不对！","{{{{{",jsonDecode.A(1).A(2).s());
		jsonDecode = new JsonDecode("[1,  \",,,\"   ,3]");
		Assert.assertEquals("解析后的字符串不对！","  \",,,\"   ",jsonDecode.A(1).s());
	}
}
