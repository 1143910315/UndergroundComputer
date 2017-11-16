package com.linjiahao.computer.data;
import java.io.Serializable;
import java.util.ArrayList;
public class Line implements Serializable {
	private ArrayList<String> lineData = new ArrayList<>();
	private ArrayList<Integer> price=new ArrayList<>();
	protected Line add(String station) {
		lineData.add(station);
		return this;
	}
}
