package Exception;

import java.io.IOException;
import java.util.Scanner;

public class ThrowMain {
	public static void check(int num) throws NumberFormatException {
		if(num<0) {
			throw new NumberFormatException("0보다 작습니다.");
		}else {
			System.out.println(num);
		}
	}
	public static void main(String[] args) {
	
		//예외를 일부러 발생시키는 경우
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자:");
		int num = sc.nextInt();
		
		try {
		check(num);
		}catch(NumberFormatException e) {
			System.out.println("예외발생:"+e);
		}
		System.out.println("");
		
		
}
}
