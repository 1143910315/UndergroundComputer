package com.linjiahao.computer.test;
import com.linjiahao.computer.data.GetUndergroundInformation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@RunWith(value = Parameterized.class)
public class GetUndergroundInformationTest {
	private String from;
	private String to;
	private int expected;
	private List<String> stationName;
	private GetUndergroundInformation getUndergroundInformation;
	@Test
	public void getMoney() throws Exception {
		int times = 0;
		while (times < 5 && !getUndergroundInformation.connection()) {
			times++;
		}
		Assert.assertTrue("数据请求失败！", times < 5);
		Assert.assertEquals(from + "到" + to + "的票价不一致！", expected, getUndergroundInformation.getMoney());
		ArrayList<String> stationNameData = getUndergroundInformation.getStationName();
		Assert.assertEquals("换乘站数不一致！", stationName.size(), stationNameData.size());
		for (int i = 0; i < stationName.size(); i++) {
			Assert.assertEquals("第" + (i + 1) + "个站不正确！", stationName.get(i), stationNameData.get(i));
		}
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
		this.expected = (int) expected;
		this.stationName = (List<String>) stationName;
		getUndergroundInformation = new GetUndergroundInformation(this.from, this.to);
	}
}
