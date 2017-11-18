package com.linjiahao.computer.data;
import java.io.Serializable;
import java.util.ArrayList;
public class Line implements Serializable {
	private ArrayList<String> lineData = new ArrayList<>();
	private ArrayList<Double> mileage=new ArrayList<>();
	protected Line add(String station) {
		lineData.add(station);
		mileage.add(0.0);
		return this;
	}
	public double getMileage(int index) {
		return mileage.get(index);
	}
	public String getStationName(int stationName){
		return lineData.get(stationName);
	}
	public int size(){
		return lineData.size();
	}
}
