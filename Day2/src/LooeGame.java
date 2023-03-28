import java.util.Random;
import java.util.Scanner;

public class LooeGame {

	public static void main(String[] args) {

		
		/*업앤다운 게임[2단계]
		 * 1. com은 랜덤으로 1~100사이를 저장한다.
		 * 2. me는 1~100사이를 입력한다.
		 * 3. com과 me를 비교해 com 크면 "크다", com이 작으면 "작다" 힌트제공
		 * 4. 정답을 맞추면 게임은 종료.
		 * 단! 100점 틀릴 때마다 5점 감소! 0이 되면 게임종료
		 * 
		 * 정수 무한적으로 입력 받다가 -100을 입력하면 프로그램 종료!
		 */
		int num = 0;
		
		do {
			 int num = sc.nextInt();
			 System.out.println();
		}while(num != -100);
			//do, while 차이. 무조건 하냐 물어보고 하냐?
		
		
		while(true) {
			 int num = sc.nextInt();
			 System.out.println();
			 if(num == -100) break
		 }
		for(초기식; 조건식; 증감식은 ;없어도됨)
		for(int num = 0; num != -100;)
		 
		 
		 /*
		 * 횟수값 입력 받아서 횟수만큼 이름 출력하기
		 * 예: 횟수 3
		 * 강준희
		 * 강준희
		 * 강준희
		 */
			
			int com = r.nextInt(100) + 1;
			int score = 100;
			int me = 0;
			
						//&&둘 다 참이어야 함. 겜 멈춰야 되니까 ||로 하면 ㄴㄴ
			while(com == me && score == 0) {
				System.out.println("1~100 사이의 숫자를 입력하쇼");
				me = sc.nextInt();
				if(com == me) {
					System.out.println("정답");
				}else {
					score -= 5;
					if(me > com)
					{
				}
			}
			
			
			
			
			
			
			
			
			
		Random uad = new Random();
		System.out.println(uad.nextInt(100) + 1);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정답:");
		int num = sc.nextInt();
		
		if()
	}

}
