package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.security.sasl.SaslException;

public class Main {

	public static void main(String[] args) {
		//예외처리
		// - 비정상적인 종료를 막기 위해서! 사용하는 것!
		
		//에러(error) : 개발자가 해결할 수 없는 치명적인 오류
		//예외(exception):개발자가 해결할 수 있는 오류

		//try~catch문
		/*
		 * try{
		 * 		예외가 발생할 수 있는 문장;
 		 * 
		 * }catch(){
		 * 		발생한 예외를 처리하는 문장;
		 * } 
		 * 
		 */
		//두 수를 받아서 나누는 프로그램
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("정수1 입력:");
			int num = sc.nextInt();
			System.out.println("정수2 입력:");
			int num2 = sc.nextInt();
			
			System.out.println(num/num2);
			
//			int[] arr = new int[2];
//			System.out.println(arr[2]);
			
			//여러개의 예외가 발생할 경우
			//Exception 클래스를 이용해서 업캐스팅
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}System.out.println("정상종료!");
	}
}

// Compile Error: 컴파일 시점에서 발생하는 에러로
// 소스코드를 컴파일러가 컴파일하는 시점에서
// 소스의 오타나 잘못된 구문, 자료형 체크등 검사를 수행하는데
// 여기서 발생하는 에러를 컴파일 에러라 하며 이 시점에서 발생하는
// 문제들을 수정 후 컴파일을 성공적으로 마칠경우
// 클래스 파일(*.class) 파일이 생성된다.
//		Runtime Error: 프로그램 실행 시점에서 발생하는 에러로
// 컴파일러는 컴파일 시점에서 문법 오류나 오타같은
// 컴파일시점에서 예측가능한 오류는 잡아줄 수 있지만,
// 실행 중 발생할 수 있는 잠재적인 에러까지 잡을 순 없다.
//		그래서 컴파일은 문제없이 완료되어 프로그램 실행이되고 
// 실행도중 의도치않은 동작에 대처하지못해 에러가 발생할 수 있다.