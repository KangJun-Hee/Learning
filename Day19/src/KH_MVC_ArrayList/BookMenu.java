package KH_MVC_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMenu {
	Scanner sc = new Scanner(System.in);
	BookController bc = new BookController();

	public void mainMenu() {
		System.out.println("== Welcome KH Library ==");
		System.out.println("******* 메인 메뉴 *******");
		System.out.println("1. 새 도서 추가");
		System.out.println("2. 도서 전체 조회");
		System.out.println("3. 도서 검색 조회");
		System.out.println("4. 도서 삭제");
		System.out.println("5. 도서 명 오름차순 정렬");
		System.out.println("9. 종료");

		while (true) {
			int num = sc.nextInt();

			switch (num) {
			case 1: {
				insertBook();
				break;
			}
			case 2: {
				selectList();
				break;
			}
			case 3: {
				searchBook();
				break;
			}
			case 4: {
				deleteBook();
				break;
			}
			case 5: {
				ascBook();
				break;
			}
			case 9: {
				System.out.println("프로그램을 종료합니다.");
				mainMenu();
				return;
			}
			default:
				System.out.println("잘못입력하셨습니드악. 다시 입력~~~~");
			}
		}
	}

	public void insertBook() {
		System.out.println("1. 도서명 입력받기");
		String title = sc.next();
		System.out.println("2. 저자명 입력받기");
		String author = sc.next();

		System.out.println("3. 장르 입력받기");
		while (true) {
			int category = sc.nextInt();
			switch (category) {
			case 1: {
				break;
			}
			case 2: {

				break;
			}
			case 3: {

				break;
			}
			case 4: {

				break;
			}
			default: {
				return;
			}

			}// 스위치
		} // 와일
		System.out.println("4. 가격 입력받기");
		int price = sc.nextInt();
		
		Book b = new Book(title, author, category, price);
		if(b.category == 1) {
		}
		bc.insertBook(b);
	}

	public void selectList() {
		ArrayList<E> res = bc.selectList();
		ArrayList<Book> bookList = res;
		
		if(bookList.isEmpty()) {
			System.out.println("존재하는 도서 없다!!!!!!! 가라!!");
		}else {
			while(true) {
				
			}
		}
	}

	public void searchBook() {
		String keyword = sc.next();
		//값 전달
		bc.searchBook(keyword);
		
		ArrayList<Book>;
		
		if(searchList.isEmpty()) {
			System.out.println("검색결과가 없습니다~~~~~");
		}else {
			
		}
	}

	public void deleteBook() {
		System.out.println("1. 삭제할 도서명");
		String title = sc.next();
		System.out.println("2. 삭제할 저자명");
		String author = sc.next();
		
		bc.deleteBook(title, author);
		
		if()
		
	}

	public void ascBook() {
		bc.ascBook();
		if() {
			System.out.println();
		}else {
			System.out.println();
		}
	}

	
	
	
	
	
	
	
	
}
