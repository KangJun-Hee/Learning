package Exception_NumRange;

import java.util.Scanner;

public class NumberMenu {
	public static Scanner sc = new Scanner(System.in);
	
	public static void menu() throws Exception{
		System.out.println("정수1 입력:");
		int num = sc.nextInt();
		System.out.println("정수2 입력:");
		int num2 = sc.nextInt();
		
		checkDouble()
		System.out.println();
	}
	public static void main(String[] args) {
		try {
			menu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
