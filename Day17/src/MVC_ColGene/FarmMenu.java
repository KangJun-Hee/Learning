package MVC_ColGene;

import java.util.Scanner;

import MVC_TreeSet.Lottery;

public class FarmMenu {
	Scanner sc = new Scanner(System.in);
	FarmController fc = new FarmController();

	public void mainMenu() {
		while (true) {
			System.out.println("============KH 마트===========");
			System.out.println("************메인 메뉴***********");
			System.out.println("1. 직원메뉴");
			System.out.println("2. 손님메뉴");
			System.out.println("9. 종료");
			System.out.println("메뉴 번호 선택 :");
			int num = sc.nextInt();

			switch (num) {
			case 1: {
				adminMenu();
				break;
			}
			case 2: {
				customerMenu();
				break;
			}
			case 9: {
				System.out.println("프로그램 종료.");
				mainMenu();
				return;
			}
			default: {
				System.out.println("잘못 입력하였습니다. 다시입력하쇼");
			}
			}
		}

	}

	public void adminMenu() {

		while (true) {
			System.out.println("*******직원 메뉴*******");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			System.out.println("메뉴 번호 선택 :");
			int num = sc.nextInt();

			switch (num) {
			case 1: {
				addNewKind();
				break;
			}
			case 2: {
				removeKind();
				break;
			}
			case 3: {
				changeAmount();
				break;
			}
			case 4: {
				printFarm();
				break;
			}
			case 9: {
				mainMenu();
				return;
			}
			default: {
				System.out.println("잘못 입력하였습니다. 다시입력하쇼");
			}

			}
		}
	}

	public void customerMenu() {
		System.out.println("*******고객 메뉴*******");
		System.out.println("1. 농산물 사기");
		System.out.println("2. 농산물 빼기");
		System.out.println("3. 구입한 농산물 보기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.println("메뉴 번호 선택 :");
		int num = sc.nextInt();

		switch (num) {
		case 1: {
			buyFarm();
			break;
		}
		case 2: {
			removeFarm();
			break;
		}
		case 3: {
			printBuyFarm();
			break;
		}
		case 9: {
			mainMenu();
			return;
		}
		default: {
			System.out.println("잘못 입력하였습니다. 다시입력하쇼");
		}

		}
	}

	public void addNewKind() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		int num = sc.nextInt();

		switch (num) {
		case 1: {
			System.out.println("이름 : ");
			String fn = sc.next();
			System.out.println("수량 : ");
			int fa = sc.nextInt();
			
			fc.addNewKind(fn, fa);
			
			boolean res = fc.addNewKind(temp);			
			break;
		}
		case 2: {
			System.out.println("이름 : ");
			String vn = sc.next();
			System.out.println("수량 : ");
			int va = sc.nextInt();
			
			fc.addNewKind(vn,va);
			
			boolean res = fc.addNewKind(temp);			
			break;
		}
		case 3: {
			System.out.println("이름 : ");
			String nn = sc.next();
			System.out.println("수량 : ");
			int na = sc.nextInt();
			
			fc.addNewKind(nn, na);
			
			boolean res = fc.addNewKind(temp);			
			break;
		}
		default: {
			System.out.println("잘못 입력하였습니다. 다시입력하쇼");
		}

		}
	}

}

	}

	public void removeKind() {
	}

	public void changeAmount() {
	}

	public void printFarm() {
		
	}

	public void buyFarm() {
	}

	public void removeFarm() {
	}

	public void printBuyFarm() {
	}

}
