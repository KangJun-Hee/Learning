import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Main {

	static void menuGuestInfo(String name, String pn) {
		System.out.println("이름:" + name + " 전화번호:" + pn);
	}

	void menuCartItemList() {
	}

	void menuCartClear() {
	}

	void menuCartAddItem() {
	}

	void menuCartRemoveItemCount() {
	}

	void menuCartRemoveItem() {
	}

	void menuCartBill() {
	}

	void menuExit() {
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("당신의 이름을 입력하세요.");
		String name = sc.next();
		System.out.println("연락처를 입력하세요.");
		String pn = sc.next();

		String greeting = "Welcome to shopping Mall";
		String tagline = "Welcome to Book Market!";

		System.out.println("*********************************************");
		System.out.println("\t" + greeting);
		System.out.println("\t" + tagline);
		System.out.println("*********************************************");
		System.out.println("1. 고객 정보 확인하기");
		System.out.println("2. 장바구니 상품 목록 보기");
		System.out.println("3. 장바구니 비우기");
		System.out.println("4. 바구니에 항목 추가하기");
		System.out.println("5. 장바구니의 항목 수량 줄이기");
		System.out.println("6. 장바구니의 항목 삭제하기");
		System.out.println("7. 영수증 표시하기");
		System.out.println("8. 종료");

		System.out.println("*********************************************");

		int menu = sc.nextInt();
		if (menu < 1 || menu > 8) {
			System.out.println("메뉴번호를 선택하세요");
			System.out.println("1부터 8까지의 숫자를 입력하세요.");
		} else {
			switch (menu) {
			case 1:
				System.out.println("1. 고객 정보 확인하기");
				// System.out.println("이름:"+name+"연락처:"+pn);
				menuGuestInfo(name, pn);
				
				break;

			case 2:
				System.out.println("2. 장바구니 상품 목록 보기");
				
				break;
			case 3:
				System.out.println("3. 장바구니 비우기");
				break;
			case 4:
				System.out.println("4. 바구니에 항목 추가하기");
				break;
			case 5:
				System.out.println("5. 장바구니의 항목 수량 줄이기");
				break;
			case 6:
				System.out.println("6. 장바구니의 항목 삭제하기");
				break;
			case 7:
				System.out.println("7. 영수증 표시하기");
				break;
			case 8:
				System.out.println("8. 종료");
				break;
			}

		}
	}
}
