/*
 * Copyright (c) 2017年11月19日22时35分11秒 林嘉豪 All rights reserved.
 */
package com.linjiahao.computer.data;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class GetUndergroundMileage {
	//地图搜索区域
	private final int leftX;
	private final int topY;
	private final int rightX;
	private final int bottomY;
	public GetUndergroundMileage() {
		bottomY = 2648588;
		rightX = 12629675;
		topY = 2629107;
		leftX = 12598697;
	}
	public GetUndergroundMileage(int leftX, int topY, int rightX, int bottomY) {
		this.leftX = leftX;
		this.topY = topY;
		this.rightX = rightX;
		this.bottomY = bottomY;
	}
	public void search(String stationName) {
		try {
			stationName = URLEncoder.encode(stationName, "UTF-8");
			String address =
					String.format("http://map.baidu.com/su?wd=%s&cid=257&type=0&b=(%d%%2C%d%%3B%d%%2C%d)&pc_ver=2", stationName, leftX, topY, rightX, bottomY);
			URL url = new URL(address);
			InputStreamReader inputStreamReader = getBufferedInputStream(url);
			if (inputStreamReader != null) {
				try {
					StringBuffer stringBuffer = new StringBuffer();
					char[] c = new char[50];
					while (inputStreamReader.read(c) != -1) {
						stringBuffer.append(c);
					}
					String pid = splitPID(stringBuffer);
				}finally {
					inputStreamReader.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private InputStreamReader getBufferedInputStream(URL url) {
		try {
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			if (httpURLConnection.getResponseCode() == 200) {
				return new InputStreamReader(httpURLConnection.getInputStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private String splitPID(CharSequence result) {
		try {
			//提取第一个地点的唯一标志
			final String stationPID = "$$[\\s\\S]*?$[\\s\\S]*?$([\\s\\S]*?)$";
			Pattern compile = Pattern.compile(stationPID);
			Matcher matcher = compile.matcher(result);
			if (matcher.find()) {
				return matcher.group(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private int splitDistance(){
	String requestAddress="http://map.baidu.com/?qt=bt&sn=0$$%s$$%d,%d$$%s$$$$$$&en=0$$%s$$%d,%d$$%s$$$$$$";
	String realAddress= String.format(requestAddress,"" );
	return -1;
	}
}
