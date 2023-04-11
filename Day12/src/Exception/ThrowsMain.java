package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsMain {
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void fn() throws Exception{
		System.out.println("정수1 입력:");
		int num = sc.nextInt();
		System.out.println("정수2 입력:");
		int num2 = sc.nextInt();
		
		System.out.println(num/num2);
	}
	
	
	
	
	public static void main(String[] args) {
		// 호출한 곳으로 예외를 던진다.(양도)
		try {
			fn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//예외를 함수 안에 넣고 반복적으로 호출해 처리하기 보단
		//한 곳에서 처리해 주는 것이 좋다!
	}
}
