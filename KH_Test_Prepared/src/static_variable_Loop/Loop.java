package static_variable_Loop;

import java.util.Scanner;

public class Loop {


	public static void main(String[] args) {
		//변수
		// - 메모리에 생존시간
		//지역변수: {}사이에 생성되는 변수
		//전역변수: 프로그램 끝날때까지 유지되는 변수
		
		// 중요! static !중요
		//			= 전역변수 단점을 뺀 제어자(공유된다)
		int num1 = 0;
		
		//static int total = 1000;
		//while(num == 0) {}
		Scanner sc = new Scanner(System.in);
		int num = 0;
		double num2 = 0;
		String str= null;
		
		do {
			num = sc.nextInt(); //-10
		}while(num != -100);
	}

}