import java.util.Scanner;

public class InputEx {

	public static void main(String[] args) {

		//int num = 10;
		Scanner sc = new Scanner(System.in);
		
		//정수 두 개 입력 받아서 합 출력
		int a = 2;
		int b = 3;
		System.out.println(a + b);
		//성적 입력 받아서 60점 이상 100점 이하면 true, false. if 사용금지
	
		//비교연산자 <= >=
		// 집중!!          == 같냐          !!집중
		// != 다르냐
		
		//논리연산자
		//and && 비교연산자 두 개 이상 <모두> 참일 때
		//ex) 티켓(날짜, 좌석 등)
		
		//or || 비교연산자 두 개 이상 중 <하나만> 참
		//ex) 할인카드
		
		//증감연산자
		//	무조건 1 밖에 증가or감소함.
		//++, --
		// ++변수 = 먼저 증가하고 다음에 실행
		// 변수++ = 실행하고 다 끝나고 다음에 증가
		
		//복합연산자
		//A += B
		//A = A + B
		
		//조건연산자 (삼항연산자)
		// 비교문 ? 참인경우(앞) : 거짓인경우(뒤에);
		
		boolean res = (10 == 10) ? true : false;
	}

}
