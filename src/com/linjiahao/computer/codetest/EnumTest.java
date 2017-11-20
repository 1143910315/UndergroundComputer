/*
 * Copyright (c) 2017年11月20日11时18分55秒 林嘉豪 All rights reserved.
 */
package com.linjiahao.computer.codetest;
enum Grade {
	A(5){
		public void setI(int i) {
			this.i = i;
		}
	}, b() {

		public void setI(int i) {
			this.i = i;
		}
	};
	public int i;
	Grade() {
		i=0;
	}
	Grade(int i) {
		this.i=i;
	}
	public int getI(){return i;}
	public abstract void setI(int i);
}
class EnumTest {
	private int i;
	EnumTest(Grade grade) {
		this.i=grade.getI();
		grade.setI(i);
	}
	int getI(){
		return i;
	}
}
