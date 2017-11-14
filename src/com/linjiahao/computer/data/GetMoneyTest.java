package com.linjiahao.computer.data;
import org.junit.Assert;
import org.junit.Test;
public class GetMoneyTest {
	@Test
	public void sendGet() throws Exception {
		Assert.assertEquals("西朗到坑口", 2, GetMoney.sendGet("西朗", "坑口"));
		Assert.assertEquals("体育西路到大石", 5, GetMoney.sendGet("体育西路", "大石"));
		Assert.assertEquals("虫雷 岗到龙洞", 8, GetMoney.sendGet("虫雷 岗", "龙洞"));
		Assert.assertEquals("广州南站到万胜围", 6, GetMoney.sendGet("广州南站", "万胜围"));
	}
}
