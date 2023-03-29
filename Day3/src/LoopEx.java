import java.util.Scanner;

public class LoopEx {

	public static void main(String[] args) {

		/*
		 * # 반복문 for
		 * 1. 반복문의 조건 3가지
		 * 1) 초기식
		 * 2) 조건식
		 * 3) 증감식
		 * 2. for문의 구조
		 * for(초기식;조건식;증감식){
		 * 		조건식이 참일 동안 실행할 문장;
		 * }
		 * 3. for문의 실행순서
		 * 초기식 → 조건식 → 실행문 → 증감식 → 조건식 → 실행문 → 증감식 ...
		 */
		
		
		//1부터 10까지 반복해 3 미만 7 이상 출력
		//for()
			
		//1부터 100까지 반복 홀수와 짝수의 합을 각각 출력
//		int jjak = 0; //짝수 합
//		int hol = 0;  //홀수 합
//		
//		for(int i = 0; i < 5; i++) {
//			
//			if(i % 2 == 0) {
//				//짝수
//				jjak += i;
//			}
//			
//			hol += i; 			//꼭 else는 안 써도 되니깐
//
//		}
			
			
			
			
			
			
			
			
			
			//1. 5회 반복을 하면서 정수를 입력 받는다.
			//2. 입력받은 정수를 전부 합을 출력한다.
			//3. 만약에 입력 받은 합이 100 이상이면 반복이 5회가
			//		아닐지라도 즉시 종료
			//여기에 쓰면 생존시간 다름. main의 끝에서 끝남.
			//int sum1 = 0; <이거  여기서 선언했으면 아래 초기식에 안 써도 됨.
			//혹은 초기화 잘 해야 함.
//			Scanner sc = new Scanner(System.in);
//			int total = 0; //누적합
//			
//			//무한for(;;){}
//			for(int i = 0; i < 5; i++) {
//				
//				System.out.println("정수>");
//				int num = sc.nextInt();
//				
//				total += num;
//				
//				if(total >= 100) {
//					break;
//				}
//			}
			
			//if문으로 먼저 풀고 혹시 switch문 바꿔서 작성
			//월 입력 받으면 3~5월까지는 봄. 출력
			//6~8월 여름. 9~11가을. 12~2월 겨울.
			//결과를 저장해서 println()은 딱 한 번만 쓰기
			//무한으로 입력 받다가 99 입력하면 프로그램 종료!
			//단! 1~12월 외 숫자 입력하면 "월을 잘못 입력했습니다." 99제외.
			
//			Scanner sc = new Scanner(System.in);
//			
//			System.out.println("월 입력> ");
//			int x = sc.nextInt();
//			
//			for(;;) {
//				if(x >= 3 && x <= 5) {
//						System.out.println("봄");
//					}else if(x >= 6 && x <= 8) {
//						System.out.println("여름");
//					}else if(x >= 9 && x <= 11){
//						System.out.println("가을");
//					}else if(x <= 2 || x == 12 ){
//						System.out.println("겨울");
//					}else {
//						System.out.println("잘못 입력하셨습니다.");
//					}
//			

			//switch버전
			switch(month2) {
				case 12, 1, 2:
					season2 = "겨울";
					break;
				
			}

	}}
