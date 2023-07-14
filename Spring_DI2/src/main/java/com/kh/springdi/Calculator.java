package com.kh.springdi;

public class Calculator {
	public void add(int firstNum, int seconNum) {
		System.out.println("add()실행됩니다~");
		int result = firstNum + seconNum;
		System.out.println(firstNum + "+" + seconNum + "=" + result);
	}

	public void sub(int firstNum, int seconNum) {
		System.out.println("sub()실행됩니다~");

		int result = firstNum - seconNum;
		System.out.println(firstNum + "-" + seconNum + "=" + result);
	}

	public void mul(int firstNum, int seconNum) {
		System.out.println("mul()실행됩니다~");

		int result = firstNum * seconNum;
		System.out.println(firstNum + "*" + seconNum + "=" + result);
	}

	public void div(int firstNum, int seconNum) {
		System.out.println("div()실행됩니다~");

		int result = firstNum / seconNum;
		System.out.println(firstNum + "/" + seconNum + "=" + result);
	}
}
