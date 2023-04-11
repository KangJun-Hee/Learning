package Exception_Account;

import java.util.Scanner;

public class AccountManagerMain {
	
	public static void main(String[] args) {
		
		//private 멤버변수
		//상속 X -> 부모한테 초기화하라고 해야함
		//
		
		Scanner sc = new Scanner(System.in);
		System.out.println("계좌번호");
		int no = sc.nextInt();
		System.out.println("비밀번호");
		int pw = sc.nextInt();
		
		try {
			check(no);
			
		}catch(NumberFormatException e) {
			System.out.println("비밀번호가 맞지 않습니다."+e);
		}
		
		
		//check():계좌번호랑 비밀번호를 입력받는다.
				//			계좌등록시 입력한 비밀번호,현재입력비번 비교
				//			맞으면 출금함수 호출
				//			예외적 상황이 발생한다. "비번이 맞지 않습니다. 확인하세"
}
}
