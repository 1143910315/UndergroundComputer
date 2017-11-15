package com.linjiahao.computer.test;
import com.linjiahao.computer.data.GetUndergroundInformation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@RunWith(value = Parameterized.class)
public class GetUndergroundInformationTest {
	private String from;
	private String to;
	private Integer expected;
	private List<String> stationName;
	private GetUndergroundInformation getUndergroundInformation;
	@Test
	public void getMoney() throws Exception {
		int times = 0;
		while (times < 5 && !getUndergroundInformation.connection()) {
			times++;
		}
		Assert.assertTrue(times < 5);
		Assert.assertEquals(from + "到" + to, expected, Integer.valueOf(getUndergroundInformation.getMoney()));
	}
	@Parameters
	public static Collection<Object[]> getParams() {
		return Arrays.asList(new Object[][]{
				{"西朗", "坑口", 2, Arrays.asList("西朗", "坑口")},
				{"体育西路", "大石", 5, Arrays.asList("体育西路", "大石")},
				{"虫雷 岗", "龙洞", 8, Arrays.asList("虫雷 岗", "西朗", "黄沙", "龙洞")},
				{"广州南站", "万胜围", 6, Arrays.asList("广州南站", "大学城南", "万胜围")},
				{"小北", "万胜围", 5, Arrays.asList("小北", "车陂南", "万胜围")},
				{"海珠广场", "高塘石", 6, Arrays.asList("海珠广场", "高塘石")}
		});
	}
	public GetUndergroundInformationTest(Object from, Object to, Object expected, Object stationName)
			throws UnsupportedEncodingException {
		this.from = (String) from;
		this.to = (String) to;
		this.expected = (Integer) expected;
		this.stationName= (List<String>) stationName;
		getUndergroundInformation = new GetUndergroundInformation(this.from, this.to);
	}
}
