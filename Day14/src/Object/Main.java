package Object;

import java.util.Scanner;

import String.StringTokenMain;

public class Main{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//회원가입시 qwer 아이디비번 받아서 객체생성.
		//User()
		User a = new User("qwer", "qwer");
		

		//getClass()
		//자신이 속한클래스의 객체를 반환하는 메서드
		//모든 정보를 담고 있는 클래스
		//클래스 당 1개만 존재
		//자바 파일 -> .class -> 객체를 생성할 때 
		
		System.out.println(a.getClass());
		System.out.println(a.getClass().getName());
		
		//자바에서 Reflection API
		//자바에서 타입을 모르더라도 getClass().다양한 기능
		
	}

}
