package com.linjiahao.computer.data;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class GetMoney {
	/**
	 * 向指定URL发送GET方法的请求
	 *
	 * @return URL 所代表远程资源的响应结果
	 */
	public static int sendGet(String startStation, String endStation) {
		int price = -1;
		InputStreamReader in = null;
		try {
			String encoderStartStation = URLEncoder.encode(startStation, "UTF-8");
			encoderStartStation = URLEncoder.encode(encoderStartStation, "UTF-8");
			String encoderEndStation = URLEncoder.encode(endStation, "UTF-8");
			encoderEndStation = URLEncoder.encode(encoderEndStation, "UTF-8");
			String requestURL =
					String.format("http://cs.gzmtr.com/base/doSearchPathLine.do?startStation=%s&endStation=%s", encoderStartStation, encoderEndStation);
			URL request = new URL(requestURL);
			URLConnection urlConnection = request.openConnection();
			urlConnection.connect();
			in = new InputStreamReader(urlConnection.getInputStream());
			Pattern compile = Pattern.compile("[\\s\\S]*\"price\":([0-9]*),[\\s\\S]*");
			StringBuffer result = new StringBuffer();
			char[] buff = new char[50];
			while (in.read(buff) != -1) {
				result.append(buff);
				Matcher matcher = compile.matcher(result);
				if (matcher.matches()) {
					String stringPrice = matcher.replaceFirst("$1");
					price = Integer.parseInt(stringPrice);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return price;
	}
}
