package Sort;

import java.util.Scanner;

public class RecursionMain {

	public static void Function(int num) throws StackOverflowError {
		System.out.println("반갑습니다.");

		if (num == 0) {
			return;
		}

		// 자기 자신 안에서 자기를 다시 부름
		Function(num - 1);
	}

	// 1부터 5까지 합을 구하는 재귀함수를 작성
	public static int Function2(int num) {

		if (num == 1) {// 함수가 끝나면 마지막 1도 더해야 된다.
			return 1;
		}

		return num + Function2(num - 1);
	}
	public static int factorial(int n) {
		if(n <= 1) return 1;
		return n*factorial(n-1);
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		in.close();//이렇게 닫을 수도 있다. 사용 끝나면
		//단! 함부로 사용하면 뒤에 입력을 받을 때 문제가
		//생기니 close() 가장 나중에 하기! 
		
		
		// 재귀함수
		// - 자기 자신을 다시 호출하여 문제를 해결해 가는 함수
		// StackOverflowError 스택이 넘쳐흐를 수 있다.
		// 끝나는 조건을 잘 주어야 된다.
		// - 새로운 함수를 계속해서 스택에 쌓아간다.
		// 그러다 넘치면 예외가 발생한다.

		try {
			Function(5);
			int res = Function2(5);
			System.out.println(res);
			
			//1+N까지의 합을 구하기!
			//피보나치수열 구하기 백준에 있다.
			
			
		} catch (StackOverflowError e) {
			System.out.println("재귀함수 예외발생 조건작성하기");
		}

	}

}












