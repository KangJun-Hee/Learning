
package control;

public class IfEx {

	public static void main(String[] args) {

		/*
		 * if(비교){
		 * 참인경우 실행
		 * 
		 * }else{
		 * 
		 * 거짓인경우실행
		 * }
		 * 
		 * 
		 * if(비교){
		 * 참인경우 실행
		 * 
		 * }else if{
		 * 참인 경우 실행
		 * }else{
		 * 위의 어떤 것도 해당 안 되면 실행
		 * }
		 * 
		 */
		
		
		// // 문제) 시험점수3개를 입력받고 학점출력 
		Scanner sc = new Scanner(System.in);
		System.out.println("3개의 시험점수 입력하세요.");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();

		int avg = (num1 + num2 + num3) /3;
		
		String res = ""; //결과 저장하는 변수
		if (avg >= 90 && avg <= 100) {
			res = "A";
		}else if(avg >= 80 && avg <=89) {
			res = "B";
		}else if(avg >= 70 && avg <= 79) {
			res = "C";
		}else {
			res = "재시험";
		}
		System.out.println("avg: " + avg);
		System.out.println(res);
		
		//숫자의 자리수를 구한다.
		//327
		System.out.println(327 / 100);
		System.out.println((327 % 100) / 10);
		
		// 일의 자리가 저장
		int s = avg % 10;
		
		if (s >= 7 && avg >= 70) {
			res = res + "+";
		}
		
		System.out.println(res);
		//if
				
				
				
		// 조건 1) 3과목의 평균을 가지고 점수를 매긴다.
		// 조건 2) 3과목의 평균이 100~90 ==> A
		// 조건 3) 3과목의 평균이 89~80 ==> B
		// 조건 4) 3과목의 평균이 79~70 ==> C
		// 조건 5) 69이하                      ==> 재시험 
		// 추가조건) 각점수대별로 끝자리가 7점 이상은 + 가붙는다. 
		// 예) 98 ==> A+
		// 예) 89 ==> B+
		// 예) 79 ==> C+
		int num1 = 30;
		int num2 = 40;
		int num3 = 50;
		
		int ave = ((num1 + num2 + num3)/3);
		
		if() {
			System.out.println('A');
		}else {
			System.out.println('B');
		}
		
		/*A와 B 입력받아서 비교
		 * A > B, >출력
		 * A < B, <출력
		 * B와 같은 경우 '=='출력
		 */
		
		ㅑㅜ
		
		}
	}


