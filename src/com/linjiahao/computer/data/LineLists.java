package com.linjiahao.computer.data;
import java.io.*;
import java.util.ArrayList;
public class LineLists {
	private ArrayList<Line> line = new ArrayList<>();
	public boolean load() {
		File dataFile = new File("data");
		if (dataFile.isDirectory()) {
			line.clear();
			int i = 0;
			File data = new File(dataFile, "line" + i++ + ".dat");
			while (data.isFile()) {
				FileInputStream fileInputStream = null;
				ObjectInputStream objectInputStream = null;
				try {
					fileInputStream = new FileInputStream(data);
					objectInputStream = new ObjectInputStream(fileInputStream);
					line.add((Line) objectInputStream.readObject());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (objectInputStream != null) {
						try {
							objectInputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fileInputStream != null) {
						try {
							fileInputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				data = new File(dataFile, "line" + i++ + ".dat");
			}
			return true;
		}
		return false;
	}
	public boolean save() {
		File dataFile = new File("data");
		if (!dataFile.isDirectory()) {
			if (!dataFile.mkdir()) {
				return false;
			}
		}
		for (int i = 0; i < line.size(); i++) {
			File data = new File(dataFile, "line" + i + ".dat");
			FileOutputStream fileOutputStream = null;
			ObjectOutputStream objectOutputStream = null;
			try {
				fileOutputStream = new FileOutputStream(data);
				objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(line.get(i));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (objectOutputStream != null) {
					try {
						objectOutputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fileOutputStream != null) {
					try {
						fileOutputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return true;
	}
	public void loadDefault() {
		line.clear();
		line.add(new Line().add("广州东站").add("体育中心").add("体育西路").add("杨箕").add("东山口").add("烈士陵园").add("农讲所").add("公园前")
				.add("西门口").add("陈家祠").add("长寿路").add("黄沙").add("芳村").add("花地湾").add("坑口").add("西朗"));
		line.add(new Line().add("嘉禾望岗").add("黄边").add("江夏").add("萧岗").add("白云文化广场").add("白云公园").add("飞翔公园").add("三元里")
				.add("广州火车站").add("越秀公园").add("纪念堂").add("公园前").add("海珠广场").add("市二宫").add("江南西").add("昌岗").add("江泰路")
				.add("东晓南").add("南洲").add("洛溪").add("南浦").add("会江").add("石壁").add("广州南站"));
		line.add(new Line().add("番禺广场").add("市桥").add("汉溪长隆").add("大石").add("厦滘").add("沥滘").add("大塘").add("客村")
				.add("广州塔").add("珠江新城").add("体育西路").add("石牌桥").add("岗顶").add("华师").add("五山").add("天河客运站"));
		line.add(new Line().add("黄村").add("车陂").add("车陂南").add("万胜围").add("官洲").add("大学城北").add("大学城南").add("新造")
				.add("官桥").add("石碁").add("海傍").add("低涌").add("东涌").add("庆盛").add("黄阁汽车城").add("黄阁").add("蕉门")
				.add("金洲"));
		line.add(new Line().add("文冲").add("大沙东").add("大沙地").add("鱼珠").add("三溪").add("东圃").add("车陂南").add("科韵路")
				.add("员村").add("潭村").add("猎德").add("珠江新城").add("五羊邨").add("杨箕").add("动物园").add("区庄").add("淘金").add("小北")
				.add("广州火车站").add("西村").add("西场").add("中山八").add("坦尾").add("滘口"));
		line.add(new Line().add("浔峰岗").add("横沙").add("沙贝").add("河沙").add("坦尾").add("如意坊").add("黄沙").add("文化公园")
				.add("一德路").add("海珠广场").add("北京路").add("团一大广场").add("东湖").add("东山口").add("区庄").add("黄花岗").add("沙河顶")
				.add("沙河").add("天平架").add("燕塘").add("天河客运站").add("长湴"));
		line.add(new Line().add("美的大道站").add("北滘新城站").add("林头站").add("南涌站").add("陈村新城站").add("陈村站").add("陈村北站")
				.add("韦涌站").add("广州南站").add("石壁").add("谢村").add("钟村").add("汉溪长隆").add("南村万博").add("员岗").add("板桥")
				.add("大学城南").add("深井站").add("长洲站").add("洪圣沙站").add("裕丰围站").add("大沙东站").add("姬堂站").add("加庄站").add("科丰路站")
				.add("萝岗站").add("水西站").add("水西北站"));
		line.add(new Line().add("凤凰新村").add("沙园").add("宝岗大道").add("昌岗").add("晓港").add("中大").add("鹭江").add("客村")
				.add("赤岗").add("磨碟沙").add("新港东").add("琶洲").add("万胜围"));
		line.add(new Line().add("飞鹅岭站").add("花都汽车城站").add("广州北站").add("花城路站").add("花果山公园站").add("花都广场站").add("马鞍山公园站")
				.add("莲塘站").add("清布站").add("清塘站").add("高增站"));
		line.add(new Line().add("西朗").add("广钢新城").add("东沙").add("大干围").add("石溪").add("东晓南").add("五凤").add("中大南门")
				.add("滨江东路").add("东湖").add("署前路").add("寺右新马路").add("广州大道中").add("天河路").add("石牌桥").add("岗顶").add("华师")
				.add("五山").add("天河客运站"));
		line.add(new Line().add("田心村").add("云台花园").add("大金钟").add("广园新村").add("梓元岗").add("广州火车站").add("流花路").add("彩虹桥")
				.add("中山八").add("如意坊").add("石围塘").add("芳村").add("芳村大道东").add("沙涌").add("鹤洞东").add("南石路").add("燕岗")
				.add("江泰路").add("轻纺城").add("逸景路").add("上涌公园").add("大塘").add("石榴岗").add("赤沙滘").add("琶洲").add("员村")
				.add("天河公园").add("华景路").add("华师").add("天河东").add("广州东站").add("沙河"));
		line.add(new Line().add("浔峰岗").add("里横路").add("槎头").add("聚龙").add("棠溪").add("南航新村").add("新市墟").add("白云文化广场")
				.add("云溪公园").add("小金钟").add("景云路").add("广园新村").add("恒福路").add("建设六马路").add("烈士陵园").add("东湖").add("二沙岛")
				.add("岭南广场").add("赤岗").add("赤沙").add("赤沙滘").add("仑头").add("官洲").add("大学城北").add("大学城南"));
		line.add(new Line().add("体育西路").add("林和西").add("广州东站").add("燕塘").add("梅花园").add("京溪南方医院").add("同和").add("永泰")
				.add("白云大道北").add("嘉禾望岗").add("龙归").add("人和").add("机场南"));
		line.add(new Line().add("燕岗").add("沙园").add("沙涌").add("鹤洞").add("西朗").add("菊树").add("龙溪").add("金融高新区")
				.add("千灯湖").add("虫雷 岗").add("南桂路").add("桂城").add("朝安").add("普君北路").add("祖庙").add("同济路").add("季华园")
				.add("魁奇路").add("澜石").add("世纪莲").add("东平").add("新城东"));
	}
	public String getStationName(int lineIndex, int stationIndex) {
		return line.get(lineIndex).getStationName(stationIndex);
	}
	public int getLineCount() {
		return line.size();
	}
	public int getStationCount(int lineIndex) {
		return line.get(lineIndex).size();
	}
}


