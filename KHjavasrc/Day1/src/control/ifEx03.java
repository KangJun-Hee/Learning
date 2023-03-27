package control;

import java.util.Scanner;

public class ifEx03 {

	public static void main(String[] args) {

		//성적 60 이상 = 합격
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수>");
		int score = sc.nextInt();
		
		//비교를 했을 때 결과. 참과 거짓이 나오는 연산자
		if(score >= 60) {// 조건이 참 true
			//만약 참이라면
			System.out.println("합격~");
		}
		if(score < 60) {
			System.out.println("불합격");
		}
		
		
		/*
		 * 로그인
		 * 1. 아이디 비번 입력받는다.(정수 4자리)
		 * 2. 입력받은 데이터와 db데이터 비교해 로그인 진행
		 * 예) 로그인 성공 or 실패
		 * 
		 */
		
		//기존 아이디, 비번
		int id = 1111;
		int pw = 2222;
		
		//현재 로그인하는 아이디, 비번 저장(스캐너 안 쓰고)
		int now_id = 1111;
		int now_pw = 2222;
		
		//1. 아이디부터 ㅣㅂ교
		//		아이디 맞으면 "아이디는 맞습니다."
		//			다르면 "아이디가 다릅니다."
		//2. 비번 비교. 맞으면 "로그인 성공"
		//		틀리면 "아이디 또는 비밀번호를 확인"
		//논리연산자 
		if(id == now_id && pw == now_pw) {
				System.out.println("로그인 성공!");
			}else {
				System.out.println("아이디 또는 비밀번호 확인");
		}
	}

}
