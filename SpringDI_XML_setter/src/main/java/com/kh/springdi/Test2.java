package com.kh.springdi;

public class Test2 {
	private Test22 obj;
	
	public Test2(Test22 obj) {
		this.obj = obj;
	}
	
	public void setData(Test22 obj) {
		this.obj = obj;
	}
	
	public void print() {
		obj.print();
	}
}
