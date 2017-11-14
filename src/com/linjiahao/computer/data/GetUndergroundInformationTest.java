package com.linjiahao.computer.data;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
@RunWith(value = Parameterized.class)
public class GetUndergroundInformationTest {
	private String from;
	private String to;
	private String expected;
	private GetUndergroundInformation getUndergroundInformation;
	@Test
	public void getMoney() throws Exception {
		int times = 0;
		while (times < 5 && !getUndergroundInformation.connection()) {
			times++;
		}
		Assert.assertTrue(times < 5);
		Assert.assertEquals(from + "到" + to, expected, String.valueOf(getUndergroundInformation.getMoney()));
	}
	@Parameters
	public static Collection<String[]> getParams() {
		return Arrays.asList(new String[][]{
				{"西朗", "坑口", "2"},
				{"体育西路", "大石", "5"},
				{"虫雷 岗", "龙洞", "8"},
				{"广州南站", "万胜围", "6"},
				{"小北", "万胜围", "5"},
				{"海珠广场", "高塘石", "6"}
		});
	}
	public GetUndergroundInformationTest(String from, String to, String expected) throws UnsupportedEncodingException {
		this.from = from;
		this.to = to;
		this.expected = expected;
		getUndergroundInformation = new GetUndergroundInformation(from, to);
	}
}
