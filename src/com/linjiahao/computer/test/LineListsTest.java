/*
 * Copyright (c) 2017年11月18日23时53分36秒 林嘉豪 All rights reserved.
 */

package com.linjiahao.computer.test;
import com.linjiahao.computer.data.LineLists;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.util.Arrays;
import java.util.List;
@FixMethodOrder(MethodSorters.JVM)//指定测试方法按定义的顺序执行
public class LineListsTest {
	@Test
	public void testLoadDefault() throws Exception {
		LineLists lineLists = new LineLists();
		lineLists.loadDefault();
		checkData(lineLists);
	}
	@Test
	public void testLoadAndSave() throws Exception {
		File dataFile = new File("data");
		dataFile.deleteOnExit();
		LineLists lineLists = new LineLists();
		lineLists.loadDefault();
		Assert.assertTrue("保存失败！",lineLists.save());
		Assert.assertTrue("读取失败！",lineLists.load());
		checkData(lineLists);

	}
	private void checkData(LineLists lineLists) {
		Assert.assertEquals("路线数不正确！", 14, lineLists.getLineCount());
		List<Integer> list = Arrays.asList(16, 24, 16, 18, 24, 22, 28, 13, 11, 19, 32, 25, 13, 22);
		for (int i = 0; i < lineLists.getLineCount(); i++) {
			Assert.assertEquals("第" + i + "条线的站点总数不对！", list.get(i).intValue(), lineLists.getStationCount(i));
		}
		Assert.assertEquals("站点名不对！", "广州东站", lineLists.getStationName(0, 0));
		Assert.assertEquals("站点名不对！", "三元里", lineLists.getStationName(1, 7));
		Assert.assertEquals("站点名不对！", "珠江新城", lineLists.getStationName(2, 9));
		Assert.assertEquals("站点名不对！", "马鞍山公园站", lineLists.getStationName(8, 6));
		Assert.assertEquals("站点名不对！", "如意坊", lineLists.getStationName(10, 9));
		Assert.assertEquals("站点名不对！", "祖庙", lineLists.getStationName(13, 14));
		Assert.assertEquals("站点名不对！", "新城东", lineLists.getStationName(13, 21));
	}
}
