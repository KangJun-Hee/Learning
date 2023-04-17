package Generics;

import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

//	사용자가 직접 메인 메뉴를 선택 할 수 있음. 
//	종료 전까지 반복 실행. 각 메뉴를 누를 시 해당 메소드로 이동.
	void mainMenu() {

		while (true) {

			System.out.println("=======KH 사이트=======");

			System.out.println("*******메인 메뉴*********");

			// joinMembership() 실행
			System.out.println("1. 회원 가입 ");
			System.out.println("2. 로그인"); // login()실행 후 memberMenu() 실행
			System.out.println("3. 같은 이름 회원 찾기"); // sameName()
			System.out.println("9. 종료!"); // 프로그램 종료 후 main()

			// next() 공백 허용X
			// nextLine() 공백을 허용한다.
			// 엔터처리!

			System.out.print(">");
			int key = sc.nextInt(); // 10 엔터
			sc.nextLine(); // 기존 버퍼의 엔터를 지운다.

			switch (key) {
			case 1: {
				joinMembership();
				break;
			}
			case 2: {
				login();
				memberMenu();
				break;
			}case 3:{
				changName();
				break;
			}			
			
			case 9: {
				System.out.println("프로그램 종료!");
				return;
			}
			default:
				System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요");
			}
		}

	}

	void memberMenu() {

		while (true) {
			System.out.println("*******회원 메뉴*********");

			// joinMembership() 실행
			System.out.println("1. 비밀번호 바꾸기 ");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃");

			System.out.println("메뉴 선택:");
			int sel = sc.nextInt();

			sc.nextLine();
			switch (sel) {
			case 1: {
				changPassword();
				break;
			}
			case 2: {
				changName();
				break;
			}
			case 3: {
				System.out.println("로그아웃");
				return;
			}
			default:
				System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요");
			}
		}
	}

	void joinMembership() {
		// 컨트롤러는 저장 하고 true false
		System.out.print("id>");
		
		String str = sc.nextLine();
		String[] list = str.split(" ");

		Member temp = new Member(list[0], list[1]);

		// 실제 컨트롤러에 저장하는 내용
		boolean res = mc.joinMembership(list[0], temp);

		if (res) {
			System.out.println("가입 완료되었습니다.");
		} else {
			System.out.println("가입 완료되지 않았습니다.");
		}
	} // mainMenu() 로 돌아간다.

	void login() {
		System.out.println("id pw >");
		String[] str = sc.nextLine().split(" ");
		
		String str2 = mc.loing(str[0], str[1]);
		System.out.println(str2);
		
	}

	void changPassword() {
				
		System.out.println("id>");
		String id = sc.nextLine();
		
		System.out.println("new >");
		String newpw = sc.nextLine();
		
		System.out.println("old>");
		String oldpw = sc.nextLine();
			
		boolean res = mc.changPassword(id, oldpw, newpw);
		if(res) {
			System.out.println("변경 완료");
		}else {
			System.out.println("아이디랑 비밀번화 확인하기");
		}
	}

	void changName() {
		//1. map에서 찾을 수있는 내용은 id  
		//2. 그 안에 있는 name 입력 
		// 3. 변경이 잘 됬다면 boolean 값 받기 
		System.out.println("id>");
		String id = sc.nextLine();
		
		System.out.println("name >");
		String name = sc.nextLine();
		
		// 컨트롤러야~ 일 해라! 이름 수정해라!
		mc.changName(id, name);
	
	}

	void sameName() {

		System.out.println("name >");
		String name = sc.nextLine();
		
		TreeMap<String, Member> list = mc.sameName(name);
		System.out.println(list);
	}
}
