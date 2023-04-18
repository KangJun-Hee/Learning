package MVC_TreeSet;

import java.util.Scanner;

public class LotteryMenu {
	Scanner sc = new Scanner(System.in);
	LotteryController lc = new LotteryController();
	
	public void mainMenu() {
		System.out.println("=============KH 추첨 프로그램=============");
		System.out.println("*******메인 메뉴*******");
		System.out.println("1. 추첨 대상 추가");
		System.out.println("2. 추첨 대상 삭제");
		System.out.println("3. 다첨 대상 확인");
		System.out.println("4. 정렬된 당첨 대상 확인");
		System.out.println("5. 당첨 대상 검색");
		System.out.println("9. 종료");
		System.out.println("메뉴 번호 선택 : >>");
		int num = sc.nextInt();
		
		while(equals(9)){
			switch (num) {
			case 1: {
				insertObject();
				break;
			}
			case 2: {
				deleteObject();
				break;
			}
			case 3: {
				winObject();
				break;
			}
			case 4: {
				sortedWinObject();
				break;
			}
			case 5: {
				searchWinner();
				break;
			}
			case 9: {
				System.out.println("프로그램 종료!!!!!!");
				mainMenu();
				break;
			}
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력하쇼");
			}
		}
	}
	void insertObject() {
		System.out.println("추첨대상자 수:");
		int num = sc.nextInt();

		System.out.println("추첨자 이름과 핸드폰 번호를 입력해 주세요.");
		String info = sc.next();
		String[] list = info.split(" ");
		
		Lottery temp = new Lottery(list[0], list[1]);
		
		boolean res = lc.insertObject(temp);
		
		if(res) {
			System.out.println("추가 완료되었다");
		}else if(res){
			System.out.println("중복된 대상입니다. 다시 입력하세요.");
			
		}
	}
	void deleteObject() {
		System.out.println("삭제할 대상의 이름, 핸드폰 번호를 입력하세요>");

		String info = sc.next();
		String[] list = info.split(" ");
		
		Lottery temp = new Lottery(list[0], list[1]);
		
		boolean res = lc.insertObject(temp);
		
		if(res) {
			System.out.println("삭제 완료되었다");
		}else{
			System.out.println("존재하지 않는 대상입니다.");
			
		}
	}
	void winObject() {
		System.out.println();
	}
	void sortedWinObject() {
		
	}
	void searchWinner() {
		System.out.println("이름, 핸드폰 번호를 입력하세요>");
		String info = sc.next();
		String[] list = info.split(" ");
		
		Lottery temp = new Lottery(list[0], list[1]);
		
		boolean res = lc.insertObject(temp);
		
		if(res) {
			System.out.println("삭제 완료되었다");
		}else{
			System.out.println("존재하지 않는 대상입니다.");
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
