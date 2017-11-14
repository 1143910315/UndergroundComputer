package com.linjiahao.computer.data;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Line {
    private ArrayList<String> lineData=new ArrayList<>();
    protected Line add(String station){
        lineData.add(station);
        return this;
    }
}
