package control;

import java.util.Scanner;

public class Up_Down_game {

	public static void main(String[] args) {

		try (/*
				 * #Up Down 게임
				 * 1. com은 8이다.
				 * 2. me 는 숫자를 하나 입력 받는다.
				 * 3. com과 me를 비교해서 다음과 같은 메세지를 출력한다.
				 * me < com : up!
				 * me == com: bingo!
				 * me > com : down!
				 */
		Scanner sc = new Scanner(System.in)) {
			int com = 8;
			System.out.println("숫자>");
			int me = sc.nextInt();
			
			//여러개의 경우를 선택하는 if문
			//if (비교문) 작성 가능.
			//else (비교문)작성 불가능.
			if(me < com) {
				System.out.println("Up!");
			}else if(me == com) {
				System.out.println("Bingo!");
			}else {
				System.out.println("Down!");
			}
		}
		
		/*나이를 Scanner 입력 받아서
		 * 나이가 20세 미만 "소아청소년"
		 * 		20세 이상 "성인"
		 * 
		 * 입력 받고 20세 미만 "할인율 10% 입니다"출력
		 * 			30세 미만 "할인율 20% 입니다"
		 * 			39세 이상 " 할인율 5% 입니다" 
		 */
		
		int age = 18;
		
		if(age < 20) {
			System.out.println("할인율 10%입니다.");
		}else if(age < 30) {
			System.out.println("할인율 20%입니다.");
		}else if(age >= 39){
			System.out.println("할인율 5%입니다.");
			
			
		}
		/*
		 * 놀이기구 이용제한
		 * 1. 키를 입력받는다.
		 * 2. 키가 120 이상, 이용가능.
		 * 3. 		미만, 이용할 수 없다.
		 * 4. 단, 부모님과 함꼐 왔으면 이용가능.
		 * 		예)함께 오셨나요? (네:1, 아뇨:0)
		 * 		1번 누르면 "부모님과 동반탑승 가능"
		 * 		2번 누르면 "
		 */
		int h = 153;
		
		if(h >= 120) {
			System.out.println("탑승가능합니다.");
		} else {
			System.out.println("이용불가능합니다.");
		}
		
		/*
		 * 구구단 게임
		 * 1. 구구단 문제 출제 위해, 숫자 2개 입력받는다.
		 * 2. 입력 받은 숫자 토대로 구구단 문제출력.
		 * 		예) 3 X 7 = ?
		 * 3. 문제에 해당하는 정답 입력받는다.
		 * 4. 정답 비교 "정답" 또는 "땡"을 출력.
		 * 
		 */
		int num1 = 1;
		int num2 = 5;
		
		System.out.println("1 X 5 = ?");
		
		/*
		 * 국어수학영어 3개를 받아서 평균
		 * 평균이 90점 이상인 경우
		 * 국수영 모두 90점 이상 "최우수상"출력
		 * 하나라도 90 미만이면 "우수상"출력
		 * 
		 * 평균이 80점이상 89점 이하인 경우
		 *	국수영 3개 중 하나라도 90점 이상이면 "장려상"
		 * 
		 * 평균 80미만 "안녕"
		 * 
		 */
		int kor = 90;
		int mat = 99;
		int eng = 98;
		
		int avg = ((kor+mat+eng)/3);
		
		if(avg >= 90) {
			if(int ) {
				
			}
		}else if()
	}

}
