
public class LoopEx01 {

	public static void main(String[] args) {

		/*
		 * 반복문
		 * while(조건문){
		 * 	참인동안 반복하는 문장
		 * }
		 * 
		 * for
		 * 
		 */
		
		//1~10까지 반복해 5~9만 출력
		//시작 : 1
		//조건 : 1~5까지 반복
		//증감 : 1씩
		// \t tap만큼
		// \n 줄바꿈
		
		//printf("%숫자d") 오른쪽다섯칸떼고정렬
		
		/*
		 * int i = 1; while( i <= 10) { 
		 * System.out.println(i + "\t"); 
		 * i +=1; 
		 * }
		 */
		
		
		
		
		
		/*
		 * int start = 1;
		 * 
		 * while(start <= 5) {// start < 6, start != 6 
		 * System.out.println(start); 
		 * start
		 * = start + 1; }
		 */
		
		
		//문제2) 10~1 반복해 6~3 거꾸로 출력
		int start = 10;
		
		while(start >= 1) {
			if(start >= 3 && start <= 6) {
				System.out.println(start);
			}
			start -= 10; // start -= 1; 
		}
		
		
		
		
		
		
		
		
		
		
	}

}
