package com.linjiahao.computer.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class GetMoney {
    /*
GET http://cs.gzmtr.com/base/doSearchPathLine.do?startStation=%25E8%25A5%25BF%25E6%259C%2597&endStation=%25E5%259D%2591%25E5%258F%25A3 HTTP/1.1
Host: cs.gzmtr.com

    */
    public static String transform(String source){
        String encode = null;
        try {
             encode = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }
    /**
     * 向指定URL发送GET方法的请求
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String startStation,String endStation) {
        String url= String.format("http://cs.gzmtr.com/base/doSearchPathLine.do?startStation=%s&endStation=%s", GetMoney.transform(GetMoney.transform(startStation)),GetMoney.transform(GetMoney.transform(endStation)));
        String result = "";
        BufferedReader in = null;
        int price=-1;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            return Pattern.compile("[\\s\\S]*\"price\":([0-9]*),[\\s\\S]*").matcher(result).replaceFirst("$1");
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
