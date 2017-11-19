/*
 * Copyright (c) 2017年11月19日21时37分29秒 林嘉豪 All rights reserved.
 */
package com.linjiahao.computer.codetest;
import org.junit.Test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CodeTest {
	@Test
	public void testGroup() throws Exception {
		final String stationName = "[\\s\\S]*?\"stationName\":\"([\\s\\S]*?)\"";
		String origin =
				"null({\"count\":16,\"spendTime\":\"40\",\"lines\":[{\"lineName\":\"六号线\",\"stationName\":\"海珠广场\",\"stationCode\":\"610\"},{\"stationName\":\"高塘石\",\"stationCode\":\"626\"}],\"price\":6,\"stations\":[{\"endtime\":\"23:55\",\"linecode\":\"2\",\"starttime\":\"6:19\",\"endstage\":\"广州南站\",\"lineid\":\"2\",\"startstage\":\"海珠广场\",\"sgk\":\"211\"},{\"endtime\":\"23:55\",\"linecode\":\"2\",\"starttime\":\"6:18\",\"endstage\":\"嘉禾望岗\",\"lineid\":\"2\",\"startstage\":\"海珠广场\",\"sgk\":\"211\"},{\"endtime\":\"23:38\",\"linecode\":\"10\",\"starttime\":\"6:07\",\"endstage\":\"浔峰岗\",\"lineid\":\"6\",\"startstage\":\"海珠广场\",\"sgk\":\"211\"},{\"endtime\":\"23:08\",\"linecode\":\"10\",\"starttime\":\"6:14\",\"endstage\":\"香雪\",\"lineid\":\"6\",\"startstage\":\"海珠广场\",\"sgk\":\"211\"}]})\",\"lineid\":\"6";
		Pattern compile = Pattern.compile(stationName);
		Matcher matcher = compile.matcher(origin);
		while (matcher.find()) {
			System.out.println(matcher.group(1));
		}
	}
	@Test
	public void getRuntimePath() throws Exception {
		File file = new File("");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile());
		File file1 = new File("data");
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getAbsoluteFile());
	}
}
