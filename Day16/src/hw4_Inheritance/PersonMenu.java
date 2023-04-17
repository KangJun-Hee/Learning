package hw4_Inheritance;

import java.io.FileWriter;
import java.util.Scanner;

public class PersonMenu {
	Scanner sc = new Scanner(System.in);
	PersonController pc = new PersonController();
	
	//field
	public void mainMenu() {
		String M = null;
		String N = null;
		System.out.println("학생은 최대 3명까지 저장 가능합니다. \n"
				+ "현재 저장된 학생은"+M+"명입니다.\n"
				+"사원은 최대 10명까지 저장할 수 있습니다. \n"
				+"현재 저장된 사원은"+N+"명입니다. \n"
				);
		System.out.println("1. 학생 메뉴 2. 사원 메뉴 9. 끝내기"
				+ "\n 메뉴 번호:");
		int mn = sc.nextInt();
		
		
		
		
		switch (mn) {
		case 1:
			studentMenu();
			break;
		case 2:
			employeeMenu();
			break;

		case 9:
			System.out.println("종료합니다.");
			break;
		
		default :
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			int mn2 = sc.nextInt();
		}
		
	}
	public void studentMenu() {
		System.out.println("1. 학생 추가 2. 학생 보기 9. 메인으로"
				+ "\n 메뉴 번호:");
		int smn = sc.nextInt();
		
		switch (smn) {
		case 1:
			insertStudent();
			break;
		case 2:
			printStudent();
			break;

		case 9:
			System.out.println("메인으로 돌아가겠다!!!!");
			mainMenu();
			break;
		
		default :
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			int smn2 = sc.nextInt();
		}
		
	}
	void employeeMenu() {System.out.println("1. 사원 추가 2. 사원 보기 9. 메인으로"
			+ "\n 메뉴 번호:");
	
	
	
	int emn = sc.nextInt();
	
	switch (emn) {
	case 1:
		insertEmployee();
		break;
	case 2:
		printEmployee();
		break;

	case 9:
		System.out.println("메인으로 돌아가겠다!!!! \n");
		mainMenu();
		break;
	
	default :
		System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		int smn2 = sc.nextInt();
	}

}
	void insertStudent() {
		String[] stu = new String[6];
		String[] stu2 = new String[6];
		String[] stu3 = new String[6];
		
		int size = stu.length;
		for(int i=0; i<size ; i++) {
		System.out.println("학생 이름: \n"
				+ "학생 전공:");
		String nam = sc.next();
		String maj = sc.next();
		System.out.println("학생 나이: \n"
				+ "학생 학년:");
		int age = sc.nextInt();
		int name = sc.nextInt();
		System.out.println("학생 키: \n"
				+ "학생 몸무게:");
		double hei = sc.nextDouble();
		double wei = sc.nextDouble();
		
		System.out.println("그만 하시려면 N(또는 n), 이어서 하시려면 아무 키나 누르쇼");
		String r = sc.next();
		if(r=="N" || r=="n") {
			System.out.println("학생 담을 수 있는 공간 꽉차서 학생추가 종료하고 학생메뉴로 돌아감.");
		}studentMenu();
		}
}
	void printStudent() {
		
		System.out.println();
	}
	void insertEmployee() {
		System.out.println("사원 이름: \n"
				+ "사원 부서:");
		String nam = sc.next();
		String maj = sc.next();
		System.out.println("사원 나이: \n"
				+ "사원 급여:");
		int age = sc.nextInt();
		int sal = sc.nextInt();
		System.out.println("사원 키: \n"
				+ "사원 몸무게:");
		double hei = sc.nextDouble();
		double wei = sc.nextDouble();
		
		System.out.println("그만 하시려면 N(또는 n), 이어서 하시려면 아무 키나 누르쇼");
		String r = sc.next();
		if(r=="N" || r=="n") {
			System.out.println("사원 담을 수 있는 공간 꽉차서 학생추가 종료하고 학생메뉴로 돌아감.");
		}employeeMenu();

	}
	void printEmployee() {
		System.out.println();
	}
}
