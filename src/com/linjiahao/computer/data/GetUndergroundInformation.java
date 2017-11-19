/*
 * Copyright (c) 2017年11月19日22时00分08秒 林嘉豪 All rights reserved.
 */

package com.linjiahao.computer.data;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class GetUndergroundInformation {
	private String startStation;
	private String endStation;
	private ArrayList<String> stationName = null;
	private int price = -1;
	public GetUndergroundInformation(String startStation, String endStation) throws UnsupportedEncodingException {
		this.startStation = URLEncoder.encode(URLEncoder.encode(startStation, "UTF-8"), "UTF-8");
		this.endStation = URLEncoder.encode(URLEncoder.encode(endStation, "UTF-8"), "UTF-8");
	}
	public boolean connection() {
		InputStreamReader in = getInputStreamReader();
		if (in == null) {
			return false;
		}
		StringBuffer result = new StringBuffer();
		char[] buff = new char[50];
		try {
			while (in.read(buff) != -1) {
				result.append(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return analysis(result);
	}
	private InputStreamReader getInputStreamReader() {
		try {
			String originalRequestURL = "http://cs.gzmtr.com/base/doSearchPathLine.do?startStation=%s&endStation=%s";
			String requestURL = String.format(originalRequestURL, startStation, endStation);
			URL request = new URL(requestURL);
			HttpURLConnection urlConnection = (HttpURLConnection) request.openConnection();
			urlConnection.connect();
			if (urlConnection.getResponseCode() == 200) {
				return new InputStreamReader(urlConnection.getInputStream());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	private boolean analysis(CharSequence result) {
		try {
			//经过车站
			final String stationNameRegex = "[\\s\\S]*?\"stationName\":\"([\\s\\S]*?)\"";
			Pattern compile = Pattern.compile(stationNameRegex);
			Matcher matcher = compile.matcher(result);
			if (stationName != null) {
				stationName.clear();
			} else {
				stationName = new ArrayList<>();
			}
			while (matcher.find()) {
				stationName.add(matcher.group(1));
			}
			//票价
			final String priceRegex = "[\\s\\S]*\"price\":([0-9]*)[\\s\\S]*";
			Matcher priceMatcher = Pattern.compile(priceRegex).matcher(result);
			if (priceMatcher.matches()) {
				String stringPrice = priceMatcher.replaceFirst("$1");
				price = Integer.parseInt(stringPrice);
			}
			return true;
		} catch (Exception e) {
			stationName = null;
			price = -1;
			e.printStackTrace();
			return false;
		}
	}
	public int getMoney() {
		return price;
	}
	public ArrayList<String> getStationName() {
		return stationName;
	}
}
