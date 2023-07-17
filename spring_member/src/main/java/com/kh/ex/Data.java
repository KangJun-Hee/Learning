package com.kh.ex;

public class Data {
	private int n1;
	private int n2;
	
	public Data() {}
		
	public Data(int n1, int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	@Override
	public String toString() {
		return "Data [n1=" + n1 + ", n2=" + n2 + "]";
	}
	
}
